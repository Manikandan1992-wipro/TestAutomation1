package POM.functions;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import FrameWork.listeners.po_BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.sql.Driver;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

import static FrameWork.helpers.Helper.getData;

import static FrameWork.helpers.Helper.saveTestDataToDb;
import static FrameWork.library.Util.click;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.library.Util.waitFor;
import static POM.functions.fn_allLogin.initPageObjects;

public class fn_eCorp_BO {

	public static void Select_BO_IGTBBH() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(6000);

			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			WebElement ele = getLatestDriver().findElement(By.xpath("//frame[@name='mainbot']"));
			driver.switchTo().frame(ele);

			//getLatestDriver().findElement(By.xpath("//img[@alt='IGTBBH']")).click();
			System.out.println("_--------->>>>>>>**********************");
			//System.out.println(getLatestDriver().findElement(By.xpath("//img[@alt='IGTBBH']")).getAttribute("src"));
			String check = "";
			check = driver.findElement(By.xpath("//div[@id='secondpage_06']//tbody/tr[2]/td[2]//img")).getAttribute("alt");
			driver.findElement(By.xpath("//div[@id='secondpage_06']//tbody/tr[2]/td[2]//img")).click();
			if (check.equals("IGTBSA") || check.equals(("IGTBBH"))) {
				ReportHelper.logReportStatus(LogStatus.INFO, "IGTBBH/IGTBSA back office icon is clicked");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "IGTBBH/IGTBSA back office icon is not clicked");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Logon to IGTBBH/IGTBSA failed" + e.getMessage());
		}

	}

	public static void SegementCreate() {
		try {

			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub1']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Segment Create displayed in the submenu");
			driver.findElement(By.xpath("//a[@name='sub3']")).click();
			waitFor(1000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			System.out.println(driver.getPageSource());
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			//driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='TopFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));

			System.out.println(driver.getPageSource());
			driver.findElement(By.xpath("//input[@id='txtCustomerSegmentName']")).sendKeys(getData("CustomerSegment"));
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Customer Segment Name entered in the Segment Create screen successfully");
			driver.findElement(By.xpath("//a[@class='Action_button']/span/span")).click();
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}
			waitFor(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
			waitFor(5000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}
			waitFor(2000);

			String Check = "";
			Check = driver.findElement(By.xpath("//*[@name='frmChild']//tbody/tr/td[2]")).getText();

			if (Check.contains("Customer Information added successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Information added successfully for Segment creation");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
				}
				waitFor(2000);
				driver.findElement(By.xpath("//span[text()='Close']")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Error occured on Segment creation");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Segment creation failed due to : <br>" + e.toString());
		}

	}

	public static void CustSgmtProf_SelAttribute() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(4000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub4']")).click();
			System.out.println("///////////////////////////////////////////////");
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add Customer Segment Profile displayed in the submenu");
			driver.findElement(By.xpath("//a[@name='sub6']")).click();

			//ReportHelper.logReportStatus(LogStatus.PASS, " back office icon is clicked");

			System.out.println(driver.getPageSource());

			System.out.println("----------------------------------===============================++++++++++++++++");
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			System.out.println(driver.getPageSource());
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.findElement(By.xpath("/html/body/div/form/div[5]/div[4]/table/tbody/tr[1]/td/a")).click();
			waitFor(2000);
			driver.findElement(By.xpath("//input[@name='txtProfileName']")).sendKeys(getData("CustProfileName"));
			Select CntrySgmt = new Select(driver.findElement(By.xpath("//select[@name='slctProfileCountry']")));
			CntrySgmt.selectByValue(getData("ProfileCountry"));
			Select Cust_Typ = new Select(driver.findElement(By.xpath("//select[@name='slctCustomerType']")));
			Cust_Typ.selectByValue(getData("CustType"));
			// To click save button
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in Customer Segment Profile Add");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Segment Profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void CustProf_SelectProdAndSubProdLink() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(4000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step1");

			driver.findElement(By.xpath("//div[5]/div[4]/table/tbody/tr[2]/td/a")).click();
			waitFor(2000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Product and SubProduct link is not clicked due to " + e.getMessage() + "'");
		}
	}

	public static void CustProf_SelProdAndSubProd1() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(4000);
			WebDriver driver = po_BaseClass.po_GetDriver();


			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));

			String[] Prodt = getData("Product_Items").split(",");
			int iLength = Prodt.length;
			int j = 0;
			for (int i = 0; i <= iLength - 1; i++) {
				//System.out.println(j);
				if (j == 3 || j == 5 || j == 7) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
					ReportHelper.logReportStatus(LogStatus.PASS, "Selected Sub Products entered successfully");
					//To click Add more products button
					driver.findElement(By.xpath("//div[@id='normalButtonPanel']//td/a[@class='Action_button'][1]")).click();
					waitFor(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
				}

				Select vProdt = new Select(driver.findElement(By.xpath("//select[@name='cboProductCode" + i + "']")));
				List<WebElement> ProdOpts = vProdt.getOptions();
				for (WebElement ProdItem : ProdOpts) {

					String cProdVal = ProdItem.getText();
					if (cProdVal.contains(Prodt[i])) {
						j = j + 1;
						//System.out.println("The value of 'Product"+i+"' is "+cProdVal);
						vProdt.selectByVisibleText(Prodt[i]);
						waitFor(1000);
						Select AvalSubProd = new Select(driver.findElement(By.xpath("//select[@name='$$cboSubProduct" + i + "']")));
						List<WebElement> AllSubProdOpts = AvalSubProd.getOptions();
						for (WebElement e : AllSubProdOpts) {
							e.click();
						}
						driver.findElement(By.xpath("//tr[" + j + "]/td[3]/div/input[@class='moveToRightBtn']")).click();

						Select ChkSeltdSubProd1 = new Select(driver.findElement(By.xpath("//select[@name='cboSubProductCode" + i + "']")));
						List<WebElement> ChkSeltdSubProd2 = ChkSeltdSubProd1.getOptions();
						String vProdFunc = ProdItem.getText();
						if (ChkSeltdSubProd2.size() == AllSubProdOpts.size()) {
							ReportHelper.logReportStatus(LogStatus.PASS, vProdFunc + " sub Product added successfully");
						} else {
							ReportHelper.logReportStatus(LogStatus.FAIL, vProdFunc + " sub Product added is not successful");
						}
						break;
					}
				}
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "All Selected Sub Products entered successfully");
			driver.findElement(By.xpath("//a[4]/span/span[contains(text(),'Save')]")).click();

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Product and SubProduct in customer Segment Profile failed due to " + e.getMessage() + "'");
		}

	}

	public static void CustProf_SelProdAndSubProd() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(4000);
			WebDriver driver = po_BaseClass.po_GetDriver();


			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));

			String[] Prodt = getData("Product_Items").split(",");
			int iLength = Prodt.length;
			int j = 0;
			for (int i = 0; i <= iLength - 1; i++) {
				//System.out.println(j);
				if (j == 3 || j == 5 || j == 7) {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
					ReportHelper.logReportStatus(LogStatus.PASS, "Selected Sub Products entered successfully");
					//To click Add more products button
					driver.findElement(By.xpath("//div[@id='normalButtonPanel']//td/a[@class='Action_button'][1]")).click();
					waitFor(1000);
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
				}

				Select vProdt = new Select(driver.findElement(By.xpath("//select[@name='cboProductCode" + i + "']")));
				List<WebElement> ProdOpts = vProdt.getOptions();
				for (WebElement ProdItem : ProdOpts) {

					String cProdVal = ProdItem.getText();
					if (cProdVal.contains(Prodt[i])) {
						j = j + 1;
						//System.out.println("The value of 'Product"+i+"' is "+cProdVal);
						vProdt.selectByVisibleText(Prodt[i]);
						waitFor(1000);
						Select AvalSubProd = new Select(driver.findElement(By.xpath("//select[@name='$$cboSubProduct" + i + "']")));
						List<WebElement> AllSubProdOpts = AvalSubProd.getOptions();
						for (WebElement e : AllSubProdOpts) {
							e.click();
						}
						driver.findElement(By.xpath("//tr[" + j + "]/td[3]/div/input[@class='moveToRightBtn']")).click();

						Select ChkSeltdSubProd1 = new Select(driver.findElement(By.xpath("//select[@name='cboSubProductCode" + i + "']")));
						List<WebElement> ChkSeltdSubProd2 = ChkSeltdSubProd1.getOptions();
						String vProdFunc = ProdItem.getText();
						if (ChkSeltdSubProd2.size() == AllSubProdOpts.size()) {
							ReportHelper.logReportStatus(LogStatus.PASS, vProdFunc + " sub Product added successfully");
						} else {
							ReportHelper.logReportStatus(LogStatus.FAIL, vProdFunc + " sub Product added is not successful");
						}
						break;
					}
				}
			}

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "All Selected Sub Products entered successfully");
			driver.findElement(By.xpath("//a[4]/span/span[contains(text(),'Save')]")).click();

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Product and SubProduct in customer Segment Profile failed due to " + e.getMessage() + "'");
		}

	}

	public static void CustProf_SelectFuncForEachProdLink() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Products and sub products added successfully");
			driver.findElement(By.xpath("//div[5]/div[4]/table/tbody/tr[3]/td/a")).click();
			waitFor(2000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Product for each function link is not clicked due to '" + e.getMessage() + "'");
		}

	}

	public static void CustProf_SelFunctForEachProd() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the first function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();

			/// fuct2
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the second function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();
			//funct 3
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the third function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();
//funct 4
			//funct 3
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the fourth function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();

			//fuvt 5
			//funct 3
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the fifth function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();

			//fuct 6
			//funct 3
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the sixth function");
			driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();

			//fuct 7
			//funct 3
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));

			ReportHelper.logReportStatus(LogStatus.PASS, "All Selected Products for each function entered successfully");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Product for each function in customer segment profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void CustProf_SelFunctForEachProd2() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();


			String[] Prod = getData("Product_Items").split(",");
			for (int i = 0; i < Prod.length - 1; i++) {
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
				driver.findElement(By.xpath("//input[@name='All']")).click();
				driver.switchTo().defaultContent();

				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the first function");
				driver.findElement(By.xpath("//span[contains(text(),'Next Product')]")).click();
			}


			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='headerFrame']")));
			driver.findElement(By.xpath("//input[@name='All']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));

			ReportHelper.logReportStatus(LogStatus.PASS, "All Selected Products for each function entered successfully");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Product for each function in customer segment profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void CustSgmtProf_ReviewConfirm() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Selected Products for each function added successfully");
			driver.findElement(By.xpath("//div[5]/div[4]/table/tbody/tr[4]/td/a")).click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data displayed correctly");
			driver.findElement(By.xpath("//a/span/span[contains(text(),' Confirm ')]")).click();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			String Check = "";
			Check = driver.findElement(By.xpath("//table//tr/td[@class='fontFormElements']")).getText();

			if (Check.contains("Customer Segment Profile Details Added Successfully and Profile Id")) {
				waitFor(5000);
				String[] LastChar = Check.split("is");
				//System.out.println(LastChar[1]);
				String ProfId = LastChar[1].trim();
				Helper.saveTestDataToDb("Profile_ID", ProfId);
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Segment Profile added successfully and Profile ID '" + ProfId + "' is generated");
				waitFor(1000);
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Error occured on Segment creation");

			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Review confirm in segment profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void BO_IGTBBH_Logout() {

		try {
			initPageObjects();
			getLatestDriver();
			//waitFor(2000);

			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='pmtop']")));
			driver.findElement(By.xpath("//a[@class='Action_button_signoff']")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "IGTBHH/IGTBSA failed due to '" + e.getMessage() + "'");
		}

	}

	public static void Authorise() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub3']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize displayed in the Customer Segment Profile submenu");
			driver.findElement(By.xpath("//a[@name='sub5']")).click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);
			Select CntrySgmt = new Select(driver.findElement(By.xpath("//*[@name='cmbProfileId']")));
			CntrySgmt.selectByValue(getData("Profile_ID"));
			waitFor(2000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Profile ID entered correctly");
			driver.findElement(By.xpath("//a/span/span[contains(text(),'Submit ')]")).click();
			waitFor(5000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));

			ReportHelper.logReportStatus(LogStatus.PASS, "Profile ID details displayed successfully");
			driver.findElement(By.xpath("//a/span/span[contains(text(),' Authorize')]")).click();
			waitFor(8000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			String Check = "";
			Check = driver.findElement(By.xpath("//table//tr/td[@class='fontFormElements']")).getText();
			if (Check.contains("Customer Segment Profile authorized successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Segment Profile for Name:" + getData("CustProfileName") + " authorized successfully ");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Error occured on Segment creation");

			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of Customer Segment Profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void Roles_Add() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub25']")).click();
			waitFor(4000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add Roles displayed in the Roles submenu");
			driver.findElement(By.xpath("//a[@name='sub27']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(5000);

			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(Keys.ENTER);
			waitFor(10000);

			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='txtCompName']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF details autopopulated correctly");

				String role = getData("Role_data");
				String[] role_list = role.split(",");

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

				if (role_list.length < 2) {
					driver.findElement(By.xpath("//table[@id='tableover']//td[contains(span,'1')]/following::input[contains(@name,'txtRoleA')][1]")).sendKeys(role_list[0]);
				} else {
					for (int i = 1; i <= role_list.length; i++) {

						if (i == 1) {
							driver.findElements(By.xpath("//table[@id='tableover']//td[contains(span,'1')]/following::input[contains(@name,'txtRole')][1]")).get(0).sendKeys(role_list[0]);
						} else {
							String xpath_val = "//table[@id='tableover']//td[contains(span,'" + i + "')]/following::input[contains(@name,'txtRole')][1]";
							driver.findElement(By.xpath(xpath_val)).sendKeys(role_list[i - 1]);

						}
					}
				}
				ReportHelper.logReportStatus(LogStatus.PASS, "All roles entered successfully");
				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Roles added successfully");
				driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();


				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

				if (!reference_no.equals("")) {
					waitFor(5000);
					ReportHelper.updateStatusDescDb = true;
					saveTestDataToDb("Role_RefNo", reference_no);
					ReportHelper.logReportStatus(LogStatus.PASS, "Role created and send for Authorisation");
					driver.close();
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Role not created");
				}

			} else {
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records for the entered GCIF found");
				driver.findElement(By.xpath("//span[@class='right']")).click();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of Roles failed due to '" + e.getMessage() + "'");
		}


	}

	public static void Role_Authorize() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub17']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize Roles displayed in the Roles submenu");
			driver.findElement(By.xpath("//a[@name='sub19']")).click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);
			String role = getData("Role_RefNo");
		/*String RolePath = "//span[contains(text(),'"+role+"')]";
		System.out.println(RolePath);*/
			driver.findElement(By.xpath("//span[contains(text(),'" + role + "')]")).click();
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Reference No '" + getData("Role_RefNo") + "' entered correctly");
			driver.findElement(By.xpath("//a//span[contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);

			if (RoleMsg.contains("Role Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Role authorized successfully for GCIF: " + getData("GCIF"));
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Role is not authorized successfully");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of roles failed due to '" + e.getMessage() + "'");
		}

	}


	public static void Role_View() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);

			driver.findElement(By.xpath("//a[@name='sub25']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize Roles displayed in the Roles submenu");
			driver.findElement(By.xpath("//a[@name='sub26']")).click();
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(5000);
			driver.findElement(By.xpath("//span[contains(text(),'Advanced Search')]")).click();
			String role = getData("Role_RefNo");
			driver.findElement(By.name("REF_NO")).sendKeys(role);
			waitFor(1000);
			driver.findElement(By.xpath("//span[@class='right'][contains(.,'Submit')]")).click();
			waitFor(5000);

			String Status = driver.findElement(By.xpath("//td[5]/span[@class='text']")).getText();
			if (Status.equals("Authorized")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Verification of Roles failed due to '" + e.getMessage() + "'");
		}

	}

	public static void BasicInfo_CustDetails() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub41']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub42']")).click();
			waitFor(2000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add displayed in the Basic Info submenu");
			driver.findElement(By.xpath("//a[@name='sub44']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			waitFor(1000);
			driver.findElement(By.xpath("//div/div/table/tbody/tr[1]/td[2]/a")).click();
			waitFor(1000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpmain']")));
			driver.findElement(By.xpath("//input[@name='COMPANY_ID']")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//input[@name='COMPANY_ID']")).sendKeys(Keys.ENTER);
			waitFor(5000);

			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='COMPANY_NAME']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details autopopulated successfully");
				Select sel = new Select(driver.findElement(By.xpath("//select[@name='NATIONALID_TYPE']")));
				sel.selectByIndex(1);
				waitFor(1000);
				driver.findElement(By.xpath("//*[@name='EXPIRY_DATE']")).sendKeys(getData("BasicInfo_ExpDate"));
				driver.findElement(By.xpath("//*[@name='NATIONALID']")).sendKeys(getData("NationalID"));
				driver.findElement(By.xpath("//*[@name='FIRST_NAME']")).sendKeys(getData("FirstName"));
				driver.findElement(By.xpath("//*[@name='LAST_NAME']")).sendKeys(getData("LastName"));

				Select UserTyp = new Select(driver.findElement(By.xpath("//*[@name='USER_TYPE']")));
				UserTyp.selectByValue(getData("UserType"));

				Select AuthTyp = new Select(driver.findElement(By.xpath("//*[@name='AUTH_TYPE']")));
				AuthTyp.selectByValue(getData("AuthType"));

				waitFor(1000);
				driver.findElement(By.xpath("//*[@name='LOGIN_ID']")).sendKeys(getData("LoginID"));
				driver.findElement(By.xpath("//*[@name='LINE1']")).sendKeys(getData("AddressDtls"));
				driver.findElement(By.xpath("//*[@name='CITY']")).sendKeys(getData("AddressDtls"));
				driver.findElement(By.xpath("//*[@name='COUNTRY']")).sendKeys(getData("AddressDtls"));
				driver.findElement(By.xpath("//*[@name='ZIP_CODE']")).sendKeys(getData("AddressDtls"));

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpbottom']")));
				waitFor(2000);
				ReportHelper.logReportStatus(LogStatus.PASS, "All Data entered successfully in Basic Info - Customer Details");
				driver.findElement(By.xpath("//*[contains(text(),'Next')]")).click();
				waitFor(2000);

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpmain']")));
				driver.findElement(By.xpath("//*[@name='EMAIL_ID']")).sendKeys(getData("EmailID"));
				driver.findElement(By.xpath("//*[@name='MOBILE_NO']")).sendKeys(getData("MobileNo"));

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpbottom']")));
				waitFor(2000);
				ReportHelper.logReportStatus(LogStatus.PASS, "EmailID and Mobile No entered successfully");
				driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
			} else {

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records for the entered GCIF found");
				driver.findElement(By.xpath("//span[@class='right']")).click();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of Basic Info failed due to '" + e.getMessage() + "'");
		}

	}

	public static void SelectCustomerUser() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step1");
			driver.findElement(By.xpath("//div/div/table/tbody/tr[2]/td[2]/a")).click();
			waitFor(5000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in Select Customer User");
			driver.findElement(By.xpath("//*[contains(text(),'Save')]")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer user selection failed due to '" + e.getMessage() + "'");
		}
	}

	public static void BsicInfo_DefineUserRole() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step2");

			driver.findElement(By.xpath("//div/div/table/tbody/tr[3]/td[2]/a")).click();
			waitFor(3000);
			//	Select sel=new Select(driver.findElement(By.xpath("//select[@name='GROUP']")));
			//	sel.selectByIndex(1);
			Select sel1 = new Select(driver.findElement(By.xpath("//select[@name='ROLE" + getData("GCIF") + "']")));
			sel1.selectByIndex(1);
			ReportHelper.logReportStatus(LogStatus.PASS, "GCIF entered successfully");
			driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "User role of Basic Info failed due to '" + e.getMessage() + "'");
		}

	}

	public static void BsicInfo_ReviewAndConfirm() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step3");
			driver.findElement(By.xpath("//div/div/table/tbody/tr[4]/td[2]/a")).click();
			waitFor(3000);
			//	Select sel=new Select(driver.findElement(By.xpath("//select[@name='GROUP']")));
			//	sel.selectByIndex(1);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpbottom']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Data displayed correctly");
			driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();

			waitFor(8000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

			if (!reference_no.equals("")) {
				waitFor(8000);
				saveTestDataToDb("Role_RefNo", reference_no);

				ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' created and send for Authorisation");
				driver.close();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Reference number is not generated");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Review confirmation of basic info failed due to '" + e.getMessage() + "'");
		}
	}


	public static void BasicInfo_Authorize() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub27']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub28']")).click();
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize displayed in the Basic Info submenu");
			driver.findElement(By.xpath("//a[@name='sub30']")).click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);
			String role = getData("Role_RefNo");
			driver.findElement(By.xpath("//span[contains(text(),'" + role + "')]")).click();
			waitFor(5000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='corpbottom']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Reference No '" + getData("Role_RefNo") + "' entered correctly");
			driver.findElement(By.xpath("//a//span[contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);

			if (RoleMsg.contains("Customer User Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer User for GCIF:" + getData("GCIF") + "authorized successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Customer User is not authorized successfully");
				driver.close();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of basic info failed due to '" + e.getMessage() + "'");
		}
	}

	public static void BasicInfo_View() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub41']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub42']")).click();
			waitFor(2000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add displayed in the Basic Info submenu");
			driver.findElement(By.xpath("//a[@name='sub43']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			waitFor(1000);
			driver.findElement(By.xpath("//span[contains(.,'Advanced Search')]")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//*[@name='REF_NO']")).sendKeys(getData("Role_RefNo"));
			driver.findElement(By.xpath("//span[@class='right' and contains(.,'Submit')]")).click();
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"tableover\"]/tbody/tr[2]/td[7]/span"));
			if (ele.isDisplayed()) {
				String check = ele.getText();
				if (check.equalsIgnoreCase("Authorized")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "For Basic Add Reference ID:" + getData("Role_RefNo") + " the data is shown as Authorized as expected");
				} else {
					ReportHelper.logReportStatus(LogStatus.PASS, "For Basic Add Reference ID:" + getData("Role_RefNo") + " the data is Still not Authorized");
				}
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "NO records available for refernce ID :" + getData("Role_RefNo"));
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Basic Info View validation failed due to '" + e.getMessage() + "'");
		}

	}


	public static void UserGroupCreation_View() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub30']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub31']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Creation displayed in the UserGroup submenu");
			driver.findElement(By.xpath("//a[@name='sub32']")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "View displayed in the UserGroup submenu");
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//span[contains(.,'Advanced Search')]")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//*[@name='REF_NO']")).sendKeys(getData("Role_RefNo"));
			driver.findElement(By.xpath("//span[@class='right' and contains(.,'Submit')]")).click();
			waitFor(2000);

			if (driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[2]/td[7]/span")).isDisplayed()) {
				WebElement ele = driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[2]/td[7]/span"));
				String check = ele.getText();
				if (check.equalsIgnoreCase("Authorized")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "For User group craetion View Reference ID:" + getData("Role_RefNo") + " the data is shown as Authorized as expected");
				} else {
					ReportHelper.logReportStatus(LogStatus.PASS, "For User group craetion View  Reference ID:" + getData("Role_RefNo") + " the data is Still not Authorized");
				}
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "NO records available for refernce ID :" + getData("Role_RefNo"));
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of user group failed due to '" + e.getMessage() + "'");
		}

	}

	public static void CustomerRegisteration_view() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			ReportHelper.logReportStatus(LogStatus.PASS, "IGTBSA Page is Launched as expected");
			WebElement ele = driver.findElement(By.xpath("//*[@name='menu']"));
			driver.switchTo().frame(ele);
			driver.findElement(By.xpath("//*[@id='entlMenu']/a/span")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele2);
			driver.findElement(By.xpath("//*[@name='sub9']")).click();
			waitFor(5000);
			driver.findElement(By.xpath("//*[@name='sub10']")).click();
			waitFor(3000);
			//ReportHelper.logReportStatus(LogStatus.PASS,"Customer Registration Add displayed in the page successfully");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			waitFor(3000);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele4);
			WebElement ele3 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele3);

			driver.findElement(By.xpath("//span[contains(.,'Advanced Search')]")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//*[@name='REF_NO']")).sendKeys(getData("Role_RefNo"));
			driver.findElement(By.xpath("//span[@class='right' and contains(.,'Submit')]")).click();
			waitFor(2000);

			if (driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[2]/td[7]/span")).isDisplayed()) {
				WebElement ele7 = driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[2]/td[7]/span"));
				String check = ele7.getText();
				if (check.equalsIgnoreCase("Authorized")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "For Customer Registration Reference ID:" + getData("Role_RefNo") + " the data is shown as Authorized as expected");
				} else {
					ReportHelper.logReportStatus(LogStatus.PASS, "For Customer Registration Reference ID:" + getData("Role_RefNo") + " the data is Still not Authorized");
				}
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "NO records available for refernce ID :" + getData("Role_RefNo"));
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Custumer Registeration failed '" + e.getMessage() + "'");
		}

	}

	public static void SegementCreate_view() {
		try {

			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub1']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Segment Create displayed in the submenu");
			driver.findElement(By.xpath("//a[@name='sub2']")).click();
			waitFor(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));


			List<WebElement> segmentlist = driver.findElements(By.xpath("//*[@id=\"tableover\"]/tbody/tr/td[2]"));
			for (int i = 0; i < segmentlist.size(); i++) {
				if (segmentlist.get(i).getText().equals(getData("CustomerSegment").toUpperCase())) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Segment Name:" + getData("CustomerSegment") + " is dipalyed in Segement View  Successfully");
				}
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Segment view is failed due to <br>" + e.toString());
		}

	}

	public static void BO_CustProfile_view() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(4000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub4']")).click();
			System.out.println("///////////////////////////////////////////////");
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add Customer Segment Profile displayed in the submenu");
			driver.findElement(By.xpath("//a[@name='sub5']")).click();

			//ReportHelper.logReportStatus(LogStatus.PASS, " back office icon is clicked");

			//	System.out.println(driver.getPageSource());

			System.out.println("++++++++++++++-===============================++++++++++++++++");
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			System.out.println(driver.getPageSource());
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.findElement(By.xpath("//input[@name='txtProfileName']")).sendKeys(getData("CustProfileName"), Keys.ENTER);
			waitFor(1000);

			Select sam = new Select(driver.findElement(By.xpath("//select[@name='cmbStatus']")));
			sam.selectByIndex(1);

			driver.findElement(By.xpath("//span[@class='right' and contains(.,'Submit')]")).click();
			waitFor(2000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			System.out.println(driver.getPageSource());
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
			if (driver.findElement(By.xpath("//table[@id='tableover']//table[@id='tableover']//tr[4]//td[4]/span")).isDisplayed()) {
				WebElement ele7 = driver.findElement(By.xpath("//table[@id='tableover']//table[@id='tableover']//tr[4]//td[4]/span"));
				String check = ele7.getText();
				if (check.equalsIgnoreCase("Authorized")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "For Customer Segement profile the data is shown as Authorized as expected");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "For Customer Segement profile the data is Still not Authorized");
				}
				//driver.findElement(By.xpath("//span[@class='right' and contains(.,'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "NO records available for refernce ID :" + getData("Role_RefNo"));
			}


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Segment Profile failed due to '" + e.getMessage() + "'");
		}

	}

	public static void UserGroupCreation() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub30']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub31']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Creation displayed in the UserGroup submenu");
			driver.findElement(By.xpath("//a[@name='sub33']")).click();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//input[@name='text1']")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//input[@name='text1']")).sendKeys(Keys.ENTER);

			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='text2']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details autopopulated successfully");
				String Usergroupnames = getData("UserGroup_Details");
				String UserGrouplist[] = Usergroupnames.split(";");
				for (int i = 0; i < UserGrouplist.length; i++) {
					String row_value[] = UserGrouplist[i].split(",");

					driver.findElements(By.xpath("//form[@name='frmAddUserGroup']//table[@id='tableover']/tbody/tr/td[2]/input[@type='text']")).get((2 + i)).sendKeys(row_value[0]);
					driver.findElements(By.xpath("//form[@name='frmAddUserGroup']//table[@id='tableover']/tbody/tr/td[3]/input[@type='text']")).get((i)).sendKeys(row_value[1]);
					Select sel = new Select(driver.findElements(By.xpath("//form[@name='frmAddUserGroup']//table[@id='tableover']/tbody/tr/td[4]/select")).get(i));
					sel.selectByVisibleText(row_value[2]);
				}

				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				waitFor(1000);
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "All data entered successfully in the UserGroup Creation");
				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitFor(5000);
				ReportHelper.logReportStatus(LogStatus.PASS, "All data added successfully in the UserGroup Creation");
				driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
				waitFor(5000);

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

				if (!reference_no.equals("")) {
					waitFor(5000);
					ReportHelper.updateStatusDescDb = true;
					saveTestDataToDb("Role_RefNo", reference_no);
					ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' created and send for Authorisation");
					driver.close();
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Role not created");
				}
			} else {

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records for the entered GCIF found");
				driver.findElement(By.xpath("//span[@class='right']")).click();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of user group failed due to '" + e.getMessage() + "'");
		}

	}

	public static void UserGroup_Authorize() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(2000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}
			waitFor(2000);

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub20']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub21']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize displayed in the UserGroup submenu");
			driver.findElement(By.xpath("//a[@name='sub23']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='DataFrame']")));
			waitFor(2000);
			String role = getData("Role_RefNo");
			driver.findElement(By.xpath("//span[contains(text(),'" + role + "')]")).click();
			waitFor(5000);
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			ReportHelper.logReportStatus(LogStatus.PASS, "Reference No'" + getData("Role_RefNo") + "' entered correctly");
			driver.findElement(By.xpath("//a//span[contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);

			if (RoleMsg.contains("User Group Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "User Group authorized successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "User Group is not authorized successfully");
				driver.close();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of user group failed due to '" + e.getMessage() + "'");
		}

	}

	public static void UserActivationAdd() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub41']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub52']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add displayed in the User Activation submenu");
			driver.findElement(By.xpath("//a[@name='sub54']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(Keys.ENTER);
			waitFor(5000);

			if (driver.findElement(By.xpath("//div[5]/div[4]/table[2]/tbody/tr[3]/td[1]/a/span")).isDisplayed()) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details displayed successfully in the User Activation");
				driver.findElement(By.xpath("//div[5]/div[4]/table[2]/tbody/tr[3]/td[1]/a/span")).click();
				waitFor(5000);

				Select User = new Select(driver.findElement(By.xpath("//select[@name='USER']")));
				List<WebElement> AllUsers = User.getOptions();
				for (WebElement e : AllUsers) {
					e.click();
				}

				driver.findElement(By.xpath("//input[@name='bnMoveRightChannel']")).click();
				ReportHelper.logReportStatus(LogStatus.PASS, "Data entered successfully in the User Activation");
				driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
				waitFor(10000);

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

				if (!reference_no.equals("")) {
					waitFor(8000);
					ReportHelper.updateStatusDescDb = true;
					saveTestDataToDb("Role_RefNo", reference_no);
					ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' is created and send for Authorisation");
					driver.close();
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Reference Number is not generated");
				}
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "No pending user for the entered GCIF");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of user activation failed due to '" + e.getMessage() + "'");
		}


	}

	public static void UserActivation_Authorize() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);

			driver.findElement(By.xpath("//a[@name='sub27']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub34']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize displayed in the User Activation submenu");
			driver.findElement(By.xpath("//a[@name='sub36']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			waitFor(2000);
			String role = getData("Role_RefNo");
			driver.findElement(By.xpath("//span[contains(text(),'" + role + "')]")).click();
			waitFor(5000);

			//String UserNo=getData("UserNo");
			driver.findElement(By.xpath("//div/table/tbody/tr[2]/td[1]/span/a")).click();
			//driver.findElement(By.xpath("//span[contains(text(),'"+role+"')]")).click();
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Reference No '" + getData("Role_RefNo") + "' entered correctly");
			driver.findElement(By.xpath("//a//span[contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);
			if (RoleMsg.contains("Pin Request Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "User Activation authorized successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);

				}
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "User Activation  is not authorized successfully");
				driver.close();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of user activation failed due to '" + e.getMessage() + "'");
		}
	}

	public static void UserActivation_View() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);

			driver.findElement(By.xpath("//a[@name='sub41']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub52']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "View displayed in the User Activation submenu");
			driver.findElement(By.xpath("//a[@name='sub53']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//span[contains(text(),'Advanced Search')]")).click();
			String role = getData("Role_RefNo");
			driver.findElement(By.name("REF_NO")).sendKeys(role);
			waitFor(2000);
			driver.findElement(By.xpath("//span[@class='right'][contains(.,'Submit')]")).click();
			waitFor(5000);

			String Status = driver.findElement(By.xpath("//td[5]/span[@class='text']")).getText();
			if (Status.equals("Authorized")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "View user activation failed due to '" + e.getMessage() + "'");
		}

	}

	public static void TxnWorkflow_Add() {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub56']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Add displayed in the Transaction Workflow Rules submenu");
			driver.findElement(By.xpath("//a[@name='sub58']")).click();
			waitFor(1000);

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);
			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(Keys.ENTER);
			waitFor(5000);

			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='COMPANY_NAME']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details autopopulated successfully in the Transaction Workflow Rules screen");

				Select CIF = new Select(driver.findElement(By.xpath("//select[@name='corpRuleCriteria']")));
				CIF.selectByValue(getData("CIF"));

				Select Prodt = new Select(driver.findElement(By.xpath("//select[@name='cboProduct']")));
				Prodt.selectByValue(getData("Product"));

				Select SubProd = new Select(driver.findElement(By.xpath("//select[@name='cmbSortBySource']")));
				SubProd.selectByValue(getData("SubProduct"));

				driver.findElement(By.xpath("//input[@name='txtRuleName']")).sendKeys(getData("RuleName"));
				driver.findElement(By.xpath("//input[@name='txtRuleDesc']")).sendKeys(getData("RuleName"));
				waitFor(1000);
				ReportHelper.logReportStatus(LogStatus.PASS, "All mandatory details entered successfully in the Transaction Workflow Rules screen");
				driver.findElement(By.xpath("//a[2]/span/span[contains(.,'Next Page')]")).click();
				waitFor(5000);

				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction workflow rules Details displayed successfully");
				driver.findElement(By.xpath("//input[@name='txtMin1']")).sendKeys(getData("MinimumAmt"));
				driver.findElement(By.xpath("//input[@name='txtMax1']")).sendKeys(getData("MaximumAmt"));
				driver.findElement(By.xpath("//input[@name='txtValue1']")).sendKeys(getData("NoOfAuth"));
				Select AuthRole = new Select(driver.findElement(By.xpath("//select[@name='cboRoleName1']")));
				AuthRole.selectByValue(getData("AuthRole"));
				ReportHelper.logReportStatus(LogStatus.PASS, "All mandatory fields entered successfully in the workflow rules");
				driver.findElement(By.xpath("//tr/td[@class='textfield']/a[contains(.,'Add')]")).click();
				waitFor(3000);

				String Rule = driver.findElement(By.xpath("//input[@name='txtTmpDisp1']")).getAttribute("value");
				if (!Rule.equals("")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "The value of Rule entered successfully");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "The value of rule entered is not successful");
				}
				//System.out.println(driver.findElement(By.xpath("//input[@name='txtTmpDisp1']")).getAttribute("value"));
				driver.findElement(By.xpath("//tr[4]/td[2]/a[contains(.,'Ok')]")).click();
				waitFor(3000);

				String FinalRule = driver.findElement(By.xpath("//textarea[@name='txtDisp1']")).getAttribute("value");
				if (!FinalRule.equals("")) {
					ReportHelper.logReportStatus(LogStatus.PASS, "The value of Final Rule entered successfully");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "The value of Final rule entered is not successful");
				}
				//System.out.println(driver.findElement(By.xpath("//textarea[@name='txtDisp1']")).getAttribute("value"));

				driver.findElement(By.xpath("//a/span/span[contains(.,'Save')]")).click();
				waitFor(5000);
				ReportHelper.logReportStatus(LogStatus.PASS, "All transaction workflow rules details displayed correctly");

				driver.findElement(By.xpath("//a/span/span[contains(.,'Confirm')]")).click();
				waitFor(2000);

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

				if (!reference_no.equals("")) {
					waitFor(8000);
					saveTestDataToDb("Role_RefNo", reference_no);
					ReportHelper.updateStatusDescDb = true;
					ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' is created and send for Authorisation");
					driver.close();
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Reference Number is not generated");
				}
			} else {

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records for the entered GCIF found");
				driver.findElement(By.xpath("//span[@class='right']")).click();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Creation of Transaction workflow rules failed due to '" + e.getMessage() + "'");
		}

	}

	public static void TxnWorkflow_Authorize() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub37']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize Roles displayed in the Transaction workflow Rules submenu");
			driver.findElement(By.xpath("//a[@name='sub39']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			System.out.println(driver.getPageSource());
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			waitFor(2000);
			String role = getData("Role_RefNo");
			System.out.println(role);
		/*String RolePath = "//span[contains(text(),'"+role+"')]";
		System.out.println(RolePath);*/
			driver.findElement(By.xpath("//a/span[contains(text(),'" + role + "')]")).click();
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Reference No '" + getData("Role_RefNo") + "' entered correctly");
			driver.findElement(By.xpath("//a//span[contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);
			if (RoleMsg.contains("Rule Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Transaction workflow Rules authorized successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);

				}
				driver.close();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Transaction workflow Rules is not authorized successfully");
				driver.close();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Authorization of transaction workflow rules failed due to '" + e.getMessage() + "'");
		}

	}

	public static void TxnWorkflow_View() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub56']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "View displayed in the Transaction workflow Rules submenu");
			driver.findElement(By.xpath("//a[@name='sub57']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//span[contains(text(),'Advanced Search')]")).click();
			String role = getData("Role_RefNo");
			driver.findElement(By.name("REF_NO")).sendKeys(role);
			waitFor(2000);
			driver.findElement(By.xpath("//span[@class='right'][contains(.,'Submit')]")).click();
			waitFor(5000);

			String Status = driver.findElement(By.xpath("//td[7]/span[@class='text']")).getText();
			if (Status.equals("Authorized")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Verification of Transaction Workflow Rules failed due to '" + e.getMessage() + "'");
		}
	}

	/////
	public static void CustomerRegisteration() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			ReportHelper.logReportStatus(LogStatus.PASS, "IGTBSA Page is Launched as expected");
			WebElement ele = driver.findElement(By.xpath("//*[@name='menu']"));
			driver.switchTo().frame(ele);
			driver.findElement(By.xpath("//*[@id='entlMenu']/a/span")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele2);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[4]/td/a")).click();
			waitFor(5000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[6]/td/a")).click();
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Customer Registration Add displayed in the page successfully");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			waitFor(3000);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele4);
			WebElement ele3 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele3);
			driver.findElement(By.xpath("//a[@class='linkblue']")).click();
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 1 Select Customer Details you want to register displayed in the screen successfully");
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[1]/td[2]/input")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[1]/td[2]/input")).sendKeys(Keys.TAB);
			waitFor(5000);

			/*			String name="Intellect Suite - Enterprise Platform for Boundaryless Banking from Polaris Software";
			String win=driver.getTitle();
			if(win.equals(name))
            {
                ReportHelper.logReportStatus(LogStatus.INFO,"Customer Details autopopulated successfully");*/
			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='txtCorporateName']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details autopopulated successfully");
				driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[3]/span/span")).click();
				waitFor(2000);
				SelectTemplate();
				OperationalLimits();
				waitFor(5000);
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step1");
				driver.findElement(By.xpath("//div[5]/div[5]/table/tbody/tr[4]/td/a")).click();
				waitFor(2000);
				CustProf_SelProdAndSubProd();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Products and sub products added successfully");
				driver.findElement(By.xpath("//div[5]/div[5]/table/tbody/tr[5]/td/a")).click();
				CustProf_SelFunctForEachProd2();
				CustReg_ReviewConfirm();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records found for the entered GCIF");
				driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a/span/span")).click();
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Custumer Registeration failed '" + e.getMessage() + "'");
		}

	}

	//
	public static void SelectTemplate() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(3000);
			driver.findElement(By.xpath("//form/div[5]/div[5]/table/tbody/tr[2]/td/a")).click();
			waitFor(3000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 2 Select Template for Corporate displayed in the page successfully");
			driver.findElement(By.xpath("//*[@name='defTemplateCode']")).click();
			waitFor(2000);
			driver.findElement(By.xpath("//*[@name='defTemplateCode']/option[2]")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Template for Corporate details entered successfully");
			driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[3]/span/span")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Select Template function failed '" + e.getMessage() + "'");
		}
	}

	public static void OperationalLimits() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(3000);
			driver.findElement(By.xpath("//form/div[5]/div[5]/table/tbody/tr[3]/td/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 3 Enter Operational limits for corporates displayed in the page successfully");
			waitFor(5000);
			ReportHelper.logReportStatus(LogStatus.PASS, "Operational limits for corporates details entered successfully");
			driver.findElement(By.xpath("//*[@id=\"normalButtonPanel\"]/table/tbody/tr/td/a[3]/span/span")).click();
			waitFor(3000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Operational Limits function failed '" + e.getMessage() + "'");
		}
	}

	public static void CustReg_ReviewConfirm() throws Exception {

		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			driver.findElement(By.xpath("//form/div[5]/div[5]/table/tbody/tr[6]/td/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 6 - Review and Confirm that the information you entered is Correct displayed in the page successfully");
			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='BottomFrame']")));
			driver.findElement(By.xpath("//span[@class='right'][contains(text(),'Confirm')]")).click();
			waitFor(8000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

			if (!reference_no.equals("")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' is created and send for Authorisation");
				waitFor(8000);
				saveTestDataToDb("Role_RefNo", reference_no);
				driver.close();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Reference Number is not generated");
			}

			/*for (String sam : driver.getWindowHandles()) {
			    driver.switchTo().window(sam);
            }
			driver.manage().window().maximize();

			String Text = "";
			String Uno = "";
			Text = driver.findElement(By.xpath("//div/form/table[1]/tbody/tr/td[2]")).getText();
			Uno = driver.findElement(By.xpath("//form/table[2]/tbody/tr/td[2]")).getText();
			saveTestData("REFNO", Uno);
			ReportHelper.logReportStatus(LogStatus.PASS, Text);
			driver.findElement(By.xpath("//*[@id=\"normalButtonPanel\"]/table/tbody/tr/td/a/span/span")).click();*/


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Review confirmation failed" + e.getMessage() + "'");
		}
	}

	public static void CustomerRegisterationAuthorization() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele = driver.findElement(By.xpath("//*[@name='menu']"));
			driver.switchTo().frame(ele);
			driver.findElement(By.xpath("//*[@id='entlMenu']/a/span")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele2);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[4]/td/a")).click();
			waitFor(5000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[6]/td/a")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele4);
			WebElement ele6 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele6);
			String UFNO = getData("Role_RefNo");
			String Xpath = "//span[contains(text(),'" + UFNO + "')]";

			if (driver.findElement(By.xpath(Xpath)).isDisplayed() == true) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Registeration Authorization displayed in the page successfully");
				driver.findElement(By.xpath(Xpath)).click();
				waitFor(5000);
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
				}
				driver.switchTo().frame(ele1);
				driver.switchTo().frame(ele4);
				driver.switchTo().frame(ele6);
				WebElement ele5 = driver.findElement(By.xpath("//*[@name='BottomFrame']"));
				driver.switchTo().frame(ele5);
				driver.findElement(By.xpath("//a/span/span[contains(text(),'Authorize')]")).click();
				waitFor(8000);

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
				}
				String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
				String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
				saveTestDataToDb("Role_RefNo", reference_no);
				waitFor(7000);
				if (RoleMsg.contains("Customer Registration Authorized successfully")) {
					ReportHelper.updateStatusDescDb = true;
					ReportHelper.logReportStatus(LogStatus.PASS, "Customer Registration authorized successfully");
					for (String sam : driver.getWindowHandles()) {
						driver.switchTo().window(sam);
					}
					driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Registration is not authorized successfully");
					driver.close();
				}
	 /*           for (String sam : driver.getWindowHandles()) {
	                driver.switchTo().window(sam);
                    System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
                }
                String Text = driver.findElement(By.xpath("//form/table[1]/tbody/tr/td[2]")).getText();
                ReportHelper.logReportStatus(LogStatus.PASS, Text);
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//*[@id=\"normalButtonPanel\"]/table/tbody/tr/td/a/span/span")).click();*/
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records found for the entered Reference number '" + UFNO + "' in Customer Registration - Authorize screen");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Registeration Authorization failed" + e.getMessage() + "'");
		}

	}


	public static void Login_BO_GTPPP() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele = driver.findElement(By.xpath("//*[@name='mainbot']"));
			driver.switchTo().frame(ele);
			ReportHelper.logReportStatus(LogStatus.INFO, "User successfully logged into GTBPPP Page");
			driver.findElement(By.xpath("//div[@id='secondpage_06']//t" +
					"body/tr[2]/td[1]//img")).click();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "GTBPPP User failed to login due to '" + e.getMessage() + "'");
		}
	}

	/////
	public static void CustomerOnboarding() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam1 : driver.getWindowHandles()) {
				driver.switchTo().window(sam1);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().defaultContent();
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='main']"));
			driver.switchTo().frame(ele2);
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele1);
			if (driver.findElement(By.xpath("//a[@name='sub2']")).isDisplayed()) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GTPPP payment page is displayed in the screen successfully");
			}
			driver.findElement(By.xpath("//a[@name='sub2']")).click();
			waitFor(3000);
			driver.findElement(By.xpath("//a[@name='sub3']")).click();
			waitFor(3000);
			for (String sam2 : driver.getWindowHandles()) {
				driver.switchTo().window(sam2);
			}
			driver.switchTo().frame(ele2);
			WebElement ele3 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele3);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='F1']"));
			driver.switchTo().frame(ele4);

			if (driver.findElement(By.xpath("//td[2]/input[@name='cif']")).isDisplayed() == true) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Customer Onboarding Add/Modify displayed in the page successfully");
				driver.findElement(By.xpath("//form[@name='frm1']//tr/td[2]/a/img")).click();
				waitFor(5000);

				for (String sam3 : driver.getWindowHandles()) {
					driver.switchTo().window(sam3);
				}
				WebElement ele5 = driver.findElement(By.xpath("//*[@name='F1']"));
				driver.switchTo().frame(ele5);

				String CIFID = getData("CIF");
				String[] CIFID2 = CIFID.split("-");
				driver.findElement(By.xpath("//input[@name='cif']")).sendKeys(CIFID2[1]);
				driver.findElement(By.xpath("//td[@tabindex='4']")).click();
				waitFor(2000);

				driver.findElement(By.xpath("//a[contains(.,'" + CIFID + "')]")).click();
				waitFor(3000);
				for (String sam4 : driver.getWindowHandles()) {
					driver.switchTo().window(sam4);
				}
				driver.switchTo().frame(ele2);
				driver.switchTo().frame(ele3);
				driver.switchTo().frame(ele4);

				if (driver.findElement(By.xpath("//a[contains(.,'Generate New GCIF')]")).isDisplayed()) {
					ReportHelper.logReportStatus(LogStatus.PASS, "Customer Details for the entered CIF ID - '" + CIFID + "' autopopulated successfully");
					driver.findElement(By.xpath("//a[contains(.,'Generate New GCIF')]")).click();
					waitFor(5000);

					// to validate whether GCIF is generated after entering CIF details
					String vGCIF = driver.findElement(By.xpath("//*[@id='gcif0']")).getAttribute("value");
					if (vGCIF != "" && vGCIF != null) {
						ReportHelper.logReportStatus(LogStatus.PASS, "GCIF-'" + vGCIF + "' is generated successfully");
						waitFor(5000);
						Helper.saveTestDataToDb("GCIF", vGCIF);
						driver.findElement(By.xpath("//input[@name='gcif_name0']")).sendKeys(getData("GCIFName"));
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "GCIF-'" + vGCIF + "' is not generated successfully");
					}

					driver.findElement(By.xpath("//input[@id='chkPortal']")).click();
					waitFor(1000);
					driver.findElement(By.xpath("//*[@id='hrefLink2']")).click();
					waitFor(1000);
					Select sel1 = new Select(driver.findElement(By.xpath("//select[@name='newAccount']")));
					List<WebElement> NewAcct = sel1.getOptions();
					ReportHelper.logReportStatus(LogStatus.PASS, "New accounts displayed successfully under Account Onboarding section");
					driver.findElement(By.xpath("//*[@id='accButtons']/table/tbody/tr[2]/td")).click();
					waitFor(2000);

					Select sel2 = new Select(driver.findElement(By.xpath("//select[@name='onboardAccount']")));
					List<WebElement> OboardAcct = sel2.getOptions();

					if (NewAcct.size() == OboardAcct.size()) {
						ReportHelper.logReportStatus(LogStatus.PASS, "Account onboarding details added successfully");
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Account onboarding details are not added successfully");
					}
					driver.findElement(By.xpath("//td[contains(.,'Confirm')]")).click();
					waitFor(3000);

					driver.findElement(By.xpath("//*[@id='hrefLink3']")).click();
					Select sel = new Select(driver.findElement(By.xpath("//*[@id='service_tier']")));
					sel.selectByValue(getData("Charges_Segmt"));
					ReportHelper.logReportStatus(LogStatus.PASS, "Segment added successfully under Charges section");

					driver.findElement(By.xpath("//*[@id='hrefLink9']")).click();
					driver.findElement(By.xpath("//td[contains(text(),'Submit')]")).click();
					waitFor(5000);

					for (String sam4 : driver.getWindowHandles()) {
						driver.switchTo().window(sam4);
					}
					String RefNum = driver.findElement(By.xpath("//table[1]/tbody/tr/td/b")).getText();
					if (RefNum != "") {
						saveTestDataToDb("Role_RefNo", RefNum);
						ReportHelper.updateStatusDescDb = true;
						ReportHelper.logReportStatus(LogStatus.PASS, "Reference number '" + RefNum + "' is generated and New GCIF '" + getData("GCIF") + "' details submiited successfully");
						driver.findElement(By.xpath("//td[text()='Close']")).click();
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Reference number is not generated successfully");
					}

				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "'Generate New GCIF' in the screen is not displayed successfully");
				}
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Onboarding failed" + e.getMessage() + "'");
		}

	}

	///
	public static void Logout_BO_GTPPP() {
		try {
			waitFor(5000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			for (String sam4 : driver.getWindowHandles()) {
				driver.switchTo().window(sam4);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele6 = driver.findElement(By.xpath("//*[@name='bottom']"));
			driver.switchTo().frame(ele6);
			driver.findElement(By.xpath("//*[@alt='Logout']")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "GTPPP successfully logged out");
			waitFor(5000);
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "GTPPP failed to log out due to '" + e.getMessage() + "'");
		}
	}


	public static void CustomerOnboardingAuthorization() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam1 : driver.getWindowHandles()) {
				driver.switchTo().window(sam1);
			}
			driver.switchTo().defaultContent();
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='main']"));
			driver.switchTo().frame(ele2);
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele1);
			if (driver.findElement(By.xpath("//a[@name='sub2']")).isDisplayed() == true) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GTPPP payment displayed in the page successfully");
				driver.findElement(By.xpath("//a[@name='sub2']")).click();
				waitFor(1000);
				driver.findElement(By.xpath("//a[@name='sub4']")).click();
				waitFor(1000);
				for (String sam4 : driver.getWindowHandles()) {
					driver.switchTo().window(sam4);
				}
				waitFor(3000);
				WebElement ele4 = driver.findElement(By.xpath("//*[@name='main']"));
				driver.switchTo().frame(ele4);
				WebElement ele3 = driver.findElement(By.xpath("//*[@name='txnband']"));
				driver.switchTo().frame(ele3);
				String gRefNo = getData("Role_RefNo");

				String cRefNo = driver.findElement(By.xpath("//a[contains(.,'" + gRefNo + "')]")).getText();
				if (cRefNo.equals(gRefNo)) {
					ReportHelper.updateStatusDescDb = true;
					ReportHelper.logReportStatus(LogStatus.PASS, "Reference number '" + gRefNo + "' displayed in the Authorization page correctly");
					driver.findElement(By.xpath("//a[contains(.,'" + gRefNo + "')]")).click();
					waitFor(5000);
					for (String sam4 : driver.getWindowHandles()) {
						driver.switchTo().window(sam4);
					}

					driver.switchTo().frame(driver.findElement(By.xpath("//*[@name='F1']")));
					ReportHelper.logReportStatus(LogStatus.PASS, "Customer Onboarding Authorization Details displayed in the screen correctly");

					driver.findElement(By.xpath("//*[contains(text(),'Authorize')]")).click();
					waitFor(5000);
					for (String sam4 : driver.getWindowHandles()) {
						driver.switchTo().window(sam4);
					}

					String gAuthTxt = driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td")).getText();
					if (gAuthTxt.contains("Authorization Successfully Completed with Reference Number")) {
						ReportHelper.updateStatusDescDb = true;
						ReportHelper.logReportStatus(LogStatus.PASS, gAuthTxt);
						driver.findElement(By.xpath("//td[text()='Close']")).click();
					} else {
						ReportHelper.logReportStatus(LogStatus.FAIL, "Reference number is not authorized successfully");
					}
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "Reference number '" + gRefNo + "' is not found in the customer onboarding authorization list");
				}
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Customer Onboarding authorization failed" + e.getMessage() + "'");
		}
	}

	public static void UserProfileAdd() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele = driver.findElement(By.xpath("//*[@name='menu']"));
			driver.switchTo().frame(ele);
			driver.findElement(By.xpath("//*[@id='entlMenu']/a/span")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele2);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[9]/td/a")).click();
			waitFor(3000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[11]/td/a")).click();
			waitFor(3000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[13]/td/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Add User Profile is displayed in the screen");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			WebElement ele3 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele3);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele4);
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[1]/td[2]/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 1 Select the user groups is displayed in the screen successfully");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			waitFor(1000);
			driver.switchTo().frame(ele1);
			driver.switchTo().frame(ele3);
			driver.switchTo().frame(ele4);
			WebElement ele5 = driver.findElement(By.xpath("//*[@name='CompanyFrame']"));
			driver.switchTo().frame(ele5);
			waitFor(1000);
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[1]/td[2]/input")).sendKeys(getData("GCIF"));
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[1]/td[2]/input")).sendKeys(Keys.TAB);
			waitFor(5000);

			String Check = "";
			Check = driver.findElement(By.xpath("//input[@name='txtCompanyName']")).getAttribute("value");

			if (!Check.equals("")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "GCIF Details autopopulated successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
				}
				waitFor(1000);
				driver.switchTo().frame(ele1);
				driver.switchTo().frame(ele3);
				driver.switchTo().frame(ele4);
				WebElement ele6 = driver.findElement(By.xpath("//*[@name='ChannelFrame']"));
				driver.switchTo().frame(ele6);
				Select sel = new Select(driver.findElement(By.xpath("//*[@id='selct']")));
				sel.selectByIndex(1);
				//sel.selectByVisibleText("Maker");
				ReportHelper.logReportStatus(LogStatus.PASS, "All data entered successfully in Step 1");
				driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[3]/span/span")).click();
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
				}
				driver.switchTo().frame(ele1);
				driver.switchTo().frame(ele3);
				driver.switchTo().frame(ele4);
				driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[2]/td[2]/a")).click();
				ReportHelper.logReportStatus(LogStatus.PASS, "Step 2 Enter operational limits displayed in the screen successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
				}
				driver.switchTo().frame(ele1);
				driver.switchTo().frame(ele3);
				driver.switchTo().frame(ele4);
				ReportHelper.logReportStatus(LogStatus.PASS, "All mandatory details entered successfully in operational limits");
				driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[3]/span/span")).click();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Data added successfully in Step1");

				driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[3]/td[2]/a")).click();
				waitFor(2000);
				CustProf_SelProdAndSubProd();
				driver.switchTo().defaultContent();
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
				driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
				ReportHelper.logReportStatus(LogStatus.PASS, "Products and sub products added successfully");
				driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[4]/td[2]/a")).click();
				waitFor(2000);
				CustProf_SelFunctForEachProd2();
				//CustProf_SelFunctForEachProd();
				CustProfCre_CriteriaValue();
				User_ProfCreation_ReviewChanges();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "No records found for the entered GCIF");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "User Profile Add failed" + e.getMessage() + "'");
		}

	}

	//////
	public static void CustProfCre_CriteriaValue() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele4);
			WebElement ele3 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele3);
			driver.findElement(By.xpath("//*[@id='tableover']/tbody/tr[5]/td[2]/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 5 Define Criteria value for each User group is displayed in the screen successfully");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			driver.switchTo().frame(ele4);
			driver.switchTo().frame(ele3);
			WebElement ele5 = driver.findElement(By.xpath("//*[@name='BottomFrame']"));
			driver.switchTo().frame(ele5);
			driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[3]/span/span")).click();
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			driver.switchTo().frame(ele4);
			driver.switchTo().frame(ele3);
			driver.switchTo().frame(ele5);
			int Count = 0;
			Outer:
			do {

				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);
					System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
				}
				driver.switchTo().frame(ele1);
				driver.switchTo().frame(ele4);
				driver.switchTo().frame(ele3);
				WebElement ele6 = driver.findElement(By.xpath("//*[@name='DataFrame']"));
				driver.switchTo().frame(ele6);
				if (driver.findElements(By.xpath("//*[contains(@name,'cboCriteriaType')]")).isEmpty()) {

					for (String sam : driver.getWindowHandles()) {
						driver.switchTo().window(sam);
						System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
					}
					driver.switchTo().frame(ele1);
					driver.switchTo().frame(ele4);
					driver.switchTo().frame(ele3);
					driver.switchTo().frame(ele5);
					driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[4]/span/span")).click();
					Count += 1;
					if (Count == 2) {
						break Outer;
					}
				} else {
					List<WebElement> Slct = driver.findElements(By.xpath("//*[contains(@name,'cboCriteriaType')]"));
					List<WebElement> Slct1 = driver.findElements(By.xpath("//*[contains(@name,'cboAccountGrp')]"));
					List<WebElement> Slct2 = driver.findElements(By.xpath("//*[contains(@name,'cboAccNo')]"));
					List<WebElement> Slct3 = driver.findElements(By.xpath("//*[@class='moveToRightBtn']"));

					for (int i = 0; i < Slct.size(); i++) {
						Select Sel = new Select(Slct.get(i));
						Sel.selectByIndex(1);
						Select Sel1 = new Select(Slct1.get(i));
						Sel1.selectByIndex(1);
						Select AvalSubProd2 = new Select(Slct2.get(i));
						List<WebElement> AllSubProdOpts2 = AvalSubProd2.getOptions();
						for (WebElement e : AllSubProdOpts2) {
							e.click();
						}
						Slct3.get(i).click();
					}
					for (String sam : driver.getWindowHandles()) {
						driver.switchTo().window(sam);
						System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
					}
					driver.switchTo().frame(ele1);
					driver.switchTo().frame(ele4);
					driver.switchTo().frame(ele3);
					driver.switchTo().frame(ele5);
					driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[4]/span/span")).click();
					waitFor(3000);
					for (String sam : driver.getWindowHandles()) {
						driver.switchTo().window(sam);
						System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
					}
					driver.switchTo().frame(ele1);
					driver.switchTo().frame(ele4);
					driver.switchTo().frame(ele3);
					driver.switchTo().frame(ele5);

				}

			}
			while (driver.findElement(By.xpath("//*[@id='normalButtonPanel']/table/tbody/tr/td/a[4]/span/span")).isDisplayed());
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 5 Define Criteria value for each User group added successfully");
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Criteria value for each user group failed" + e.getMessage() + "'");
		}
	}


	/////
	public static void User_ProfCreation_ReviewChanges() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();


			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));

			driver.findElement(By.xpath("//*[@id=\"tableover\"]/tbody/tr[6]/td[2]/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Step 6 Review and confirm displayed in the screen successfully");

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				//System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(3000);
			driver.findElement(By.xpath("//*[@class='right'][contains(text(),'Confirm')]")).click();
			waitFor(5000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();

			if (!reference_no.equals("")) {
				waitFor(8000);
				ReportHelper.updateStatusDescDb = true;
				saveTestDataToDb("Role_RefNo", reference_no);
				ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number '" + reference_no + "' is created and send for Authorisation");
				driver.close();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Reference Number is not generated");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Review Changes failed" + e.getMessage() + "'");
		}
	}

	public static void UserProfileAddAuthorization() {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele = driver.findElement(By.xpath("//*[@name='menu']"));
			driver.switchTo().frame(ele);
			driver.findElement(By.xpath("//*[@id='entlMenu']/a/span")).click();
			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			WebElement ele1 = driver.findElement(By.xpath("//*[@name='fraH1V1']"));
			driver.switchTo().frame(ele1);
			WebElement ele2 = driver.findElement(By.xpath("//*[@name='submenu']"));
			driver.switchTo().frame(ele2);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[9]/td/a")).click();
			waitFor(3000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[11]/td/a")).click();
			waitFor(3000);
			driver.findElement(By.xpath("//*[@id='mtmtable']/tbody/tr[13]/td/a")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "User Profile Authorization dispalyed in the screen successfully");
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			WebElement ele4 = driver.findElement(By.xpath("//*[@name='txnband']"));
			driver.switchTo().frame(ele4);
			WebElement ele6 = driver.findElement(By.xpath("//*[@name='MainFrame']"));
			driver.switchTo().frame(ele6);

			String UFNO = getData("Role_RefNo");
			String Xpath = "//span[contains(text(),'" + UFNO + "')]";
			driver.findElement(By.xpath(Xpath)).click();
			waitFor(5000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
				System.out.println(driver.getWindowHandle() + "   " + driver.getTitle());
			}
			driver.switchTo().frame(ele1);
			driver.switchTo().frame(ele4);
			driver.switchTo().frame(ele6);
			driver.findElement(By.xpath("//span[@class='right'][contains(text(),'Authorize')]")).click();
			waitFor(10000);

			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}
			String RoleMsg = driver.findElement(By.xpath("//table[1]//tr/td[2]")).getText();
			String reference_no = driver.findElement(By.xpath("//table[2]//tr//td[@class='fontFormElements']")).getText();
			saveTestDataToDb("Role_RefNo", reference_no);
			if (RoleMsg.contains("User Group Profile Authorized Successfully")) {
				ReportHelper.updateStatusDescDb = true;
				ReportHelper.logReportStatus(LogStatus.PASS, "User Group Profile authorized successfully");
				for (String sam : driver.getWindowHandles()) {
					driver.switchTo().window(sam);

				}
				driver.findElement(By.xpath("//span[contains(text(),'Close')]")).click();
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "User Group Profile is not authorized successfully");
				driver.close();
			}
			/*for(String sam: driver.getWindowHandles())
	        {
                driver.switchTo().window(sam);
                System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
            }
			String Text=driver.findElement(By.xpath("//form/table[1]/tbody/tr/td[2]")).getText();
			ReportHelper.logReportStatus(LogStatus.PASS, Text);
			driver.findElement(By.xpath("//*[@id=\"normalButtonPanel\"]/table/tbody/tr/td/a/span/span")).click();*/

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "User Profile Add Authorization failed" + e.getMessage() + "'");
		}

	}

	public static void UserProfile_View() {
		try {

			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			waitFor(1000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));
			driver.findElement(By.xpath("//span[contains(text(),'Entitlements')]")).click();
			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(3000);

			driver.findElement(By.xpath("//a[@name='sub41']")).click();
			waitFor(1000);
			driver.findElement(By.xpath("//a[@name='sub47']")).click();
			waitFor(1000);
			ReportHelper.logReportStatus(LogStatus.PASS, "View displayed in the User Profiles submenu");
			driver.findElement(By.xpath("//a[@name='sub48']")).click();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(2000);

			driver.findElement(By.xpath("//span[contains(text(),'Advanced Search')]")).click();
			waitFor(2000);
			String role = getData("Role_RefNo");
			driver.findElement(By.name("REF_NO")).sendKeys(role);
			driver.findElement(By.xpath("//span[@class='right'][contains(.,'Submit')]")).click();
			waitFor(5000);

			String Status = driver.findElement(By.xpath("//td[7]/span[@class='text']")).getText();
			if (Status.equals("Authorized")) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Status for Reference No '" + getData("Role_RefNo") + "' is '" + Status + "'");
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Verification of User Profile failed due to '" + e.getMessage() + "'");
		}
	}

	/**
	 * This method is used to Disable the Login
	 *
	 * @throws Exception
	 */
	public static void DisableUser() {
		try {
			clickUserAccessMaintenance();

			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(1000);


			driver.findElement(By.xpath("//a[@title='Disable User']")).click();

			ReportHelper.logReportStatus(LogStatus.PASS, "Disable user is displayed in the submenu");

			enterGCIFAndLoginId();


			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}


			String referenceNumber = driver.findElement(By.xpath("//table[2]//tbody//tr//td[2]")).getText();

			saveTestDataToDb("disableUser_refno", referenceNumber);

			System.out.println(getData("disableUser_refno"));


			boolean isNumeric = referenceNumber.chars().allMatch(Character::isDigit);

			if (isNumeric) {
				ReportHelper.logReportStatus(LogStatus.PASS, "The referenceNumber" + referenceNumber + "is yet to be Authorized");

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "The reference number is not populated");
			}

			driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to disable the user" + e.getMessage() + "'");
		}

	}

	/**
	 * This method is used to Authorize the Disabled Login
	 *
	 * @throw Exception
	 */

	public static void DisableUser_Authorize() {
		try {
			clickUserAccessMaintenance();
			initPageObjects();
			getLatestDriver();
			WebDriver driver = po_BaseClass.po_GetDriver();

			clickAuthorize();


			driver.findElement(By.xpath("//a[@class='subtext' and text()='Disable User']")).click();


			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));


			List<WebElement> list = driver.findElements(By.xpath("//tr//td//a//span[@class='text']"));

			for (WebElement element : list) {


				if (getData("disableUser_refno").equals(element.getText())) {


					driver.findElement(By.xpath("//tr//td//a//span[@class='text']")).click();
					ReportHelper.logReportStatus(LogStatus.PASS, "The disable user valid reference number is clicked");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "The  reference number is  invalid");
				}
			}


			boolean flag1 = driver.findElement(By.xpath("//div[@class='sectionTitle']")).isDisplayed();
			if (flag1) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Please confirm the details to authorize disable user");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to authorize the disable user");
			}

			WebElement element1 = driver.findElement(By.xpath("//span[@class='right' and text()='Authorize']"));
			if (element1.isDisplayed()) {
				element1.click();
				ReportHelper.logReportStatus(LogStatus.PASS, "Authorize button has been clicked");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click Authorize button");
			}


			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Authorize the disable user" + e.getMessage() + "'");
		}
	}

	/**
	 * This method is used to Enable the Login
	 *
	 * @throws Exception
	 */


	public static void enableUser() {

		try {
			clickUserAccessMaintenance();

			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(1000);

			driver.findElement(By.xpath("//a[@title='Enable User']")).click();

			enterGCIFAndLoginId();

			waitFor(8000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}


			String msg = driver.findElement(By.xpath("//td[@class='fontFormElements' and contains(text(),'Request sent')]")).getText();

			if (msg.contains("Authorization")) {
				ReportHelper.logReportStatus(LogStatus.PASS, msg);
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Request not sent for Authorization");
			}

			String referenceNumber = driver.findElement(By.xpath("//table[2]//tbody//tr//td[2]")).getText();

			boolean isNumeric = referenceNumber.chars().allMatch(Character::isDigit);

			saveTestDataToDb("enableUser_refno", referenceNumber);

			if (isNumeric) {
				ReportHelper.logReportStatus(LogStatus.PASS, "The enable user " + referenceNumber + "is yet to be Authorized");

			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "The reference number is not populated");
			}

			driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Enable the user" + e.getMessage() + "'");
		}

	}


	/**
	 * This method is used to Authorize the Enabled  Login
	 *
	 * @throws Exception
	 */
	public static void enableUser_Authorize() {

		try {
			clickUserAccessMaintenance();

			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			clickAuthorize();
			driver.findElement(By.xpath("//a[@class='subtext' and text()='Enable User']")).click();


			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));

			List<WebElement> list = driver.findElements(By.xpath("//tr//td//a//span[@class='text']"));
			for (WebElement element : list) {


				if (getData("enableUser_refno").equals(element.getText())) {


					driver.findElement(By.xpath("//tr//td//a//span[@class='text']")).click();
					ReportHelper.logReportStatus(LogStatus.PASS, "The enable  user valid reference number is clicked");
				} else {
					ReportHelper.logReportStatus(LogStatus.FAIL, "The  enable user reference number is  invalid");
				}
			}


			boolean flag = driver.findElement(By.xpath("//div[@class='sectionTitle']")).isDisplayed();
			if (flag) {
				ReportHelper.logReportStatus(LogStatus.PASS, "Please confirm the details to authorize enable user");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to authorize the enable user");
			}

			WebElement element1 = driver.findElement(By.xpath("//span[@class='right' and text()='Authorize']"));
			if (element1.isDisplayed()) {
				element1.click();
				ReportHelper.logReportStatus(LogStatus.PASS, "Authorize button has been clicked");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click Authorize button");
			}


			waitFor(3000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}


			WebElement element = driver.findElement(By.xpath("//td[@class='fontFormElements' and contains(text(),'User enabled')]"));
			if (element.isDisplayed()) {
				ReportHelper.logReportStatus(LogStatus.PASS, "User enabled successfully");
			}
			driver.findElement(By.xpath("//a//span[contains(text(),'Close')]")).click();


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Authorize the user" + e.getMessage() + "'");
		}

	}


	/**
	 * This Method is used to click the User Access Maintenance in the menu
	 *
	 * @throws Exception
	 */
	private static void clickUserAccessMaintenance() {
		try {
			initPageObjects();
			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();
			driver.switchTo().defaultContent();
			waitFor(5000);
			for (String sam : driver.getWindowHandles()) {
				driver.switchTo().window(sam);
			}

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='menu']")));

			driver.findElement(By.xpath("//*[@id='userMenu']/a/span")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "User Access Maintenance is clicked");

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "unable to click User Access Maintenance " + e.getMessage() + "'");
		}
	}

	/**
	 * This Method is used to enter GCIF and Login ID values.
	 *
	 * @throws Exception
	 */

	private static void enterGCIFAndLoginId() {
		try {

			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='txnband']")));

			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='MainFrame']")));
			waitFor(1000);

			driver.findElement(By.xpath("//input[@name='txtGCIF']")).sendKeys(getData("GCIF"));

			ReportHelper.logReportStatus(LogStatus.PASS, "GCIF value is Entered");

			waitFor(4000);

			String loginId = getData("LoginIdValue");
			System.out.println(loginId);
			driver.findElement(By.name("LOGIN_ID")).click();
			WebElement element = driver.findElement(By.name("LOGIN_ID"));
			Select select = new Select(element);
			waitFor(4000);
			select.selectByVisibleText(loginId);

			String reason = getData("ReasonValue");
			Select select1 = new Select(driver.findElement(By.name("REASON")));
			select1.selectByVisibleText(reason);

			ReportHelper.logReportStatus(LogStatus.PASS, " Reason is selected");

			driver.findElement(By.xpath("//span[@class='right' and text()='Submit']")).click();

			driver.findElement(By.xpath("//span[@class='right' and text()='Confirm']")).click();

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to enter the GCIF and LoginId" + e.getMessage() + "'");
		}
	}


	private static void clickAuthorize() {
		try {

			getLatestDriver();
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(2000);
			driver.findElement(By.xpath("//a[@name='sub49']")).click();
			ReportHelper.logReportStatus(LogStatus.PASS, "Authorize menu is clicked");


		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click Authorize " + e.getMessage() + "'");
		}
	}


	public static void generatePin() {
		try {
			clickUserAccessMaintenance();

			getLatestDriver();
			waitFor(2000);
			WebDriver driver = po_BaseClass.po_GetDriver();

			driver.switchTo().defaultContent();
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='fraH1V1']")));
			waitFor(1000);
			driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='submenu']")));
			waitFor(1000);

			driver.findElement(By.xpath("//a[@title='Generate PIN']")).click();
			waitFor(30000);

			WebElement element = driver.findElement(By.xpath("//td[@class='ez1' and contains(text(),'Pin')]"));

			if (element.isDisplayed()) {
				ReportHelper.logReportStatus(LogStatus.PASS, "PIN Generated successfully");
			} else {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Generate PIN");
			}
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to generate pin " + e.getMessage() + "'");
		}
	}
}















