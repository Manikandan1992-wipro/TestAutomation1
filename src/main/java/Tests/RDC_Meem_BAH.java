package Tests;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import Tests.testSteps.st_RDC_Meem_BAH;
import Tests.testSteps.st_UBS;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class RDC_Meem_BAH extends DriverHelper{

    @BeforeClass()
    public void LoadDataTestCase() throws Exception {
        Helper.GetDatasource();
        ReportHelper.getgenarateLogTestStart();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Login_Validation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Login_Validation();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Login_Invalid_Users(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Login_Invalid_Users();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Login_Invalid_OTP(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Login_Invalid_OTP();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Acc_Summary_view_BAH(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Acc_Summary_view_BAH();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Acc_Summary_view_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Acc_Summary_view_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void FCY_Account_Closure(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.FCY_Account_Closure();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void FCY_Account_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.FCY_Account_Creation();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Profile_Update(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Profile_Update();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Password_Update(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Password_Update();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Password_Update_SameAs_Old(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Password_Update_SameAs_Old();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Ben_Creation();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Ben_Deletion(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Ben_Deletion();
    }


    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Behrain_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Behrain_Ben_Creation();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Behrain_Ben_Deletion(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Behrain_Ben_Deletion();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void International_Ben_Creation(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.International_Ben_Creation();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void International_Ben_Deletion(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.International_Ben_Deletion();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Ben_Creation_Invalid(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Ben_Creation_Invalid();
    }


    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Own_Acc_trans_onepack_To_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Own_Acc_trans_onepack_To_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Own_Acc_trans_FCY_To_Onepack(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Own_Acc_trans_FCY_To_Onepack();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Own_Acc_trans_FCY_To_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Own_Acc_trans_FCY_To_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Own_Acc_trans_Insufficient_Funds(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Own_Acc_trans_Insufficient_Funds();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Transfer_BHD_to_BHD(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Transfer_BHD_to_BHD();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Transfer_BHD_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Transfer_BHD_to_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Transfer_FCY_to_BHD(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Transfer_FCY_to_BHD();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Meem_Transfer_FCY_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Meem_Transfer_FCY_to_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Within_Behrain_Fawri_Transfer(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Within_Behrain_Fawri_Transfer();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void International_Transfer_BHD_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.International_Transfer_BHD_to_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void International_Transfer_FCY_to_FCY(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.International_Transfer_FCY_to_FCY();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Inter_Transfer_Insufficient_Balance(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Inter_Transfer_Insufficient_Balance();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Standing_Ins_within_OwnAcc(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Standing_Ins_within_OwnAcc();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Standing_Ins_within_Meem(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Standing_Ins_within_Meem();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Standing_Ins_within_Behrain(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Standing_Ins_within_Behrain();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Standing_Ins_within_International(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Standing_Ins_within_International();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Add_OnLine_Biller(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Add_OnLine_Biller();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Add_OffLine_Biller(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Add_OffLine_Biller();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Single_OnLine_Payment(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Single_OnLine_Payment();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Single_OffLine_Payment(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Single_OffLine_Payment();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Multiple_OnLine_Bill_Payment(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Multiple_OnLine_Bill_Payment();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Multiple_OnLine_And_OffLine_Bill_Payment(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Multiple_OnLine_And_OffLine_Bill_Payment();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Talk_Meem_New_Complaint(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Talk_Meem_New_Complaint();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Talk_Meem_New_Enquiry(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Talk_Meem_New_Enquiry();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Delete_Mails(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Delete_Mails();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Initiate_Favorite_Transfers(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Initiate_Favorite_Transfers();
    }

    @Parameters({"browser", "dataBinder"})
    @Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
    public void Delete_Favorite_Transfers(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
        st_RDC_Meem_BAH.Delete_Favorite_Transfers();
    }


    @AfterClass
    public void close() throws Exception {
        closeReportAndDriver();
    }






}
