package POM.pageobjects;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class po_eCorp_fo extends po_BaseClass {

	public po_eCorp_fo(WebDriver driver) {
		super(driver);
	}

	/*
	* eCorp FundTransfer Object
	* */

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ext-el-mask-msg x-mask-loading')]")
	public static WebElement Div_LoadingPleaseWait;

	//*[@id="ext-gen1179"]/div
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'widget_icon PYMNTSMaster')]")
	public static WebElement HomePage_Payments;

	@FindBy(how = How.XPATH, using = "//div[@class='x-window-header x-unselectable x-window-draggable' and contains(.,'Domestic Fund Transfer')]")
	public static WebElement DivWindow_DomesticFundTransfer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Loans Summary')]")
	public static WebElement Tab_LoansSummary;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Reject Reason')]")
	public static WebElement Label_RejectRason;

	@FindBy(how = How.XPATH, using = "//textarea[@name='OD_REJECT_REASON']")
	public static WebElement TextArea_RejectReason;
	@FindBy(how = How.XPATH, using = "//*[@class=\"widget_icon ACCSERVMaster\"]")
	public static WebElement HomePage_AcctServices;



	@FindBy(how = How.XPATH, using = "//a/span[.='Payments']")
	public static WebElement Menu_Payments;

	@FindBy(how = How.XPATH, using = "//a/span[.='Domestic Fund Transfer']")
	public static WebElement Menu_DomesticFundTransfer;

	@FindBy(how = How.XPATH, using = "//a/span[.='International Fund Transfer']")
	public static WebElement Menu_InternationalFundTransfer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Own Account Transfer')]")
	public static WebElement Menu_OwnFundTransfer;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Transfer within GIB')]")
	public static WebElement Menu_TransferWithinGIB;

	@FindBy(how = How.NAME, using = "INPUT_DEBIT_ORG_ACC_NO")
	public static WebElement Input_DebitAccountNumber;

	@FindBy(how = How.XPATH, using = "//lable[.='Existing']")
	public static WebElement CheckBox_ExistingBeneficiary;

	@FindBy(how = How.NAME, using = "INPUT_AVAILABLE_BAL")
	public static WebElement TextArea_AccountAvailableBalance;

	@FindBy(how = How.NAME, using = "BENE_ACC_NO")
	public static WebElement Input_BeneficiaryAccountNumber;

	//	@FindBy(how = How.XPATH, using = "//lable[.='Payment Amount']")
	@FindBy(how = How.NAME, using = "PYMNT_AMT_RADIO")
	public static WebElement CheckBox_PaymentAmount;

	@FindBy(how = How.NAME, using = "INPUT_CREDIT_AMOUNT")
	public static WebElement Input_CreditAmount;

	@FindBy(how = How.XPATH, using = "//*[@class='x-form-field-wrap x-form-field-trigger-wrap x-box-item']")
	public static WebElement DropDown_PayCcyType;

	@FindBy(how = How.XPATH, using = "//*[@class='x-combo-list-inner']/div")
	public static List<WebElement> Dropdown_CcyValue;


	@FindBy(how = How.XPATH, using = "//*[@id='$$_ext-comp-1511']")
	public static WebElement DropDown_CurrencyType;

	@FindBy(how = How.XPATH, using = "//label[contains(.,'Charge Type')]/following::div[1]/div/input[contains(@class,'x-trigger-noedit')]")
	public static WebElement DropDown_ChargeType;

	//	@FindBy(how = How.XPATH, using = "//*[@id='$$_ext-comp-1525']") //$$_ext-comp-1525
	@FindBy(how = How.XPATH, using = "//div[@class='x-form-item']/label[contains(.,'Purpose of Transfer')]/following::div[1]/div/input[contains(@class,'x-trigger-noedit')]")
	public static WebElement DropDown_PurposeType;

	@FindBy(how = How.NAME, using = "payRef")
	public static WebElement TextArea_PaymentDetails;

	@FindBy(how = How.NAME, using = "CUST_REF")
	public static WebElement TextArea_CustomerReference;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Submit')]")
	public static WebElement Button_SubmitFundTransfer;

	@FindBy(how = How.NAME, using = "INPUT_VALUE_DATE")
	public static WebElement Date_TransactionDate;

	@FindBy(how = How.XPATH, using = "//*[@class=\"x-window-body\"]/div[@class=\"message-window\"]")
	public static WebElement Div_ConfirmationMsgBox;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Yes')]")
	public static WebElement Button_Yes;

	@FindBy(how = How.NAME, using = "OD_REF_NO")
	public static WebElement TextArea_TRANSACTION_REF_NO_VAL;

	@FindBy(how = How.NAME, using = "OD_STATUS_DESC")
	public static WebElement TextArea_TransactionStatus;

	@FindBy(how = How.NAME, using = "TXN_REF_NO_VAL")
	public static WebElement TextArea_TRANSACTION_REF_NO_VAL_2;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Confirm')]")
	public static WebElement Button_Confirm;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//button[contains(.,'Close')]")
	})
	public static List<WebElement> Button_Close_TopIndex;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Pending Activities')]")
	public static WebElement Button_PendingActivities;

	@FindBy(how = How.XPATH, using = "//div[@class='x-window-header x-unselectable x-window-draggable']")
	public static WebElement DivWindow_PendingActivities;


	@FindAll({
			@FindBy(how = How.XPATH, using = "//div[contains(@class,'x-tool x-tool-refresh')]")
	})
	public static List<WebElement> Button_Refresh_TopIndex;

	@FindBy(how = How.XPATH, using = "//div[contains(.,'Transaction Inquiries')]/div[contains(@class,'x-tool x-tool-refresh')]")
	public static List<WebElement> Button_RefreshTransactions;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//button[contains(.,'Authorize')]")
	})
	public static List<WebElement> Button_Authorize_TopIndex;

	@FindBy(how = How.NAME, using = "PARAM2")
	public static WebElement Input_Authorize_OTP;

	@FindBy(how = How.XPATH, using = "//button[@id='ext-gen120' and contains(@class,' x-btn-text')]")
	public static WebElement Button_Home;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'widget_icon ACCSERVMaster')]")
	public static WebElement Button_AccountSerivces_HomePage;

	@FindBy(how = How.NAME, using = "TRAN_DET_CUSTOMER_REFERENCE")
	public static WebElement TextArea_eCorp_CUSTOMER_REFERENCE;

	@FindBy(how = How.NAME, using = "TRAN_DET_UNIQ_TXN_REF_NO")
	public static WebElement TextArea_UBS_TXN_REF_NO;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//div[contains(@class,'CUSTOMER_REFERENCE') and contains(.,'200GT')]")
	})
	public static List<WebElement> Table_UBS_ReferenceNumberList;

	//Payment page DataMaintainance dropdown
/*	@FindBy(how = How.XPATH, using = "//*[@class=' x-btn-text DATA_MAINTENANCE']")
	public static WebElement Payment_DataMaintainance;*/
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Data Maintenance')]")
	public static WebElement Payment_DataMaintainance;

	//Beneficiary Library
	@FindBy(how = How.XPATH, using = ("//*[@id='DATA_MAINTENANCE']/ul/li/a/span"))
	public static WebElement DataMaintainance_BeneficiaryLibrary;

	//Add Beneficiary
	@FindBy(how = How.XPATH, using = ("//*[@id='BENIFICIARY_LIB']/ul/li/a/span"))
	public static WebElement BeneficiaryLibrary_AddBeneficiary;

	//BeneficiaryType
	@FindBy(how = How.XPATH, using = ("//div[@class='x-form-field-wrap x-form-field-trigger-wrap']/img"))
	public static WebElement AddBeneficiary_BeneficiaryType;
	@FindBy(how = How.XPATH, using = ("//form[@class='x-panel-body x-panel-body-noheader x-panel-body-noborder x-form']/div/table/tbody/tr/td/div/div/div/input[2]"))
	public static WebElement AddBeneficiary_BeneficiaryType1;


	//International Fund Transfer
	@FindBy(how = How.XPATH, using = ("//*[@class='x-combo-list-inner']/div[3]"))
	public static WebElement BeneficiaryType_InternationalFundTransfer;

	//Country Name
	@FindBy(how = How.XPATH, using = ("//*[@name='COUNTRY_IFT_LKP']"))
	public static WebElement AddBeneficiary_CountryName;

	//Country India
	@FindBy(how = How.XPATH, using = ("//*[@class='x-grid3-cell-inner x-grid3-col-COUNTRY_CODE'][contains(text(),'IN')]"))
	public static WebElement AddBeneficiary_Country;

	//BeneficiaryNickName
	@FindBy(how = How.XPATH, using = ("//*[@class='x-form-text x-form-field x-form-textField x-form-focus']"))
	public static WebElement AddBeneficiary_BeneNickName;

	//BeneficiaryName
	@FindBy(how = How.XPATH, using = ("//*[@name='BENE_NME']"))
	public static WebElement AddBeneficiary_BeneName;

	//AddressLine1
	@FindBy(how = How.XPATH, using = ("//*[@name='ADD_LINE_1']"))
	public static WebElement AddBeneficiary_AddressLine1;

	//BeneAccNo
	@FindBy(how = How.XPATH, using = ("//*[@name='IBAN_ACCT_NO']"))
	public static WebElement AddBeneficiary_BeneAccNo;

	//Submit
	@FindBy(how = How.XPATH, using = ("//*[contains(text(),'Submit')]"))
	public static WebElement AddBeneficiary_Submit;

	//SwiftCode
	@FindBy(how = How.XPATH, using = ("//*[@id=\"ext-comp-1463\"]"))
	public static WebElement BeneficiaryDetails_SwiftCode;

	//CountryName
	@FindBy(how = How.XPATH, using = ("//*[@name='CITY_NAME_SPEC']"))
	public static WebElement BeneficiaryDetails_CountryName;

	//SelectCountry
	@FindBy(how = How.XPATH, using = ("//*[contains(text(),'ABOHAR')]"))
	public static WebElement CountryName_SelectCountry;

	//BranchName
	@FindBy(how = How.XPATH, using = ("//*[@id='ext-comp-1470']"))
	public static WebElement BeneficiaryDetails_BranchName;

	//BankName
	@FindBy(how = How.XPATH, using = ("//*[@name='BANK_NAME3_SPEC']"))
	public static WebElement BeneficiaryDetails_BankName;

	//SelectBank
	@FindBy(how = How.XPATH, using = ("//*[@class='x-grid3-cell-inner x-grid3-col-BANK_DESCRIPTION'][contains(text(),'STATE BANK OF INDIA')]"))
	public static WebElement BankName_SelectBank;

	//Submit
	@FindBy(how = How.XPATH, using = ("//*[@id=\"ext-gen1619\"]/div/table/tbody/tr/td[1]/div"))
	public static WebElement BeneficiaryDetails_Submit;


	//Confirmation
	@FindBy(how = How.XPATH, using = ("//*[@class='x-btn portal_pos_btn x-btn-noicon']/tbody/tr[2]/td[2]/em/button"))
	public static WebElement BeneficiaryDetails_Confirmation;

	//Close
	@FindBy(how = How.XPATH, using = ("//*[@id=\"ext-gen2929\"]"))
	public static WebElement Confirmation_Close;

	//PendingActivities
	@FindBy(how = How.XPATH, using = ("//*[@id=\"ext-gen327\"]"))
	public static WebElement Payments_PendingActivities;

	//Beneficiaries
	@FindBy(how = How.XPATH, using = ("//*[@id=\"ext-gen3028\"]]"))
	public static WebElement PendingActivities_Beneficiaries;


	//Close
	@FindBy(how = How.XPATH, using = ("//button[contains(text(),'Close')]"))
	public static WebElement Close;
	@FindBy(how = How.XPATH, using = ("//*[@class=' x-btn-text indexedPanel-btn btn-WGT_BENE_SUMMARY']"))
	public static WebElement Benefisary_autze_tab;


	@FindAll({
			@FindBy(how = How.XPATH, using = "//button[@class=' x-btn-text'][text()='Authorize']")
	})
	public static List<WebElement> Button_Authorization;

	@FindBy(how = How.XPATH, using = ("//button[contains(.,'Submit')]"))
	public static WebElement OTP_submit;

	@FindBy(how = How.XPATH, using = ("//*[contains(text(),'Ok')]"))
	public static WebElement OTP_Ok;

	@FindBy(how = How.XPATH, using = ("//*[@class='message-window']"))
	public static WebElement OTPSuccessMsg;


	@FindBy(how = How.XPATH, using = ("//span[text()='Beneficiaries']"))
	public static WebElement Payments_Beneficiaries_tab;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@class='x-grid3-cell-inner x-grid3-col-BENE_ALIAS_NAME']")
	})
	public static List<WebElement> Nickname_data;


	//eStatement
	@FindAll({
			@FindBy(how = How.XPATH, using = "//div[contains(@class,'x-grid3-cell-inner x-grid3-col-OD_ACC_NO')]")
	})
	public static List<WebElement> Table_AccountSummary_AccountNumberList;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@class='x-grid3-cell-inner x-grid3-col-0']/img[2]")
	})
	public static List<WebElement> Table_AccountSummary_ActionList;

	@FindBy(how = How.XPATH, using = "//a/span[text()='View e-Statement']")
	public static WebElement Img_View_eStatement;

	@FindBy(how = How.XPATH, using = "//*[@class=' x-form-label-top x-table-layout-ct x-table-form-layout-ct']/table/tbody/tr[2]//input[2]")
	public static WebElement ListBox_Statement_Year;

	@FindBy(how = How.XPATH, using = "//*[@class=' x-form-label-top x-table-layout-ct x-table-form-layout-ct']/table/tbody/tr[3]//input[2]")
	public static WebElement ListBox_Statement_Month;

	@FindAll({
			@FindBy(how = How.CLASS_NAME, using = "x-combo-list-item")
	})
	public static List<WebElement> List_Statement_List;

	@FindBy(how = How.XPATH, using = "//button[text()='Go']")
	public static WebElement Button_Go;

	@FindBy(how = How.XPATH, using = "//div/a[contains(@class,'pdfstyle')]")
	public static WebElement element_Statement_pdf;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	public static WebElement Button_Cancel;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'error-text')]")
	public static WebElement Element_Error;

	@FindBy(how = How.XPATH, using = "//a/span[.='Instruments']")
	public static WebElement Menu_Instruments;

	@FindBy(how = How.XPATH, using = "//a/span[.='Managers Cheque']")
	public static WebElement Menu_InstManagerCheque;

	@FindBy(how = How.NAME, using = "BENE_ACC_NAME")
	public static WebElement Input_PayeeName;

	@FindBy(how = How.XPATH, using = "//input[@name='Address1']")
	public static WebElement Input_PayeeAddress;

	@FindBy(how = How.NAME, using = "collecBranchLkup")
	public static WebElement Input_CollectionBranch;

	@FindBy(how = How.NAME, using = "icNo")
	public static WebElement Input_AuthorizedPersonID;

	@FindBy(how = How.NAME, using = "authPerson")
	public static WebElement Input_AuthorizedPersonName;

	@FindBy(how = How.XPATH, using = "//input[@class=' x-form-checkbox x-form-field']")
	public static WebElement CheckBox_AcceptTermsAndCondts;

	@FindBy(how = How.XPATH, using = "//input[@class=' x-form-checkbox x-form-field'][@name='Yes']")
	public static WebElement CheckBox_AcceptTermsAndCondts2;

	////a/em/span/span[contains(text(),'Instruments')]
	@FindBy(how = How.XPATH, using = "//a/em/span/span[contains(text(),'Instruments')]")
	public static WebElement Tab_Instruments;

	@FindBy(how = How.XPATH, using = "//a/span[.='FCY Demand Draft']")
	public static WebElement Menu_InstFCYDemandDraft;

	@FindBy(how = How.NAME, using = "BENE_CURRENCY")
	public static WebElement Input_PayeeCurrency;

	@FindBy(how = How.XPATH, using = "//*[text()='Initiate']")
	public static WebElement Menu_Initiate;

	@FindBy(how = How.XPATH, using = "//*[text()='Account Opening']")
	public static WebElement Initiate_AccountOpening;

	@FindBy(how = How.XPATH, using = "//*[@name='CIF_NUM_LOOKUP']")
	public static WebElement AccountOpening_CIFSearch;

	@FindBy(how = How.XPATH, using = "//td[@class='x-grid3-col x-grid3-cell x-grid3-td-CIF_NO x-grid3-cell-first ']/div")
	public static WebElement CIFSearch_SelectCIF;

	@FindBy(how = How.XPATH, using = "//table[@class='x-table-layout']/tbody/tr[2]//input[2]")
	public static WebElement AccountOpening_AccountType;

	@FindBy(how = How.XPATH, using = "//div[@class='x-combo-list-inner']/div[3]")
	public static WebElement AccountType_CurrentAccount;

	@FindBy(how = How.XPATH, using = "//div[@class='x-fieldset-bwrap']/div/table/tbody/tr/td[2]/div/div/div/input[2]")
	public static WebElement AccountOpening_AccountCurrency;

	@FindBy(how = How.XPATH, using = "//div[@class='x-combo-list-inner']/div[contains(text(),'AED')]")
	public static WebElement AccountCurrency_SelectAED;

	@FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @ name='Yes']")
	public static WebElement AccountOpening_TermsandConditions;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	public static WebElement AccountOpening_Submit;

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'No records found that match this criteria.')]")
	public static WebElement CIFSearch_NoRecords;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Confirm')]")
	public static WebElement AccountOpening_Confirm;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close')]")
	public static WebElement AccountOpening_Close;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cheque Book Request')]")
	public static WebElement Initiate_CheckBookRequest;

	@FindBy(how = How.XPATH, using = "//input[@name='DEBIT_ACCOUNT_NO']")
	public static WebElement CheckBookRequest_AccountNo;

	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-cell-inner x-grid3-col-INPUT_ORG_ACC_NO']")
	public static WebElement AccountNo_SelectAccount;

	@FindBy(how = How.XPATH, using = "//tbody/tr[1]//div[@class='x-form-item ' ]/div/div/input[2]")
	public static WebElement CheckBookRequest_CheckBookSize;

	@FindBy(how = How.XPATH, using = "//div[@class='x-combo-list-inner']/div[2]")
	public static WebElement CheckBookSize_SelectSize;

	@FindBy(how = How.XPATH, using = "//input[@name='NO_BK']")
	public static WebElement CheckBookRequest_NoofCheck;

	@FindBy(how = How.XPATH, using = "//input[@name='AUTHPERSON_ID']")
	public static WebElement CheckBookRequest_AuthPersonID;

	@FindBy(how = How.XPATH, using = "//input[@name='AUTHPERSON_NAME']")
	public static WebElement CheckBookRequest_AuthPersonName;

	@FindBy(how = How.XPATH, using = "//input[@name='COL']")
	public static WebElement CheckBookRequest_CollectionBranch;

	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-cell-inner x-grid3-col-BRANCH_SWIFT_CODE']")
	public static WebElement CollectionBranch_SelectBranch;

	@FindBy(how = How.XPATH, using = "//input[@name='Yes' and @type='checkbox']")
	public static WebElement CheckBookRequest_TermsandConditions;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	public static WebElement CheckBookRequest_Submit;
	@FindBy(how = How.XPATH, using = "//input[@name='SI_OPTION'][@value='Yes']")
	public static WebElement Input_StandingInstructions;

	@FindBy(how = How.NAME, using = "SI_FIRST_PAY_DATE")
	public static WebElement Input_FirstPaymentDate;

	@FindBy(how = How.XPATH, using = "//tr[@class=' x-btn-with-menu']/td[2]/em")
	public static WebElement FirstPaymentDate_Arrow;

	@FindBy(how = How.XPATH, using = "//tr[4]/td[2][@class='x-table-layout-cell x-table-layout-column-1']//input[2]")
	public static WebElement Input_ExecutionFrequency;

	@FindBy(how = How.XPATH, using = "//div[@class='x-combo-list-inner']/div[2][contains(text(),'Daily')]")
	public static WebElement ExecutionFrequency_Daily;

	@FindBy(how = How.NAME, using = "SI_NO_PAY")
	public static WebElement Input_NOofPAyments;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close')]")
	public static WebElement Button_Close;

	@FindBy(how = How.XPATH, using = "//input[@name='CURR_AVAIL_BAL_AMT']")
	public static WebElement TextArea_CurrentBalance;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Close')]")
	public static WebElement OtherRequestSummary_Close;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Other Request Summary')]")
	public static WebElement Payments_OtherRequestSummary;

	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Standing Instructions')]")
	public static  WebElement Tab_StandingInstructions;

	@FindBy(how = How.XPATH,using = "//div[@class='user-logininfo']")
	public static WebElement Div_UserLoginInfo;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Stop Cheque Request')]")
	public static WebElement Initiate_StopCheckRequest;

	@FindBy(how = How.NAME, using = "CHQ_NO")
	public static WebElement Input_ChequeNumber;

	@FindBy(how = How.NAME, using = "CHQ_AMOUNT")
	public static WebElement Input_ChequeAmount;

	@FindBy(how = How.NAME, using = "CHQ_PAYEE")
	public static WebElement Input_ChequePayeeName;

	@FindBy(how = How.XPATH, using = "//*[@class='x-form-text x-form-field x-form-combo x-trigger-noedit']")
	public static WebElement DropDown_Reason;

	@FindBy(how = How.XPATH, using = "//*[@class='x-combo-list-inner']/div")
	public static List<WebElement> Dropdown_ReasonValue;

	@FindBy(how = How.NAME, using = "CIF_NUM_LOOKUP")
	public static WebElement Input_BillerCIF;

	@FindBy(how = How.NAME, using = "BILLER_LOOKUP")
	public static WebElement Input_BillerName;

	@FindBy(how = How.NAME, using = "SUBSCRIBER_ID")
	public static WebElement Input_SubscriberID;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Confirmation')]")
	public static WebElement Button_Confirmation;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'SADAD Biller')]")
	public static WebElement Menu_SADADBiller;

	@FindBy(how = How.XPATH, using = "//select[@id='billerType']")
	public static WebElement Select_BillerType;

	@FindBy(how = How.NAME, using = "CATEGRY_LOOKUP")
	public static WebElement Input_BillerCategory;

	//div[@id='billerLookUp']//img
	@FindBy(how = How.XPATH, using = "//div[@id='billerLookUp']//img")
	public static WebElement Search_BillerLookUp;

	//div[@id='categryLookUp']//img
	@FindBy(how = How.XPATH, using = "//div[@id='categryLookUp']//img")
	public static WebElement Search_BillerCategory;

	//BeneficiaryId
	@FindBy(how = How.NAME, using = "BeneficiaryId")
	public static WebElement Input_SponsorID;

	//select[@id='VisaType']
	@FindBy(how = How.XPATH, using = "//select[@id='VisaType']")
	public static WebElement Select_VisaType;

	//VisaCount
	@FindBy(how = How.NAME, using = "VisaCount")
	public static WebElement Inputt_VisaCount;

	//button[@id='go']
	@FindBy(how = How.XPATH, using = "//button[@id='go']")
	public static WebElement Button_BillerInfo_GO;

	@FindBy(how = How.XPATH, using = "//div[@id='cifLookUp']//img")
	public static WebElement Search_BillerCIF;

	@FindBy(how = How.XPATH, using = "//div[@id='acc_no']//img")
	public static WebElement Search_DebitAccountNum;

	@FindBy(how = How.XPATH, using = "//div[@class='x-grid3-scroller']//div[@class='x-grid3-row x-grid3-row-first']/table[@class='x-grid3-row-table']//td[@class='x-grid3-col x-grid3-cell x-grid3-td-0 x-grid3-cell-first ']")
	public static WebElement Select_CIFID;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'SADAD  Biller')]")
	public static WebElement Tab_SADADBiller;

	@FindBy(how = How.XPATH, using = "//div[contains(.,'Quick Pay')]/div[contains(@class,'x-tool x-tool-refresh')]")
	public static List<WebElement> Button_RefreshQuickPay;

	@FindBy(how = How.XPATH, using = "//textarea[@name='REASON']")
	public static WebElement Input_BillerCancellation_Reason;

	@FindBy(how = How.XPATH, using = "//input[@id='INPUT_DEBIT_AMOUNT']")
	public static WebElement Input_Biller_DebitAmount;

	@FindBy(how = How.XPATH, using = "//a/em/span/span[contains(text(),'SADAD Bill Payment')]")
	public static WebElement Tab_SADADBillPayment;

	@FindBy(how = How.XPATH, using = "//a/em/span/span[contains(text(),'SADAD Moi Payment')]")
	public static WebElement Tab_SADADMOIPayment;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Other Request Summary')]")
	public static WebElement Tab_OtherRequestSummary;

	@FindBy(how = How.XPATH, using = "//div[contains(.,'Service Request Summary')]/div[contains(@class,'x-tool x-tool-refresh')]")
	public static List<WebElement> Button_RefreshServiceRequestSummary;

	@FindBy(how = How.XPATH, using = "//*[text()='Data Maintenance']")
	public static WebElement Menu_DataMaintenance;

	@FindBy(how = How.XPATH, using = "//a/span[.='SADAD Biller Registration']")
	public static WebElement Menu_BillerRegistration;

	@FindBy(how = How.NAME, using = "STATUS_VAL")
	public static WebElement TextArea_Biller_Status;

	@FindBy(how = How.NAME, using = "TRANSACTION_REF_NO_VAL")
	public static WebElement TextArea_Biller_TxnReferenceNumber;

	@FindBy(how = How.XPATH, using = "//a/span[.='SADAD Payments']")
	public static WebElement Menu_SADADBillPayments;

	@FindBy(how = How.NAME, using = "OD_ACC_NO")
	public static WebElement Input_SADADDebitAccountNumber;

	@FindBy(how = How.NAME, using = "avail_bal")
	public static WebElement TextArea_SADADAvailableBalance;

	@FindBy(how = How.NAME, using = "txnRefNo")
	public static WebElement TextArea_SADADBiller_TxnReferenceNumber;

	@FindBy(how = How.XPATH, using = "//div[contains(.,'SADAD')]/div[contains(@class,'x-tool x-tool-refresh')]")
	public static List<WebElement> Button_RefreshSADAD;

	@FindBy(how = How.XPATH, using = "//a/span[.='SADAD MOI Payment']")
	public static WebElement Menu_SADADMOIPayments;




}
