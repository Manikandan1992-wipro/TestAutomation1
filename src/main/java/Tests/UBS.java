package Tests;

import FrameWork.helpers.DriverHelper;
import FrameWork.helpers.Helper;
import FrameWork.helpers.ReportHelper;
import Tests.testSteps.st_UBS;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class UBS extends DriverHelper {

	@BeforeClass()
	public void LoadDataTestCase() throws Exception {
		Helper.GetDatasource();
		ReportHelper.getgenarateLogTestStart();
	}


	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void fundTransfer_Validate(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.fundTransfer_Validate();
	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void International_Transfer(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.internationalTransfer();
	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void DomesticTransfer_KSA(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.DomesticTransfer_KSA();
	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void InternationalTransfer_KSA(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.InternationalTransfer_KSA();
	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void DomesticTransfer_BAH(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.DomesticTransfer_BAH();
	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void International_Transfer_BAH(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.internationalTransfer_BAH();

	}

	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void International_Transfer_UAE(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.internationalTransfer_UAE();
	}
	@Parameters({"browser", "dataBinder"})
	@Test(testName = "Fund Transfer Validation", priority = 1, enabled = true, description = "Fund Transfer Validation")
	public void DomesticTransfer_UAE(String browser, String dataBinder, @Optional Method method, @Optional ITestContext iTestContext) throws Throwable {
		st_UBS.DomesticTransfer_UAE();
	}



	@AfterClass
	public void close() throws Exception {
	//closeReportAndDriver();
	}

}
