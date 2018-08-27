package POM.functions;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_RDI_IB;
import POM.pageobjects.po_UBS;
import POM.pageobjects.po_android;
import Tests.testSteps.st_UBS;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static FrameWork.helpers.DriverHelper.closeReportAndDriver;
import static FrameWork.helpers.Helper.*;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.switchDFrame;
import static FrameWork.listeners.PreReq.driverFolder;
import static FrameWork.listeners.po_BaseClass.driver;
import static FrameWork.listeners.po_BaseClass.drvr;
import static POM.functions.FetchOTP.UBSValidation_MeemAndroid;
import static io.appium.java_client.touch.offset.PointOption.point;
import static org.openqa.selenium.support.PageFactory.initElements;

public class fn_Android_Meem_Bah {



    public static void all_Login_MeemAndroidLogin() {
        try {
            String loginType = DriverHelper.environmentURL;

            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_Android_Meem_Bah.Android_Meembahrain_Login(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, e.getMessage());
        }
    }

    public static void Meembahrainlogin() {
        try {


            AppiumDriver<MobileElement> driver = getAppiumDriver();
            waitToElement("//android.widget.Button[@text='OK']");

            MobileElement e1 = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            e1.click();
            Thread.sleep(2000);
            MobileElement el1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
            el1.click();
            Thread.sleep(2000);

            String userName = getData("UserName");
            el1.sendKeys(userName);
            driver.hideKeyboard();
            MobileElement el2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
            String password = getData("Password");

            el2.sendKeys(password);
            driver.hideKeyboard();
            ReportHelper.logReportStatus(LogStatus.PASS, "UserName and Password Given Successfully");

            MobileElement loginBtn = driver.findElementByXPath("//android.widget.Button[@text='Login']");
            loginBtn.click();

            String otp = FetchOTP.getOTP().replace("Your OTP is ", "").trim();

            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(otp);

            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Entered Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            waitToElement("//android.widget.Button[@text='S']");
            ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");


          /*  String IBANNum="BH33 **** 2314";

            MobileElement element=driver.findElement(By.xpath("//android.widget.TextView[1][@text='"+IBANNum+"']"));
            element.click(); */
            //System.out.println(list.size());
            //System.out.println(list);


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to login into the application" + e.getMessage());

        }
    }

    /**
     * This method is used for Meem Baharin Android Login
     *
     * @throws Exception
     * @ param userName,password,confirmation code
     */

    public static void Android_Meembahrain_Login(String username,String environment) {
        try {

            System.out.println(username);
            loginCredentials(username);

           System.out.println(loginCredentials(username)[0]);
           System.out.println(loginCredentials(username)[1]);


            AppiumDriver<MobileElement> driver = getAppiumDriver();
            waitToElement("//android.widget.Button[@text='OK']");
            MobileElement e1ement = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            e1ement.click();

            waitToElement("//android.widget.EditText[@text='Username']");
            MobileElement el11 = driver.findElementByXPath("//android.widget.EditText[@text='Username']");
            el11.sendKeys(loginCredentials(username)[0]);
            driver.hideKeyboard();
            MobileElement el2 = driver.findElementByXPath("//android.view.ViewGroup[3]/android.widget.EditText");
            //String password = getData("Password");
            el2.sendKeys(loginCredentials(username)[1]);
            driver.hideKeyboard();
            ReportHelper.logReportStatus(LogStatus.PASS, "UserName and Password Given Successfully");

            MobileElement loginBtn = driver.findElementByXPath("//android.widget.Button[@text='Login']");
            loginBtn.click();
            ReportHelper.logReportStatus(LogStatus.PASS, "Login button clicked successfully");

            String otp = FetchOTP.getOTP().replace("Your OTP is ", "").trim();


            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(otp);

            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Given Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            waitToElement("//android.widget.Button[@text='S']");
            ReportHelper.logReportStatus(LogStatus.PASS, "Login Successfully");


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to login into the application" + e.getMessage());

        }
    }

    /**
     * This method is used to  send Invalid Username and passwords
     *
     * @throws NoSuchElementException
     */

    public static void Android_meembah_Invalid_users() {
        try {

            AppiumDriver<MobileElement> driver = getAppiumDriver();
            Thread.sleep(2000);
            MobileElement el1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
            el1.click();

            String userName = getData("UserName");
            el1.sendKeys(userName);
            driver.hideKeyboard();
            MobileElement el2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
            String password = getData("Password");

            el2.sendKeys(password);
            Thread.sleep(3000);
            driver.hideKeyboard();
            ReportHelper.logReportStatus(LogStatus.PASS, "UserName and Password Given Successfully");

            MobileElement loginBtn = driver.findElementByXPath("//android.widget.Button[@text='Login']");
            loginBtn.click();

            Thread.sleep(4000);
            MobileElement Errormsg = driver.findElementByXPath("//android.widget.TextView[@text='Please enter a valid username or password and try again']");

            if (Errormsg.isDisplayed()) {
                Thread.sleep(2000);
                ReportHelper.logReportStatus(LogStatus.PASS, "Please enter a valid username or password and try again");
                MobileElement e2 = driver.findElementByXPath("//android.widget.Button[@text='Go To Home']");
                e2.click();
                Thread.sleep(2000);
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Login into the application");

        }
    }

    /**
     * This method is used to  send Invalid OTP
     *
     * @throws NoSuchElementException
     */

    public static void Android_Invalid_otp() {
        try {

            AppiumDriver<MobileElement> driver = getAppiumDriver();
            Thread.sleep(2000);
            MobileElement el1 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText");
            el1.click();

            String userName = getData("UserName");
            el1.sendKeys(userName);
            driver.hideKeyboard();
            MobileElement el2 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.EditText");
            String password = getData("Password");

            el2.sendKeys(password);
            driver.hideKeyboard();
            ReportHelper.logReportStatus(LogStatus.PASS, "UserName and Password Given Successfully");

            MobileElement loginBtn = driver.findElementByXPath("//android.widget.Button[@text='Login']");
            loginBtn.click();

            Thread.sleep(12000);

            driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']").sendKeys("5252");
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Invalid OTP Given Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            Thread.sleep(15000);
            MobileElement Errormsg = driver.findElementByXPath("//android.widget.TextView[@text='Sorry the authentication code you entered is incorrect. Please try again.']");

            if (Errormsg.isDisplayed()) {
                Thread.sleep(3000);
                ReportHelper.logReportStatus(LogStatus.PASS, "Sorry the authentication code you entered is incorrect. Please try again.");
                MobileElement e2 = driver.findElementByXPath("//android.widget.Button[@text='Go To Home']");
                e2.click();
                Thread.sleep(2000);
            }


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "login into the application");

        }
    }


    /**
     * This method is used to  click harmburger menu
     *
     * @throws NoSuchElementException
     */

    public static void clickHarmburgerMenuBTN() {
        try {
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            waitToElement("//android.widget.Button[@text='S']");
            MobileElement harmburgerMenu = appiumDriver.findElementByXPath("//android.widget.Button[@text='S']");

            if (harmburgerMenu.isDisplayed()) {
                harmburgerMenu.click();
                ReportHelper.logReportStatus(LogStatus.PASS, "HarmBurger button has been clicked successfully");
            }

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click Harm buger menu");
        }
    }

    public static void clickTransferBTN() {
        try {
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            MobileElement transferBtn = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Transfers']");

            if (transferBtn.isDisplayed()) {
                transferBtn.click();
                ReportHelper.logReportStatus(LogStatus.PASS, "Transfer button has been clicked successfully");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click transfer button");
        }
    }

    /**
     * This method is used to  create the Beneficary within Meem
     *
     * @throws NoSuchElementException
     */

    public static void Within_Meem_Ben_creation() {
        try {
            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(10000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");
            appiumDriver.findElementByXPath("//android.widget.Button[@text='T']").click();
            Thread.sleep(5000);

            MobileElement withinMeem = appiumDriver.findElementByXPath("//android.widget.Button[@text='Within Meem']");
            withinMeem.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Meem Selected Successfully");
            String IBAN = getData("Meem_IBANNo");
            MobileElement IBANNo = appiumDriver.findElementByXPath("//android.widget.EditText[@text='IBAN']");
            IBANNo.sendKeys(IBAN);
            Thread.sleep(2000);
            MobileElement verify = appiumDriver.findElementByXPath("//android.widget.Button[@text='Verify']");
            verify.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Details verified Successfully");
            MobileElement name = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Shoaib Malik']");
            String NickName = name.getText();
            saveTestDataToDb("BeneficaryName", NickName);
            Thread.sleep(2000);
            MobileElement continues = appiumDriver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continues.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Details Reviewed Successfully");
            MobileElement AddBen = appiumDriver.findElementByXPath("//android.widget.Button[@text='Add Beneficiary']");
            AddBen.click();
            Thread.sleep(5000);
            String otp = FetchOTP.getOTP().replace("Your Code for this transaction is ", "").trim();
            driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']").sendKeys(otp);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Given Successfully");
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            Thread.sleep(12000);
            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your beneficiary has been successfully created']");

            if (SuccessMsg.isDisplayed()) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to home']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to add Beneficary name");
        }


    }

    /**
     * This method is used to  create the Beneficary within Bahrain
     *
     * @throws NoSuchElementException
     */

    public static void Within_Behrain_Ben_creation() {
        try {
            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(10000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");
            appiumDriver.findElementByXPath("//android.widget.Button[@text='T']").click();
            Thread.sleep(5000);

            MobileElement withinMeem = appiumDriver.findElementByXPath("//android.widget.Button[@text='Within Bahrain']");
            withinMeem.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Within Bahrain Selected Successfully");
            String IBAN = getData("Behrain_IBANNo");
            MobileElement IBANNo = appiumDriver.findElementByXPath("//android.widget.EditText[@text='IBAN']");
            IBANNo.sendKeys(IBAN);
            Thread.sleep(2000);
            MobileElement verify = appiumDriver.findElementByXPath("//android.widget.Button[@text='Verify']");
            verify.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Details verified Successfully");
            String Firtname = getData("FirstName");
            MobileElement FirstName = appiumDriver.findElementByXPath("//android.widget.EditText[@text='First name']");
            FirstName.sendKeys(Firtname);
            Thread.sleep(2000);
            String SecondName = getData("SecondName");
            MobileElement Secondname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Second name']");
            Secondname.sendKeys(SecondName);
            Thread.sleep(2000);
            String LastName = getData("LastName");
            MobileElement Lastname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Last name']");
            Lastname.sendKeys(LastName);
            Thread.sleep(2000);
            String NickName = getData("NickName");
            MobileElement Nickname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Nickname (optional)']");
            Nickname.sendKeys(NickName);
            Thread.sleep(2000);
            MobileElement continues = appiumDriver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continues.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Details Reviewed Successfully");
            MobileElement AddBen = appiumDriver.findElementByXPath("//android.widget.Button[@text='Add Beneficiary']");
            AddBen.click();
            Thread.sleep(5000);
            String otp = FetchOTP.getOTP().replace("Your Code for this transaction is ", "").trim();
            driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']").sendKeys(otp);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Given Successfully");
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            Thread.sleep(12000);
            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your beneficiary has been successfully created']");

            if (SuccessMsg.isDisplayed()) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to home']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to add Beneficary name");
        }


    }

    /**
     * This method is used to  create the International Beneficary
     *
     * @throws NoSuchElementException
     */

    public static void International_Ben_creation() {
        try {
            Thread.sleep(10000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(10000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");
            appiumDriver.findElementByXPath("//android.widget.Button[@text='T']").click();
            Thread.sleep(5000);

            MobileElement withinMeem = appiumDriver.findElementByXPath("//android.widget.Button[@text='International']");
            withinMeem.click();
            Thread.sleep(3000);
            // ReportHelper.logReportStatus(LogStatus.PASS, "International Selected Successfully");
            String IBAN = getData("InterIBANNo");
            MobileElement IBANNo = appiumDriver.findElementByXPath("//android.widget.EditText[@text='IBAN / Account number']");
            IBANNo.sendKeys(IBAN);
            Thread.sleep(2000);
            MobileElement verify = appiumDriver.findElementByXPath("//android.widget.Button[@text='Verify']");
            verify.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Details verified Successfully");
            String Firtname = getData("FirstName");
            MobileElement FirstName = appiumDriver.findElementByXPath("//android.widget.EditText[@text='First name']");
            FirstName.sendKeys(Firtname);
            Thread.sleep(2000);
            String SecondName = getData("SecondName");
            MobileElement Secondname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Second name']");
            Secondname.sendKeys(SecondName);
            Thread.sleep(2000);
            String LastName = getData("LastName");
            MobileElement Lastname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Last name']");
            Lastname.sendKeys(LastName);
            Thread.sleep(2000);
            String NickName = getData("NickName");
            MobileElement Nickname = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Nickname (optional)']");
            Nickname.sendKeys(NickName);
            Thread.sleep(2000);

            TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.10);
            int startX = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();


            //String Cur=getData("Currency");
            MobileElement Currency = appiumDriver.findElementByXPath("//android.widget.TextView[@text='Please select Currency']");
            Currency.click();
            Thread.sleep(2000);
            MobileElement Cur = appiumDriver.findElementByXPath("//android.widget.TextView[@text='EUR-EURO']");
            Cur.click();
            Thread.sleep(2000);
            String RouteNo = getData("RoutingNumber");
            MobileElement RouteNum = appiumDriver.findElementByXPath("//android.widget.EditText[@text='Routing number (optional)']");
            RouteNum.sendKeys(RouteNo);
            Thread.sleep(2000);

            String Swift = getData("SwiftCode");
            MobileElement swiftcode = appiumDriver.findElementByXPath("//android.widget.EditText[@text='swift Code']");
            swiftcode.sendKeys(Swift);
            Thread.sleep(2000);

            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();


            String Add = getData("BenResAddress");
            List<MobileElement> list = appiumDriver.findElements(By.xpath("//android.widget.EditText[@text='Beneficiary Residence Address']"));
            System.out.println(list.size());
            list.get(0).sendKeys(Add);


            Thread.sleep(2000);

            MobileElement continues = appiumDriver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continues.click();
            Thread.sleep(3000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary Details Reviewed Successfully");
            MobileElement AddBen = appiumDriver.findElementByXPath("//android.widget.Button[@text='Add Beneficiary']");
            AddBen.click();
            Thread.sleep(5000);
            String otp = FetchOTP.getOTP().replace("Your Code for this transaction is ", "").trim();
            driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']").sendKeys(otp);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Given Successfully");
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            Thread.sleep(12000);
            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your beneficiary has been successfully created']");

            if (SuccessMsg.isDisplayed()) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Your beneficiary has been successfully created");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to home']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to add Beneficary name" + e.getMessage());
        }


    }

    /**
     * This method is used to Delete the Beneficary within Meem
     *
     * @throws NoSuchElementException
     */

    public static void Within_Meem_Ben_deletion() {
        try {
            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(15000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");

            String BenName = getData("BenName");

            List<MobileElement> BenNames = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenNames.size());
            int Namesize = BenNames.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name);


                if (Name.contains(BenName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag = true;
                    break;
                }

            }

            if (Flag == true) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                // ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }

            MobileElement Delete = driver.findElementByXPath("//android.widget.TextView[@text='Delete']");
            Delete.click();
            Thread.sleep(2000);

            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            Thread.sleep(2000);

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Confirm']");
            confirmtn.click();
            Thread.sleep(2000);


            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='The beneficiary has been deleted']");

            if (SuccessMsg.isDisplayed()) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted']");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to beneficiary management']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            // ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    /**
     * This method is used to Delete the Beneficary within Bahrain
     *
     * @throws NoSuchElementException
     */

    public static void Within_Bahrain_Ben_deletion() {
        try {
            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(15000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");

            String BenName = getData("NickName");

            List<MobileElement> BenNames = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenNames.size());
            int Namesize = BenNames.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name);


                if (Name.contains(BenName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag = true;
                    break;
                }

            }

            if (Flag == true) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                // ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }

            MobileElement Delete = driver.findElementByXPath("//android.widget.TextView[@text='Delete']");
            Delete.click();
            Thread.sleep(2000);

            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            Thread.sleep(2000);

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Confirm']");
            confirmtn.click();
            Thread.sleep(2000);


            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='The beneficiary has been deleted']");

            if (SuccessMsg.isDisplayed()) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted']");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to beneficiary management']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            // ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }


    /**
     * This method is used to Delete the International Beneficary
     *
     * @throws NoSuchElementException
     */

    public static void International_Ben_deletion() {
        try {
            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            Thread.sleep(5000);
            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            Thread.sleep(2000);
            appiumDriver.findElementByXPath("//android.widget.TextView[@text='Beneficiary Management']").click();
            Thread.sleep(15000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Beneficary Management selected Successfully");

            String BenName = getData("NickName");

            List<MobileElement> BenNames = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenNames.size());
            int Namesize = BenNames.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name);


                if (Name.contains(BenName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag = true;
                    break;
                }

            }

            if (Flag == true) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                // ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }

            MobileElement Delete = driver.findElementByXPath("//android.widget.TextView[@text='Delete']");
            Delete.click();
            Thread.sleep(2000);

            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            Thread.sleep(2000);

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Confirm']");
            confirmtn.click();
            Thread.sleep(2000);


            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='The beneficiary has been deleted']");

            if (SuccessMsg.isDisplayed()) {
                //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary has been deleted']");
                Thread.sleep(3000);
                MobileElement HomeBtn = appiumDriver.findElementByXPath("//android.widget.Button[@text='Go to beneficiary management']");
                HomeBtn.click();
                Thread.sleep(3000);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
            // ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    /**
     * This method is used to Transfers the funds from Onepack to FCY
     *
     * @throws NoSuchElementException
     */


    public static void Own_Acc_Onepack_To_FCY() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Own Accounts']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Own Accounts']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String ToBenIBANNo = getData("ToACCIBANNo");
            List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNos.size());
            int Namesize1 = IBANNos.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name1);


                if (Name1.contains(ToBenIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag1 = true;
                    break;
                }

            }


            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);
            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(4000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    /**
     * This method is used to Transfers the funds from FCY to Onepack
     *
     * @throws NoSuchElementException
     */

    public static void Own_Acc_FCY_To_Onepack() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Own Accounts']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Own Accounts']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String ToBenIBANNo = getData("ToACCIBANNo");
            List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNos.size());
            int Namesize1 = IBANNos.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name1);


                if (Name1.contains(ToBenIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag1 = true;
                    break;
                }

            }


            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);
            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(4000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    /**
     * This method is used to Transfers the funds from FCY to FCY
     *
     * @throws NoSuchElementException
     */


    public static void Own_Acc_FCY_To_FCY() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Own Accounts']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Own Accounts']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String ToBenIBANNo = getData("ToACCIBANNo");
            List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNos.size());
            int Namesize1 = IBANNos.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name1);


                if (Name1.contains(ToBenIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag1 = true;
                    break;
                }

            }


            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);
            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(4000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    public static void Own_Acc_Insufficent_Bal() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Own Accounts']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Own Accounts']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String ToBenIBANNo = getData("ToACCIBANNo");
            List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNos.size());
            int Namesize1 = IBANNos.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name1);


                if (Name1.contains(ToBenIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag1 = true;
                    break;
                }

            }


            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);
            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();

            waitToElement("//android.widget.TextView[@text='Insufficient balance.']");
            MobileElement Insuffmsg = driver.findElementByXPath("//android.widget.TextView[@text='Insufficient balance.']");
            String Insufficientmsg = Insuffmsg.getText();
            ReportHelper.logReportStatus(LogStatus.PASS, "Insufficient balance");

            clickCancelButton();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    public static void clickCancelButton() {
        try {

            waitToElement("//android.widget.Button[@text='Cancel']");
            MobileElement Cancel = driver.findElementByXPath("//android.widget.Button[@text='Cancel']");
            Cancel.click();

            ReportHelper.logReportStatus(LogStatus.PASS, "The cancel button has been clicked");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to click Cancel Button");
        }
    }

    public static void Within_Meem_Transfer_BHD_to_BHD() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Within Meem']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Within Meem']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize1 = BenName.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            waitToElement("//android.widget.ImageView[@index='1']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.ImageView[@index='1']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    public static void Within_Meem_Transfer_BHD_to_FCY() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Within Meem']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Within Meem']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize1 = BenName.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            waitToElement("//android.widget.ImageView[@index='1']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.ImageView[@index='1']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    public static void Within_Meem_Transfer_FCY_to_BHD() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Within Meem']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Within Meem']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize1 = BenName.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            waitToElement("//android.widget.ImageView[@index='1']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.ImageView[@index='1']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }

    public static void Within_Meem_Transfer_FCY_to_FCY() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();
            waitToElement("//android.widget.TextView[@text='Within Meem']");

            MobileElement OwnAccounts = driver.findElementByXPath("//android.widget.TextView[@text='Within Meem']");
            OwnAccounts.click();
            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize1 = BenName.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            waitToElement("//android.widget.ImageView[@index='1']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.ImageView[@index='1']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            MobileElement confirmtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmtn.click();
            waitToElement("//android.widget.TextView[contains(@text,'Ref No ')]");

            String RefNo = driver.findElementByXPath("//android.widget.TextView[contains(@text,'Ref No ')]").getText();
            saveTestDataToDb("RefNo", RefNo);
            Thread.sleep(3000);
            System.out.println(RefNo);

            waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your transfer was successfully done");
            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Delete Beneficary name");
        }
    }


    public static void Standing_Inst_Setup_Within_OwnAcc() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();

            waitToElement("//android.widget.TextView[@text='Set Standing Instructions']");
            MobileElement StandingIns = driver.findElementByXPath("//android.widget.TextView[@text='Set Standing Instructions']");
            StandingIns.click();

            waitToElement("//android.widget.Button[@text='T']");
            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();

            waitToElement("//android.widget.TextView[@text='U']");
            MobileElement TypeofStaindingInsDropdown = driver.findElementByXPath("//android.widget.TextView[@text='U']");
            TypeofStaindingInsDropdown.click();
           // ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been viewed Successfuly']");

            String StandingInstructionType = getData("TypeofStandIns");

            List<MobileElement> TypeOfIns = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(TypeOfIns.size());
            int Namesize1 = TypeOfIns.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(StandingInstructionType)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);

            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String ToBenIBANNo = getData("ToACCIBANNo");
            List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNos.size());
            int Namesize2 = IBANNos.size();
            boolean Flag2;
            Flag2 = false;
            for (int i = 1; i < Namesize2 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name1);


                if (Name1.contains(ToBenIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag1 = true;
                    break;
                }

            }


            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.10);
            int startX = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();

            waitToElement("//android.widget.TextView[@text='U']");
            MobileElement Frequencydropdown = driver.findElementByXPath("//android.widget.TextView[@text='U']");
            Frequencydropdown.click();

            String Frequency=getData("Frequency");
            waitToElement("//android.widget.ListView//android.widget.CheckedTextView");
            List<MobileElement> Fre = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(Fre.size());
            int Namesize3 = IBANNos.size();
            boolean Flag3;
            Flag3 = false;
            for (int i = 1; i < Namesize3 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(Frequency)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag3 = true;
                    break;
                }

            }


            waitToElement("//android.widget.TextView[@index='1' and @text='U']");
            MobileElement Startdate = driver.findElementByXPath("//android.widget.TextView[@index='1' and @text='U']");
            Startdate.click();

            waitToElement("//android.widget.Button[@text='OK']");
            MobileElement OkButton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            OkButton.click();

            String Transfers=getData("NoofTransfers");
            waitToElement("//android.widget.EditText[@text='Number of Transfers']");
            MobileElement NoofTransfers = driver.findElementByXPath("//android.widget.EditText[@text='Number of Transfers']");
            NoofTransfers.sendKeys(Transfers);

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement confirmbtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmbtn.click();

            waitToElement("//android.widget.TextView[@text='You have successfully schedule a standing instructions']");
            String Successmsg=driver.findElement(By.xpath("//android.widget.TextView[@text='You have successfully schedule a standing instructions']")).getText();
            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to schedule a standing instructions");
        }
    }


    public static void Standing_Inst_Setup_Within_Meem() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();

            waitToElement("//android.widget.TextView[@text='Set Standing Instructions']");
            MobileElement StandingIns = driver.findElementByXPath("//android.widget.TextView[@text='Set Standing Instructions']");
            StandingIns.click();

            waitToElement("//android.widget.Button[@text='T']");
            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();

            waitToElement("//android.widget.TextView[@text='U']");
            MobileElement TypeofStaindingInsDropdown = driver.findElementByXPath("//android.widget.TextView[@text='U']");
            TypeofStaindingInsDropdown.click();
            // ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been viewed Successfuly']");

            String StandingInstructionType = getData("TypeofStandIns");

            List<MobileElement> TypeOfIns = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(TypeOfIns.size());
            int Namesize1 = TypeOfIns.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(StandingInstructionType)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);

            waitToElement("// android.widget.TextView[@text='V']");
            MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
            FromAcc.click();
            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String FromAccIBANNo = getData("FromACCIBANNo");
            List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
            System.out.println(IBANNo.size());
            int Namesize = IBANNo.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                System.out.println(Name);


                if (Name.contains(FromAccIBANNo)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("// android.widget.TextView[@text='V' and @index='1']");
            MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V' and @index='1']");
            ToAcc.click();

            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize11 = BenName.size();
            boolean Flag11;
            Flag11 = false;
            for (int i = 1; i < Namesize11 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag11 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }



            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.10);
            int startX = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();

            waitToElement("//android.widget.TextView[@text='Select a purpose']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select a purpose']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.TextView[@text='Select frequency']");
            MobileElement Frequencydropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select frequency']");
            Frequencydropdown.click();

            String Frequency=getData("Frequency");
            waitToElement("//android.widget.ListView//android.widget.CheckedTextView");
            List<MobileElement> Fre = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(Fre.size());
            int Namesize3 = Fre.size();
            boolean Flag3;
            Flag3 = false;
            for (int i = 1; i < Namesize3 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(Frequency)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag3 = true;
                    break;
                }

            }

            Thread.sleep(3000);


            waitToElement("//android.widget.TextView[@text='Start Date']");
            MobileElement Startdate = driver.findElementByXPath("//android.widget.TextView[@text='Start Date']");
            Startdate.click();

            MobileElement date = driver.findElementByXPath("//android.view.View[@index='17' and @text='18']");
            date.click();

            waitToElement("//android.widget.Button[@text='OK']");
            MobileElement OkButton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            OkButton.click();
            Thread.sleep(2000);

            String Transfers=getData("NoofTransfers");
            waitToElement("//android.widget.EditText[@text='Number of Transfers']");
            MobileElement NoofTransfers = driver.findElementByXPath("//android.widget.EditText[@text='Number of Transfers']");
            NoofTransfers.sendKeys(Transfers);

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement confirmbtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmbtn.click();

            waitToElement("//android.widget.TextView[@text='You have successfully schedule a standing instructions']");
            String Successmsg=driver.findElement(By.xpath("//android.widget.TextView[@text='You have successfully schedule a standing instructions']")).getText();
            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to schedule a standing instructions");
        }
    }


    public static void Standing_Inst_Setup_Within_Bahrain() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();

            waitToElement("//android.widget.TextView[@text='Set Standing Instructions']");
            MobileElement StandingIns = driver.findElementByXPath("//android.widget.TextView[@text='Set Standing Instructions']");
            StandingIns.click();

            waitToElement("//android.widget.Button[@text='T']");
            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();

            waitToElement("//android.widget.TextView[@text='U']");
            MobileElement TypeofStaindingInsDropdown = driver.findElementByXPath("//android.widget.TextView[@text='U']");
            TypeofStaindingInsDropdown.click();
            // ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been viewed Successfuly']");

            String StandingInstructionType = getData("TypeofStandIns");

            List<MobileElement> TypeOfIns = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(TypeOfIns.size());
            int Namesize1 = TypeOfIns.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(StandingInstructionType)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.TextView[@text='Select a beneficiary']");
            MobileElement ToAcc = driver.findElementByXPath("//android.widget.TextView[@text='Select a beneficiary']");
            ToAcc.click();

            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize11 = BenName.size();
            boolean Flag11;
            Flag11 = false;
            for (int i = 1; i < Namesize11 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag11 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }



            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.10);
            int startX = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();

            waitToElement("//android.widget.TextView[@text='Select a purpose']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select a purpose']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.TextView[@text='Select a subpurpose']");
            MobileElement SubPurposedropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select a subpurpose']");
            SubPurposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='SAVING']");
            MobileElement SubPurpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='SAVING']");
            SubPurpose.click();

            waitToElement("//android.widget.TextView[@text='Select frequency']");
            MobileElement Frequencydropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select frequency']");
            Frequencydropdown.click();

            String Frequency=getData("Frequency");
            waitToElement("//android.widget.ListView//android.widget.CheckedTextView");
            List<MobileElement> Fre = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(Fre.size());
            int Namesize3 = Fre.size();
            boolean Flag3;
            Flag3 = false;
            for (int i = 1; i < Namesize3 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(Frequency)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag3 = true;
                    break;
                }

            }

            Thread.sleep(3000);


            waitToElement("//android.widget.TextView[@text='Start Date']");
            MobileElement Startdate = driver.findElementByXPath("//android.widget.TextView[@text='Start Date']");
            Startdate.click();

            MobileElement date = driver.findElementByXPath("//android.view.View[@index='17' and @text='18']");
            date.click();

            waitToElement("//android.widget.Button[@text='OK']");
            MobileElement OkButton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            OkButton.click();
            Thread.sleep(2000);

            String Transfers=getData("NoofTransfers");
            waitToElement("//android.widget.EditText[@text='Number of Transfers']");
            MobileElement NoofTransfers = driver.findElementByXPath("//android.widget.EditText[@text='Number of Transfers']");
            NoofTransfers.sendKeys(Transfers);

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement confirmbtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmbtn.click();

            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);

            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(OTP);

            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Entered Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation OTP Given Successfully");


            waitToElement("//android.widget.TextView[@text='You have successfully schedule a standing instructions']");
            String Successmsg=driver.findElement(By.xpath("//android.widget.TextView[@text='You have successfully schedule a standing instructions']")).getText();
            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to schedule a standing instructions");
        }
    }

    public static void Standing_Inst_Setup_International() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Transfers']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Transfer = driver.findElementByXPath("//android.widget.TextView[@text='Transfers']");
            Transfer.click();

            waitToElement("//android.widget.TextView[@text='Set Standing Instructions']");
            MobileElement StandingIns = driver.findElementByXPath("//android.widget.TextView[@text='Set Standing Instructions']");
            StandingIns.click();

            waitToElement("//android.widget.Button[@text='T']");
            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();

            waitToElement("//android.widget.TextView[@text='U']");
            MobileElement TypeofStaindingInsDropdown = driver.findElementByXPath("//android.widget.TextView[@text='U']");
            TypeofStaindingInsDropdown.click();
            // ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been viewed Successfuly']");

            String StandingInstructionType = getData("TypeofStandIns");

            List<MobileElement> TypeOfIns = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(TypeOfIns.size());
            int Namesize1 = TypeOfIns.size();
            boolean Flag1;
            Flag1 = false;
            for (int i = 1; i < Namesize1 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(StandingInstructionType)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag1 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "Type of standing Instructions has been Selected Successfuly']");
                    break;

                }

            }

            Thread.sleep(5000);
            waitToElement("//android.widget.TextView[@text='Select a beneficiary']");
            MobileElement ToAcc = driver.findElementByXPath("//android.widget.TextView[@text='Select a beneficiary']");
            ToAcc.click();

            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']");
            String BeneName = getData("BeneficaryName");
            List<MobileElement> BenName = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(BenName.size());
            int Namesize11 = BenName.size();
            boolean Flag11;
            Flag11 = false;
            for (int i = 1; i < Namesize11 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name1);


                if (Name1.contains(BeneName)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag11 = true;
                    ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");
                    break;

                }

            }



            if (Flag1 == true) {
                ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

            } else {
                ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

            }
            waitToElement("//android.widget.EditText[@index='0']");
            String Bal = getData("Amount");
            MobileElement Balance = driver.findElementByXPath("//android.widget.EditText[@index='0']");
            Balance.sendKeys(Bal);

            TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size = driver.manage().window().getSize();
            int startY = (int) (size.height * 0.80);
            int endY = (int) (size.height * 0.10);
            int startX = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();

            waitToElement("//android.widget.TextView[@text='Select a purpose']");
            MobileElement Purposedropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select a purpose']");
            Purposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='PERSONAL']");
            MobileElement Purpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='PERSONAL']");
            Purpose.click();

            waitToElement("//android.widget.TextView[@text='Select a subpurpose']");
            MobileElement SubPurposedropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select a subpurpose']");
            SubPurposedropdown.click();

            waitToElement("//android.widget.CheckedTextView[@text='SAVING']");
            MobileElement SubPurpose = driver.findElementByXPath("//android.widget.CheckedTextView[@text='SAVING']");
            SubPurpose.click();

            waitToElement("//android.widget.TextView[@text='Select frequency']");
            MobileElement Frequencydropdown = driver.findElementByXPath("//android.widget.TextView[@text='Select frequency']");
            Frequencydropdown.click();

            String Frequency=getData("Frequency");
            waitToElement("//android.widget.ListView//android.widget.CheckedTextView");
            List<MobileElement> Fre = driver.findElements(By.xpath("//android.widget.ListView//android.widget.CheckedTextView"));
            System.out.println(Fre.size());
            int Namesize3 = Fre.size();
            boolean Flag3;
            Flag3 = false;
            for (int i = 1; i < Namesize3 + 1; i++) {

                String Name1 = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).getText();
                System.out.println(Name1);


                if (Name1.contains(Frequency)) {

                    driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id='android:id/text1'][" + i + "]")).click();
                    Flag3 = true;
                    break;
                }

            }

            Thread.sleep(3000);


            waitToElement("//android.widget.TextView[@text='Start Date']");
            MobileElement Startdate = driver.findElementByXPath("//android.widget.TextView[@text='Start Date']");
            Startdate.click();

            MobileElement date = driver.findElementByXPath("//android.view.View[@index='17' and @text='18']");
            date.click();

            waitToElement("//android.widget.Button[@text='OK']");
            MobileElement OkButton = driver.findElementByXPath("//android.widget.Button[@text='OK']");
            OkButton.click();
            Thread.sleep(2000);

            TouchAction action1 = new TouchAction((AppiumDriver<MobileElement>) driver);
            driver.context("NATIVE_APP");
            Dimension size1 = driver.manage().window().getSize();
            int startY1 = (int) (size.height * 0.80);
            int endY1 = (int) (size.height * 0.10);
            int startX1 = size.width / 2;
            System.out.println("Performing Swipe action");
            action.longPress(point(startX1, startY1)).moveTo(point(startX1, endY1)).release().perform();

            String Transfers=getData("NoofTransfers");
            waitToElement("//android.widget.EditText[@text='Number of Transfers']");
            MobileElement NoofTransfers = driver.findElementByXPath("//android.widget.EditText[@text='Number of Transfers']");
            NoofTransfers.sendKeys(Transfers);

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();

            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement confirmbtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            confirmbtn.click();

            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);

            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(OTP);

            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Entered Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation OTP Given Successfully");


            waitToElement("//android.widget.TextView[@text='You have successfully schedule a standing instructions']");
            String Successmsg=driver.findElement(By.xpath("//android.widget.TextView[@text='You have successfully schedule a standing instructions']")).getText();
            ReportHelper.logReportStatus(LogStatus.PASS, "You have successfully schedule a standing instructions");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to schedule a standing instructions");
        }
    }


    public static void Add_Online_Biller() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Fawateer']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Fawateer = driver.findElementByXPath("//android.widget.TextView[@text='Fawateer']");
            Fawateer.click();
            waitToElement("//android.widget.Button[@text='T']");

            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();
            waitToElement("//android.widget.TextView[@text='Select the biller']");
            MobileElement SelectBiller = driver.findElementByXPath("//android.widget.TextView[@text='Select the biller']");
            SelectBiller.click();

            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']");
            String Billers = getData("BillersName");
            List<MobileElement> Nos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(Nos.size());
            int Namesize = Nos.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name);


                if (Name.contains(Billers)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("//android.widget.TextView[@text='Choose Service']");
            MobileElement BillService = driver.findElementByXPath("//android.widget.TextView[@text='Choose Service']");
            BillService.click();

            waitToElement("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            MobileElement BillType = driver.findElementByXPath("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            BillType.click();

            String Nicknames=getData("NickName");
            waitToElement("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            MobileElement NickName = driver.findElementByXPath("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            NickName.sendKeys(Nicknames);



            waitToElement("//android.widget.EditText[@text='TLN - Telephone number']");
            String telNo=getData("TelephoneNumber");
            MobileElement Tele = driver.findElementByXPath("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            Tele.sendKeys(telNo);


            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);

            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(OTP);

            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Entered Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation OTP Given Successfully");


            waitToElement("//android.widget.TextView[@text='Your biller has been successfully added. It is available at biller's list']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your biller has been successfully added. It is available at biller's list']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your biller has been successfully added. It is available at biller's list");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add Biller");
        }
    }

    public static void Add_Offline_Biller() {
        try {


            waitToElement("//android.widget.Button[@text='S']");
            clickHarmburgerMenuBTN();
            waitToElement("//android.widget.TextView[@text='Fawateer']");
            AppiumDriver<MobileElement> driver = getAppiumDriver();

            MobileElement Fawateer = driver.findElementByXPath("//android.widget.TextView[@text='Fawateer']");
            Fawateer.click();
            waitToElement("//android.widget.Button[@text='T']");

            MobileElement AddButton = driver.findElementByXPath("//android.widget.Button[@text='T']");
            AddButton.click();
            waitToElement("//android.widget.TextView[@text='Select the biller']");
            MobileElement SelectBiller = driver.findElementByXPath("//android.widget.TextView[@text='Select the biller']");
            SelectBiller.click();

            waitToElement("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']");
            String Billers = getData("BillersName");
            List<MobileElement> Nos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='0']"));
            System.out.println(Nos.size());
            int Namesize = Nos.size();
            boolean Flag;
            Flag = false;
            for (int i = 1; i < Namesize + 1; i++) {

                String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).getText();
                System.out.println(Name);


                if (Name.contains(Billers)) {

                    driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='0']")).click();
                    Flag = true;
                    break;
                }

            }

            waitToElement("//android.widget.TextView[@text='Choose Service']");
            MobileElement BillService = driver.findElementByXPath("//android.widget.TextView[@text='Choose Service']");
            BillService.click();

            waitToElement("//android.widget.CheckedTextView[@text='CITI Utility Payments']");
            MobileElement BillType = driver.findElementByXPath("//android.widget.CheckedTextView[@text='CITI Utility Payments']");
            BillType.click();

            String Nicknames = getData("NickName");
            waitToElement("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            MobileElement NickName = driver.findElementByXPath("//android.widget.CheckedTextView[@text='MASN Prepaid Voice']");
            NickName.sendKeys(Nicknames);


            waitToElement("//android.widget.EditText[@text='SN - Subscriber Number']");
            String telNo = getData("TelephoneNumber");
            MobileElement Tele = driver.findElementByXPath("//android.widget.EditText[@text='SN - Subscriber Number']");
            Tele.sendKeys(telNo);


            waitToElement("//android.widget.Button[@text='Continue']");
            MobileElement continuebtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continuebtn.click();
            waitToElement("//android.widget.Button[@text='Continue']");

            String OTP = FetchOTP_Meem.getOTP().replace("Your Code for this transaction is ", "").trim();
            System.out.println(OTP);

            waitToElement("//android.widget.EditText[@text='Confirmation Code']");

            MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
            ConfirmCode.sendKeys(OTP);

            ReportHelper.logReportStatus(LogStatus.PASS, "OTP Entered Successfully");
            driver.hideKeyboard();
            MobileElement continueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
            continueBtn.click();
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation OTP Given Successfully");


            waitToElement("//android.widget.TextView[@text='Your biller has been successfully added. It is available at biller's list']");

            MobileElement SuccessMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your biller has been successfully added. It is available at biller's list']");

            ReportHelper.logReportStatus(LogStatus.PASS, "Your biller has been successfully added. It is available at biller's list");

            waitToElement("//android.widget.Button[@text='Go to home']");
            MobileElement HomeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
            HomeBtn.click();
            Thread.sleep(7000);


        } catch (Exception e) {
            System.out.println(e.getMessage());
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Add the Biller");
        }
    }






    public static void fundTransfer() {
        try {

            Thread.sleep(2000);
            clickHarmburgerMenuBTN();
            clickTransferBTN();


            String TransferType = getData("TransferType");
            switch (TransferType) {
                case "Own Accounts":
                    MobileElement OwnAccounts = driver.findElementByXPath("// android.widget.TextView[@text='OwnAccounts']");
                    OwnAccounts.click();
                    Thread.sleep(5000);
                    MobileElement FromAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
                    FromAcc.click();
                    Thread.sleep(3000);
                    String FromAccIBANNo = getData("NickName");
                    List<MobileElement> IBANNo = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
                    System.out.println(IBANNo.size());
                    int Namesize = IBANNo.size();
                    boolean Flag;
                    Flag = false;
                    for (int i = 1; i < Namesize + 1; i++) {

                        String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                        System.out.println(Name);


                        if (Name.contains(FromAccIBANNo)) {

                            driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                            Flag = true;
                            break;
                        }

                    }

                    Thread.sleep(5000);
                    MobileElement ToAcc = driver.findElementByXPath("// android.widget.TextView[@text='V']");
                    ToAcc.click();
                    Thread.sleep(3000);
                    String ToBenIBANNo = getData("NickName");
                    List<MobileElement> IBANNos = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup//android.widget.TextView[@index='1']"));
                    System.out.println(IBANNos.size());
                    int Namesize1 = IBANNos.size();
                    boolean Flag1;
                    Flag1 = false;
                    for (int i = 1; i < Namesize1 + 1; i++) {

                        String Name = driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).getText();
                        System.out.println(Name);


                        if (Name.contains(ToBenIBANNo)) {

                            driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView//android.view.ViewGroup[" + i + "]//android.widget.TextView[@index='1']")).click();
                            Flag1 = true;
                            break;
                        }

                    }


                    if (Flag1 == true) {
                        //ReportHelper.logReportStatus(LogStatus.PASS, "The beneficiary name has been Selected Successfuly']");

                    } else {
                        // ReportHelper.logReportStatus(LogStatus.PASS, "Unable to Select the beneficary Name']");

                    }

                    break;

                case "Within Meem":
                    MobileElement WithinMeem = driver.findElementByXPath("// android.widget.TextView[@text='Within Meem']");
                    WithinMeem.click();
                    break;
                case "Within Bahrain":
                    MobileElement withinBahrain = driver.findElementByXPath("// android.widget.TextView[@text='Within Meem']");
                    withinBahrain.click();
                    break;

                case "International":
                    System.out.println("International ");
                    String transferMsg = "Your transfer was successfully done";
                    clickIntertnational();
                    internationalFundTransfer();
                    MobileElement continueBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
                    continueBtn.click();


                    String otp = FetchOTP.getInternationalOTP().replace("The Code for your transfer:", "").trim();
                    waitToElement("//android.widget.EditText[@text='Confirmation Code']");

                    MobileElement ConfirmCode = driver.findElementByXPath("//android.widget.EditText[@text='Confirmation Code']");
                    ConfirmCode.sendKeys(otp);

                    MobileElement confirmContinueBtn = driver.findElementByXPath("//android.widget.Button[@text='Continue']");
                    confirmContinueBtn.click();

                    waitToElement("//android.widget.TextView[@text='Your transfer was successfully done']");


                    MobileElement successMsg = driver.findElementByXPath("//android.widget.TextView[@text='Your transfer was successfully done']");
                    System.out.println(successMsg.getText());

                    String UBSreference = driver.findElementByXPath("// android.widget.TextView[contains(@text,'Ref No')]").getText();
                    System.out.println(UBSreference);
                    saveTestDataToDb("UBSreference", UBSreference.substring(8));

                    if (successMsg.getText().equals(transferMsg)) {
                        ReportHelper.logReportStatus(LogStatus.PASS, "International fund transfer was successfully done");
                    }


                    MobileElement homeBtn = driver.findElementByXPath("//android.widget.Button[@text='Go to home']");
                    homeBtn.click();
                    ReportHelper.logReportStatus(LogStatus.PASS, "Home button has been clicked");
            }
            Android_MeemBah_Logout();
            UBSValidation_MeemAndroid();


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "unable to do fund transfer" + e.getMessage());

        }
    }

    /**
     * This method is used to validate the insufficient balanace for international fund transfer
     */

    public static void INTTransfer_Insufficientbalance() {

        try {
            clickHarmburgerMenuBTN();
            clickTransferBTN();
            clickIntertnational();
            internationalFundTransfer();
            waitToElement("//android.widget.TextView[@text='Insufficient balance.']");

            MobileElement insufficientMSG = driver.findElement(By.xpath("//android.widget.TextView[@text='Insufficient balance.']"));
            verifyElementIsDisplayed(insufficientMSG, "Insufficient Balance");
            clickCancelButton();

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "unable to verify the message" + e.getMessage());
        }


    }


    /**
     *This method is used to click International button in Transfer screen
     *

     */
    public static void clickIntertnational() {
        try {
            AppiumDriver<MobileElement> driver = getAppiumDriver();
            waitToElement("// android.widget.TextView[@text='International']");
            MobileElement internationalBTN = driver.findElementByXPath("// android.widget.TextView[@text='International']");
            internationalBTN.click();
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "unable to click International transfer button" + e.getMessage());
        }
    }


    /**
     * This Method is used to International fund transfer
     */

    public static void internationalFundTransfer() {
        try {
            AppiumDriver<MobileElement> driver = getAppiumDriver();
            waitToElement("// android.widget.TextView[@text='Select a beneficiary']");
            MobileElement fromAccount = driver.findElementByXPath("// android.widget.TextView[@text='Select a beneficiary']");
            fromAccount.click();
            Thread.sleep(2000);
            String fromAccountValue = getData("FromACCName");
            System.out.println(fromAccountValue);
            String amountValue = getData("Amount");
            String purpose = getData("Purpose");
            String subPurpose = getData("subPurpose");


            driver.findElementByXPath("//android.widget.EditText[@text='Search for a beneficiary']").sendKeys(fromAccountValue);
            Thread.sleep(2000);
            driver.findElementByXPath("//	android.widget.TextView[@text='" + fromAccountValue + "']").click();
            ReportHelper.logReportStatus(LogStatus.PASS, "The Beneficiary Account " + fromAccountValue + " has been selected ");
            waitToElement("//android.widget.EditText[@text='0.000']");
            MobileElement amount = driver.findElementByXPath("//android.widget.EditText[@text='0.000']");
            amount.clear();
            amount.sendKeys(amountValue);
            ReportHelper.logReportStatus(LogStatus.PASS, "The Amount " + amountValue + " has been entered sucessfully");
            FuncSwipe();

            driver.findElementByXPath("//android.widget.TextView[@text='Select a purpose']").click();
            waitToElement("//android.widget.CheckedTextView[@text='" + purpose + "']");
            ReportHelper.logReportStatus(LogStatus.PASS, "The purpose " + purpose + " has been selected ");

            driver.findElementByXPath("//android.widget.CheckedTextView[@text='" + purpose + "']").click();
            waitToElement("//android.widget.TextView[@text='Select a subpurpose']");


            driver.findElementByXPath("//android.widget.TextView[@text='Select a subpurpose']").click();
            waitToElement("//android.widget.CheckedTextView[@text='" + subPurpose + "']");
            driver.findElementByXPath("//android.widget.CheckedTextView[@text='" + subPurpose + "']").click();
            Thread.sleep(2000);

            MobileElement continueBtn = driver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
            continueBtn.click();
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to do  International Fund  transfer " + e.getMessage());
        }
    }


    /**
     * This method is used to logout the Meem Bahrain Application
     *
     * @throws NoSuchElementException
     */


    public static void Android_MeemBah_Logout() throws Exception{

        try {
            Thread.sleep(3000);
            clickHarmburgerMenuBTN();

            AppiumDriver<MobileElement> appiumDriver = getAppiumDriver();
            waitToElement("//android.widget.Button[@text='Logout']");

            appiumDriver.findElementByXPath("//android.widget.Button[@text='Logout']").click();
            waitToElement("//android.widget.TextView[@text='Digital banking']");
            ReportHelper.logReportStatus(LogStatus.PASS, "Logged out successfully");
            appiumDriver.quit();


        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Logout" + e.getMessage());

        }

    }


    public static void toAndroid_UBS_Fund_Transfers() throws Exception {
        try {


            // System.setProperty("webdriver.chrome.driver", driverFolder+"chromedriver.exe");
            DriverHelper.environmentURL = "MKR6~UBS_BAH~T8";
            st_UBS.all_Login_UBS();
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
            String RefNo = Num.replace("Ref No  ", "").trim();
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
            WebElement Confmsg = driver.findElement(By.xpath("//iframe[@title='Confirmation Message']"));
            driver.switchTo().frame(Confmsg);
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Confirmation Message");
            driver.findElement(By.xpath("//*[@id='BTN_OK']")).click();
            Thread.sleep(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "UBS Funds Transfers verified Successfully");
            driver.close();
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to Verify the funds due to" + e.getMessage() + "'");
        }
    }


    /**
     * This function  is used to swipe up
     *
     * @throws Exception
     */


    public static void FuncSwipe() {
        AppiumDriver<MobileElement> driver = getAppiumDriver();

        TouchAction action = new TouchAction((AppiumDriver<MobileElement>) driver);

        driver.context("NATIVE_APP");

        Dimension size = driver.manage().window().getSize();

        int startY = (int) (size.height * 0.80);

        int endY = (int) (size.height * 0.10);

        int startX = size.width / 2;
        action.longPress(point(startX, startY)).moveTo(point(startX, endY)).release().perform();

    }

    public static void waitToElement(String xpathExpression) {

        try {
            AppiumDriver<MobileElement> driver = getAppiumDriver();
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));
        } catch (Exception e) {

            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to find element" + e.getMessage());
        }
    }


    /*
     * This method is used for tap an MobileElement
     *
     *
       MobileElement
     *
     * @throws Exception
     */

    public static void tap(MobileElement elementToTap) {

        try {
            AppiumDriver<MobileElement> driver = getAppiumDriver();
            TouchActions action = new TouchActions(driver);
            action.singleTap(elementToTap);
            action.perform();


        } catch (Exception e) {

            ReportHelper.logReportStatus(LogStatus.FAIL, "Unable to find element" + e.getMessage());
        }
    }

    /**
     * This method will verify the element is displayed on the screen.
     *
     * @ param The element which has to be identified
     * @ param Text
     * to print in report
     */

    public static void verifyElementIsDisplayed(MobileElement mobileElement, String expectedText) {
        try {

            AppiumDriver<MobileElement> driver = getAppiumDriver();
            WebDriverWait wait = new WebDriverWait(driver, 25);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            if (mobileElement.isDisplayed())
                ReportHelper.logReportStatus(LogStatus.PASS, "The text " + expectedText + " is displayed");
            else
                ReportHelper.logReportStatus(LogStatus.FAIL, "The element  " + expectedText + " is not displayed");
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL, "The element  " + expectedText + " is not displayed");

        }
    }
}




