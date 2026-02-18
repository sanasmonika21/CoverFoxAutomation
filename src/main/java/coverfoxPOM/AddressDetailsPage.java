package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressDetailsPage {

	@FindBy(xpath = "//div[@class='title']")
	private WebElement mainHeading;

	@FindBy(xpath = "(//input[@class='mp-input-text'])[1]")
	private WebElement pinCode;

	@FindBy(xpath = "(//input[@class='mp-input-text'])[2]")
	private WebElement pinCodeParent;

	@FindBy(xpath = "//label[text()='Same as Mine']")
	private WebElement sameAsMineCheckBox;

	@FindBy(xpath = "//input[@id='want-expert']")
	private WebElement mobileNumber;

	@FindBy(xpath = "//div[@class='next-btn']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[contains(text(),'valid mobile no')]")
	private WebElement mobErrMsg;
	
	@FindBy(xpath = "//div[contains(text(),'valid pincode ')]")
	private WebElement pinErrMsg;
	
	public AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String gettingMainHeading() {
		return mainHeading.getText();
	}

	public void enterYourPincode(String pin) {
		pinCode.sendKeys(pin);
	}

	public void enterParentsPincode(String pin) {
		pinCodeParent.sendKeys(pin);
	}

	public void enterMobileNumber(String Mo_no) {
		mobileNumber.sendKeys(Mo_no);
	}

	public void clickOnCheckBox() {
		sameAsMineCheckBox.click();
	}

	public void clickOnContinueButton() {
		continueButton.click();
	}
	public String validatePinErrMessage() {
		String pincodeActualErrorMessage = pinErrMsg.getText();
		return pincodeActualErrorMessage;	
	}
	public String validateMobNoErrMessage() {
		String moNoActualErrorMessage = mobErrMsg.getText();
		return moNoActualErrorMessage;	
	}
	
}
