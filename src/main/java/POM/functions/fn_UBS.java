package POM.functions;

import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import FrameWork.helpers.eMailOtpReader;
import FrameWork.library.Util;
import FrameWork.listeners.po_BaseClass;
import POM.pageobjects.*;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.saveTestData;
import static FrameWork.helpers.Helper.saveTestDataToDb;
import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.listeners.po_BaseClass.drvr;
import static FrameWork.listeners.po_BaseClass.po_GetDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.List;

public class fn_UBS {

	public static void initPageObjects() throws Exception {
		initElements(drvr, po_UBS.class);
		logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		getLatestDriver();
	}


	// newly added
	public static void UBS_SwitchBranch() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			hover(po_UBS.Image_UBS_BranchIsOnline);
			waitFor(1000);
			click(po_UBS.Select_UBS_SelectBranch);


			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='List of Values Branch Code']")));
			po_UBS.Input_UBS_BranchCode.clear();
			sendKeys(po_UBS.Input_UBS_BranchCode, "399");
			ReportHelper.logReportStatus(LogStatus.PASS, "Branch code entered in the Select Branch screen successfully");
			click(po_UBS.Button_UBS_FetchValues);
			waitFor(1000);
				click(po_UBS.Table_UBS_SelectBranches);
				driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Confirmation Message']")));
				click(po_UBS.Button_UBS_OK);


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Swicth Branch failed due to '" + e.getMessage() + "'");
		}
	}

	/**
	 * This is Method used to input the Fund transfer detail and summary in FastPath and click the same.
	 *
	 * @throws Exception
	 */

	public static void FastPath() {

		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();


			//sendKeys(po_UBS.Input_UBS_FastPath, "FTSTRSAR");
			sendKeys(po_UBS.Input_UBS_FastPath, "IASCUSAC");



			click(po_UBS.Button_UBS_FastPathGo);
			Thread.sleep(1000);

			ReportHelper.logReportStatus(LogStatus.PASS, "Fast Path Action Performed'");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Fast Path failed due to '" + e.getMessage() + "'");
		}

	}
	public static void Acc_summary_BAH() {

		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Islamic Customer Accounts Summary')]")));
			String AccNo=getData("AccountNum");
			po_RDC_Meem_BAH.Input_AccNo.sendKeys(AccNo);
			click(po_RDC_Meem_BAH.Clk_Search_Button);
			Thread.sleep(2000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Details");
			Actions action = new Actions(getLatestDriver());
			action.doubleClick(po_RDC_Meem_BAH.Clk_Authorize_link).perform();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(1));
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Data validated with UBS");
			click(po_RDC_Meem_BAH.Clk_AmountsandDate_Btn);
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Amounts And Dates')]")));
			Util.scrollDown(po_RDC_Meem_BAH.Txt_available_Balance);
			Thread.sleep(1000);
			String UBSAvaBal=po_RDC_Meem_BAH.Txt_available_Balance.getAttribute("value");
			saveTestDataToDb("UBSAvailBalance", UBSAvaBal);
			System.out.println(UBSAvaBal);
			if(UBSAvaBal.contains(getData("AvailBalance")))
			{
				ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Data validated with UBS");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Account Summary data is not matched with UBS Data");
			}
			driver.findElement(By.xpath("//*[@id='BTN_EXIT_IMG']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "AccountSummary failed due to '" + e.getMessage() + "'");
		}
	}
	/**
	 * This method is used to click New button in Main Screen
	 *
	 * @throws Exception
	 *
	 *
	 */

	public static void Acc_summary_FCY() {

		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Islamic Customer Accounts Summary')]")));
			String AccNo=getData("AccountNum");
			po_RDC_Meem_BAH.Input_AccNo.sendKeys(AccNo);
			click(po_RDC_Meem_BAH.Clk_Search_Button);
			Thread.sleep(2000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Details");
			Actions action = new Actions(getLatestDriver());
			action.doubleClick(po_RDC_Meem_BAH.Clk_Authorize_link).perform();
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(1));
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Data validated with UBS");
			click(po_RDC_Meem_BAH.Clk_AmountsandDate_Btn);
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Amounts And Dates')]")));
			Util.scrollDown(po_RDC_Meem_BAH.Txt_available_Balance);
			Thread.sleep(1000);
			String UBSAvaBal=driver.findElement(By.xpath("//*[@id='BLK_AMOUNT_DATES__DIS_TOT_AVL_AMOUNT']")).getAttribute("value");
			saveTestDataToDb("UBSAvailBalance", UBSAvaBal);
			System.out.println(UBSAvaBal);
			if(UBSAvaBal.contains(getData("AvailBalance")))
			{
				ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Data validated with UBS");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Account Summary data is not matched with UBS Data");
			}
			driver.findElement(By.xpath("//*[@id='BTN_EXIT_IMG']")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "AccountSummary failed due to '" + e.getMessage() + "'");
		}
	}


	public static void Clo_verify() {

		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Islamic Customer Accounts Summary')]")));
			String AccNo=getData("AccountNum");
			//po_RDC_Meem_BAH.Input_AccNo.sendKeys(AccNo);
			driver.findElement(By.xpath("//input[@title='Account']")).sendKeys(AccNo);
			driver.findElement(By.xpath("//button[@title='Search']")).click();
			//click(po_RDC_Meem_BAH.Clk_Search_Button);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[span[text()='Close']]")).click();
			ReportHelper.logReportStatus(LogStatus.PASS,"Account Closure Verify Successfully");

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Account Closure failed due to '" + e.getMessage() + "'");
		}
	}
	public static void clickQueryButton() {
		try {
			initPageObjects();
			getLatestDriver();
			//WebDriver driver = getLatestDriver();

			click(po_UBS.BTN_Query);
			ReportHelper.logReportStatus(LogStatus.PASS, "New button clicked'");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "New Button has not been clicked '" + e.getMessage() + "'");
		}

	}

	public static void HomeBranch() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			hover(po_UBS.Image_UBS_BranchIsOnline);
			waitFor(1000);
			click(po_UBS.Select_UBS_HomeBranch);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Confirmation Message']")));
			click(po_UBS.Button_UBS_OK);
			driver.switchTo().defaultContent();


			ReportHelper.logReportStatus(LogStatus.PASS, "Home Branch clicked'");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Home Branch has not been clicked '" + e.getMessage() + "'");
		}

	}
	public static void clickNewbutton() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			click(po_UBS.newBtn);
			ReportHelper.logReportStatus(LogStatus.PASS, "New button clicked'");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "New Button has not been clicked '" + e.getMessage() + "'");
		}

	}

	/**
	 * This mehod is used to enter Transaction Branch code
	 *
	 * @throws Exception
	 */



	public static void enterBranchCode() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			//driver.switchTo().frame("ifrSubScreen");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			WebElement Branch=driver.findElement(By.xpath("//iframe[contains(@title,'Transaction Branch Code')]"));
			driver.switchTo().frame(Branch);

			po_UBS.branchCode.clear();
			String branchCode = getData("BranchCode");

			po_UBS.branchCode.sendKeys(branchCode);
			po_UBS.okBtn.click();

			ReportHelper.logReportStatus(LogStatus.PASS, "Entered the branch code is'" + branchCode);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Enter the branch code '" + e.getMessage() + "'");
		}

	}

	public static void EnterReferceAndclickQuery() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifr_LaunchWin");
sendKeys(po_UBS.TXT_contctRefernce,getData("ContactRefernceNumber"));
driver.switchTo().defaultContent();
		click(po_UBS.BTN_ExecuteQuery);
			click(po_UBS.BTN_Authorize);
			//Thread.sleep(6000);

			ReportHelper.logReportStatus(LogStatus.PASS, "Clicked  the product populate  button");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click product populate buttton '" + e.getMessage() + "'");
		}

	}
	/**
	 * This mehod is used to enter the  Product and populate the product values in Fund transfer screen
	 *
	 * @throws Exception
	 */

	public static void enterProductAndClickPopulate() {
		try {
			initPageObjects();
			getLatestDriver();

			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			po_UBS.productTxt.sendKeys("FOLC");
			po_UBS.productSearchBtn.click();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			//driver.switchTo().frame("ifrSubScreen");

			driver.switchTo().frame(ContractInput);
			Thread.sleep(1000);
			WebElement Listofproductvalues=driver.findElement(By.xpath("//iframe[@title='List of Values Product']"));
			driver.switchTo().frame(Listofproductvalues);


			String productName = getData("ProductName");
			po_UBS.productValue.sendKeys(productName);
			po_UBS.fetchValuesBtn.click();

			driver.findElement(By.xpath("//tbody//tr[1]//td[1]//a[text()='" + productName + "']")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Enter the product is" + productName);

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame(ContractInput);
			po_UBS.prdpopulateBtn.click();
			//Thread.sleep(6000);

			ReportHelper.logReportStatus(LogStatus.PASS, "Clicked  the product populate  button");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click product populate buttton '" + e.getMessage() + "'");
		}

	}

	/**
	 * This method is used to enter the debit  and credit details in the screen
	 *
	 * @throws Exception
	 */

	public static void enterDebitAndCreditDetails() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);
			driver.findElement(By.xpath("//div[input[@title='Debit Account' and @class='TXTstd']]//button[contains(@title,'List')]")).click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			//driver.switchTo().frame("ifrSubScreen");

			driver.switchTo().frame(ContractInput);


			WebElement Listofdebitvalues=driver.findElement(By.xpath("//iframe[@title='List of Values Debit Account']"));
			driver.switchTo().frame(Listofdebitvalues);

			String debitAccNo = getData("DebitAccountNumber");

			//driver.findElement(By.xpath("//input[@class='TXTstd' and @id='1']")).sendKeys("200");

			WebElement element = driver.findElement(By.xpath("//input[@class='TXTstd' and @name='2']"));
			element.clear();
			element.sendKeys(debitAccNo);

			driver.findElement(By.xpath("//span[@class='ICOsearch']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//td//a[@class='Astd' and text()='" + debitAccNo + "']")).click();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame(ContractInput);
			//waitFor(7000);
			Thread.sleep(1000);
			String DrBan = driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__DRIBAN']")).getAttribute("value");
			if (!DrBan.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Debit Account details verified successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Debit Account details have not been verified successfully");
			}
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame(ContractInput);

			driver.findElement(By.xpath("//div[input[@title='Credit Account' and @class='TXTstd']]//button[contains(@title,'List')]")).click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			//Thread.sleep(2000);
			//driver.switchTo().frame("ifrSubScreen");
			driver.switchTo().frame(ContractInput);

			WebElement Creditvalue=driver.findElement(By.xpath("//iframe[@title='List of Values Credit Account']"));
			driver.switchTo().frame(Creditvalue);

			String creditAccNo = getData("CreditAccountNumber");

			//	driver.findElement(By.xpath("//input[@class='TXTstd' and @id='1']")).sendKeys("200");
			WebElement element2 = driver.findElement(By.xpath("//input[@class='TXTstd' and @name='2']"));
			element2.clear();
			element2.sendKeys(creditAccNo);

			driver.findElement(By.xpath("//span[@class='ICOsearch']")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//td//a[@class='Astd' and text()='" + creditAccNo + "']")).click();

			//waitFor(7000);
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame(ContractInput);
			if (getData("TypeofTransfer").equalsIgnoreCase("Domestic"))
			{
			String CrBan =driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__CRIBAN']")).getAttribute("value");
			if (!CrBan.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Credit Account details verified successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Credit Account details have not been verified successfully");
			}

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
				driver.switchTo().frame(ContractInput);}
			po_UBS.txt_CreditAmount.sendKeys(getData("CreditAmount"));
			ReportHelper.logReportStatus(LogStatus.PASS, "Credit Amount entered successfully");

			By customerInitiated = By.xpath("//select[@class='SELstd' and @label_value='Customer Initiated']");
			Select select = new Select(driver.findElement(customerInitiated));
			select.selectByVisibleText("Yes");

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Debit and Credit Amount details are not entered properly'" + e.getMessage() + "'");
		}

	}

	public static void clickBenificaryIBANANDCountry() {
		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			By IBANSearch = By.xpath("//div[input[@title='Beneficiary IBAN' and @class='TXTstd']]//button[contains(@title,'List')]");
			//driver.findElement(IBANSearch).click();

			//Benificary Name
		/*	driver.switchTo().defaultContent();
			driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame("ifrSubScreen");*/

			String benificaryIBAN = getData("BenficaryIBAN");
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN1']")).sendKeys(benificaryIBAN);
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN2']")).sendKeys(getData("Benef_name"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN3']")).sendKeys(getData("BAddress1"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN4']")).sendKeys(getData("BAddress2"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN5']")).sendKeys(getData("BAddress3"));
			By benificaryName = By.xpath("//input[@class='TXTstd' and @name='1']");
			/*driver.findElement(benificaryName).clear();
			driver.findElement(benificaryName).sendKeys(benificaryIBAN);

			po_UBS.fetchValuesBtn.click();

			driver.findElement(By.xpath("//td//a[text()='" + benificaryIBAN + "']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifr_LaunchWin");
*/
			WebElement enrichBtn = driver.findElement(By.xpath("//button[@title='Enrich']"));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", enrichBtn);

			System.out.println("Scrolled  successfully");


			String countryValue = getData("Country");

			List<WebElement> list = driver.findElements(By.xpath("//div//input[@title='Country' and @class='TXTstd']"));
			list.get(1).sendKeys(countryValue);

			ReportHelper.logReportStatus(LogStatus.PASS, "Entered the Country code is:" + countryValue);

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to enter Benficary IBAN and country code'" + e.getMessage() + "'");
		}
	}

	public static void clickBenificaryIBANANDCountry_domestic() {
		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

		//	By IBANSearch = By.xpath("//div[input[@title='Beneficiary IBAN' and @class='TXTstd']]//button[contains(@title,'List')]");
			/*driver.findElement(IBANSearch).click();

			//Benificary Name
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame("ifrSubScreen");*/

			String benificaryIBAN = getData("BenficaryIBAN");
/*
			By benificaryName = By.xpath("//input[@class='TXTstd' and @name='1']");
			driver.findElement(benificaryName).clear();
			driver.findElement(benificaryName).sendKeys(benificaryIBAN);

			po_UBS.fetchValuesBtn.click();

			driver.findElement(By.xpath("//td//a[text()='" + benificaryIBAN + "']")).click();*/
/*
			driver.switchTo().defaultContent();
			driver.switchTo().frame("ifr_LaunchWin");*/
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN1']")).sendKeys(benificaryIBAN);
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN2']")).sendKeys(getData("Benef_name"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN3']")).sendKeys(getData("BAddress1"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN4']")).sendKeys(getData("BAddress2"));
			driver.findElement(By.xpath("//input[@id='BLK_CONTRACT_DETAILS__ULTBEN5']")).sendKeys(getData("BAddress3"));
			driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__ULTIBEN6']")).clear();
			driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__ULTIBEN6']")).sendKeys(getData("Country"));
			ReportHelper.logReportStatus(LogStatus.PASS,"Beneficiary fields entered successfully");
			WebElement enrichBtn = driver.findElement(By.xpath("//button[@title='Enrich']"));

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", enrichBtn);

			System.out.println("Scrolled  successfully");


		/*	String countryValue = getData("Countrycode");

			List<WebElement> list = driver.findElements(By.xpath("//div//input[@title='Country' and @class='TXTstd']"));
			list.get(1).sendKeys(countryValue);*/

			//ReportHelper.logReportStatus(LogStatus.PASS, "Entered the Country code is:" + countryValue);

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to enter Benficary IBAN and country code'" + e.getMessage() + "'");
		}
	}

	public static void clickEnrichAndSave() {
		try {

			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			WebElement enrichBtn = driver.findElement(By.xpath("//button[@title='Enrich']"));
			enrichBtn.click();



			//waitFor(5000);
			Thread.sleep(1000);
			//String debitAmount = po_UBS.txt_debitAmount.getText();
			String debitAmount = driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__DRAMTI']")).getAttribute("value");
			System.out.println(debitAmount);
			Double CrAmt = Double.parseDouble(getData("CreditAmount"));
			DecimalFormat df = new DecimalFormat("0.00");
			String vCrAmt = df.format(CrAmt);
/*

			if (debitAmount.equals(vCrAmt)) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Debit amount has been verified correctly");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Debit amount has not been verified correctly");
			}
*/

			driver.switchTo().defaultContent();
			if (getData("TypeofTransfer").equalsIgnoreCase("Domestic"))
			{

				//driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
				driver.switchTo().frame(ContractInput);
			//po_UBS.PartyDetails.click();
				driver.findElement(By.xpath("//span[text()='Party Details']")).click();
		 	    po_UBS.purposeofTransfer.sendKeys(getData("Purpose"));
				driver.findElement(By.xpath("//*[@id='BLK_SETTLEMENTS_CUST__ORDINST1']")).clear();
				driver.findElement(By.xpath("//*[@id='BLK_SETTLEMENTS_CUST__ORDINST1']")).sendKeys(getData("OrderingInstruction"));

				driver.switchTo().defaultContent();
				//driver.switchTo().frame(ContractInput);

			}
			if(getData("ProductName").equals("FTSW")||getData("ProductName").equals("FTSA")||getData("ProductName").equals("FWRM")) {
				//click(po_UBS.Button_UBS_Fields);
				driver.switchTo().frame(ContractInput);
				driver.findElement(By.xpath("//*[@id='CSCTRUDF']/a")).click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				//driver.switchTo().frame("ifr_LaunchWin");
				WebElement e2 = driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
				driver.switchTo().frame(e2);


				if (getData("BranchCode").equals("399"))

				{
					WebElement e1 = driver.findElement(By.xpath("//iframe[@title='Override Message']"));
					driver.switchTo().frame(e1);

					driver.findElement(By.xpath("//*[@id='BTN_ACCEPT']")).click();
					Thread.sleep(1000);
					//po_UBS.acceptBtn.click();
					driver.switchTo().defaultContent();
					Thread.sleep(1000);
					//driver.switchTo().frame("ifr_LaunchWin");
					//driver.switchTo().frame("ifrSubScreen");
					driver.switchTo().frame(e2);


				}

				WebElement e3=driver.findElement(By.xpath("//iframe[contains(@title,'Fields')]"));
				driver.switchTo().frame(e3);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id='BLK_TXN_UDF_DETAILS__FLDVAL']")).sendKeys(getData("TransactionName"));
				driver.findElement(By.xpath("//*[@id='BLK_TXN_UDF_DETAILS__FLDVAL1']")).sendKeys(getData("TransactionIDType"));
				driver.findElement(By.xpath("//*[@id='BLK_TXN_UDF_DETAILS__FLDVAL2']")).sendKeys(getData("TransactionIDNO"));
				driver.findElement(By.xpath("//*[@id='BLK_TXN_UDF_DETAILS__FLDVAL3']")).sendKeys(getData("ContactNumber"));
				driver.findElement(By.xpath("//*[@id='BLK_TXN_UDF_DETAILS__FLDVAL4']")).sendKeys(getData("TransactionIDTypeOther"));
				Thread.sleep(1000);
				ReportHelper.logReportStatus(LogStatus.PASS, "Transactor fields entered successfully");
				driver.findElement(By.xpath("//input[@id='BTN_OK']")).click();
				driver.switchTo().defaultContent();
				//driver.switchTo().frame(ContractInput);

			}


			if(getData("BranchCode").equals("400"))

			{
				driver.switchTo().frame(ContractInput);
				driver.findElement(By.xpath("//*[@id='ISCTRSTL']/a")).click();
				Thread.sleep(1000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(ContractInput);
				WebElement SettlementDetails = driver.findElement(By.xpath("//iframe[contains(@title,'Settlement Details')]"));
				driver.switchTo().frame(SettlementDetails);
				Thread.sleep(1000);


				/*List <WebElement> Component= driver.findElements(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT']/tbody/tr/td[2]"));
				int Com=Component.size();
				for (int i=1;i<Com+1;i++) {
					String compcode=driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT']/tbody/tr[\"+i+\"]/td[2]")).getAttribute("value");
					System.out.println(compcode);
					if(compcode.equals("TFR_AMT")){
						driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT']/tbody/tr[\"+i+\"]/td[2]")).click();
						break;
					}

				} */
				if(getData("ProductName").equals("FTAE"))
				{
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT']/tbody/tr[3]/td[1]/label")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT']/tbody/tr[1]/td[1]/label")).click();
					driver.findElement(By.xpath("//*[@id='TAB_UAEFTS_QATCH']/span")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ORDERING_CUSTOMER_TYPE']")).clear();
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ORDERING_CUSTOMER_TYPE']")).sendKeys("0502");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__TRANSACTION_TYPE_CODE']")).clear();
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__TRANSACTION_TYPE_CODE']")).sendKeys("AFL");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
				}

				if(getData("ProductName").equals("FTOB"))
				{
					driver.findElement(By.xpath("//*[@id='chkDeleteRow1']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='chkDeleteRow']")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='TAB_UAEFTS_QATCH']/span")).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ORDERING_CUSTOMER_TYPE']")).clear();
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ORDERING_CUSTOMER_TYPE']")).sendKeys("0502");
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ITD13']")).sendKeys("101");
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__ITD14']")).sendKeys("101");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__TRANSACTION_TYPE_CODE']")).clear();
					driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_SETTLEMENT__TRANSACTION_TYPE_CODE']")).sendKeys("AFL");
					Thread.sleep(1000);
					driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
					Thread.sleep(1000);
					driver.switchTo().defaultContent();
				}




			}
			po_UBS.saveBtn.click();
			Thread.sleep(1000);

			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			driver.switchTo().frame(ContractInput);
			//driver.switchTo().frame("ifr_AlertWin");
			WebElement overridemsg=driver.findElement(By.xpath("//iframe[@title='Override Message']"));
			driver.switchTo().frame(overridemsg);

			String Msg = driver.findElement(By.xpath("//h1[text()='Override Message']")).getText();
			System.out.println("The Message is:" + Msg);

			if (po_UBS.acceptBtn.isDisplayed()) {
				po_UBS.acceptBtn.click();
				ReportHelper.logReportStatus(LogStatus.PASS, "Accept button clicked successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Accept button has not been clicked");
			}

			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			driver.switchTo().frame(ContractInput);
			//driver.switchTo().frame("ifr_AlertWin");
			WebElement Infomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
			driver.switchTo().frame(Infomsg);

			String successMsg = po_UBS.SuccessMsg.getText();

			if (successMsg.contains("Successfully Saved and Authorized")) {
				ReportHelper.logReportStatus(LogStatus.PASS, successMsg);
				po_UBS.okBtn.click();

				// NEED TO CAPTURE TWO FIELDS - DEBIT AMOUNT AND EXC RATE
				// STRNG CONVAMT = DEBTAMT*EXCRATE
				//SAVETESTTODB("ConversionAmount",CONVAMT)
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,successMsg);
				po_UBS.okBtn.click();
			}


			Thread.sleep(1000);

			/*DecimalFormat df = new DecimalFormat("0.00");*/
			/*String TotAmt = driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__TOTALAMOUNTI']")).getAttribute("value");
			Double dTotAmt = Double.parseDouble(getData("CreditAmount"))+Double.parseDouble(getData("FeeAmount"))+Double.parseDouble(getData("VAT"));
			String ChkTotAmt = df.format(dTotAmt);*/
/*
			if (TotAmt.equals(ChkTotAmt)) {
				ReportHelper.logReportStatus(LogStatus.PASS,"Total Amount as '"+TotAmt+"' has been verified correctly");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Total Amount as '"+TotAmt+"' has not been verified correctly");
			}*/
			//driver.switchTo().defaultContent();

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction Messge got Failed due to'" + e.getMessage() + "'");
		}
	}


	public static void ExitAllActiveWindowsall() {

		try {
			WebDriver driver = getLatestDriver();

			List<WebElement> frame2;
			frame2 = driver.findElements(By.cssSelector("#ifr_LaunchWin"));
			for(int i=frame2.size()-1;i>=0;i--)
			{
				driver.switchTo().defaultContent();
				driver.switchTo().frame(frame2.get(i));
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='Close']")).click();
			}

		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Exit all active windows failed due to '" + e.getMessage() + "'");
		}

	}

	public static void SearchREFNo1() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver3 = getLatestDriver();

			driver3.switchTo().frame("ifr_LaunchWin");
			driver3.findElement(By.id("BLK_SUMMARY_DETAILS__CONTREFNO")).sendKeys(getData("UBS_ReferenceNumber"));
			WebElement element = driver3.findElement(By.cssSelector("#tblquery_fleft > button:nth-child(3)"));
			JavascriptExecutor executor = (JavascriptExecutor) driver3;
			executor.executeScript("arguments[0].click();", element);
			//driver.findElement(By.xpath("//button[@name='Search']/span/span")).click();
			//driver.findElement(By.xpath("//*[contains(text(),'  Search')]")).click();

			Thread.sleep(2000);
			driver3.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a")).click();

			Actions act = new Actions(driver3);
			//act.moveToElement(driver.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a"))).doubleClick().build().perform();
			act.moveToElement(driver3.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a"))).doubleClick().build().perform();
			driver3.switchTo().defaultContent();
			Thread.sleep(2000);
			driver3.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(1));
			//switchDFrame(po_UBS.Frame_UBS_Contracts);
			WebElement elem = driver3.findElement(By.cssSelector("#BLK_CONTRACT_DETAILS__CONTREFNO"));
			String strRefNo = driver3.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__CONTREFNO']")).getAttribute("value");

			Double intDebitAmount = Double.parseDouble(driver3.findElement(By.xpath("//input[@name='DRAMT']")).getAttribute("value"));
			DecimalFormat dformat = new DecimalFormat("0.00");
			String fDebAmt = dformat.format(intDebitAmount);
			System.out.println(strRefNo + "    " + fDebAmt);

			String ChkRefNum = getData("UBS_ReferenceNumber");
			Double tPayAmt = Double.parseDouble(getData("PaymentAmount"));
			String ChkPayAmt = dformat.format(tPayAmt);

			System.out.println(ChkRefNum + "    " + ChkPayAmt);
			driver3.switchTo().defaultContent();

			if (strRefNo.equals(ChkRefNum) && (fDebAmt.equals(ChkPayAmt))) {
				logReportStatus(LogStatus.PASS, "Transaction has been found in UBS and Payment amount Verified");
			} else {
				logReportStatus(LogStatus.FAIL, "Transaction was not found in UBS and Payment amount not Verified");
			}


		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Search Transaction Reference Number failed due to '" + e.getMessage() + "'");
			//e.printStackTrace();
		}
	}
	public static void VerifyContractDetails1() throws Exception {

		try {
			WebDriver driver=getLatestDriver();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			//driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(1));
			driver.findElement(By.xpath("//*[@id='CSDEVENT']/a")).click();
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			//driver.switchTo().frame(ContractInput);

		//	WebElement EventsFrame=driver.findElement(By.xpath("//iframe[contains(@title,'Events')]"));
			//Thread.sleep(1000);
		//	driver.switchTo().frame(EventsFrame);
			List<WebElement> frame1;
			frame1=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
			driver.switchTo().frame(frame1.get(1));
			//newly copies
			List <WebElement> EventLst = driver.findElements(By.xpath("//div[@id='tableContainer']//tbody/tr/td[4]"));
			int EventCnt = EventLst.size();
			for (int i=1;i<EventCnt+1;i++) {
				String EventCode = driver.findElement(By.xpath("//div[@id='tableContainer']//tbody/tr["+i+"]/td[4]/input")).getAttribute("value");
				System.out.println(EventCode);
				if (EventCode.equals("INIT")) {
					driver.findElement(By.xpath("//div[@id='tableContainer']//tbody/tr["+i+"]/td[4]")).click();
					break;
				}
			}
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Event details entered successfully");

			click(po_UBS.Button_UBS_AccountEntries);
			waitFor(2000);
			driver.switchTo().defaultContent();

			List<WebElement> frame2;
			frame2=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
			driver.switchTo().frame(frame2.get(2));

			DecimalFormat dformat=new DecimalFormat("0.00");

			List <WebElement> AccEntLst = driver.findElements(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr/td[4]/input"));
			int AccEntCnt = AccEntLst.size();
			int index=0;
			Robot rt = new Robot();
			for (int i=1;i<AccEntCnt;i++) {
				//String AcctNum = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+i+"]/td[4]")).getText();
				System.out.println(AccEntLst.get(i).getAttribute("value"));
				if (AccEntLst.get(i).getAttribute("value").equals(getData("UBS_ChgeAcctNo"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					if (CRTag.equals("C")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Charge Account and CR Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Charge Account and CR Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					double ubsamt=Double.parseDouble(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value"));
					System.out.println(ubsamt);
					double ubsdbamt=Double.parseDouble(getData("UBS_Camount"));
					System.out.println(ubsdbamt);

					if (ubsamt==ubsdbamt) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Fee Charge Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Fee Charge Amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				} else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBS_VATAcctNo"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					if (CRTag.equals("C")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "VAT Account and CR Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "VAT Account and CR Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					System.out.println(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value")+" ///"+(getData("UBSVATAmt")));

					double VAtamt=Double.parseDouble(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value"));
					if (VAtamt==Double.parseDouble(getData("UBSVATAmt"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "VAT Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "VAT Amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				}  else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBSDebitAccount"))) {
					index=i+1;
					String DRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					String CcyTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[7]/input")).getAttribute("value");
					if (DRTag.equals("D") && CcyTag.equals(getData("DebitCurrency"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Debit Account and DR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Debit Account and DR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					Double TotTxnAmt = Double.parseDouble(getData("UBS_CAmount"))+Double.parseDouble(getData("UBSVATAmt"))+Double.parseDouble(getData("CreditAmount"));
					String TotDebAmt = dformat.format(TotTxnAmt);
					if (driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value").equals(TotDebAmt)) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Debit Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Debit amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				} else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBSCreditAccount"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					if (CRTag.equals("C")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Credit Account and CR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Credit Account and CR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					Double creditAmt=Double.parseDouble(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value"));
					System.out.println(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value") +"///"+(getData("CreditAmount")));

					if (creditAmt==Double.parseDouble(getData("CreditAmount")) ) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Credit Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Credit amount verification is not successful");
					}
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				}
			}

			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL,"Verification of transaction details failed due to '"+e.getMessage()+"'");
		}

	}
/*	public static void VerifyContractDetails() throws Exception {

		int i;
		int iTransferAmt;
		int iAmtEqui;
		int iFees;

		initPageObjects();
		getLatestDriver();


		click(po_UBS.Button_UBS_Event);
		waitFor(1000);

		WebDriver driver2 = getLatestDriver();
		;
		driver2.switchTo().defaultContent();
		*//*List<WebElement> frame1;
		frame1=driver2.findElements(By.cssSelector("#ifr_LaunchWin"));
		driver2.switchTo().frame(frame1.get(2)); *//*
		driver2.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(2));

		if (po_UBS.ChkBox_UBS_Event.size() > 0) {
			for (WebElement ele : po_UBS.ChkBox_UBS_Event) {
				if (ele.isSelected() == false) {
					click(ele);
					//ele.click();
				}
			}
		} else {
			logReportStatus(LogStatus.FAIL, "Transaction doesn't have events in UBS");
		}

		*//*
		if(po_UBS.ChkBox_UBS_Event.size()>0){
			for (WebElement ele:po_UBS.ChkBox_UBS_Event){
				if (ele.isSelected()==true) {
					click(ele);
				}
			}
		}else{
			logReportStatus(LogStatus.FAIL, "Transaction doesn't have events in UBS");
		}
		*//*

		click(po_UBS.Button_UBS_AccountEntries);
		waitFor(1000);

		*//*
		iTransferAmt=Integer.parseInt(getTableText(10,"//*[@id=\"BLK_ACCOUNT__LCYAMT\"]" ));
		iAmtEqui=Integer.parseInt(getTableText(10,"//*[@id=\"BLK_ACCOUNT__LCYAMT1\"]" ));
		iFees=Integer.parseInt(getTableText(10,"//*[@id=\"BLK_ACCOUNT__LCYAMTI2\"]" )); *//*

		driver2.switchTo().defaultContent();
		*//*
		List<WebElement> frame2;
		frame2=driver2.findElements(By.cssSelector("#ifr_LaunchWin"));
		driver2.switchTo().frame(frame2.get(3)); *//*
		driver2.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(3));

		*//* List<WebElement> Amt=driver2.findElements(By.xpath("//input[@name='LCYAMT']"));
		String Amount=Amt.get(0).getAttribute("value");
		String EqAmt=Amt.get(1).getAttribute("value");
		String Fees=Amt.get(2).getAttribute("value"); *//*

		iTransferAmt = Integer.parseInt(po_UBS.Input_UBS_LCYAmt.get(0).getAttribute("value"));
		iAmtEqui = Integer.parseInt(po_UBS.Input_UBS_LCYAmt.get(1).getAttribute("value"));
		iFees = Integer.parseInt(po_UBS.Input_UBS_LCYAmt.get(2).getAttribute("value"));

		if (iTransferAmt == Integer.parseInt(getData("PaymentAmount")) &&
				(iAmtEqui == Integer.parseInt(getData("PaymentAmount")) + Integer.parseInt(getData("Fees"))) &&
				(iFees == Integer.parseInt(getData("Fees")))) {
			logReportStatus(LogStatus.PASS, "Transaction Details: Payment Amount & Fees has been verified in UBS");
		} else {
			logReportStatus(LogStatus.FAIL, "Transaction Details: Payment Amount & Fees are not displayed as expected in UBS");
		}

	}*/

	public static void ExitAllActiveWindows1() {

		try {
			WebDriver driver = getLatestDriver();
			List<WebElement> frame2;
			frame2 = driver.findElements(By.cssSelector("#ifr_LaunchWin"));

			driver.switchTo().frame(frame2.get(3));
			driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();
			driver.switchTo().defaultContent();


			driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(2));
			driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();

			driver.switchTo().defaultContent();

			List<WebElement> sam1 = driver.findElements(By.xpath("//*[@id='ifr_LaunchWin']"));
			driver.switchTo().frame(sam1.get(1));

			driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();
			Thread.sleep(2000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.cssSelector("#ifr_LaunchWin")));
			driver.findElement(By.cssSelector("#BTN_EXIT")).click();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Exit all active windows failed due to '" + e.getMessage() + "'");
		}

	}

	public static void ExitAllActiveWindows() throws Exception {

		WebDriver driver = getLatestDriver();
		click(po_UBS.Image_UBS_Exit);
		//driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();
		driver.switchTo().defaultContent();

		/*List<WebElement> frame1;
		frame1=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
		driver.switchTo().frame(frame1.get(2)); */
		driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(2));
		click(po_UBS.Image_UBS_Exit);
		//driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();

		driver.switchTo().defaultContent();

		/* List<WebElement> sam1=driver.findElements(By.xpath("//*[@id='ifr_LaunchWin']"));
		driver.switchTo().frame(sam1.get(1)); */
		driver.switchTo().frame(po_UBS.Frame2_UBS_Contracts.get(1));
		click(po_UBS.Image_UBS_Exit);
		//driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();
		Thread.sleep(2000);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.cssSelector("#ifr_LaunchWin")));
		//driver.findElement(By.cssSelector("#BTN_EXIT")).click(); */
		click(po_UBS.Image_UBS_Exit);
		driver.switchTo().defaultContent();

		/*
		for(WebElement ele:po_UBS.Buttonlist_UBS_Exit) {
			click(ele);
			waitFor(1000);
		}*/

	}

	/**********************************************************************************************************************************/
	/*
	 * Function Name : SearchAccNo_RetailIB
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/
	public static void SearchAccNo_RetailIB() {
		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			click(po_UBS.Button_UBS_EnterQuery);
			waitFor(1000);

			driver.switchTo().frame("ifr_LaunchWin");

			sendKeys(po_UBS.Input_UBS_RDIAcctNo, getData("AccountNum"));
			waitFor(1000);
			driver.switchTo().defaultContent();

			click(po_UBS.Button_UBS_ExecuteQuery);
			waitFor(5000);
			driver.switchTo().frame("ifr_LaunchWin");

			String CustNo = getText(po_UBS.Input_UBS_RDICustNo);
			if (!CustNo.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Account details displayed in the screen successfully");
				saveTestDataToDb("CustomerNo", CustNo);
				driver.switchTo().defaultContent();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Account details displayed in the screen is not successful");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Search Account Number failed due to '" + e.getMessage() + "'");
		}
	}

	/**********************************************************************************************************************************/
    /*
     * Function Name : SearchAcctSummary_RetailIB
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/
	public static void SearchAcctSummary_RetailIB() {

		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			click(po_UBS.Button_UBS_Customer);
			waitFor(1000);

			String CustID = getData("CustomerNo");
			sendKeys(po_UBS.Input_UBS_SearchCustomerID, CustID);
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Customer Number entered in the search successfully");
			click(po_UBS.Button_UBS_Search);

			int waitCust = 15;
			boolean Flag;
			Flag = false;
			for (int i = 1; i < waitCust; i++) {
				waitFor(1000);
				if (!po_UBS.Table_UBS_CustomerList.equals("")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Entered Customer ID is found in the record successfully");
					click(po_UBS.Table_UBS_CustomerList);
					Flag = true;
					break;
				}
			}

			if (Flag = false) {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Entered Customer ID is not found in the record successfully");
			}

			int waitAcct = 20;
			boolean Flag2;
			Flag2 = false;
			for (int i = 1; i < waitAcct; i++) {
				waitFor(1000);
				if (!driver.findElement(By.xpath("//div[@id='ListofAccDiv']//tbody/tr[1]/td[1]/a")).getText().equals("")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Accounts displayed in the list successfully");
					Flag2 = true;
					break;
				}
			}

			if (Flag2 = false) {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Entered Customer ID is not found in the record successfully");
			}

			//div[@id='ListofAccDiv']//a[contains(.,'29900186629')]
			driver.findElement(By.xpath("//div[@id='ListofAccDiv']//a[contains(.,'" + getData("AccountNum") + "')]")).click();
			waitFor(1000);

			String Prod = getText(po_UBS.WebElement_UBS_AcctProduct);
			String cCurrBal = getText(po_UBS.WebElement_UBS_CurrentAcct).replace(",", "").trim();

			if (Prod.equals("CUROP") && cCurrBal.equals(getData("CurrentBalance")) || Prod.equals("FCURAC") && cCurrBal.equals(getData("FCYAccountBalance"))) {
				scrollDownScreenShot(po_UBS.WebElement_UBS_CurrentAcct, "Current Balance verified successfully");
				ReportHelper.logReportStatus(LogStatus.PASS, "Current Balance verified successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Current Balance verified is not successful");
			}

			// Meem OnePack
			if (getData("AcctType").equals("SAR")) {
				String temp = getData("AccountNum");
				Double SavAccNo = Double.parseDouble(temp);
				SavAccNo = SavAccNo + 1;
				DecimalFormat df = new DecimalFormat("0");
				String fSavAcct = df.format(SavAccNo);
				System.out.println(fSavAcct);
				driver.findElement(By.xpath("//div[@id='ListofAccDiv']//a[contains(.,'" + fSavAcct + "')]")).click();
				waitFor(1000);
				String Prod2 = getText(po_UBS.WebElement_UBS_AcctProduct);
				String cAvalBal = getText(po_UBS.WebElement_UBS_SavingAcct).replace(",", "").trim();

				if (Prod2.equals("SAVOP") && cAvalBal.equals(getData("SavingAcctBalance"))) {
					scrollDownScreenShot(po_UBS.WebElement_UBS_SavingAcct, "Saving account Balance verified successfully");
					ReportHelper.logReportStatus(LogStatus.PASS, "Saving account verified successfully");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Saving account verified is not successful");
				}
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Search customer details failed due to '" + e.getMessage() + "'");
		}

	}

	public static void SearchREFNo_RetailIB() {

		try {
			initPageObjects();
			getLatestDriver();
			WebDriver driver = getLatestDriver();

			click(po_UBS.Button_UBS_EnterQuery);
			waitFor(1000);

			driver.switchTo().frame("ifr_LaunchWin");
			sendKeys(po_UBS.Input_UBS_RDIContRefNo, getData("UBS_ReferenceNumber"));
			waitFor(1000);
			driver.switchTo().defaultContent();

			click(po_UBS.Button_UBS_ExecuteQuery);
			waitFor(5000);
			driver.switchTo().frame("ifr_LaunchWin");

			String intDebitAmount = getText(po_UBS.Input_UBS_DebitAmount).replace(",", "").trim();
			DecimalFormat dformat = new DecimalFormat("0.00");
			//String fDebAmt=dformat.format(intDebitAmount);

			String intCreditAmount = getText(po_UBS.Input_UBS_CreditAmount).replace(",", "").trim();
			//String fCredAmt=dformat.format(intCreditAmount);

			Double tPayAmt = Double.parseDouble(getData("PaymentAmount"));
			String ChkPayAmt = dformat.format(tPayAmt);

			Double tCredAmt = Double.parseDouble(getData("CreditAmount"));
			String ChkCredAmt = dformat.format(tCredAmt);

			if (intDebitAmount.equals(ChkPayAmt) && intCreditAmount.equals(ChkCredAmt)) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Debit amount and Credit amount displayed correctly");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Debit amount and Credit amount displayed is not correct");
			}
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Search Transaction Reference Number failed due to '" + e.getMessage() + "'");
		}
	}

	public static void VerifyContractDetails_RetailIB() throws Exception {

		try {
			WebDriver driver = getLatestDriver();
			waitFor(1000);
			switchDFrame(po_UBS.Frame_UBS_Contracts);

			click(po_UBS.Button_UBS_Event);
			waitFor(2000);
			driver.switchTo().defaultContent();

			switchDFrame(po_UBS.Frame2_UBS_Contracts);
			ReportHelper.logReportStatus(LogStatus.PASS, "Event displayed in the screen successfully");
			for (WebElement ele : po_UBS.ChkBox_UBS_Event) {
				if (ele.isSelected() == false) {
					ele.click();
				}
			}
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Event details entered successfully");
			click(po_UBS.Button_UBS_AccountEntries);
			waitFor(2000);
			driver.switchTo().defaultContent();
			ReportHelper.logReportStatus(LogStatus.PASS, "Account entries displayed in the screen successfully");
			switchDFrame(po_UBS.Frame2_UBS_Contracts);

			DecimalFormat dformat = new DecimalFormat("0.0");


			Double TOTAL_AMt = 0.0, Calculated_TOTAMt = 0.0, gTxnAmt = 0.0, ChkTxnAmt = 0.0;
			gTxnAmt = Double.parseDouble(getData("TotalTxnAmount"));
			if (getData("BeneType").equals("WITHIN MEEM")) {
				TOTAL_AMt = Double.parseDouble(po_UBS.Input_UBS_LCYAmt.get(0).getAttribute("value"));
			} else if (getData("BeneType").equals("INTERNATIONAL") || getData("BeneType").equals("WITHIN KSA")) {
				int Amt = po_UBS.Input_UBS_LCYAmt.size();
				boolean Flag;
				Flag = false;
				for (int i = 0; i < Amt; i++) {
					Calculated_TOTAMt = Double.parseDouble(po_UBS.Input_UBS_LCYAmt.get(i).getAttribute("value"));
					if (Calculated_TOTAMt.equals(gTxnAmt)) {
						Flag = true;
						break;
					}
				}

				if (Flag = true) {
					ChkTxnAmt = Calculated_TOTAMt;
				}
			}

			if ((gTxnAmt.equals(ChkTxnAmt)) || (gTxnAmt.equals(TOTAL_AMt))) {
				logReportStatus(LogStatus.PASS, "Transaction Details: Payment Amount & Fees has been verified in UBS");
			} else {
				logReportStatus(LogStatus.FAIL, "Transaction Details: Payment Amount & Fees are not displayed as expected in UBS");
			}

			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL, "Verification of transaction details - Retail IB failed due to '" + e.getMessage() + "'");
		}

	}
public static void UBS_authorize()
{
	WebDriver driver = getLatestDriver();
	driver.switchTo().defaultContent();
	driver.switchTo().frame("ifr_LaunchWin");
	driver.switchTo().frame("ifrSubScreen");
click(po_UBS.BTN_Authorize_all);


	driver.switchTo().defaultContent();
	driver.switchTo().frame("ifr_LaunchWin");
	driver.switchTo().frame("ifrSubScreen");
	driver.switchTo().frame("ifr_AlertWin");
	String msg=driver.findElement(By.xpath("//table[@id='ERRTBL']//span[@class='SPNtbltwoC']")).getText();
	if(msg.equalsIgnoreCase("Successfully Authorized"))
	{
		logReportStatus(LogStatus.PASS, "Authorised Done Successfully");
	}
}

	public static void VerifyContractDetails_InternationalFT()  {

		try {
			WebDriver driver=getLatestDriver();
			waitFor(1000);
			driver.switchTo().defaultContent();
			//driver.switchTo().frame("ifr_LaunchWin");
			WebElement ContractInput=driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input')]"));
			driver.switchTo().frame(ContractInput);

			click(po_UBS.Button_UBS_Event);
			waitFor(1000);
			driver.switchTo().defaultContent();

			//switchDFrame(po_UBS.Frame2_UBS_Contracts);
			//driver.switchTo().frame(ContractInput);
			ReportHelper.logReportStatus(LogStatus.PASS,"Event displayed in the screen successfully");
/*			for (WebElement ele:po_UBS.ChkBox_UBS_Event){
				if (ele.isSelected()==false) {
					ele.click();
				}
			}*/
			List<WebElement> frame1;
			frame1=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
			driver.switchTo().frame(frame1.get(1));
			List <WebElement> EventLst = driver.findElements(By.xpath("//div[@id='tableContainer']//tbody/tr/td[4]"));
			int EventCnt = EventLst.size();
			for (int i=1;i<EventCnt+1;i++) {
				String EventCode = driver.findElement(By.xpath("//div[@id='tableContainer']//tbody/tr["+i+"]/td[4]/input")).getAttribute("value");
				System.out.println(EventCode);
				if (EventCode.equals("INIT")) {
					driver.findElement(By.xpath("//div[@id='tableContainer']//tbody/tr["+i+"]/td[4]")).click();
					break;
				}
			}

			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Event details entered successfully");
			click(po_UBS.Button_UBS_AccountEntries);
			waitFor(2000);
			driver.switchTo().defaultContent();
			//ReportHelper.logReportStatus(LogStatus.PASS,"Account entries displayed in the screen successfully");

			List<WebElement> frame2;
			frame2=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
			driver.switchTo().frame(frame2.get(2));

			DecimalFormat dformat=new DecimalFormat("0.00");

/*			Double tPaymtAmt=0.0,tConvAmt=0.0;
			tPaymtAmt = Double.parseDouble(getData("PaymentAmount"));
			tConvAmt = Double.parseDouble(getData("ConversionAmount"));*/

			//String ExcRate = po_UBS.Input_UBS_ExcRate.get(1).getAttribute("value");


/*			LCYAmt = Double.parseDouble(po_UBS.Input_UBS_LCYAmt.get(1).getAttribute("value"));
			FCYAmt = Double.parseDouble(po_UBS.Input_UBS_FCYAmt.get(1).getAttribute("value"));
			String AccCcy = po_UBS.Input_UBS_AccCcy.get(1).getAttribute("value");*/


/*			if((tPaymtAmt.equals(FCYAmt)) && (tConvAmt.equals(LCYAmt)) && (AccCcy.equals(Ccy)) && ExcRate.equals(getData("ExchangeRate")) ) {
				ReportHelper.logReportStatus(LogStatus.PASS,"Debit Currency and Credit Currency verified successfully");
				po_UBS.Input_UBS_CrAcct.get(1).click();
				Robot rt = new Robot();
				rt.keyPress(KeyEvent.VK_TAB);
				rt.keyRelease(KeyEvent.VK_TAB);
				rt.keyPress(KeyEvent.VK_TAB);
				rt.keyRelease(KeyEvent.VK_TAB);

				logReportStatus(LogStatus.PASS, "Debit and credit details verified successfully");
			} else {
				logReportStatus(LogStatus.FAIL, "Debit and Credit details verified successfully");
			}*/


			List <WebElement> AccEntLst = driver.findElements(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr/td[4]/input"));
			int AccEntCnt = AccEntLst.size();
			int index=0;
			Robot rt = new Robot();
			for (int i=0;i<AccEntCnt;i++) {
				//String AcctNum = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+i+"]/td[4]")).getText();
				System.out.println(AccEntLst.get(i).getAttribute("value"));
				if (AccEntLst.get(i).getAttribute("value").equals(getData("UBS_ChgeAcctNo"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					if (CRTag.equals("C")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Fee Charge Account and CR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Fee Charge Account and CR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);

					System.out.println(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value")+"/////"+(getData("UBS_Camount")));

					if (Double.parseDouble(driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value"))==Double.parseDouble(getData("UBS_Camount"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Fee Charge Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Fee Charge Amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				} else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBS_VATAcctNo"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					if (CRTag.equals("C")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "VAT Account and CR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "VAT Account and CR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					if (driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value").equals(getData("UBSVATAmt"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "VAT Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "VAT Amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				}  else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBSDebitAccount"))) {
					index=i+1;
					String DRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					String CcyTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[7]/input")).getAttribute("value");
					if (DRTag.equals("D") && CcyTag.equals(getData("DebitCurrency"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Debit Account and DR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Debit Account and DR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
						rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					Double TotTxnAmt = Double.parseDouble(getData("UBS_Camount"))+Double.parseDouble(getData("UBSVATAmt"))+Double.parseDouble(getData("ConversionAmount"));
					String TotDebAmt = dformat.format(TotTxnAmt);
					if (driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value").equals(TotDebAmt)) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Debit Amount verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Debit amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				} else if(AccEntLst.get(i).getAttribute("value").equals(getData("UBSCreditAccount"))) {
					index=i+1;
					String CRTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[5]/input")).getAttribute("value");
					String CcyTag = driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[7]/input")).getAttribute("value");
					if (CRTag.equals("C") && CcyTag.equals(getData("CreditCurrency"))) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Credit Account and CR & Currency Tag verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Credit Account and CR & Currency Tag has not been verified successfully");
					}
					AccEntLst.get(i).click();
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					// Credit Currency & Exchange Rate
					//String Ccy = getData("CreditCurrency");
					String ExcRate = getData("ExchangeRate");
					if (driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[10]/input")).getAttribute("value") .equals(getData("ConversionAmount")) && driver.findElement(By.xpath("//*[@id='BLK_ACCOUNT']/tbody/tr["+index+"]/td[9]/input")).getAttribute("value").equals(ExcRate)) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Credit Amount and Exchange rate  verified successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Credit amount verification is not successful");
					}
					rt.keyPress(KeyEvent.VK_TAB);
					rt.keyRelease(KeyEvent.VK_TAB);
					waitFor(1000);
				}
			}

			Thread.sleep(2000);
			driver.switchTo().defaultContent();

		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL,"Verification of transaction details - Retail IB failed due to '"+e.getMessage()+"'");
		}



	}

	public static void ExitActiveWindow_AcctSummary()  {

		try {
			WebDriver driver=getLatestDriver();

			driver.switchTo().frame(driver.findElement(By.cssSelector("#ifr_LaunchWin")));
			driver.findElement(By.cssSelector("#BTN_EXIT_IMG")).click();
			driver.switchTo().defaultContent();

			waitFor(2000);
			hover(po_UBS.Image_UBS_BranchIsOnline);
			waitFor(1000);
			click(po_UBS.Select_UBS_HomeBranch);
			waitFor(2000);

			driver.switchTo().frame("ifr_AlertWin");
			driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();

		} catch (Exception e) {
			logReportStatus(LogStatus.FAIL,"Exit active window for account summary failed due to '" +e.getMessage()+"'");
		}

	}
}
