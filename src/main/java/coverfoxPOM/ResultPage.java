package coverfoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ResultPage {

	@FindBy(xpath = "//div[contains(text(),'matching Health Insurance Plans')]")
	private WebElement policyCount;

	@FindBy(xpath = "//div[@class='plan-card-container']")
	private List<WebElement> bannerCountList;

	public ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int gettingPolicyCount() {
		Reporter.log("getting policy count", true);
		// int result = Integer.parseInt(policyCount.getText().substring(0, 2));
		int result = Integer.parseInt(policyCount.getText().replaceAll("\\D+", ""));
		return result;
	}

	public int gettingBannerCountList() throws InterruptedException {

		Reporter.log("getting banner count", true);
		int size = bannerCountList.size();
		return size;
	}
}
