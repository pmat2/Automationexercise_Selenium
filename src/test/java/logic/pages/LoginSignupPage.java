package logic.pages;

import io.qameta.allure.Step;
import logic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Optional;

public class LoginSignupPage extends BasePage {

    private final By newUserText = By.xpath("//h2[text()='New User Signup!']");
    private final By loginText = By.xpath("//h2[text()='Login to your account']");
    private final By signupNameInput = By.name("name");
    private final By signupEmailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signupBtn = By.xpath("//button[@data-qa='signup-button']");
    private final By loginEmailInput = By.name("email");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginBtn = By.xpath("//button[@data-qa='login-button']");
    private final By userExistsText = By.xpath("//p[normalize-space()='Email Address already exist!']");

    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewUserSignupVisible() {
        return isVisible(newUserText);
    }

    public boolean isloginTextVisible() {
        return isVisible(loginText);
    }

    protected boolean isVisible(By locator, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("User enters username and email address to signup form")
    public Optional<AccountInformationPage> signup(String name, String email) {
        type(signupNameInput, name);
        type(signupEmailInput, email);
        click(signupBtn);
        if (isVisible(userExistsText, 2)) {
            return Optional.empty();
        }
        return Optional.of(new AccountInformationPage(driver));
    }

    @Step("User enters username and password to login form")
    public HomePage login(String email, String password) {
        type(loginEmailInput, email);
        type(loginPasswordInput, password);
        click(loginBtn);

        return new HomePage(driver);
    }
}

