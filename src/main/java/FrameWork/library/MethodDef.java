/*

package mav.gib.library.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;

import mav.gib.driver.DriverFactory;
import mav.gib.framework.ConfigProvider;
import mav.gib.framework.ExReporter;
import mav.gib.framework.ProjectConfig;
import mav.gib.pom.elements.BasePage;

public class MethodDef {

	public static void click(By by) {
		CommonDef.waitVisible(by);
		CommonDef.waitClickable(by);
		CommonDef.click(by);
	}

	public static void click(By by, String elemname) {
		CommonDef.waitVisible(by, elemname);
		CommonDef.waitClickable(by, elemname);
		CommonDef.click(by, elemname);
	}

	public static void clickNoFail(By by, String elemname) {
		CommonDef.waitVisibleNoError(by);
		CommonDef.clickNoError(by, elemname);
	}

	public static void moveClickNoFail(By by, String elemname) {
		CommonDef.waitVisibleNoError(by);
		CommonDef.moveToElementClickNoFail(by, elemname);
	}

	public static void clickNoError(By by, String elemname) {
		// CommonDef.waitVisible(by);
		CommonDef.clickNoError(by, elemname);
	}

	public static void click(WebElement elem) {
		CommonDef.waitVisible(elem);
		CommonDef.waitClickable(elem);
		CommonDef.click(elem);
	}

	public static void click(WebElement elem, String elemname) {
		CommonDef.waitVisible(elem, elemname);
		CommonDef.waitClickable(elem, elemname);
		CommonDef.click(elem, elemname);
	}

	public static void clickJS(By by) {
		CommonDef.waitVisible(by);
		CommonDef.waitClickable(by);
		CommonDef.clickJS(by);
	}

	public static void clickJS(WebElement elem) {
		CommonDef.waitVisible(elem);
		CommonDef.waitClickable(elem);
		CommonDef.clickJS(elem);
	}

	public static void clickJS(WebElement elem, String elemname) {
		CommonDef.waitVisible(elem, elemname);
		CommonDef.waitClickable(elem, elemname);
		CommonDef.clickJS(elem, elemname);
	}

	public static void clickJS(By by, String elemname) {
		CommonDef.waitVisible(by, elemname);
		CommonDef.waitClickable(by, elemname);
		CommonDef.clickJS(by, elemname);
	}

	public static void clickJSNoError(By by, String elemname) {
		// CommonDef.waitVisibleNoError(by);
		CommonDef.waitClickableNoError(by);
		CommonDef.clickJSNoError(by, elemname);
	}

	
	public static void clickJSNoError(By by, String elemname, int i) {
		CommonDef.waitClickableNoError(by, i);
		CommonDef.clickJSNoError(by, elemname);
	}

	public static void moveClick(By by, String elemname) {
		// CommonDef.waitClickable(by);
		CommonDef.moveClick(by, elemname);
	}

	public static void moveClick(WebElement elem, String elemname) {
		// CommonDef.waitClickable(by);
		CommonDef.moveClick(elem, elemname);
	}

	public static void sendKeys(By by, String keysToSend) {
		CommonDef.waitVisible(by, keysToSend);
		CommonDef.waitClickable(by, keysToSend);
		CommonDef.clearText(by);
		CommonDef.sendKeys(by, keysToSend);
	}

	public static void sendKeys(WebElement elem, String keysToSend) {
		CommonDef.waitVisible(elem, keysToSend);
		CommonDef.waitClickable(elem, keysToSend);
		CommonDef.clearText(elem);
		CommonDef.sendKeys(elem, keysToSend);
	}

	public static String getText(By by) {
		CommonDef.waitVisible(by);
		return CommonDef.getText(by);
	}

	public static String getText(By by, String elem) {
		CommonDef.waitVisible(by, elem);
		return CommonDef.getText(by, elem);
	}

	public static void findElementsClick(By by) {
		CommonDef.waitVisible(by);
		CommonDef.waitClickable(by);
		CommonDef.findElementsClick(by);
	}

	public static void findElements(By by) {
		CommonDef.waitVisible(by);
		CommonDef.waitClickable(by);
	}

	public static void assertAttributeEquals(By by, String attr, String value) {
		CommonDef.assertEquals(CommonDef.getAttribute(by, attr), value);
	}

	public static void loadWaitIE() {
		try {
			if (ConfigProvider.getConfig("Browser").equalsIgnoreCase("IE"))
				Thread.sleep(3000);
			CommonDef.waitForPageLoad();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static boolean assertContains(By by, String string) {
		CommonDef.waitVisible(by, string);
		boolean b = CommonDef.assertContains(by, string);
		return b;
	}
	
	public static void assertContainsData(By by, String string) {
		CommonDef.waitVisible(by, string);
		CommonDef.assertContainsData(by, string);
	}

	public static boolean assertElemsContains(By by, String string) {
		CommonDef.waitVisible(by, string);
		boolean b = CommonDef.assertElemsContains(by, string);
		return b;
	}

	public static boolean assertElemsContainsWarn(By by, String string) {
		CommonDef.waitVisibleNoError(by);
		boolean b = CommonDef.assertElemsContainsWarn(by, string);
		return b;
	}

	public static boolean assertContainsNoError(By by, String string) {
		// CommonDef.waitVisibleNoError(by);
		boolean b = CommonDef.assertInnerHTMLContains(by, string);
		return b;
	}

	public static void assertContains(By by, String string, String passmsg) {
		//CommonDef.waitVisible(by, string);
		CommonDef.assertContains(by, string, passmsg);
	}

	public static void dateFunctionBBTemp(By calendarActiveDates, By totalRows, By Btn_DateFwdMonth, By calendar,
			int daytoselect, String type) {
		try {
			clickJS(calendar, "Calendar");

			try {
				Date date = new Date();
				Date dateApp = new Date();

				DateFormat dateFormatnow = new SimpleDateFormat("dd MMMM yyyy");
				String datenow = CommonDef.getTextNoError(calendarActiveDates) + " "
						+ CommonDef.getTextNoError(BasePage.dateActiveMonth());

				dateApp = dateFormatnow.parse(datenow);
				date = DateUtils.truncate(date, Calendar.DATE);
				dateApp = DateUtils.truncate(dateApp, Calendar.DATE);
				if (dateApp.compareTo(date) < 0)
					ExReporter.log(LogStatus.WARNING, "Application has backdated date");
				else
					ExReporter.log(LogStatus.INFO, "Basic Date Validation Passed");
			} catch (Exception EE) {
				// System.out.println(EE.getMessage());
				// EE.printStackTrace();
			}
			int activedaysinview = CommonDef.findElements(calendarActiveDates).size();
			int datetry = 0;
			do {
				datetry++;
				if ((activedaysinview > daytoselect)) {

					clickJS(CommonDef.findElements(calendarActiveDates).get(daytoselect), "Date Selected");
					ExReporter.log(LogStatus.PASS, "DATE Selection Successful");
					break;
				} else if ((CommonDef.findElements(calendarActiveDates).size() == 0)) {
					clickJS(Btn_DateFwdMonth, "Next Month - Calendar");
				} else {
					int rows = CommonDef.findElements(totalRows).size();
					int lastrow;
					if (type.equalsIgnoreCase("payments"))
						lastrow = CommonDef.findElements(BasePage.calendarActiveDatesLastRow(rows)).size();
					else
						lastrow = CommonDef.findElements(BasePage.calendarActiveDatesLastRowSOPayDate(rows)).size();
					daytoselect = daytoselect - (activedaysinview - lastrow) - 1;
					clickJS(Btn_DateFwdMonth, "Next Month - Calendar");
					activedaysinview = activedaysinview + CommonDef.findElements(calendarActiveDates).size() - lastrow;
				}
			} while (datetry < 10);
		} catch (Exception e) {
			e.printStackTrace();
			ExReporter.log(LogStatus.ERROR, "Error selecting the payment date: " + e.getMessage());
		}
	}

	public static void dateFunctionBB(By calendarActiveDates, By totalRows, By Btn_DateFwdMonth, By calendar,
			int daytoselect, String type) {
		try {
			clickJS(calendar, "Calendar");

			try {
				Date date = new Date();
				Date dateApp = new Date();

				DateFormat dateFormatnow = new SimpleDateFormat("dd MMMM yyyy");
				String datenow = CommonDef.getTextNoError(calendarActiveDates) + " "
						+ CommonDef.getTextNoError(BasePage.dateActiveMonth());

				dateApp = dateFormatnow.parse(datenow);
				date = DateUtils.truncate(date, Calendar.DATE);
				dateApp = DateUtils.truncate(dateApp, Calendar.DATE);
				if (dateApp.compareTo(date) < 0)
					ExReporter.log(LogStatus.WARNING, "Application has backdated date");
				else
					ExReporter.log(LogStatus.INFO, "Basic Date Validation Passed");
			} catch (Exception EE) {
				// System.out.println(EE.getMessage());
				// EE.printStackTrace();
			}

			try {
				Calendar cal = Calendar.getInstance();
				Date curr = cal.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
				String date = sdf.format(curr);
				int curday = Integer.parseInt(date.substring(0, 2));
				int curmon = Integer.parseInt(date.substring(2, 4));
				String curyear = date.substring(4, 8);
				//System.out.println(curday + " " + curmon + " " + curyear);
				for (int i = 0; i < daytoselect; i++) {
					do {
						cal.add(Calendar.DAY_OF_MONTH, 1);
					} while (!isWorkingDay(cal));
				}
				Date newdate = cal.getTime();
				sdf = new SimpleDateFormat("ddMMyyyy");
				date = sdf.format(newdate);
				String todate = date.substring(0, 2);
				int tomon = Integer.parseInt(date.substring(2, 4));
				String toyear = date.substring(4, 8);
				//System.out.println(todate + " " + tomon + " " + toyear);
					
				if(tomon<curmon){
					//int diffmonth=
					for (int i = 0; i < tomon; i++) {
						clickJS(Btn_DateFwdMonth, "Next Month - Calendar");
					}
				}else{
					for (int i = 0; i < (tomon - curmon); i++) {
						clickJS(Btn_DateFwdMonth, "Next Month - Calendar");
					}
				}
				
				//Old Logic
				//for (int i = 0; i < (tomon - curmon); i++) {
				//	clickJS(Btn_DateFwdMonth, "Next Month - Calendar");
				//}
				
				if (type.contains("End Date"))
					clickJS(By
							.xpath("//section[contains(@class,'payment-schedule')]//div[@ng-switch]//tr[@ng-repeat]//td[@aria-disabled='false']//button[not(contains(.,'disabled'))]//span[contains(.,'"
									+ todate + "')]"));
				else
					clickJS(By
							.xpath("//div[@ng-switch]//tr[@ng-repeat]//td[@aria-disabled='false']//button[not(contains(.,'disabled'))]//span[contains(.,'"
									+ todate + "')]"));

			} catch (Exception e) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			ExReporter.log(LogStatus.ERROR, "Error selecting the payment date: " + e.getMessage());
		}
	}

	private static boolean isWorkingDay(Calendar cal) {
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.SATURDAY)
			return false;
		// tests for other holidays here
		// ...
		return true;
	}

	public static String getIP() {
		WebDriver curr = DriverFactory.getCurrentDriver();
		String id = ((RemoteWebDriver) curr).getSessionId().toString();
		String ip = "";
		try {
			String hub = ProjectConfig.getPropertyValue("SelHost").split("/wd/hub")[0];
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(hub + "/grid/api/testsession?session=" + id);
			HttpResponse response = client.execute(request);
			JsonObject myjsonobject = extractObject(response);
			JsonElement urltest = myjsonobject.get("proxyId");
			ip = urltest.getAsString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ip;
	}

	private static JsonObject extractObject(HttpResponse resp) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer s = new StringBuffer();
		String line;
		while ((line = rd.readLine()) != null) {
			s.append(line);
		}
		rd.close();
		JsonParser parser = new JsonParser();
		JsonObject objToReturn = (JsonObject) parser.parse(s.toString());
		return objToReturn;
	}

	public static String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}

	public static void launchURL() {
		WebDriver driver = DriverFactory.getCurrentDriver();
		driver.get(ProjectConfig.getPropertyValue("url"));
		ExReporter.log(LogStatus.INFO, "URL Loaded: " + ProjectConfig.getPropertyValue("url"));
		CommonDef.waitForPageLoad();
	}

	public static void getResponseCodes(By topNavBarLinks, String testItem) {
		ExReporter.logNoScreen(LogStatus.INFO, "Validating hyperlink in: " + testItem);
		for (WebElement web : CommonDef.findElements(topNavBarLinks))
			CommonDef.brokenLinkValidation(CommonDef.getAttribute(web, "href"));
		if (CommonDef.findElements(topNavBarLinks).size() < 1)
			ExReporter.logNoScreen(LogStatus.FAIL, "No Hyperlinks are found in: " + testItem);
	}
}


*/