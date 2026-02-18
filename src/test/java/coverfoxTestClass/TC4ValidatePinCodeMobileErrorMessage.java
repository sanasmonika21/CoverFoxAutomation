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

public class TC4ValidatePinCodeMobileErrorMessage extends Base {
	public static Logger logger;

	CoverfoxHomePage homePage;
	CoverfoxHealthPlan healthPlanPage;
	CoverfoxMembersDetails memberDetailsPage;
	AddressDetailsPage addressDetailsPage;
	ResultPage resultPage;
	String excelpath = System.getProperty("user.dir") + "\\userData.xlsx";
	String sheetName = "Sheet1";



	@BeforeMethod(alwaysRun = true)
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException {
		launchBrowser();
		logger = Logger.getLogger("8thJune2024");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Openeing Application");
		
		homePage = new CoverfoxHomePage(driver);
		healthPlanPage = new CoverfoxHealthPlan(driver);
		memberDetailsPage = new CoverfoxMembersDetails(driver);
		addressDetailsPage = new AddressDetailsPage(driver);
		resultPage = new ResultPage(driver);

		homePage.clickOnMaleButton();
		logger.info("Clicking on male gender button");
		Thread.sleep(1000);

		healthPlanPage.clickOnNextButton();
		logger.info("Clicking on geneder Next button");
		Thread.sleep(1000);

		memberDetailsPage.selectYourAge(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 1));
		logger.info("Handling Age dropdown");
		memberDetailsPage.clickOnNextButton();
		logger.info("Clicking on next button");
		Thread.sleep(1000);

	}

	@Test(priority = -1, groups = {"health","policyPlan"})
	public void validatePinCodeErrMessage() throws EncryptedDocumentException, IOException {
		logger.info("Entering mobile number");
		addressDetailsPage.enterMobileNumber(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 3));

		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking on continue button logger");
		String actualPinCodeErrMessage = addressDetailsPage.validatePinErrMessage();
		String expectedPinCodeErrMessage = UtilityMethods.readDataFromExcel(excelpath, sheetName, 0, 4);
		Assert.assertEquals(actualPinCodeErrMessage, expectedPinCodeErrMessage,actualPinCodeErrMessage+" and "+expectedPinCodeErrMessage+" are not matching");
	}
	@Test(groups = {"health"})
	public void validateMobileNumberCodeErrMessage() throws EncryptedDocumentException, IOException {
		addressDetailsPage.enterYourPincode(UtilityMethods.readDataFromExcel(excelpath, sheetName, 2, 2)); 
		logger.info("entering pincode logger");
		logger.warn("enter valid pincode");
		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking on continue button logger");
		String actualMobileNumberErrMessage = addressDetailsPage.validateMobNoErrMessage();
		String expectedMobileNumberErrMessage = UtilityMethods.readDataFromExcel(excelpath, sheetName, 1, 4);
		Assert.assertEquals(actualMobileNumberErrMessage, expectedMobileNumberErrMessage,actualMobileNumberErrMessage+" and "+expectedMobileNumberErrMessage+" are not matching");
	}
	
	@AfterMethod(alwaysRun = true)
	public void closingApplication() {
		logger.info("closing browser logger");
		Reporter.log("Closing Application....", true);
		closeBrowser();
	}
}
