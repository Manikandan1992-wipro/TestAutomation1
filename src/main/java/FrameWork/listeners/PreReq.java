package FrameWork.listeners;

import FrameWork.helpers.ReportHelper;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.text.ParseException;
import java.util.Properties;

import static FrameWork.helpers.DataHelper.getPropConfigValues;
import static FrameWork.library.Util.fn_GetTimeStamp;

public class PreReq {

	public static String fwConfigPropertyFile = null;
	public static String driverFolder = null;
	public static String vbsFilePath = null;
	public static String projectConfigPropertyFile = null;
	public static Properties fwConfig;
	public static Properties projectConfig;
	public static String reportFilenameWithScreenshots;
	public static String reportFilenameWithOutScreenshots;
	public static String baseReport;
	public static String screenshots;
	public static String XMLBasePath;
	public static String XMLRequest;
	public static String XMLResponse;
	public static String screenshotsPass;
	public static String screenshotsFail;
	public static String workingDir = null;
	public static String testData;
	public static String subFolder = null;
	public static String reportsFolder = null;
	public static String RequestXMLPath = null;
	public static String ResponseXMLPath = null;
	public static String loginUserTypeHelper = "";
	public static String  htmlFilepath;	public static String  htmlFilepath1;


	public static String getURL(String environment) {
		String url = projectConfig.getProperty(environment).toString();
		System.out.println(url);
		Log.info("Launching URL for '" + environment + "': " + url);
		try {
			ReportHelper.logReportStatusInBlue(LogStatus.INFO, "Launching URL for '" + environment + "': " + url);
		} catch (Exception e) {

		}

		return url;
	}

	public static String getSoapURL(String appliaction) {
		String url = projectConfig.getProperty(appliaction).toString();
		Log.info("Launching URL for '" + appliaction + "': " + url);
		try {
			ReportHelper.logReportStatusInBlue(LogStatus.INFO, "Launching URL for '" + appliaction + "': " + url);
		} catch (Exception e) {

		}

		return url;
	}


	public static void ReportInitialise() throws Exception {
		workingDir = System.getProperty("user.dir");
		Log.info("workingDir is " + workingDir);
		subFolder = workingDir + "\\src\\main\\resources\\";
		driverFolder = workingDir + "\\src\\main\\resources\\drivers\\";
		Log.info("subFolder is " + subFolder);
		fwConfigPropertyFile = subFolder + "\\properties\\";
		vbsFilePath = subFolder + "\\VBS\\";
		projectConfigPropertyFile = subFolder + "\\properties\\";
		Log.info("workingDir is " + fwConfigPropertyFile);
		reportsFolder = workingDir + "\\Reports\\";//+fn_GetTimeStamp().replace("_","")+"\\";
		Log.info("reportsFolder is " + reportsFolder);
		testData = workingDir + "\\GIB\\testData\\";
		Log.info("Tests.testData is " + testData);
		fwConfig = getPropConfigValues(fwConfigPropertyFile + "fwConfig.properties");
		projectConfig = getPropConfigValues(projectConfigPropertyFile + "projectConfig.properties");

	}

	public static void folderStructureReport(String testSuitename) throws ParseException {
		reportFilenameWithScreenshots = System.getProperty("ResSuite") + "_" + testSuitename + "_" + fn_GetTimeStamp().replace("_", "-");//+"_"+fn_GetTimeStamp().replace("_","");
		reportFilenameWithOutScreenshots = System.getProperty("ResSuite") + "_" + testSuitename + "_WithoutScreenshots_" + fn_GetTimeStamp().replace("_", "-");//+"_"+fn_GetTimeStamp().replace("_","");
		baseReport = reportsFolder + reportFilenameWithScreenshots + "\\";


		htmlFilepath1=reportsFolder+reportFilenameWithScreenshots+"/"+reportFilenameWithScreenshots+".html";
		Log.info("reportsFolder is " + baseReport);
		screenshots = baseReport + "Screenshots\\";
		Log.info("reportsFolder is " + screenshots);
		screenshotsPass = screenshots + "\\PASS\\";
		Log.info("reportsFolder is " + screenshotsPass);
		screenshotsFail = screenshots + "\\FAIL\\";
		Log.info("reportsFolder is " + screenshotsFail);
		XMLBasePath = baseReport + "XML\\";
		XMLRequest = XMLBasePath + "Request_XML\\";
		XMLResponse = XMLBasePath + "Response_XML\\";
	}

	public static void createFolders() {
		// Create Reports Folder
		createFolder(reportsFolder);
		// Create screenshots Folder
		createFolder(screenshots);
		// Create screenshotsPass Folder
		createFolder(screenshotsPass);
		// Create screenshotsFail Folder
		createFolder(screenshotsFail);
		createFolder(XMLBasePath);
		createFolder(XMLRequest);
		createFolder(XMLResponse);
	}

	public static void createFolder(String filePath) {
		boolean b = false;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				b = file.mkdirs();
			}
		} catch (Exception e) {
			Log.info("Folder is not Created : " + filePath);

		}
	}

	public static void initialiseFolderProperties(String testCase) throws Exception, ParseException {
		//Initilaise PreReq folders
		ReportInitialise();
		//Intialise the Folder Structure
		folderStructureReport(testCase);
		//Create Folders
		createFolders();
		Log.info("after creating folders  is pass " + screenshotsPass);
		Log.info("after creating folders is fail " + screenshotsFail);
		Log.info("after creating folders is screenshots " + screenshots);
	}
}