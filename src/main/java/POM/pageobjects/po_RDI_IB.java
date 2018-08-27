package POM.pageobjects;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class po_RDI_IB extends po_BaseClass {

    public po_RDI_IB(WebDriver driver) {
        super(driver);
    }


    /***********************************SELECT-MENU ITEM**********************************************************/

    @FindBy(how = How.XPATH, using = "//*[@id='Needs-btn']")
    public static WebElement Button_Products;

    @FindBy(how = How.XPATH, using = "//*[@id='talkToUs-btn']")
    public static WebElement Button_TalktoMeem;

    @FindBy(how = How.XPATH, using = "//*[@id='Profile-btn']")
    public static WebElement Button_Profile;

    @FindBy(how = How.XPATH, using = "//*[@id='Tools-btn']")
    public static WebElement Button_Tools;

    @FindBy(how = How.XPATH, using = "//*[@id='Security-btn']")
    public static WebElement Button_Security;

    @FindBy(how = How.XPATH, using = "//*[@id='Invite-Btn']")
    public static WebElement Button_Invite;

    @FindBy(how = How.XPATH, using = "//*[@id='Favorites-btn']")
    public static WebElement Button_Favorites;

    @FindBy(how = How.XPATH, using = "//*[@id='Recipients-btn']")
    public static WebElement Button_TransferPayment;

    @FindBy(how = How.XPATH, using = "//*[@id='Accounts-btn']")
    public static WebElement Button_Accounts;

    @FindBy(how = How.XPATH, using = "//*[@id='Budgets-btn']")
    public static WebElement Button_Budgets;

    @FindBy(how = How.XPATH, using = "//*[@id='Emergency-cash']")
    public static WebElement Button_EmergencyCash;

    @FindBy(how = How.XPATH, using = "//div/h3[contains(.,'Your Bank Mailbox')]")
    public static WebElement WebElement_TalktoMeem;

    @FindBy(how = How.XPATH, using= "//div/h3[contains(.,'password and security settings')]")
    public static WebElement WebElement_Profile;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Booking Murabaha Deposit')]")
    public static WebElement WebElement_Products;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Security Tips')]")
    public static WebElement WebElement_SecurityTips;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Invite Friends and family')]")
    public static WebElement WebElement_InviteFriends;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Your Favourite Transactions')]")
    public static WebElement WebElement_Favourite;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Move Money')]")
    public static WebElement WebElement_TransferPayment;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'Accounts')]")
    public static WebElement WebElement_Accounts;

    @FindBy(how=How.XPATH, using="//div/h3[contains(.,'My Saving')]")
    public static WebElement WebElement_Budgets;

    @FindBy(how=How.XPATH, using="//h2[contains(.,'Emergency Cash')]")
    public static WebElement WebElement_EmergencyCash;

    /*****************************************************************************************************************************************/
    @FindBy(how = How.XPATH, using = "//a[@id='Recipients-btn']")
    public static WebElement Menu_TransferAndPaymt;

    @FindBy(how = How.XPATH, using = "//span/div[contains(text(),'Select the account you want to move money from')]")
    public static WebElement Select_MoveMoneyFrom;

    @FindBy(how = How.XPATH, using = "//div[@class='dd wrapper-dropdown-5 ddfromaccount wrapper-dropdown-padding active']//div[@id='aUD1']")
    public static WebElement DropDownLst_OnePack;

    @FindBy(how = How.XPATH, using = "//span/div[contains(text(),'Select the account you want to move money to')]")
    public static WebElement Select_MoveMoneyTo;

    @FindBy(how = How.XPATH, using = "//div[@class='dd wrapper-dropdown-5 ddtoaccount wrapper-dropdown-padding active']//div[@id='aUD2']")
    public static WebElement DropDownLst_FCY;

    @FindBy(how = How.XPATH, using = "//input[@id='sourceAmount']")
    public static WebElement Input_SourceAmount;

    @FindBy(how = How.XPATH, using = "//input[@id='exchangeRate']")
    public static WebElement Input_ExchangeRate;

    @FindBy(how = How.XPATH, using = "//input[@id='destinationAmount']")
    public static WebElement Input_DestinationAmount;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'Immediately')]")
    public static WebElement Button_Immediately;

    @FindBy(how = How.XPATH, using = "//div[@class='enterAmount-validation']//span[@class='ValidatoionError']")
    public static WebElement TextArea_ValidationAmountError;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Bills')]")
    public static WebElement Menu_Bills;

    @FindBy(how = How.XPATH, using = "//*[@id='dvPayeesBeneficries1']/li")
    public static List<WebElement> Table_FundTransferSummaryList;

    @FindBy(how = How.XPATH, using = "//*[@id='delete-btn']")
    public static WebElement Button_Delete;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Beneficiaries')]")
    public static WebElement Menu_Beneficiaries;

    @FindBy(how = How.XPATH, using = "//*[@id='aUD1']/div/div[2]/div/p[2]")
    public static WebElement TextArea_AcctBalance;

    @FindBy(how = How.XPATH, using = "//div/h2[contains(text(),'Your Account Transactions')]")
    public static WebElement WebElement_AcctTransaction;

/*    @FindBy(how = How.XPATH, using = "//div/h3[contains(text(),'Meem OnePack')]")
    public static WebElement WebElement_AcctDetails;*/

    @FindBy(how = How.XPATH, using = "//span[@id='lblStatusVal']")
    public static WebElement TextArea_AccountStatus;

    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_ContentPlaceHolder2_upConfirm']//a[contains(text(),'Confirm')]")
    public static WebElement Button_MoveMoney_Confirm;

    @FindBy(how = How.XPATH, using = "//*[@id='slideContainer']//tr[5]/td[2]/span")
    public static WebElement WebElement_CreditAmt;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Your funds transfer has been successful.')]")
    public static WebElement WebElement_FundTransferSuccessfulMsg;

    @FindBy(how = How.XPATH, using = "//li/a[contains(.,'Done')]")
    public static WebElement Button_Done;

    @FindBy(how = How.XPATH, using = "//div/a[contains(.,'Products')]")
    public static WebElement Menu_Products;

    @FindBy(how = How.XPATH, using = "//div/a[contains(.,'Foreign Currency Account')]")
    public static WebElement Menu_ForeignCcyAcct;

    @FindBy(how = How.XPATH, using = "//div[@class='currency']/ul/li")
    public static List<WebElement> Table_ForeignCcy;

    @FindBy(how = How.XPATH, using = "//div[@class='currency']/ul/li[@class='dummyClass']")
    public static WebElement Select_ForeignCcy;

    @FindBy(how = How.XPATH, using = "//div[@class='statement']/ul/li")
    public static List<WebElement> Table_Statement;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Confirm')]")
    public static WebElement Button_Confirm;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Accept')]")
    public static WebElement Button_Accept;

    @FindBy(how = How.XPATH, using = "//div/input[@name='ctl00$ContentPlaceHolder2$amount11']")
    public static WebElement Input_LimitAmount;

    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_ContentPlaceHolder2_upInternationalLimits']//a[contains(.,'Update')]")
    public static WebElement Button_UpdateLimit;

    @FindBy(how = How.XPATH, using = "//li/a[@id='lbtnOTPSentMobile']")
    public static WebElement Button_OTPSentMobile;
    //*[@id="upTwo"]/div/img

    @FindBy(how = How.XPATH, using = "//li/a[contains(text(),'Confirm')]")
    public static WebElement Button_OTPConfirm;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Profiles')]")
    public static WebElement Menu_Profiles;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Security Settings')]")
    public static WebElement SubMenu_SecSettings;

    @FindBy(how = How.XPATH, using = "//div/h3[@id='Limits']")
    public static WebElement Select_CardUpdateLimit;

    @FindBy(how = How.XPATH, using = "//div[@id='BeneficiaryList']//ul/li//div/h6[2]/p")
    public static List<WebElement> Table_Beneficiaries;

    @FindBy(how = How.XPATH, using = "//li[@id='pay-now-btn']")
    public static WebElement Button_PayNow;

    @FindBy(how = How.XPATH, using = "//span[@class='close']")
    public static WebElement Image_Close;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$ucAmountSlider$txtAmount")
    public static WebElement Input_TransferAmount;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ContentPlaceHolder2_lbtnTransferMoney']")
    public static WebElement Button_ConfirmTransferMoney;

    @FindBy(how = How.XPATH, using = "//div/div[@class='from']/div/p")
    public static WebElement WebElement_fromAccount;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtPurpose")
    public static WebElement Input_PurposeOfPaymt;

    @FindBy(how = How.XPATH, using = "//select[@name='ctl00$ContentPlaceHolder2$ddlGroupPurposeOfPayment']")
    public static WebElement Select_PurposeOfCategoryPaymt;

    @FindBy(how = How.XPATH, using = "//select[@name='ctl00$ContentPlaceHolder2$ddlPurposePayment']")
    public static WebElement Select_PurposeOfPayment;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ContentPlaceHolder2_btnProceed']")
    public static WebElement Button_ConfirmProceed;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ContentPlaceHolder2_lbtnConfirm']")
    public static WebElement Button_ConfirmTxn;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ContentPlaceHolder2_btnAgree']")
    public static WebElement Button_ConfirmAgreemnt;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'OK')]")
    public static WebElement Button_OK;

    @FindBy(how = How.XPATH, using = "//div[@class='accountsContainer FCY']/div/div/h3")
    public static List<WebElement> Table_FCYAccounts;

    @FindBy(how = How.XPATH, using = "//div[@id='buttonDOWN']")
    public static WebElement Button_ArrowDown;

    @FindBy(how = How.XPATH, using = "//div[@id='arrow-menu']/a[1]")
    public static WebElement Button_GoalArrowDown;

    @FindBy(how = How.XPATH, using = "//div[@id='arrow-menu']/a[2]")
    public static WebElement Button_SIArrowDown;

    @FindBy(how = How.XPATH, using = "//span[@id='lblConvertedAmount']")
    public static WebElement WebElement_BeneCreditAmt;

    @FindBy(how = How.XPATH, using = "//*[@id='ctl00_ucleftmenucontrol_lbtnHome']")
    public static WebElement Image_Home;

    @FindBy(how = How.XPATH, using = "//div[@id='accountsContainer']/div//div[@class='accountsLeft']/h3")
    public static List<WebElement> Table_Accounts;

    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_ContentPlaceHolder2_ucTransactionList_udpTransactionList']/ul/li/div[2]/h1/p")
    public static List<WebElement> Table_AcctTransaction;

    @FindBy(how = How.XPATH, using = "//div/h2[contains(.,'Your Account Transactions')]")
    public static WebElement Title_AccountTransaction;

    @FindBy(how = How.XPATH, using = "//div[@id='available-balance']//p[@class='amount']")
    public static WebElement TextArea_CreditAmount;

    @FindBy(how = How.XPATH, using = "//tr[contains(.,'Reference Number:')]/td[2]")
    public static WebElement TextArea_TxnReferenceNumber;

    @FindBy(how = How.XPATH, using = "//div[@class='charges hidden']/p/b")
    public static WebElement TextArea_VATChargesAmt;

    @FindBy(how = How.XPATH, using = "//p[@id='createNewGoal']")
    public static WebElement Button_CreateNewGoal;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtGoalLabel")
    public static WebElement Input_GoalName;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtTotalValue")
    public static WebElement Input_TotalSavingAmount;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtThreshHoldAmount")
    public static WebElement Input_ThreshHoldAmount;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtStartDate")
    public static WebElement Input_StartDate;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtEndDate")
    public static WebElement Input_EndDate;

    @FindBy(how = How.XPATH, using = "//div[@class='calendars-month']//select[1]")
    public static WebElement Select_CalendarMonth;

    @FindBy(how = How.XPATH, using = "//div[@class='calendars-month']//select[2]")
    public static WebElement Select_CalendarYear;

    @FindBy(how = How.XPATH, using = "//div[@id='createSuccess']/div[2]/h3")
    public static WebElement WebElement_GoalSuccessfulMessage;

    @FindBy(how = How.XPATH, using = "//div[@id='slideContainer']//div/h3")
    public static List<WebElement> Table_SavingInfo;

    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_ContentPlaceHolder2_rptGoals_ctl00_lbtnDeleteGoal']")
    public static WebElement Button_DeleteGoal;

    @FindBy(how = How.XPATH, using = "//li[@id='set-up-standing-btn']")
    public static WebElement Button_SetUpStandingInstr;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$txtCeilingAmount")
    public static WebElement Input_SI_Amount;

    @FindBy(how = How.XPATH, using = "//ul[@class='buttons']/li[contains(text(),'Meem OnePack')]")
    public static WebElement Button_MeemOnePack;

    @FindBy(how = How.XPATH, using = "//div/h3[contains(.,'Meem OnePack')]")
    public static WebElement WebElement_MeemOnePackAccount;

    @FindBy(how = How.XPATH, using = "//div/h3[contains(.,'T TWO')]")
    public static WebElement WebElement_CreditCardAccount;

    @FindBy(how = How.XPATH, using = "//a[@id='StandingInstructions-btn']")
    public static WebElement SubMenu_StandingInstruction;

    @FindBy(how = How.XPATH, using = "//select[@name='ctl00$ContentPlaceHolder2$ucTransactionList$ddlFilter']")
    public static WebElement Select_TransactionList;

    @FindBy(how = How.XPATH, using = "//ul[@class='rows']/li")
    public static List<WebElement> Table_TransactionList;

    @FindBy(how = How.XPATH, using = "//div[@class='successbutton']/span")
    public static WebElement WebElement_BenefSuccessfulMessage;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Currencies Card')]")
    public static WebElement SubMenu_CurrenciesCard;

    @FindBy(how = How.XPATH, using = "//h2[contains(.,'Currencies Card')]")
    public static WebElement Title_CurrenciesCard;

    @FindBy(how = How.XPATH, using = "//div[@id='dvCurrencies']//li")
    public static List<WebElement> Table_Currency;

    @FindBy(how = How.XPATH, using = "//a[contains(.,'add new product')]")
    public static WebElement Button_AddNewProduct;

    @FindBy(how = How.XPATH, using = "//p[@class='card']/span")
    public static WebElement WebELement_OP_ATMCard;

    @FindBy(how = How.XPATH, using = "//div/h3[@id='ActivateCard']")
    public static WebElement WebELement_MFCA_ActivateCard;

    @FindBy(how = How.XPATH, using = "//li[@id='Block']")
    public static WebElement Button_CardBlock;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Block')]")
    public static WebElement Button_ConfirmCardBlock;

    @FindBy(how = How.XPATH, using = "//div[@id='accountsDetails']//div[@class='details']//tr[1]/td[2]")
    public static WebElement WebELement_IBANNumber;

    @FindBy(how = How.XPATH, using = "//div[@id='accountsDetails']//div[@class='oneRight']/p[2]")
    public static WebElement WebELement_AvailableBalance;

    @FindBy(how = How.XPATH, using = "//div[@id='accountsDetails']//div[@class='opdetails']//li[1]/span")
    public static WebElement WebELement_CurrentAccount;

    @FindBy(how = How.XPATH, using = "//div[@id='accountsDetails']//div[@class='opdetails']//li[2]/span")
    public static WebElement WebELement_SavingAccount;

    // FCY Account Summary

    @FindBy(how = How.XPATH, using = "//*[@id='slideContainer']/div/div/div[2]/p[1]")
    public static WebElement WebELement_FCYIBAN;

    @FindBy(how = How.XPATH, using = "//*[@id='slideContainer']/div/div/div[1]/div[3]/p[2]")
    public static WebElement WebELement_FCYBalance;

    @FindBy(how = How.XPATH, using = "//h3[@id='cashBackArrangement']")
    public static WebElement WebELement_CC_CashBackDetails;

    @FindBy(how = How.XPATH, using = "//h3[@id='StopCard']")
    public static WebElement WebELement_CC_StopCard;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$BlockCard$txtNewPIN")
    public static WebElement Input_CC_NewCardPin;

    @FindBy(how = How.NAME, using = "ctl00$ContentPlaceHolder2$BlockCard$txtConfirmNewPIN")
    public static WebElement Input_CC_ConfirmNewPin;
}
