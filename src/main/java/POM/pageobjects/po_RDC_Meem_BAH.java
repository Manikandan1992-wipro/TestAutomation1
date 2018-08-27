package POM.pageobjects;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class po_RDC_Meem_BAH extends po_BaseClass {

    public po_RDC_Meem_BAH(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//input[@id='frmLogin_txtUsername']")
    public static WebElement Input_Meem_BAH_username;

    @FindBy(how = How.XPATH, using = "//input[@id='frmLogin_txtPassword']")
    public static WebElement Input_Meem_BAH_password;

    @FindBy(how = How.XPATH, using = "//input[@id='frmLogin_btnLogin']")
    public static WebElement Button_Meem_BAH_okbtn;

    @FindBy(how = How.XPATH, using = "//*[@id='frmOTPScreen_txtOTP']")
    public static WebElement Input_OTP_code;

    @FindBy(how = How.XPATH, using = "//*[@id='frmOTPScreen_btnContinue']")
    public static WebElement Button_continueclk;

    @FindBy(how = How.XPATH, using = "//input[@value='Logout']")
    public static WebElement Button_logout;

    @FindBy(how = How.XPATH, using = "//*[@id='frmLogin_lblInfoDesc']")
    public static WebElement Alert_msg;

    @FindBy(how = How.XPATH, using = "//*[@id='frmLogin_btnInfoOk']")
    public static WebElement Alert_Ok_Btn;

    @FindBy(how = How.XPATH, using = "//*[@id=\'frmErrorScreen_lblVerificationMsg\']")
    public static WebElement OTP_Error_msg;

    @FindBy(how = How.XPATH, using = "//*[@id='frmErrorScreen_btnContinue']")
    public static WebElement OTP_Home_Btn;

    @FindBy(how = How.XPATH, using = "//div[text()='Meem OnePack']")
    public static WebElement Link_Meem_Onepack;

    @FindBy(how = How.XPATH, using = "//*[@id='frmProductDetails_btnInfo']")
    public static WebElement Icon_Meem_Onepack;

    @FindBy(how = How.XPATH, using = "//*[@id='frmProductDetails_btnAccClose']")
    public static WebElement Close_Icon_Meem_Onepack;

    @FindBy(how = How.XPATH, using = "//*[@id='frmProductDetails_lblIBAN']")
    public static WebElement IBAN_No_Link;

    @FindBy(how = How.XPATH, using = "//input[@title='Account']")
    public static WebElement Input_AccNo;

    @FindBy(how = How.XPATH, using = "//button[@title='Search']")
    public static WebElement Clk_Search_Button;

    @FindBy(how = How.XPATH, using = "//a[text()='Authorized']")
    public static WebElement Clk_Authorize_link;

    @FindBy(how = How.XPATH, using = "//button[text()='Amounts And Dates']")
    public static WebElement Clk_AmountsandDate_Btn;

    @FindBy(how = How.XPATH, using = "//*[@id='BLK_AMOUNT_DATES__AVL_BALI']")
    public static WebElement Txt_available_Balance;

    @FindBy(how = How.XPATH, using = "//*[@id='frmProductDetails_rchTxtAvailableBalance']/label")
    public static WebElement Meem_available_Balance;



























}
