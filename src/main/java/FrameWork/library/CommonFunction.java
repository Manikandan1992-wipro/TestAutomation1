package FrameWork.library;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;

public class CommonFunction {

    public static void  ClearAllCaches() {
        WebDriver driver= po_BaseClass.po_GetDriver();
        for(String sam:driver.getWindowHandles())
        {
            driver.switchTo().window(sam);
        }
        driver.manage().deleteAllCookies();

    }
}
