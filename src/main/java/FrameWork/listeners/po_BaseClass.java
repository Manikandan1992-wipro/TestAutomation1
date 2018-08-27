package FrameWork.listeners;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;

public abstract class po_BaseClass {
	public static WebDriver drvr = null;
	public static boolean bResult;


	public static AppiumDriver<MobileElement> driver = null;
	public static boolean aResult;

	public po_BaseClass(WebDriver driver) {
		po_BaseClass.drvr = driver;
		po_BaseClass.bResult = true;
	}

	public po_BaseClass(AppiumDriver<MobileElement> appiumDriver) {
		po_BaseClass.driver = appiumDriver;
		po_BaseClass.aResult = true;
	}


	public static AppiumDriver<MobileElement> po_GetDriver1() {
		return po_BaseClass.driver;
	}

	public static void po_SetDriver1(AppiumDriver<MobileElement> driver) {
		po_BaseClass.driver = driver;
	}



   public static WebDriver po_GetDriver() {
		return po_BaseClass.drvr;
	}

	public static void po_SetDriver(WebDriver driver) {
		po_BaseClass.drvr = driver;
	}
}
