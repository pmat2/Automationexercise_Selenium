package example.pages;

import io.qameta.allure.Step;
import example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedText = By.xpath("//b[text()='Account Created!']");
    private final By continueBtn = By.xpath("//a[@data-qa='continue-button']");

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedVisible() {
        return isVisible(accountCreatedText);
    }

    @Step("User navigates to home page")
    public HomePage continueToHome() {
        click(continueBtn);
        return new HomePage(driver);
    }
}

