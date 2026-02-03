package utils;

import base.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();

        if (testInstance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) testInstance).driver;

            if (driver != null) {
                saveScreenshot(driver);
            } else {
                System.out.println("Driver is null – screenshot skipped");
            }
        }
    }

    @Attachment(value = "Screenshot on failure", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }
}
