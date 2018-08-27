package FrameWork.helpers;

import FrameWork.listeners.Log;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;

import static FrameWork.helpers.DriverHelper.*;
import static FrameWork.library.Util.fn_TakeSnapshot;
import static FrameWork.library.Util.fn_TakeSnapshot_Extern;
import static FrameWork.library.Util.replacePathSymbol;
import static FrameWork.listeners.PreReq.screenshotsFail;
import static FrameWork.listeners.PreReq.screenshotsPass;

public class ReportHelper {

	public static boolean forceScreenShot = false;
	public static boolean forceScreenShotPass = true;
	public static boolean updateStatusDescDb=false;

public static String Test_remarks="";
	public static ExtentTest genarateLogTestStart(String testMethodName, String description, ExtentReports extentReports) throws Exception {
		ExtentTest extentTest;
		logger.info("extent test " + test + " - test method : " + testMethodName);
		extentTest = extentReports.startTest(testMethodName, description + " - " + testMethodName);
		return extentTest;
	}

	public static void getgenarateLogTestStart() throws Exception {
		//ExtentTest extentTest = null;
		try {
			DriverHelper.test = genarateLogTestStart(DriverHelper.testCaseName, "Test Automation Execution Report ", extent);
			DriverHelper.testWithout = genarateLogTestStart(DriverHelper.testCaseName, "Test Automation Execution Report ", extentWithout);
			if (Helper.hmData != null) {
				System.out.println(Helper.hmData);
				logReportStatusInBlue(LogStatus.INFO, "Running test Class: '" + DriverHelper.testCaseName + "'");
				logReportStatus(LogStatus.INFO, "Initialising the data for the test in a map with Data : " + Helper.hmData);
			} else {
				logReportStatusInBlue(LogStatus.ERROR, "Not able to run test Class: " + DriverHelper.testCaseName + "'");
				logReportStatus(LogStatus.ERROR, "Initialising the data for the test in a map failed : " + Helper.hmData);
			}
		} catch (Exception e) {
			logReportStatus(LogStatus.ERROR, e.getMessage());
		}
	}

	public static void rplog(LogStatus logStatus, String statusDescription, String screenShotPath) {
		if (!screenShotPath.equalsIgnoreCase("NA")) {
			String ssPath = (fn_TakeSnapshot(screenShotPath));
			test.log(logStatus, statusDescription + "<br> Snapshot below : - " + replacePathSymbol(ssPath) + test.addScreenCapture(ssPath));
			testWithout.log(logStatus, statusDescription);
		} else {
			test.log(logStatus, statusDescription);
			testWithout.log(logStatus, statusDescription);
		}

	}



	public static void logReportStatus_external(LogStatus logStatus, String statusDescription, WebDriver driver) {
		String ssPath = screenshotsPass + testCaseName + "_PASS_";

		switch (logStatus) {
			case PASS:
				if (forceScreenShotPass) {
					//ssPath = screenshotsFail + testCaseName + "_PASS_";
					ssPath = screenshotsPass + testCaseName + "_PASS_";

				} else {
					ssPath = "NA";
					forceScreenShotPass = true;
				}
				rplog3(logStatus, "<font style=\"background-color:#009900;\"color=\"White\">" + statusDescription + "</font>", ssPath,driver);
				if(updateStatusDescDb==true){
					Test_remarks=statusDescription;
					updateStatusDescDb=false;}
				break;
			case FAIL:
				ssPath = screenshotsFail + testCaseName + "_FAIL_";
				rplog3(logStatus, "<font style=\"background-color:#ff0000;\"color=\"White\">" + statusDescription + "</font>", ssPath,driver);
				Test_remarks=statusDescription;


				org.testng.Assert.fail("");
				break;
			case FATAL:
				ssPath = screenshotsFail + testCaseName + "_FAIL_";
				rplog3(logStatus, "<font color=\"Red\">" + statusDescription + "</font>", ssPath,driver);
				break;
			case ERROR:
				ssPath = "NA";
				rplog3(logStatus, "<font color=\"Red\">" + statusDescription + "</font>", ssPath,driver);
				Test_remarks=statusDescription;
				break;
			case SKIP:
				ssPath = screenshotsPass + testCaseName + "_PASS_";
				rplog3(logStatus, "<b>" + statusDescription + "</b>", ssPath,driver);
				break;
			case WARNING:
				ssPath = "NA";
				rplog3(logStatus, "<b>" + statusDescription + "</b>", ssPath,driver);
				break;
			case INFO:
				if (forceScreenShot) {
					ssPath = screenshotsPass + testCaseName + "_PASS_";
					forceScreenShot = false;
				} else {
					ssPath = "NA";
				}
				rplog3(logStatus, statusDescription, ssPath,driver);
				Log.info(logStatus + " -> " + statusDescription);
				break;
			default:
				ssPath = screenshotsPass + testCaseName + "_PASS_";
				rplog3(logStatus, "<i>" + statusDescription + "</i>", ssPath,driver);
				break;
		}


		//rplog3(logStatus, "<font style=\"background-color:#009900;\"color=\"White\">" + statusDescription + "</font>", ssPath,driver);
			}
	public static void rplog3(LogStatus logStatus, String statusDescription, String screenShotPath,WebDriver driver) {


		if (!screenShotPath.equalsIgnoreCase("NA")) {
			String ssPath = (fn_TakeSnapshot_Extern(screenShotPath,driver));
			test.log(logStatus, statusDescription + "<br> Snapshot below : - " + replacePathSymbol(ssPath) + test.addScreenCapture(ssPath));
			testWithout.log(logStatus, statusDescription);
		} else {
			test.log(logStatus, statusDescription);
			testWithout.log(logStatus, statusDescription);
		}
	}

	public static void logReportStatusInBlue(LogStatus logStatus, String statusDescription) throws Exception {
		statusDescription = "<p style=\"color:blue;\"><b>" + statusDescription + "</b></p>";
		logReportStatus(logStatus, statusDescription);
	}

	public static void logReportStatus(LogStatus logStatus, String statusDescription)  {
		String ssPath;

		switch (logStatus) {
			case PASS:
				if (forceScreenShotPass) {
					//ssPath = screenshotsFail + testCaseName + "_PASS_";
					ssPath = screenshotsPass + testCaseName + "_PASS_";

				} else {
					ssPath = "NA";
					forceScreenShotPass = true;
				}
				rplog(logStatus, "<font style=\"background-color:#009900;\"color=\"White\">" + statusDescription + "</font>", ssPath);
				if(updateStatusDescDb==true){
				Test_remarks=statusDescription;
				updateStatusDescDb=false;}
				break;
			case FAIL:
				ssPath = screenshotsFail + testCaseName + "_FAIL_";
				rplog(logStatus, "<font style=\"background-color:#ff0000;\"color=\"White\">" + statusDescription + "</font>", ssPath);
				Test_remarks=statusDescription;


				org.testng.Assert.fail("");
				break;
			case FATAL:
				ssPath = screenshotsFail + testCaseName + "_FAIL_";
				rplog(logStatus, "<font color=\"Red\">" + statusDescription + "</font>", ssPath);
				break;
			case ERROR:
				ssPath = "NA";
				rplog(logStatus, "<font color=\"Red\">" + statusDescription + "</font>", ssPath);
				Test_remarks=statusDescription;
				break;
			case SKIP:
				ssPath = screenshotsPass + testCaseName + "_PASS_";
				rplog(logStatus, "<b>" + statusDescription + "</b>", ssPath);
				break;
			case WARNING:
				ssPath = "NA";
				rplog(logStatus, "<b>" + statusDescription + "</b>", ssPath);
				break;
			case INFO:
				if (forceScreenShot) {
					ssPath = screenshotsPass + testCaseName + "_PASS_";
					forceScreenShot = false;
				} else {
					ssPath = "NA";
				}
				rplog(logStatus, statusDescription, ssPath);
				Log.info(logStatus + " -> " + statusDescription);
				break;
			default:
				ssPath = screenshotsPass + testCaseName + "_PASS_";
				rplog(logStatus, "<i>" + statusDescription + "</i>", ssPath);
				break;
		}
	}

	public static void methodInformation() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();


	}
}


