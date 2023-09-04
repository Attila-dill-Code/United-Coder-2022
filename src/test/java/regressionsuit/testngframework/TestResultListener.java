package regressionsuit.testngframework;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.List;

public class TestResultListener implements ITestListener{
    List<ITestNGMethod> passedTests = new ArrayList<>();
    List<ITestNGMethod> failedTests = new ArrayList<>();
    List<ITestNGMethod> skippedTests = new ArrayList<>();
    ScreenShotUtility screenShotUtility = new ScreenShotUtility();
    public void onTestStart(ITestResult result) {
    }

    public void onTestSuccess(ITestResult result) {
        passedTests.add(result.getMethod());
        screenShotUtility.takeScreenShot(result.getMethod().getMethodName().trim()+"_Passed",
                ((WebDriver)result.getTestContext().getAttribute("driver")));
    }

    public void onTestFailure(ITestResult result) {
        failedTests.add(result.getMethod());
        screenShotUtility.takeScreenShot(result.getMethod().getMethodName().trim()+"_Failed",
                ((WebDriver)result.getTestContext().getAttribute("driver")));
    }

    public void onTestSkipped(ITestResult result) {
    }

}
