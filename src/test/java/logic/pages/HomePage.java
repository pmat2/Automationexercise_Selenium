package logic.pages;

import io.qameta.allure.Step;
import logic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By signupLoginBtn = By.linkText("Signup / Login");
    private final By logoutBtn = By.linkText("Logout");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomePageVisible() {
        return driver.getTitle().contains("Automation Exercise");
    }

    public void logout() {
        click(logoutBtn);
    }

    @Step("User navigates to signup page")
    public LoginSignupPage goToSignupLogin() {
        click(signupLoginBtn);
        return new LoginSignupPage(driver);
    }
}
