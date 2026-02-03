package logic.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class CookieUtils {

    private CookieUtils() {
        // util class
    }


    @Step("User accepts cookies")
    public static void acceptCookiesIfPresent(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            WebElement consentButton = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//button[@aria-label='Consent']")
                    )
            );

            consentButton.click();
        } catch (TimeoutException ignored) {
            // cookie popup not displayed
        } catch (NoSuchElementException ignored) {
            // element not found
        }
    }
}
