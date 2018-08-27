package Tests.testSteps;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import FrameWork.library.CommonFunction;
import FrameWork.listeners.Log;
import FrameWork.listeners.PreReq;
import POM.functions.*;
import com.relevantcodes.extentreports.LogStatus;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

import static FrameWork.helpers.DriverHelper.ENV;
import static FrameWork.helpers.Helper.getData;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.library.Util.waitFor;

import static POM.functions.fn_eCorp_FO.initPageObjects;
import static Tests.testSteps.st_GTX.GTX_TRN_Status_Validate;


public class st_GTBeCorp {

	public static void all_Login_GTBeCorp() throws Exception {
		String loginType = DriverHelper.environmentURL;

		String application = loginType.split("~")[1];
		String urlType = loginType.split("~")[2];

		switch (application) {
			case "eCorp_FO":
				fn_allLogin.login_GTBeCorp_FO(loginType, application + "~" + urlType);
				break;
			case "eCorp_BO":
				fn_allLogin.login_GTBeCorp_BO(loginType, application + "~" + urlType);
				break;
		}
	}

	public static void all_Logout_GTBeCorp() {

		String loginType = DriverHelper.environmentURL;
		String application = loginType.split("~")[1];


		switch (application) {
			case "eCorp_FO":
				fn_allLogin.logout_GTBeCorp_FO();
				break;
			case "eCorp_BO":
				fn_allLogin.logout_GTBeCorp_BO();
				break;
		}
	}

	public static void all_GTBeCorp_FO_FundTransfer() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.initiateFundTransfer();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		CommonFunction.ClearAllCaches();
		all_GTBeCorp_FO_Authorise();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_GTBeCorp_FO_Validate();
/*		CommonFunction.ClearAllCaches();
		//	st_UBS.fundTransfer_Validate();
		st_UBS.fundTransfer_Validate_test();
		GTX_TRN_Status_Validate();*/
	}


	public static void all_GTBeCorp_FO_Authorise() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.authoriseFundTransfer();
		all_Logout_GTBeCorp();
	}


	public static void all_GTBeCorp_FO_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateFundTransferStatus();
		all_Logout_GTBeCorp();
	}


	public static void AccountSumm_FO_View() throws Exception {
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.AccountSummary();
		//fn_eCorp_FO.accc();
		all_Logout_GTBeCorp();
	}

	public static void BeneficiaryRegisteration() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.AddBeneficiary();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		BeneficiaryAuthorisation();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		BeneficiaryVerification();
	}

	public static void BeneficiaryAuthorisation() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.authoriseBeneficary();
		all_Logout_GTBeCorp();
	}

	public static void BeneficiaryVerification() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateBeneficary();
		all_Logout_GTBeCorp();
	}

	public static void View_eStatement() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.GeteStatement();
		all_Logout_GTBeCorp();
	}

	public static void webservice() throws ParserConfigurationException, TransformerException, SAXException, SOAPException, IOException {
		//form xml with given input data
		webserviceHandler.formXMLwithdata(getData("Accoun_xml"), getData("Dls_inputele_data"));
		//connect and get response path
		String xmlresponsepath = webserviceHandler.getSoapConnectionResponse(getData("Accoun_xml"), getData("SOAP_ACTION"), getData("SOAP_URL"));
		//get data from Response
		webserviceHandler.getDatafromResponse(getData("Accoun_xml"), xmlresponsepath, getData("Dls_outnode"), "Dls_outdata");

	}


	public static void All_GTeCorp_FO_Instruments() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.initiateInstruments();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		all_GTBeCorp_FO_Authorise();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		Instrumts_FO_Validate();
	}


	public static void Instrumts_FO_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateInstrumentsStatus();
		all_Logout_GTBeCorp();
	}

	public static void Account_Opening() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.Account_Opening();
		all_Logout_GTBeCorp();
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		AccountServices_FO_Authorize();
	}

	public static void AccountServices_FO_Authorize() throws Exception {

		all_Login_GTBeCorp();
		fn_eCorp_FO.authoriseAccountServices();
		all_Logout_GTBeCorp();
	}

	/**********************************New Test Scenarios********************************************************/
	public static void LoansSumm_FO_View() throws Exception {
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.LoansSummary();
		all_Logout_GTBeCorp();
	}

	public static void StopCheckRequest() throws Exception {
		DriverHelper.environmentURL = "MKR~eCorp_FO~T2";
		all_Login_GTBeCorp();
		fn_eCorp_FO.StopCheckRequest();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR~eCorp_FO~T2";
		AccountServices_FO_Authorize();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		DriverHelper.environmentURL = "MKR~eCorp_FO~" + ENV;
		StopChequeRequest_FO_Validate();
	}

	public static void StopChequeRequest_FO_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateStopChequeRequestStatus();
		all_Logout_GTBeCorp();
	}

	public static void All_GTeCorp_FO_BillerRegistration() throws Exception {
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.BillerRegistration();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR3~eCorp_FO~" + ENV;
		GTBeCorp_SADADBiller_Authorise();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		GTBeCorp_SADADBiller_Validate();

	}

	public static void GTBeCorp_SADADBiller_Authorise() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.authoriseSADADBiller();
		all_Logout_GTBeCorp();
	}

	public static void GTBeCorp_SADADBiller_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateSADADBiller();
		all_Logout_GTBeCorp();
	}

	public static void All_GTeCorp_FO_BillerCancellation() throws Exception {
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.BillerCancellation();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR3~eCorp_FO~" + ENV;
		GTBeCorp_SADADBiller_Authorise();

	}

	public static void SADADBillPayment_FO_Create() throws Exception {
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.initiateSADADBillPayments();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR3~eCorp_FO~" + ENV;
		all_GTBeCorp_FO_Authorise();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		SADADBillPayment_FO_Validate();
	}

	public static void SADADBillPayment_FO_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateSADADBillPaymentStatus();
		all_Logout_GTBeCorp();
	}

	public static void SADADMOIPayment_FO_Create() throws Exception {
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.initiateSADADMOIPayments();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR3~eCorp_FO~" + ENV;
		all_GTBeCorp_FO_Authorise();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Validation Process Started!!!");
		DriverHelper.environmentURL = "MKR3~eCorp_FO~" + ENV;
		SADADMOIPayment_FO_Validate();
	}

	public static void SADADMOIPayment_FO_Validate() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_FO.validateSADADMOIPaymentStatus();
		all_Logout_GTBeCorp();
	}


	///////////Bo//////////////////
	public static void BO_Segment_Create() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
//		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.SegementCreate();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Valdiation Process Started!!!");
		SegementCreate_view();

	}

	public static void SegementCreate_view() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.SegementCreate_view();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}


	public static void all_GTBeCorp_BO_CustProfile() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.CustSgmtProf_SelAttribute();
		fn_eCorp_BO.CustProf_SelectProdAndSubProdLink();
		fn_eCorp_BO.CustProf_SelProdAndSubProd();
		fn_eCorp_BO.CustProf_SelectFuncForEachProdLink();
		fn_eCorp_BO.CustProf_SelFunctForEachProd();
		fn_eCorp_BO.CustSgmtProf_ReviewConfirm();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_CustomerProfile_Authorise();

		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Valdiation Process Started!!!");
		BO_CustProfile_view();
	}

	public static void BO_CustomerProfile_Authorise() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.Authorise();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();

	}

	public static void BO_CustProfile_view() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.BO_CustProfile_view();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();

	}

	public static void All_GTBeCorp_BO_Roles() throws Exception {

		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.Roles_Add();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_Roles_Authorize();
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Process Started!!!");
		BO_Roles_View();
	}

	public static void BO_Roles_Authorize() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.Role_Authorize();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_Roles_View() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.Role_View();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_BasicInfo_Add() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.BasicInfo_CustDetails();
		fn_eCorp_BO.SelectCustomerUser();
		fn_eCorp_BO.BsicInfo_DefineUserRole();
		fn_eCorp_BO.BsicInfo_ReviewAndConfirm();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_BasicInfo_Authorize();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, " View Validation Process Started!!!");

		BO_BasicInfo_View();
	}

	public static void BO_BasicInfo_Authorize() throws Exception {
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.BasicInfo_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_BasicInfo_View() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.BasicInfo_View();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_Usergroup_creation() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserGroupCreation();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_Usergroup_Authorize();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Validation Process Started!!!");
		BO_Usergroup_creation_view();
	}

	public static void BO_Usergroup_creation_view() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserGroupCreation_View();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_Usergroup_Authorize() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserGroup_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_TxnWorkflowRules_Add() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.TxnWorkflow_Add();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_TxnWorkflowRules_Authorize();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Process Started!!!");
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		BO_TxnWorkflowRules_View();
	}

	public static void BO_TxnWorkflowRules_Authorize() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.TxnWorkflow_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();

	}

	public static void BO_TxnWorkflowRules_View() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.TxnWorkflow_View();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void PPP_Customer_Onboarding() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Login_BO_GTPPP();
		fn_eCorp_BO.CustomerOnboarding();
		fn_eCorp_BO.Logout_BO_GTPPP();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		PPP_Customer_Onboarding_Authorization();
	}

	public static void PPP_Customer_Onboarding_Authorization() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Login_BO_GTPPP();
		fn_eCorp_BO.CustomerOnboardingAuthorization();
		fn_eCorp_BO.Logout_BO_GTPPP();
		all_Logout_GTBeCorp();
	}

	public static void BO_UserActivation_Add() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserActivationAdd();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		BO_UserActivation_Authorize();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Process Started!!!");
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		BO_UserActivation_View();

	}

	public static void BO_UserActivation_Authorize() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserActivation_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void BO_UserActivation_View() throws Exception {
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserActivation_View();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}


	public static void Customer_Registeration() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.CustomerRegisteration();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		Customer_Registeration_Authorization();
		CommonFunction.ClearAllCaches();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Validation Process Started!!!");

		CustomerRegisteration_view();
	}

	public static void Customer_Registeration_Authorization() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.CustomerRegisterationAuthorization();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void CustomerRegisteration_view() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.CustomerRegisteration_view();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void All_GTBeCorp_BO_UserProfile() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~T2";
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserProfileAdd();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		CommonFunction.ClearAllCaches();
		DriverHelper.environmentURL = "CKR1~eCorp_BO~T2";
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		User_Profile_Authorize();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "View Process Started!!!");
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		//	UserProfile_View();
	}

	public static void User_Profile_Authorize() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserProfileAddAuthorization();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void UserProfile_View() throws Exception {
		all_Login_GTBeCorp();
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.UserProfile_View();
		waitFor(3000);
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void Check_Book_Request() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		fn_eCorp_FO.CheckBookRequest();
		all_Logout_GTBeCorp();
		ReportHelper.forceScreenShotPass = false;
		ReportHelper.logReportStatus(LogStatus.PASS, "Authorization Process Started!!!");
		DriverHelper.environmentURL = "CKR~eCorp_FO~" + ENV;
		AccountServices_FO_Authorize();
	}

	public static void Bo_DisableUser() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.DisableUser();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		Bo_DisableUser_Authorize();
	}

	public static void Bo_DisableUser_Authorize() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.DisableUser_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void Bo_Enable_User() throws Exception {
		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(2000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.enableUser();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
		Bo_Enable_User_authorize();
	}

	public static void Bo_Enable_User_authorize() throws Exception {
		DriverHelper.environmentURL = "CKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.enableUser_Authorize();
		fn_eCorp_BO.BO_IGTBBH_Logout();
		all_Logout_GTBeCorp();
	}

	public static void Bo_GeneratePin() throws Exception {

		BO_BasicInfo_Add();

		DriverHelper.environmentURL = "MKR1~eCorp_BO~" + ENV;
		all_Login_GTBeCorp();
		waitFor(5000);
		fn_eCorp_BO.Select_BO_IGTBBH();
		fn_eCorp_BO.generatePin();


	}
}
