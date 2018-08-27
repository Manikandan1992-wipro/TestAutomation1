package POM.functions;

import FrameWork.helpers.ReportHelper;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_UBS;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.loginCredentials;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.waitFor;
import static POM.functions.fn_allLogin.initPageObjects;


public class FetchOTP {

    public static String workingDir;
    public static String subFolder;
    public static String driverFolder;


    public static String getOTP() throws InterruptedException {

        workingDir = System.getProperty("user.dir");
        subFolder = workingDir + "\\src\\main\\resources\\";
        driverFolder = workingDir + "\\src\\main\\resources\\drivers\\";

        String chromedriver = driverFolder + "chromeDriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://10.14.5.94:899/Home/Index");
        Thread.sleep(1000);
        webDriver.findElement(By.id("btnGetOTP")).click();

        String otp = webDriver.findElement(By.xpath("//*[@id='body']/section/table/tbody/tr[2]/td[2]")).getText();
        Thread.sleep(1000);
        webDriver.quit();
        return otp;

    }

    public static String getInternationalOTP() throws InterruptedException {

        workingDir = System.getProperty("user.dir");
        subFolder = workingDir + "\\src\\main\\resources\\";
        driverFolder = workingDir + "\\src\\main\\resources\\drivers\\";

        String chromedriver = driverFolder + "chromeDriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://10.14.5.94:899/Home/Index");

        Thread.sleep(5000);
        webDriver.findElement(By.id("btnGetOTP")).click();


        Thread.sleep(5000);
        String otp = webDriver.findElement(By.xpath("//*[@id='body']/section/table/tbody/tr[2]/td[2]")).getText();
        webDriver.quit();

        return otp;

    }


    public static void UBSValidation_MeemAndroid() throws InterruptedException {

        try {

            workingDir = System.getProperty("user.dir");
            subFolder = workingDir + "\\src\\main\\resources\\";
            driverFolder = workingDir + "\\src\\main\\resources\\drivers\\";

            String chromedriver = driverFolder + "chromeDriver.exe";
            System.setProperty("webdriver.chrome.driver", chromedriver);
            WebDriver driver = new ChromeDriver();
            driver.get("http://ubsapptst8:15831/FCJNeoWebWhBah");

            for (String sam : driver.getWindowHandles()) {
                driver.switchTo().window(sam);
            }

            Thread.sleep(2000);
            WebElement infomsg = driver.findElement(By.xpath("//iframe[@title='Information Message']"));
            driver.switchTo().frame(infomsg);
            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();

            driver.switchTo().defaultContent();

            driver.findElement(By.id("USERID")).sendKeys("mani02");
            driver.findElement(By.id("PASSWORD")).sendKeys("Oracle@4");
            driver.findElement(By.xpath("//*[@id='fc_sbmit']")).click();
            ReportHelper.logReportStatus(LogStatus.PASS, "UBS Login successfully");


            WebElement alertwin = driver.findElement(By.xpath("//iframe[@id='ifr_AlertWin']"));
            driver.switchTo().frame(alertwin);
            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();

            driver.switchTo().defaultContent();

            WebElement element = driver.findElement(By.xpath("//span[@class='ICOonline'][contains(.,'Branch Is Online')]"));
            WebElement elem = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.visibilityOf(element));
            (new Actions(driver)).moveToElement(elem).perform();

            Thread.sleep(1000);
            driver.findElement(By.xpath(" //*[@id='nav']//b[@title='Select Branch']")).click();


            //click(po_UBS.Select_UBS_SelectBranch);


            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='List of Values Branch Code']")));

            WebElement branchCode = driver.findElement(By.xpath(" //div[1]/div[@class='DIVText'][1]/input[1]"));
            branchCode.clear();
            branchCode.sendKeys("399");


            ReportHelper.logReportStatus(LogStatus.PASS, "Branch code entered in the Select Branch screen successfully");

            driver.findElement(By.xpath("//*[@id='LOVPageHead']//div[3]/button")).click();


            driver.findElement(By.xpath("//*[@id='TableLov']/tbody/tr[1]")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Confirmation Message']")));
            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();

            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id='fastpath']")).sendKeys("FTSTRSWT");
            ReportHelper.logReportStatus(LogStatus.PASS, "Fast path entered successfully");
            driver.findElement(By.id("btnGo")).click();

            driver.switchTo().frame("ifr_LaunchWin");
            driver.findElement(By.id("BLK_SUMMARY_DETAILS__CONTREFNO")).sendKeys(getData("UBSreference"));
            WebElement element1 = driver.findElement(By.cssSelector("#tblquery_fleft > button:nth-child(3)"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element1);
            //driver.findElement(By.xpath("//button[@name='Search']/span/span")).click();
            //driver.findElement(By.xpath("//*[contains(text(),'  Search')]")).click();

            Thread.sleep(2000);
            driver.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a")).click();

            Actions action = new Actions(driver);
            //act.moveToElement(driver.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a"))).doubleClick().build().perform();
            action.moveToElement(driver.findElement(By.cssSelector("#TBL_QryRslts > tbody > tr:nth-child(1) > td:nth-child(3) > a"))).doubleClick().build().perform();
            driver.switchTo().defaultContent();
            Thread.sleep(2000);
            System.out.println("PASS");
            List<WebElement> frame1;
            frame1 = driver.findElements(By.cssSelector("#ifr_LaunchWin"));
            driver.switchTo().frame(frame1.get(1));


            driver.findElement(By.xpath("//li//a[@class='Abutton' and text()='Events']")).click();

            driver.switchTo().defaultContent();
            List<WebElement> frame2 = driver.findElements(By.cssSelector("#ifr_LaunchWin"));
            driver.switchTo().frame(frame2.get(2));


            WebElement element2 = driver.findElement(By.xpath("//tr[2]//td//label//input[@name='chkDeleteRow']"));
            action.doubleClick(element2).perform();


            By accountEntriesXpath = By.xpath("//a[@class='Abutton' and text()='Accounting Entries']");
            driver.findElement(accountEntriesXpath).click();

            driver.switchTo().defaultContent();
            List<WebElement> frame3 = driver.findElements(By.xpath("//iframe[@id='ifr_LaunchWin']"));

            driver.switchTo().frame(frame3.get(3));

            Double totalCredit = 0.0d;

            List<WebElement> creditAmount1 = driver.findElements(By.xpath("//tr[td//input[@label_value='Dr/Cr' and @value='C']]//td[10]//input[@value]"));
            System.out.println(creditAmount1.size());

            for (WebElement str : creditAmount1) {

                String creditVlues = str.getAttribute("value");
                totalCredit = totalCredit + Double.parseDouble(creditVlues);

            }
            System.out.println(totalCredit);


            By debit = By.xpath("//tr[td//input[@name='AMTTAG' and @value='AMT_EQUIV']]//td[10]//input[@value]");
            String debitAmountValue = driver.findElement(debit).getAttribute("value");
            double debitAmount = Double.parseDouble(debitAmountValue);


            By credit = By.xpath("//tr[td//input[@name='AMTTAG' and @value='TFR_AMT']]//td[10]//input[@value]");
            String creditAmountValue = driver.findElement(credit).getAttribute("value");
            double creditAmount = Double.parseDouble(creditAmountValue);
            String Amount = getData("Amount");

            if (Double.parseDouble(Amount) == creditAmount) {

                ReportHelper.logReportStatus(LogStatus.PASS, "The credit Amount  has been verified with UBS Amount");

            }
            By charges = By.xpath("//tr[td//input[@name='AMTTAG' and @value='FTINTLCHG']]//td[10]//input[@value]");
            String chargesValue = driver.findElement(charges).getAttribute("value");

            double chargeAmount = Double.parseDouble(chargesValue);
            System.out.println(chargeAmount);

            By Fee = By.xpath("//tr[td//input[@name='AMTTAG' and @value='FTINTLFEE']]//td[10]//input[@value]");
            String FeeValue = driver.findElement(Fee).getAttribute("value");
            double FeeAmount = Double.parseDouble(FeeValue);
            System.out.println(FeeAmount);


            Double totalCreditAmount = FeeAmount + chargeAmount + creditAmount;


            System.out.println(totalCreditAmount);

            if (totalCreditAmount == debitAmount) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The total credit Amount is equal to debit Account");
            }


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.PASS, "Unable to verify Accounting  entries in UBS");
        }
    }

}




