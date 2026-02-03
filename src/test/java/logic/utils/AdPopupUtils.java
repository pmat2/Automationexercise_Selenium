package logic.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public final class AdPopupUtils {

    private AdPopupUtils() {
    }

    @Step("User closes ads if present")
    public static void killAdIfPresent(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        for (WebElement iframe : iframes) {
            try {
                driver.switchTo().frame(iframe);

                List<WebElement> closeButtons = driver.findElements(
                        By.xpath("//*[text()='Close']")
                );

                if (!closeButtons.isEmpty()) {
                    js.executeScript("arguments[0].click();", closeButtons.get(0));
                }

                driver.switchTo().defaultContent();

                js.executeScript("arguments[0].remove();", iframe);

                return;

            } catch (Exception ignored) {
                driver.switchTo().defaultContent();
            }
        }

        js.executeScript("""
                    document.querySelectorAll('iframe').forEach(f => {
                        if (f.src && (f.src.includes('doubleclick') || f.src.includes('ads'))) {
                            f.remove();
                        }
                    });
                    document.body.style.overflow = 'auto';
                """);
    }

    public static void nukeAds(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 3; i++) {
            js.executeScript("""
                        document.querySelectorAll('iframe').forEach(f => {
                            if (f.src && (f.src.includes('ads') || f.src.includes('doubleclick'))) {
                                f.remove();
                            }
                        });
                        document.body.style.overflow='auto';
                    """);

            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
