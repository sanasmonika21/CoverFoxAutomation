package coverfoxUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtility {
	private WebDriverWait wait;

	public WaitsUtility(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public void type(WebElement element, String text) {
		 wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
	}
}
