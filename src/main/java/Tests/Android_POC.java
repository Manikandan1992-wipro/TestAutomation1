package Tests;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import Tests.testSteps.st_Android;
import Tests.testSteps.st_RDC_Meem_BAH;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;



public class Android_POC extends DriverHelper{

    @BeforeClass()
    public void LoadDataTestCase() throws Exception {
        Helper.GetDatasource();
        ReportHelper.getgenarateLogTestStart();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void MeemBahrain_Android_login(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.MeemBahrain_Android_login();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Login_Invalid_Users(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Login_Invalid_Users();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Invalid_OTP(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Invalid_OTP();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Meem_Ben_Creation();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Behrain_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Behrain_Ben_Creation();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_International_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_International_Ben_Creation();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Ben_Deletions(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

       st_Android.Android_Within_Meem_Ben_Deletions();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void InternationalFundTransfer_BHD_To_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Meem_fundTransfer();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Bahrain_Ben_Deletions(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Bahrain_Ben_Deletions();


    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_International_Ben_Deletions(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_International_Ben_Deletions();


    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Own_Acc_trans_Onepack_To_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Own_Acc_trans_Onepack_To_FCY();


    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Own_Acc_trans_FCY_To_Onepack(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Own_Acc_trans_FCY_To_Onepack();


    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Own_Acc_trans_FCY_To_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Own_Acc_trans_FCY_To_FCY();


    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Own_Acc_trans_Insufficient_Funds(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Own_Acc_trans_Insufficient_Funds();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_InternationalTransfer_insufficient(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_International_Insufficient_Balance();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Transfer_BHD_to_BHD(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Meem_Transfer_BHD_to_BHD();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Transfer_BHD_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Meem_Transfer_BHD_to_FCY();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Transfer_FCY_to_BHD(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Meem_Transfer_FCY_to_BHD();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Within_Meem_Transfer_FCY_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Within_Meem_Transfer_FCY_to_FCY();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Standing_Ins_within_OwnAcc(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Standing_Ins_within_OwnAcc();

    }


    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Standing_Ins_within_Meem(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Standing_Ins_within_Meem();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Standing_Ins_within_Bahrain(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Standing_Ins_within_Bahrain();

    }


    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Standing_Ins_International(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Standing_Ins_International();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Add_Online_Biller(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Add_Online_Biller();

    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Android_Add_Offline_Biller(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {

        st_Android.Android_Add_Offline_Biller();

    }


    @AfterClass
    public void close() throws Exception {
        closeReportAndDriver();
    }






}
