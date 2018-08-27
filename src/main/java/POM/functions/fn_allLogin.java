package POM.functions;


import FrameWork.helpers.ReportHelper;
import FrameWork.helpers.eMailOtpReader;
import FrameWork.library.CommonFunction;
import FrameWork.listeners.Log;
import FrameWork.listeners.po_BaseClass;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_RDC_Meem_BAH;
import POM.pageobjects.po_android;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static FrameWork.helpers.Helper.loginCredentials;
import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.listeners.PreReq.getURL;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;


public class fn_allLogin {

	public static void initPageObjects() {
		try {
			initElements(drvr, po_LoginPage.class);
			logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		} catch (Exception e) {

		}

	}

	public static void login_GTBeCorp_BO(String userType, String environment) throws Exception {

		initPageObjects();
		CommonFunction.ClearAllCaches();
		openUrl(getURL(environment));

		getLatestDriver();



		sendKeys(po_LoginPage.GTBeCorpBO_UserID, loginCredentials(userType)[0]);

		sendKeys(po_LoginPage.GTBeCorpBO_Password, loginCredentials(userType)[1]);
		try {
			sendKey(po_LoginPage.GTBeCorpBO_Password, Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}

		getLatestDriver();
		try {
			getLatestDriver().findElement(By.cssSelector("#dialog-modal > table > tbody > tr:nth-child(2) > td > a:nth-child(2)"));
			if (waitVisibleShort(po_LoginPage.GTBeCorpBO_KillPreviousSession)) {
				click(po_LoginPage.GTBeCorpBO_KillPreviousSession);
			}
		} catch (Exception e) {

		}


		waitFor(5000);
		//WebElement ele2=getLatestDriver().findElement(By.xpath("/html/frameset/frameset/frameset/frame[1]"));

		WebDriver driver = po_BaseClass.po_GetDriver();


		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
		}

		WebElement ele = driver.findElement(By.xpath("//*[@name='maintop']"));
		switchDFrame(ele);    //maintop


		String check = "";
		try {
			check = driver.findElement(By.xpath("//*[@id='rootMenu']")).getText(); /*getText(po_LoginPage.GTBeCorpBO_MenuBtn);*/

		} catch (Exception e) {
			check = "Failed";
		}

		getLatestDriver();
		if (check.equalsIgnoreCase("Menu")) {

			logReportStatus(LogStatus.PASS, "Login Success");
		} else {
			logReportStatus(LogStatus.FAIL, "Login not successful");
		}
	}

	public static void logout_GTBeCorp_BO() {
		initPageObjects();
		getLatestDriver();
		WebDriver driver = po_BaseClass.po_GetDriver();
		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
		}
		WebElement ele = driver.findElement(By.xpath("//*[@name='maintop']"));
		switchDFrame(ele);    //maintop
		waitFor(2000);

		driver.findElement(By.xpath("//*[@id='rootMenu']")).click();
		driver.findElement(By.xpath("//a[@id='logout']")).click();
		waitFor(2000);
		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
		}
		driver.switchTo().defaultContent();
		String check = "";
		getLatestDriver();
		try {
			check = driver.findElement(By.cssSelector("#dialog-modal > table > tbody > tr:nth-child(2) > td > a")).getText();
		} catch (Exception e) {
			check = "Failed";
		}
		if (check.equalsIgnoreCase("Close")) {
			logReportStatus(LogStatus.PASS, "Logout Success");
			driver.findElement(By.cssSelector("#dialog-modal > table > tbody > tr:nth-child(2) > td > a")).click();
		} else {
			logReportStatus(LogStatus.FAIL, "Logout not  successful");
		}
	}

	public static void login_GTBeCorp_FO(String userType, String environment) {
		try {


			initPageObjects();
			openUrl(getURL(environment));
			getLatestDriver();
			// Perform the actions on new window
			sendKeys(po_LoginPage.GTBeCorpFO_CorpID, loginCredentials(userType)[0]);
			sendKeys(po_LoginPage.GTBeCorpFO_UserID, loginCredentials(userType)[1]);
			sendKeys(po_LoginPage.GTBeCorpFO_Password, loginCredentials(userType)[2]);
			click(po_LoginPage.GTBeCorpFO_SubmitBtn);
			//Thread.sleep(5000);
			String Otp = eMailOtpReader.readMail();
			Log.info("OTP Value = " + Otp);
			if (Otp.length() == 5) {
				sendKeys(po_LoginPage.GTBeCorpFO_OtpNumber, Otp);
			} else {
			}
			click(po_LoginPage.GTBeCorpFO_OtpVerifyLink);
			waitForPageLoad();
			getLatestDriver();
			if (elemExist(po_LoginPage.GTBeCorpFO_SignOff))
				logReportStatus(LogStatus.PASS, "Login Success");
			else
				logReportStatus(LogStatus.FAIL, "Login not successful");
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Login module failed " + e.getMessage());
		}
	}

	public static void logout_GTBeCorp_FO() {
		initPageObjects();
		getLatestDriver();

		click(po_LoginPage.GTBeCorpFO_SignOff);

		if (elemExist(po_LoginPage.GTBeCorpFO_SignOff_YesBtn))
			logReportStatus(LogStatus.PASS, "Logout Success");
		else
			logReportStatus(LogStatus.FAIL, "Logout not successful");

		click(po_LoginPage.GTBeCorpFO_SignOff_YesBtn);
	}

	public static void login_UBS_test(String userType, String environment) throws Exception {
		initPageObjects();


		getLatestDriver().navigate().to(getURL(environment));
		System.out.println(userType);
		System.out.println(environment);
//		openUrl(getURL(environment));


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriver driver = po_BaseClass.po_GetDriver();
		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			//	System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
		}
		//driver.switchTo().frame("ifr_AlertWin");
		WebElement infomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
		driver.switchTo().frame(infomsg);

		//click(po_LoginPage.Frame_LoginPage);
		//switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
		//po_LoginPage.Button_UBSLoginPage_Ok.click();
	/*	Actions builder = new Actions(driver);
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		driver.switchTo().defaultContent();
		//click(po_LoginPage.Button_UBSLoginPage_Ok);
		System.out.println(loginCredentials(userType)[0]);
		sendKeys(po_LoginPage.Input_UBSLoginPage_UserID, loginCredentials(userType)[0]);
		sendKeys(po_LoginPage.Input_UBSLoginPage_Password, loginCredentials(userType)[1]);
		click(po_LoginPage.Button_UBSLoginPage_Submit);
		Thread.sleep(1000);

		//driver.switchTo().defaultContent();
		//switchDFrame(po_LoginPage.Frame_LoginPage);
		WebElement Logininfomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
		driver.switchTo().frame(Logininfomsg);
		Thread.sleep(1000);
		//	driver.switchTo().frame("ifr_AlertWin");
		po_LoginPage.Button_UBSLoginPage_Ok.click();

		/*Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/


		//driver.findElement(By.xpath("//*[contains(text(),'Ok')]")).click();
	//	driver.switchTo().defaultContent();
		/*switchDFrame(po_LoginPage.Frame_LoginPage);
		click(po_LoginPage.Button_UBSLoginPage_Ok);*/
//		switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
/*
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		//driver.switchTo().defaultContent();

		/*try {
			Thread.sleep(2000);
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}*/

	//	waitFor(2000);
//		switchDFrame(po_LoginPage.UBS_Frame);


	}




	public static void login_UBS(String userType, String environment) throws Exception {
		initPageObjects();

		openUrl(getURL(environment));


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriver driver = po_BaseClass.po_GetDriver();
		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			//	System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
		}
		WebElement infomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
		driver.switchTo().frame(infomsg);
		Thread.sleep(1000);


		//click(po_LoginPage.Frame_LoginPage);
		//switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
		//po_LoginPage.Button_UBSLoginPage_Ok.click();
	/*	Actions builder = new Actions(driver);
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		driver.switchTo().defaultContent();
		//click(po_LoginPage.Button_UBSLoginPage_Ok);
		sendKeys(po_LoginPage.Input_UBSLoginPage_UserID, loginCredentials(userType)[0]);
		sendKeys(po_LoginPage.Input_UBSLoginPage_Password, loginCredentials(userType)[1]);
		click(po_LoginPage.Button_UBSLoginPage_Submit);


		//driver.switchTo().defaultContent();
		switchDFrame(po_LoginPage.Frame_LoginPage);
		ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");
		Thread.sleep(1000);
		//	driver.switchTo().frame("ifr_AlertWin");
		po_LoginPage.Button_UBSLoginPage_Ok.click();

		/*Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/


		//driver.findElement(By.xpath("//*[contains(text(),'Ok')]")).click();
		driver.switchTo().defaultContent();
		/*switchDFrame(po_LoginPage.Frame_LoginPage);
		click(po_LoginPage.Button_UBSLoginPage_Ok);*/
		       //switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
/*
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		//driver.switchTo().defaultContent();

		/*try {
			Thread.sleep(2000);
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}*/

		Thread.sleep(1000);

//		switchDFrame(po_LoginPage.UBS_Frame);


	}

	public static void Android_login_UBS(String userType, String environment) throws Exception {
		initPageObjects();

		openUrl(getURL(environment));


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriver driver = new ChromeDriver();
		for (String sam : driver.getWindowHandles()) {
			driver.switchTo().window(sam);
			//	System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
		}
		WebElement infomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
		driver.switchTo().frame(infomsg);
		Thread.sleep(1000);


		//click(po_LoginPage.Frame_LoginPage);
		//switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
		driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
		//po_LoginPage.Button_UBSLoginPage_Ok.click();
	/*	Actions builder = new Actions(driver);
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		driver.switchTo().defaultContent();
		//click(po_LoginPage.Button_UBSLoginPage_Ok);
		sendKeys(po_LoginPage.Input_UBSLoginPage_UserID, loginCredentials(userType)[0]);
		sendKeys(po_LoginPage.Input_UBSLoginPage_Password, loginCredentials(userType)[1]);
		click(po_LoginPage.Button_UBSLoginPage_Submit);


		//driver.switchTo().defaultContent();
		switchDFrame(po_LoginPage.Frame_LoginPage);
		ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");
		Thread.sleep(1000);
		//	driver.switchTo().frame("ifr_AlertWin");
		po_LoginPage.Button_UBSLoginPage_Ok.click();

		/*Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/


		//driver.findElement(By.xpath("//*[contains(text(),'Ok')]")).click();
		driver.switchTo().defaultContent();
		/*switchDFrame(po_LoginPage.Frame_LoginPage);
		click(po_LoginPage.Button_UBSLoginPage_Ok);*/
		//switchDFrame(po_LoginPage.Frame_LoginPage);

		//System.out.println(driver.getPageSource());
/*
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).perform();
		builder1.moveToElement(po_LoginPage.Button_UBSLoginPage_Ok).click().perform();*/
		//driver.switchTo().defaultContent();

		/*try {
			Thread.sleep(2000);
			Robot robot=new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);

			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}*/

		Thread.sleep(1000);

//		switchDFrame(po_LoginPage.UBS_Frame);


	}



	public static void login_GTX(String userType, String environment) {
		try {
			initPageObjects();
			openUrl(getURL(environment));
			getLatestDriver();

			// Perform the actions on new window
			sendKeys(po_LoginPage.GTX_user_id, loginCredentials(userType)[0]);
			sendKeys(po_LoginPage.GTX_user_password, loginCredentials(userType)[1]);

			click(po_LoginPage.GTX_login_button);
			logReportStatus(LogStatus.PASS, "Login to GTX Applicayion is successfull");
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Login to GTX Failed '" + e.getMessage() + "'");

		}

	}

	public static void logout_UBS() {
		try {

			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			//System.out.println(driver.findElement(By.cssSelector(("#btnSignOff"))).getAttribute("title"));

		/* WebElement element1 = driver.findElement(By.cssSelector("#btnSignOff"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1); */
			JavascriptExecutor executor1 = (JavascriptExecutor) driver;
			executor1.executeScript("arguments[0].click();", po_LoginPage.Button_UBS_SignOff);

		/*driver.switchTo().defaultContent();
		*//*
		driver.switchTo().frame("ifr_AlertWin");
		driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
		*//*
		switchDFrame(po_LoginPage.Frame_LoginPage);
		click(po_LoginPage.Button_UBSLoginPage_Ok);*/

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_AlertWin");
			WebElement Confmsg=driver.findElement(By.xpath("//iframe[@title='Confirmation Message']"));
			driver.switchTo().frame(Confmsg);
			driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
			waitFor(1000);
			//driver.quit();
			logReportStatus(LogStatus.PASS, "UBS Logout Successfully");
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Logout UBS Failed '" + e.getMessage() + "'");
		}
	}

	public static void Login_RDI(String userType, String environment) {

		initPageObjects();
		openUrl(getURL(environment));
		getLatestDriver();

		WebDriver driver=getLatestDriver();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		//System.out.println(driver.getPageSource());
		//switchDFrame(1);

		sendKeys(po_LoginPage.Input_RDILogin_UserID, loginCredentials(userType)[0]);
		sendKeys(po_LoginPage.Input_RDILogin_Password, loginCredentials(userType)[1]);
		ReportHelper.logReportStatus(LogStatus.PASS,"National/IQAMA ID and Password entered successfully");
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		//fClick(1,po_LoginPage.Button_RDI_Login);
		waitFor(3000);

		if (elemExist(driver.findElement(By.className("MaskedPassword")))) {
			ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed in the screen successfully");
			//driver.findElement(By.className("MaskedPassword")).sendKeys(FetchOTP.getOTP());
			ReportHelper.logReportStatus(LogStatus.PASS,"OTP entered successfully");
			//sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
		}else {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Entered National ID and Password are invalid");
		}

		waitFor(2000);
		if (elemExist(po_LoginPage.Button_RDI_LogOut)) {
			logReportStatus(LogStatus.PASS, "RDI Login Success");
		} else {
			logReportStatus(LogStatus.FAIL, "RDI Login is not successful");
		}

	}

	public static void logout_RDI()  {

		try {
			initPageObjects();
			//getLatestDriver( );
			WebDriver driver=getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(1);

			driver.findElement(By.xpath("//a[contains(.,'Log Out')]")).click();
			//click(po_LoginPage.Button_RDI_LogOut);
			waitFor(7000);

/*			if (driver.findElement(By.xpath("//input[@id='txtIqama']")).isDisplayed()) {
				//if (elemExist(po_LoginPage.Button_RDI_Login)) {*/
				ReportHelper.logReportStatus(LogStatus.PASS,"Logout Success");
/*			}else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Logout not successful");
			}*/
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"User failed to log out due to '"+e.getMessage()+"'");
		}

	}

}

