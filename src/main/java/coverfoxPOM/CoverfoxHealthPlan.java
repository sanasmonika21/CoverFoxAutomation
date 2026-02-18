package coverfoxPOM;

import java.awt.image.ReplicateScaleFilter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHealthPlan {

	@FindBy(xpath = "//h1[contains(text(),'Health Insurance')]")
	private WebElement mainHeading;
	
	@FindBy(xpath = "//div[contains(text(),'Select your gender')]")
	private WebElement subHeading1;
	
	@FindBy(xpath = "//div[contains(text(),'Select members')]")
	private WebElement subHeading2;

	@FindBy(xpath = "//div[contains(text(),'Female')]")
	private WebElement femaleButton;

	@FindBy(xpath = "//div[contains(text(),'Husband')]")
	private WebElement husbansButton;

	@FindBy(xpath = "//div[contains(text(),'Daughter')]")
	private WebElement daughtheruButton;

	@FindBy(xpath = "//div[contains(text(),'Son')]")
	private WebElement sonButton;

	@FindBy(xpath = "//div[contains(text(),'Father')]")
	private WebElement fatherButton;

	@FindBy(xpath = "//div[contains(text(),'Mother')]")
	private WebElement motherButton;

	@FindBy(className = "next-btn")
	private WebElement nextButton;

	
	public CoverfoxHealthPlan(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String gettingMainHead() {
		Reporter.log("getting main head ", true);
		return mainHeading.getText();
	}
	
	public String gettingSubHeading1() {
		Reporter.log("getting sub heading.....", true);
		return subHeading1.getText();
	}
	
	public String gettingSubHeading2() {
		Reporter.log("getting sub heading 2", true);
		return subHeading2.getText();
	}

	public void clickOnFemaleButton() {
		Reporter.log("Clicking on female button", true);
		femaleButton.click();
	}

	public void clickOnHusbandButton() {
		Reporter.log("Clickining on husband button", true);
		husbansButton.click();
	}

	public void clickOnDaughterButton() {
		Reporter.log("Clicking on daughther button", true);
		daughtheruButton.click();
	}

	public void clickOnSonButton() {
		Reporter.log("Clicking on son button", true);
		sonButton.click();
	}

	public void clickonFatherButton() {
		Reporter.log("Clickimg on father button", true);
		fatherButton.click();
	}

	public void clickOnMotherButton() {
		Reporter.log("clciking on mother button", true);
		motherButton.click();
	}

	public void clickOnNextButton() {
		Reporter.log("clicking on next button", true);
		nextButton.click();
	}
	
}
