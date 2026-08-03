package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>> [STARTED]: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">>> [PASSED]: " + result.getMethod().getMethodName());
        
        ScreenshotUtils.takeScreenshot(BaseTest.driver, "PASSED_" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>> [FAILED]: " + result.getMethod().getMethodName());

        ScreenshotUtils.takeScreenshot(BaseTest.driver, "FAILED_" + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(">>> [SKIPPED]: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(">>> [SUITE FINISHED]: All tests execution completed.");
    }
}