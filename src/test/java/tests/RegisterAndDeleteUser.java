package tests;

import base.BaseTest;
import logic.pages.*;
import logic.utils.AdPopupUtils;
import logic.utils.CookieUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Optional;

import static org.testng.Assert.assertTrue;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, utils.AllureListener.class})
public class RegisterAndDeleteUser extends BaseTest {

    private final String USERNAME = "TestUser";
    private final String EMAIL = "TestUser123@mail.com";
    private final String PASSWORD = "Password123";

    @Test
    public void shouldRegisterAndDeleteUser() {

        driver.get("http://automationexercise.com");
        CookieUtils.acceptCookiesIfPresent(driver);

        HomePage home = new HomePage(driver);
        assertTrue(home.isHomePageVisible());

        LoginSignupPage login = home.goToSignupLogin();
        assertTrue(login.isNewUserSignupVisible());

        Optional<AccountInformationPage> accountOpt =
                login.signup(USERNAME, EMAIL);

        if (accountOpt.isEmpty()) {
            login.login(EMAIL, PASSWORD);
        } else {
            AccountCreatedPage created =
                    accountOpt.get().fillAccountDetails(PASSWORD)
                            .fillAddressAndCreateAccount(
                                    "Jan", "Kowalsky",
                                    "Zielony Las 5", "Ontario",
                                    "Toronto", "12345",
                                    "123456789"
                            );

            assertTrue(created.isAccountCreatedVisible());
            home = created.continueToHome();
        }
        AdPopupUtils.killAdIfPresent(driver);

        assertTrue(home.isHomePageVisible());

        HeaderComponent header = new HeaderComponent(driver);
        assertTrue(header.isUserLoggedIn(USERNAME));

        header.deleteAccount();
    }
}
