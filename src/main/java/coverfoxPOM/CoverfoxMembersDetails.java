package coverfoxPOM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import coverfoxUtility.DropDownUtility;
import coverfoxUtility.UtilityMethods;

public class CoverfoxMembersDetails {
	@FindBy(xpath = "//div[contains(text(),'the ages of your')]")
	private WebElement mainHeading;

	@FindBy(xpath = "//img[@src='/static/img/icons/ic_edit.svg']")
	private WebElement editButton;

	@FindBy(xpath = "//select[@name='You']")
	private WebElement dropdownYou;

	@FindBy(xpath = "//select[@name='Spouse']")
	private WebElement dropdownSpouse;

	@FindBy(xpath = "//select[@name='Son']")
	private WebElement dropdownSon;

	@FindBy(xpath = "//select[@name='Daughter']")
	private WebElement dropdownDaughter;

	@FindBy(xpath = "//select[@name='Mother']")
	private WebElement dropdownMother;

	@FindBy(xpath = "//select[@name='Father']")
	private WebElement dropdownFather;

	@FindBy(xpath = "//div[@class='next-btn']")
	private WebElement nextButton;

	public CoverfoxMembersDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String gettingMainHeading() {
		Reporter.log("getting main heading", true);
		return mainHeading.getText();
	}

	public void clickOnEditButton() {
		Reporter.log("Clicking on edit button", true);
		editButton.click();
	}

	public void selectYourAge(String age) throws EncryptedDocumentException, IOException {
		Reporter.log("Selecting your age......", true);
		DropDownUtility.selectByContainsVisibleText(dropdownYou, age);
	}

	public void selectYourHusbandAge(String filePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		Reporter.log("Selecting your husband age ", true);
		DropDownUtility.selectByContainsVisibleText(dropdownSpouse,
				UtilityMethods.readDataFromExcel(filePath, sheetName, rowNumber, cellNumber));
	}

	public void selectYourSonAge(String filePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		Reporter.log("Selecting your Son Age ", true);
		DropDownUtility.selectByContainsVisibleText(dropdownSon,
				UtilityMethods.readDataFromExcel(filePath, sheetName, rowNumber, cellNumber));
	}

	public void selectYourDaughterAge(String filePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		Reporter.log("Selecting your Daughther age ", true);
		DropDownUtility.selectByContainsVisibleText(dropdownDaughter,
				UtilityMethods.readDataFromExcel(filePath, sheetName, rowNumber, cellNumber));
	}

	public void selectYourFatherAge(String filePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		Reporter.log("selecting your Father age ", true);
		DropDownUtility.selectByContainsVisibleText(dropdownFather,
				UtilityMethods.readDataFromExcel(filePath, sheetName, rowNumber, cellNumber));
	}

	public void selectYourMotherAge(String filePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		Reporter.log("Selecting Your mother age", true);
		DropDownUtility.selectByContainsVisibleText(dropdownMother,
				UtilityMethods.readDataFromExcel(filePath, sheetName, rowNumber, cellNumber));
	}

	public void clickOnNextButton() {
		Reporter.log("Clicking on next button", true);
		nextButton.click();
	}
}
