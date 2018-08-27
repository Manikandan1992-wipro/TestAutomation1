package Tests.testSteps;

import FrameWork.helpers.DriverHelper;
import POM.functions.fn_UBS;
import POM.functions.fn_allLogin;


public class st_UBS {

	public static void all_Login_UBS() throws Exception {

		String loginType = DriverHelper.environmentURL;
		//String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
		String application = loginType.split("~")[1];
		String urlType = loginType.split("~")[2];

		fn_allLogin.login_UBS(loginType, application + "~" + urlType);
	}

	public static void all_Login_UBS_test() throws Exception {

		String loginType = DriverHelper.environmentURL;
		//String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
		String application = loginType.split("~")[1];
		String urlType = loginType.split("~")[2];

		fn_allLogin.login_UBS(loginType, application + "~" + urlType);
	}

	public static void Android_all_Login_UBS() throws Exception {

		String loginType = DriverHelper.environmentURL;
		//String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
		String application = loginType.split("~")[1];
		String urlType = loginType.split("~")[2];

		fn_allLogin.Android_login_UBS(loginType, application + "~" + urlType);
	}


	public static void fundTransfer_Validate() throws Exception {
		DriverHelper.environmentURL = "CKR3~UBS_KSA~T2";
		st_UBS.all_Login_UBS();
		fn_UBS.FastPath();
		fn_UBS.SearchREFNo1();
		fn_UBS.VerifyContractDetails1();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}

	public static void fundTransfer_Validate_test() throws Exception {
		DriverHelper.environmentURL = "MKR3~UBS_KSA~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.SearchREFNo1();
		fn_UBS.VerifyContractDetails1();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}


	public static void internationalTransfer() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_KSA~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}

	public static void internationalTransfer_BAH() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_BAH~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails_InternationalFT();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}

	public static void internationalTransfer_UAE() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_UAE~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails_InternationalFT();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}

	public static void DomesticTransfer_UAE() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_UAE~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails1();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
	}

	public static void InternationalTransfer_KSA() throws Exception {
		DriverHelper.environmentURL = "MKR6~UBS_KSA~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry_domestic();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails_InternationalFT();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
		/*DriverHelper.environmentURL="MKR7~UBS_KSA~T7";
		FT_Authorize();
*/
	}

	public static void DomesticTransfer_KSA() throws Exception {
		DriverHelper.environmentURL = "MKR6~UBS_KSA~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry_domestic();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails1();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
		/*DriverHelper.environmentURL="MKR7~UBS_KSA~T7";
		FT_Authorize();
*/
	}

	public static void DomesticTransfer_BAH() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_BAH~T2";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickNewbutton();
		fn_UBS.enterBranchCode();
		fn_UBS.enterProductAndClickPopulate();
		fn_UBS.enterDebitAndCreditDetails();
		fn_UBS.clickBenificaryIBANANDCountry_domestic();
		fn_UBS.clickEnrichAndSave();
		fn_UBS.VerifyContractDetails1();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();
		/*DriverHelper.environmentURL="MKR7~UBS_KSA~T7";
		FT_Authorize();
*/
	}

	public static void FT_Authorize() throws Exception {
		//	DriverHelper.environmentURL="CKR6~UBS_KSA~T7";
		st_UBS.all_Login_UBS_test();
		fn_UBS.FastPath();
		fn_UBS.clickQueryButton();
		fn_UBS.EnterReferceAndclickQuery();
		fn_UBS.UBS_authorize();
		fn_UBS.ExitAllActiveWindowsall();
		fn_allLogin.logout_UBS();

	}


	/*****************UBS Login*****************/
	public static void OnePackAcctSummary() throws Exception {
		DriverHelper.environmentURL = "MKR5~UBS_BAH~T2";
		st_UBS.all_Login_UBS();
		fn_UBS.UBS_SwitchBranch();
		fn_UBS.FastPath();
		fn_UBS.SearchAccNo_RetailIB();
		fn_UBS.SearchAcctSummary_RetailIB();
		fn_UBS.ExitActiveWindow_AcctSummary();
		fn_allLogin.logout_UBS();

	}
}