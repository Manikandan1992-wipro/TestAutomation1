package FrameWork.listeners;

import com.relevantcodes.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static FrameWork.listeners.PreReq.*;

public class ExtentManager {

    public static ExtentReports Instance(String PathofReportFile) throws Exception{

         String baseReportHtml=baseReport+PathofReportFile+".html";
        ExtentReports extent = new ExtentReports(baseReportHtml, true);
        extent.config()
                .documentTitle("Automation PreReq")
                .reportName("Detailed Test Execution ");
        //extent.config().setAutoCreateRelativePathMedia(true);
        return extent;
    }
    public static String CaptureScreen(WebDriver driver, String ImagesPath, String TestCase) throws Exception {
        TakesScreenshot oScn = (TakesScreenshot) driver;
        File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
        File oDest = new File(ImagesPath + ".jpg");
        try {
            FileUtils.copyFile(oScnShot, oDest);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".jpg";
    }
}