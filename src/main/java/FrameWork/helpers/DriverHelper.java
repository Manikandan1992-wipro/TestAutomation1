package FrameWork.helpers;

import FrameWork.listeners.ExtentManager;
import FrameWork.listeners.po_BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.*;
import io.appium.java_client.MobileElement;

import java.net.MalformedURLException;


import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.RetrieveData.Updateinsert;
import static FrameWork.listeners.PreReq.*;


import java.net.URL;

//import static POM.functions.Shopping.getgenarateLogTestStart;

public class DriverHelper { //extends PreReq {
    public static String testCaseName;
    public static String testSuiteName;
    public static String dataSheet;
    public static String dataBinding;
    public static String ENV;
    public static String environmentURL;
    public static String currentBrowser;
    public static ExtentReports extentWithout;
    public static ExtentReports extent;
    public static ExtentTest testWithout;
    public static ExtentTest test;
    public static Logger logger = Logger.getLogger("Inside helper Class " + DriverHelper.class.getName().toUpperCase());
    public static JavascriptExecutor javascriptExecutor = null;
    public WebDriver driver;

    public AppiumDriver appiumDriver;
//	public static HashMap<String, String> hmData = new HashMap<>();

    @BeforeSuite
    @Parameters({"browser", "dataBinder"})
    public static void extentManagerInit(@Optional String browser, @Optional String dataBinder, @Optional ITestContext iTestContext) throws Exception {
        //String PathofReportFile = baseReport +reportFilenameWithOutScreenshots+".html";
        // String PathofReportWithoutFile = baseReport +reportFilenameWithOutScreenshots+".html";
        try {
            testSuiteName = iTestContext.getCurrentXmlTest().getSuite().getName();
            initialiseFolderProperties(testSuiteName);
            extent = ExtentManager.Instance(reportFilenameWithScreenshots);
            extentWithout = ExtentManager.Instance(reportFilenameWithOutScreenshots);
            logger.info("Launching URL " + browser);
        } catch (Exception e) {
            logger.info("Error occured while launching URL " + browser);
        }
        //launchBrowser(String browser, String dataBinder, String env, @Optional ITestContext iTestContext);
    }

    @AfterSuite
    @Parameters({"browser", "dataBinder", "ENV", "dataSheet"})
    public static void updateEndRun(@Optional String browser, @Optional String dataBinder, @Optional String ENV, @Optional String applicationname, @Optional ITestContext iTestContext) throws Exception {

        try {
            String testSuiteName1 = iTestContext.getCurrentXmlTest().getSuite().getName();
            String env = ENV;

            String query = "update MasterTestExecutor set Run_TimeStamp=Now() where TestingType='" + testSuiteName1 + "' and ApplicationName='" + applicationname + "' and ENV='" + ENV + "' and Run='YES'";

            Updateinsert(query);



			/*initialiseFolderProperties(testSuiteName);
            extent = ExtentManager.Instance(reportFilenameWithScreenshots);
			extentWithout = ExtentManager.Instance(reportFilenameWithOutScreenshots);
			logger.info("Launching URL " + browser);*/
        } catch (Exception e) {
            logger.info("Error occured while launching URL " + browser);
        }
        //launchBrowser(String browser, String dataBinder, String env, @Optional ITestContext iTestContext);
    }



      @BeforeMethod(alwaysRun = true)
      public static void beforeMethod(Object[] testArgs, ITestContext ctx, Method method) {
      String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
       logger.info("Executing SUITE ::: " + suiteName + " ||| METHOD ::: " + method.getName());
    }

    public static void closeReportAndDriver() throws Exception {
        String testCaseId = getData("TestcaseID");
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String testDescrption = test.getDescription();
        String databinding = DriverHelper.dataBinding;
        Date startTimedate = test.getStartedTime();
        String startTime = df.format(startTimedate);
        String remarks = ReportHelper.Test_remarks;
        ResultSet rs = RetrieveData.getDbdata("Select TestCaseName from TestScript_Manager where TestCaseID='" + testCaseId + "'");
        String TcName = "";
        while (rs.next()) {
            TcName = rs.getString("TestCaseName");
        }
        rs.close();
        extent.endTest(test);
        extent.flush();
        extentWithout.endTest(testWithout);
        extentWithout.flush();
        // extent.close();


        Date endTimedate = test.getEndedTime();
        String endTime = df.format(endTimedate);
        endTime.toString();
        LogStatus statusresult = test.getRunStatus();
        String status = statusresult.toString();
        if (status.equalsIgnoreCase("fail")) {

            ITest test1 = test.getTest();
            System.out.println(test1.getName());
        }

        if (status.equalsIgnoreCase("Pass")) {
            String query1 = "update data_" + DriverHelper.dataSheet + " set RunStatus='OLD' where dataBinding='" + DriverHelper.dataBinding + "'";
            RetrieveData.update(query1);

        }
        RetrieveData.updateResult(testCaseId, TcName, databinding, startTime, endTime, status, remarks);

        ReportHelper.Test_remarks = "";


        po_BaseClass.drvr.quit();
    }

    private static WebDriver launchIEBrowser() {
//		String iedriver = fwConfig.get("ieDriver").toString();
        String iedriver = driverFolder + "IEDriverServer.exe";
        System.setProperty("webdriver.ie.driver", iedriver);
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        // Line of code is to resolve protected mode issue
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "about:blank");
//		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        WebDriver webDriver = new InternetExplorerDriver(capabilities);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//      webDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		webDriver.manage().window().setSize(new Dimension(1024, 768));
        return webDriver;
    }

    private static WebDriver launchChromeBrowser() {
//		String chromedriver = fwConfig.get("chromeDriver").toString();
        String chromedriver = driverFolder + "chromeDriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriver);
        //   System.out.println("chrome driver path : " + workingDir + subFolder + "drivers\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-web-security");
        DesiredCapabilities caps = DesiredCapabilities.chrome();
//		caps.setCapability();
        caps.setCapability(ChromeOptions.CAPABILITY, opt);
        WebDriver webDriver = new ChromeDriver(caps);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        return webDriver;
    }

    private static WebDriver launchFirefoxBrowser() {
//		String geckodriver = fwConfig.get("firefoxDriver").toString();
        String geckodriver = driverFolder + "geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", geckodriver);
        FirefoxProfile ffProf = new FirefoxProfile();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private static WebDriver launchOperaBrowser() {
//		String operadriver = fwConfig.get("operaDriver").toString();

        String operadriver = driverFolder + "operadriver.exe";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.setProperty("webdriver.opera.driver", operadriver);
        capabilities.setCapability("opera.binary", workingDir + subFolder + "drivers\\operadriver.exe");
        capabilities.setCapability("opera.log.level", "CONFIG");
        WebDriver driver = new OperaDriver(capabilities);
        return driver;
    }

    private static AppiumDriver<MobileElement> launchAndroid() throws MalformedURLException, InterruptedException {
//		String operadriver = fwConfig.get("operaDriver").toString();
        AppiumDriver<MobileElement> driver;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\300096\\Downloads\\MeemBahrainMobileUAT_08052018.apk");
        capabilities.setCapability(MobileCapabilityType.UDID, projectConfig.getProperty("UDID").toString());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, projectConfig.getProperty("DEVICE_NAME").toString());
        capabilities.setCapability("appPackage", projectConfig.getProperty("appPackage").toString());
        capabilities.setCapability("appActivity", projectConfig.getProperty("appActivity").toString());
        capabilities.setCapability(MobileCapabilityType.PLATFORM, projectConfig.getProperty("PLATFORM_NAME").toString());
        capabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, true);
        capabilities.setCapability("noReset", true);
        //capabilities.setCapability(MobileCapabilityType.APP,"");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(10000);


        return driver;

    }


    @Parameters({"browser", "dataSheet", "dataBinder", "ENV"})
    @BeforeTest
//	@BeforeSuite
    public void launchBrowser(String browser, String dataSheetName, String dataBinder, String env, @Optional ITestContext iTestContext) throws Exception {
        dataSheet = dataSheetName;
        dataBinding = dataBinder;
        environmentURL = env;
        ENV = env;
        testCaseName = iTestContext.getName();
        currentBrowser = browser.toString().toUpperCase();
        try {
            if (browser.toUpperCase().toString().equals("firefox".toUpperCase().toString())) {
                driver = launchFirefoxBrowser();
            } else if (browser.toUpperCase().toString().equals("chrome".toUpperCase().toString())) {
                driver = launchChromeBrowser();
            } else if (browser.toUpperCase().toString().equals("htmlUnit".toUpperCase().toString())) {
                //driver = new HtmlUnitDriver(true);
                driver.manage().window().maximize();
            } else if (browser.toUpperCase().toString().equals("opera".toUpperCase().toString())) {
                driver = launchOperaBrowser();
            } else if (browser.toUpperCase().toString().equals("IE".toUpperCase().toString())) {
                driver = launchIEBrowser();
            } else if (browser.toUpperCase().toString().equals("Android".toUpperCase().toString())) {
                appiumDriver = launchAndroid();
            } else {
                logger.info("Opening Invalid driver");
            }
            try {

                po_BaseClass.po_SetDriver1(appiumDriver);

            } catch (Exception e) {

            }
        } catch (Exception e) {
            logger.info("Error occured while setting up WebDriver for: " + browser);
        }
    }
}
