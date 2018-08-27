package Tests.testSteps;
import FrameWork.helpers.DriverHelper;
import POM.functions.fn_RDI_IB;
import POM.functions.fn_UBS;
import POM.functions.fn_allLogin;

import static FrameWork.library.Util.openUrl;
import static FrameWork.listeners.PreReq.getURL;

public class st_RDIIB {

    public static void Login_FirstAndSecondFA() throws Exception {
        /************Valid Login******/
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_allLogin.logout_RDI();
        /***********Invalid Login*****/
        DriverHelper.environmentURL="INVMKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
    }

    public static void OTPSMSToMobile() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_allLogin.logout_RDI();
    }

    public static void Prof_SecSettng_PwdChnge() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.SecSettng_PasswordChnge();
        fn_allLogin.logout_RDI();
    }

    public static void FCYAcct_MoveMoneyfromOnePackToFCY() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.FCYAcct_MoveMoneyFromOnePacktoFCY();
        fn_allLogin.logout_RDI();

    }

    public static void FCYAcct_Creation() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.FCY_Create();
        fn_allLogin.logout_RDI();

    }

    public static void Bill_Creation() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Bill_Create();
        fn_allLogin.logout_RDI();

    }

    public static void Bill_Deletion() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Bill_Delete();
        fn_allLogin.logout_RDI();

    }

    public static void Beneficiary_Deletion() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Beneficiary_Delete();
        fn_allLogin.logout_RDI();

    }

    public static void OnePackAcctSummary() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.OnePack_AccountSumm();
        fn_allLogin.logout_RDI();

        /*****************UBS Login*****************/
        DriverHelper.environmentURL="MKR3~UBS_KSA~T2";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.SearchAccNo_RetailIB();
        fn_UBS.SearchAcctSummary_RetailIB();
        fn_allLogin.logout_UBS();

    }

    public static void FCYAcct_MoveMoneyfromFCYToOnePack() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.FCYAcct_MoveMoneyFromFCYToOnePack();
        fn_allLogin.logout_RDI();

    }

    public static void FCYAcctSummary() throws Exception {
        DriverHelper.environmentURL="MKR7~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.FCY_AccountSumm();
        fn_allLogin.logout_RDI();

        /*****************UBS Login*****************/
        DriverHelper.environmentURL="MKR1~UBS_KSA~T2";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.SearchAccNo_RetailIB();
        fn_UBS.SearchAcctSummary_RetailIB();
        fn_allLogin.logout_UBS();

    }

    public static void FCYAcctClose() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.FCYAcct_Close();
        fn_allLogin.logout_RDI();

    }

    public static void Bill_GovtPayment() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Govt_Payment();
        fn_allLogin.logout_RDI();

    }

    public static void Benef_Creation() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Beneficiary_Create();
        fn_allLogin.logout_RDI();

    }

    public static void MFCA_AcctDetails() throws Exception {
        DriverHelper.environmentURL="MKR1~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.CurrenciesCard_AcctDetails();
        fn_allLogin.logout_RDI();

    }

    public static void Prof_CardUpdateLimit() throws Exception {
        DriverHelper.environmentURL="MKR3~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.CardUpdateLimit();
        fn_allLogin.logout_RDI();

    }

    public static void BenefType_LimitValidtn() throws Exception {
        DriverHelper.environmentURL="MKR3~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.BeneType_LimitValidation();
        fn_RDI_IB.BeneType_VerifyAcctTransaction();
        fn_allLogin.logout_RDI();

        /*****************UBS Login*****************/
        DriverHelper.environmentURL="MKR3~UBS_KSA~T2";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.SearchREFNo_RetailIB();
        fn_UBS.VerifyContractDetails_RetailIB();
        fn_UBS.ExitAllActiveWindows1();
        fn_allLogin.logout_UBS();

    }

    public static void Budget_GoalCreate() throws Exception {
        DriverHelper.environmentURL="MKR4~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Goal_Create();
        fn_allLogin.logout_RDI();

    }

    public static void Budget_GoalDelete() throws Exception {
        DriverHelper.environmentURL="MKR4~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Goal_Delete();
        fn_allLogin.logout_RDI();

    }

    public static void StandingInstructn_SetUp() throws Exception {
        DriverHelper.environmentURL="MKR4~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.SI_SetUp();
        fn_RDI_IB.SI_Verify();
        fn_allLogin.logout_RDI();

    }

    public static void StandingInstructn_Delete() throws Exception {
        DriverHelper.environmentURL="MKR4~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.SI_Delete();
        fn_RDI_IB.SI_Verify();
        fn_allLogin.logout_RDI();

    }

    public static void MFCACreation() throws Exception {
        DriverHelper.environmentURL="MKR4~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.MFCA_Create();
        fn_allLogin.logout_RDI();

    }

    public static void CardResIssuance() throws Exception {
        DriverHelper.environmentURL="MKR8~RDI_IB~T2";
        fn_RDI_IB.all_Login_RDI();
        fn_RDI_IB.Card_ReIssuance();
        fn_allLogin.logout_RDI();

    }

}
