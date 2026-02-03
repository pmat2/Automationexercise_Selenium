package tests;

import base.BaseTest;
import logic.pages.*;
import logic.utils.AdPopupUtils;
import logic.utils.CookieUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static logic.utils.TestDataUtils.generateEmail;
import static org.testng.Assert.assertTrue;

@Listeners({io.qameta.allure.testng.AllureTestNg.class, utils.AllureListener.class})
public class RegisterAndDeleteUser extends BaseTest {

    @Test
    public void shouldRegisterAndDeleteUser() {

        driver.get("http://automationexercise.com");
        CookieUtils.acceptCookiesIfPresent(driver);

        HomePage home = new HomePage(driver);
        assertTrue(home.isHomePageVisible());

        LoginSignupPage login = home.goToSignupLogin();
        assertTrue(login.isNewUserSignupVisible());

        AccountInformationPage account =
                login.signup("TestUser", generateEmail());

        AccountCreatedPage created =
                account.fillAccountDetails("Password123")
                        .fillAddressAndCreateAccount(
                                "Jan", "Kowalsky", "Zielony Las 5", "Ontario", "Toronto", "12345", "123456789");

        assertTrue(created.isAccountCreatedVisible());

        home = created.continueToHome();

        AdPopupUtils.killAdIfPresent(driver);

        HeaderComponent header = new HeaderComponent(driver);
        assertTrue(header.isUserLoggedIn());

        header.deleteAccount();
    }
}
