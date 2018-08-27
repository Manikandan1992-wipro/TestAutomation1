package POM.functions;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_RDC_Meem_BAH;
import POM.pageobjects.po_UBS;
import Tests.testSteps.st_UBS;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.loginCredentials;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.click;
import static FrameWork.listeners.PreReq.driverFolder;
import static FrameWork.listeners.po_BaseClass.driver;

public class FetchOTP_Meem {


    public  static String getOTP() {

        System.setProperty("webdriver.chrome.driver", driverFolder+"chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://10.14.5.94:899/Home/Index");

        waitFor(4000);
        webDriver.findElement(By.id("btnGetOTP")).click();
        waitFor(4000);

        String otp = "";
        String MobileNo = "97383105926035";

        List<WebElement> Number = webDriver.findElements(By.xpath("//*[@id='body']/section/table/tbody/tr/td[1]"));
        int Size = Number.size();
        boolean Flag;
        Flag = false;
        for (int i = 2; i < Size + 1; i++) {
            String Names = webDriver.findElement(By.xpath("//*[@id='body']/section/table/tbody/tr[" + i + "]/td[1]")).getText();
            if (MobileNo.contains(Names)) {
                otp = webDriver.findElement(By.xpath("//*[@id='body']/section/table/tbody/tr[" + i + "]/td[2]")).getText();
                Flag = true;
                break;
            }

        }


        webDriver.quit();
        return otp;
    }

    public static void Android_UBS_Fund_Transfers() throws Exception {
        try
        {

            System.setProperty("webdriver.chrome.driver", driverFolder+"chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("http://ubsapptst8:15831/FCJNeoWebWhBah");
            Thread.sleep(4000);
            for (String sam : driver.getWindowHandles()) {
                driver.switchTo().window(sam);
                //	System.out.println(driver.getWindowHandle()+"   "+driver.getTitle());
            }
            WebElement infomsg=driver.findElement(By.xpath("//iframe[@title='Information Message']"));
            driver.switchTo().frame(infomsg);
            Thread.sleep(1000);

            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            //click(po_LoginPage.Button_UBSLoginPage_Ok);
            driver.findElement(By.xpath("//input[@id='USERID']")).sendKeys("mani02");
            driver.findElement(By.xpath("//input[@id='PASSWORD']")).sendKeys("Oracle@4");
            driver.findElement(By.xpath("//button[@id='fc_sbmit']")).click();
            Thread.sleep(2000);
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Information Message']")));
            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
           // ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");
            Thread.sleep(1000);

            driver.switchTo().defaultContent();
            Thread.sleep(2000);
            WebElement a1=driver.findElement(By.xpath("//span[@class='ICOonline'][contains(.,'Branch Is Online')]"));
            Actions e1=new Actions(driver);
            e1.moveToElement(a1).perform();
            driver.findElement(By.xpath("//*[@id='nav']//b[@title='Select Branch']")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='List of Values Branch Code']")));
            driver.findElement(By.xpath("//div[1]/div[@class='DIVText'][1]/input[1]")).clear();
            driver.findElement(By.xpath("//div[1]/div[@class='DIVText'][1]/input[1]")).sendKeys("399");
            //ReportHelper.logReportStatus(LogStatus.PASS, "Branch code entered in the Select Branch screen successfully");
            driver.findElement(By.xpath("//*[@id='LOVPageHead']//div[3]/button")).click();
            waitFor(1000);
            driver.findElement(By.xpath("//*[@id='TableLov']/tbody/tr[1]")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Confirmation Message']")));
            driver.findElement(By.xpath("//button[@id='BTN_OK']")).click();
            driver.switchTo().defaultContent();
            driver.findElement(By.xpath("//*[@id='fastpath']")).sendKeys("FTSTRSWT");
            Thread.sleep(1000);
           // ReportHelper.logReportStatus(LogStatus.PASS, "Fast Path Action Performed'");
            driver.findElement(By.xpath("//span[span[text()='Go']]")).click();
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Contracts (SWIFT)')]")));
            Thread.sleep(2000);
            String Num = getData("RefNo");
            System.out.println(Num);
            String RefNo=Num.replace("Ref No  ", "").trim();
            driver.findElement(By.xpath("//*[@title='Contract Reference Number']")).sendKeys(RefNo);
            System.out.println(RefNo);
            Thread.sleep(1000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number passed");
            driver.findElement(By.xpath("//button[@title='Search']")).click();
            Thread.sleep(2000);
           // ReportHelper.logReportStatus(LogStatus.PASS, "Account Summary Details");
            WebElement e2=driver.findElement(By.xpath("//a[text()='Authorized']"));
            Actions action = new Actions(driver);
            action.doubleClick(e2).perform();
            driver.switchTo().defaultContent();
            Thread.sleep(1000);
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input (SWIFT)')]")));
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[@id='CSDEVENT']//a")).click();
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
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
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='CSDACENT']")).click();
            Thread.sleep(2000);
            driver.switchTo().defaultContent();

            List<WebElement> frame2;
            frame2=driver.findElements(By.cssSelector("#ifr_LaunchWin"));
            driver.switchTo().frame(frame2.get(2));

            WebElement Confmsg=driver.findElement(By.xpath("//iframe[@title='Confirmation Message']"));
            driver.switchTo().frame(Confmsg);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation Message");
            driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "UBS Funds Transfers verified Successfully" );
            driver.close();
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Verify the funds due to" + e.getMessage() + "'");
        }
    }


}
