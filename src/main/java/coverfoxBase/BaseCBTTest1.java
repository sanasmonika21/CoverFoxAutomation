package coverfoxBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import coverfoxUtility.UtilityMethods;

public class BaseCBTTest1 {
	protected WebDriver driver;

	public void launchBrowser(String browser) throws IOException {
		Reporter.log("Launching Browser", true);
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(UtilityMethods.readDataFromPropertyFile("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public WebDriver getDriver() {
		return driver;
	}
	public void closeBrowser() {
		Reporter.log("Closing Browser", true);
		driver.quit();
	}
}
