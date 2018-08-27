package POM.functions;

import FrameWork.helpers.DriverHelper;
import POM.pageobjects.po_GTX;
import POM.pageobjects.po_UBS;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;

public class fn_GTX_login {

	public static void initPageObjects() throws Exception {
		initElements(drvr, po_GTX.class);
		logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		getLatestDriver();
	}
	public static void all_Login_GTX() throws Exception {

		String loginType = DriverHelper.environmentURL;
		//String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
		String application = loginType.split("~")[1];
		String urlType = loginType.split("~")[2];

		fn_allLogin.login_GTX(loginType,application + "~" + urlType);
	}
	public static void search() {
		try {
			waitFor(2000);
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			Actions builder = new Actions(driver);
			builder.moveToElement(po_GTX.GTX_landing_msg_menu).perform();
			waitFor(1000);
			click(po_GTX.GTX_landing_search);
			System.out.println("done!!");
			sendKeys(po_GTX.GTX_TRN_number, getData("UBS_ReferenceNumber"));
			click(po_GTX.GTX_search_btn);


			if (po_GTX.GTX_Type.getText().equals("103")) {
				logReportStatus(LogStatus.PASS, "TRN number Type is validated ");
				if (po_GTX.GTX_status_verify.getText().equalsIgnoreCase("VERIFIED")) {

					logReportStatus(LogStatus.PASS, "TRN number status is verified ");
				} else {
					logReportStatus(LogStatus.FAIL, "TRN Status is not \"verified\" as expected");
				}

			} else {
				logReportStatus(LogStatus.FAIL, "TRN Type is not populated as expected");
			}
		}catch(Exception e)
		{
			logReportStatus(LogStatus.FAIL, "TRN Type is not populated as expected");
		}
	}
	public static void GTX_logout() {
click(po_GTX.GTX_logout);


	}











		//builder.moveToElement(po_GTX.GTX_landing_search).click().perform();




}
