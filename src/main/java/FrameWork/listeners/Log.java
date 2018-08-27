package FrameWork.listeners;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;
import java.io.File;
import java.util.List;
import java.util.Set;

import static FrameWork.listeners.PreReq.driverFolder;

public class Log {

	private static Logger Log = Logger.getLogger(Log.class.getName()); 
	
	public static void startTestCase(String sTestCaseName){
		Log.info("Started Test case");
	}


	public static void endTestCase(String sTestCaseName){
		Log.info("Ended Test Case");
	}

	public static void info(String message)
	{
		Log.info(message);
	}



	/*public static void open_report() {
		//	String url = "file:///"+PreReq.htmlFilepath1;
		File f = new File(PreReq.htmlFilepath1);
		URI u = f.toURI();
		String url = PreReq.htmlFilepath1;

		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(u);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("xdg-open " + url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
*/	public static void open_report1()
	{
		System.setProperty("webdriver.chrome.driver", driverFolder + "chromeDriver.exe" );
		WebDriver driver=new ChromeDriver();
		driver.get(PreReq.htmlFilepath1);
		driver.manage().window().maximize();

	}

}