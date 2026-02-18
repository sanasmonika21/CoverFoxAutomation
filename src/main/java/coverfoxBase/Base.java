package coverfoxBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import coverfoxUtility.*;

public class Base {
	protected static WebDriver driver;
	//protected WebDriver driver;

	public void launchBrowser() throws IOException {
		/*
		 * if (browser.equals("chrome")) { driver = new ChromeDriver(); }
		 */
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(UtilityMethods.readDataFromPropertyFile("url"));
		Reporter.log("launching browser.....", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("waiting.............", true);
	}

	public void closeBrowser() {
		Reporter.log("Closing browser....", true);
		// driver.close();
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
