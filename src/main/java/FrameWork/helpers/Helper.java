package FrameWork.helpers;

import FrameWork.listeners.Log;
import FrameWork.listeners.PreReq;
import FrameWork.trigger.TestSuiteCreator;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import static FrameWork.trigger.TestSuiteCreator.ResSuite;


public class Helper {
	public static Connection connection;
	public static Fillo fillo;
	public static HashMap<String, String> hmData = new HashMap<>();
	public static HashMap<String, String> mapper_keyval = new HashMap<>();

	public static String getData(String fieldName) {
		return hmData.get(fieldName).toString();
	}

	public static String[] loginCredentials(String userType) {
		return PreReq.projectConfig.getProperty(userType).toString().split("~");
	}

	public static void test() throws FilloException {
		//HashMap<String, String> hmDataMap = new HashMap<>();

		HashMap<String, String> data_map = new HashMap<>();
		String ResSuite = System.getProperty("ResSuite");
		String filePath = System.getProperty("user.dir") + "\\" + ResSuite + "\\runManager\\RunManager.xlsx";
		System.out.println("---->" + DriverHelper.dataBinding);
		String query = "select TestCaseID from datasheet where dataBinding='" + DriverHelper.dataBinding + "'";
		System.out.println(query);
		Recordset recordset = getDataRecordSet(filePath, query);
		String testcaseid = "";
		while (recordset.next()) {
			testcaseid = recordset.getField("TestCaseID");
		}
		recordset.close();


		Recordset recordset1 = getDataRecordSet(filePath, "select * from Mapping where TestCaseID ='" + testcaseid + "'");


		while (recordset1.next()) {
			mapper_keyval.put(recordset1.getField("Key"), recordset1.getField("Column"));
		}
		recordset1.close();
		String dataquery = "select * from datasheet where dataBinding='" + DriverHelper.dataBinding + "'";
		Recordset resul = getDataRecordSet(filePath, dataquery);

		while (resul.next()) {
			for (Map.Entry<String, String> entry : mapper_keyval.entrySet()) {
				System.out.println(entry.getKey() + "/" + entry.getValue());
				data_map.put(entry.getKey(), resul.getField(entry.getValue()));
			}
		}


		//hmDataMap = getDataMap(resul);

		hmData = data_map;
	}

	/**
	 * The database code has been changed
	 *
	 * @throws FilloException
	 */
	public static void GetDatasource() throws FilloException {
		try {
			HashMap<String, String> hmDataMap = new HashMap<>();
			HashMap<String, String> data_map = new HashMap<>();

			String query = "select TestCaseID from data_" + DriverHelper.dataSheet + " where dataBinding='" + DriverHelper.dataBinding + "'";
			System.out.println(query);
			ResultSet rs = RetrieveData.getDbdata(query);
			String testcaseid = "";
			while (rs.next()) {
				testcaseid = rs.getString("TestCaseID");
			}
			rs.close();

			ResultSet recordset1 = RetrieveData.getDbdata("select * from DataMapping where TestCaseID ='" + testcaseid + "'");

			while (recordset1.next()) {
				mapper_keyval.put(recordset1.getString("Key"), recordset1.getString("Column"));
			}
			recordset1.close();
			String dataquery1 = "select * from  data_" + DriverHelper.dataSheet + " where dataBinding='" + DriverHelper.dataBinding + "'";
			ResultSet resul = RetrieveData.getDbdata(dataquery1);

			while (resul.next()) {
				for (Map.Entry<String, String> entry : mapper_keyval.entrySet()) {
					System.out.println(entry.getKey() + "/" + entry.getValue());

					String val = resul.getString(entry.getValue());
					if (val == null || val.equals("")) {
						val = "";
					}
					data_map.put(entry.getKey(), val);
				}
			}
			//hmDataMap =RetrieveData.getDbdatamapper(dataquery);
			hmData = data_map;
			hmData.put("TestcaseID", testcaseid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void saveTestDataToDb(String Columnname, String Value) {
		if (mapper_keyval != null) {
			for (Map.Entry<String, String> entry : mapper_keyval.entrySet()) {
				System.out.println(entry.getKey() + "/" + entry.getValue());
				if (entry.getKey().equalsIgnoreCase(Columnname)) {
					String query = "update Data_" + DriverHelper.dataSheet + " set " + entry.getValue() + "='" + Value + "' where dataBinding='" + DriverHelper.dataBinding + "'";
					RetrieveData.update(query);
					//break;
				}
			}
			for (Map.Entry<String, String> entry : hmData.entrySet()) {
				String key = entry.getKey();


				if (key.equals(Columnname)) {
					entry.setValue(Value);
				}
				// do something with key and/or tab
			}
		}

	}

	//public String filePath;
	public static String createFile(String fileName) {
		String homeDir = System.getProperty("user.dir") + "\\src\\test\\resources\\Tests.xmlFiles\\";
		String createdFilePath = null;
		boolean flag = false;
		File file = new File(homeDir + fileName);
		if (!file.exists()) {
			try {
				if (file.createNewFile())
					createdFilePath = file.getCanonicalPath();
			} catch (IOException ioe) {
				System.out.println("Error while Creating File in Java" + ioe);
			}
		}
		return createdFilePath;
	}

	public static void getDataResultSet() throws FilloException {

		String testDataFileName = System.getProperty("ResSuite") + "\\" + System.getProperty("ResData");
		String queryTestData = ("select * from " + DriverHelper.dataSheet + " where dataBinding='" + DriverHelper.dataBinding + "'");

		Log.info("testDataFileName - " + testDataFileName);
		Log.info("queryTestData - " + queryTestData);

		Recordset recordset = null;
		HashMap<String, String> hmDataMap = new HashMap<>();
		fillo = new Fillo();
		try {
			connection = fillo.getConnection(testDataFileName);
			recordset = connection.executeQuery(queryTestData);
			hmDataMap = getDataMap(recordset);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			recordset.close();
			connection.close();
		}
		hmData = hmDataMap;
	}

	public static void saveTestData(String ColName, String Data) throws Exception {

		Runtime.getRuntime().exec("cmd /c taskKill /f /im excel.exe");

		String testDataFileName = System.getProperty("ResSuite") + "\\" + System.getProperty("ResData");
		String queryEmptyTestData = ("UPDATE " + DriverHelper.dataSheet + " SET " + ColName
				+ "='' WHERE dataBinding='" + DriverHelper.dataBinding + "'");
		String queryTestData = ("UPDATE " + DriverHelper.dataSheet + " SET " + ColName
				+ "='" + Data + "' WHERE dataBinding='" + DriverHelper.dataBinding + "'");

		Log.info("testDataFileName - " + testDataFileName);
		Log.info("queryTestData - " + queryTestData);

		fillo = new Fillo();
		try {
			connection = fillo.getConnection(testDataFileName);
			connection.executeUpdate(queryEmptyTestData);
			connection.executeUpdate(queryTestData);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		// Update the hmDataMap as per the new set above data
		getDataResultSet();
	}

	public static void saveMasterRunmanger(String ColName, LogStatus logStatus) throws Exception {

		Runtime.getRuntime().exec("cmd /c taskKill /f /im excel.exe");

		String testDataFileName = System.getProperty("user.dir") + "\\" + ResSuite + "\\runManager\\RunManager.xlsx";
		String queryEmptyTestData = ("UPDATE " + "FundTransfer" + " SET  status"
				+ "='' WHERE status='" + DriverHelper.dataBinding + "'");
		String queryTestData = ("UPDATE FundTransfer SET  status='" + logStatus + "' WHERE dataBinding='" + DriverHelper.dataBinding + "'");

		Log.info("testDataFileName - " + testDataFileName);
		Log.info("queryTestData - " + queryTestData);

		fillo = new Fillo();
		try {
			connection = fillo.getConnection(testDataFileName);
			connection.executeUpdate(queryEmptyTestData);
			connection.executeUpdate(queryTestData);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		// Update the hmDataMap as per the new set above data
		getDataResultSet();
	}


	public static Recordset getDataRecordSet(String filepath, String query) throws FilloException {
		Recordset recordset = null;
		HashMap<String, String> hmDataMap = new HashMap<>();
		fillo = new Fillo();
		try {
			connection = fillo.getConnection(filepath);
			recordset = connection.executeQuery(query);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return recordset;
	}

	public static HashMap<String, String> getDataMap(Recordset recordset) throws FilloException {
		HashMap<String, String> hmDataMap = new HashMap<>();
		recordset.moveNext();
		ArrayList<String> columnNames = recordset.getFieldNames();
		for (String str : columnNames) {
			hmDataMap.put(str, recordset.getField(str));


		}
		return hmDataMap;
	}

	public static HashMap<String, String> getDBDataMap(ResultSet resultset) throws FilloException {
		try {


			HashMap<String, String> hmDataMap = new HashMap<>();
			ResultSetMetaData rsMd = resultset.getMetaData();
			int clcount = rsMd.getColumnCount();
			while (resultset.next()) {
				for (int i = 0; i < clcount; i++) {
					hmDataMap.put(rsMd.getColumnName(i), resultset.getString(rsMd.getColumnName(i)));
				}
			}
			return hmDataMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}


	}

	public static XmlSuite getParallelMode(XmlSuite xmlSuite, String str) {
		if (str.toUpperCase().equals("TESTS".toString())) {
			xmlSuite.setParallel(XmlSuite.ParallelMode.TRUE);
		} else if (str.toUpperCase().equals("METHODS".toString())) {
			xmlSuite.setParallel(XmlSuite.ParallelMode.METHODS);
		} else if (str.toUpperCase().equals("CLASSES".toString())) {
			xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
		} else if (str.toUpperCase().equals("INSTANCES".toString())) {
			xmlSuite.setParallel(XmlSuite.ParallelMode.INSTANCES);
		} else {
			xmlSuite.setParallel(XmlSuite.ParallelMode.NONE);
		}
		return xmlSuite;
	}

	public static XmlSuite getSuiteXmlTests(ArrayList<XmlTest> xmlTestList, XmlSuite xmlSuite) {
		//  XmlSuite xmlSuite1=new XmlSuite();
		for (XmlTest xmlTest : xmlTestList)
			xmlSuite.addTest(xmlTest);
		return xmlSuite;
	}

	public static String createSuites(ResultSet recordset,
	                                  String suiteName,
	                                  String xmlName) throws SQLException {
		XmlSuite suite = new XmlSuite();
		ArrayList<XmlTest> alXmlTest = new ArrayList<XmlTest>();
		XmlTest xmlTest = new XmlTest();

		String excludedMethods = "";
		try {
			while (recordset.next()) {
				String includedMethods = "";
				//ArrayList<String> allColumns = recordset.ge();
				// for(String str:allColumns){
				   /* if(str.toString().startsWith("includeMethod")
				            &&str.toUpperCase().contains("includeMethod")){*/
				includedMethods = recordset.getString("TestMethod");
				//  }
				// }
				/*for (String str : allColumns) {
					if (str.toString().startsWith("excludeMethod")
							|| str.toUpperCase().contains("excludeMethod")) {
						excludedMethods = excludedMethods + recordset.getString(str.toString()) + "!:!";
					}
				}*/
				//includedMethods = includedMethods.substring(0, includedMethods.length() - 1).trim();
				String appname = recordset.getString("ApplicationName");
				String testClassName = recordset.getString("TestClassName");
				String listenersClass = "FrameWork.listeners." + recordset.getString("listenersClass");
				String Browser = recordset.getString("WITH") + "!:!" + recordset.getString("ON");
				String dataSheet = "dataSheet" + "!:!" + recordset.getString("ApplicationName");
				//	String dataBinding = "dataBinder" + "!:!" + recordset.getField("dataBinding");
				String environment = "ENV" + "!:!" + recordset.getString("ENV");
				String threadCount = recordset.getString("threadCount");
				String parallel = recordset.getString("parallel");
				String dataproviderthreadcount = recordset.getString("dataproviderthreadcount");
				String TestCaseID = recordset.getString("TestCaseID");
				ArrayList<String> listeners = new ArrayList<>();
				listeners.add(listenersClass);
				suite.setName(suiteName);
				suite.setThreadCount(Integer.valueOf(threadCount));
				//  suite.setDataProviderThreadCount(Integer.valueOf((dataproviderthreadcount)));
				suite = getParallelMode(suite, parallel);
				suite.setVerbose(2);
				suite.setListeners(listeners);

				System.out.println("includedMethods final string : " + includedMethods);

				// adding new
				String query = "select dataBinding from data_" + appname + " where TestCaseID='" + TestCaseID + "' and RunStatus='NEW'";
				ResultSet data_set = RetrieveData.getDbdata(query);

				//Recordset recordset1 = getDataRecordSet(TestSuiteCreator.filePath, query);
				List<String> databinerlist = new ArrayList<String>();
				while (data_set.next()) {
					databinerlist.add(data_set.getString("dataBinding"));
				}



				for (int i = 0; i < databinerlist.size(); i++) {
					/*if (key == 1) {
						String s = formatter.format(i);
						dataBinding1 = arr[0].split("_")[0] + "_" + s;
					}*/

					String dataBinding1 = "dataBinder" + "!:!" + databinerlist.get(i);
					xmlTest = getTest(suite,
							testClassName,
							includedMethods,
							excludedMethods,
							Browser,
							dataSheet,
							dataBinding1,
							environment,
							TestCaseID);
					alXmlTest.add(xmlTest);
				}
			}

			List<XmlTest> disntictList = alXmlTest.stream().distinct().collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			recordset.close();
		}
		return writeTestNGFile(suite, xmlName);
	}

	public static XmlTest getTest(XmlSuite suite, String... strings) {
		List<String> listValue = Arrays.asList(strings);
		String testClassName = listValue.get(0);
		String includedMethods = listValue.get(1);
		String excludedMethods = listValue.get(2);
		String browser = listValue.get(3);
		String dataSheet = listValue.get(4);
		String dataBinding = listValue.get(5);
		String environment = listValue.get(6);
		String TestcaseID = listValue.get(7);
		/*Test tag*/
		XmlTest test1 = new XmlTest(suite);
		HashMap<String, String> hmParam = new HashMap<String, String>();
		hmParam.put(browser.split("!:!")[0], browser.split("!:!")[1]);
		hmParam.put(dataSheet.split("!:!")[0], dataSheet.split("!:!")[1]);
		hmParam.put(dataBinding.split("!:!")[0], dataBinding.split("!:!")[1]);
		hmParam.put(environment.split("!:!")[0], environment.split("!:!")[1]);

		//Setting the xTestNG xml Test name and Parameters
		//test1.setName((testClassName.trim() + "_" + includedMethods.trim() + "(" + dataBinding.split("!:!")[1] + ")").trim());
		test1.setName((TestcaseID.trim() + "_" + includedMethods.trim() + "(" + dataBinding.split("!:!")[1] + ")").trim());
		test1.setParameters(hmParam);
		/*Class tag*/
		List<XmlClass> lstClasses = new ArrayList<XmlClass>();
		XmlClass xmlClass = new XmlClass();
		xmlClass.setName("Tests." + testClassName);
		/*Exclude tag*/
		List<String> lstxmlExclude = new ArrayList<String>();
		for (String str : excludedMethods.split("!:!")) {
			lstxmlExclude.add(str);
		}
		xmlClass.setExcludedMethods(lstxmlExclude);
		/*Include tag*/
		List<XmlInclude> lstxmlInclude = new ArrayList<XmlInclude>();
		XmlInclude xmlInclude = null;
		for (String str : includedMethods.split("!:!")) {
			xmlInclude = new XmlInclude(str);
			lstxmlInclude.add(xmlInclude);
		}
		xmlClass.setIncludedMethods(lstxmlInclude);
		lstClasses.add(xmlClass);
		test1.setClassNames(lstClasses);
		return test1;
	}

	public static String writeTestNGFile(XmlSuite suite, String xmlName) {
		String xmlPath = System.getProperty("user.dir") + "/" + System.getProperty("ResSuite") + "/suites/" + xmlName;
		try {
			FileWriter writer = new FileWriter(new File(xmlPath));
			BufferedWriter bw = new BufferedWriter(writer);
			bw.write(suite.toXml());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xmlPath;
	}

	public static ArrayList<String> getSheetNames(Recordset recordset) {
		ArrayList<String> alSheetNames = new ArrayList<String>();
		try {
			while (recordset.next()) {
				// Run	TestcaseName	username	password	password_Wrong
				String testName = recordset.getField("SheetName");
				alSheetNames.add(testName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			recordset.close();
		}
		return alSheetNames;
	}

	public static String getColumnData(Recordset recordset, String columnName) {
		String testName = "";
		try {
			while (recordset.next()) {
				// Run	TestcaseName	username	password	password_Wrong
				testName = recordset.getField(columnName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testName;
	}

	public static boolean runTestNGMasterSuite(ArrayList<String> xmlSuiteList) {
		TestNG testNG = new TestNG();
	   /* suites.add(System.getProperty("user.dir") + "/target/parallel.xml");*/
		testNG.setTestSuites(xmlSuiteList);


		testNG.run();
		return testNG.hasFailure();
	}
}
