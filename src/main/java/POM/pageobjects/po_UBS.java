package POM.pageobjects;


import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class po_UBS extends po_BaseClass {

	public po_UBS(WebDriver driver) {
		super(driver);
	}

	/*
	* UBS Object
	* */
	@FindBy(how = How.XPATH, using = "//button[@id='BTN_OK']")
	public static WebElement Landingpage_okbtn;

	@FindBy(how = How.XPATH, using = "//button[@id='BTN_OK']")
	public static WebElement Button_UBS_OK;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'ext-el-mask-msg x-mask-loading')]")
	public static WebElement Div_LoadingPleaseWait;

	@FindBy(how = How.ID_OR_NAME, using = "fastpath")
	public static WebElement Input_UBS_FastPath;

	@FindBy(how = How.ID , using = "btnGo")
	public static WebElement Button_UBS_FastPathGo;

	@FindBy(how=How.ID , using = "ifr_LaunchWin")
	public static WebElement Frame_UBS_Contracts;

	@FindBy(how = How.ID , using = "BLK_SUMMARY_DETAILS__CONTREFNO")
	public static WebElement Input_UBS_RefNo;

	/*@FindBy(how = How.XPATH , using ="//button[@name='Search']")
	public static WebElement Button_UBS_RefNo; */

	@FindBy(how = How.CSS , using ="#tblquery_fleft > button:nth-child(3)")
	public static WebElement Button_UBS_RefNo;

	@FindBy(how = How.CSS , using ="#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a")
	public static WebElement Rec_UBS_RefNo;

	@FindBy(how = How.CSS, using="#ifr_LaunchWin")
	public static  List<WebElement> Frame2_UBS_Contracts;

	@FindBy(how = How.ID , using ="BLK_CONTRACT_DETAILS__CONTREFNO")
	public static WebElement Input_UBS_ContRefNo;

	@FindBy(how = How.XPATH , using ="//input[@name='DRAMT']")
	public static WebElement Input_UBS_DebitAmt;

	@FindBy(how=How.XPATH, using ="//*[@id='CSDEVENT']/a")
	public static WebElement Button_UBS_Event;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='chkDeleteRow']")
	})
	public static List<WebElement> ChkBox_UBS_Event;

	@FindBy (how=How.XPATH, using="//*[@id='CSDACENT']" )
	public static WebElement Button_UBS_AccountEntries;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='LCYAMT']")
	})
	public static List<WebElement> Input_UBS_LCYAmt;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='FCYAMT']")
	})
	public static List<WebElement> Input_UBS_FCYAmt;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='ACCCY']")
	})
	public static List<WebElement> Input_UBS_AccCcy;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='EXRATE']")
	})
	public static List<WebElement> Input_UBS_ExcRate;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//input[@name='ACNO']")
	})
	public static List<WebElement> Input_UBS_CrAcct;

	@FindBy(how = How.CSS, using="#BTN_EXIT_IMG")
	public static  List<WebElement> Image_UBS_Exit;

	@FindAll({
			@FindBy(how = How.XPATH, using = "//*[@id='BTN_EXIT_IMG']")
	})
	public static List<WebElement> Buttonlist_UBS_Exit;

	@FindBy(how = How.XPATH , using ="//span[@class='ICOonline'][contains(.,'Branch Is Online')]")
	public static WebElement Image_UBS_BranchIsOnline;

	@FindBy(how = How.XPATH , using ="//*[@id='nav']//b[@title='Select Branch']")
	public static WebElement Select_UBS_SelectBranch;

	@FindBy(how = How.XPATH , using ="//*[@id='nav']//b[@title='Home Branch']")
	public static WebElement Select_UBS_HomeBranch;

	@FindBy(how = How.XPATH , using ="//div[1]/div[@class='DIVText'][1]/input[1]")
	public static WebElement Input_UBS_BranchCode;

	@FindBy(how = How.XPATH , using ="//*[@id='LOVPageHead']//div[3]/button")
	public static WebElement Button_UBS_FetchValues;

	@FindBy(how = How.XPATH , using ="//*[@id='TableLov']/tbody/tr[1]")
	public static WebElement Table_UBS_SelectBranches;

	@FindBy(how = How.ID , using ="BLK_CONTRACT_DETAILS__CONTREFNO")
	public static WebElement Input_UBS_RDIContRefNo;

	@FindBy(how = How.XPATH , using ="//span[@class='ICOqueryenter']")
	public static WebElement Button_UBS_EnterQuery;

	@FindBy(how = How.XPATH , using ="//span[@class='ICOqueryexecute']")
	public static WebElement Button_UBS_ExecuteQuery;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__DRAMTI']")
	public static WebElement Input_UBS_DebitAmount;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__CRAMTI']")
	public static WebElement Input_UBS_CreditAmount;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__TOTALAMOUNTI']")
	public static WebElement Input_UBS_TotalAmount;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__DRACC']")
	public static WebElement Input_UBS_DebitAccount;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__CRACC']")
	public static WebElement Input_UBS_CreditAccount;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__DRACCBRN']")
	public static WebElement Input_UBS_DebitBranch;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__CRACCBRN']")
	public static WebElement Input_UBS_CreditBranch;

	@FindBy(how = How.XPATH , using ="//input[@id='BLK_CONTRACT_DETAILS__ULTBEN1']")
	public static WebElement Input_UBS_BeneIBANAccount;

	@FindBy(how = How.ID , using ="BLK_CUST_ACCOUNT__ACC")
	public static WebElement Input_UBS_RDIAcctNo;

	@FindBy(how = How.ID , using ="BLK_CUST_ACCOUNT__CUSTNO")
	public static WebElement Input_UBS_RDICustNo;

	@FindBy(how = How.XPATH , using ="//*[@id='vTabLN_CUSTOMER']/a")
	public static WebElement Button_UBS_Customer;

	@FindBy(how = How.NAME , using ="CFid")
	public static WebElement Input_UBS_SearchCustomerID;

	@FindBy(how = How.ID , using ="btnSearch")
	public static WebElement Button_UBS_Search;

	@FindBy(how = How.XPATH , using ="//div[@id='CUSTDETAILS']//tbody/tr[1]/td/a")
	public static WebElement Table_UBS_CustomerList;

	@FindBy(how = How.XPATH , using ="//div[@id='ListofAccDiv']//tbody/tr/td[1]")
	public static List<WebElement> Table_UBS_AcctList;

	@FindBy(how = How.XPATH , using ="//div[@id='AccDetailsDiv']//tr[1]/td/span")
	public static WebElement WebElement_UBS_AcctProduct;

	@FindBy(how = How.XPATH , using ="//div[@id='AccDetailsDiv']//tr[5]/td/span")
	public static WebElement WebElement_UBS_CurrentAcct;

	@FindBy(how = How.XPATH , using ="//div[@id='AccDetailsDiv']//tr[6]/td/span")
	public static WebElement WebElement_UBS_SavingAcct;

//******************************************************************

	@FindBy(how = How.XPATH, using = "//button[@class='BTNicon']")
	public static WebElement newBtn;

	@FindBy(how = How.XPATH, using = "//input[@class='TXTstd' and @name='BRANCH_CODE']")
	public static WebElement branchCode;

	@FindBy(how = How.XPATH, using = "//button[@id='BTN_OK']")
	public static WebElement okBtn;

	@FindBy(how = How.XPATH, using = "//input[@class='TXTstd' and @title='Product']")
	public static WebElement productTxt;

	@FindBy(how = How.XPATH, using = "//button[contains(@title,'List')]")
	public static WebElement productSearchBtn;

	@FindBy(how = How.XPATH, using = "//input[@type='VARCHAR2' and @name='1']")
	public static WebElement productValue;

	@FindBy(how = How.XPATH, using = "//button[@class='BTNtext' and contains(text(),'Fetch Values')]")
	public static WebElement fetchValuesBtn;

	@FindBy(how = How.XPATH, using = "//button[@label_value='P']")
	public static WebElement prdpopulateBtn;

	@FindBy(how = How.XPATH, using = "//input[@label_value='Debit Currency']")
	public static WebElement txt_debitCurrency;

	@FindBy(how = How.XPATH, using = "//input[@name='DRAMTI']")
	public static WebElement txt_debitAmount;

	@FindBy(how = How.XPATH, using = "//input[@title='Debit Branch']")
	public static WebElement txt_debitBranch;

	@FindBy(how = How.XPATH, using = "//input[@title='Credit Amount' and @class='TXTstd numeric']")
	public static WebElement txt_CreditAmount;

	@FindBy(how = How.XPATH, using = "//button[@class='BTNicon' and @title='Save']")
	public static WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//input[@name='PAYMENTDET1']")
	public static WebElement purposeofTransfer;

	@FindBy(how = How.XPATH, using = "//button[@name='ACCEPT']")
	public static WebElement acceptBtn;

	@FindBy(how = How.XPATH, using = "//span[@class='SPNtbltwoC']")
	public static WebElement SuccessMsg;

	@FindBy(how = How.XPATH, using = "//span[contains(.,'Party Details')]")
	public static WebElement PartyDetails;

	@FindBy(how = How.XPATH, using = "//button[@id='EnterQuery']")
	public static WebElement BTN_Query;

	@FindBy(how = How.XPATH, using = "//input[@id='BLK_CONTRACT_DETAILS__CONTREFNO']")
	public static WebElement TXT_contctRefernce;

	@FindBy(how = How.XPATH, using = "//button[@id='ExecuteQuery']")
	public static WebElement BTN_ExecuteQuery;

	@FindBy(how = How.XPATH, using = "//button[@id='Authorize']")
	public static WebElement BTN_Authorize;

	@FindBy(how = How.XPATH, using = "//button[@id='BLK_AUTH_DETAILS__BTN_AUTH']")
	public static WebElement BTN_Authorize_all;






}
