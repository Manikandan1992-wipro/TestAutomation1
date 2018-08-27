package FrameWork.trigger;

import FrameWork.helpers.RetrieveData;
import FrameWork.listeners.Log;
import com.codoid.products.fillo.Recordset;

import java.sql.ResultSet;
import java.util.ArrayList;

import static FrameWork.helpers.Helper.*;


public class TestSuiteCreator {

    public static String ResSuite = System.getProperty("ResSuite");
/*	public static String filePath = System.getProperty("user.dir") + "\\" + ResSuite + "\\runManager\\RunManager.xlsx";*/

    public static void main(String[] args) throws Exception {
        //Recordset recordset = null;
        ArrayList<String> xmlSuiteList = new ArrayList<>();

        String testtypee = System.getProperty("TestType");


//get the value form master run to create multiple suite
        String queryDataSheet = ("select * from MasterTestExecutor where Run='YES'");
        System.out.println(queryDataSheet);
        //recordset = getDataRecordSet(filePath, queryDataSheet);
        ResultSet result = RetrieveData.getDbdata(queryDataSheet);

        while (result.next()) {


            String testingtype = result.getString("TestingType");
            String app_name = "";
            app_name = result.getString("ApplicationName");

            String ENV = result.getString("ENV");

            String xmlSuitPath = null;
            if (testingtype.equalsIgnoreCase("Regression")) {

                String query1 = "SELECT A.*,'" + ENV + "' As ENV,B.TestClassName,B.TestMethod,B.listenersClass,B.threadCount,B.parallel,B.dataproviderthreadcount  " +
                        "from TestScript_Manager A,TestScript_Config B where A.Regression='YES' AND A.testcaseid=B.testcaseid AND A.ApplicationName='" + app_name + "'";

                ResultSet rs = RetrieveData.getDbdata(query1);

                xmlSuitPath = createSuites(rs, testingtype, app_name + "_" + testingtype + ".xml");


            } else if (testingtype.equalsIgnoreCase("Smoke")) {
                String query1 = "SELECT A.*,'" + ENV + "' As ENV,B.TestClassName,B.TestMethod,B.listenersClass,B.threadCount,B.parallel,B.dataproviderthreadcount  " +
                        "from TestScript_Manager A,TestScript_Config B where A.Smoke='YES' AND A.testcaseid=B.testcaseid AND A.ApplicationName='" + app_name + "'";

                ResultSet rs = RetrieveData.getDbdata(query1);

                xmlSuitPath = createSuites(rs, testingtype, app_name + "_" + testingtype + ".xml");


            } else if (testingtype.equalsIgnoreCase("Selective_Run")) {


                String query1 = "SELECT A.*,'" + ENV + "' As ENV,B.TestClassName,B.TestMethod,B.listenersClass,B.threadCount,B.parallel,B.dataproviderthreadcount  " +
                        "from TestScript_Manager A,TestScript_Config B where A.run='YES' AND A.testcaseid=B.testcaseid AND A.ApplicationName='" + app_name + "'";

                ResultSet rs = RetrieveData.getDbdata(query1);

                xmlSuitPath = createSuites(rs, testingtype, app_name + "_" + testingtype + ".xml");


            }

            xmlSuiteList.add(xmlSuitPath);
        }

        //System.out.println(recordset.toString());
        //	String xmlSuitPath = createSuites(recordset, testtypee, ResSuite + "_" + testtypee + ".xml");

        runTestNGMasterSuite(xmlSuiteList);
        Log.open_report1();

    }
}

