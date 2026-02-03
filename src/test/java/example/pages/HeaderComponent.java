package example.pages;

import io.qameta.allure.Step;
import example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    private final By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccount = By.linkText("Delete Account");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return isVisible(loggedInText);
    }

    @Step("User click 'delete account' button")
    public void deleteAccount() {
        click(deleteAccount);
    }
}

