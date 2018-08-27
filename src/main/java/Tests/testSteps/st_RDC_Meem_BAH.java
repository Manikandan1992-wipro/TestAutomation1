package Tests.testSteps;

import FrameWork.helpers.DriverHelper;
import POM.functions.fn_Meem_BAH;
import POM.functions.fn_UBS;
import POM.functions.fn_allLogin;

public class st_RDC_Meem_BAH {


    public static void all_Login_Meem() throws Exception {

        String loginType = DriverHelper.environmentURL;
        //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
        String application = loginType.split("~")[1];
        String urlType = loginType.split("~")[2];

        fn_Meem_BAH.login_Meem_BAH_test(loginType, application + "~" + urlType);
    }

    public static void all_Login_Meem_test() throws Exception {

        String loginType = DriverHelper.environmentURL;
        //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
        String application = loginType.split("~")[1];
        String urlType = loginType.split("~")[2];

        fn_Meem_BAH.login_Meem_BAH_test(loginType,application + "~" + urlType);
    }





    public static void Login_Validation() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_Validation_MeemBah();
        fn_Meem_BAH.Logout();
    }


    public static void Login_Invalid_Users() throws Exception {
        DriverHelper.environmentURL = "MKR1~RDCMEEM_BAH~T8";
        fn_Meem_BAH.Invalid_Login_MeemBah();
    }

    public static void Login_Invalid_OTP() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.Invalid_OTP();
    }

    public static void Acc_Summary_view_BAH() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Acc_Bal_view_BAH();
        fn_Meem_BAH.UBS_Balace_verify_BAH();
    }

    public static void Acc_Summary_view_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Acc_Bal_view_BAH();
        fn_Meem_BAH.UBS_Balace_verify_FCY();
    }

    public static void FCY_Account_Closure() throws Exception {
       DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
       fn_Meem_BAH.all_Login_MeemBah();
       fn_Meem_BAH.FCY_Acc_Closure();
        fn_Meem_BAH.UBS_Closure_verify();
    }

    public static void FCY_Account_Creation() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.FCY_Acc_Creation();
    }

    public static void Profile_Update() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.profile_updates();
    }


    public static void Password_Update() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.password_updates();
    }

    public static void Password_Update_SameAs_Old() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.password_update_sameAs_Old();
    }

    public static void Within_Meem_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Meem_Ben_creation();

    }

    public static void Within_Meem_Ben_Deletion() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Meem_Ben_Deletion();

    }

    public static void Within_Behrain_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Behrain_Ben_creation();

    }

    public static void Within_Behrain_Ben_Deletion() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Behrain_Ben_Deletion();

    }

    public static void International_Ben_Creation() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.international_Ben_creation();

    }

    public static void International_Ben_Deletion() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.international_Ben_Deletion();

    }

    public static void Ben_Creation_Invalid() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Ben_creation_Invalid();
    }

    public static void Own_Acc_trans_onepack_To_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Own_Acc_Onepack_to_FCY();
    }

    public static void Own_Acc_trans_FCY_To_Onepack() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Own_Acc_FCY_to_Onepack();
    }
    public static void Own_Acc_trans_FCY_To_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Own_Acc_FCY_to_FCY();
    }

    public static void Own_Acc_trans_Insufficient_Funds() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Own_Acc_Insufficient_fund();
    }


    public static void Within_Meem_Transfer_BHD_to_BHD() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Meem_BHD_to_BHD();
        fn_Meem_BAH.UBS_Fund_Transfers();

    }

    public static void Within_Meem_Transfer_BHD_to_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Meem_BHD_to_FCY();

    }

    public static void Within_Meem_Transfer_FCY_to_BHD() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Meem_FCY_to_BHD();

    }

    public static void Within_Meem_Transfer_FCY_to_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Meem_FCY_to_FCY();


    }

    public static void  Within_Behrain_Fawri_Transfer() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.within_Behrain_Fawri_Transfers();


    }


    public static void International_Transfer_BHD_to_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.International_tran_BAH_To_FCY();
        fn_Meem_BAH.UBS_Fund_Transfers();

    }

    public static void International_Transfer_FCY_to_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.International_tran_FCY_To_FCY();
    }
    public static void Inter_Transfer_Insufficient_Balance() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.International_tran_Insufficent_Bal();
    }

    public static void Standing_Ins_within_OwnAcc() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Standing_Inst_Setup_Within_OwnAcc();
    }

    public static void Standing_Ins_within_Meem() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Standing_Inst_Setup_Within_Meem();
    }

    public static void Standing_Ins_within_Behrain() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Standing_Inst_Setup_Within_Behrain();
    }

    public static void Standing_Ins_within_International() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Standing_Inst_Setup_International();
    }

    public static void Add_OnLine_Biller() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Add_Online_Biller();
    }

    public static void Add_OffLine_Biller() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Add_Offline_Biller();
    }


    public static void Single_OnLine_Payment() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Single_Online_Payment();
    }

    public static void Single_OffLine_Payment() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Single_Offline_Payment();
    }

    public static void Multiple_OnLine_Bill_Payment() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Multiple_Online_Bill_Payment();
    }

    public static void Multiple_OnLine_And_OffLine_Bill_Payment() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Multiple_Online_and_Offline_Bill_Payment();
    }

    public static void Deleting_Existing_Billers() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Deleting_Existing_Biller();
    }

    public static void Talk_Meem_New_Complaint() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.New_Complaint();
    }

    public static void Talk_Meem_New_Enquiry() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.New_Enquiry();
    }

    public static void Delete_Mails() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Delete_Mail();
    }

    public static void Initiate_Favorite_Transfers() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Intiate_Favorite_Transfer();
    }

    public static void Delete_Favorite_Transfers() throws Exception {
        DriverHelper.environmentURL = "MKR~RDCMEEM_BAH~T8";
        fn_Meem_BAH.all_Login_MeemBah();
        fn_Meem_BAH.Delete_Favorite_Transfer();

    }





}