package FrameWork.library;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.ReportHelper;
import FrameWork.listeners.Log;
import FrameWork.listeners.PreReq;
import FrameWork.listeners.po_BaseClass;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
//import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static FrameWork.helpers.DriverHelper.test;

public class Util {
	//temp driver
	public static WebDriver gDriver;
	public static Logger logger = Logger.getLogger("Inside helper Class " + Util.class.getName().toUpperCase());

	public static void closeDr(WebDriver webDriver) {
//		WebDriver webDriver = po_BaseClass.po_GetDriver();
		logger.info("Closing browser and driver");
		webDriver.close();
		webDriver.quit();
	}

	public static String replacePathSymbol(String str) {
		str = str.replace("\\", "-");
		String[] a = str.split("-");
		int length = a.length;
		String str1 = a[length - 1];
		return str1;
	}

  /*  public static void openUrl(String append) {
        logger.info("Opening URL: " + Const.URL + append);
       dr.get(Const.URL + append);
    }*/

	public static void openUrl(String URL) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		gDriver = webDriver;
		logger.info("Opening URL: " + URL);
		webDriver.get(URL);
		waitFor(3000);
		//waitForPageLoad();
	}

	public static void waitFor(long fWait) {
		//logger.info("Impplicity wait for " + fWait + " ms.");
		try {
			Thread.sleep(fWait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String fn_TakeSnapshot(String DestFilePath) {
		WebDriver driver ;
		if(DriverHelper.currentBrowser.equalsIgnoreCase("Android"))
		{
			AppiumDriver<MobileElement>appiumDriver=po_BaseClass.po_GetDriver1();

		String TS = fn_GetTimeStamp();
		TakesScreenshot tss = (TakesScreenshot) appiumDriver;
		File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
		DestFilePath = DestFilePath + TS + ".png";
		File DestFileObj = new File(DestFilePath);
		try {
			FileUtils.copyFile(srcfileObj, DestFileObj);
		} catch (IOException e) {
			test.log(LogStatus.INFO, "Unable to log screenshot");
		}
			return DestFilePath;
		}else {
		driver= po_BaseClass.po_GetDriver();
		String TS = fn_GetTimeStamp();
		TakesScreenshot tss = (TakesScreenshot) driver;
		File srcfileObj = tss.getScreenshotAs(OutputType.FILE);
		DestFilePath = DestFilePath + TS + ".png";
		File DestFileObj = new File(DestFilePath);
		try {
			FileUtils.copyFile(srcfileObj, DestFileObj);
		} catch (IOException e) {
			test.log(LogStatus.INFO, "Unable to log screenshot");
		}
		/// FileUtils.copyFile(srcfileObj, Des tFileObj);

		return DestFilePath;
	}}

	public static String fn_GetTimeStamp() {

		String DateValue = null;
		String dtFormat = "(dd-MM-yyyy)_(HH:mm:ss)";
		SimpleDateFormat sdf = new SimpleDateFormat(dtFormat);
		Date dte = new Date();
		try {
			DateValue = sdf.format(dte);
			DateFormat DF = DateFormat.getDateTimeInstance();
			DateValue = DateValue.replaceAll(" ", "_");
			DateValue = DateValue.replaceAll("-", "_");
			DateValue = DateValue.replaceAll(":", "_");
			DateValue = DateValue.replace(".", "_");
		} catch (Exception e) {
			return DateValue;
		}
		return DateValue;
	}

	public static WebElement fluentWait(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		long timeStart = System.currentTimeMillis();
		WebElement elem = (new WebDriverWait(webDriver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
		long timeEnd = System.currentTimeMillis();
		//logger.info("Element waited for: " + (timeEnd - timeStart) + " ms.");
		return elem;
	}

	public static WebElement fluentWait(WebElement webElement) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		long timeStart = System.currentTimeMillis();
		WebElement elem = (new WebDriverWait(webDriver, 10))
				.until(ExpectedConditions.visibilityOf(webElement));
		long timeEnd = System.currentTimeMillis();
		//logger.info("Element waited for: " + (timeEnd - timeStart) + " ms.");
		return elem;
	}

	public static String getText(By locator) {
		return fluentWait(locator).getText();
	}

	public static String getText(WebElement webElement) throws Exception {
		String s = "";
		//getLatestDriver();

		try {
			scrollDown(webElement);
		} catch (Exception e) {
			//Do nothing
		}

		s = webElement.getAttribute("innerText").toString();
		if (s.equalsIgnoreCase("")) {
			s = webElement.getAttribute("value").toString();
		}

		if (s.equalsIgnoreCase("")) {
			s = webElement.getText();
		}

		if (s.equalsIgnoreCase("")) {
			ReportHelper.logReportStatus(LogStatus.ERROR, "Unable to fetch the inner text for: "
					+ webElement.toString());
		}

		return s;
	}

	public static String getAttr(By locator, String attr, WebDriver webDriver) {
		return fluentWait(locator).getAttribute(attr);
	}

	public static boolean verifyText(By locator, String expectedText) {
		return getText(locator).equals(expectedText);
	}

	public static boolean verifyTitle(String expectedTitle) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		return webDriver.getTitle().equals(expectedTitle);
	}

	public static boolean elemExist(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		return (webDriver.findElements(locator).size() != 0);
	}

	public static boolean elemExist(WebElement webelement) {
		return (webelement.isEnabled() && webelement.isDisplayed());
	}

	public static boolean elemPresent(By locator) {
		return fluentWait(locator).isDisplayed();
	}

	public static void clear(By locator) {
		fluentWait(locator).clear();
	}

	public static void click(WebElement webElement) {
		getLatestDriver();
		String s = "";
		try {
			s = webElement.toString();
			if (s.contains("->"))
				s = s.split("->")[1];

			/*Click Event*/
			boolean flag = retryingFindClick(webElement);
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed Click @: '" + s + "'");
			waitForPageLoad();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform Click @: '" + s + "'");
			ReportHelper.logReportStatus(LogStatus.ERROR, e.getMessage());
		}
	}

	public static void click(String xPathString) {
		String s = "";
		try {
			//if (webElement.getText().equalsIgnoreCase(""))
			WebElement webElement = getLatestDriver().findElement(By.xpath(xPathString));
			s = webElement.toString();
			if (s.contains("->"))
				s = s.split("->")[1];
//			else
//				s = webElement.getText();

			/*Click Event*/
			boolean flag = retryingFindClick(webElement);
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed Click @: '" + s + "'");

			waitForPageLoad();
		} catch (Exception e) {
			//try {
			//	waitFor(5000);
			//	click(webElement);
			//} catch (Exception e1) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform Click @: '" + s + "'");
			ReportHelper.logReportStatus(LogStatus.ERROR, e.getMessage());
			//}
		}
	}

	public static void click(List<WebElement> listElement) throws Exception {
		getLatestDriver();
		WebElement webElement = null;
		String s = "";
		try {
			for (WebElement ele : listElement) { //To set the final element
				webElement = ele;
			}

			//if (webElement.getText().equalsIgnoreCase(""))
			s = webElement.toString();
			if (s.contains("->"))
				s = s.split("->")[1];
			//	else
			//	s = webElement.getText();

			/*Click Event*/
			boolean flag = retryingFindClick(webElement);
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed Click @: '" + s + "'");

			waitForPageLoad();
		} catch (Exception e) {
			//	try {
			//	waitFor(5000);
			//	click(listElement);
			//	} catch (Exception e1) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform Click @: '" + s + "'");
			ReportHelper.logReportStatus(LogStatus.ERROR, e.getMessage());
			//  }

		}
	}

	public static void clickTopIndex(String xpathString) throws Exception {
		getLatestDriver();
		String s = "";

		List<WebElement> list = po_BaseClass.po_GetDriver().findElements(By.xpath(xpathString));

		WebElement webElement = null;
		for (WebElement ele : list) { //To set the final element
			webElement = ele;
		}

		try {
			//if (webElement.getText().equalsIgnoreCase(""))
			s = webElement.toString();
			if (s.contains("->"))
				s = s.split("->")[1];
			//	else
			//	s = webElement.getText();

			/*Click Event*/
			boolean flag = retryingFindClick(webElement);
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed Click @: '" + s + "'");

			waitForPageLoad();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform Click @: '" + s + "'");
		}
	}

	public static void sendKey(WebElement webElement, Keys sendKey) throws Exception {
		getLatestDriver();
		String s = "";
		try {
			//if (webElement.getText().equalsIgnoreCase("")) {
			s = webElement.toString();
			if (s.contains("->"))
				s = s.split("->")[1];
			//} else {
			//	s = webElement.getText();
			//}

			/*Click Event*/
			webElement.sendKeys(sendKey);
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed ('" + sendKey.name().toString() + "') @: '" + s + "'");
			waitForPageLoad();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform ('" + sendKey.name().toString() + "') @: '" + s + "'");
		}
	}

	public static void doubleClickWithText(String xpathString) throws Exception {
		getLatestDriver();
		scrollDown(xpathString);
		Actions action = new Actions(getLatestDriver());
		String s = "";
		List<WebElement> list = getLatestDriver().findElements(By.xpath(xpathString));

		WebElement webElement = null;
//		WebElement webElement = getLatestDriver().findElement(By.xpath(xpathString));

		for (WebElement ele : list) { //To set the final element
			webElement = ele;
		}

		if (webElement != null) {
			try {
				s = webElement.toString();
				if (s.contains("->"))
					s = s.split("->")[1];

			/*Click Event*/
				action.doubleClick(fluentWait(webElement)).perform();
				ReportHelper.logReportStatus(LogStatus.INFO, "Performed double click @: '" + s + "'");
				waitForPageLoad();
			} catch (Exception e) {
				ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform double click @: '" + s + "'");
			}
		} else {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to find webElement using: '" + xpathString + "'");
		}

		//waitTillElementIsNotVisible(po_eCorp_fo.Div_LoadingPleaseWait);

	}

	public static void clickText(String xpathText) throws Exception {
		getLatestDriver();
		String s = "";
		List<WebElement> list = po_BaseClass.po_GetDriver().findElements(By.xpath(xpathText));

		WebElement webElement = null;
		for (WebElement ele : list) { //To get the final element
			webElement = ele;
		}

		try {
			/*Click Event*/
			ReportHelper.logReportStatus(LogStatus.INFO, "Performed Click @: '" + s + "'");
			//	boolean flag = retryingFindTextClick(xpathText);
			webElement.click();
			waitForPageLoad();
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Not able to Perform Click @: '" + s + "'");
		}
	}

	public static boolean retryingFindClick(WebElement webElement) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 10) {
			try {
				waitFor(1000);
				webElement.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static boolean retryingFindTextClick(String xpathText) {
		boolean result = false;
		int attempts = 0;
		while (attempts < 3) {
			try {
				po_BaseClass.po_GetDriver().findElement(By.xpath(xpathText)).click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public static void getWebElementVisible(WebElement webElement, WebDriver webDriver) {
	    /*new WebDriverWait(webDriver, 4)
	            .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    webElement.click();
                    return true;
                });*/
		final WebDriverWait wait = new WebDriverWait(webDriver, 5);
		wait.until(ExpectedConditions.refreshed(
				ExpectedConditions.elementToBeClickable(webElement)));
		webElement.click();
	}

	public static void clear(WebElement webElement, WebDriver webDriver) {
		// fluentWait(webElement,webDriver).clear();
	   /* boolean flag=retryingFindClick(webElement);
	    System.out.println("flag of click : "+flag);*/
		handleStaleElement(webElement);
		actionsElementClear(webElement, webDriver);
	}

	public static void click(By locator, WebDriver webDriver) {
		fluentWait(locator).click();
	}

	public static void dbClick(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Actions(webDriver)).doubleClick(fluentWait(locator)).perform();
	}

	public static void dbClick(WebElement element) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Actions(webDriver)).doubleClick(fluentWait(element)).perform();
		waitForPageLoad();
	}

	public static void rClick(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Actions(webDriver)).contextClick(fluentWait(locator)).perform();
	}

	public static void hover(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Actions(webDriver)).moveToElement(fluentWait(locator)).perform();
	}

	public static void hover(WebElement webElement) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
//		(new Actions(webDriver)).moveToElement(webElement).perform();
		(new Actions(webDriver)).moveToElement(fluentWait(webElement)).perform();
	}

	public static void sendKeys(By locator, String text) {
		fluentWait(locator).sendKeys(text);
	}

	public static void sendKeys(WebElement webElement, String text)  {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		fluentWait(webElement);
		//clear(webElement, webDriver);
		actionsElement(webElement, webDriver, text);
		//jsExecElement(webElement,webDriver,text);
		//webDriver.switchTo().activeElement().sendKeys(text);
		// webElement.sendKeys(text);
		ReportHelper.logReportStatus(LogStatus.INFO, "Performed Set Text @: '" + webElement.getAttribute("ID") + "' - with: '" + text + "'");
	}

	public static void drag(By elemLocator, By destLocator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Actions(webDriver))
				.dragAndDrop(fluentWait(elemLocator), fluentWait(destLocator))
				.perform();
	}

	public static void dslcAll(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).deselectAll();
	}

	public static void dslcByIndex(By locator, int index) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).deselectByIndex(index);
	}

	public static void dslcByValue(By locator, String value) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).deselectByValue(value);
	}

	public static void dslctByText(By locator, String text) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).deselectByVisibleText(text);
	}

	public static void slcMultiple(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		System.out.println((new Select(fluentWait(locator))).isMultiple());
	}

	public static void slcByValue(By locator, String value) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).selectByValue(value);
	}

	public static void slcByIndex(By locator, int index) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).selectByIndex(index);
	}

	public static void slcByText(By locator, String text) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		(new Select(fluentWait(locator))).selectByVisibleText(text);
	}

	public static String slcGetAllSelected(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		Select selectBox = new Select(fluentWait(locator));
		List<WebElement> selectOptions = selectBox.getAllSelectedOptions();
		String allSelectedText = "";
		for (WebElement temp : selectOptions) {
			allSelectedText = allSelectedText + " " + temp.getText();
			System.out.println("allSelectedText: " + allSelectedText);
		}
		return allSelectedText;
	}

	public static void slcGetAllOptions(By locator) {
		Select selectBox = new Select(fluentWait(locator));
		List<WebElement> selectOptions = selectBox.getOptions();
		for (WebElement temp : selectOptions) {
			System.out.println("getText" + temp.getText());
		}
	}

	public static void scrollTo(By locator) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		((JavascriptExecutor) webDriver)
				.executeScript("arguments[0].scrollIntoView(true);", fluentWait(locator));
	}

	public static void scrollTo(WebElement web) {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		((JavascriptExecutor) webDriver)
				.executeScript("arguments[0].scrollIntoView(true);", web);
	}

	public static void scrollBottom() {
		WebDriver webDriver = po_BaseClass.po_GetDriver();
		((JavascriptExecutor) webDriver)
				.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
	}

	public static void scrollDownScreenShot(WebElement web, String description) {
		try {
			WebDriver driver = getLatestDriver();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", web);
			ReportHelper.forceScreenShot = true;
			ReportHelper.logReportStatus(LogStatus.INFO, description);
		} catch (Exception E) {

		}

	}

	public static void scrollDown(WebElement web) {
		try {
			WebDriver driver = getLatestDriver();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", web);
		} catch (Exception E) {
			Log.info("Issue in scrollDown for - " + web.toString());
		}
	}

	public static void scrollDown(String xPath) {
		try {
			WebDriver driver = getLatestDriver();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xPath)));
		} catch (Exception E) {

		}
	}

	public static void upload(By inputLocator, String path) {

		LocalFileDetector detector = new LocalFileDetector();
		File f = detector.getLocalFile(path);
		WebElement elem = fluentWait(inputLocator);
		((RemoteWebElement) elem).setFileDetector(detector);
		elem.sendKeys(f.getAbsolutePath());
		logger.info("Uploading file: " + f.getAbsolutePath());
	}

	public static void login() {
		// logger.info("Logging in with [" + Const.USERNAME + " / **********]");
	   /* sendKeys(Const.usernameLocator, Const.USERNAME);
	    sendKeys(Const.passwordLocator, Const.PASSWORD);
        click(Const.loginBtneLocator);*/
	}

	/*
		testing email confirmation: http://putsbox.com/ is a website that can generate instant email
		works only if the email is a html email and needs to confirm by clicking a link in the email
	*/
	public static String mailConfirmAddr(WebDriver webDriver) {
		WebDriver newDr = new FirefoxDriver();
		WebDriver orig = webDriver;
		newDr.get("http://putsbox.com/");
		click(By.cssSelector(".btn.btn-primary.btn-large"), webDriver);
		String addr = getAttr(By.id("putsbox-token-input"), "value", webDriver);
		closeDr(webDriver);
		logger.info("Got testing email address: " + addr);
		return addr;
	}

	public static void mailConfirmRefresh(String addr, By linkLocator, WebDriver webDriver) {
		String s = addr.split("@")[0];
		webDriver.get("http://putsbox.com/" + s + "/inspect");
		waitFor(3000);
		webDriver.get(getAttr(By.linkText("HTML"), "href", webDriver));
		webDriver.get(getAttr(linkLocator, "href", webDriver));
	}

	public static void setSlider(By handleLocator, By trackLocator, int percentage, WebDriver webDriver) {
		int width = Integer.parseInt(fluentWait(trackLocator).getCssValue("width").replace("px", ""));
		int dx = (int) (percentage / 100.0 * width);
		(new Actions(webDriver)).dragAndDropBy(fluentWait(handleLocator), -999, 0).perform();
		(new Actions(webDriver)).dragAndDropBy(fluentWait(handleLocator), dx, 0).perform();
	}

	public static ArrayList<HashMap<String, String>> getResultSetDataAsMap(Recordset recordset, String fieldName) throws FilloException {
		HashMap<String, String> hmData = new HashMap<>();
		ArrayList<HashMap<String, String>> alHashMapData = new ArrayList<HashMap<String, String>>();
		while (recordset.next()) {
			ArrayList<String> dataColl = recordset.getFieldNames();
			for (String str : dataColl) {
				hmData.put(str, recordset.getField(str));
			}
			alHashMapData.add(hmData);
		}
		return alHashMapData;
	}

	public static void actionsElement(WebElement webElement, WebDriver webDriver, String text) {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(webElement).click().sendKeys(text).build().perform();
	}

	public static void handleStaleElement(WebElement webElement) {
		int count = 0;
		//It will try 4 times to find same element using name.
		while (count < 4) {
			try {
				//If exception generated that means It Is not able to find element then catch block will handle It.
				//WebElement staledElement = driver.findElement(By.name(elementName));
				//If exception not generated that means element found and element text get cleared.
				webElement.click();
			} catch (StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count + 1;
			}
			count = count + 4;
		}
	}

	public static void handleStaleElementClear(WebElement webElement) {
		int count = 0;
		//It will try 4 times to find same element using name.
		while (count < 4) {
			try {
				//If exception generated that means It Is not able to find element then catch block will handle It.
				//WebElement staledElement = driver.findElement(By.name(elementName));
				//If exception not generated that means element found and element text get cleared.
				webElement.clear();
			} catch (StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count + 1;
			}
			count = count + 4;
		}
	}

	public static void handleStaleElementSend(WebElement webElement, String text) {
		int count = 0;
		//It will try 4 times to find same element using name.
		while (count < 4) {
			try {
				//If exception generated that means It Is not able to find element then catch block will handle It.
				//WebElement staledElement = driver.findElement(By.name(elementName));
				//If exception not generated that means element found and element text get cleared.
				webElement.sendKeys(text);
			} catch (StaleElementReferenceException e) {
				e.toString();
				System.out.println("Trying to recover from a stale element :" + e.getMessage());
				count = count + 1;
			}
			count = count + 4;
		}
	}

	public static void handleStaleElementClearAndSend(WebElement webElement, String text) {
		handleStaleElementClear(webElement);
		handleStaleElementSend(webElement, text);
	}

	public static void actionsElement(WebElement webElement, WebDriver webDriver) {
		//boolean flag=retryingFindClick(webElement);
		// System.out.println("flag of click : "+flag);
		handleStaleElement(webElement);
		waitFor(3000);
	 /*   Actions builder = new Actions(webDriver);
	    builder.moveToElement(webElement).click().build().perform();*/
	}

	public static void actionsElementClear(WebElement webElement, WebDriver webDriver) {
		Actions builder = new Actions(webDriver);
		builder.moveToElement(webElement).click().build().perform();
		webElement.clear();
	}

	public static void jsExecElement(WebElement webElement, WebDriver webDriver, String text) {
		JavascriptExecutor rightexecutor = (JavascriptExecutor) webDriver;
		rightexecutor.executeScript("arguments[0].setAttribute('value','" + text + "')", webElement);
	}

	public static void switchDFrame(String frameName) {
		WebDriver driver;
		waitForPageLoad();
		driver = getLatestDriver();
		driver.switchTo().defaultContent();
		driver = driver.switchTo().frame(frameName);
		po_BaseClass.po_SetDriver(driver);
	}

	public static void switchDFrame(int FrameNum) {
		WebDriver driver;
		waitForPageLoad();
		driver = getLatestDriver();
		driver.switchTo().defaultContent();
		driver = driver.switchTo().frame(FrameNum);
		po_BaseClass.po_SetDriver(driver);
	}

	public static void switchDFrame(WebElement eleFrame) {
		WebDriver driver;
		waitForPageLoad();
		driver = getLatestDriver();
		driver.switchTo().defaultContent();
		driver = driver.switchTo().frame(eleFrame);
//		driver = driver.switchTo().frame(By.xpath());
		po_BaseClass.po_SetDriver(driver);
	}

	public static void switchDFrame(List<WebElement> eleFrame) {
		WebDriver driver;
		waitForPageLoad();
		driver = getLatestDriver();
		driver.switchTo().defaultContent();

		List<WebElement> list = eleFrame;

		WebElement webElement = null;
		for (WebElement ele : list) { //To get the final element
			webElement = ele;
		}
		driver = driver.switchTo().frame(webElement);
		//System.out.println(driver.getPageSource());
//		driver = driver.switchTo().frame(By.xpath());
		po_BaseClass.po_SetDriver(driver);
	}

	public static AppiumDriver<MobileElement> getAppiumDriver() {
		AppiumDriver<MobileElement> appiumDriver = po_BaseClass.po_GetDriver1();
		return appiumDriver;
	}


	public static WebDriver getLatestDriver() {
		WebDriver driver = po_BaseClass.po_GetDriver();
		String CurWindow = null;

	/*	if (DriverHelper.currentBrowser.equalsIgnoreCase("IE")) {
			Set<String> newwindows = driver.getWindowHandles();
			CurWindow = (String) newwindows.toArray()[newwindows.size()];
			driver.switchTo().window(CurWindow);
		} else {*/
			Set<String> newwindows = driver.getWindowHandles();
			/*try {
				CurWindow = (String) newwindows.toArray()[newwindows.size()];
			} catch (Exception e) {

			*/
		/*	if(newwindows.size()!=0) {
				CurWindow = (String) newwindows.toArray()[newwindows.size() - 1];
				driver.switchTo().window(CurWindow);
			}*/
			/*}*/



		po_BaseClass.po_SetDriver(driver);
	//	System.out.println(driver.getPageSource());

		// Switch to new window opened
		return driver;
	}




	public static WebDriver getLatestDriver(int i) {
		WebDriver driver = po_BaseClass.po_GetDriver();

		if (DriverHelper.currentBrowser.equalsIgnoreCase("IE")) {
			Set<String> newwindows = driver.getWindowHandles();
			String CurWindow = (String) newwindows.toArray()[newwindows.size()];
			driver.switchTo().window(CurWindow);
		} else {
			Set<String> newwindows = driver.getWindowHandles();
			String CurWindow = (String) newwindows.toArray()[newwindows.size() - 1];
			driver.switchTo().window(CurWindow);
		}
		po_BaseClass.po_SetDriver(driver);

		// Switch to new window opened
		return driver;
	}

	public static boolean waitVisible(WebElement elem) throws Exception {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PreReq.fwConfig.getProperty("timeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
			ReportHelper.logReportStatus(LogStatus.INFO, "Element is visible :" + elem.getAttribute("ID"));
			return true;
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.ERROR, "Element not visible :" + elem.getAttribute("ID"));
			return false;
		}
	}

	public static boolean waitVisibleShort(WebElement elem) {
		try {
			WebDriver driver = po_BaseClass.po_GetDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(PreReq.fwConfig.getProperty("shortTimeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
			ReportHelper.logReportStatus(LogStatus.INFO, "Element is visible :" + elem.getAttribute("ID"));
			return true;
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.INFO, "Element not visible :" + elem);
			return false;
		}
	}

	public static void waitForPageLoad() {

		if (PreReq.fwConfig.getProperty("pageLoadSleepRequired").equalsIgnoreCase("YES")) {
			waitFor(2000);
		}
		WebDriver driver;// = po_BaseClass.po_GetDriver();
		driver = getLatestDriver();
		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		try {
			if (DriverHelper.currentBrowser.equalsIgnoreCase("IE")) {
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			} else {
				wait.until(expect);
			}

		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.INFO, "Page Load Condition failed. Continuing with test");
		}

		//if () { //Need to add Application specific if loop for correct wait
		//waitTillElementIsNotVisible("//div[contains(.,'Loading... Please wait.')]");
		//}
		getLatestDriver();
	}

	public static void waitTillElementIsNotVisible(String xPathString) {
		try {
			WebDriverWait wait1 = new WebDriverWait(getLatestDriver(), Integer.parseInt(PreReq.fwConfig.getProperty("timeout")));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathString)));
		} catch (Exception e) {
		}

		List<WebElement> wele = getLatestDriver().findElements(By.xpath(xPathString));

		for (WebElement ele : wele) { //To set the final element
			//webElement = ele;
		}
	}

	public static void waitTillElementIsNotVisible(WebElement element) {
		int waitTime = Integer.parseInt(PreReq.fwConfig.getProperty("timeout"));
		waitTime = 30000;
		try {
			WebDriverWait waitNew = new WebDriverWait(getLatestDriver(), waitTime);

			waitNew.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.invisibilityOf(element));
//					.until(ExpectedConditions.invisibilityOfElementLocated(ele));

		} catch (Exception e) {

		} finally {
			getLatestDriver().manage().timeouts()
					.implicitlyWait(waitTime, TimeUnit.SECONDS);
		}

	}

	public static void waitTillElementIsVisible(WebElement element) {
		int waitTime = Integer.parseInt(PreReq.fwConfig.getProperty("timeout"));
		waitTime = 30000;
		try {
			WebDriverWait waitNew = new WebDriverWait(getLatestDriver(), waitTime);

			waitNew.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOf(element));
//					.until(ExpectedConditions.invisibilityOfElementLocated(ele));

		} catch (Exception e) {

		} finally {
			getLatestDriver().manage().timeouts()
					.implicitlyWait(waitTime, TimeUnit.SECONDS);
		}

	}

	public static void waitTillElementIsVisible(String element) {
		int waitTime = Integer.parseInt(PreReq.fwConfig.getProperty("timeout"));
		waitTime = 30000;
		try {
			WebDriverWait waitNew = new WebDriverWait(getLatestDriver(), waitTime);

			waitNew.ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class)
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
//					.until(ExpectedConditions.invisibilityOfElementLocated(ele));

		} catch (Exception e) {

		} finally {
			getLatestDriver().manage().timeouts()
					.implicitlyWait(waitTime, TimeUnit.SECONDS);
		}

	}

	public static String getTableText(int getCol, String xPathString) {
		WebDriver webDriver = getLatestDriver();
		WebElement webEle = webDriver.findElement(By.xpath("//table/tbody/tr[contains(.,'" + xPathString + "')]" + "/td[" + getCol + "]"));

		String s = webEle.getText();

		if (s.equalsIgnoreCase("")) {
			s = webEle.getAttribute("innerText");
		}

		if (s.equalsIgnoreCase("")) {
			s = webEle.getAttribute("value");
		}
		return s;
	}




	/**
	 * This method will can be used in case FuncSwipeAndScroll is throwing any
	 * exception.
	 *
	 * @param elementToFind
	 * @param clickYorN
	 * @throws Exception
	 */
	public  void FunCnewSwipe(MobileElement elementToFind, boolean clickYorN, int swipes) throws Exception {

		AppiumDriver<MobileElement>appiumDriver=getAppiumDriver();
		Dimension size = appiumDriver.manage().window().getSize();
		int startx = size.width;
		int starty = size.height;
		boolean flag = true;
		int count = 0;
		try {
			while (flag && count < swipes) try {
				if (elementToFind.isDisplayed()) {

					flag = false;
				} else {


				}
			} catch (Exception e) {


				//appiumDriver.swipe(startx / 2, starty - (starty / 4), startx / 2, starty / 4, 600);
				count++;
			}

		} catch (IllegalArgumentException e) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "IllegalArgumentException Exception occurred");
			throw e;
		} catch (NoSuchElementException n) {
			ReportHelper.logReportStatus(LogStatus.FAIL, "Element not displayed");
			throw n;
		} catch (Exception e) {
			ReportHelper.logReportStatus(LogStatus.FAIL,
					"Exception <b>- " + e.toString() + "</b> occured while trying launch the application.");
			throw e;
		}
		if (clickYorN) {
			elementToFind.click();
		}

	}


	public static String waitAndGetTableText(WebElement eleRefresh, String valueToWait, int waitCol, String xPathString) throws Exception {
		String s = "";
		int i = 0;
		do {
			i++;
			click(eleRefresh);
			s = getTableText(waitCol, xPathString);
			waitFor(1000);
			if (i == 10) {
				return "NA";
			}
		} while (!(s.equalsIgnoreCase(valueToWait)));
		return s;
	}

	public static String waitAndGetTableText(List<WebElement> eleRefresh, String valueToWait, int waitCol, String xPathString) throws Exception {
		String s = "";
		int i = 0;
		int wait = Integer.parseInt(PreReq.fwConfig.getProperty("waitForTableDataLimit"));
		do {
			i++;
			click(eleRefresh);
			s = getTableText(waitCol, xPathString);
			waitFor(1000);
//			if (i == 30) {
			if (i == wait) {
				return s;
			}
		} while (!(s.equalsIgnoreCase(valueToWait)));
		return s;
	}

	public static String waitAndGetTableText(String valueToWait, int waitCol, String xPathString) throws Exception {
		String s = "";
		int i = 0;
		do {
			i++;
			s = getTableText(waitCol, xPathString);
			waitFor(1000);
			if (i == 30) {
				return "NA";
			}
		} while (!(s.contains(valueToWait)));
		return s;
	}


	public static void clickWithTableText(int clickCol, String xPathString) throws Exception {
		waitForPageLoad();

		click(getLatestDriver().findElement(By.xpath("//table/tbody/tr[contains(.,'" + xPathString + "')]" + "/td[" + clickCol + "]")));
	}

	public static boolean waitVisibleNoErr(By by, int sec) {
		try {
			WebDriver driver = getLatestDriver();
			WebDriverWait wait = new WebDriverWait(driver, sec);

			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			// ExReporter.log(LogStatus.ERROR, "Element not visible");
			return false;
		}
	}

	public static void ajax(WebDriver driver,int timeouts)
	{

		WebDriverWait wait = new WebDriverWait(driver,timeouts);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//img[@src='desktopweb/images/loading.gif']")));
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}



}
