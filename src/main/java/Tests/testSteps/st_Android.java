package Tests.testSteps;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import POM.functions.*;
import POM.pageobjects.po_GTX;
import POM.pageobjects.po_android;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.getAppiumDriver;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.listeners.po_BaseClass.driver;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;

public class st_Android {
    public st_Android() throws Exception {
        initPageObjects();
    }


    public static void initPageObjects() throws Exception {
        //initElements(appiumDriver, po_android.class);
        logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
        getLatestDriver();
    }

    public static void MeemBahrain_Android_login() throws Exception {

        fn_Android_Meem_Bah.Meembahrainlogin();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Login_Invalid_Users() throws Exception {
        fn_Android_Meem_Bah.Android_meembah_Invalid_users();
    }

    public static void Android_Invalid_OTP() throws Exception {

        fn_Android_Meem_Bah.Android_Invalid_otp();

    }

    public static void Android_Within_Meem_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Ben_creation();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }


    public static void Android_Within_Behrain_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Behrain_Ben_creation();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }
    public static void Android_International_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.International_Ben_creation();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }

    public static void Android_Within_Meem_Ben_Deletions() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Ben_deletion();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }

    public static void Android_Meem_fundTransfer() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.fundTransfer();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }



    public static void Android_Within_Bahrain_Ben_Deletions() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Bahrain_Ben_deletion();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }

    public static void Android_International_Ben_Deletions() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.International_Ben_deletion();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
    }

    public static void Android_Own_Acc_trans_Onepack_To_FCY() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Own_Acc_Onepack_To_FCY();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }

    public static void Android_Own_Acc_trans_FCY_To_Onepack() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Own_Acc_FCY_To_Onepack();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }

    public static void Android_Own_Acc_trans_FCY_To_FCY() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Own_Acc_FCY_To_FCY();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }

    public static void Android_Own_Acc_trans_Insufficient_Funds() throws Exception {
        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Own_Acc_Insufficent_Bal();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }


    public static void Android_International_Insufficient_Balance() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.INTTransfer_Insufficientbalance();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Within_Meem_Transfer_BHD_to_BHD() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Transfer_BHD_to_BHD();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        FetchOTP_Meem.Android_UBS_Fund_Transfers();
    }

    public static void Android_Within_Meem_Transfer_BHD_to_FCY() throws Exception {
        DriverHelper.environmentURL = "Test1~HOST_URL~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Transfer_BHD_to_FCY();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }


    public static void Android_Within_Meem_Transfer_FCY_to_BHD() throws Exception {
        DriverHelper.environmentURL = "Test1~HOST_URL~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Transfer_FCY_to_BHD();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }

    public static void Android_Within_Meem_Transfer_FCY_to_FCY() throws Exception {
        DriverHelper.environmentURL = "Test1~HOST_URL~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Within_Meem_Transfer_FCY_to_FCY();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();
        //fn_Android_Meem_Bah.Android_UBS_Fund_Transfers();
    }

    public static void Android_Standing_Ins_within_OwnAcc() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Standing_Inst_Setup_Within_OwnAcc();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Standing_Ins_within_Meem() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Standing_Inst_Setup_Within_Meem();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Standing_Ins_within_Bahrain() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Standing_Inst_Setup_Within_Bahrain();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Standing_Ins_International() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Standing_Inst_Setup_International();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Add_Online_Biller() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Add_Online_Biller();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }

    public static void Android_Add_Offline_Biller() throws Exception {

        DriverHelper.environmentURL = "Test1~Meem_Android_user~T8";
        fn_Android_Meem_Bah.all_Login_MeemAndroidLogin();
        fn_Android_Meem_Bah.Add_Offline_Biller();
        fn_Android_Meem_Bah.Android_MeemBah_Logout();

    }


}


