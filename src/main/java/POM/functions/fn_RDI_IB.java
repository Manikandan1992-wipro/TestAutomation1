package POM.functions;
import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import POM.pageobjects.po_LoginPage;
import POM.pageobjects.po_RDI_IB;
import com.relevantcodes.extentreports.LogStatus;
//import org.apache.regexp.RE;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static FrameWork.helpers.Helper.getData;
import static FrameWork.helpers.Helper.loginCredentials;
import static FrameWork.helpers.Helper.saveTestDataToDb;
import static FrameWork.helpers.ReportHelper.logReportStatusInBlue;
import static FrameWork.library.Util.*;
import static FrameWork.library.Util.getLatestDriver;
import static FrameWork.listeners.PreReq.getURL;
import static FrameWork.listeners.po_BaseClass.drvr;
import static org.openqa.selenium.support.PageFactory.initElements;

public class fn_RDI_IB {
    public static void initPageObjects() throws Exception {
        initElements(drvr, po_RDI_IB.class);
        logReportStatusInBlue(LogStatus.INFO, "Method: " + Thread.currentThread().getStackTrace()[2].getMethodName());
        getLatestDriver();
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : all_Login_RDI
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void all_Login_RDI() {
        try {
            String loginType = DriverHelper.environmentURL;
            //String loginUserType = loginType.split("~")[0] + "~" + loginType.split("~")[1];
            String application = loginType.split("~")[1];
            String urlType = loginType.split("~")[2];
            fn_allLogin.Login_RDI(loginType, application + "~" + urlType);
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,e.getMessage());
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Select_MenuItem
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Select_MenuItem(String strMenuItem){
        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver=getLatestDriver();
            switchDFrame(1);
            WebElement PageHeader=null;
            switch (strMenuItem){

                case "TALK TO MEEM":
                    po_RDI_IB.Button_TalktoMeem.click();
                    PageHeader=po_RDI_IB.WebElement_TalktoMeem;
                    break;

                case "PROFILES":
                    po_RDI_IB.Button_Profile.click();
                    PageHeader=po_RDI_IB.Button_Profile;
                    break;

                case "TOOLS":
                    po_RDI_IB.Button_Tools.click();
                    PageHeader=po_RDI_IB.WebElement_TalktoMeem;
                    break;

                case "PRODUCTS":
                    po_RDI_IB.Button_Products.click();
                    PageHeader=po_RDI_IB.WebElement_Products;
                    break;

                case "SECURITY TIPS":
                    po_RDI_IB.Button_Security.click();
                    PageHeader=po_RDI_IB.WebElement_SecurityTips;
                    break;

                case "INVITE FRIENDS":
                    po_RDI_IB.Button_Invite.click();
                    PageHeader=po_RDI_IB.WebElement_InviteFriends;
                    break;

                case "FAVOURITE":
                    po_RDI_IB.Button_Favorites.click();
                    PageHeader=po_RDI_IB.WebElement_Favourite;
                    break;

                case "TRANSFER":
                    po_RDI_IB.Button_TransferPayment.click();
                    PageHeader=po_RDI_IB.WebElement_TransferPayment;
                    break;

                case "YOUR ACCOUNTS":
                    po_RDI_IB.Button_Accounts.click();
                    PageHeader=po_RDI_IB.WebElement_Accounts;
                    break;

                case "YOUR BUDGET":
                    po_RDI_IB.Button_Budgets.click();
                    PageHeader=po_RDI_IB.WebElement_Budgets;
                    break;

                case "EMERGENCY CASH":
                    po_RDI_IB.Button_EmergencyCash.click();
                    PageHeader=po_RDI_IB.WebElement_EmergencyCash;
                    break;

                default:
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Menu Item proivded '" +strMenuItem+"' is not present in home page, kindly check");
            }

            waitFor(1000);

/*            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);*/

            if (elemExist(PageHeader)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Click on the Menu Item '" +strMenuItem+"',Page of '"+strMenuItem+"' is displayed succesfully");
            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Click on the Menu Item '" +strMenuItem+"',Page of '"+strMenuItem+"' is not displayed");
            }
        } catch (Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL,"Navigation through Menu Item failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : FCYAcct_MoveMoneyFromOnePacktoFCY
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void FCYAcct_MoveMoneyFromOnePacktoFCY() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver=getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();

/*            switchDFrame(1);
            click(po_RDI_IB.Menu_TransferAndPaymt);*/
            waitFor(1000);

            // fund transfer displayed
            if (elemExist(driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money from')]")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Move Money is displayed in the Transfer & Payments screen successfully");
                driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money from')]")).click();
                //click(po_RDI_IB.Select_MoveMoneyFrom);
                waitFor(1000);

                driver.findElement(By.xpath("//div[@class='dd wrapper-dropdown-5 ddfromaccount wrapper-dropdown-padding active']//div[@id='aUD1']")).click();
                //click(po_RDI_IB.DropDownLst_OnePack);
                ReportHelper.logReportStatus(LogStatus.PASS,"Move money from the account -'One Pack' entered successfully");
                waitFor(1000);

                driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money to')]")).click();
                //click(po_RDI_IB.Select_MoveMoneyTo);
                waitFor(1000);

                driver.findElement(By.xpath("//div[@class='dd wrapper-dropdown-5 ddtoaccount wrapper-dropdown-padding active']//div[@id='aUD2']")).click();
                //click(po_RDI_IB.DropDownLst_FCY);
                ReportHelper.logReportStatus(LogStatus.PASS,"Move money to the account -'FCY' entered successfully");
                waitFor(1000);

                String SrceAmt = getData("SourceAmount");
                sendKeys(po_RDI_IB.Input_SourceAmount,SrceAmt);
                /*sendKeys(po_RDI_IB.Input_ExchangeRate,"");
                sendKeys(po_RDI_IB.Input_DestinationAmount,"");*/

                ReportHelper.logReportStatus(LogStatus.PASS,"All mandatory details entered successfully");
                driver.findElement(By.xpath("//a[contains(.,'Immediately')]")).click();
                //click(po_RDI_IB.Button_Immediately);
                waitFor(7000);

                String CreditAmt = driver.findElement(By.xpath("//*[@id='slideContainer']//tr[5]/td[2]/span")).getText();

                if (!CreditAmt.equals(0.00)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Move Money details added successfully");
                    driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_upConfirm']//a[contains(text(),'Confirm')]")).click();
                    //click(po_RDI_IB.Button_MoveMoney_Confirm);
                    waitFor(8000);

                    String TxnMsg = driver.findElement(By.xpath("//span[contains(text(),'Your funds transfer has been successful.')]")).getText();
                    if (TxnMsg.contains("Your funds transfer has been successful")) {
                        ReportHelper.logReportStatus(LogStatus.PASS,TxnMsg);
                        driver.findElement(By.xpath("//li/a[contains(.,'Done')]")).click();
                        //click(po_RDI_IB.Button_Done);
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,TxnMsg);
                    }

                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Move Money from One Pack to FCY account added is not successful");
                }

            }
            else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Move money displayed in the Transfer & Payments screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account - Move Money failed due to '" +e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : FCY_Create
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void FCY_Create() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);
            //switchDFrame(1);
            //click(po_RDI_IB.Menu_Products);
            driver.findElement(By.xpath("//div/a[contains(.,'Products')]")).click();
            waitFor(5000);

            if (elemExist(driver.findElement(By.xpath("//div/a[contains(.,'Foreign Currency Account')]")))) {
                //if (elemExist(po_RDI_IB.Menu_ForeignCcyAcct)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Foreign Currency Account displayed in the submenu successfully");
                driver.findElement(By.xpath("//div/a[contains(.,'Foreign Currency Account')]")).click();
                //click(po_RDI_IB.Menu_ForeignCcyAcct);
                waitFor(3000);

                driver.findElement(By.xpath("//div[@class='currency']/ul/li[contains(.,'"+getData("ForeignCcy")+"')]")).click();
                waitFor(1000);
                driver.findElement(By.xpath("//div[@class='statement']/ul/li[contains(.,'"+getData("Statement")+"')]")).click();
                waitFor(5000);
                String FCYAcctName = driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder2$txtAccountLabel']")).getAttribute("value");
                saveTestDataToDb("AccountName",FCYAcctName);
                ReportHelper.logReportStatus(LogStatus.PASS,"Foreign Currency Account details entered successfully");

                //click(po_RDI_IB.Button_Confirm);
                driver.findElement(By.xpath("//a[contains(text(),'Confirm')]")).click();
                waitFor(5000);

                if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Accept')]")))) {
                    //if (elemExist(po_RDI_IB.Button_Accept)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Foreign Currency Account displayed in the confirmation page successfully");
                    driver.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();
                    //click(po_RDI_IB.Button_Accept);
                    waitFor(10000);

                    System.out.println(getData("AccountName"));
                    if (driver.findElement(By.xpath("//div/h3[contains(text(),'"+getData("AccountName")+"')]")).isDisplayed()) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Foreign currency account created successfully");
                    }else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Foreign currency account is not created successfully");
                    }
                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Foreign Currency Account displayed in the confirmation page is not successful");
                }
            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Foreign Currency Account displayed in the submenu is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Creation of FCY failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : FCYAcct_MoveMoneyFromFCYToOnePack
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void FCYAcct_MoveMoneyFromFCYToOnePack() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver=getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();

/*            switchDFrame(1);
            click(po_RDI_IB.Menu_TransferAndPaymt);*/
            waitFor(1000);

            // fund transfer displayed
            if (elemExist(driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money from')]")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Move Money is displayed in the Transfer & Payments screen successfully");
                driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money from')]")).click();
                //click(po_RDI_IB.Select_MoveMoneyFrom);
                waitFor(1000);

                driver.findElement(By.xpath("//div[@class='dd wrapper-dropdown-5 ddfromaccount wrapper-dropdown-padding active']//div[@id='aUD2']")).click();
                //click(po_RDI_IB.DropDownLst_OnePack);
                ReportHelper.logReportStatus(LogStatus.PASS,"Move money from the FCY account entered successfully");
                waitFor(1000);

                driver.findElement(By.xpath("//span/div[contains(text(),'Select the account you want to move money to')]")).click();
                //click(po_RDI_IB.Select_MoveMoneyTo);
                waitFor(1000);

                driver.findElement(By.xpath("//div[@class='dd wrapper-dropdown-5 ddtoaccount wrapper-dropdown-padding active']//div[@id='aUD1']")).click();
                //click(po_RDI_IB.DropDownLst_FCY);
                ReportHelper.logReportStatus(LogStatus.PASS,"Move money to the OnePack Account entered successfully");
                waitFor(10000);

                String SrceAmt = getData("SourceAmount");
                sendKeys(po_RDI_IB.Input_SourceAmount,SrceAmt);
                /*sendKeys(po_RDI_IB.Input_ExchangeRate,"");
                sendKeys(po_RDI_IB.Input_DestinationAmount,"");*/

                ReportHelper.logReportStatus(LogStatus.PASS,"All mandatory details entered successfully");
                driver.findElement(By.xpath("//a[contains(.,'Immediately')]")).click();
                //click(po_RDI_IB.Button_Immediately);
                waitFor(7000);

                String CreditAmt = driver.findElement(By.xpath("//*[@id='slideContainer']//tr[5]/td[2]/span")).getText();
                System.out.println(CreditAmt);

                if (!CreditAmt.equals(0.00)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Move Money details added successfully");
                    driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_upConfirm']//a[contains(text(),'Confirm')]")).click();
                    //click(po_RDI_IB.Button_MoveMoney_Confirm);
                    waitFor(10000);

                    String TxnMsg = driver.findElement(By.xpath("//span[contains(text(),'Your funds transfer has been successful.')]")).getText();
                    if (TxnMsg.contains("YOUR FUNDS TRANSFER HAS BEEN SUCCESSFUL")) {
                        ReportHelper.logReportStatus(LogStatus.PASS,TxnMsg);
                        driver.findElement(By.xpath("//li/a[contains(.,'Done')]")).click();
                        //click(po_RDI_IB.Button_Done);
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,TxnMsg);
                    }

                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Move Money from One Pack to FCY account added is not successful");
                }

            }
            else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Move money displayed in the Transfer & Payments screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account - Move Money failed due to '" +e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Bill_Create
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Bill_Create() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //click(po_RDI_IB.Menu_TransferAndPaymt);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();
            waitFor(1000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Bills')]")))) {
                //if (elemExist(po_RDI_IB.Menu_Bills)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Bills displayed in the submenu successfully");
                //click(po_RDI_IB.Menu_Bills);
                driver.findElement(By.xpath("//a[contains(text(),'Bills')]")).click();
                waitFor(2000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Bills are displayed in the records successfully");

                // To add new bill button
                driver.findElement(By.xpath("//a[@id='addNewb']")).click();
                waitFor(5000);

                // create new button
                ReportHelper.logReportStatus(LogStatus.PASS,"Create new Bill displayed in the screen successfully");
                driver.findElement(By.xpath("//li[contains(text(),'Create New')]")).click();
                waitFor(2000);

                driver.findElement(By.xpath("//*[@id='1']/h6//p[contains(.,'Telecom')]")).click();
                waitFor(2000);
                driver.findElement(By.xpath("//h6//p[contains(.,'Mobily')]")).click();
                waitFor(2000);
                driver.findElement(By.xpath("//li[@id='GSM_CIP']")).click();
                waitFor(5000);

                int Sdsize = 15;
                for (int i=1;i<Sdsize;i++) {
                    if (driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).isEnabled()) {
                        waitFor(1000);
                        driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).click();
                        if (driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder2_lbtnSaveConsumer']")).isDisplayed()) {
                            driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).click();
                            break;
                        }
                    }
                }

                driver.findElement(By.xpath("//li[@id='liField'][1]/input")).sendKeys(getData("ServiceLineNumber"));
                driver.findElement(By.xpath("//li[@id='liField'][2]/input ")).sendKeys(getData("BeneficiaryID"));
                driver.findElement(By.xpath("//li[@id='liField'][3]/ul/li[contains(.,'"+getData("BeneficiaryIDType")+"')]")).click();
                //li[@id='liField'][3]/ul/li[contains(.,'National ID')] - Bene ID Type

                driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder2$txtConcumerAlias']")).sendKeys(getData("Alias"));
                ReportHelper.logReportStatus(LogStatus.PASS,"All bill details entered successfully");
                waitFor(2000);
                driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).click();
                driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_upConsumerAdd']/div/ul/li/a[contains(text(),'Add')]")).click();
                waitFor(8000);

                if (elemExist(driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")))) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed in the screen");
                    driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")).click();
                    waitFor(6000);

                    /*String OTP = FetchOTP.getOTP();
                    driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder2$ucFAuth2$txtVerificationNumber']")).sendKeys(OTP);
                    driver.findElement(By.xpath("//li/a[contains(text(),'Confirm')]")).click();*/
                    sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
                    driver.findElement(By.xpath("//li/a[contains(text(),'Confirm')]")).click();
                    waitFor(15000);

                    if (driver.findElement(By.xpath("//li[contains(.,'"+getData("Alias")+"')]")).isDisplayed()) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Newly created bill details displayed in the list successfully");
                    }else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Newly created bill details displayed in the list is not successful");
                    }

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Bill details added is not successful");
                }
            }else  {
                ReportHelper.logReportStatus(LogStatus.FAIL, "Bills displayed in the submenu is not successful");
            }
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Creation of Bills failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Bill_Delete
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Bill_Delete() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //click(po_RDI_IB.Menu_TransferAndPaymt);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();
            waitFor(1000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Bills')]")))) {
                //if (elemExist(po_RDI_IB.Menu_Bills)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Bills displayed in the submenu successfully");
                //click(po_RDI_IB.Menu_Bills);
                driver.findElement(By.xpath("//a[contains(text(),'Bills')]")).click();
                waitFor(5000);

                List<WebElement> eleBills = driver.findElements(By.xpath("//*[@id='dvPayeesBeneficries1']/li"));
                int iBills = eleBills.size();
                //int iBills = po_RDI_IB.Table_FundTransferSummaryList.size();
                ReportHelper.logReportStatus(LogStatus.PASS,"Bills are displayed in the list successfully");
                boolean bFlag;
                bFlag = false;
                for (int i=1;i<iBills;i++) {
                    String tBillName = driver.findElement(By.xpath("//li["+i+"]//p[@id='billName']")).getText();
                    System.out.println(tBillName);
                    System.out.println(getData("BillName"));
                    if (tBillName.equals(getData("BillName"))) {
                        driver.findElement(By.xpath("//*[@id='dvPayeesBeneficries1']/li["+i+"]")).click();
                        waitFor(3000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Bill Name details displayed successfully");
                        driver.findElement(By.xpath("//*[@id='delete-btn']")).click();
                        //click(po_RDI_IB.Button_Delete);
                        waitFor(2000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Are you sure that you want to delete this bill? YES/NO");
                        driver.findElement(By.xpath("//a[contains(text(),'Yes')]")).click();
                        waitFor(5000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Bill name deleted successfully");
                        bFlag=true;
                        break;
                    }
                }

                if (bFlag=false) {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Bill name is not deleted successfully");
                }

            } else {

                ReportHelper.logReportStatus(LogStatus.FAIL,"Bills displayed in the submenu is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Bill Deletion failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Beneficiary_Delete
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Beneficiary_Delete() {
        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //click(po_RDI_IB.Menu_TransferAndPaymt);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();
            waitFor(1000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Beneficiaries')]")))) {
                //if (elemExist(po_RDI_IB.Menu_Beneficiaries)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiaries displayed in the submenu successfully");
                //click(po_RDI_IB.Menu_Beneficiaries);
                driver.findElement(By.xpath("//a[contains(text(),'Beneficiaries')]")).click();

                List<WebElement> eleBills = driver.findElements(By.xpath("//*[@id='dvPayeesBeneficries1']/li"));
                int iBene = eleBills.size();
                //int iBene = po_RDI_IB.Table_FundTransferSummaryList.size();
                ReportHelper.logReportStatus(LogStatus.PASS,"Beneficiaries are displayed in the records successfully");
                boolean bFlag;
                bFlag = false;
                for (int i=1;i<iBene;i++) {
                    String tBeneName = driver.findElement(By.xpath("//li["+i+"]//p[@id='BenName']")).getText();
                    System.out.println(tBeneName);
                    System.out.println(getData("BeneName"));
                    if (tBeneName.equals(getData("BeneName"))) {
                        driver.findElement(By.xpath("//*[@id='dvPayeesBeneficries1']/li["+i+"]")).click();
                        waitFor(3000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Beneficary Name details displayed successfully");
                        driver.findElement(By.xpath("//*[@id='delete-btn']")).click();
                        //click(po_RDI_IB.Button_Delete);
                        waitFor(2000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Are you sure that you want to delete this bill? YES/NO");
                        driver.findElement(By.xpath("//a[contains(text(),'Yes')]")).click();
                        waitFor(5000);
                        ReportHelper.logReportStatus(LogStatus.PASS,"Beneficiary name deleted successfully");
                        bFlag=true;
                        break;
                    }
                }

                if (bFlag=false) {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Beneficiary name is not deleted successfully");
                }

            }else {

                ReportHelper.logReportStatus(LogStatus.FAIL,"Beneficiaries displayed in the submenu is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Beneficiary Deletion failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : OnePack_AccountSumm
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void OnePack_AccountSumm() {
        try {
            initPageObjects();
            getLatestDriver();

            //WebDriver driver = getLatestDriver();
            switchDFrame(1);
            String AcctBal = getText(po_RDI_IB.TextArea_AcctBalance);

            if (!AcctBal.equals(0.00)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Available Balance -'"+AcctBal+"' of Meem OnePack displayed successfully");
                click(po_RDI_IB.WebElement_MeemOnePackAccount);
                waitFor(7000);

                if (getText(po_RDI_IB.TextArea_AccountStatus).equals(getData("AcctStatus"))) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Meem OnePack account details displayed correctly");

                    String IBAN = getText(po_RDI_IB.WebELement_IBANNumber).trim();
                    String AccountNo = IBAN.substring(13, IBAN.length());
                    saveTestDataToDb("AccountNum", AccountNo);
                    waitFor(1000);
                    String AvalBal = getText(po_RDI_IB.WebELement_AvailableBalance).replace(",","").trim();
                    saveTestDataToDb("AvailableBalance", AvalBal);
                    waitFor(1000);
                    String CurrBal = getText(po_RDI_IB.WebELement_CurrentAccount).replace("SAR","");
                    String gCurBal = CurrBal.replace(",","").trim();
                    saveTestDataToDb("CurrentBalance", gCurBal);

                    String SavBal = getText(po_RDI_IB.WebELement_SavingAccount).replace("SAR","");
                    String gSavBal = SavBal.replace(",","").trim();
                    saveTestDataToDb("SavingAcctBalance", gSavBal);

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Meem OnePack account details displayed is not successful");
                }

            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Available Balance of Meem OnePack is shown as '"+AcctBal+"'");
            }

        } catch (Exception e){
            ReportHelper.logReportStatus(LogStatus.FAIL,"OnePack Account summary failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : FCY_AccountSumm
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void FCY_AccountSumm() {
        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
/*            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);*/
            switchDFrame(1);

            ReportHelper.logReportStatus(LogStatus.PASS,"Account summary displayed in the screen successfully");

            //div/h3[contains(.,'Foreign Currency account Creation')]
            driver.findElement(By.xpath("//div/h3[contains(.,'"+getData("FCYAccountName")+"')]")).click();
            waitFor(5000);

            if (elemExist(po_RDI_IB.WebELement_FCYIBAN)) {
                ReportHelper.logReportStatus(LogStatus.PASS,getData("FCYAccountName")+" details displayed successfully");

                String AllIBAN = getText(po_RDI_IB.WebELement_FCYIBAN);
                String IBAN= AllIBAN.replace("IBAN:","").trim();
                String AccountNo = IBAN.substring(13, IBAN.length());
                System.out.println(AccountNo);
                saveTestDataToDb("AccountNum", AccountNo);
                waitFor(1000);

                String AvalBal = getText(po_RDI_IB.WebELement_FCYBalance).trim();
                String AcctBal = AvalBal.replace(",","");
                saveTestDataToDb("FCYAccountBalance", AcctBal);
                waitFor(1000);

            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,getData("FCYAccountName")+" details displayed is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account summary failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : FCYAcct_Close
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void FCYAcct_Close() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            if (elemExist(driver.findElement(By.xpath("//div/div/h3[contains(.,'"+getData("AcctType")+"')]")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,getData("AcctType")+" displayed in the account summary list");

                driver.findElement(By.xpath("//div/div/h3[contains(.,'"+getData("AcctType")+"')]")).click();
                waitFor(3000);

                ReportHelper.logReportStatus(LogStatus.PASS,getData("AcctType")+" details displayed successfully");
                driver.findElement(By.xpath("//a[contains(.,'ACCOUNT CLOSE')]")).click();
                waitFor(3000);

                driver.findElement(By.xpath("//textarea[@name='ctl00$ContentPlaceHolder2$ucAccountClose$txtPurpose']")).sendKeys(getData("TextArea_CloseAcct"));
                ReportHelper.logReportStatus(LogStatus.PASS,"Data entered successfully");

                driver.findElement(By.xpath("//a[contains(.,'proceed')]")).click();
                //waitTillElementIsVisible(driver.findElement(By.xpath("//div/div/h3[contains(.,'Accounts')]")));
                waitFor(18000);

                List<WebElement> AcctList = driver.findElements(By.xpath("//div/div/div/div/h3"));
                int CntAcct = AcctList.size();
                boolean AcctFlg;
                AcctFlg=false;
                for (int i=1;i<CntAcct;i++){
                    String gAcct = driver.findElement(By.xpath("//div/div["+i+"]/div/div/h3")).getText();
                    if (gAcct.equals(getData("AcctType"))) {
                        AcctFlg=true;
                        ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account details closed is not successful");
                        break;
                    }
                }

                if (AcctFlg=false) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"FCY Account details have been closed successfully");
                }

/*                try {
                    driver.findElement(By.xpath("//div/div/h3[contains(.,'"+getData("AcctType")+"')]"));
                    ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account details closed is not successful");
                }catch(Exception e)
                {
                    ReportHelper.logReportStatus(LogStatus.PASS,"FCY Account details have been closed successfully");
                }*/
              /*  if (driver.findElement(By.xpath("//div/div/h3[contains(.,'"+getData("AcctType")+"')]")).isDisplayed()) {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account details closed is not successful");
                }else {

                    ReportHelper.logReportStatus(LogStatus.PASS,"FCY Account details have been closed successfully");
                }*/

            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account Close failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Govt_Payment
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Govt_Payment() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //click(po_RDI_IB.Menu_TransferAndPaymt);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();
            waitFor(1000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(.,'Government Payment')]")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Government Payment displayed in the submenu successfully");

                driver.findElement(By.xpath("//a[contains(.,'Government Payment')]")).click();
                waitFor(1000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Government Payment displayed in the page successfully");
                driver.findElement(By.xpath("//div[@class='new-GovtFeeCompanies-viewport govtCarousel']/div")).click();
/*                Select Biller = new Select(driver.findElement(By.xpath("//div[@class='new-GovtFeeCompanies-viewport govtCarousel']/select[@id='GvotCompanies']")));
                Biller.selectByVisibleText(getData("SelBiller"));*/
                driver.findElement(By.xpath("//div[@class='new-GovtFeeCompanies-viewport govtCarousel']//ul/li[contains(.,'"+getData("SelBiller")+"')]")).click();

                waitFor(2000);

                driver.findElement(By.xpath("//div[@class='new-GovtFees-viewport govtCarousel']/div")).click();
/*                Select Servce = new Select(driver.findElement(By.xpath("//select[@id='GovtServices']")));
                Servce.selectByVisibleText(getData("SelService"));*/
                driver.findElement(By.xpath("//div[@class='new-GovtFees-viewport govtCarousel']//ul/li[contains(.,'"+getData("SelService")+"')]")).click();
                ReportHelper.logReportStatus(LogStatus.PASS,"Biller and services entered successfully");
                waitFor(1000);
                driver.findElement(By.xpath("//li[contains(.,'Payment')]")).click();
                waitFor(2000);

                driver.findElement(By.xpath("//ul[@id='dvFields']/li/input")).sendKeys(getData("IQAMAID"));
/*                Select Iqama_Duratn = new Select(driver.findElement(By.xpath("//select[@id='ulCustomFields']")));
                Iqama_Duratn.selectByVisibleText(getData("Iqama_Duration"));*/
                driver.findElement(By.xpath("//select[@id='ulCustomFields']")).click();
                driver.findElement(By.xpath("//select[@id='ulCustomFields']/option[contains(.,'"+getData("Iqama_Duration")+"')][1]")).click();
                ReportHelper.logReportStatus(LogStatus.PASS,"IQAMA details entered successfully");

                driver.findElement(By.xpath("//a[@id='SearchGovtFee']")).click();
                waitFor(5000);

                String TotAmtPay = driver.findElement(By.xpath("//div[@id='dvBillDetails']/h2//span[@id='lblAmountFormatted']")).getText();
                System.out.println(TotAmtPay);

                if (!TotAmtPay.equals("")) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Total Amount of government payment is displayed as '"+TotAmtPay+"'");
                    driver.findElement(By.xpath("//a[@id='PayFee']")).click();
                    waitFor(7000);

                    String SuccMsg = driver.findElement(By.xpath("//span[@id='lblFeeSuccess']")).getText();
                    if (SuccMsg.contains("YOUR FEE PAYMENT HAS BEEN PAID SUCCESSFULLY")) {
                        ReportHelper.logReportStatus(LogStatus.PASS,SuccMsg);
                        driver.findElement(By.xpath("//a[@id='lbtnOK']")).click();
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,SuccMsg);
                    }
                } else {
                    String ErrMsg = driver.findElement(By.xpath("//span[@id='lblFeeError']")).getText();
                    ReportHelper.logReportStatus(LogStatus.FAIL,ErrMsg);
                }
            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Government Payment displayed in the submenu is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Government Payment failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Beneficiary_Create
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Beneficiary_Create() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //click(po_RDI_IB.Menu_TransferAndPaymt);
            driver.findElement(By.xpath("//a[@id='Recipients-btn']")).click();
            waitFor(1000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Beneficiaries')]")))) {
                //if (elemExist(po_RDI_IB.Menu_Beneficiaries)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiaries displayed in the submenu successfully");
                //click(po_RDI_IB.Menu_Beneficiaries);
                driver.findElement(By.xpath("//a[contains(text(),'Beneficiaries')]")).click();
                waitFor(2000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Beneficiaries are displayed in the list successfully");

                driver.findElement(By.xpath("//a[@id='addNewb']")).click();
                waitFor(5000);

                // create new button
                ReportHelper.logReportStatus(LogStatus.PASS,"Create new Bill displayed in the screen successfully");

                driver.findElement(By.xpath("//ul/li[contains(text(),'"+getData("BeneType")+"')]")).click();
                waitFor(2000);

                driver.findElement(By.xpath("//input[@name='ctl00$ContentPlaceHolder2$txtIBAN']")).sendKeys(getData("IBANNumber"));
                ReportHelper.logReportStatus(LogStatus.PASS,"IBAN Number entered successfully");
                driver.findElement(By.xpath("//*[@id='add-new-accordion']//ul/li/img")).click();
                waitFor(2000);

                if (elemExist(driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtFirstName")))) {
                    ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiary fields after entering IBAN displayed successfully");
                    if(getData("BeneType").equals("Within KSA")) {
                        driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtFirstName")).sendKeys(getData("BeneFirstNam"));
                        driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtSecondName")).sendKeys(getData("BeneSecNam"));
                        driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtLastName")).sendKeys(getData("BeneLastNam"));
                    } else if (getData("BeneType").equals("International")){
                        driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtBeneSwift")).sendKeys("CTBAAU2S");
                    }
                    ReportHelper.logReportStatus(LogStatus.PASS,"All beneficiary details entered successfully");
                    waitFor(2000);

                    int Sdsize = 16;
                    for (int i=1;i<Sdsize;i++) {
                        if (driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).isEnabled()) {
                            waitFor(1000);
                            driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).click();
                            if (driver.findElement(By.xpath("//a[contains(.,'Confirm')]")).isDisplayed()) {
                                break;
                            }
                        }
                    }
                    driver.findElement(By.xpath("//*[@id='arrow-menu']/a[1]")).click();
                    driver.findElement(By.xpath("//a[contains(.,'Confirm')]")).click();
                    waitFor(8000);

                    if (elemExist(driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")))) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed in the screen");
                        //driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")).click();
                        click(po_RDI_IB.Button_OTPSentMobile);
                        waitFor(6000);

                        sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
                        click(po_RDI_IB.Button_OTPConfirm);
                        //driver.findElement(By.xpath("//li/a[contains(text(),'Confirm')]")).click();
                        waitFor(15000);

                        String BeneName = getData("BeneFirstNam")+" "+getData("BeneLastNam");
                        if (driver.findElement(By.xpath("//div/h6/p[@id='BenName'][contains(.,'"+BeneName+"')]")).isDisplayed()) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Newly created beneficiary details added in the list successfully");
                        }else {
                            ReportHelper.logReportStatus(LogStatus.FAIL,"Newly created beneficiary details added in the list is not successful");
                        }
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Authentication code displayed in the screen is not successful");
                    }
                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Beneficiary Fields displayed after entering IBAN details is not successful");
                }
            }else  {
                ReportHelper.logReportStatus(LogStatus.FAIL, "Beneficiaries displayed in the submenu is not successful");
            }
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Creation of Beneficiary failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : SecSettng_PasswordChnge
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void SecSettng_PasswordChnge() {
        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            driver.findElement(By.xpath("//a[contains(text(),'Profiles')]")).click();
            waitFor(3000);

            if (elemExist(driver.findElement(By.xpath("//a[contains(text(),'Security Settings')]")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Profiles displayed in the submenu successfully");
                driver.findElement(By.xpath("//a[contains(text(),'Security Settings')]")).click();
                waitFor(1000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Password and Security Settings displayed successfully");
                driver.findElement(By.xpath("//div/h3[@id='ChangePassword']")).click();
                waitFor(1000);

                driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtOldPassword")).sendKeys(getData("OldPassword"));
                driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtNewPassword")).sendKeys(getData("NewPassword"));
                driver.findElement(By.name("ctl00$ContentPlaceHolder2$txtConfirmNewPassword")).sendKeys(getData("ConfirmNewPassword"));
                ReportHelper.logReportStatus(LogStatus.PASS,"All fields entered successfully");
                driver.findElement(By.xpath("//div[2]/ul/li/a[contains(text(),'confirm')]")).click();
                waitFor(3000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed in the screen");
                driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")).click();
                waitFor(1000);
                sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
                driver.findElement(By.xpath("//li/a[contains(text(),'Confirm')]")).click();
                waitFor(5000);

                String SuccMsg = driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceHolder2_ucFAuth2_imgbtn_Validator']")).getText();
                if (SuccMsg.contains("YOU HAVE SUCCESSFULLY CHANGED YOUR PASSWORD")) {
                    ReportHelper.logReportStatus(LogStatus.PASS,SuccMsg);
                    driver.findElement(By.xpath("//a[@id='ctl00_ContentPlaceHolder2_ucFAuth2_imgbtn']")).click();
                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,SuccMsg);
                }

            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Profiles displayed in the submenu is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Security Setting - Password Change failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : CurrenciesCard_AcctDetails
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void CurrenciesCard_AcctDetails() {
        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            driver.findElement(By.xpath("//div/h3[contains(.,'"+getData("EmbossName")+"')]")).click();


            if (elemExist(driver.findElement(By.xpath("//div/h3[@id='MoreDetails']")))) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Currencies Card displayed in the page successfully");
                driver.findElement(By.xpath("//div/h3[@id='MoreDetails']")).click();
                waitFor(1000);

                String AcctStatus = driver.findElement(By.xpath("//div[@id='divMoreDetails']//tr[4]/td[2]")).getText();
                if (AcctStatus.equals(getData("AcctStatus"))) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Account Status of Currencies Card is '"+AcctStatus+"'");
                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Account Status of Currencies Card is '"+AcctStatus+"'");
                }

            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Currencies Card displayed is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Currencies Card account details failed due to'"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : CardUpdateLimit
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void CardUpdateLimit() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            driver.switchTo().defaultContent();
            driver.switchTo().frame(1);

            //driver.findElement(By.xpath("//a[contains(text(),'Profiles')]")).click();
            click(po_RDI_IB.Menu_Profiles);
            waitFor(3000);

            if (elemExist(po_RDI_IB.SubMenu_SecSettings)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Profiles displayed in the submenu successfully");
                //driver.findElement(By.xpath("//a[contains(text(),'Security Settings')]")).click();
                click(po_RDI_IB.SubMenu_SecSettings);
                waitFor(1000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Password and Security Settings displayed successfully");

                //driver.findElement(By.xpath("//div/h3[@id='Limits']")).click();
                click(po_RDI_IB.Select_CardUpdateLimit);
                waitFor(1000);

/*                driver.findElement(By.xpath("//div/input[@name='ctl00$ContentPlaceHolder2$amount11']")).clear();
                driver.findElement(By.xpath("//div/input[@name='ctl00$ContentPlaceHolder2$amount11']")).sendKeys();*/
                po_RDI_IB.Input_LimitAmount.clear();
                sendKeys(po_RDI_IB.Input_LimitAmount,getData("LimitAmount"));
                ReportHelper.logReportStatus(LogStatus.PASS,"Limit Amount entered successfully");

                click(po_RDI_IB.Button_UpdateLimit);
                waitFor(1000);
                //driver.findElement(By.xpath("//li/a[@id='lbtnOTPSentMobile']")).click();
                click(po_RDI_IB.Button_OTPSentMobile);
                waitFor(1000);
                sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());

                //driver.findElement(By.xpath("//li/a[contains(text(),'Confirm')]")).click();
                click(po_RDI_IB.Button_OTPConfirm);
                waitFor(5000);



            }else {

            }
        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Card Update Limit failed due to'"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : BeneType_LimitValidation
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/
    public static void BeneType_LimitValidation() {

        try {
            initPageObjects();
            getLatestDriver();

            switchDFrame(1);
            click(po_RDI_IB.Menu_TransferAndPaymt);
            waitFor(1000);

            ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiaries displayed in the submenu successfully");
            click(po_RDI_IB.Menu_Beneficiaries);
            waitFor(4000);
            //ReportHelper.logReportStatus(LogStatus.PASS, "Beneficiaries displayed in the summary list successfully");

            int iBene = po_RDI_IB.Table_Beneficiaries.size();
            WebDriver driver = getLatestDriver();
            boolean bFlag;
            bFlag = false;
            for (int i=1;i<iBene;i++) {
                String gBeneTyp = driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]//div/h6[2]/p")).getText();
                String gBeneStatus = driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]//div/h6[3]/p")).getText();
                if (gBeneTyp.equals(getData("BeneType")) && gBeneStatus.equals("ACTIVE")) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"'"+gBeneTyp+"' displayed in the summary list successfully");
                    driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]")).click();
                    bFlag=true;
                    break;
                }
            }

            waitFor(5000);
            if (bFlag=true && elemExist(po_RDI_IB.Button_PayNow)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"'"+getData("BeneType")+"' Details displayed successfully");
                click(po_RDI_IB.Button_PayNow);
                waitFor(3000);

                if (elemExist(po_RDI_IB.Input_TransferAmount)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Beneficiaries Payment displayed in the screen successfully");

                    String Ccy = getData("BeneCurrency");
                    if (Ccy.equals("FCY")) {
                        click(po_RDI_IB.Image_Close);
                        waitFor(5000);
                        click(po_RDI_IB.Button_ArrowDown);
                        waitFor(1000);

                        int iFCYAccts = po_RDI_IB.Table_FCYAccounts.size();
                        boolean FFlag;
                        FFlag=false;
                        for (int i=1;i<iFCYAccts;i++){
                            waitFor(2000);
                            String cAcctNam = driver.findElement(By.xpath("//div[@class='accountsContainer FCY']["+i+"]/div[1]//h3")).getText();
                            String cAcctBal = driver.findElement(By.xpath("//div[@class='accountsContainer FCY']["+i+"]/div[2]/p[@class='amount']")).getText();
                            String cAcctStatus = driver.findElement(By.xpath("//div[@class='accountsContainer FCY']["+i+"]/div/div/p[1]")).getText();
                            if (!cAcctBal.equals("0.00") && cAcctStatus.equals("ACTIVE") && cAcctNam.equals(getData("AccountName"))) {
                                WebElement source=driver.findElement(By.xpath("//div[@class='accountsContainer FCY']["+i+"]/div[1]"));
                                WebElement destiny=driver.findElement(By.xpath("//*[@data-class='from']"));

                                Actions builder = new Actions(driver);
                                Action dragAndDrop = builder.clickAndHold(source)
                                        .moveToElement(destiny)
                                        .release(destiny)
                                        .build();
                                dragAndDrop.perform();

                                FFlag=true;
                                ReportHelper.logReportStatus(LogStatus.PASS,"FCY Account entered in the 'From Account' field successfully");
                                break;
                            }
                            click(po_RDI_IB.Button_ArrowDown);
                        }

                        if (FFlag=false) {
                            ReportHelper.logReportStatus(LogStatus.FAIL,"FCY Account entered in the 'From Account' field is not successful");
                        }
                    }

                    waitFor(7000);
                    if (getData("BeneType").equals("INTERNATIONAL")&& Ccy.equals("FCY")) {
                        String gCreditAmt = getText(po_RDI_IB.Input_TransferAmount);
                        saveTestDataToDb("PaymentAmount",gCreditAmt);
                        saveTestDataToDb("CreditAmount",gCreditAmt);
                    }else {
                        po_RDI_IB.Input_TransferAmount.clear();
                        sendKeys(po_RDI_IB.Input_TransferAmount, getData("PaymentAmount"));
                    }
                    ReportHelper.logReportStatus(LogStatus.PASS,"Transfer Amount entered successfully");
                    waitFor(1000);

                    if ((getData("BeneType").equals("WITHIN MEEM")&&Ccy.equals("FCY")) ||(getData("BeneType").equals("WITHIN KSA")&&Ccy.equals("FCY")) || (getData("BeneType").equals("INTERNATIONAL")&& Ccy.equals("SAR")) ) {
                        String gCreditAmt = getText(po_RDI_IB.WebElement_BeneCreditAmt);
                        saveTestDataToDb("CreditAmount", gCreditAmt);
                    }
                    click(po_RDI_IB.Button_ConfirmTransferMoney);
                    waitFor(5000);

                    if (getData("BeneType").equals("WITHIN KSA") || getData("BeneType").equals("INTERNATIONAL")) {
                        Select CategoryPaymt = new Select(po_RDI_IB.Select_PurposeOfCategoryPaymt);
                        CategoryPaymt.selectByValue(getData("PurposeOfCategoryPaymt"));
                        waitFor(2000);
                        Select Payment = new Select(po_RDI_IB.Select_PurposeOfPayment);
                        Payment.selectByValue(getData("PurposeOfPayment"));
                        waitFor(1000);
                        String VATChrge = getText(po_RDI_IB.TextArea_VATChargesAmt).replace("SAR","").trim();
                        Double gVAT = Double.parseDouble(VATChrge);
                        saveTestDataToDb("VATCharge",VATChrge);

                        if (!getData("BeneType").equals("INTERNATIONAL")) {
                            Double dCredAmt = Double.parseDouble(getData("CreditAmount"));
                            Double TotAmt = gVAT + dCredAmt;
                            DecimalFormat df = new DecimalFormat("0.00");
                            String TotalTxnAmt = df.format(TotAmt);
                            saveTestDataToDb("TotalTxnAmount", TotalTxnAmt);
                        }

                    } else if (getData("BeneType").equals("WITHIN MEEM")) {
                        sendKeys(po_RDI_IB.Input_PurposeOfPaymt,getData("PurposeOfPayment"));
                    }
                    ReportHelper.logReportStatus(LogStatus.PASS,"Payment details entered successfully");
                    click(po_RDI_IB.Button_ConfirmProceed);
                    waitFor(2000);

                    if (elemExist(po_RDI_IB.Button_ConfirmTxn)) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Transaction details displayed successfully");
                        click(po_RDI_IB.Button_ConfirmTxn);
                        waitFor(1000);

                        if (elemExist(po_LoginPage.Input_AuthenticationCode)) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed successfully");
                            sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
                            waitFor(3000);
                            ReportHelper.logReportStatus(LogStatus.PASS,"Transfer amount details displayed correctly");
                            click(po_RDI_IB.Button_ConfirmAgreemnt);
                        } else if (elemExist(po_RDI_IB.Button_ConfirmAgreemnt)) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Transfer amount details displayed correctly");
                            click(po_RDI_IB.Button_ConfirmAgreemnt);
                        } else {
                            ReportHelper.logReportStatus(LogStatus.FAIL,"Transfer amount details displayed is not successful");
                        }

                        waitFor(6000);
                        String TxnMsg = getText(po_RDI_IB.WebElement_FundTransferSuccessfulMsg);

                        if (TxnMsg.contains("YOUR FUNDS TRANSFER HAS BEEN SUCCESSFUL")) {
                            ReportHelper.logReportStatus(LogStatus.PASS,TxnMsg);
                            click(po_RDI_IB.Button_OK);
                        } else {
                            ReportHelper.logReportStatus(LogStatus.FAIL,TxnMsg);
                        }

                    }else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction details displayed is not successful");
                    }

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Beneficiaries Payment displayed in the screen is not successful");
                }

            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL,getData("BeneType")+" Beneficiary Type is not displayed in the list");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Fund Transfer failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : BeneType_VerifyAcctTransaction
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/
    public static void BeneType_VerifyAcctTransaction() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            //click(po_RDI_IB.Image_Home);
            waitFor(2000);

            ReportHelper.logReportStatus(LogStatus.PASS,"Account summary displayed in the screen successfully");
            boolean AcctFlag;
            AcctFlag = false;
            String Ccy = "";
            int iAccts = po_RDI_IB.Table_Accounts.size();
            for (int i=1;i<iAccts;i++) {
                String cAcct = driver.findElement(By.xpath("//div[@id='accountsContainer']/div["+i+"]//div[@class='accountsLeft']/h3")).getText();
                if (cAcct.equals(getData("AccountName"))) {
                    Ccy = driver.findElement(By.xpath("//div[@id='accountsContainer']/div["+i+"]//div[@class='accountsRight']//p[1]/span")).getText();
                    driver.findElement(By.xpath("//div[@id='accountsContainer']/div["+i+"]//div[@class='accountsRight']//p[2]")).click();
                    AcctFlag = true;
                    break;
                }
            }

            waitFor(4000);
            if (AcctFlag=true && elemExist(po_RDI_IB.Title_AccountTransaction)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Account Transaction displayed in the screen successfully");
                int iAcctTxns = po_RDI_IB.Table_AcctTransaction.size();
                boolean TxnFlag;
                TxnFlag=false;
                for (int i=1;i<iAcctTxns;i++) {
                    String cTxnAmt = driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_ucTransactionList_udpTransactionList']/ul/li["+i+"]/div[2]/h1/p")).getText().replace(",","").trim();
                    DecimalFormat dformat=new DecimalFormat("0.00");
                    String vTransfAmt1 ="",vTransfAmt2="",vTransfAmt3="",vTransfAmt4="",vTransfAmt5="";

                    Double TransfAmt1 = Double.parseDouble(getData("PaymentAmount")); //Based on Internal(Within Meem)
                    vTransfAmt1 = dformat.format(TransfAmt1);

                    if (getData("BeneType").equals("WITHIN KSA") && getData("BeneCurrency").equals("FCY") ) {
                        String VATAmt = getData("VATCharge");
                        String CcyExc = getData("CcyExchange");
                        Double FVATAmt = Double.parseDouble(VATAmt)*Double.parseDouble(CcyExc);
                        Double TxnAmt2 = FVATAmt + Double.parseDouble(getData("PaymentAmount"));
                        vTransfAmt2 = dformat.format(TxnAmt2);
                    } else if (getData("BeneType").equals("INTERNATIONAL") && getData("BeneCurrency").equals("SAR")) {
                        Double TransfAmt4 = Double.parseDouble(getData("PaymentAmount")) + Double.parseDouble(getData("VATCharge")) + 3.25;
                        vTransfAmt4 = dformat.format(TransfAmt4);
                        saveTestDataToDb("TotalTxnAmount", vTransfAmt4);
                    } else if (getData("BeneType").equals("INTERNATIONAL") && getData("BeneCurrency").equals("FCY")){
                        String CcyExc = getData("CcyExchange");
                        Double FVATAmt = Double.parseDouble(getData("PaymentAmount"))*Double.parseDouble(CcyExc);
                        Double TxnAmt5 = FVATAmt + Double.parseDouble(getData("VATCharge")) + 3.25 ;
                        vTransfAmt5 = dformat.format(TxnAmt5);
                        saveTestDataToDb("TotalTxnAmount", vTransfAmt5);
                    } else {
                        Double TransfAmt3 = Double.parseDouble(getData("TotalTxnAmount")); //Based on Domestic(KSA) And International
                        vTransfAmt3 = dformat.format(TransfAmt3);
                    }

                    if (cTxnAmt.equals(vTransfAmt1) || cTxnAmt.equals(vTransfAmt2) || cTxnAmt.equals(vTransfAmt3) || cTxnAmt.equals(vTransfAmt4) || cTxnAmt.equals(vTransfAmt5)) {
                        driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_ucTransactionList_udpTransactionList']/ul/li["+i+"]/div[1]/h3/a")).click();
                        waitFor(10000);
                        String cTxnAmt2 = getText(po_RDI_IB.TextArea_CreditAmount).replace(",","").trim();
                        String vTxnAmt = "";
                        String vTxnAmt2 = "";
                        String vCredtAmt ="";
                        if (getData("BeneType").equals("INTERNATIONAL") && getData("BeneCurrency").equals("SAR")) {
                            vTxnAmt2 = vTransfAmt4;
                        }else {
                            Double TxnAmt = Double.parseDouble(getData("TotalTxnAmount"));//Based on Domestic(KSA) And International
                            Double CredtAmt = Double.parseDouble(getData("CreditAmount"));//Based on Internal(Within Meem)
                            vTxnAmt = dformat.format(TxnAmt);
                            vCredtAmt = dformat.format(CredtAmt);
                        }
                        //System.out.println(cTxnAmt2+" "+vCredAmt);
                        if (cTxnAmt2.equals(vTxnAmt) || cTxnAmt2.equals(vTxnAmt2) || cTxnAmt2.equals(vCredtAmt)) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Transaction Details displayed in the screen correctly");
                            String gRefNum = getText(po_RDI_IB.TextArea_TxnReferenceNumber);
                            saveTestDataToDb("UBS_ReferenceNumber",gRefNum);
                            TxnFlag=true;
                            break;
                        }
                    }
                }

                if (TxnFlag=false) {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction Details displayed in the screen is not successful");
                }
            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL, "Account Transaction displayed in the screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Verification of account balance failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Goal_Create
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/
    public static String getmonth(String monthval)
    {
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        String month=monthName[Integer.parseInt(monthval)-1];
        return month;
    }

    public static void Goal_Create() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");

            Select_MenuItem("YOUR BUDGET");
            click(po_RDI_IB.Button_CreateNewGoal);
            waitFor(3000);

            if (elemExist(po_RDI_IB.Input_GoalName)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"New Saving Plan displayed in the screen successfully");

                driver.findElement(By.xpath("//div[@class='viewport']/ul/li[@id='"+getData("GoalIcon")+"']/img")).click();
                sendKeys(po_RDI_IB.Input_GoalName,getData("GoalName"));
                sendKeys(po_RDI_IB.Input_TotalSavingAmount,getData("TotalSavingAmount"));
                sendKeys(po_RDI_IB.Input_ThreshHoldAmount,getData("ThreshHoldAmount"));
                driver.findElement(By.xpath("//li[@id='"+getData("VIA")+"']")).click();

                String []Sp_StartDate = getData("StartDate").split("/");
                String vDate1 = Sp_StartDate[0];
                String vMonth1 = getmonth(Sp_StartDate[1]);
                System.out.println(vMonth1);
                String vYear1 = Sp_StartDate[2];
                click(po_RDI_IB.Input_StartDate);
                Select Month1 = new Select(po_RDI_IB.Select_CalendarMonth);
                Month1.selectByVisibleText(vMonth1);
                Select Year1 = new Select(po_RDI_IB.Select_CalendarYear);
                Year1.selectByVisibleText(vYear1);
                driver.findElement(By.xpath("//div[@class='calendars-month']//tr/td/a[contains(.,'"+vDate1+"')]")).click();

                String []Sp_EndDate = getData("EndDate").split("/");
                String vDate2 = Sp_EndDate[0];
                String vMonth2 = getmonth(Sp_EndDate[1]);
                System.out.println(vMonth2);
                String vYear2 = Sp_EndDate[2];
                click(po_RDI_IB.Input_EndDate);
                Select Month2 = new Select(po_RDI_IB.Select_CalendarMonth);
                Month2.selectByVisibleText(vMonth2);
                Select Year2 = new Select(po_RDI_IB.Select_CalendarYear);
                Year2.selectByVisibleText(vYear2);
                driver.findElement(By.xpath("//div[@class='calendars-month']//tr/td/a[contains(.,'"+vDate2+"')]")).click();
                waitFor(1000);

                driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceHolder2_upFrequency']//li[contains(.,'"+getData("UpFrequency")+"')]")).click();
                ReportHelper.logReportStatus(LogStatus.PASS,"Goal details entered successfully");

                int ArrDown = 5;
                for (int i=1;i<ArrDown;i++){
                    click(po_RDI_IB.Button_GoalArrowDown);
                }
                click(po_RDI_IB.Button_Confirm);
                waitFor(5000);

                String SuccMsg = getText(po_RDI_IB.WebElement_GoalSuccessfulMessage);
                if (SuccMsg.equals("YOU HAVE SUCCESSFULLY CREATED A NEW SAVING GOAL")) {
                    ReportHelper.logReportStatus(LogStatus.PASS,SuccMsg);
                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,SuccMsg);
                }

            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"New Saving Plan displayed in the screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Goal creation failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Goal_Delete
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Goal_Delete() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");

            Select_MenuItem("YOUR BUDGET");

            int SavCnt = po_RDI_IB.Table_SavingInfo.size();
            boolean SFlag;
            SFlag=false;
            for (int i=1;i<SavCnt+1;i++){
                System.out.println(po_RDI_IB.Table_SavingInfo.get(i-1).getText() +"   "+getData("GoalName"));
                if(getData("GoalName").equals(po_RDI_IB.Table_SavingInfo.get(i-1).getText())) {
                    hover(po_RDI_IB.Table_SavingInfo.get(i-1));
                    i=i+1;
                    //System.out.println(i);
                    driver.findElement(By.xpath("//div[@class='jspPane']/div["+i+"]//a[@id='deleteIcon']")).click();
                    waitFor(2000);
                    ReportHelper.logReportStatus(LogStatus.PASS,"Are you sure that you want to delete your goal? Yes/No");
                    driver.findElement(By.xpath("//div[@class='jspPane']/div["+i+"]//a[contains(.,'yes')]")).click();
                    SFlag=true;
                    break;
                }
            }

            waitFor(8000);
            if (SFlag=true) {
                ReportHelper.logReportStatus(LogStatus.PASS,"Goal details deleted successfully");
            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"Goal details deleted is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Deletion of goal failed due to '"+e.getMessage()+"'");
        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : SI_SetUp
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void SI_SetUp() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");

            Select_MenuItem("TRANSFER");
            click(po_RDI_IB.Menu_Beneficiaries);
            waitFor(4000);

            int iBene = po_RDI_IB.Table_Beneficiaries.size();
            boolean bFlag;
            bFlag = false;
            for (int i=1;i<iBene+1;i++) {
                String gBeneName = driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]//div/h6[1]/p")).getText();
                String gBeneStatus = driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]//div/h6[3]/p")).getText();
                if (gBeneName.equals(getData("BeneName")) && gBeneStatus.equals("ACTIVE")) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"'"+gBeneName+"' displayed in the summary list successfully");
                    driver.findElement(By.xpath("//div[@id='BeneficiaryList']//ul/li["+i+"]")).click();
                    bFlag=true;
                    break;
                }
            }

            waitFor(5000);
            if (bFlag=true && elemExist(po_RDI_IB.Button_SetUpStandingInstr)) {
                ReportHelper.logReportStatus(LogStatus.PASS,"'"+getData("BeneName")+"' Details displayed successfully");
                click(po_RDI_IB.Button_SetUpStandingInstr);
                waitFor(3000);

                if (elemExist(po_RDI_IB.Input_SI_Amount)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"New Standing Instruction displayed in the screen successfully");

                    sendKeys(po_RDI_IB.Input_SI_Amount,getData("SI_Amount"));
                    click(po_RDI_IB.Button_MeemOnePack);
                    driver.findElement(By.xpath("//ul[@class='freq']/li[contains(text(),'"+getData("Frequency")+"')]")).click();

                    String []Sp_StartDate = getData("StartDate").split("/");
                    String vDate1 = Sp_StartDate[0];
                    String vMonth1 = getmonth(Sp_StartDate[1]);
                    System.out.println(vMonth1);
                    String vYear1 = Sp_StartDate[2];
                    click(po_RDI_IB.Input_StartDate);
                    Select Month1 = new Select(po_RDI_IB.Select_CalendarMonth);
                    Month1.selectByVisibleText(vMonth1);
                    Select Year1 = new Select(po_RDI_IB.Select_CalendarYear);
                    Year1.selectByVisibleText(vYear1);
                    driver.findElement(By.xpath("//div[@class='calendars-month']//tr/td/a[contains(.,'"+vDate1+"')]")).click();

                    String []Sp_EndDate = getData("EndDate").split("/");
                    String vDate2 = Sp_EndDate[0];
                    String vMonth2 = getmonth(Sp_EndDate[1]);
                    System.out.println(vMonth2);
                    String vYear2 = Sp_EndDate[2];
                    click(po_RDI_IB.Input_EndDate);
                    Select Month2 = new Select(po_RDI_IB.Select_CalendarMonth);
                    Month2.selectByVisibleText(vMonth2);
                    Select Year2 = new Select(po_RDI_IB.Select_CalendarYear);
                    Year2.selectByVisibleText(vYear2);
                    driver.findElement(By.xpath("//div[@class='calendars-month']//tr/td/a[contains(.,'"+vDate2+"')]")).click();
                    waitFor(1000);
                    ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instruction details entered successfully");
                    click(po_RDI_IB.Button_Confirm);

                    waitFor(5000);
                    Select CategoryPaymt = new Select(po_RDI_IB.Select_PurposeOfCategoryPaymt);
                    CategoryPaymt.selectByValue(getData("PurposeOfCategoryPaymt"));
                    waitFor(2000);
                    Select Payment = new Select(po_RDI_IB.Select_PurposeOfPayment);
                    Payment.selectByValue(getData("PurposeOfPayment"));
                    waitFor(1000);
                    ReportHelper.logReportStatus(LogStatus.PASS,"Payment details entered successfully");
                    click(po_RDI_IB.Button_ConfirmProceed);
                    waitFor(2000);

                    if (elemExist(po_RDI_IB.Button_ConfirmTxn)) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Transaction details displayed successfully");
                        click(po_RDI_IB.Button_ConfirmTxn);
                        waitFor(1000);

                        if (elemExist(po_LoginPage.Input_AuthenticationCode)) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Authentication code displayed successfully");
                            sendKeys(po_LoginPage.Input_AuthenticationCode,FetchOTP.getOTP());
                            waitFor(3000);
                            ReportHelper.logReportStatus(LogStatus.PASS,"Transfer amount details displayed correctly");
                            click(po_RDI_IB.Button_ConfirmAgreemnt);
                        } else if (elemExist(po_RDI_IB.Button_ConfirmAgreemnt)) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Transfer amount details displayed correctly");
                            click(po_RDI_IB.Button_ConfirmAgreemnt);
                        } else {
                            ReportHelper.logReportStatus(LogStatus.FAIL,"Transfer amount details displayed is not successful");
                        }

                        waitFor(6000);
                        String TxnMsg = getText(po_RDI_IB.WebElement_BenefSuccessfulMessage);
                       /* System.out.println(TxnMsg);
                        System.out.println("YOUR STANDING INSTRUCTION REQUEST FOR SAR "+getData("SI_Amount")+" PAYABLE DAILY HAS BEEN SETUP");*/
                        if (TxnMsg.contains("YOUR STANDING INSTRUCTION REQUEST FOR SAR "+getData("SI_Amount")+" PAYABLE DAILY HAS BEEN SETUP")) {
                            ReportHelper.logReportStatus(LogStatus.PASS,TxnMsg);
                            click(po_RDI_IB.Button_OK);
                        } else {
                            ReportHelper.logReportStatus(LogStatus.FAIL,TxnMsg);
                        }

                    }else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Transaction details displayed is not successful");
                    }

                }else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"New Standing Instruction displayed in the screen is not successful");
                }
            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,"New Standing Instruction displayed in the screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction Setup failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : SI_Verify
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void SI_Verify() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);

            if (elemExist(po_RDI_IB.WebElement_MeemOnePackAccount)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");
                click(po_RDI_IB.WebElement_MeemOnePackAccount);
                waitFor(3000);

                if (elemExist(po_RDI_IB.SubMenu_StandingInstruction)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instruction displayed in the submenu successfully");
                    click(po_RDI_IB.SubMenu_StandingInstruction);
                    waitFor(2000);

                    ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instructions displayed in the transaction details screen successfully");
                    Select TxnList = new Select(po_RDI_IB.Select_TransactionList);
                    TxnList.selectByVisibleText(getData("TransactionList"));
                    waitFor(3000);

                    click(po_RDI_IB.Button_SIArrowDown);
                    int TxnLst = po_RDI_IB.Table_TransactionList.size();
                    boolean TxnFlg;
                    TxnFlg=false;
                    for (int i=1;i<TxnLst;i++) {
                        String BeneName = driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[@class='left']/h3")).getText();
                        String TxnVal = driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[2]/h1/p")).getText().trim();
/*                        System.out.println(BeneName +"        "+getData("FullName"));
                        System.out.println(TxnVal+"       "+getData("SI_Amount"));*/
                        if (getData("FullName").equals(BeneName) && TxnVal.equals(getData("SI_Amount"))) {
                            ReportHelper.logReportStatus(LogStatus.PASS,"Successful Transaction status displayed in the details");
                            TxnFlg=true;
                            break;
                        }
                        click(po_RDI_IB.Button_SIArrowDown);
                    }

                    if (TxnFlg=false) {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Successful Transaction status displayed is not found in the details");
                    }

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction displayed in the submenu is not successful");
                }

            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL, "Account summary displayed in the screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Verification of Standing Instruction failed due to '"+e.getMessage()+"'");
        }


    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : SI_Delete
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void SI_Delete() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);

            if (elemExist(po_RDI_IB.WebElement_MeemOnePackAccount)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");
                click(po_RDI_IB.WebElement_MeemOnePackAccount);
                waitFor(3000);

                if (elemExist(po_RDI_IB.SubMenu_StandingInstruction)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instruction displayed in the submenu successfully");
                    click(po_RDI_IB.SubMenu_StandingInstruction);
                    waitFor(2000);

                    ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instructions displayed in the transaction details screen successfully");
                    Select TxnList = new Select(po_RDI_IB.Select_TransactionList);
                    TxnList.selectByVisibleText(getData("TransactionList"));
                    waitFor(3000);

                    click(po_RDI_IB.Button_SIArrowDown);
                    int TxnLst = po_RDI_IB.Table_TransactionList.size();
                    boolean TxnFlg;
                    TxnFlg=false;
                    for (int i=1;i<TxnLst;i++) {
                        String BeneName = driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[@class='left']/h3")).getText();
                        String TxnVal = driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[2]/h1/p")).getText().trim();
                        if (getData("FullName").equals(BeneName) && TxnVal.equals(getData("SI_Amount"))) {
                            driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[@class='left']")).click();
                            waitFor(1000);
                            ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instruction Delete button displayed successfully");
                            driver.findElement(By.xpath("//ul[@class='rows']/li["+i+"]/div[@class='buttons']//a[1]")).click();
                            TxnFlg=true;
                            break;
                        }
                        click(po_RDI_IB.Button_SIArrowDown);
                    }

                    if (TxnFlg=true && elemExist(po_RDI_IB.WebElement_MeemOnePackAccount) ) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Standing Instruction details deleted successfully");
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction details deleted is not successful");
                    }

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Standing Instruction displayed in the submenu is not successful");
                }

            }else {
                ReportHelper.logReportStatus(LogStatus.FAIL, "Account summary displayed in the screen is not successful");
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Verification of Standing Instruction failed due to '"+e.getMessage()+"'");
        }

    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : MFCA_Create
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void MFCA_Create() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");

            Select_MenuItem("PRODUCTS");
            click(po_RDI_IB.SubMenu_CurrenciesCard);

            if (elemExist(po_RDI_IB.Title_CurrenciesCard)) {
                ReportHelper.logReportStatus(LogStatus.PASS, "Currencies Card displayed in the screen successfully");
                String gCcy = getData("Currencies");
                String Sp_Ccy[] = gCcy.split(";");
                int CcyCnt = Sp_Ccy.length;
                //int CcyCnt = po_RDI_IB.Table_Currency.size();
                for (int i=0;i<CcyCnt;i++) {
                    driver.findElement(By.xpath("//div[@id='dvCurrencies']//li[contains(.,'"+Sp_Ccy[i]+"')]")).click();
                }

                driver.findElement(By.xpath("//div[@id='baseCurr']//li[contains(.,'"+getData("BaseCurrency")+"')]")).click();
                driver.findElement(By.xpath("//div[@class='statement']//li[contains(.,'"+getData("E_Statement")+"')]")).click();
                driver.findElement(By.xpath("//div[@class='delivery-option']//li[contains(.,'"+getData("DeliveryOption")+"')]")).click();
                ReportHelper.logReportStatus(LogStatus.PASS, "Currencies Card fields entered successfully");

                click(po_RDI_IB.Button_AddNewProduct);
                waitFor(2000);

                click(po_RDI_IB.Button_OTPSentMobile);
                waitFor(2000);

                sendKeys(po_LoginPage.Input_AuthenticationCode, FetchOTP.getOTP());
                ReportHelper.logReportStatus(LogStatus.PASS,"OTP Code entered successfully");
                click(po_RDI_IB.Button_OTPConfirm);
                waitFor(3000);

                if (elemExist(po_RDI_IB.Button_Accept)) {
                    ReportHelper.logReportStatus(LogStatus.PASS,"Currencies card details displayed correctly");
                    click(po_RDI_IB.Button_Accept);
                    waitFor(20000);
/*                    String loginType=DriverHelper.environmentURL;
                    String loginType1 = loginCredentials(loginType)[0];*/
                    if (elemExist(driver.findElement(By.xpath("//div/h3[contains(text(),'Currencies Card')]")))) {
                        ReportHelper.logReportStatus(LogStatus.PASS,"Newly created MFCA account added in the summary list successfully");
                    } else {
                        ReportHelper.logReportStatus(LogStatus.FAIL,"MFCA account created is not successful");
                    }

                } else {
                    ReportHelper.logReportStatus(LogStatus.FAIL,"Currencies card details displayed is not successful");
                }
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Creation of currencies card failed due to '"+e.getMessage()+"'");

        }
    }

    /**********************************************************************************************************************************/
    /*
     * Function Name : Card_ReIssuance
     * Description    :
     * Designed Date:
     * Updated Date :
     * @throws  Exception
     *********************************************************************************************************************************/

    public static void Card_ReIssuance() {

        try {
            initPageObjects();
            getLatestDriver();

            WebDriver driver = getLatestDriver();
            switchDFrame(1);
            waitFor(2000);
            ReportHelper.logReportStatus(LogStatus.PASS, "Account summary displayed in the screen successfully");

            if (getData("AccountType").equals("MeemOnePack")) {
                click(po_RDI_IB.WebElement_MeemOnePackAccount);
                waitFor(3000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Meem OnePack displayed in the details successfully");
                click(po_RDI_IB.WebELement_OP_ATMCard);
            } else if (getData("AccountType").equals("CurrenciesCard")) {
                //div/h3[contains(text(),'1040674291')]
                String loginType=DriverHelper.environmentURL;
                String loginType1 = loginCredentials(loginType)[0];
                driver.findElement(By.xpath("//div/h3[contains(text(),'"+loginType1+"')]")).click();
                waitFor(3000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Currencies Card displayed in the details successfully");
                click(po_RDI_IB.WebELement_MFCA_ActivateCard);
            } else if (getData("AccountType").equals("CreditCard")) {
                click(po_RDI_IB.WebElement_CreditCardAccount);
                waitFor(3000);
                ReportHelper.logReportStatus(LogStatus.PASS,"Credit Card details displayed in the screen successfully");
                click(po_RDI_IB.WebELement_CC_CashBackDetails);
                waitFor(1000);
                click(po_RDI_IB.WebELement_CC_StopCard);
            }

            ReportHelper.logReportStatus(LogStatus.PASS,"Card Block details displayed successfully");
            click(po_RDI_IB.Button_CardBlock);
            waitFor(2000);

            driver.findElement(By.xpath("//ul[@id='reason']/li[contains(text(),'"+getData("BlockCardReason")+"')]")).click();
            waitFor(1000);
            if (getData("AccountType").equals("MeemOnePack") || getData("AccountType").equals("CreditCard")) {
                int ArrDown = 10;
                for (int i=1;i<ArrDown;i++){
                    click(po_RDI_IB.Button_GoalArrowDown);
                }
                driver.findElement(By.xpath("//div[@id='divDeliveryOptions']//li[contains(.,'" + getData("DeliverCard") + "')]")).click();
            } else {
                driver.findElement(By.xpath("//div[@id='divDeliveryOptions']//li[contains(.,'" + getData("DeliverCard") + "')]")).click();
            }

            if (getData("AccountType").equals("CreditCard")) {
                sendKeys(po_RDI_IB.Input_CC_NewCardPin,getData("NewCardPin"));
                sendKeys(po_RDI_IB.Input_CC_ConfirmNewPin,getData("ConfirmNewPin"));
            }

            ReportHelper.logReportStatus(LogStatus.PASS,"Card Block details entered successfully");
            click(po_RDI_IB.Button_ConfirmCardBlock);
            waitFor(25000); // need to be modified (loading object)

            String IssuMsg = getText(po_RDI_IB.WebElement_BenefSuccessfulMessage);
            if (IssuMsg.contains(getData("CardSuccessMessage"))) {
                ReportHelper.logReportStatus(LogStatus.PASS,IssuMsg);
                click(po_RDI_IB.Button_OK);
            } else {
                ReportHelper.logReportStatus(LogStatus.FAIL,IssuMsg);
            }

        } catch (Exception e) {
            ReportHelper.logReportStatus(LogStatus.FAIL,"Card ReIssuance failed due to '"+e.getMessage()+"'");
        }

    }

}
