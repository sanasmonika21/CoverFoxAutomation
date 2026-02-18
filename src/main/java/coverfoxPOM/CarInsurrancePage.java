package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarInsurrancePage {

	@FindBy(xpath = "//button[@title='View Quotes']")
	private WebElement viewQuotesButton;

	@FindBy(xpath = "//p[text()='Oh, we can’t proceed without your registration number. Do your bit?']")
	private WebElement carNumValidationErrorMessage;

	@FindBy(xpath = "//p[contains(text(),'Not a valid registration number')]")
	private WebElement InvalidCarNumberValidationMessage;
	
	@FindBy(xpath = "//input[contains(@id,'1771')]")
	private WebElement carNumberFiled;
	
	@FindBy(xpath = "(//span[@class='dls-link'])[1]")
	private WebElement DontKnowCarNumberClickhereLink;
	
	
	@FindBy(xpath = "(//span[@class='dls-link'])[2]")
	private WebElement BoughtNewCarClickhereLink;
	
	@FindBy(xpath = "//span[@id='instant-renewal']")
	private WebElement RenewHereLink;
	
	public CarInsurrancePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnviewQuotesButton() {
		viewQuotesButton.click();
	}

	public String gettingValidationMessage() {
		return carNumValidationErrorMessage.getText();
	}
	public String gettingInvalidcarNumValidationMessage() {
		return InvalidCarNumberValidationMessage.getText();
	}
	public void enterCarNumber(String carNumber) {
		carNumberFiled.sendKeys(carNumber);
	}
	public void ClickHereLinkDontKnowCarNumber() {
		BoughtNewCarClickhereLink.click();
	}
	public void ClickHereLinkBoughtNewCar() {
		BoughtNewCarClickhereLink.click();
	}
}
