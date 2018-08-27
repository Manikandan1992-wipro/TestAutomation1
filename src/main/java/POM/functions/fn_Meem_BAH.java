package POM.functions;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import FrameWork.library.Util;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_RDC_Meem_BAH;
import POM.pageobjects.po_UBS;
import Tests.testSteps.st_UBS;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.loginCredentials;
import static FrameWork.helpers.Helper.saveTestDataToDb;
import static FrameWork.helpers.ReportHelper.logReportStatus;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.listeners.PreReq.getURL;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;

public class fn_Meem_BAH {

    public static void initPageObjects() {
        try {
            initElements(drvr, po_RDC_Meem_BAH.class);
            logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
        } catch (Exception e) {

        }

    }

    public static void all_Login_MeemBah() {
        try {
            String loginType = DriverHelper.environmentURL;
            //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_Meem_BAH.login_Meem_BAH_test(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, e.getMessage());
        }
    }

    public static void all_Login_Validation_MeemBah() {
        try {
            String loginType = DriverHelper.environmentURL;
            //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_Meem_BAH.login_validation_Meem_BAH_test(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, e.getMessage());
        }
    }
public static void Logout()
{
    click(po_RDC_Meem_BAH.Button_logout);
}
    public static void login_Meem_BAH_test(String userType, String environment) throws Exception {
        initPageObjects();
        openUrl(getURL(environment));

        //getLatestDriver().navigate().to(getURL(environment));
        Thread.sleep(5000);
        System.out.println(userType);
        System.out.println(environment);
//		openUrl(getURL(environment));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLatestDriver();
        WebDriver driver = getLatestDriver();

        System.out.println(loginCredentials(userType)[0]);
        System.out.println(loginCredentials(userType)[1]);
        Thread.sleep(1000);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_username, loginCredentials(userType)[0]);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_password, loginCredentials(userType)[1]);
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "Username and Password Passed Succesfully");
        Thread.sleep(1000);
        click(po_RDC_Meem_BAH.Button_Meem_BAH_okbtn);
        Thread.sleep(8000);
        String OTP = FetchOTP_Meem.getOTP().replace("Your OTP is ", "").trim();
        System.out.println(OTP);
        sendKeys(po_RDC_Meem_BAH.Input_OTP_code, OTP);
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "OTP Passed Succesfully");
        click(po_RDC_Meem_BAH.Button_continueclk);
        Thread.sleep(7000);

        if (po_RDC_Meem_BAH.Button_logout.isDisplayed()) {
            ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");
        } else {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Login Success Failed");
        }
        //click(po_RDC_Meem_BAH.Button_logout);
    }

    public static void login_validation_Meem_BAH_test(String userType, String environment) throws Exception {
        initPageObjects();
        openUrl(getURL(environment));

        //getLatestDriver().navigate().to(getURL(environment));
        Thread.sleep(5000);
        System.out.println(userType);
        System.out.println(environment);
//		openUrl(getURL(environment));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLatestDriver();
        WebDriver driver = getLatestDriver();

        System.out.println(loginCredentials(userType)[0]);
        System.out.println(loginCredentials(userType)[1]);
        Thread.sleep(1000);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_username, loginCredentials(userType)[0]);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_password, loginCredentials(userType)[1]);
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "Username and Password Passed Succesfully");
        Thread.sleep(1000);
        click(po_RDC_Meem_BAH.Button_Meem_BAH_okbtn);
        Thread.sleep(8000);
        String OTP = FetchOTP_Meem.getOTP().replace("Your OTP is ", "").trim();
        System.out.println(OTP);
        sendKeys(po_RDC_Meem_BAH.Input_OTP_code, OTP);
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "OTP Passed Succesfully");
        click(po_RDC_Meem_BAH.Button_continueclk);
        Thread.sleep(7000);

        if (po_RDC_Meem_BAH.Button_logout.isDisplayed()) {
            ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");
        } else {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Login Success Failed");
        }
        click(po_RDC_Meem_BAH.Button_logout);
    }



    public static void Invalid_Login_MeemBah() {
        try {
            String loginType = DriverHelper.environmentURL;
            //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_Meem_BAH.InvalidLogin_Meem_BAH_test(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, e.getMessage());
        }
    }

    public static void InvalidLogin_Meem_BAH_test(String userType, String environment) throws Exception {
        initPageObjects();
        openUrl(getURL(environment));

        //getLatestDriver().navigate().to(getURL(environment));
        Thread.sleep(2000);
        System.out.println(userType);
        System.out.println(environment);
//		openUrl(getURL(environment));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLatestDriver();
        //WebDriver driver = po_BaseClass.po_GetDriver();

        System.out.println(loginCredentials(userType)[0]);
        System.out.println(loginCredentials(userType)[1]);
        Thread.sleep(2000);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_username, loginCredentials(userType)[0]);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_password, loginCredentials(userType)[1]);
        click(po_RDC_Meem_BAH.Button_Meem_BAH_okbtn);
        Thread.sleep(3000);
        String alertmsg=po_RDC_Meem_BAH.Alert_msg.getText();
        click(po_RDC_Meem_BAH.Alert_Ok_Btn);
        if(alertmsg.contains("Please enter a valid Username or password")||alertmsg.contains("We are sorry to inform you that your banking account has been blocked due to some problems"))
        {
            ReportHelper.logReportStatus(LogStatus.PASS, alertmsg);

        }
        else {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Login Successfully");
        }

    }

    public static void Invalid_OTP() {
        try {
            String loginType = DriverHelper.environmentURL;
            //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_Meem_BAH.Invalid_OTP_Meem_BAH_test(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, e.getMessage());
        }
    }

    public static void Invalid_OTP_Meem_BAH_test(String userType, String environment) throws Exception {
        initPageObjects();
        openUrl(getURL(environment));

        //getLatestDriver().navigate().to(getURL(environment));
        Thread.sleep(4000);
        System.out.println(userType);
        System.out.println(environment);
//		openUrl(getURL(environment));


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getLatestDriver();
        //WebDriver driver = po_BaseClass.po_GetDriver();

        System.out.println(loginCredentials(userType)[0]);
        System.out.println(loginCredentials(userType)[1]);
        Thread.sleep(2000);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_username, loginCredentials(userType)[0]);
        sendKeys(po_RDC_Meem_BAH.Input_Meem_BAH_password, loginCredentials(userType)[1]);
        click(po_RDC_Meem_BAH.Button_Meem_BAH_okbtn);
        Thread.sleep(5000);
        sendKeys(po_RDC_Meem_BAH.Input_OTP_code, "1234");
        click(po_RDC_Meem_BAH.Button_continueclk);
        Thread.sleep(5000);
        String Errormsg=po_RDC_Meem_BAH.OTP_Error_msg.getText();
        if (Errormsg.contains("Sorry the authentication code you entered is incorrect")) {
            ReportHelper.logReportStatus(LogStatus.PASS , Errormsg);
        } else {
            ReportHelper.logReportStatus(LogStatus.FAIL,"OTP Entered Successfully");
        }
        click(po_RDC_Meem_BAH.OTP_Home_Btn);
    }

    public static void Acc_Bal_view_BAH()
    {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            String BenNo=getData("BeneficaryNumber");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li/div/div/div[2]/div"));
            int Namesize=BenNames.size();
            for (int i=1;i<Namesize+1;i++) {
                String BeneNames=driver.findElement(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li["+i+"]/div/div/div[2]/div")).getText().trim();
                System.out.println(BeneNames);
                if(BenNo.equalsIgnoreCase(BeneNames))
                {

                    driver.findElement(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li["+i+"]/div/div/div[2]/div")).click();
                    Thread.sleep(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Name Seleced Sucessfully");
                    Thread.sleep(1000);
                    break;

                }

            }
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS,"Account Details Entered Successfully");
            click(po_RDC_Meem_BAH.Icon_Meem_Onepack);
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS,"Account Details viewed Successfully");
            click(po_RDC_Meem_BAH.Close_Icon_Meem_Onepack);
            String IBANNo=po_RDC_Meem_BAH.IBAN_No_Link.getText().trim();
            saveTestDataToDb("IBANNumber", IBANNo);
            String AccNo=IBANNo.substring(13,IBANNo.length()).replace(" ","");
            saveTestDataToDb("AccountNum", AccNo);
            System.out.println(AccNo);
            String AvailBal=po_RDC_Meem_BAH.Meem_available_Balance.getText();
            System.out.println("DB:"+getData("AvailBalance"));
            System.out.println("Available:"+AvailBal);
            saveTestDataToDb("AvailBalance", AvailBal);
            System.out.println(getData("AvailBalance"));
            System.out.println(AvailBal);
            click(po_RDC_Meem_BAH.Button_logout);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account Balance Viewed Successfully" );
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to view the Account Balance '" + e.getMessage() + "'");
        }

    }

    public static void Acc_Bal_view_FCY()
    {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            String BenNo=getData("BeneficaryNumber");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li/div/div/div[2]/div"));
            int Namesize=BenNames.size();
            for (int i=1;i<Namesize+1;i++) {
                String BeneNames=driver.findElement(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li["+i+"]/div/div/div[2]/div")).getText().trim();
                System.out.println(BeneNames);
                if(BenNo.equalsIgnoreCase(BeneNames))
                {

                    driver.findElement(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li["+i+"]/div/div/div[2]/div")).click();
                    Thread.sleep(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Name Seleced Sucessfully");
                    Thread.sleep(1000);
                    break;

                }

            }

            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS,"Account Entered Successfully");
            click(po_RDC_Meem_BAH.Icon_Meem_Onepack);
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS,"Account Details viewed Successfully");
            click(po_RDC_Meem_BAH.Close_Icon_Meem_Onepack);
            String IBANNo=po_RDC_Meem_BAH.IBAN_No_Link.getText().trim();
            saveTestDataToDb("IBANNumber", IBANNo);
            String AccNo=IBANNo.substring(13,IBANNo.length()).replace(" ","");
            saveTestDataToDb("AccountNum", AccNo);
            System.out.println(AccNo);
            String AvailBal=po_RDC_Meem_BAH.Meem_available_Balance.getText();
            System.out.println("DB:"+getData("AvailBalance"));
            System.out.println("Available:"+AvailBal);
            saveTestDataToDb("AvailBalance", AvailBal);
            System.out.println(getData("AvailBalance"));
            System.out.println(AvailBal);
            click(po_RDC_Meem_BAH.Button_logout);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account Balance Viewed Successfully" );
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to view the Account Balance '" + e.getMessage() + "'");
        }

    }

    public static void UBS_Balace_verify_BAH() throws Exception {
        DriverHelper.environmentURL = "MKR6~UBS_BAH~T8";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.Acc_summary_BAH();
        fn_UBS.ExitAllActiveWindowsall();
        fn_UBS.HomeBranch();
        fn_allLogin.logout_UBS();

    }
    public static void UBS_Balace_verify_FCY() throws Exception {
        DriverHelper.environmentURL = "MKR6~UBS_BAH~T8";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.Acc_summary_FCY();
        fn_UBS.ExitAllActiveWindowsall();
        fn_UBS.HomeBranch();
        fn_allLogin.logout_UBS();

    }
    public static void UBS_Closure_verify() throws Exception {
        DriverHelper.environmentURL = "MKR6~UBS_BAH~T8";
        st_UBS.all_Login_UBS();
        fn_UBS.UBS_SwitchBranch();
        fn_UBS.FastPath();
        fn_UBS.Clo_verify();
        fn_UBS.HomeBranch();
        fn_allLogin.logout_UBS();

    }


    public static void UBS_Fund_Transfers() throws Exception {
        try
        {
        DriverHelper.environmentURL = "MKR6~UBS_BAH~T8";
        st_UBS.all_Login_UBS();
        getLatestDriver();
        WebDriver driver = getLatestDriver();
        driver.findElement(By.xpath("//*[@id='fastpath']")).sendKeys("FTDTRSWT");
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "Fast Path Action Performed'");
        driver.findElement(By.xpath("//span[span[text()='Go']]")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='EnterQuery']/span")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input (SWIFT)')]")));
        Thread.sleep(2000);
        String Num = getData("RefNo");
        System.out.println(Num);
        String RefNo=Num.replace("Ref No  ", "").trim();
        driver.findElement(By.xpath("//*[@id='BLK_CONTRACT_DETAILS__CONTREFNO']")).sendKeys(RefNo);
        System.out.println(RefNo);
        Thread.sleep(1000);
        ReportHelper.logReportStatus(LogStatus.PASS, "Reference Number passed");
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='ExecuteQuery']/span")).click();
        Thread.sleep(4000);
        ReportHelper.logReportStatus(LogStatus.PASS, "Fund Transfer Viewed Successfully");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@title,'Contract Input (SWIFT)')]")));
        driver.findElement(By.xpath("//a[@title='Close']")).click();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id='btnSignOff']/span")).click();
        Thread.sleep(1000);
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

    public static void Add_FCY_account()
    {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            driver.findElement(By.xpath("//div[text()='Add an additional account']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@value='New Account']")).click();
            Thread.sleep(3000);
            WebElement Currency=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_lstCurrency']"));
            Select s1=new Select(Currency);
            String Cur=getData("Currency");
            System.out.println(Cur);
            s1.selectByVisibleText(Cur);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_btnMonthly']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_imgAcceptTnC']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(8000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep3_lblClosureTitle']")).getText();

            String IBANNo=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep3_lblIBAN']")).getText().trim();
            saveTestDataToDb("IBANNumber", IBANNo);
            String AccNo=IBANNo.substring(13,IBANNo.length()).replace(" ","");
            saveTestDataToDb("AccountNum", AccNo);
            System.out.println(AccNo);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();

            List<WebElement> AccType=driver.findElements(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li"));
            int AccTypes=AccType.size();
            System.out.println(AccTypes);
            if(AccTypes>2)
            {
                driver.findElement(By.xpath("//div[text()='View More accounts']")).click();
                List<WebElement> CurTypes=driver.findElements(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li/div/div/div[2]"));
                int Cursize=CurTypes.size();
                for (int i=1;i<Cursize+1;i++) {
                    String CurrencyTypes=driver.findElement(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li["+i+"]/div/div/div[2]")).getText();
                    System.out.println(CurrencyTypes);
                    String LastFourDigits=CurrencyTypes.substring(10,CurrencyTypes.length());
                    if(AccNo.contains(LastFourDigits))
                    {

                        driver.findElement(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li["+i+"]/div/div/div[2]")).click();
                        break;
                    }

                }
            }

            String AvailBal=po_RDC_Meem_BAH.Meem_available_Balance.getText();
            System.out.println("DB:"+getData("AvailBalance"));
            System.out.println("Available:"+AvailBal);
            saveTestDataToDb("AvailBalance", AvailBal);
            System.out.println(getData("AvailBalance"));
            System.out.println(AvailBal);
            click(po_RDC_Meem_BAH.Button_logout);

            if(Successmsg.contains("Your New Foreign Currency Account has been created succesfully"))
            ReportHelper.logReportStatus(LogStatus.PASS, "Your New Foreign Currency Account has been created succesfully" );
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Create the Account" + e.getMessage() + "'");
        }

    }

    public static void FCY_Acc_Closure() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();

            List<WebElement> AccType=driver.findElements(By.xpath("//*[@id='frmDashboard_segAccounts']/ul/li"));
            int AccTypes=AccType.size();
            System.out.println(AccTypes);
            if(AccTypes>2)
            {
                driver.findElement(By.xpath("//div[text()='View More accounts']")).click();
                List<WebElement> CurTypes=driver.findElements(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li/div/div/div[2]"));
                int Cursize=CurTypes.size();
                for (int i=1;i<Cursize+1;i++) {
                    String CurrencyTypes=driver.findElement(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li["+i+"]/div/div/div[2]")).getText();
                    System.out.println(CurrencyTypes);
                    String LastFourDigits=CurrencyTypes.substring(10,CurrencyTypes.length());
                    String AccNo=getData("AccountNum");
                    if(AccNo.contains(LastFourDigits))
                    {

                        driver.findElement(By.xpath("//*[@id='frmMyAccounts_segMyAccounts']/ul/li["+i+"]/div/div/div[2]")).click();
                        break;
                    }

                }
            }

            driver.findElement(By.xpath("//div[text()='R']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[text()='Close Account']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmCloseAccountStep1_txtClosure']")).sendKeys("Unused Account Number");
            driver.findElement(By.xpath("//*[@id='frmCloseAccountStep1_btnContinue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(5000);
            String Sucessmsg=driver.findElement(By.xpath("//*[@id='frmCloseAccountStep3_lblClosureTitle']")).getText();
            //driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(2000);


            if(Sucessmsg.contains("Your account has been successfully closed. We hope to see you again"))

                ReportHelper.logReportStatus(LogStatus.PASS, "Your account has been successfully closed. We hope to see you again!");
            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Close the Account" + e.getMessage() + "'");
        }

    }

    public static void FCY_Acc_Creation()
    {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            driver.findElement(By.xpath("//div[text()='Add an additional account']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@value='New Account']")).click();
            Thread.sleep(8000);
            WebElement Currency=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_lstCurrency']"));
            Select s1=new Select(Currency);
            String Cur=getData("Currency");
            System.out.println(Cur);
            s1.selectByVisibleText(Cur);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_btnMonthly']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep1_imgAcceptTnC']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(8000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep3_lblClosureTitle']")).getText();

            String IBANNo=driver.findElement(By.xpath("//*[@id='frmForeignCurrAccStep3_lblIBAN']")).getText().trim();
            saveTestDataToDb("IBANNumber", IBANNo);
            String AccNo=IBANNo.substring(13,IBANNo.length()).replace(" ","");
            saveTestDataToDb("AccountNum", AccNo);
            System.out.println(AccNo);


            if(Successmsg.contains("Your New Foreign Currency Account has been created succesfully"))
                ReportHelper.logReportStatus(LogStatus.PASS, "Your New Foreign Currency Account has been created succesfully" );
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(1000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Create the Account" + e.getMessage() + "'");
        }

    }

    public static void profile_updates() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='More Information']")).click();
            Thread.sleep(2000);
            Boolean Other= driver.findElement(By.xpath("//*[@id='frmProfileManagement_btnOtherYes']")).isSelected();
            if(Other==false) {
                driver.findElement(By.xpath("//*[@id='frmProfileManagement_btnOtherYes']")).click();
                Thread.sleep(1000);
            }
            else
            {
                driver.findElement(By.xpath("//*[@id='frmProfileManagement_btnOtherNo']")).click();
                Thread.sleep(1000);
            }
            driver.findElement(By.xpath("//*[@id='frmProfileManagement_txtPleaseSpecify']")).sendKeys("Other");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Save']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Confirm Changes']")).click();
            Thread.sleep(3000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your OTP is ", "").trim();
            System.out.println(OTP);
            sendKeys(po_RDC_Meem_BAH.Input_OTP_code, OTP);
            click(po_RDC_Meem_BAH.Button_continueclk);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(1000);
            click(po_RDC_Meem_BAH.Button_logout);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_lblSuccessTitle']")).getText();
            if (Successmsg.contains("Your personal details have been successfully updated"));
                ReportHelper.logReportStatus(LogStatus.PASS, "Your personal details have been successfully updated");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Update the profile" + e.getMessage() + "'");
        }
    }

    public static void password_updates() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmProfileManagement_tabletSettings_lblSecuritySettings']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Change Password']")).click();
            Thread.sleep(2000);
            String OldPassword=getData("Oldpassword");
            driver.findElement(By.xpath("//input[@placeholder='Old Password']")).sendKeys(OldPassword);
            Thread.sleep(1000);
            String NewPassword=getData("Newpassword");
            driver.findElement(By.xpath("//input[@placeholder='New password']")).sendKeys(NewPassword);
            Thread.sleep(1000);
            String RepeatNewPassword=getData("RepeatNewpassword");
            driver.findElement(By.xpath("//input[@placeholder='Repeat new password']")).sendKeys(RepeatNewPassword);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmProfileManagement_btnContinueForChangePassword']")).click();
            Thread.sleep(3000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your OTP is ", "").trim();
            System.out.println(OTP);
            sendKeys(po_RDC_Meem_BAH.Input_OTP_code, OTP);
            click(po_RDC_Meem_BAH.Button_continueclk);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(1000);
            click(po_RDC_Meem_BAH.Button_logout);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmCredentialsSuccess_lblSuccessTitle']")).getText();
            if (Successmsg.contains("You have updated your new password"));
            ReportHelper.logReportStatus(LogStatus.PASS, "Your password have been successfully updated");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Update the password" + e.getMessage() + "'");
        }
    }

    public static void password_update_sameAs_Old() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmProfileManagement_tabletSettings_lblSecuritySettings']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Change Password']")).click();
            Thread.sleep(2000);
            String OldPassword=getData("Oldpassword");
            driver.findElement(By.xpath("//input[@placeholder='Old Password']")).sendKeys(OldPassword);
            Thread.sleep(1000);
            String NewPassword=getData("Newpassword");
            driver.findElement(By.xpath("//input[@placeholder='New password']")).sendKeys(NewPassword);
            Thread.sleep(1000);
            String RepeatNewPassword=getData("RepeatNewpassword");
            driver.findElement(By.xpath("//input[@placeholder='Repeat new password']")).sendKeys(RepeatNewPassword);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmProfileManagement_btnContinueForChangePassword']")).click();
            Thread.sleep(3000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your OTP is ", "").trim();
            System.out.println(OTP);
            sendKeys(po_RDC_Meem_BAH.Input_OTP_code, OTP);
            click(po_RDC_Meem_BAH.Button_continueclk);
            Thread.sleep(3000);
            String Errormsg=driver.findElement(By.xpath("//*[@id='frmErrorScreen_lblVerificationMsg']")).getText();
            driver.findElement(By.xpath("//*[@id='frmErrorScreen_btnContinue']")).click();
            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);

            if (Errormsg.contains("Please type a new password as the one you provided was used before"));
            ReportHelper.logReportStatus(LogStatus.PASS, "Please type a new password as the one you provided was used before");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Update the password" + e.getMessage() + "'");
        }
    }

    public static void within_Meem_Ben_creation() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary opened Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_btnAdd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Within Meem']")).click();
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Meem Beneficary Selected Sucessfully");
            String IBANNo=getData("Meem_IBANNo");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtIBAN']")).sendKeys(IBANNo);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Verify']")).click();
            Thread.sleep(5000);
            String BenName=driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_lblBeneficiaryNameValue']")).getText();
            saveTestDataToDb("BeneficaryName", BenName);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details viewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Reviewed Beneficary details Sucessfully");
            driver.findElement(By.xpath("//input[@value='Add Beneficiary']")).click();
            Thread.sleep(8000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_txtOTP']")).sendKeys(OTP);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Passed Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_btnContinue']")).click();
            Thread.sleep(3000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep4_lblClosureTitle']")).getText();

            Thread.sleep(3000);


            if (Successmsg.contains("Your beneficiary has been successfully created"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Create the Beneficary" + e.getMessage() + "'");
        }
    }

    public static void within_Behrain_Ben_creation() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary opened Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_btnAdd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Within Bahrain']")).click();
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Behrain Beneficary Selected Sucessfully");
            String IBANNo=getData("Behrain_IBANNo");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtIBAN']")).sendKeys(IBANNo);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Verify']")).click();
            Thread.sleep(3000);
            String firstName=getData("FirstName");
            driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys(firstName);
            Thread.sleep(1000);
            String secondName=getData("SecondName");
            driver.findElement(By.xpath("//input[@placeholder='Second name']")).sendKeys(secondName);
            Thread.sleep(1000);
            String lastName=getData("LastName");
            driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys(lastName);
            Thread.sleep(1000);
            String nickName=getData("NickName");
            driver.findElement(By.xpath("//input[@placeholder='Nickname (optional)']")).sendKeys(nickName);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details viewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Reviewed Beneficary details Sucessfully");
            driver.findElement(By.xpath("//input[@value='Add Beneficiary']")).click();
            Thread.sleep(8000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_txtOTP']")).sendKeys(OTP);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Passed Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_btnContinue']")).click();
            Thread.sleep(3000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep4_lblClosureTitle']")).getText();

            if (Successmsg.contains("Your beneficiary has been successfully created"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");

            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Create the Beneficary" + e.getMessage() + "'");
        }
    }

    public static void international_Ben_creation() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary opened Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_btnAdd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='International']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "International Beneficary Selected Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtIBAN']")).click();
            Thread.sleep(2000);
            String IBANNo=getData("InterIBANNo");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtIBAN']")).sendKeys(IBANNo);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Verify']")).click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details given Sucessfully");
            String firstName=getData("FirstName");
            driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys(firstName);
            Thread.sleep(1000);
            String secondName=getData("SecondName");
            driver.findElement(By.xpath("//input[@placeholder='Second name']")).sendKeys(secondName);
            Thread.sleep(1000);
            String lastName=getData("LastName");
            driver.findElement(By.xpath("//input[@placeholder='Last name']")).sendKeys(lastName);
            Thread.sleep(1000);
            String nickName=getData("NickName");
            driver.findElement(By.xpath("//input[@placeholder='Nickname (optional)']")).sendKeys(nickName);
            Thread.sleep(2000);
            scrollDown("//input[@placeholder='Beneficiary Residence Address']");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_lblCurrencyValue']")).click();
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details given Sucessfully");

                List<WebElement> CurTypes=driver.findElements(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_segSmartSearch']/ul/li//div//div//div//div"));
                int Cursize=CurTypes.size();
                for (int i=1;i<Cursize+1;i++) {
                    String CurrencyTypes=driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_segSmartSearch']/ul/li["+i+"]//div//div//div//div")).getText();
                    System.out.println(CurrencyTypes);
                    String cur=getData("Currency");
                    if(cur.contains(CurrencyTypes))
                    {

                        driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_segSmartSearch']/ul/li["+i+"]//div//div//div//div")).click();
                        break;
                    }

                }


            Thread.sleep(2000);
            String routingNo=getData("RoutingNumber");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtRoutingNo']")).sendKeys(routingNo);
            String swiftcode=getData("SwiftCode");
            driver.findElement(By.xpath("//input[@placeholder='swift Code']")).sendKeys(swiftcode);
            Thread.sleep(2000);
            String BenResAdd=getData("BenResAddress");
            driver.findElement(By.xpath("//input[@placeholder='Beneficiary Residence Address']")).sendKeys(BenResAdd);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details given Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary details Reviewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Add Beneficiary']")).click();
            Thread.sleep(8000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_txtOTP']")).sendKeys(OTP);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Passed Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep3_btnContinue']")).click();
            Thread.sleep(3000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep4_lblClosureTitle']")).getText();

            if (Successmsg.contains("Your beneficiary has been successfully created"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            Thread.sleep(3000);
            click(po_RDC_Meem_BAH.Button_logout);

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Create the Beneficary" + e.getMessage() + "'");
        }
    }




    public static void Ben_creation_Invalid() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Seleced Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_btnAdd']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Within Meem']")).click();
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Meem Beneficary Selected Sucessfully");
            driver.findElement(By.xpath("//*[@id='frmAddNewBeneficiaryStep1_txtIBAN']")).sendKeys("123456789810");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Verify']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmErrorScreen_lblVerificationMsg']")).getText();

            if (Successmsg.contains("The IBAN number you entered is invalid , please check and try again"));

            ReportHelper.logReportStatus(LogStatus.PASS, "The IBAN number you entered is invalid , please check and try again.");

            Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@value='Go To Home']")).click();
            Thread.sleep(3000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Beneficary Created Successfully" + e.getMessage() + "'");
        }
    }



    public static void Meem_Ben_Deletion() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Seleced Sucessfully");
            String BenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li/div/div/div[1]"));
            int Namesize=BenNames.size();
            for (int i=1;i<Namesize+1;i++) {
                String BeneNames=driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                System.out.println(BeneNames);
                if(BenName.contains(BeneNames))
                {

                    driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Name Seleced Sucessfully");
                    Thread.sleep(1000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete selected Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete Reviewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(4000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmDeleteBeneficiaryStep3_lblClosureTitle']")).getText();
            Thread.sleep(2000);


            if (Successmsg.contains("The beneficiary has been deleted"));

            ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted");
            Thread.sleep(3000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete the Beneficary" + e.getMessage() + "'");
        }
    }

    public static void Behrain_Ben_Deletion() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Seleced Sucessfully");
            String BenName=getData("NickName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li/div/div/div[1]"));
            int Namesize=BenNames.size();
            for (int i=1;i<Namesize+1;i++) {
                String BeneNames=driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                System.out.println(BeneNames);
                if(BenName.contains(BeneNames))
                {

                    driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Name Seleced Sucessfully");
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete selected Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete Reviewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(4000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmDeleteBeneficiaryStep3_lblClosureTitle']")).getText();
            Thread.sleep(2000);

            if (Successmsg.contains("The beneficiary has been deleted"));

            ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted");
            Thread.sleep(3000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete the Beneficary" + e.getMessage() + "'");
        }
    }

    public static void international_Ben_Deletion() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Beneficiaries']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Seleced Sucessfully");
            String BenName=getData("NickName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li/div/div/div[1]"));
            int Namesize=BenNames.size();
            for (int i=1;i<Namesize+1;i++) {
                String BeneNames=driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                System.out.println(BeneNames);
                if(BenName.contains(BeneNames))
                {

                    driver.findElement(By.xpath("//*[@id='frmBeneficiaryManagement_segLinked']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Name Seleced Sucessfully");
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete selected Sucessfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Delete Reviewed Sucessfully");
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(4000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmDeleteBeneficiaryStep3_lblClosureTitle']")).getText();
            Thread.sleep(2000);

            if (Successmsg.contains("The beneficiary has been deleted"));
            ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted");
            Thread.sleep(3000);
            click(po_RDC_Meem_BAH.Button_logout);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete the Beneficary" + e.getMessage() + "'");
        }
    }

    public static void Own_Acc_Onepack_to_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Own Accounts']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblChevToAccount']")).click();
            Thread.sleep(2000);

            String ToAccIBANNo=getData("ToACCIBANNo");

            List<WebElement> ToAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Size=ToAccIBANNum.size();
            for (int i=1;i<Size+1;i++) {
                String ToAccIBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(ToAccIBANNo.contains(ToAccIBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();

            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);


            if (Successmsg.contains("Your transfer was successfully done"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }
    }

    public static void Own_Acc_FCY_to_Onepack() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Own Accounts']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblChevToAccount']")).click();
            Thread.sleep(2000);

            String ToAccIBANNo=getData("ToACCIBANNo");

            List<WebElement> ToAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Size=ToAccIBANNum.size();
            for (int i=1;i<Size+1;i++) {
                String ToAccIBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(ToAccIBANNo.contains(ToAccIBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("Your transfer was successfully done"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }
    }

    public static void Own_Acc_FCY_to_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Own Accounts']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblChevToAccount']")).click();
            Thread.sleep(2000);

            String ToAccIBANNo=getData("ToACCIBANNo");

            List<WebElement> ToAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Size=ToAccIBANNum.size();
            for (int i=1;i<Size+1;i++) {
                String ToAccIBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(ToAccIBANNo.contains(ToAccIBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("Your transfer was successfully done"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }
    }

    public static void Own_Acc_Insufficient_fund() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Own Accounts']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblChevToAccount']")).click();
            Thread.sleep(2000);

            String ToAccIBANNo=getData("ToACCIBANNo");

            List<WebElement> ToAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Size=ToAccIBANNum.size();
            for (int i=1;i<Size+1;i++) {
                String ToAccIBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(ToAccIBANNo.contains(ToAccIBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblValidationErr']")).getText();
            Thread.sleep(2000);

            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);


            if (Successmsg.contains("Insufficient balance."));

            ReportHelper.logReportStatus(LogStatus.PASS, "Insufficient balance.");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Transactions done" + e.getMessage() + "'");
        }
    }

    public static void within_Meem_BHD_to_BHD() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Transfers Actions perfomed");
            driver.findElement(By.xpath("//div[text()='Within Meem']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Meem Transfers");
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Transfers Details given Successfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);


            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
                Thread.sleep(2000);
                click(po_RDC_Meem_BAH.Button_logout);
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }


    }

    public static void within_Meem_BHD_to_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Within Meem']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }

            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);


            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }


    }



    public static void within_Meem_FCY_to_BHD() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Within Meem']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(1000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);


            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }


    }

    public static void within_Meem_FCY_to_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Within Meem']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo = getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum = driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize = FromAccIBANNum.size();
            for (int i = 1; i < Numsize + 1; i++) {
                String IBANNos = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li[" + i + "]/div/div/div[2]")).getText().trim();
                if (FromAccIBANNo.contains(IBANNos)) {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li[" + i + "]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName = getData("BeneficaryName");

            List<WebElement> BenNames = driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size = BenNames.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li[" + i + "]/div/div/div[1]")).getText().trim();
                if (ToAccBenName.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount = getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(1000);

            String OneFcyRate = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose = getData("Purpose");
            WebElement e1 = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1 = new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
            }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
            } catch(Exception e){
                ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
            }

    }

    public static void within_Behrain_Fawri_Transfers() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Within Bahrain']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo = getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum = driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize = FromAccIBANNum.size();
            for (int i = 1; i < Numsize + 1; i++) {
                String IBANNos = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li[" + i + "]/div/div/div[2]")).getText().trim();
                if (FromAccIBANNo.contains(IBANNos)) {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li[" + i + "]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName = getData("BeneficaryName");

            List<WebElement> BenNames = driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size = BenNames.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li[" + i + "]/div/div/div[1]")).getText().trim();
                if (ToAccBenName.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String Amount = getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(1000);

            String OneFcyRate = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose = getData("Purpose");
            WebElement e1 = driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1 = new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }

    }




    public static void International_tran_BAH_To_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Transfers Selected Successfully");
            driver.findElement(By.xpath("//div[text()='International']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "International Transfers Selected Successfully");
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "List of IBAN Number viewed Successfully");
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Name viewed Successfully");
            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(2000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            String Subpurpose=getData("SubPurpose");
            WebElement e2=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxSubPurpose']"));
            Select s2=new Select(e2);
            s2.selectByVisibleText(Subpurpose);
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Tranfer detaiils given Successfully");
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Reviewed Transfers Details Successfully");
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);


            String OTP = FetchOTP_Meem.getOTP().replace("The Code for your transfer: ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@placeholder='Confirmation Code']")).sendKeys(OTP);
            Thread.sleep(1000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP given Successfully");
            driver.findElement(By.xpath("//*[@value='Continue']")).click();
            Thread.sleep(3000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);

            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
                Thread.sleep(2000);
                click(po_RDC_Meem_BAH.Button_logout);
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }


    }

    public static void International_tran_FCY_To_FCY() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='International']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(2000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            String Subpurpose=getData("SubPurpose");
            WebElement e2=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxSubPurpose']"));
            Select s2=new Select(e2);
            s2.selectByVisibleText(Subpurpose);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);


            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");

                driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnCb1']")).click();

                Thread.sleep(1000);

                String AddFavSuccessmsg = driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblInfoDesc']")).getText();

                if (AddFavSuccessmsg.contains("Your transfer added to favorite transfers successfully"))
                {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer added to favorite transfers successfully");
                    Thread.sleep(2000);
                    driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_btnInfoOk']")).click();
                    Thread.sleep(2000);
                }
                else{
                    ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Favorite Transfer");
                }

                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }


    }


    public static void International_tran_Insufficent_Bal() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='International']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(2000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s1=new Select(e1);
            s1.selectByVisibleText(purpose);
            Thread.sleep(2000);
            String Subpurpose=getData("SubPurpose");
            WebElement e2=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxSubPurpose']"));
            Select s2=new Select(e2);
            s2.selectByVisibleText(Subpurpose);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//div[*[@id='frmMakeTransfer_lblValidationErr']]")).getText();

            Thread.sleep(2000);
            click(po_RDC_Meem_BAH.Button_logout);


            if (Successmsg.contains("Insufficient balance"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Insufficient balance.");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Transactions done" + e.getMessage() + "'");
        }
    }

    public static void Standing_Inst_Setup_Within_OwnAcc() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Set Standing Instructions']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmStandingOrders_btnAdd']")).click();
            Thread.sleep(2000);
            String StandingInsTypes=getData("StandingInsType");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmSelectStandingOrderType_lstBoxStandingOrderType']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(StandingInsTypes);

            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblChevToAccount']")).click();
            Thread.sleep(2000);

            String ToAccIBANNo=getData("ToACCIBANNo");

            List<WebElement> ToAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Size=ToAccIBANNum.size();
            for (int i=1;i<Size+1;i++) {
                String ToAccIBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(ToAccIBANNo.contains(ToAccIBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(2000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String frequency=getData("Frequency");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstSelectFrequency']"));
            Select s2=new Select(e1);
            s2.selectByVisibleText(frequency);
            Thread.sleep(2000);
            String NoofTransfer=getData("NoofTransfers");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtNoOfTransfers']")).sendKeys(NoofTransfer);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("You have successfully schedule a standing instructions"));

            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to scehedule standing instructions due to" + e.getMessage() + "'");
        }
    }


    public static void Standing_Inst_Setup_Within_Meem() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Set Standing Instructions']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmStandingOrders_btnAdd']")).click();
            Thread.sleep(2000);
            String StandingInsTypes=getData("StandingInsType");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmSelectStandingOrderType_lstBoxStandingOrderType']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(StandingInsTypes);

            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblSelected']")).click();
            Thread.sleep(2000);
            String FromAccIBANNo=getData("FromACCIBANNo");

            List<WebElement> FromAccIBANNum=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li/div/div/div[2]"));
            int Numsize=FromAccIBANNum.size();
            for (int i=1;i<Numsize+1;i++) {
                String IBANNos=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).getText().trim();
                if(FromAccIBANNo.contains(IBANNos))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segAccountsList']/ul/li["+i+"]/div/div/div[2]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(2000);
            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s11=new Select(e1);
            s11.selectByVisibleText(purpose);
            Thread.sleep(2000);

            String frequency=getData("Frequency");
            WebElement e11=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstSelectFrequency']"));
            Select s2=new Select(e11);
            s2.selectByVisibleText(frequency);
            Thread.sleep(2000);

            String NoofTransfer=getData("NoofTransfers");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtNoOfTransfers']")).sendKeys(NoofTransfer);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("You have successfully schedule a standing instructions"));

            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to scehedule standing instructions due to" + e.getMessage() + "'");
        }
    }

    public static void Standing_Inst_Setup_Within_Behrain() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Set Standing Instructions']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmStandingOrders_btnAdd']")).click();
            Thread.sleep(2000);
            String StandingInsTypes=getData("StandingInsType");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmSelectStandingOrderType_lstBoxStandingOrderType']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(StandingInsTypes);

            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(2000);
            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s11=new Select(e1);
            s11.selectByVisibleText(purpose);
            Thread.sleep(2000);

            String Subpurpose=getData("SubPurpose");
            WebElement e2=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxSubPurpose']"));
            Select s2=new Select(e2);
            s2.selectByVisibleText(Subpurpose);


            String frequency=getData("Frequency");
            WebElement e11=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstSelectFrequency']"));
            Select s21=new Select(e11);
            s21.selectByVisibleText(frequency);
            Thread.sleep(2000);

            String NoofTransfer=getData("NoofTransfers");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtNoOfTransfers']")).sendKeys(NoofTransfer);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@placeholder='Confirmation Code']")).sendKeys(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@value='Continue']")).click();
            Thread.sleep(5000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("You have successfully schedule a standing instructions"));

            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to scehedule standing instructions due to" + e.getMessage() + "'");
        }
    }

    public static void Standing_Inst_Setup_International() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Set Standing Instructions']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmStandingOrders_btnAdd']")).click();
            Thread.sleep(2000);
            String StandingInsTypes=getData("StandingInsType");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmSelectStandingOrderType_lstBoxStandingOrderType']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(StandingInsTypes);

            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmMakeTransfer_lblBeneChevron']")).click();
            Thread.sleep(2000);

            String ToAccBenName=getData("BeneficaryName");

            List<WebElement> BenNames=driver.findElements(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li/div/div/div[1]"));
            int Size=BenNames.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).getText().trim();
                if(ToAccBenName.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmMakeTransfer_segBeneficiaryList']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(4000);
            String Amount=getData("Amount");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtAmount']")).sendKeys(Amount);
            Thread.sleep(2000);

            Thread.sleep(1000);
            String ConverRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConverted']")).getText();
            saveTestDataToDb("ConvertionRate", ConverRate);
            Thread.sleep(2000);

            String OneFcyRate=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lblConversion']")).getText();
            saveTestDataToDb("OneFCYRate", OneFcyRate);

            String purpose=getData("Purpose");
            WebElement e1=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxPurpose']"));
            Select s11=new Select(e1);
            s11.selectByVisibleText(purpose);
            Thread.sleep(2000);

            String Subpurpose=getData("SubPurpose");
            WebElement e2=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstBxSubPurpose']"));
            Select s2=new Select(e2);
            s2.selectByVisibleText(Subpurpose);


            String frequency=getData("Frequency");
            WebElement e11=driver.findElement(By.xpath("//*[@id='frmMakeTransfer_lstSelectFrequency']"));
            Select s21=new Select(e11);
            s21.selectByVisibleText(frequency);
            Thread.sleep(2000);

            String NoofTransfer=getData("NoofTransfers");
            driver.findElement(By.xpath("//*[@id='frmMakeTransfer_txtNoOfTransfers']")).sendKeys(NoofTransfer);

            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            String OTP = FetchOTP_Meem.getOTP().replace("The Code for your transfer: ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@placeholder='Confirmation Code']")).sendKeys(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@value='Continue']")).click();
            Thread.sleep(5000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to Home']")).click();


            if (Successmsg.contains("You have successfully schedule a standing instructions"));

            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to scehedule standing instructions due to" + e.getMessage() + "'");
        }
    }


    public static void Add_Online_Biller() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(20000);
            driver.findElement(By.xpath("//*[@id='frmMyBills_flxHeader']/div[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddBiller_CopylblBillerValue0f853bac0af614b']")).click();
            Thread.sleep(2000);
            String SelectBillers=getData("SelectBiller");

            List<WebElement> Billers=driver.findElements(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li/div/div/div/div"));
            int Size=Billers.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li["+i+"]/div/div/div/div")).getText();
                if(SelectBillers.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li["+i+"]/div/div/div/div")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String BillerService=getData("Billerservies");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmAddBiller_lstBxService']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(BillerService);
            String NickName=getData("NickNames");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddBiller_txtNickName']")).sendKeys(NickName);
            Thread.sleep(2000);
            String TelePhone=getData("TelephoneNumber");
            driver.findElement(By.xpath("//*[@id='frmAddBiller_1txtDynamicText']")).sendKeys(TelePhone);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your OTP for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@placeholder='Confirmation Code']")).sendKeys(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@value='Continue']")).click();
            Thread.sleep(5000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen3_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to home']")).click();

            if (Successmsg.contains("Your biller has been successfully added. It is available at biller’s list"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your biller has been successfully added. It is available at biller’s list");
        } catch (Exception e) {
            e.printStackTrace();
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Biller due to" + e.getMessage() + "'");
        }
    }

    public static void Add_Offline_Biller() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='frmMyBills_flxHeader']/div[2]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddBiller_CopylblBillerValue0f853bac0af614b']")).click();
            Thread.sleep(2000);
            String SelectBillers=getData("SelectBiller");

            List<WebElement> Billers=driver.findElements(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li/div/div/div/div"));
            int Size=Billers.size();
            for (int i=1;i<Size+1;i++) {
                String Names=driver.findElement(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li["+i+"]/div/div/div/div")).getText();
                if(SelectBillers.contains(Names))
                {

                    driver.findElement(By.xpath("//*[@id='frmAddBiller_segBillersList']/ul/li["+i+"]/div/div/div/div")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            String BillerService=getData("Billerservies");
            WebElement typeofStandingIns=driver.findElement(By.xpath("//*[@id='frmAddBiller_lstBxService']"));
            Select s1=new Select(typeofStandingIns);
            s1.selectByVisibleText(BillerService);
            String NickName=getData("NickNames");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmAddBiller_txtNickName']")).sendKeys(NickName);
            Thread.sleep(2000);
            String CprNumber=getData("CPRNumber");
            driver.findElement(By.xpath("//*[@id='frmAddBiller_1txtDynamicText']")).sendKeys(CprNumber);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            String OTP = FetchOTP_Meem.getOTP().replace("Your OTP for this transaction is ", "").trim();
            System.out.println(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@placeholder='Confirmation Code']")).sendKeys(OTP);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@value='Continue']")).click();
            Thread.sleep(5000);


            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen3_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@value='Go to home']")).click();

            if (Successmsg.contains("Your biller has been successfully added. It is available at biller’s list"));

            ReportHelper.logReportStatus(LogStatus.PASS, "Your biller has been successfully added. It is available at biller’s list");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Biller due to" + e.getMessage() + "'");
        }
    }

    public static void Single_Online_Payment() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(5000);

            String SelectBillers = getData("SelectBiller");

            List<WebElement> BillersNmae = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size = BillersNmae.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).getText();
                if (SelectBillers.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Pay']")).click();
            Thread.sleep(2000);
            String Amount = getData("Amounts");
            driver.findElement(By.xpath("//*[@id='frmPayBills_0txtPBTextBox']")).sendKeys(Amount);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(5000);


            if (driver.findElement(By.xpath("//img[@src='desktopweb/images/page1.png']")).isDisplayed()) ;
            ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status has been successfully completed");

            driver.findElement(By.xpath("//input[@value='Go to home']")).click();
        }
            catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Bill due to" + e.getMessage() + "'");
        }
    }

    public static void Single_Offline_Payment() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(6000);

            String SelectBillers = getData("SelectBiller");

            List<WebElement> BillersNmae = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size = BillersNmae.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li["+i+"]/div/div/div[1]")).getText();
                if (SelectBillers.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Pay']")).click();
            Thread.sleep(2000);
            String Amount = getData("Amounts");
            driver.findElement(By.xpath("//*[@id='frmPayBills_0txtPBTextBox']")).sendKeys(Amount);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(5000);

            if (driver.findElement(By.xpath("//img[@src='desktopweb/images/page1.png']")).isDisplayed())
            {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status has been successfully completed");
            }
            else if(driver.findElement(By.xpath("//img[@src='desktopweb/images/info_alert.png']")).isDisplayed()) {
               ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status is pending");
            }

            driver.findElement(By.xpath("//input[@value='Go to home']")).click();
        }
            catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Bill due to" + e.getMessage() + "'");
        }
    }

    public static void Multiple_Online_Bill_Payment() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(5000);

            String SelectBillers1 = getData("SelectBiller1");

            List<WebElement> BillersNmae1 = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size = BillersNmae1.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names1 = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).getText();
                if (SelectBillers1.contains(Names1)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            String SelectBillers2 = getData("SelectBiller2");
            List<WebElement> BillersNmae2 = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size1 = BillersNmae2.size();
            for (int i = 1; i < Size1 + 1; i++) {
                String Names2 = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).getText();
                if (SelectBillers2.contains(Names2)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='frmMyBills_CopyLabel0ef12901b36f24c']")).click();
            Thread.sleep(2000);
            String Amount1 = getData("Amounts1");
            driver.findElement(By.xpath("//*[@id='frmPayBills_0txtPBTextBox']")).sendKeys(Amount1);
            Thread.sleep(2000);
            String Amount2 = getData("Amounts2");
            driver.findElement(By.xpath("//*[@id='frmPayBills_1txtPBTextBox']")).sendKeys(Amount2);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(5000);

            if (driver.findElement(By.xpath("//img[@src='desktopweb/images/page1.png']")).isDisplayed())
            {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status has been successfully completed");
            }
            else if(driver.findElement(By.xpath("//img[@src='desktopweb/images/info_alert.png']")).isDisplayed()) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status is pending");
            }
            driver.findElement(By.xpath("//input[@value='Go to home']")).click();
        }
            catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Bill due to" + e.getMessage() + "'");
        }
    }

    public static void Multiple_Online_and_Offline_Bill_Payment() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(5000);

            String SelectBillers1 = getData("SelectBiller1");

            List<WebElement> BillersNmae1 = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size = BillersNmae1.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names1 = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).getText();
                if (SelectBillers1.contains(Names1)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            String SelectBillers2 = getData("SelectBiller2");
            List<WebElement> BillersNmae2 = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size1 = BillersNmae2.size();
            for (int i = 1; i < Size1 + 1; i++) {
                String Names2 = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).getText();
                if (SelectBillers2.contains(Names2)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li[" + i + "]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='frmMyBills_CopyLabel0ef12901b36f24c']")).click();
            Thread.sleep(2000);
            String Amount1 = getData("Amounts1");
            driver.findElement(By.xpath("//*[@id='frmPayBills_0txtPBTextBox']")).sendKeys(Amount1);
            Thread.sleep(2000);
            String Amount2 = getData("Amounts2");
            driver.findElement(By.xpath("//*[@id='frmPayBills_1txtPBTextBox']")).sendKeys(Amount2);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Confirm']")).click();
            Thread.sleep(5000);

            if (driver.findElement(By.xpath("//img[@src='desktopweb/images/page1.png']")).isDisplayed())
            {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status has been successfully completed");
            }
            else if(driver.findElement(By.xpath("//img[@src='desktopweb/images/info_alert.png']")).isDisplayed()) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your bill status is pending");
            }
            driver.findElement(By.xpath("//input[@value='Go to home']")).click();
        }
        catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Bill due to" + e.getMessage() + "'");
        }
    }


    public static void Deleting_Existing_Biller() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Fawateer']")).click();
            Thread.sleep(6000);

            String SelectBillers = getData("SelectBiller");

            List<WebElement> BillersNmae = driver.findElements(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li/div/div/div[1]"));
            int Size = BillersNmae.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li["+i+"]/div/div/div[1]")).getText();
                if (SelectBillers.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMyBills_segLinked']/ul/li["+i+"]/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(2000);


            if (driver.findElement(By.xpath("//*[@id='frmMyBills_btnConfirmationYes']")).isDisplayed())
                ReportHelper.logReportStatus(LogStatus.PASS, "Your biller has been successfully Deleted");
            driver.findElement(By.xpath("//*[@id='frmMyBills_btnConfirmationYes']")).click();
            Thread.sleep(5000);

        }
        catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete the Biller due to" + e.getMessage() + "'");
        }
    }

    public static void New_Complaint() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[text()='Talk to Meem']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//div[text()='COMPLAINTS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmMore_lblIcon']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='New Message']")).click();
            Thread.sleep(2000);

            String Subject = getData("Subjects");
            driver.findElement(By.xpath("//*[@id='frmMore_txtSubject']")).sendKeys(Subject);
            Thread.sleep(2000);
            String message = getData("Message");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='frmMore_txtArMsgNewMsg']")).sendKeys(message);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmMore_btnSendNewMsg']")).click();
            Thread.sleep(8000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_lblSuccessTitle']")).getText();
            Thread.sleep(2000);



            if (Successmsg.contains("Your Complaint has been sent"))
                ReportHelper.logReportStatus(LogStatus.PASS, "Your Complaint has been sent");

            driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_btnLogin']")).click();
            Thread.sleep(2000);

        }
        catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Complaint due to" + e.getMessage() + "'");
        }
    }


    public static void New_Enquiry() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//div[text()='Talk to Meem']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//div[text()='COMPLAINTS']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmMore_lblIcon']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='New Message']")).click();
            Thread.sleep(2000);

            String Subject = getData("Subjects");
            driver.findElement(By.xpath("//*[@id='frmMore_txtSubject']")).sendKeys(Subject);
            Thread.sleep(1000);
            String message = getData("Message");
            driver.findElement(By.xpath("//*[@id='frmMore_txtArMsgNewMsg']")).sendKeys(message);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id='frmMore_btnSendNewComplaint']")).click();
            Thread.sleep(8000);
            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_lblSuccessTitle']")).getText();
            Thread.sleep(2000);



            if (Successmsg.contains("Your Complaint has been sent"))
                ReportHelper.logReportStatus(LogStatus.PASS, "Your Complaint has been sent");

            driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_btnLogin']")).click();
            Thread.sleep(2000);

        }
        catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Complaint due to" + e.getMessage() + "'");
        }
    }


    public static void Delete_Mail() {
        try {
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Settings']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//div[text()='Talk to Meem']")).click();
            Thread.sleep(4000);

            String Subject = getData("Subjects");

            List<WebElement> subjects = driver.findElements(By.xpath("//*[@id='frmMore_segMessages']/ul/li/div/div/div/div/div/div[1]"));
            int Size = subjects.size();
            for (int i = 1; i < Size + 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmMore_segMessages']/ul/li["+i+"]/div/div/div/div/div/div[1]")).getText();
                if (Subject.contains(Names)) {

                    driver.findElement(By.xpath("//*[@id='frmMore_segMessages']/ul/li["+i+"]/div/div/div/div/div/div[1]")).click();
                    Thread.sleep(2000);
                    break;

                }

            }
            Thread.sleep(3000);

            if (driver.findElement(By.xpath("//div[text()='Remove']")).isDisplayed())
                ReportHelper.logReportStatus(LogStatus.PASS, "Enquiry Removed Successfully");

            driver.findElement(By.xpath("//div[text()='Remove']")).click();
            Thread.sleep(2000);

        }
        catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Remove Complaint due to" + e.getMessage() + "'");
        }
    }


    public static void Intiate_Favorite_Transfer() {

        try {
            String amts="";
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//div[text()='Perform Favorite Transfer']")).click();
            Thread.sleep(4000);

            String FavTransName = getData("FavTransferName");
            List<WebElement> subjects = driver.findElements(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li/div/div/div[1]/div"));
            int Size = subjects.size();

            for (int i = 1; i < Size+ 1; i++) {
                  String Names = driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+i+"]/div/div/div[1]/div")).getText();



            Thread.sleep(1000);
                String FavTransamt= getData("FavTransferAmt");
                List<WebElement> amounts = driver.findElements(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li/div/div/div[4]/div"));
                int Size1 = amounts.size();
                boolean Flag;
                Flag=false;
                for (int j = 1; j < Size1 + 1; j++) {
                amts = driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+j+"]/div/div/div[4]/div")).getText();
                System.out.println(amts);

                System.out.println(Names +"\\"+FavTransName+"\\"+FavTransamt+"\\"+amts);
                if ((FavTransName.equalsIgnoreCase(Names)) && (FavTransamt.equalsIgnoreCase(amts))) {
                    driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+j+"]/div/div/div[4]/div")).click();

                    Thread.sleep(2000);
                    Flag=true;
                    break;
                }

                }
                if(Flag==true)
                break;

            }

            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@id='frmFavoriteTransfers_flxActiveOptions']/div[2]/div/div")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id='frmTransfersReview_btnContinue']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            String RefNo=driver.findElement(By.xpath("//*[@id='frmTransfersSuccessScreen_lblAccDetailIBAN']")).getText();
            saveTestDataToDb("RefNo", RefNo);

            Thread.sleep(2000);


            if (Successmsg.contains("Your transfer was successfully done")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Transfer due to" + e.getMessage() + "'");
        }

    }


    public static void Delete_Favorite_Transfer() {

        try {
            String amts="";
            initPageObjects();
            getLatestDriver();
            WebDriver driver = getLatestDriver();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Transfers']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//div[text()='Perform Favorite Transfer']")).click();
            Thread.sleep(4000);

            String FavTransName = getData("FavTransferName");
            List<WebElement> subjects = driver.findElements(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li/div/div/div[1]/div"));
            int Size = subjects.size();

            for (int i = 1; i < Size+ 1; i++) {
                String Names = driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+i+"]/div/div/div[1]/div")).getText();



                Thread.sleep(1000);
                String FavTransamt= getData("FavTransferAmt");
                List<WebElement> amounts = driver.findElements(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li/div/div/div[4]/div"));
                int Size1 = amounts.size();
                boolean Flag;
                Flag=false;
                for (int j = 1; j < Size1 + 1; j++) {
                    amts = driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+j+"]/div/div/div[4]/div")).getText();
                    System.out.println(amts);

                    System.out.println(Names +"\\"+FavTransName+"\\"+FavTransamt+"\\"+amts);
                    if ((FavTransName.equalsIgnoreCase(Names)) && (FavTransamt.equalsIgnoreCase(amts))) {
                        driver.findElement(By.xpath("//*[@id='frmFavoriteTransfers_segTransfers']/ul/li["+j+"]/div/div/div[4]/div")).click();

                        Thread.sleep(2000);
                        Flag=true;
                        break;
                    }

                }
                if(Flag==true)
                    break;

            }

            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[text()='Delete']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id='frmRemoveScreen_btnConfirm']")).click();
            Thread.sleep(5000);

            String Successmsg=driver.findElement(By.xpath("//*[@id='frmSuccessScreen2_lblSuccessTitle']")).getText();
            Thread.sleep(2000);

            if (Successmsg.contains("You have successfully deleted your favorite transfer")) ;
            {

                ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully deleted your favorite transfer");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//input[@value='Go to Home']")).click();
            }
        } catch(Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to delete favorite transfer due to" + e.getMessage() + "'");
        }

    }







}