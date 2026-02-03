package logic.pages;

import io.qameta.allure.Step;
import logic.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountInformationPage extends BasePage {

    private final By password = By.id("password");
    private final By newsletter = By.id("newsletter");
    private final By optin = By.id("optin");

    private final By firstname = By.id("first_name");
    private final By lastname = By.id("last_name");
    private final By address = By.id("address1");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");

    private final By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public AccountInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("User fills basic login data")
    public AccountInformationPage fillAccountDetails(String pwd) {
        type(password, pwd);
        click(newsletter);
        click(optin);
        return this;
    }

    @Step("User fills account details")
    public AccountCreatedPage fillAddressAndCreateAccount(
            String firstnameVal, String lastnameVal, String addressVal,
            String stateVal, String cityVal,
            String zip, String phone) {

        type(firstname, firstnameVal);
        type(lastname, lastnameVal);
        type(address, addressVal);
        type(state, stateVal);
        type(city, cityVal);
        type(zipcode, zip);
        type(mobile, phone);

        click(createAccountBtn);
        return new AccountCreatedPage(driver);
    }
}
