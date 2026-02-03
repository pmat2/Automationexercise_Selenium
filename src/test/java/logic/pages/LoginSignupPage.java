package logic.pages;

import io.qameta.allure.Step;
import logic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage extends BasePage {

    private final By newUserText = By.xpath("//h2[text()='New User Signup!']");
    private final By nameInput = By.name("name");
    private final By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn = By.xpath("//button[@data-qa='signup-button']");

    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupVisible() {
        return isVisible(newUserText);
    }

    @Step("User enters name: {name} and email")
    public AccountInformationPage signup(String name, String email) {
        type(nameInput, name);
        type(emailInput, email);
        click(signupBtn);
        return new AccountInformationPage(driver);
    }
}

