package Tests.testSteps;

import FrameWork.helpers.DriverHelper;
import POM.functions.fn_GTX_login;
import POM.functions.fn_allLogin;
import POM.pageobjects.po_GTX;
import POM.pageobjects.po_UBS;
import com.relevantcodes.extentreports.LogStatus;

import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;

public class st_GTX {
public  st_GTX() throws Exception {
initPageObjects();
}



	public static void initPageObjects() throws Exception {
		initElements(drvr, po_GTX.class);
		logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		getLatestDriver();
	}


	public static void GTX_TRN_Status_Validate() throws Exception {
	DriverHelper.environmentURL="CKR~GTX~T2";
		fn_GTX_login.all_Login_GTX();
		fn_GTX_login.search();
		fn_GTX_login.GTX_logout();
	}


}
