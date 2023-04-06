package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.LoginPage;

import java.util.List;

public class LoginTest extends BaseTest {
    @Test
    public void tesValidationErrorMessageFieldIsEmpty_LoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required"
        );
        openBaseURL();
        final List<String> actualTextValidationError = openLoginURL()
                .clickLoginButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(loginPage.isErrorImageIsDisplayed());
        Assert.assertTrue(loginPage.isErrorIconIsDisplayed());

    }

    @Test
    public void testPlaceholderIsAvailable_LoginPage() throws InterruptedException {
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "Username or email"
        );
        final String attribute = "placeholder";


        final List<String> actualInnerTextOfPlaceholder = openLoginURL()

                .getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }

    @Test
    public void testLoginToAccount_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Dashboard - Swisscows Accounts";
        final String oldUrl = openLoginURL()
                .enterUserCredentials()
                .getCurrentURL();
        final String newUrl = loginPage
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getCurrentURL();

        final String actualTittle = loginPage.getTitle();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertEquals(actualTittle, expectedTittle);


    }

    @Test
    public void testLoginToAccountWithInvalidPassword_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedValidationError = "The email or password is invalid";

        final String actualValidationError = openLoginURL()
                .enterInvalidUserCredentials()
                .clickLoginButton()
                .getTextValidationErrorMessage();

        Assert.assertEquals(actualValidationError, expectedValidationError);

    }

    @Test
    public void testLoginToSiteSwisscows_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Your private and anonymous search engine Swisscows";
        loginPage
                .openSwisscowsSite()
                .clickHamburgerMenu()
                .clickSignInMenu()
                .enterUserCredentials()
                .clickLoginButton_Dashboard()
                .waitForUrlContains("https://dev.swisscows.com/en");

        Assert.assertEquals(loginPage.getTitle(),expectedTittle);



    }
}