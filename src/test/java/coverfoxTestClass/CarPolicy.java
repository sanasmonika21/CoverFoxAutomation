package coverfoxTestClass;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import coverfoxBase.Base;
import coverfoxPOM.CarInsurrancePage;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxUtility.UtilityMethods;

public class CarPolicy extends Base {
	public static Logger logger;

	CoverfoxHomePage homePage;
	CarInsurrancePage carInssurance;
	String excelPath = System.getProperty("user.dir") + "\\userData.xlsx";
	String sheetName = "carDetails";

	@BeforeMethod(alwaysRun = true)
	public void clickOnCarButton() throws IOException {
		launchBrowser();
		logger = Logger.getLogger("8thJune2024");
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Opening Application...");
		homePage = new CoverfoxHomePage(driver);
		homePage.clickOnCarButton();
		logger.info("Clicking on car button");
	}

	@Test(groups = { "car" })
	public void validateErrorMessageIfCarNumDetails() throws EncryptedDocumentException, IOException {
		carInssurance = new CarInsurrancePage(driver);
		carInssurance.clickOnviewQuotesButton();

		String expectedValidationMessage = UtilityMethods.readDataFromExcel(excelPath, sheetName, 1, 1);
		String actualValidationMessage = carInssurance.gettingValidationMessage();
		Reporter.log(actualValidationMessage, true);
		Reporter.log(expectedValidationMessage, true);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualValidationMessage, expectedValidationMessage,
				expectedValidationMessage + " and " + actualValidationMessage + " are not matching");
		Reporter.log("[tejas] updated");
		softassert.assertAll();
	}

	@Test(groups = { "car" })
	public void validateErrorMessageOnInvalidCarNumber() throws EncryptedDocumentException, IOException {
		carInssurance = new CarInsurrancePage(driver);
		carInssurance.enterCarNumber(UtilityMethods.readDataFromExcel(excelPath, sheetName, 2, 0));

		carInssurance.clickOnviewQuotesButton();

		String expectedValidationMessage = UtilityMethods.readDataFromExcel(excelPath, sheetName, 2, 1);
		String actualValidationMessage = carInssurance.gettingInvalidcarNumValidationMessage();

		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(actualValidationMessage, expectedValidationMessage,
				expectedValidationMessage + " and " + actualValidationMessage + " are not matching");

		softassert.assertAll();
	}

	@Test(groups = { "car", "policyPlan" })
	public void gettingPlansWithoutCarNumber() {
		carInssurance = new CarInsurrancePage(driver);
		logger.info("Clicking on Dont have car number Click here link");
		carInssurance.ClickHereLinkDontKnowCarNumber();
	}

	@Test
	public void gettingPlansNewCar() {
		carInssurance = new CarInsurrancePage(driver);
		logger.info("Clicking on Bought new car Click here link");
		carInssurance.ClickHereLinkBoughtNewCar();
	}

	@AfterMethod(alwaysRun = true)
	public void logOut() {
		Reporter.log("Logging Out", true);
		Reporter.log("Closing Browser", true);
		closeBrowser();
	}
}
