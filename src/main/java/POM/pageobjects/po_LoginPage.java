package POM.pageobjects;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class po_LoginPage extends po_BaseClass {

	public po_LoginPage(WebDriver driver) {
		super(driver);
	}

	/*
	* GTB eCorp BO
	* */
	@FindBy(how = How.XPATH, using = "//*[@id='txtUserId']")
	public static WebElement GTBeCorpBO_UserID;

	@FindBy(how = How.XPATH, using = "//*[@id='txtUserPassword']")
	public static WebElement GTBeCorpBO_Password;

	@FindBy(how = How.ID, using = "//*[@id='button']")
	public static WebElement GTBeCorpBO_LoginBtn;

	@FindBy(how = How.CSS, using = "#dialog-modal > table > tbody > tr:nth-child(2) > td > a:nth-child(2)")
	public static WebElement GTBeCorpBO_KillPreviousSession;

	@FindBy(how = How.XPATH, using = "//a[text()='IGTBAE']")
	public static WebElement GTBeCorpBO_IGTBAE;

	@FindBy(how = How.XPATH, using = "//*[@name='maintop']")
	public static WebElement GTBeCorpBO_MainPageFrame;


	@FindAll({
			@FindBy(how = How.XPATH, using = "//frame[1]")
	})
	public static List<WebElement> GTBeCorpBO_MainPageFrame_All;

	@FindBy(how = How.XPATH, using = "//*[@id='rootMenu']")
	public static WebElement GTBeCorpBO_MenuBtn;

	@FindBy(how = How.XPATH, using = "//div[@id='secondpage_02']/span[@class='txt_style06']")
	public static WebElement GTBeCorpBO_WelcomeToGIBeBank;

	@FindBy(how = How.CSS, using = "//a[@id='logout']")
	public static WebElement GTBeCorpBO_MenuLogout;

	@FindBy(how = How.CSS, using = "#dialog-modal > table > tbody > tr:nth-child(2) > td > a")
	public static WebElement GTBeCorpBO_Close;

	/*
	* UBS
	* */

	@FindBy(how = How.ID, using = "ifr_AlertWin")
	public static WebElement UBS_iFrameLoginOkBtn;

	@FindBy(how = How.ID, using = "BTN_OK")
	public static WebElement UBS_LoginOKBtn;

	@FindBy(how = How.ID, using = "USERID")
	public static WebElement UBS_UserID;

	@FindBy(how = How.ID, using = "PASSWORD")
	public static WebElement UBS_PASSWORD;

	@FindBy(how = How.ID, using = "fc_sbmit")
	public static WebElement UBS_LoginBtn;

	@FindBy(how = How.ID, using = "BTN_OK")
	public static WebElement UBS_AfterLoginOKBtn;

	/*
	* GTB eCorp FO
	* */

	@FindBy(how = How.ID, using = "customerId")
	public static WebElement GTBeCorpFO_CorpID;

	@FindBy(how = How.ID, using = "userNo")
	public static WebElement GTBeCorpFO_UserID;

	@FindBy(how = How.ID, using = "userPin")
	public static WebElement GTBeCorpFO_Password;

	@FindBy(how = How.CSS, using = "#content > tbody > tr:nth-child(5) > td > div > table > tbody > tr > td:nth-child(2) > a:nth-child(1)")
	public static WebElement GTBeCorpFO_SubmitBtn;

	@FindBy(how = How.ID, using = "OTP_Number")
	public static WebElement GTBeCorpFO_OtpNumber;

	@FindBy(how = How.CSS, using = "#content > tbody > tr:nth-child(5) > td > div > table > tbody > tr > td:nth-child(2) > a:nth-child(1)")
	public static WebElement GTBeCorpFO_OtpVerifyLink;

	@FindBy(how = How.CSS, using = "#footer_Items > ul > li > a")
	public static WebElement GTBeCorpFO_SignOff;

	@FindBy(how = How.XPATH, using = "//button[contains(.,'Yes')]")
	public static WebElement GTBeCorpFO_SignOff_YesBtn;

//	@FindBy(how = How.ID, using = "ext-gen171")
//	public static WebElement GTBeCorpFO_SignOff_OkBtn;

	/*
	* UBS Login page
	* */

	@FindBy(how = How.ID, using = "ifr_AlertWin")
	public static WebElement Frame_LoginPage;

	@FindBy(how = How.XPATH, using = "//button[@id='BTN_OK']")
	public static WebElement Button_UBSLoginPage_Ok;

	@FindBy(how = How.ID, using = "USERID")
	public static WebElement Input_UBSLoginPage_UserID;

	@FindBy(how = How.ID, using = "PASSWORD")
	public static WebElement Input_UBSLoginPage_Password;

	@FindBy(how = How.XPATH, using = "//*[@id='fc_sbmit']")
	public static WebElement Button_UBSLoginPage_Submit;

	@FindBy(how = How.ID, using = "//*[@id='ifr_LaunchWin']")
	public static WebElement UBS_Frame;


	@FindBy(how = How.XPATH, using = "//*[@id='userloginform:userName']")
	public static WebElement GTX_user_id;

	@FindBy(how = How.XPATH, using = "//*[@id='userloginform:password']")
	public static WebElement GTX_user_password;

	@FindBy(how = How.XPATH, using = "//*[@id='userloginform:loginAction']")
	public static WebElement GTX_login_button;

	@FindBy(how = How.CSS, using = "#btnSignOff")
	public static WebElement Button_UBS_SignOff;

	/********************************RDI-IB Login **************************************************************************/

	@FindBy(how = How.XPATH, using = "//input[@id='txtIqama']")
	public static WebElement Input_RDILogin_UserID;

	@FindBy(how = How.XPATH, using = "//input[@id='txtPassword']")
	public static WebElement Input_RDILogin_Password;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	public static WebElement Button_RDI_Login;

	@FindBy(how = How.XPATH, using = "//a[contains(.,'Log Out')]")
	public static WebElement Button_RDI_LogOut;

	@FindBy(how = How.CLASS_NAME, using = "MaskedPassword")
	public static WebElement Input_AuthenticationCode;


}
		

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
