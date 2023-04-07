package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
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
                .enterUserCredentials();
        Assert.assertTrue(loginPage.swisscowsLogoIsDisplayed());
        loginPage
                .clickLoginButton_Dashboard()
                .waitForUrlContains("https://dev.swisscows.com/en");

        Assert.assertEquals(loginPage.getTitle(),expectedTittle);

    }
    @Test
    public void testLoginToUnconfirmedAccountSwisscowsUser_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Recovery options - Swisscows Accounts";
        final String expectedUrl = "https://accounts.dev.swisscows.com/recovery";

        final String actualTittle = openLoginURL()
                .enterUserCredentialsUnconfirmedAccountSwisscowsUser()
                .clickLoginButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();

        Assert.assertEquals(actualTittle,expectedTittle);
        Assert.assertEquals(loginPage.getCurrentURL(),expectedUrl);
    }
    @Test
    public void testLinkForgotPasswordNavigateToCorrespondingPage_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Recover account - Swisscows Accounts";
        final String expectedUrl = "https://accounts.dev.swisscows.com/forgot";

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .getTitle();

        Assert.assertEquals(actualTittle,expectedTittle);
        Assert.assertEquals(loginPage.getCurrentURL(),expectedUrl);
    }
    @Test
    public void testH1Text_LoginPage()  {
        LoginPage loginPage = new LoginPage(getDriver());
        final  String expectedH1Text = "Login";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );

        final String actualH1Text = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(loginPage.getH1FontSizes(), expectedFontSizesH1text);
    }
    @Test
    public void testHoverLoginButton_LoginPage() throws InterruptedException {
        LoginPage loginPage = new  LoginPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .getColorButton();

        final List<String> colorButtonWhenHover = loginPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void testAutocompleteSwisscowsEmail_LoginPage() throws InterruptedException {
        final String expectedAttribute = "[test@swisscows.email]";
        final String actualAttribute = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail("test")
                .enterNewUserPassword("123")
                .getAutocompleteAttribute();

        Assert.assertNotEquals(actualAttribute,expectedAttribute);
    }
    @Test
    public void testAccountLogoIsDysplaed_LoginPage() {
        LoginPage loginPage = new  LoginPage(getDriver());
         openLoginURL()
                .waitMainImageToBeVisible_LoginPage();


        Assert.assertTrue(loginPage.accountLogoIsDisplayed());
    }
    @Test(dataProvider = "LangLoginPageTestData", dataProviderClass = TestData.class)
    public void testLocalisationsLinksNavigateToCorrespondingPages_LoginPage(
            int index, String expectedTittle,String expectedUrl) throws InterruptedException {
        LoginPage loginPage = new  LoginPage(getDriver());

        final String oldURL = openLoginURL()
                .getCurrentURL();

        loginPage
                .clickLangInDropdownOfLanguages(index);

        final String actualURL = loginPage.getCurrentURL();
        final String actualTittle = loginPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }

}