package coverfoxTestClass;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverfoxBase.Base;
import coverfoxPOM.AddressDetailsPage;
import coverfoxPOM.CoverfoxHealthPlan;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxPOM.CoverfoxMembersDetails;
import coverfoxPOM.ResultPage;
import coverfoxUtility.UtilityMethods;

public class TC2ValidateBannerCount extends Base {
	public static Logger logger;
	
	CoverfoxHomePage homePage;
	CoverfoxHealthPlan healthPlanPage;
	CoverfoxMembersDetails memberDetailsPage;
	AddressDetailsPage addressDetailsPage;
	ResultPage resultPage;
	String excelpath = System.getProperty("user.dir") + "\\userData.xlsx";
	String sheetName = "Sheet1";
	

	@BeforeClass
	public void openApplication() throws IOException {
		launchBrowser();
		logger = Logger.getLogger("8thJune2024");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Openeing Application");
	}

	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		homePage = new CoverfoxHomePage(driver);
		healthPlanPage = new CoverfoxHealthPlan(driver);
		memberDetailsPage = new CoverfoxMembersDetails(driver);
		addressDetailsPage = new AddressDetailsPage(driver);
		resultPage = new ResultPage(driver);

		homePage.clickOnMaleButton();
		logger.info("Clicking on geneder button logger");
		Thread.sleep(1000);

		healthPlanPage.clickOnNextButton();
		logger.info("Clicking on geneder Next logger");
		Thread.sleep(1000);

		memberDetailsPage.selectYourAge(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 1));
		logger.info("Handling Age dropdown logger");
		memberDetailsPage.clickOnNextButton();
		logger.info("Clicking on next button logger");
		Thread.sleep(1000);

		addressDetailsPage.enterYourPincode(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 2));
		logger.info("entering pincode logger");
		logger.warn("enter valid pincode");
		addressDetailsPage.enterMobileNumber(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 3));
		logger.info("entering mobile number logger");
		logger.warn("enter valid mobile");
		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking on continue button logger");
		logger.error("check detals again");
	}

	@Test
	public void validateBannerCountSelectOneMem() throws InterruptedException {
		Thread.sleep(5000);
		int actualResult = resultPage.gettingPolicyCount();
		int expectedResult = resultPage.gettingBannerCountList();
		Reporter.log("Actual Result : " + actualResult, true);
		Reporter.log("Expected Result : " + expectedResult, true);
		logger.info("Validating results logger");
		Assert.assertEquals(actualResult, expectedResult, "Actual result and expected Results are not matching");
			
	}

	@AfterMethod
	public void logOut() {
		Reporter.log("Log out", true);
	}

	@AfterClass
	public void closingApplication() {
		logger.info("closing browser logger");
		Reporter.log("Closing Application....", true);
		closeBrowser();
	}
}
