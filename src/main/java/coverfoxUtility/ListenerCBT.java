package coverfoxUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverfoxBase.BaseCBTTest1;

public class ListenerCBT extends BaseCBTTest1 implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName() + " passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Taking Screenshot", true);
		Object currentClass = result.getInstance();
		WebDriver driver = ((BaseCBTTest1) currentClass).getDriver();
		try {
			UtilityMethods.takeScreenshot(driver, result.getName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		String browserName = result.getTestContext().getCurrentXmlTest().getParameter("browser");
		Reporter.log("Running on "+browserName, true);
		Reporter.log("This is onTestStart() " + result.getName(), true);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(null, false);
		Reporter.log("this is onStart() " + context.getName() + " is started execution", true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("This is onFinish() " + context.getName() + " finish execution", true);
	}
}
