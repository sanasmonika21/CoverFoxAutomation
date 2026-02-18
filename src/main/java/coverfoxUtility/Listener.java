package coverfoxUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverfoxBase.Base;

public class Listener extends Base implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName() + " passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//WebDriver driver = ((Base) result.getInstance()).getDriver();
		Reporter.log("Taking Screenshot", true);
		try {
			UtilityMethods.takeScreenshot(driver, result.getName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName(), true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName() + " is started execution", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName() + " finish execution", true);
	}
}
