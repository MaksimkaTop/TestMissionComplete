package listener;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class FailProviderListener extends TestListenerAdapter {


    @Override
    public void onTestSkipped(ITestResult tr) {
    }

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Test class started: " + result.getTestClass().getName());
        System.out.println("Test started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test SUCCESS: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
        System.out.println("Test FAILED: " + result.getName());
        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        makeScreenshot();
        System.out.println("Test FAILED With Success Percentage: " + result.getName());
        if (result.getThrowable() != null) {
            result.getThrowable().printStackTrace();
        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}