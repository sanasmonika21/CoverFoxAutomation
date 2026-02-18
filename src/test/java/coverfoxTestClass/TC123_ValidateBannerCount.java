package coverfoxTestClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coverfoxBase.Base;
import coverfoxPOM.AddressDetailsPage;
import coverfoxPOM.CoverfoxHealthPlan;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxPOM.CoverfoxMembersDetails;
import coverfoxPOM.ResultPage;
import coverfoxUtility.UtilityMethods;

public class TC123_ValidateBannerCount extends Base {
	CoverfoxHomePage homePage;
	CoverfoxHealthPlan healthPlanPage;
	CoverfoxMembersDetails memberDetailsPage;
	AddressDetailsPage addressDetailsPage;
	ResultPage resultPage;
	String excelpath = System.getProperty("user.dir") + "\\userData.xlsx";
	String sheetName = "Sheet1";

	/*
	 * @Parameters("browserName")
	 * 
	 * @BeforeClass public void openApplication(String browser) throws IOException {
	 * launchBrowser(browser); }
	 */
	@BeforeClass
	public void openApplication() throws IOException {
		launchBrowser();
	}

	@BeforeMethod
	public void enterDetails() throws InterruptedException, EncryptedDocumentException, IOException {
		homePage = new CoverfoxHomePage(driver);
		healthPlanPage = new CoverfoxHealthPlan(driver);
		addressDetailsPage = new AddressDetailsPage(driver);
		resultPage = new ResultPage(driver);

		homePage.clickOnMaleButton();
		Thread.sleep(1000);

		healthPlanPage.clickOnFemaleButton();
		healthPlanPage.clickonFatherButton();
		healthPlanPage.clickOnHusbandButton();
		healthPlanPage.clickonFatherButton();
		healthPlanPage.clickOnDaughterButton();
		healthPlanPage.clickOnSonButton();
		healthPlanPage.clickOnMotherButton();
		healthPlanPage.clickOnNextButton();
		Thread.sleep(1000);

		memberDetailsPage = new CoverfoxMembersDetails(driver);
		memberDetailsPage.clickOnEditButton();
		Thread.sleep(1000);

		healthPlanPage.clickonFatherButton();
		Thread.sleep(1000);
		healthPlanPage.clickOnNextButton();
		Thread.sleep(500);

		memberDetailsPage.selectYourAge(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 1));
		memberDetailsPage.selectYourHusbandAge(excelpath, sheetName, 2, 1);
		memberDetailsPage.selectYourDaughterAge(excelpath, sheetName, 3, 1);
		memberDetailsPage.selectYourSonAge(excelpath, sheetName, 4, 1);
		memberDetailsPage.selectYourFatherAge(excelpath, sheetName, 5, 1);
		memberDetailsPage.selectYourMotherAge(excelpath, sheetName, 6, 1);
		Thread.sleep(500);

		memberDetailsPage.clickOnNextButton();
		Thread.sleep(1000);

		addressDetailsPage.enterYourPincode(UtilityMethods.readDataFromExcel(excelpath, sheetName, 1, 2));
		addressDetailsPage.enterParentsPincode(UtilityMethods.readDataFromExcel(excelpath, sheetName, 5, 2));
		addressDetailsPage.enterMobileNumber(UtilityMethods.readDataFromExcel(excelpath, sheetName, 1, 3));
		Thread.sleep(1000);
		addressDetailsPage.clickOnContinueButton();
		
	}

	@Test
	public void validateBannerCountSelectAllMemt() throws InterruptedException {
		Reporter.log("Test method is running ", true);
		Thread.sleep(5000);
		int acttualResult = resultPage.gettingPolicyCount();
		int expectedresult = resultPage.gettingBannerCountList();

		Assert.assertEquals(acttualResult, expectedresult,
				+acttualResult + "actual count and expected count" + expectedresult + "results are not matching");
		
	}

	@AfterClass
	public void closeApplication() {
		Reporter.log("Close Application", true);
		closeBrowser();
	}
}
