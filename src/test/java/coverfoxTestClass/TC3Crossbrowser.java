package coverfoxTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coverfoxBase.BaseCBTTest1;
import coverfoxPOM.AddressDetailsPage;
import coverfoxPOM.CoverfoxHealthPlan;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxPOM.CoverfoxMembersDetails;
import coverfoxPOM.ResultPage;
import coverfoxUtility.UtilityMethods;

public class TC3Crossbrowser extends BaseCBTTest1 {

	CoverfoxHomePage homePage;
	CoverfoxHealthPlan healthPlanPage;
	CoverfoxMembersDetails memberDetailsPage;
	AddressDetailsPage addressDetailsPage;
	ResultPage resultPage;
	String excelpath = System.getProperty("user.dir") + "\\userData.xlsx";
	String sheetName = "Sheet1";

	@Parameters("browser")
	@BeforeClass
	public void OpenApplication(String browser) throws IOException {
		launchBrowser(browser);
	}

	
	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		homePage = new CoverfoxHomePage(driver);
		healthPlanPage = new CoverfoxHealthPlan(driver);
		memberDetailsPage = new CoverfoxMembersDetails(driver);
		addressDetailsPage = new AddressDetailsPage(driver);
		resultPage = new ResultPage(driver);

		homePage.clickOnMaleButton();
		Thread.sleep(1000);

		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);

		memberDetailsPage.selectYourAge(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 1));
		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);

		addressDetailsPage.enterYourPincode(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 2));
		addressDetailsPage.enterMobileNumber(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 3));
		addressDetailsPage.clickOnContinueButton();

	}

	@Test
	public void validateBennarCountCrossBrowser() throws InterruptedException {
		Thread.sleep(5000);
		int actualResult = resultPage.gettingPolicyCount();
		int expectedResult = resultPage.gettingBannerCountList();
		Reporter.log("Actual Result : " + actualResult, true);
		Reporter.log("Expected Result : " + expectedResult, true);
		Assert.assertEquals(actualResult, expectedResult, "Actual result and expected Results are not matching");
	}

	@AfterMethod
	public void logOut() {
		Reporter.log("Log out", true);
	}

	@AfterClass
	public void closingApplication() {
		Reporter.log("Closing Application....", true);
		closeBrowser();
	}

}
