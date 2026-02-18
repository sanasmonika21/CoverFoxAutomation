package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CoverfoxHomePage {
	@FindBy(xpath = "//div[text()='Male']")
	private WebElement maleButton;

	@FindBy(xpath = "//div[text()='Female']")
	private WebElement female;

	@FindBy(xpath = "//li[text()='Car']")
	private WebElement carButton;

	@FindBy(xpath = "//li[text()='Bike']")
	private WebElement bikeButton;

	@FindBy(xpath = "//li[text()='Term Life']")
	private WebElement termLifeButton;

	@FindBy(xpath = "//button[text()='Get Started']")
	private WebElement getStartedButton;

	@FindBy(xpath = "//h2[text()='Best Health Insurance plans. Customized for you.']")
	private WebElement subHeading;

	@FindBy(xpath = "//h1[text()='Best Policies at Lowest Premiums']")
	private WebElement mainHeading;
	
	

	public CoverfoxHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnMaleButton() {
		Reporter.log("Clicking on male button", true);
		maleButton.click();
	}

	public void clickOnFemaleButton() {
		Reporter.log("clicking on female button", true);
		female.click();
	}

	public void clickOnCarButton() {
		Reporter.log("clicking on car button", true);
		carButton.click();
	}

	public void clickOnBikeButton() {
		Reporter.log("click on bike button", true);
		bikeButton.click();
	}

	public void clickOnTermLifeButton() {
		Reporter.log("clicking on term life button", true);
		termLifeButton.click();
	}

	public void clickOnGetStartedButton() {
		Reporter.log("clicking on get started button", true);
		getStartedButton.click();
	}

	public String gettingSubHeadingText() {
		Reporter.log("getting sub heading", true);
		return subHeading.getText();
	}

	public String gettingMainHeadingText() {
		Reporter.log("getting main heading", true);
		return mainHeading.getText();
	}
	

}
