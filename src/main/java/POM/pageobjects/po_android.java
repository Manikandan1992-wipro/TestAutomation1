package POM.pageobjects;

import FrameWork.listeners.po_BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class po_android extends po_BaseClass {
	public po_android(WebDriver driver) {
		super(driver);
	}


	@FindBy(how = How.XPATH, using = "//*[@id='userloginform:userName']")
	public static WebElement GTX_user_id;

	@FindBy(how = How.XPATH, using = "//*[@id='userloginform:userName']")
	public static WebElement GTX_user_password;
	@FindBy(how = How.XPATH, using = "//*[@id='menumsg']")
	public static WebElement GTX_landing_msg_menu;

	@FindBy(how = How.XPATH, using = "//*[@id='container-left']/div/ul/li[2]/ul/li[2]/ul/li[1]/a")
	public static WebElement GTX_landing_search;
	@FindBy(how = How.XPATH, using = "//*[@id='searchrequestform:field20']")
	public static WebElement GTX_TRN_number;
	@FindBy(how = How.XPATH, using = "//*[@id='searchrequestform:search']")
	public static WebElement GTX_search_btn;
	@FindBy(how = How.XPATH, using = "//*[@id=\"advList_tabledata\"]/tbody/tr/td[5]")
	public static WebElement GTX_status_verify;
	@FindBy(how = How.XPATH, using = "//*[@id=\"advList_tabledata\"]/tbody/tr/td[4]")
	public static WebElement GTX_Type;
	@FindBy(how = How.XPATH, using = "//*[@id='container-head']/table/tbody/tr/td[4]/a")
	public static WebElement GTX_logout;

}
