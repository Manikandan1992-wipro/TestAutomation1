package POM.functions;


import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import FrameWork.helpers.eMailOtpReader;
import FrameWork.library.Util;
import FrameWork.listeners.po_BaseClass;
import POM.pageobjects.po_eCorp_fo;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.saveTestData;
import static FrameWork.helpers.Helper.saveTestDataToDb;
import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.helpers.ReportHelper.updateStatusDescDb;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.waitTillElementIsNotVisible;
import static FrameWork.listeners.po_BaseClass.drvr;
import static FrameWork.listeners.po_BaseClass.po_GetDriver;
import static FrameWork.listeners.po_BaseClass.po_SetDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class fn_eCorp_FO {

	public static void initPageObjects() throws Exception {
		initElements(drvr, po_eCorp_fo.class);
		logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
		getLatestDriver();
	}

	public static void initiateFundTransfer() {

		try {
			initPageObjects();

			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitTillElementIsVisible(getLatestDriver().findElement(By.xpath("//table[@class='x-grid3-row-table']//tr[1]//td[4]")));
			//	waitTillElementIsVisible(po_eCorp_fo.Menu_Initiate);
			//waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_Initiate);
			waitFor(1000);
			hover(po_eCorp_fo.Menu_Payments);
			waitFor(1000);
			String type = getData("TransferType");
			switch (type) {
				case "Domestic":
					click(po_eCorp_fo.Menu_DomesticFundTransfer);
					waitFor(1000);
					break;
				case "International":
					click(po_eCorp_fo.Menu_InternationalFundTransfer);
					waitFor(1000);
					break;
				case "Own":
					click(po_eCorp_fo.Menu_OwnFundTransfer);
					break;
				case "Transfer within GIB":
					click(po_eCorp_fo.Menu_TransferWithinGIB);
					break;
			}

			ReportHelper.logReportStatus(LogStatus.PASS, getData("TransferType") + " fund Transfer is displayed successfully in the screen");
			sendKeys(po_eCorp_fo.Input_DebitAccountNumber, getData("DebitAccount"));
			waitFor(1000);
			sendKey(po_eCorp_fo.Input_DebitAccountNumber, Keys.TAB);
			waitFor(10000);

			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			List<WebElement> tem=getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-row x-grid3-row-first']//*[@class='x-grid3-cell-inner x-grid3-col-INPUT_ORG_ACC_NO']"));
			String sam=getData("DebitAccount");
			for(WebElement ele:tem)
			{if(ele.getText().equalsIgnoreCase(sam))
			{
				Actions act = new Actions(getLatestDriver());
				act.moveToElement(ele).doubleClick().build().perform();
				break;
			}
			}


			waitFor(5000);



			String avaBalance = getText(po_eCorp_fo.TextArea_AccountAvailableBalance);

			if (!(avaBalance.equalsIgnoreCase(""))) {
				ReportHelper.logReportStatus(LogStatus.PASS, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " has been validated and displayed as </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));
				//System.out.println(avaBalance);
				String AvalBalAmt = avaBalance.split("SAR")[0].trim().replace(",", "");
				Helper.saveTestDataToDb("AvailableBalance", AvalBalAmt);

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " is not displayed correctly </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));

			}

			sendKeys(po_eCorp_fo.Input_BeneficiaryAccountNumber, getData("BeneficiaryAccount"));
			waitFor(1000);
			sendKey(po_eCorp_fo.Input_BeneficiaryAccountNumber, Keys.TAB);
			//waitFor(5000);
			waitTillElementIsVisible(getLatestDriver().findElement(By.xpath("//div[contains(.,'" + getData("BeneficiaryAccount") + "')]")));

			doubleClickWithText("//div[contains(.,'" + getData("BeneficiaryAccount") + "')]");

			scrollDownScreenShot(po_eCorp_fo.Input_BeneficiaryAccountNumber, "Beneficiary Account details are displayed correctly");
			waitFor(1000);
			click(po_eCorp_fo.CheckBox_PaymentAmount);

			if (getData("PaymentCurrency").equals("USD")) {
				click(po_eCorp_fo.DropDown_PayCcyType);

				for (WebElement ele : po_eCorp_fo.Dropdown_CcyValue) {
					if (ele.getText().equals(getData("PaymentCurrency"))) {
						click(ele);
					}
				}
			}

		/*click(po_eCorp_fo.GTBeCropFO_CurrencyType_DropDown);
		clickText("//div[contains(.='SAR')]");*/

			sendKeys(po_eCorp_fo.Input_CreditAmount, getData("PaymentAmount"));
			sendKey(po_eCorp_fo.Input_CreditAmount, Keys.TAB);

			scrollDown(po_eCorp_fo.TextArea_PaymentDetails);

			waitFor(2000);

			click(po_eCorp_fo.DropDown_PurposeType);
			//click("//*[contains(.='Personal/Family Remittance')]");
			sendKey(po_eCorp_fo.DropDown_PurposeType, Keys.ARROW_DOWN);
			sendKey(po_eCorp_fo.DropDown_PurposeType, Keys.ENTER);

			if (getData("TransferType").equals("Own") || getData("TransferType").equals("Transfer within GIB")) {

			} else {
				click(po_eCorp_fo.DropDown_ChargeType);
				//		clickText("//div[contains(.='SHA')]");
				sendKey(po_eCorp_fo.DropDown_ChargeType, Keys.ARROW_DOWN);
				sendKey(po_eCorp_fo.DropDown_ChargeType, Keys.ENTER);

			}
			waitFor(3000);
			sendKeys(po_eCorp_fo.TextArea_PaymentDetails, "test");
			sendKeys(po_eCorp_fo.TextArea_CustomerReference, "test");

			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in " + getData("TransferType") + " fund transfer");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(5000);


			if (elemExist(po_eCorp_fo.Div_ConfirmationMsgBox)==true) {
				click(po_eCorp_fo.Button_Yes);
			}

			/*try {
				WebDriver driver= getLatestDriver();
				driver.findElement(By.xpath("//button[contains(.,'Yes')]"));
				driver.findElement(By.xpath("//button[contains(.,'Yes')]")).click();


				click(po_eCorp_fo.Button_Yes);
				waitFor(1000);
			} catch (Exception e) {

			}*/
			if (getData("TransferType").equalsIgnoreCase("Transfer within GIB")){
				sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
			}

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);

			if (transactionReffN0 != "") {
				ReportHelper.logReportStatus(LogStatus.PASS, getData("TransferType") + " fund Transfer initiated and Transaction Reference Number (" + transactionReffN0 + ") is generated successfully");

/*			ReportHelper.logReportStatus(LogStatus.PASS, "TRANSACTION REF NO VAL: "
					+ transactionReffN0);*/
				Helper.saveTestDataToDb("CBX_ReferenceNumber", transactionReffN0);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, getData("TransferType") + " fund Transfer initiated and Transaction Reference Number is not generated successfully");
				Helper.saveTestDataToDb("CBX_ReferenceNumber", "NA");
			}

			click(po_eCorp_fo.Button_Confirm);
			//scrollDownScreenShot(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL_2, "Transaction Reference Number");
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
					+ "' status displayed successfully");
			click(po_eCorp_fo.Button_Close_TopIndex);
			waitFor(2000);
//		String transactionStatus = getTableText(12, "transactionReffN0);

			String status = waitAndGetTableText(po_eCorp_fo.Button_RefreshTransactions, "Ready for Authorization",
					12, transactionReffN0);

			if (status.equalsIgnoreCase("Ready for Authorization")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for " + transactionReffN0
						+ " is - " + status + "");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction Status for '" + transactionReffN0
						+ "' is - '" + status + "'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Initiate Fund Transfer failed due to '" +e.getMessage()  +"'");
		}

	}

	public static void authoriseFundTransfer()  {
		try {
			initPageObjects();

			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			waitTillElementIsVisible(po_eCorp_fo.Button_PendingActivities);
			waitFor(15000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Button_PendingActivities);

			//waitTillElementIsVisible(po_eCorp_fo.DivWindow_PendingActivities);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Pending Activities are displayed successfully in the screen");
			click(po_eCorp_fo.Button_Refresh_TopIndex);
//		clickTopIndex("//div[contains(@class,'x-tool x-tool-refresh')]");
			waitFor(5000);
			clickWithTableText(1, getData("CBX_ReferenceNumber"));
			ReportHelper.logReportStatus(LogStatus.PASS, "CBX Reference Number '" +getData("CBX_ReferenceNumber")+ "' selected successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			click(po_eCorp_fo.Button_Yes);
			sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
			ReportHelper.logReportStatus(LogStatus.PASS,"OTP code entered successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			waitFor(2000);
//		clickTopIndex("//button[contains(.,'Authorize')]");
			String transactionStatus = waitAndGetTableText("Transaction submitted Successfully",
					3, getData("CBX_ReferenceNumber"));
			if (transactionStatus.toString().contains("Transaction submitted Successfully")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, transactionStatus );

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, transactionStatus);
			}
			click(po_eCorp_fo.Button_Close_TopIndex);
//		clickTopIndex("//button[contains(.,'Close')]");
			click(po_eCorp_fo.Button_Close_TopIndex);

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Authorize Fund Transfer failed due to '" +e.getMessage() +"'");
		}

	}

	public static void validateFundTransferStatus()  {

		try {
			initPageObjects();

			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshTransactions, "Processed by Bank",
					12, TranRefNum);

			/*if (transactionStatus.equalsIgnoreCase("Processed by Bank")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status for '"
						+ TranRefNum + "' is '" + transactionStatus + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status for '"
						+ TranRefNum + "' is '" + transactionStatus + "'");
			}*/

			click(po_eCorp_fo.Button_Home);

			click(po_eCorp_fo.Button_AccountSerivces_HomePage);

//		waitTillElementIsNotVisible("//div[contains(.,'Loading... Please wait.')]");
			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			waitFor(15000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account services are displayed successfully in the screen");
			//waitTillElementIsVisible("//div[contains(.,'" + getData("DebitAccount") + "') and contains(@class,'x-grid3-cell-inner x-grid3-col-OD_ACC_NO')]");
			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);


			List<WebElement> tem=getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-OD_ACC_NO']"));
			String sam=getData("DebitAccount");
			for(WebElement ele:tem)
			{if(ele.getText().equalsIgnoreCase(sam))
			{
				Actions act = new Actions(getLatestDriver());
				act.moveToElement(ele).doubleClick().build().perform();
				break;
			}
			}

			waitFor(10000);
			getLatestDriver();

			//int CurrBal = Integer.parseInt(getText(po_eCorp_fo.TextArea_CurrentBalance));
			String CurrBal = getText(po_eCorp_fo.TextArea_CurrentBalance);
			CurrBal=CurrBal.replace(",","");
			System.out.println("Current Balance is : "+CurrBal);

			String vPaymtAmt = getData("PaymentAmount");
			String vPrevBal = getData("AvailableBalance");
			String type = getData("TransferType");
			System.out.println(vPaymtAmt);
			System.out.println(vPrevBal);

			String ChargeAmt = getData("ChargeAmount");
			String VAT = getData("VATPercentage");

			DecimalFormat df = new DecimalFormat("0.00");
			Double vChkAcctBal=0.0;

			switch (type) {
				case "Domestic":
					// Debit amount = Charge Amount + VAT Amount + Payment amount
					Double VATAmt = Double.parseDouble(ChargeAmt) * Double.parseDouble(VAT);
					Double DebtAmt = Double.parseDouble(ChargeAmt) + VATAmt + Double.parseDouble(vPaymtAmt);
					System.out.println(DebtAmt);
					vChkAcctBal = Double.parseDouble(vPrevBal)-DebtAmt;
					System.out.println("Check Account Balance is : "+vChkAcctBal);
					break;
				case "International":
					// 1 USD is equal to 3.75 SAR
					Double PayAmt = Double.parseDouble(vPaymtAmt) * (3.756);
					// Debit Amount = Charge Amount + VAT Amount + Payment amount
					Double VATAmt2 = Double.parseDouble(ChargeAmt) * Double.parseDouble(VAT);
					Double cVATAmt = Double.parseDouble(df.format(VATAmt2));

					Double DebtAmt2 = Double.parseDouble(ChargeAmt) + cVATAmt + PayAmt;
					Double ChkAcctBal = Double.parseDouble(vPrevBal)-DebtAmt2;

					vChkAcctBal = Double.parseDouble(df.format(ChkAcctBal));
					System.out.println("Check Account Balance is : "+vChkAcctBal);
					break;
				case "Transfer within GIB":
					// 1 USD is equal to 3.75 SAR
					Double PayAmt2 = Double.parseDouble(vPaymtAmt) * (3.756);
					Double cAcctBal = Double.parseDouble(vPrevBal)-PayAmt2;
					vChkAcctBal = Double.parseDouble(df.format(cAcctBal));
					System.out.println("Check Account Balance is : "+vChkAcctBal);
					break;
				case "Own":
					Double cAcctBal2 = Double.parseDouble(vPrevBal)-Double.parseDouble(vPaymtAmt);
					vChkAcctBal = Double.parseDouble(df.format(cAcctBal2));
					System.out.println("Check Account Balance is : "+vChkAcctBal);
					break;
			}

			Double vCurrBal = Double.parseDouble(CurrBal);
			System.out.println(vCurrBal+"     "+vChkAcctBal);

			if (vCurrBal.equals(vChkAcctBal)){
				ReportHelper.logReportStatus(LogStatus.PASS,"Current Balance amount - '" +vCurrBal +"' verified successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Current Balance amount- '" +vCurrBal +"' verified is not successful");
			}
			waitFor(5000);
			for (WebElement ele : po_eCorp_fo.Table_UBS_ReferenceNumberList) {
				dbClick(ele);

				if (TranRefNum.equalsIgnoreCase(getText(po_eCorp_fo.TextArea_eCorp_CUSTOMER_REFERENCE))) {
					ReportHelper.logReportStatus(LogStatus.PASS, "UBS Transaction Number '"
							+ getText(po_eCorp_fo.TextArea_UBS_TXN_REF_NO) + "'" + "is verified successfully");

					saveTestDataToDb("UBS_ReferenceNumber", getText(po_eCorp_fo.TextArea_UBS_TXN_REF_NO));

					validation = true;
					click(po_eCorp_fo.Button_Close_TopIndex);
					break;
				} else {
					click(po_eCorp_fo.Button_Close_TopIndex);
				}
			}


			if (validation==false) {
				ReportHelper.logReportStatus(LogStatus.FAIL, "UBS Transaction Number not found for CBX Id '"
						+ TranRefNum + "'");
				click(po_eCorp_fo.Button_Close_TopIndex);
			}
			click(po_eCorp_fo.Button_Close_TopIndex);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate Fund Transfer failed due to '"+e.getMessage()+"'");
		}
	}
	public static void initiateInstruments()  {

		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_Initiate);
			waitFor(1000);
			hover(po_eCorp_fo.Menu_Instruments);
			waitFor(1000);

			String type = getData("InstrumentsType");
			switch (type) {
				case "ManagerCheque":
					click(po_eCorp_fo.Menu_InstManagerCheque);
					waitFor(1000);
					break;
				case "FCYDemandDraft":
					click(po_eCorp_fo.Menu_InstFCYDemandDraft);
					waitFor(1000);
					break;
			}

			ReportHelper.logReportStatus(LogStatus.PASS,getData("InstrumentsType") +" displayed in the screen successfully");

			sendKeys(po_eCorp_fo.Input_DebitAccountNumber, getData("DebitAccount"));
			waitFor(1000);
			sendKey(po_eCorp_fo.Input_DebitAccountNumber, Keys.TAB);
			waitFor(10000);
			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			doubleClickWithText("//div[contains(.,'" + getData("DebitAccount") + "')]");
			waitFor(5000);

			String avaBalance = getText(po_eCorp_fo.TextArea_AccountAvailableBalance);
			if (!(avaBalance.equalsIgnoreCase(""))) {
				ReportHelper.logReportStatus(LogStatus.PASS, "<b>Available Account Balance of Debit Account -" +getData("DebitAccount") + " has been validated and displayed as </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "<b>Available Account Balance of Debit Account -" +getData("DebitAccount") + " is not displayed correctly </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));
			}
			if(type.equalsIgnoreCase("FCYDemandDraft")) {
				if (getData("PaymentCurrency").equals("USD")) {
					sendKeys(po_eCorp_fo.Input_PayeeCurrency, getData("PaymentCurrency"));
					sendKey(po_eCorp_fo.Input_PayeeCurrency, Keys.TAB);
					waitFor(5000);
					//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
					doubleClickWithText("//div[@class='x-grid3-cell-inner x-grid3-col-COD_CCY'][contains(.,'" + getData("PaymentCurrency") + "')]");
					waitFor(5000);
					ReportHelper.logReportStatus(LogStatus.PASS,"Currency for FCY Demand Draft entered successfully");
				}
			}
			sendKeys(po_eCorp_fo.Input_PayeeName, getData("PayeeName"));
			waitFor(1000);
			sendKeys(po_eCorp_fo.Input_PayeeAddress, getData("PayeeAddress"));
			waitFor(1000);

			click(po_eCorp_fo.CheckBox_PaymentAmount);
			waitFor(1000);
			sendKeys(po_eCorp_fo.Input_CreditAmount, getData("PaymentAmount"));
			sendKey(po_eCorp_fo.Input_CreditAmount, Keys.TAB);
			waitFor(1000);

			sendKeys(po_eCorp_fo.Input_CollectionBranch, getData("CollectionBranch"));
			sendKey(po_eCorp_fo.Input_CollectionBranch, Keys.TAB);
			waitFor(5000);
			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			doubleClickWithText("//div[@class='x-grid3-cell-inner x-grid3-col-BRANCH_DESCRIPTION'][contains(.,'" + getData("CollectionBranch") + "')]");
			waitFor(5000);

			sendKeys(po_eCorp_fo.Input_AuthorizedPersonID, getData("AuthorizedPersonID"));
			sendKeys(po_eCorp_fo.Input_AuthorizedPersonName, getData("AuthorizedPersonName"));
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS,"All mandatory details entered successfully in Manager Cheque screen");

			if (getData("InstrumentsType").equals("FCYDemandDraft")) {
				click(po_eCorp_fo.CheckBox_AcceptTermsAndCondts2);
			}else {
				click(po_eCorp_fo.CheckBox_AcceptTermsAndCondts);
			}

			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(5000);

/*		try {
			click(po_eCorp_fo.Button_Yes);
			waitFor(1000);
		}catch (Exception e)
		{

		}*/

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
			if (transactionReffN0 != "") {
				ReportHelper.logReportStatus(LogStatus.PASS, getData("InstrumentsType") +" initiated and Transaction Reference Number (" +transactionReffN0 + ") is generated successfully" );
				System.out.println(transactionReffN0);
				Helper.saveTestDataToDb("CBX_ReferenceNumber", transactionReffN0);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, getData("InstrumentsType") +" initiated and Transaction Reference Number is not generated successfully");
				Helper.saveTestDataToDb("CBX_ReferenceNumber", "NA");
			}

			click(po_eCorp_fo.Button_Confirm);
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Transaction status for '" +transactionReffN0 + "' displayed successfully");
			click(po_eCorp_fo.Button_Close_TopIndex);

			waitFor(2000);
			click(po_eCorp_fo.Tab_Instruments);
			waitFor(3000);
			String status = waitAndGetTableText(po_eCorp_fo.Button_RefreshTransactions, "Ready for Authorization",
					15, transactionReffN0);

			if (status.equalsIgnoreCase("Ready for Authorization")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
						+ "' is - '" + status + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction Status for '" + transactionReffN0
						+ "' is - '" + status + "'");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Initiate instruments failed due to '" +e.getMessage()+"'");
		}

	}



	public static void CheckBookRequest()
	{
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_AcctServices);
			waitTillElementIsNotVisible(po_eCorp_fo.HomePage_AcctServices);
			waitFor(2000);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Account Services are displayed in the screen successfully");

			click(po_eCorp_fo.Menu_Initiate);
			click(po_eCorp_fo.Initiate_CheckBookRequest);
			waitFor(2000);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"CheckBook request Page displayed in the screen successfully");
			sendKeys(po_eCorp_fo.CheckBookRequest_AccountNo,getData("DebitAccount"));
			sendKey(po_eCorp_fo.CheckBookRequest_AccountNo,Keys.TAB);
			dbClick(po_eCorp_fo.AccountNo_SelectAccount);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Account Details autopopulated successfully");
			sendKey(po_eCorp_fo.CheckBookRequest_AccountNo,Keys.PAGE_DOWN);
			click(po_eCorp_fo.CheckBookRequest_CheckBookSize);
			waitFor(2000);
			click(po_eCorp_fo.CheckBookSize_SelectSize);
			sendKeys(po_eCorp_fo.CheckBookRequest_AuthPersonID,getData("ID"));
			sendKeys(po_eCorp_fo.CheckBookRequest_AuthPersonName,getData("Name"));
			sendKeys(po_eCorp_fo.CheckBookRequest_NoofCheck,getData("NOC"));
			sendKeys(po_eCorp_fo.CheckBookRequest_CollectionBranch,getData("Branch"));
			sendKey(po_eCorp_fo.CheckBookRequest_CollectionBranch,Keys.TAB);
			dbClick(po_eCorp_fo.CollectionBranch_SelectBranch);
			click(po_eCorp_fo.CheckBookRequest_TermsandConditions);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"All mandatory details entered successfully");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(10000);

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
			if (transactionReffN0!="") {
				ReportHelper.logReportStatus(LogStatus.PASS, "All data displayed correctly in review confirmation - Cheque Book request and Transaction Reference Number '"+transactionReffN0+"' is generated");
				Helper.saveTestDataToDb("CBX_ReferenceNumber",transactionReffN0);
				waitFor(5000);
				click(po_eCorp_fo.Button_Confirm);
				waitFor(1000);
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" +transactionReffN0 + "' is - 'Ready for Authorization'");
				click(po_eCorp_fo.Button_Close_TopIndex);
			}else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '"+transactionReffN0+ "' is not submitted successfully");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Check Book request failed '"+e.getMessage()+"'");
		}


	}


	public static void Account_Opening()
	{
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(3000);
			click(po_eCorp_fo.HomePage_AcctServices);
			waitTillElementIsNotVisible(po_eCorp_fo.HomePage_AcctServices);
			waitFor(2000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Account Services displayed successfully in the screen");

			click(po_eCorp_fo.Menu_Initiate);
			click(po_eCorp_fo.Initiate_AccountOpening);
			waitFor(2000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Account Opening displayed in the screen");
			sendKeys(po_eCorp_fo.AccountOpening_CIFSearch,getData("CIFNO"));
			sendKey(po_eCorp_fo.AccountOpening_CIFSearch,Keys.TAB);
			waitFor(2000);
			dbClick(po_eCorp_fo.CIFSearch_SelectCIF);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Details autopopulated successfully");
			sendKey(po_eCorp_fo.AccountOpening_CIFSearch, Keys.PAGE_DOWN);
			waitFor(2000);
			click(po_eCorp_fo.AccountOpening_AccountType);
			click(po_eCorp_fo.AccountType_CurrentAccount);
			waitFor(1000);
			click(po_eCorp_fo.AccountOpening_AccountCurrency);
			click(po_eCorp_fo.AccountCurrency_SelectAED);

			waitFor(2000);
			click(po_eCorp_fo.AccountOpening_TermsandConditions);
			ReportHelper.logReportStatus(LogStatus.PASS, "All mandatory fields entered successfully in  account opening");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(10000);

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
			if (transactionReffN0!="") {
				ReportHelper.logReportStatus(LogStatus.PASS, "All data displayed correctly in review confirmation - account opening and Transaction Reference Number '"+transactionReffN0+"' is generated");
				Helper.saveTestDataToDb("CBX_ReferenceNumber",transactionReffN0);
				waitFor(5000);
				click(po_eCorp_fo.AccountOpening_Confirm);
				waitFor(1000);
				updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" +transactionReffN0 + "' is - 'Ready for Authorization'");
				click(po_eCorp_fo.AccountOpening_Close);
			}else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '"+transactionReffN0+ "' is not submitted successfully");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Account opening failed"+e.getMessage()+"'");
		}

	}

	public static void authoriseAccountServices()  {
		try {
			initPageObjects();

			getLatestDriver();
			waitFor(5000);
			click(po_eCorp_fo.Button_AccountSerivces_HomePage);
			//waitTillElementIsNotVisible(po_eCorp_fo.Button_AccountSerivces_HomePage);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Button_PendingActivities);

			//waitTillElementIsVisible(po_eCorp_fo.DivWindow_PendingActivities);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Pending Activities are displayed successfully in the screen");
			click(po_eCorp_fo.Button_Refresh_TopIndex);
//		clickTopIndex("//div[contains(@class,'x-tool x-tool-refresh')]");
			waitFor(5000);
			clickWithTableText(2, getData("CBX_ReferenceNumber"));
			ReportHelper.logReportStatus(LogStatus.PASS, "CBX Reference Number '" +getData("CBX_ReferenceNumber")+ "' selected successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			click(po_eCorp_fo.Button_Yes);
			sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
			ReportHelper.logReportStatus(LogStatus.PASS,"OTP code entered successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			waitFor(2000);
//		clickTopIndex("//button[contains(.,'Authorize')]");
			String transactionStatus = waitAndGetTableText("Transaction submitted Successfully",
					3, getData("CBX_ReferenceNumber"));
			if (transactionStatus.toString().contains("Transaction submitted Successfully")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "CBX Reference Number :'"+getData("CBX_ReferenceNumber")+","+transactionStatus);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "CBX Reference Number :'"+getData("CBX_ReferenceNumber")+","+transactionStatus);
			}
			click(po_eCorp_fo.Button_Close_TopIndex);
//		clickTopIndex("//button[contains(.,'Close')]");
			click(po_eCorp_fo.Button_Close_TopIndex);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Authorize Fund Transfer failed due to '" +e.getMessage() +"'");
		}

	}
	public static void validateInstrumentsStatus()  {

		try {
			initPageObjects();

			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_Instruments);
			waitFor(5000);

			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshTransactions, "Processed by Bank",
					15, TranRefNum);

			if (transactionStatus.equalsIgnoreCase("Processed by Bank")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status for "
						+ TranRefNum + " is: " + transactionStatus + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status for :"
						+ TranRefNum + " is: " + transactionStatus + "");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate instruments status failed due to '" +e.getMessage()+"'");
		}

	}


	public static void accc()throws Exception {

		initPageObjects();

		getLatestDriver();
		click(po_eCorp_fo.Button_AccountSerivces_HomePage);
		waitTillElementIsNotVisible(po_eCorp_fo.Button_AccountSerivces_HomePage);
		//waitFor(10000);
		List<WebElement> AccBalance = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-CURR_AVAIL_BAL_AMT']"));
		System.out.println("-------------------------->>>>>>>>>>");
		System.out.println("-------------------------->>>>>>>>>>"+AccBalance.size()+"-----uc:");


	}

	public static void AccountSummary() throws Exception {
		initPageObjects();

		getLatestDriver();
		click(po_eCorp_fo.Button_AccountSerivces_HomePage);
		//waitTillElementIsNotVisible(po_eCorp_fo.Button_AccountSerivces_HomePage);

		waitFor(7000);

		String sam=getData("DebitAccount");

		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("--------------------------------------");
		System.out.println("-----------------"+sam+"---------------------");
		Helper.saveTestDataToDb("BeneficiaryAccount","Shree01222");
		List<WebElement> UncollectedBalance = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-col x-grid3-cell x-grid3-td-UNCOLLECT_BAL ']"));

		Pattern regex = Pattern.compile("[^.,()0-9]");
		List<WebElement> AccBalance = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-CURR_AVAIL_BAL_AMT']"));
		int key=0;

		for(WebElement ele:AccBalance)
		{
			System.out.println(ele.getText());
		}


		for(int i=0;i<AccBalance.size();i++)
		{

			WebElement accele=AccBalance.get(i);
			WebElement uncollele=UncollectedBalance.get(i);


			Matcher Accmtcher = regex.matcher(accele.getText());

			Matcher Umatcher = regex.matcher(uncollele.getText());
			if (Umatcher.find() && Accmtcher.find()) {
				key = 1;
			}

		}
		waitFor(5000);
		if (key==0)
		{ReportHelper.updateStatusDescDb=true;
			ReportHelper.logReportStatus(LogStatus.PASS, "Account summary data is populated");}

		else
			ReportHelper.logReportStatus(LogStatus.FAIL, "Account summary data is not populated");
	}

	public static void AddBeneficiary() throws Exception {
		initPageObjects();

		getLatestDriver();
		click(po_eCorp_fo.HomePage_Payments);

		waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);

		waitFor(10000);
		// waitTillElementIsVisible(po_eCorp_fo.Payment_DataMaintainance);
		click(po_eCorp_fo.Payment_DataMaintainance);
		waitFor(5000);
		//beneficiary library
		hover(po_eCorp_fo.DataMaintainance_BeneficiaryLibrary);
		//Add Beneficiary
		click(po_eCorp_fo.BeneficiaryLibrary_AddBeneficiary);
		//waitFor(10000);
		//International Fund Transfer
		/*click(po_eCorp_fo.AddBeneficiary_BeneficiaryType1);;*/
		waitFor(3000);
		JavascriptExecutor js = (JavascriptExecutor)getLatestDriver();
		js.executeScript("arguments[0].click();", po_eCorp_fo.AddBeneficiary_BeneficiaryType1);
		waitFor(2000);
		click(po_eCorp_fo.BeneficiaryType_InternationalFundTransfer);
		waitFor(5000);
		//Country Name
		sendKeys(po_eCorp_fo.AddBeneficiary_CountryName,getData("Country"));
		//Tab
		sendKey(po_eCorp_fo.AddBeneficiary_CountryName,Keys.TAB);
		waitFor(2000);
		//Select India
		//dbClick(po_eCorp_fo.AddBeneficiary_Country);
		List<WebElement> CountryCode = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-COUNTRY_NAME']"));
		for (WebElement ele : CountryCode) {
			if (ele.getText().equalsIgnoreCase(getData("Country"))) {
				dbClick(ele);
			}
		}
		waitFor(2000);
		//tab
		sendKey(po_eCorp_fo.AddBeneficiary_CountryName,Keys.TAB);
		waitFor(2000);
		//Beneficiary Nick name
		sendKeys(po_eCorp_fo.AddBeneficiary_BeneNickName,getData("BeneficiaryNickName"));
		waitFor(2000);
		//Beneficiary Name
		sendKeys(po_eCorp_fo.AddBeneficiary_BeneName,getData("BeneficiaryName"));
		waitFor(2000);
		//Address Line 1
		sendKeys(po_eCorp_fo.AddBeneficiary_AddressLine1,getData("AddressLine1"));
		waitFor(2000);
		//Beneficiary Account No
		sendKeys(po_eCorp_fo.AddBeneficiary_BeneAccNo,getData("BeneficiaryAccount"));
		sendKey(po_eCorp_fo.AddBeneficiary_BeneAccNo,Keys.PAGE_DOWN);

		waitFor(5000);
		//CityName
		sendKeys(po_eCorp_fo.BeneficiaryDetails_CountryName,getData("CityName"));
		sendKey(po_eCorp_fo.BeneficiaryDetails_CountryName,Keys.TAB);
		waitFor(2000);
		//SelectCity
		//dbClick(po_eCorp_fo.CountryName_SelectCountry);
		WebElement CityName=getLatestDriver().findElement(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-CITY'][contains(text(),'"+getData("CityName")+"')]"));
		dbClick(CityName);
		sendKey(po_eCorp_fo.BeneficiaryDetails_CountryName,Keys.TAB);
		//BankName
		sendKeys(po_eCorp_fo.BeneficiaryDetails_BankName,getData("BankName"));
		sendKey(po_eCorp_fo.BeneficiaryDetails_BankName,Keys.TAB);
		waitFor(2000);
		//SelectBank
		//dbClick(po_eCorp_fo.BankName_SelectBank);
		WebElement BankName=getLatestDriver().findElement(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-BANK_DESCRIPTION'][contains(text(),'"+getData("BankName")+"')]"));
		dbClick(BankName);
		//Submit;
		click(po_eCorp_fo.AddBeneficiary_Submit);

		waitFor(5000);
		//Confirmation
		click(po_eCorp_fo.BeneficiaryDetails_Confirmation);

		//Close
		click(po_eCorp_fo.Close);
		ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Successfully Created");


	}

	public static void authoriseBeneficary() throws Exception {
		initPageObjects();
		getLatestDriver();
		click(po_eCorp_fo.HomePage_Payments);
		//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
		waitFor(10000);
		click(po_eCorp_fo.Button_PendingActivities);
		waitFor(5000);
		click(po_eCorp_fo.Benefisary_autze_tab);
		//waitTillElementIsVisible(po_eCorp_fo.DivWindow_PendingActivities);
		waitFor(5000);
		click(po_eCorp_fo.Button_Refresh_TopIndex);
//		clickTopIndex("//div[contains(@class,'x-tool x-tool-refresh')]");
		waitFor(5000);
		clickWithTableText(1, getData("BeneficiaryNickName"));
		click(po_eCorp_fo.Button_Authorize_TopIndex);
		click(po_eCorp_fo.Button_Authorization.get(1));
		waitFor(5000);
		sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
		click(po_eCorp_fo.OTP_submit);
		waitFor(2000);
//		clickTopIndex("//button[contains(.,'Authorize')]");
		String transactionStatus = po_eCorp_fo.OTPSuccessMsg.getText();

		if (transactionStatus.contains("Beneficiary has been authorized successfully")) {
			ReportHelper.updateStatusDescDb=true;
			ReportHelper.logReportStatus(LogStatus.PASS, getData("BeneficiaryNickName")+transactionStatus);
		} else {
			ReportHelper.logReportStatus(LogStatus.FAIL, getData("BeneficiaryNickName")+transactionStatus);
		}
		click(po_eCorp_fo.OTP_Ok);
//		clickTopIndex("//button[contains(.,'Close')]");
		click(po_eCorp_fo.Button_Close_TopIndex);

	}


	public static void validateBeneficary() throws Exception {
		initPageObjects();
		getLatestDriver();
		click(po_eCorp_fo.HomePage_Payments);
		//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
		waitFor(6000);
		click(po_eCorp_fo.Payments_Beneficiaries_tab);
		String nickname=getData("BeneficiaryNickName");
		int k=0;
		for(WebElement ele:po_eCorp_fo.Nickname_data)
		{

			if(nickname.equals(ele.getText()))
			{
				ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Account is added successfully");
				k=1;
			}
		}
		if(k==0)
		{
			ReportHelper.logReportStatus(LogStatus.FAIL, "Beneficiary Account is not reflected");
		}	}

	public static void GeteStatement() throws Exception {

		int iAccountEleCount;
		boolean bFlag;
		bFlag=false;

		initPageObjects();

		getLatestDriver();
		click(po_eCorp_fo.HomePage_AcctServices);
		//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_AcctServices);
		waitFor(10000);

		iAccountEleCount=po_eCorp_fo.Table_AccountSummary_AccountNumberList.size();
		List<WebElement> tableaction=po_eCorp_fo.Table_AccountSummary_ActionList;

		for(int i=0;i<iAccountEleCount;i++){

			System.out.println(po_eCorp_fo.Table_AccountSummary_AccountNumberList.get(i));


			if (po_eCorp_fo.Table_AccountSummary_AccountNumberList.get(i).getText().equals(getData("DebitAccount"))) {
				//click(tableaction.get(i));
				System.out.println("enetered if ");
				JavascriptExecutor executor = (JavascriptExecutor)getLatestDriver();
				executor.executeScript("arguments[0].click();", tableaction.get(i));
				System.out.println("Clciked exit if ");
				bFlag=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Account Number:'"+getData("DebitAccount")+"' is present in the Account Summary table and is selected");
				break;
			}

		}

		if (bFlag=true) {
			click(po_eCorp_fo.Img_View_eStatement);
			waitFor(3000);

			waitTillElementIsVisible(po_eCorp_fo.ListBox_Statement_Year);
			click(po_eCorp_fo.ListBox_Statement_Year);

			click(po_eCorp_fo.List_Statement_List.get(po_eCorp_fo.List_Statement_List.size()-1));

			waitFor(2000);
			click(po_eCorp_fo.ListBox_Statement_Month);

			click(po_eCorp_fo.List_Statement_List.get(po_eCorp_fo.List_Statement_List.size()-1));
			click(po_eCorp_fo.Button_Go);
			//	waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			waitFor(5000);

			if (po_eCorp_fo.element_Statement_pdf.isDisplayed()){
				ReportHelper.logReportStatus(LogStatus.PASS, "eStatement created for Account Number for'"+getData("DebitAccount")+"'");
				click(po_eCorp_fo.element_Statement_pdf);
			}else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "eStatement not created for Account Number for'"+getData("DebitAccount")+"'");
			}
			getLatestDriver();

			if (po_eCorp_fo.Element_Error.isDisplayed()){
				ReportHelper.logReportStatus(LogStatus.FAIL, "eStatement is not downloaded for Account Number for'"+getData("DebitAccount")+"'");
				getLatestDriver().close();

			}else {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "eStatement is downloaded successfully for Account Number for'"+getData("DebitAccount")+"'");
			}
			click(po_eCorp_fo.Button_Cancel);
			click(po_eCorp_fo.Button_Yes);

		}else {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Account Number for '"+getData("DebitAccount")+"' is not present in Account Summary table");
		}
		bFlag=false;

	}

	public static void Service_Request_Summary()  {
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.Button_AccountSerivces_HomePage);
			//waitTillElementIsNotVisible(po_eCorp_fo.Button_AccountSerivces_HomePage);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account services displayed in the screen successfully");
			click(po_eCorp_fo.Payments_OtherRequestSummary);
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Other Request summary displayed in the screen successfully");
			String Refno = getData("CBX_ReferenceNumber");

			List<WebElement> CBXRefno=getLatestDriver().findElements(By.xpath("//div[@class='x-grid3-viewport x-grid3-unlocked']/div[2]/div/div//td[1]/div"));
			int i=1,j=0;
			String ReqType="";
			String validation="";
			String Status="";
			for (WebElement Ref:CBXRefno) {
				if ((Ref.getText().contains(Refno)))
				{
					ReqType=getLatestDriver().findElement(By.xpath("//div[@class='x-grid3-viewport x-grid3-unlocked']/div[2]/div/div["+i+"]//td[2]/div")).getText();
					//Status=getLatestDriver().findElement(By.xpath("//div[@class='x-grid3-viewport x-grid3-unlocked']/div[2]/div/div["+i+"]//td[6]/div")).getText();
					//j=1;
					validation="true";
				}
				i++;
			}

			if (validation.equals("true")) {
				dbClick(By.xpath("//div[contains(text(),'" + Refno + "')]"));
				waitFor(2000);
				ReportHelper.logReportStatus(LogStatus.PASS,ReqType +" displayed in the screen successfully");
				String TxnRefNo = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
				String TxnStatus = getText(po_eCorp_fo.TextArea_TransactionStatus);
				//String RejectReason = getText(po_eCorp_fo.TextArea_RejectReason);

				if (!TxnRefNo.equals("") && (!TxnStatus.equals(""))) {
					ReportHelper.updateStatusDescDb=true;
					ReportHelper.logReportStatus(LogStatus.PASS,"Transaction status - '" +TxnStatus+"' for '"+TxnRefNo+"' verified successfully");
					click(po_eCorp_fo.OtherRequestSummary_Close);
				}else {
					ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction status - '" +TxnStatus+"' for '"+TxnRefNo+"' verified is not correct");
				}

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records for the entered CBX Reference Number - '"+Refno+"'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Service Request Summary viewing failed '"+e.getMessage()+"'");
		}
	}

	public static void StandingInstructions()  {
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			//	waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(5000);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments displayed in the screen successfully");
			click(po_eCorp_fo.Menu_Initiate);
			waitFor(1000);
			hover(po_eCorp_fo.Menu_Payments);
			waitFor(1000);
			click(po_eCorp_fo.Menu_InternationalFundTransfer);
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "International Fund Transfer displayed in the screen successfully");

/*		click(po_eCorp_fo.Menu_DomesticFundTransfer);
		waitFor(1000);
*/
			sendKeys(po_eCorp_fo.Input_DebitAccountNumber, getData("DebitAccount"));
			waitFor(1000);
			sendKey(po_eCorp_fo.Input_DebitAccountNumber, Keys.TAB);
			waitFor(7000);
			//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			waitFor(5000);
			doubleClickWithText("//div[contains(.,'" + getData("DebitAccount") + "')]");
			waitFor(5000);

//		click(po_eCorp_fo.GTBeCropFO_ExistingBeneficiaryCheckBox);

			String avaBalance = getText(po_eCorp_fo.TextArea_AccountAvailableBalance);
			if (!(avaBalance.equalsIgnoreCase(""))) {
				ReportHelper.logReportStatus(LogStatus.PASS, "<b>Available Account Balance = </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));
				String AvalBalAmt = avaBalance.split("SAR")[0].trim().replace(",", "");

				Helper.saveTestDataToDb("AvailableBalance",AvalBalAmt);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "<b>Available Account Balance Null : </b>"
						+ getText(po_eCorp_fo.TextArea_AccountAvailableBalance));
			}

			sendKeys(po_eCorp_fo.Input_BeneficiaryAccountNumber, getData("BeneficiaryAccount"));
			waitFor(1000);
			sendKey(po_eCorp_fo.Input_BeneficiaryAccountNumber, Keys.TAB);
			waitFor(1000);

			//	waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);
			waitFor(5000);
			doubleClickWithText("//div[contains(.,'" + getData("BeneficiaryAccount") + "')]");
			ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Details displays as expected");

			scrollDownScreenShot(po_eCorp_fo.Input_BeneficiaryAccountNumber, "Beneficiary Account");
			waitFor(1000);
			click(po_eCorp_fo.CheckBox_PaymentAmount);

			if (getData("PaymentCurrency").equals("USD")) {
				click(po_eCorp_fo.DropDown_PayCcyType);

				for (WebElement ele : po_eCorp_fo.Dropdown_CcyValue) {
					if (ele.getText().equals(getData("PaymentCurrency"))) {
						click(ele);
					}
				}
			}

		/*click(po_eCorp_fo.GTBeCropFO_CurrencyType_DropDown);
		clickText("//div[contains(.='SAR')]");*/

			sendKeys(po_eCorp_fo.Input_CreditAmount, getData("PaymentAmount"));
			sendKey(po_eCorp_fo.Input_CreditAmount, Keys.TAB);
			waitFor(1000);
			click(po_eCorp_fo.Input_StandingInstructions);
			// to capture the system date and set the date in first payment date field
			String UserLoginInfo = getText(po_eCorp_fo.Div_UserLoginInfo);
			String [] Splitter = UserLoginInfo.split(" ");
			String CurrDate = Splitter[2];
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(CurrDate));
			//c.setTime(new Date()); // Now use today date.
			c.add(Calendar.DATE, 1); // Adding one day
			String output = sdf.format(c.getTime());
			System.out.println(output);

			String[] vDate = output.split("-");
			String Day = vDate[0];
			String Month = vDate[1];
			String Year = vDate[2];
			click(po_eCorp_fo.Input_FirstPaymentDate);
			click(po_eCorp_fo.FirstPaymentDate_Arrow);
			waitFor(1000);
			getLatestDriver().findElement(By.xpath("//a[contains(text(),'" + Month + "')]")).click();
			getLatestDriver().findElement(By.xpath("//a[contains(text(),'" + Year + "')]")).click();
			getLatestDriver().findElement(By.xpath("//button[contains(text(),'OK')]")).click();
			waitFor(1000);
			getLatestDriver().findElement(By.xpath("//td[@class='x-date-active']/a//span[contains(text(),'" + Day + "')]")).click();
			click(po_eCorp_fo.Input_ExecutionFrequency);
			waitFor(1000);
			click(po_eCorp_fo.ExecutionFrequency_Daily);
			sendKey(po_eCorp_fo.Input_ExecutionFrequency, Keys.TAB);
			ReportHelper.logReportStatus(LogStatus.PASS, "All standing instructions mandatory details entered successfully");

			sendKeys(po_eCorp_fo.Input_NOofPAyments, getData("NoofPayments"));

			scrollDown(po_eCorp_fo.TextArea_PaymentDetails);
			waitFor(2000);

			click(po_eCorp_fo.DropDown_PurposeType);
			//click("//*[contains(.='Personal/Family Remittance')]");
			sendKey(po_eCorp_fo.DropDown_PurposeType, Keys.ARROW_DOWN);
			sendKey(po_eCorp_fo.DropDown_PurposeType, Keys.ENTER);

			if (getData("TransferType").equals("Own") || getData("TransferType").equals("Transfer within GIB")) {

			} else {
				click(po_eCorp_fo.DropDown_ChargeType);
				sendKey(po_eCorp_fo.DropDown_ChargeType, Keys.ARROW_DOWN);
				sendKey(po_eCorp_fo.DropDown_ChargeType, Keys.ENTER);

			}
			waitFor(2000);
			sendKeys(po_eCorp_fo.TextArea_PaymentDetails, "test");
			sendKeys(po_eCorp_fo.TextArea_CustomerReference, "test");

		/*click(po_eCorp_fo.Date_TransactionDate);
		clickText("//td/a[.='23']");*/
			ReportHelper.logReportStatus(LogStatus.PASS, "International Fund Transfer details entered successfully");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(8000);

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
			if (transactionReffN0 != "") {
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Reference Number (" + transactionReffN0 + ") is generated successfully");

				Helper.saveTestDataToDb("CBX_ReferenceNumber", transactionReffN0);
				waitFor(5000);
				click(po_eCorp_fo.Button_Confirm);
				waitFor(3000);
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" +transactionReffN0 + "' is - 'Ready for Authorization'");
				click(po_eCorp_fo.Button_Close_TopIndex);

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction Reference Number is not generated successfully");
				Helper.saveTestData("CBX_ReferenceNumber", "NA");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction payment option failed"+e.getMessage()+"'");
		}

	}

	public static void StandingInstructionAuthorization()
	{
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments displayed in the screen successfully");

			click(po_eCorp_fo.Button_PendingActivities);

			//waitTillElementIsVisible(po_eCorp_fo.DivWindow_PendingActivities);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Pending activities displayed in the screen successfully");
			click(po_eCorp_fo.Button_Refresh_TopIndex);
//		clickTopIndex("//div[contains(@class,'x-tool x-tool-refresh')]");
			waitFor(7000);

			clickWithTableText(1, getData("CBX_ReferenceNumber"));
			ReportHelper.logReportStatus(LogStatus.PASS, "CBX Reference number '" +getData("CBX_ReferenceNumber")+ "' selected successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			click(po_eCorp_fo.Button_Yes);
			sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
			ReportHelper.logReportStatus(LogStatus.PASS,"OTP code entered successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			waitFor(2000);
//		clickTopIndex("//button[contains(.,'Authorize')]");
			String transactionStatus = waitAndGetTableText("Transaction submitted Successfully",
					3, getData("CBX_ReferenceNumber"));
			if (transactionStatus.toString().contains("Transaction submitted Successfully")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, transactionStatus);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, transactionStatus);
			}
			click(po_eCorp_fo.Button_Close_TopIndex);
//		clickTopIndex("//button[contains(.,'Close')]");
			click(po_eCorp_fo.Button_Close_TopIndex);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction payment option authorization failed '"+e.getMessage()+"'");
		}

	}

	public static void validateStandingInstructions() {

		try {
			initPageObjects();
			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			//boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Tab_StandingInstructions);
			waitFor(10000);

			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshTransactions, "Active",
					13, TranRefNum);

			if (transactionStatus.equalsIgnoreCase("Active")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status -'"+transactionStatus+"' for '"
						+ TranRefNum + "' in Standing Instructions verified successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status -'"+transactionStatus+"' for '"
						+ TranRefNum + "' in Standing Instructions verified is not successful");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validation of Standing Instructions failed due to '"+e.getMessage()+"'");
		}
	}

	public static void LoansSummary() {
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.Button_AccountSerivces_HomePage);
			waitFor(7000);

			// to click Loans summary Tab
			click(po_eCorp_fo.Tab_LoansSummary);
			waitFor(10000);

			List<WebElement> LoanBalance = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-col x-grid3-cell x-grid3-td-LOAN_APPROVED_LIMIT ']"));
			Pattern regex = Pattern.compile("[^.,()0-9]");
			List<WebElement> LoanAmount = getLatestDriver().findElements(By.xpath("//*[@class='x-grid3-cell-inner x-grid3-col-LOAN_OS']"));
			int key = 0;
/*			for (WebElement ele : LoanAmount) {
                System.out.println(ele.getText());
            }*/

			for (int i = 0; i < LoanAmount.size(); i++) {
				WebElement LAele = LoanAmount.get(i);
				WebElement uncollele = LoanBalance.get(i);
				Matcher LAmtcher = regex.matcher(LAele.getText());
				Matcher LBatcher = regex.matcher(uncollele.getText());
				if (LBatcher.find() && LAmtcher.find()) {
					key = 1;
				}
			}
			waitFor(5000);
			if (key == 0) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Account summary data is populated");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Account summary data is not populated");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Loans Summary failed due to '"+e.getMessage()+"'");
		}
	}

	public static void StopCheckRequest()
	{
		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_AcctServices);
			waitTillElementIsNotVisible(po_eCorp_fo.HomePage_AcctServices);
			waitFor(2000);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Account Services are displayed in the screen successfully");

			click(po_eCorp_fo.Menu_Initiate);
			click(po_eCorp_fo.Initiate_StopCheckRequest);
			waitFor(2000);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Stop Check Request Page displayed in the screen successfully");
			sendKeys(po_eCorp_fo.CheckBookRequest_AccountNo,getData("DebitAccount"));
			sendKey(po_eCorp_fo.CheckBookRequest_AccountNo,Keys.TAB);
			doubleClickWithText("//div[contains(.,'" + getData("DebitAccount") + "')]");
			//dbClick(po_eCorp_fo.AccountNo_SelectAccount);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Account Details autopopulated successfully");

			WebDriver driver=getLatestDriver();
			//input[value='Single']
			driver.findElement(By.cssSelector("input[value='"+getData("ChequeType")+"']")).click();
			sendKeys(po_eCorp_fo.Input_ChequeNumber,getData("ChequeNumber"));
			sendKeys(po_eCorp_fo.Input_ChequeAmount,getData("ChequeAmount"));
			sendKeys(po_eCorp_fo.Input_ChequePayeeName,getData("PayeeName"));

			click(po_eCorp_fo.DropDown_Reason);
			for (WebElement ele : po_eCorp_fo.Dropdown_ReasonValue) {
				if (ele.getText().equals(getData("Reason"))) {
					click(ele);
				}
			}

			click(po_eCorp_fo.CheckBookRequest_TermsandConditions);
			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"All stop cheque request details entered successfully");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(15000);

			String transactionReffN0 = getText(po_eCorp_fo.TextArea_TRANSACTION_REF_NO_VAL);
			if (transactionReffN0!="") {
				ReportHelper.logReportStatus(LogStatus.PASS, "All data displayed correctly in review confirmation - Stop Cheque request and Transaction Reference Number '"+transactionReffN0+"' is generated");
				Helper.saveTestDataToDb("CBX_ReferenceNumber",transactionReffN0);
				waitFor(5000);
				click(po_eCorp_fo.Button_Confirm);
				waitFor(1000);
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" +transactionReffN0 + "' is - 'Ready for Authorization'");
				click(po_eCorp_fo.Button_Close_TopIndex);
			}else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '"+transactionReffN0+ "' is not submitted successfully");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Check Book request failed '"+e.getMessage()+"'");
		}

	}

	public static void validateStopChequeRequestStatus()  {

		try {
			initPageObjects();
			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.Button_AccountSerivces_HomePage);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Account Services are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_OtherRequestSummary);
			waitFor(7000);

			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshServiceRequestSummary, "Processed by Bank",
					6, TranRefNum);

			if (transactionStatus.equalsIgnoreCase("Processed by Bank")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status for "
						+ TranRefNum + " is: " + transactionStatus + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status for :"
						+ TranRefNum + " is: " + transactionStatus + "");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate instruments status failed due to '" +e.getMessage()+"'");
		}

	}

	public static void BillerRegistration() {

		try {
			initPageObjects();
			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_DataMaintenance);
			waitFor(1000);
			click(po_eCorp_fo.Menu_BillerRegistration);
			waitFor(3000);

			ReportHelper.logReportStatusInBlue(LogStatus.PASS,"Biller Registration Page displayed in the screen successfully");
			sendKeys(po_eCorp_fo.Input_BillerCIF,getData("CIFNumber"));
			sendKey(po_eCorp_fo.Input_BillerCIF,Keys.TAB);
			//tr/td/div[contains(.,'IGTBSA-00355768')]
			doubleClickWithText("//tr/td/div[contains(.,'" + getData("CIFNumber") + "')]");
			waitFor(5000);
			sendKeys(po_eCorp_fo.Input_BillerName,getData("Input_BillerName"));
			sendKey(po_eCorp_fo.Input_BillerName,Keys.TAB);
			//tr/td/div[contains(.,'King Faisal University')]
			doubleClickWithText("//tr/td/div[contains(.,'" + getData("Input_BillerName") + "')]");
			waitFor(2000);

			sendKeys(po_eCorp_fo.Input_SubscriberID,getData("SubscriberID"));
			ReportHelper.logReportStatus(LogStatus.PASS,"Biller Registration fields entered successfully");

			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(5000);

			if (elemExist(po_eCorp_fo.Button_Confirmation)) {
				ReportHelper.logReportStatus(LogStatus.PASS,"Biller Registration details displayed correctly");
				click(po_eCorp_fo.Button_Confirmation);
				waitFor(5000);
				String status = getText(po_eCorp_fo.TextArea_Biller_Status);
				String transactionReffN0 = getText(po_eCorp_fo.TextArea_Biller_TxnReferenceNumber);
				if (status.equalsIgnoreCase("Ready for Authorization")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
					saveTestDataToDb("CBX_ReferenceNumber",transactionReffN0);
					click(po_eCorp_fo.Button_Close_TopIndex);
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
				}
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Biller Registration details displayed is not correct");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Biller Registration failed due to '"+e.getMessage()+"'");
		}
	}

	public static void authoriseSADADBiller()  {
		try {
			initPageObjects();

			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			waitFor(15000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Button_PendingActivities);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Pending Activities are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_SADADBiller);
			waitFor(1000);
			click(po_eCorp_fo.Button_Refresh_TopIndex);
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Authorization displayed under SADAD Biller Authorization section successfully");
			clickWithTableText(1, getData("CBX_ReferenceNumber"));
			ReportHelper.logReportStatus(LogStatus.PASS, "CBX Reference Number '" +getData("CBX_ReferenceNumber")+ "' selected successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS,"Transaction Reference number details displayed in the Biller Registration successfully");
			click(po_eCorp_fo.Button_Authorize_TopIndex);
			sendKeys(po_eCorp_fo.Input_Authorize_OTP, eMailOtpReader.readMail());
			ReportHelper.logReportStatus(LogStatus.PASS,"OTP code entered successfully");
			click(po_eCorp_fo.Button_SubmitFundTransfer);
			waitFor(25000);
			String transactionStatus = getText(po_eCorp_fo.OTPSuccessMsg);
			System.out.println(transactionStatus);
			if (transactionStatus.contains("SADAD Biller registration has been authorized successfully") || transactionStatus.contains("Cancel SADAD Biller has been authorized successfully")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, transactionStatus );
				waitFor(2000);
				click(po_eCorp_fo.OTP_Ok);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, transactionStatus);
			}
			click(po_eCorp_fo.Button_Close_TopIndex);

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Authorize Fund Transfer failed due to '" +e.getMessage() +"'");
		}

	}

	public static void validateSADADBiller()  {

		try {
			initPageObjects();
			getLatestDriver();
			//String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_SADADBiller);
			waitFor(10000);

			WebDriver driver = getLatestDriver();
			List <WebElement> SubscriberList = driver.findElements(By.xpath("//div/table/tbody/tr[1]/td[4]/div[@class='x-grid3-cell-inner x-grid3-col-SUBSCRIBER_ID']"));
			int SubsCount = SubscriberList.size();
			for (int i=1;i<SubsCount;i++){
				String cSubID = driver.findElement(By.xpath("//div["+i+"]/table/tbody/tr[1]/td[4]/div[@class='x-grid3-cell-inner x-grid3-col-SUBSCRIBER_ID']")).getText();
				//System.out.println(cSubID);
				if (cSubID.equals(getData("SubscriberID"))){
					ReportHelper.logReportStatus(LogStatus.PASS,"SADAD Biller Registration - Subscriber ID '"+cSubID+"' has been verified successfully");
					validation=true;
					break;
				}
			}

			if (validation=false){
				ReportHelper.logReportStatus(LogStatus.FAIL,"SADAD Biller Registration - Subscriber ID '"+getData("SubscriberID")+"' has not been verified successfully");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate instruments status failed due to '" +e.getMessage()+"'");
		}

	}

	public static void BillerCancellation()  {

		try {
			initPageObjects();
			getLatestDriver();
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_SADADBiller);
			waitFor(10000);

			WebDriver driver = getLatestDriver();
			List <WebElement> SubscriberList = driver.findElements(By.xpath("//div/table/tbody/tr[1]/td[4]/div[@class='x-grid3-cell-inner x-grid3-col-SUBSCRIBER_ID']"));
			int SubsCount = SubscriberList.size();
			for (int i=1;i<SubsCount;i++){
				String cSubID = driver.findElement(By.xpath("//div["+i+"]/table/tbody/tr[1]/td[4]/div[@class='x-grid3-cell-inner x-grid3-col-SUBSCRIBER_ID']")).getText();
				if (cSubID.equals(getData("SubscriberID"))){
					ReportHelper.logReportStatus(LogStatus.PASS,"SADAD Biller Registration - Subscriber ID '"+cSubID+"' displayed successfully");
					driver.findElement(By.xpath("//div[@class='x-column-inner']/div[@class=' x-portal-column x-column'][2]//div["+i+"]/table/tbody/tr[1]/td/div/img[2]")).click();
					waitFor(2000);
					driver.findElement(By.xpath("//div[@class='x-menu x-menu-floating x-layer']//a/span[contains(text(),'Cancel Biller')]")).click();
					validation=true;
					break;
				}
			}

			waitFor(2000);
			if (validation=true){
				sendKeys(po_eCorp_fo.Input_BillerCancellation_Reason,getData("BillerReason"));
				ReportHelper.logReportStatus(LogStatus.PASS,"Reason field entered in the SADAD Biller Cancellation successfully");
				click(po_eCorp_fo.Button_SubmitFundTransfer);
				waitFor(3000);
				ReportHelper.logReportStatus(LogStatus.PASS,"SADAD Biller cancellation displayed at the confirmation page successfully");
				click(po_eCorp_fo.Button_Confirmation);
				waitFor(5000);
				String status = getText(po_eCorp_fo.TextArea_Biller_Status);
				String transactionReffN0 = getText(po_eCorp_fo.TextArea_Biller_TxnReferenceNumber);
				if (status.equalsIgnoreCase("Ready for Authorization")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
					saveTestDataToDb("CBX_ReferenceNumber",transactionReffN0);
					click(po_eCorp_fo.Button_Close_TopIndex);
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
				}

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"No record for the Entered Subscriber ID '"+getData("SubscriberID")+"' has been found in the SADAD biller list");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate instruments status failed due to '" +e.getMessage()+"'");
		}

	}

	public static void initiateSADADBillPayments() {

		try {
			initPageObjects();

			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_Initiate);
			waitFor(1000);
			click(po_eCorp_fo.Menu_SADADBillPayments);
			waitFor(3000);

			ReportHelper.logReportStatus(LogStatus.PASS, "SADAD Bill Payments displayed in the screen successfully");
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);

			sendKeys(po_eCorp_fo.Input_SADADDebitAccountNumber,getData("DebitAccount"));
			//sendKey(po_eCorp_fo.Input_SADADDebitAccountNumber,Keys.TAB);
			driver.findElement(By.xpath("//*[contains(text(),'Biller Information')]")).click();
			//click(po_eCorp_fo.Search_DebitAccountNum);
			waitFor(15000);

			List<WebElement> tem = getLatestDriver().findElements(By.xpath("//table/tbody/tr/td[1]/div[@class='x-grid3-cell-inner x-grid3-col-0'][contains(.,'"+getData("DebitAccount")+"')]"));
			String sam = getData("DebitAccount");
			for (WebElement ele : tem) {
				System.out.println(ele.getText());
				waitFor(3000);
				if (ele.getText().equalsIgnoreCase(sam)) {
					Actions act = new Actions(driver);
					act.moveToElement(ele).doubleClick().build().perform();
					break;
				}
			}

			waitFor(5000);
			String avaBalance = getText(po_eCorp_fo.TextArea_SADADAvailableBalance);
			if (!(avaBalance.equalsIgnoreCase(""))) {
				ReportHelper.logReportStatus(LogStatus.PASS, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " has been validated and displayed as </b>"
						+ getText(po_eCorp_fo.TextArea_SADADAvailableBalance));
				String AvalBalAmt = avaBalance.split("SAR")[0].trim().replace(",", "");
				//Helper.saveTestDataToDb("AvailableBalance", AvalBalAmt);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " is not displayed correctly </b>"
						+ getText(po_eCorp_fo.TextArea_SADADAvailableBalance));
			}

			Select BillerTyp = new Select(po_eCorp_fo.Select_BillerType);
			BillerTyp.selectByVisibleText(getData("BillerType"));
			waitFor(5000);

			click(po_eCorp_fo.Search_BillerCIF);
			waitFor(10000);

			//td[@class='x-grid3-col x-grid3-cell x-grid3-td-0 x-grid3-cell-first ']//div[contains(text(),'IGTBSA-00355768')]
			Actions act = new Actions(getLatestDriver());
			act.moveToElement(driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-0 x-grid3-cell-first ']//div[contains(text(),'"+getData("CIF_ID")+"')]"))).doubleClick().build().perform();

			waitFor(7000);
			List <WebElement> Billers = driver.findElements(By.xpath("//table[@class='biller-table tableBodyScroll']//tr"));
			boolean validation = false;
			for (int i=1;i<Billers.size();i++){
				String BillerGrp = driver.findElement(By.xpath("//table[@class='biller-table tableBodyScroll']//tr["+i+"]/td[2]/input")).getAttribute("value");
				String DueAmt = driver.findElement(By.xpath("//table[@class='biller-table tableBodyScroll']//tr["+i+"]/td[8]/input")).getAttribute("value");
				Double dDueAmt=Double.parseDouble(DueAmt);
				if (BillerGrp.equals("Telecom") && !DueAmt.equals("0.00") && dDueAmt<=0){
					int Cnt = DueAmt.length();
					String Backspace = "";
					while (Cnt > 0) {
						Backspace=Backspace+"\b";
						Cnt=Cnt-1;
					}
					//System.out.println(Backspace);
					driver.findElement(By.xpath("//table[@class='biller-table tableBodyScroll']//tr["+i+"]/td[8]/input")).sendKeys(Backspace+getData("DueAmount"));
					ReportHelper.logReportStatus(LogStatus.PASS,"Due amount entered successfully");
					driver.findElement(By.xpath("//table[@class='biller-table tableBodyScroll']//tr["+i+"]/td[1]/input")).click();
					validation=true;
					break;
				} else if (dDueAmt>0) {
					driver.findElement(By.xpath("//table[@class='biller-table tableBodyScroll']//tr["+i+"]/td[1]/input")).click();
					break;
				}
			}

			waitFor(3000);
			if (validation=true){
				String PaymtAmt = getText(po_eCorp_fo.Input_Biller_DebitAmount);
				if (!PaymtAmt.equals("0.00")) {
					ReportHelper.logReportStatus(LogStatus.PASS,"Payment amount autopopulated successfully");
					waitFor(1000);
					click(po_eCorp_fo.Button_SubmitFundTransfer);
					waitFor(5000);

					String transactionReffN0 = getText(po_eCorp_fo.TextArea_SADADBiller_TxnReferenceNumber);
					if (transactionReffN0 != "") {
						ReportHelper.logReportStatus(LogStatus.PASS, "SADAD Bill Payments initiated and Transaction Reference Number (" +transactionReffN0 + ") is generated successfully" );
						//System.out.println(transactionReffN0);
						Helper.saveTestDataToDb("CBX_ReferenceNumber", transactionReffN0);
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "SADAD Bill Payments initiated and Transaction Reference Number is not generated successfully");
						Helper.saveTestDataToDb("CBX_ReferenceNumber", "NA");
					}

					click(po_eCorp_fo.Button_Confirm);
					waitFor(5000);
					String status = getText(driver.findElement(By.xpath("//form[@name='confirmationJSP']//tr[3]/td[4]")));
					if (status.equalsIgnoreCase("Ready for Authorization")) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
								+ "' is - '" + status + "'");
						click(po_eCorp_fo.Button_Close_TopIndex);
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '" + transactionReffN0
								+ "' is - '" + status + "'");
					}

				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL,"Payment amount is shown as less than zero in Payment Info");
				}

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Due amount is shown as less than zero in all Billers list");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"SADAD Bill Payments failed due to '"+e.getMessage()+"'");
		}
	}

	public static void validateSADADBillPaymentStatus()  {

		try {
			initPageObjects();
			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_SADADBillPayment);
			waitFor(8000);

			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshSADAD, "Processed by Bank",
					12, TranRefNum);

			if (transactionStatus.equalsIgnoreCase("Processed by Bank")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status for "
						+ TranRefNum + " is: " + transactionStatus + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status for :"
						+ TranRefNum + " is: " + transactionStatus + "");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate SADAD Bill Payment status failed due to '" +e.getMessage()+"'");
		}

	}

	public static void initiateSADADMOIPayments() {

		try {
			initPageObjects();

			getLatestDriver();
			click(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");
			click(po_eCorp_fo.Menu_Initiate);
			waitFor(1000);
			click(po_eCorp_fo.Menu_SADADMOIPayments);
			waitFor(3000);

			ReportHelper.logReportStatus(LogStatus.PASS, "SADAD Bill Payments displayed in the screen successfully");
			WebDriver driver = getLatestDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);

			sendKeys(po_eCorp_fo.Input_SADADDebitAccountNumber,getData("DebitAccount"));
			//sendKey(po_eCorp_fo.Input_SADADDebitAccountNumber,Keys.TAB);
			driver.findElement(By.xpath("//*[contains(text(),'Biller Information')]")).click();
			//click(po_eCorp_fo.Search_DebitAccountNum);
			waitFor(15000);

			List<WebElement> tem = getLatestDriver().findElements(By.xpath("//table/tbody/tr/td[1]/div[@class='x-grid3-cell-inner x-grid3-col-0'][contains(.,'"+getData("DebitAccount")+"')]"));
			String sam = getData("DebitAccount");
			for (WebElement ele : tem) {
				System.out.println(ele.getText());
				waitFor(3000);
				if (ele.getText().equalsIgnoreCase(sam)) {
					Actions act = new Actions(driver);
					act.moveToElement(ele).doubleClick().build().perform();
					break;
				}
			}

			waitFor(5000);
			String avaBalance = getText(po_eCorp_fo.TextArea_SADADAvailableBalance);
			if (!(avaBalance.equalsIgnoreCase(""))) {
				ReportHelper.logReportStatus(LogStatus.PASS, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " has been validated and displayed as </b>"
						+ getText(po_eCorp_fo.TextArea_SADADAvailableBalance));
				String AvalBalAmt = avaBalance.split("SAR")[0].trim().replace(",", "");
				//Helper.saveTestDataToDb("AvailableBalance", AvalBalAmt);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "<b>Available Account Balance of Debit Account -" + getData("DebitAccount") + " is not displayed correctly </b>"
						+ getText(po_eCorp_fo.TextArea_SADADAvailableBalance));
			}

			sendKeys(po_eCorp_fo.Input_BillerName,getData("BillerName"));
			driver.findElement(By.xpath("//div[@id='billerLookUp']//img")).click();
			waitFor(7000);

			Actions act = new Actions(getLatestDriver());
			act.moveToElement(driver.findElement(By.xpath("//div[@class='x-grid3-row']//td[@class='x-grid3-col x-grid3-cell x-grid3-td-0 x-grid3-cell-first ']//div[contains(text(),'"+getData("BillerName")+"')]"))).doubleClick().build().perform();

			sendKeys(po_eCorp_fo.Input_BillerCategory,getData("BillerCategory"));
			driver.findElement(By.xpath("//div[@id='categryLookUp']//img")).click();
			waitFor(7000);

			//td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 ']//div[contains(text(),'Labor Visa')]
			act.moveToElement(driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-1 ']//div[contains(text(),'"+getData("BillerCategory")+"')]"))).doubleClick().build().perform();
			waitFor(3000);

			sendKeys(po_eCorp_fo.Input_SponsorID,getData("SponsorID"));
			waitFor(1000);
			Select VisaTyp = new Select(po_eCorp_fo.Select_VisaType);
			VisaTyp.selectByVisibleText(getData("VisaType"));
			sendKeys(po_eCorp_fo.Inputt_VisaCount,getData("VisaCount"));

			ReportHelper.logReportStatus(LogStatus.PASS,"SADAD MOI details entered successfully");
			scrollDown(po_eCorp_fo.Input_Biller_DebitAmount);
			click(po_eCorp_fo.Button_BillerInfo_GO);
			waitFor(10000);

			String PaymtAmt = getText(po_eCorp_fo.Input_Biller_DebitAmount);
			if (!PaymtAmt.equals("0.00")) {
				ReportHelper.logReportStatus(LogStatus.PASS,"Payment amount autopopulated successfully");
				waitFor(1000);
				click(po_eCorp_fo.Button_SubmitFundTransfer);
				waitFor(5000);

				String transactionReffN0 = getText(po_eCorp_fo.TextArea_SADADBiller_TxnReferenceNumber);
				if (transactionReffN0 != "") {
					ReportHelper.logReportStatus(LogStatus.PASS, "SADAD Bill Payments initiated and Transaction Reference Number (" +transactionReffN0 + ") is generated successfully" );
					//System.out.println(transactionReffN0);
					Helper.saveTestDataToDb("CBX_ReferenceNumber", transactionReffN0);
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "SADAD Bill Payments initiated and Transaction Reference Number is not generated successfully");
					Helper.saveTestDataToDb("CBX_ReferenceNumber", "NA");
				}

				click(po_eCorp_fo.Button_Confirm);
				waitFor(5000);
				String status = getText(driver.findElement(By.xpath("//form[@name='confirmationJSP']//tr[3]/td[4]")));
				if (status.equalsIgnoreCase("Ready for Authorization")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
					click(po_eCorp_fo.Button_Close_TopIndex);
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Status for '" + transactionReffN0
							+ "' is - '" + status + "'");
				}

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL,"Payment amount is shown as less than zero in Payment Info");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"SADAD MOI Payments failed due to '"+e.getMessage()+"'");
		}
	}

	public static void validateSADADMOIPaymentStatus()  {

		try {
			initPageObjects();
			getLatestDriver();
			String TranRefNum = getData("CBX_ReferenceNumber");
			boolean validation = false;

			click(po_eCorp_fo.HomePage_Payments);
			//waitTillElementIsNotVisible(po_eCorp_fo.HomePage_Payments);
			waitFor(10000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Payments are displayed successfully in the screen");

			click(po_eCorp_fo.Tab_SADADMOIPayment);
			waitFor(8000);

			String transactionStatus = waitAndGetTableText(po_eCorp_fo.Button_RefreshSADAD, "Processed by Bank",
					25, TranRefNum);

			if (transactionStatus.equalsIgnoreCase("Processed by Bank")) {
				ReportHelper.updateStatusDescDb=true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction status for "
						+ TranRefNum + " is: " + transactionStatus + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction status for :"
						+ TranRefNum + " is: " + transactionStatus + "");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,"Validate SADAD MOI Payment status failed due to '" +e.getMessage()+"'");
		}

	}
}
