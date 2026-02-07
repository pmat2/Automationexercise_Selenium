package logic.pages;

import io.qameta.allure.Step;
import logic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage {

    private final By loggedInText = By.xpath("//a[contains(text(),'Logged in as')]");
    private final By deleteAccount = By.linkText("Delete Account");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn(String username) {
        return isVisible(loggedInText) && isVisible(By.xpath("//b[contains(text(), '" + username + "')]"));
    }

    public boolean isUserDeleted() {
        return isVisible(By.xpath("//b[normalize-space()='Account Deleted!']"));
    }

    @Step("User click 'delete account' button")
    public void deleteAccount() {
        click(deleteAccount);
    }
}

