/*
package mav.gib.library.functions;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import mav.gib.driver.DriverFactory;
import mav.gib.framework.ConfigProvider;
import mav.gib.framework.ExReporter;
import mav.gib.framework.ProjectConfig;
import mav.gib.utilities.enums.Locators;

public class CommonDef {

	// static WebDriver driver = DriverFactory.getCurrentDriver();

	public static String captureScreen() {
		String path;
		File trgtPath = null;
		try {
			WebDriver driverLoc = DriverFactory.getCurrentDriver();
			WebDriver augmentedDriver = new Augmenter().augment(driverLoc);
			File source = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			path = ExReporter.reportPath + "/" + source.getName();
			// System.out.println(path);
			trgtPath = new File(path);

			FileUtils.copyFile(source, trgtPath);
			return source.getName();// trgtPath.getAbsolutePath();
		} catch (Exception e) {
			return "";
		}
		// return trgtPath.getAbsolutePath();

	}

	public static void waitForPageLoad() {
		WebDriver driver = DriverFactory.getCurrentDriver();
		ExpectedCondition<Boolean> expect = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver,120);
		try {
			wait.until(expect);
		} catch (Exception E) {
			ExReporter.log(LogStatus.INFO, "Page Load Condition failed. Continuing with test");
		}
	}

	public static By locatorValue(Locators locatorTpye, String value) {
		By by = null;
		switch (locatorTpye) {
		case ID:
			by = By.id(value);
			break;
		case NAME:
			by = By.name(value);
			break;
		case XPATH:
			by = By.xpath(value);
			break;
		case CSS:
			by = By.cssSelector(value);
			break;
		case LINKTEXT:
			by = By.linkText(value);
			break;
		case PARTIAL_LINKTEXT:
			by = By.partialLinkText(value);
			break;
		case TAG_NAME:
			by = By.tagName(value);
			break;
		case CLASS_NAME:
			by = By.className(value);
			break;
		case NA:
			break;
		}
		return by;
	}

	public static WebElement findElement(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			return driver.findElement(by);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Element not located in the page :" + E.getMessage());
			return null;
		}
	}

	public static List<WebElement> findElements(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			return driver.findElements(by);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page");
			return null;
		}
	}
	

	// Used to find multiple elements in Payments module

	public static ArrayList<String> findElementsText(By by) {
		try {
			ArrayList<String> mylist = new ArrayList<String>();
			List<WebElement> elems = findElements(by);
			for (WebElement elem : elems) {
				mylist.add(elem.getText());
			}
			return mylist;
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page");
			return null;
		}
	}

	public static void click(By by) {
		try {
			WebElement elem = findElement(by);
			elem.click();
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page");
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page");
		}
	}

	public static void clickThrowError(By by, String elemname) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		WebElement elem = driver.findElement(by);// findElement(by);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", elem);
		ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
	}

	public static void clickJS(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement elem = findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page");
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Elements not located in the page");
		}
	}

	public static void clickJS(By by, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement elem = findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page: " + elemname);
		}
	}

	public static void clickJS(WebElement elem, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page: " + elemname);
		}
	}

	public static void clickJSNoError(By by, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement elem = driver.findElement(by);// findElement(by);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
		} catch (Exception E) {
		}
	}

	public static void click(By by, String elemname) {
		try {
			WebElement elem = findElement(by);
			elem.click();
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Elements not located in the page");
		}
	}

	public static void clickNoError(By by, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Thread.sleep(10000);
			driver.findElement(by).click();
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page: " + elemname);
		} catch (Exception E) {
		}
	}

	public static void click(WebElement elem) {
		try {
			elem.click();
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page");
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Elements not located in the page");
		}
	}

	public static void click(WebElement elem, String elementname) {
		try {
			elem.click();
			ExReporter.log(LogStatus.INFO, "Element successfully clicked in the page :" + elementname);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Elements not located in the page: " + elementname);
		}
	}

	public static Boolean ObjectExist(By LocatorValue) {
		Boolean ObjectExist = null;
		WebDriver driver = DriverFactory.getCurrentDriver();		
	//	waitVisibleNoError(LocatorValue, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
		try {
			Thread.sleep(1500);
			if (driver.findElement(LocatorValue).isDisplayed()) {
				ObjectExist = true;
			} else
				ObjectExist = false;
		} catch (Exception E) {
			ObjectExist = false;
		}
		return ObjectExist;
	}

	public static void sendKeys(By by, String keysToSend) {
		try {
			WebElement t = findElement(by);
			t.sendKeys(keysToSend);
			Thread.sleep(1500);
			ExReporter.log(LogStatus.INFO, "Text is entered successfully :" + keysToSend);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Text not entered successfully");
		}
	}

	public static void sendKeys(WebElement elem, String keysToSend) {
		try {
			elem.sendKeys(keysToSend);
			ExReporter.log(LogStatus.INFO, "Text is entered successfully :" + keysToSend);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Text not entered successfully");
		}
	}

	public static void waitClick(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not clickable");
		}
	}

	public static void waitVisible(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitVisible(By by, int sec) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitVisible(By by, String name) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			ExReporter.log(LogStatus.INFO, "Element is visible :" + name);
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not visible :" + name);
		}
	}

	public static void waitInVisible(By by, String name) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			ExReporter.log(LogStatus.PASS, "Element not visible :" + name);
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element is visible :" + name);
		}
	}
	
	public static void waitClickable(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not clickable");
		}
	}

	public static void waitClickable(By by, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			ExReporter.log(LogStatus.WARNING, "Element not clickable: " + elemname);
		}
	}

	public static boolean waitVisibleNoError(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			// WebDriverWait wait = new WebDriverWait(driver,
			// Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			// ExReporter.log(LogStatus.ERROR, "Element not visible");
			return false;
		}
	}

	public static void waitVisibleNoError(By by, int sec) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, sec);
			// WebDriverWait wait = new WebDriverWait(driver,
			// Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			// ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitForAttribute(By by, String attr, String value) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			// WebDriverWait wait = new WebDriverWait(driver,
			// Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.attributeContains(by, attr, value));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element has not switched to the correct attribute to continue");
		}
	}

	public static void waitClickableNoError(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitClickableNoError(By by, int time) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitVisible(WebElement elem) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not visible");
		}
	}

	public static void waitVisible(WebElement elem, String name) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not visible :" + name);
		}
	}

	public static void clearText(By by) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		driver.findElement(by).clear();
	}

	public static void clearText(WebElement elem) {
		elem.clear();
	}

	public static void waitClickable(WebElement elem) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not clickable");
		}
	}

	public static void waitClickable(WebElement elem, String elemname) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(ProjectConfig.getPropertyValue("timeout")));
			wait.until(ExpectedConditions.visibilityOf(elem));
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Element not clickable: " + elemname);
		}
	}

	public static void moveClick(By by, String elemname) {
		if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Actions action = new Actions(driver);
			action.moveToElement(findElement(by)).click().build().perform();
		} else {
			click(by);
		}
	}
	
	public static void moveClick(WebElement elem, String elemname) {
		if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Actions action = new Actions(driver);
			action.moveToElement(elem).click().build().perform();
		} else {
			click(elem);
		}
	}

	public static void moveToElement(By by, String elemname) {
		if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Actions action = new Actions(driver);
			action.moveToElement(findElement(by)).perform();
		}
	}
	
	public static void moveToElement(WebElement elem, String elemname) {
		if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Actions action = new Actions(driver);
			action.moveToElement(elem).perform();
		}
	}

	public static void moveToElementNoLog(WebElement elem) {
		try {
			if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
				WebDriver driver = DriverFactory.getCurrentDriver();
				Actions action = new Actions(driver);
				action.moveToElement(elem).perform();
			}
		} catch (Exception E) {

		}
	}

	public static void moveToElementClickNoFail(By by, String elemname) {
		if (!ConfigProvider.getConfig("Browser").equalsIgnoreCase("SAFARI")) {
			WebDriver driver = DriverFactory.getCurrentDriver();
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(by)).click().build().perform();
		} else {
			clickNoError(by, elemname);
		}
	}

	public static String getText(By by) {
		try {
			return findElement(by).getText();
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "UNABLE TO GET TEXT FROM ELEMENT");
		}
		return null;
	}
	
	public static String getTextNoError(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			return driver.findElement(by).getText();
		} catch (Exception E) {
			//ExReporter.log(LogStatus.FAIL, "UNABLE TO GET TEXT FROM ELEMENT");
		}
		return null;
	}

	public static String getText(By by, String elem) {
		try {
			return findElement(by).getText();
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "UNABLE TO GET TEXT FROM ELEMENT: " + elem);
		}
		return null;
	}

	public static void assertContainsData(By by) {
		waitVisible(by);
		try {
			WebElement elem = findElement(by);
			if (!elem.getText().isEmpty())
				ExReporter.log(LogStatus.PASS, "Data is populated in the Element");
			else
				ExReporter.log(LogStatus.FAIL, "Data is not populated in the Element");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in accessing data");
		}
	}
	
	public static void assertContainsData(By by, String string) {
		try {
			WebElement elem = findElement(by);
			if (elem.getText().isEmpty())
				ExReporter.log(LogStatus.FAIL, "Element " + elem + "has no data");
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error accessing element data");
		}
	}
	
	public static boolean assertContainsNoError(WebElement elem, String text) {
		try {
			if (elem.getText().contains(text)) {
				ExReporter.log(LogStatus.PASS, "Text is populated in the Element: " + text);
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void assertEquals(By by, String text) {
		waitVisible(by);
		try {
			WebElement elem = findElement(by);
			if (elem.getText().equals(text))
				ExReporter.log(LogStatus.PASS, "Text is populated in the Element: " + text);
			else
				ExReporter.log(LogStatus.FAIL, "Text is not populated in the Element: " + text);
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error in accessing Text");
		}
	}

	public static boolean assertContains(By by, String text) {
		try {
			WebElement elem = findElement(by);
			try {
				moveToElementNoLog(elem);
			} catch (Exception e) {

			}
			if (elem.getText().contains(text)) {
				ExReporter.log(LogStatus.PASS,
						"Text is populated in the Element: " + text + " ||actual|| " + elem.getText());
				return true;
			} else {
				ExReporter.log(LogStatus.FAIL,
						"Text is not populated in the Element: " + text + " ||actual|| " + elem.getText());
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}
	
	public static boolean assertContainsOnAttribute(By by, String text, String Attribute) {
		try {			
			WebElement elem = findElement(by);
			String attrbdata=elem.getAttribute(Attribute);
			try {
				moveToElementNoLog(elem);
			} catch (Exception e) {

			}
			if (attrbdata.contains(text)) {
				ExReporter.log(LogStatus.PASS,"Text is populated in the Attribute");
				return true;
			} else {
				ExReporter.log(LogStatus.FAIL,"Text is not populated in the Attribute");
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertElemsContains(By by, String text) {
		try {
			List<WebElement> elems = findElements(by);
			for (WebElement elem : elems) {
				try {
					moveToElementNoLog(elem);
				} catch (Exception e) {

				}
				if (elem.getText().contains(text)) {
					ExReporter.log(LogStatus.PASS,
							"Text is populated in the Element: " + text + " ||actual|| " + elem.getText());
					return true;
				}
			}
			ExReporter.log(LogStatus.FAIL, "Text is not populated in the Elements: " + text);
			return false;
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertElemsContainsWarn(By by, String text) {
		try {
			List<WebElement> elems = findElements(by);
			for (WebElement elem : elems) {
				try {
					moveToElementNoLog(elem);
				} catch (Exception e) {

				}
				if (elem.getText().contains(text)) {
					ExReporter.log(LogStatus.PASS,
							"Text is populated in the Element: " + text + " ||actual|| " + elem.getText());
					return true;
				}
			}
			ExReporter.log(LogStatus.WARNING, "Text is not populated in the Elements: " + text);
			return false;
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertInnerHTMLContains(By by, String text) {
		try {
			WebElement elem = findElement(by);
			if (elem.getAttribute("innerHTML").contains(text)) {
				ExReporter.log(LogStatus.PASS,
						"Text is populated in the Element: " + text + " ||actual|| " + elem.getAttribute("innerHTML"));
				return true;
			} else {
				ExReporter.log(LogStatus.FAIL, "Text is not populated in the Element: " + text + " ||actual|| "
						+ elem.getAttribute("innerHTML"));
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertInnerHTMLContainsNoError(By by, String text) {
		try {
			WebElement elem = findElement(by);
			if (elem.getAttribute("innerHTML").contains(text)) {
				ExReporter.log(LogStatus.PASS,
						"Text is populated in the Element: " + text + " ||actual|| " + elem.getAttribute("innerHTML"));
				return true;
			} else {
				ExReporter.log(LogStatus.INFO, "Text is not populated in the Element: " + text + " ||actual|| "
						+ elem.getAttribute("innerHTML"));
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.INFO, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertInnerHTMLContainsNoError(WebElement elem, String text) {
		try {
			if (elem.getAttribute("innerHTML").contains(text)) {
				ExReporter.log(LogStatus.PASS,
						"Text is populated in the Element: " + text + " ||actual|| " + elem.getAttribute("innerHTML"));
				return true;
			} else {
				ExReporter.log(LogStatus.INFO, "Text is not populated in the Element: " + text + " ||actual|| "
						+ elem.getAttribute("innerHTML"));
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.INFO, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static boolean assertContains(WebElement elem, String text) {
		try {
			if (elem.getText().contains(text)) {
				ExReporter.log(LogStatus.PASS, "Text is populated in the Element: " + text);
				return true;
			} else {
				ExReporter.log(LogStatus.FAIL, "Text is not populated in the Element: " + text);
				return false;
			}
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
		return false;
	}

	public static void assertContains(By by, String text, String passmsg) {
		try {
			WebElement elem = findElement(by);
			if (elem.getText().contains(text))
				ExReporter.log(LogStatus.PASS, passmsg + " - Text is populated in the Element: " + text);
			else
				ExReporter.log(LogStatus.FAIL, passmsg + " - Text is not populated in the Element: " + text);
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error in accessing Text : " + e.getMessage());
		}
	}


	public static void scrollDown() {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("window.scrollTo(0,
			// document.body.scrollHeight)");
			jse.executeScript("scroll(0, 1500);");
		} catch (Exception E) {

		}
	}
	public static void scrollDown(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			// jse.executeScript("window.scrollTo(0,
			// document.body.scrollHeight)");
			//jse.executeScript("scroll(0, 1500);");
			jse.executeScript("arguments[0].scrollIntoView(true);",by);
		} catch (Exception E) {

		}
	}

	public static void findElementsClick(By by) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			List<WebElement> elm = driver.findElements(by);
			for (WebElement s : elm) {
				clickJS(s);
			}
		} catch (Exception E) {
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page");
		}
	}
	
	public static int findElementsCount(By by){
		int itmcnt=0;
		try{
			WebDriver driver = DriverFactory.getCurrentDriver();
			List<WebElement> elm = driver.findElements(by);			
			for (WebElement s : elm) {
				itmcnt=itmcnt+1;
			}
		}catch(Exception E){
			ExReporter.log(LogStatus.ERROR, "Elements not located in the page");
		}
		return itmcnt;
	}

	public static void clickJS(WebElement elem) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", elem);
			ExReporter.log(LogStatus.PASS, "Element successfully clicked in the page");
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Elements not located in the page");
		}
	}

	public static void isDisplayed(By by, String cont) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			waitVisible(by);
			WebElement element = driver.findElement(by);
			element.isDisplayed();
			ExReporter.log(LogStatus.PASS, "Element Available in the page " + cont);
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Element not Available in the page " + e.getMessage());
		}
	}
	
	public static String getAttribute(By by, String attribute) {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			WebElement element = driver.findElement(by);
			return element.getAttribute(attribute);
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error getting attribure value of an element " + e.getMessage());
			return null;
		}
	}

	public static String getAttribute(WebElement element, String attribute) {
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error getting attribure value of an element " + e.getMessage());
			return null;
		}
	}

	public static void assertEquals(String attribute, String value) {
		try {
			if (attribute.equalsIgnoreCase(value))
				ExReporter.log(LogStatus.PASS, "Element has the correct attribute");
			else
				ExReporter.log(LogStatus.FAIL, "Element dooesn't has the correct attribure");
		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Error getting attribure value of an element " + e.getMessage());
		}
	}

	public static void clickJquery(String query) {
		WebDriver driver = DriverFactory.getCurrentDriver();
		((JavascriptExecutor) driver).executeScript("return jQuery('" + query + "').get(0)");
	}

	public static void scollToPageEnd() {
		WebDriver driver = DriverFactory.getCurrentDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public static void switchNewWindow() {
		WebDriver driver = DriverFactory.getCurrentDriver();
		try {
			Set<String> newwindows = driver.getWindowHandles();
			String CurWindow = (String) newwindows.toArray()[newwindows.size() - 1];
			driver.switchTo().window(CurWindow);
		} catch (Exception E) {
			ExReporter.log(LogStatus.FAIL, "Unable to Navigate New Window : " + E.getMessage());
		}
	}

	public static void switch_Window() {
		WebDriver driver = DriverFactory.getCurrentDriver();

		try {
			Set<String> win = driver.getWindowHandles();
			int i = 0;
			for (String w : win) {
				if (i == 1) {
					driver.switchTo().window(w);
					ExReporter.log(LogStatus.PASS, "Switch window");
					break;
				}
				if (i == 0) {
					driver.switchTo().window(w);
					// String parent=w;
					i = i + 1;
					// ExReporter.log(LogStatus.PASS, "Switch window");
				}

			}

		} catch (Exception e) {
			ExReporter.log(LogStatus.ERROR, "Unable Switch the Window: " + e.getMessage());
		}
	}

	public static void brokenLinkValidation(String URL) {
		// System.out.println("inside broken link");
		int response = getResponseCode(URL);
		if (response == 200) {
			// System.out.println("working 200");
			ExReporter.logNoScreen(LogStatus.PASS, URL + "-URL is working");
		} else {
			// System.out.println("not working NOT 200");
			ExReporter.logNoScreen(LogStatus.FAIL, URL + "-URL is not working");
		}
	}

	public static int getResponseCode(String urlString) {
		try {
			URL u = new URL(urlString);
			HttpURLConnection h = (HttpURLConnection) u.openConnection();
			h.setRequestMethod("GET");
			h.connect();
			if (h.getResponseCode() == 301 || h.getResponseCode() == 302 || h.getResponseCode() == 307) {
				String newUrl = h.getHeaderField("Location");
				u = new URL(newUrl);
				h = (HttpURLConnection) u.openConnection();
				h.setRequestMethod("GET");
				h.connect();
			}
			return h.getResponseCode();
		} catch (MalformedURLException e) {
			ExReporter.log(LogStatus.FAIL, "MalformedURLException" + e.getMessage());
			return -1;
		} catch (IOException e) {
			ExReporter.log(LogStatus.FAIL, "MalformedURLException" + e.getMessage());
		}
		return 0;
	}

	public static void assertContainsData(WebElement web, String string) {
		try {
			if (web.getText().isEmpty())
				ExReporter.log(LogStatus.FAIL, "Element " + web + "has no data");
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error accessing element data");
		}
	}

	public static void reloadPage() {
		try {
			WebDriver driver = DriverFactory.getCurrentDriver();
			driver.navigate().refresh();
			waitForPageLoad();
		} catch (Exception e) {
			ExReporter.log(LogStatus.FAIL, "Error reloading page");
		}
	}
}


*/