package tests;

import base.BaseTest;
import logic.pages.AccountInformationPage;
import logic.pages.HeaderComponent;
import logic.pages.HomePage;
import logic.pages.LoginSignupPage;
import logic.utils.AdPopupUtils;
import logic.utils.CookieUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.testng.Assert.assertTrue;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, utils.AllureListener.class})
public class LoginUserWithCorrectCredentials extends BaseTest {

    private final String USERNAME = "TestUser";
    private final String EMAIL = "TestUser123@mail.com";
    private final String PASSWORD = "Password123";

    @BeforeMethod
    public void prepareAccount() {
        driver.get("http://automationexercise.com");
        CookieUtils.acceptCookiesIfPresent(driver);

        HomePage home = new HomePage(driver);

        LoginSignupPage login = home.goToSignupLogin();

        AdPopupUtils.killAdIfPresent(driver);

        Optional<AccountInformationPage> accountOpt =
                login.signup(USERNAME, EMAIL);

        if (accountOpt.isEmpty()){
            login.login(USERNAME, PASSWORD);
            return;
        }

        AccountInformationPage account = accountOpt.get();

        account.fillAccountDetails(PASSWORD)
                .fillAddressAndCreateAccount(
                        "Jan", "Kowalsky", "Zielony Las 5", "Ontario", "Toronto", "12345", "123456789");

        home.logout();
    }

    @Test
    public void loginWithCorrectCredentials() {
        driver.get("http://automationexercise.com");
        CookieUtils.acceptCookiesIfPresent(driver);

        HomePage home = new HomePage(driver);
        assertTrue(home.isHomePageVisible());

        LoginSignupPage login = home.goToSignupLogin();
        assertTrue(login.isloginTextVisible());

        home = login.login(EMAIL, PASSWORD);
        assertTrue(home.isHomePageVisible());

        HeaderComponent header = new HeaderComponent(driver);
        assertTrue(header.isUserLoggedIn(USERNAME));

        header.deleteAccount();
        assertTrue(header.isUserDeleted());
    }
}
