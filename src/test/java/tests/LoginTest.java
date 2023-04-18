package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.LoginPage;
import utils.ProjectConstants;

import java.util.List;

public class LoginTest extends BaseTest {
    @Test
    public void testMainImageIsDisplayed_LoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        openLoginURL()
                .waitMainImageToBeVisible_LoginPage();


        Assert.assertTrue(loginPage.mainImageIsDisplayed());

    }
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
    public void testLoginToAccount_LoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterUserCredentials()
                .getCurrentURL();

        final String newUrl = loginPage
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getCurrentURL();

        final String actualTittle = loginPage.getTitle();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertEquals(actualTittle, ProjectConstants.TITLE_DASHBOARD_PAGE);


    }

    @Test
    public void testLoginToAccountWithInvalidPassword_LoginPage() {

        final String expectedValidationError = "The email or password is invalid";

        final String actualValidationError = openLoginURL()
                .enterInvalidUserCredentials()
                .clickLoginButton()
                .getTextValidationErrorMessage();

        Assert.assertEquals(actualValidationError, expectedValidationError);

    }

    @Test
    public void testLoginToSiteSwisscowsExternalUser_LoginPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSwisscowsSite()
                .clickHamburgerMenu()
                .clickSignInMenu()
                .waitUtilToBeVisibleSwisscowsLogo()
                .enterUserCredentials();
        Assert.assertTrue(loginPage.swisscowsLogoIsDisplayed());
        loginPage
                .clickLoginButton()
                .waitForUrlContains(ProjectConstants.URL_MAIN_PAGE);

        Assert.assertEquals(loginPage.getTitle(),ProjectConstants.TITLE_MAIN_PAGE);

    }
    @Test
    public void testLoginToSiteSwisscowsForSwisscowsUser_LoginPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .openSwisscowsSite()
                .clickHamburgerMenu()
                .clickSignInMenu()
                .waitUtilToBeVisibleSwisscowsLogo()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD);
        Assert.assertTrue(loginPage.swisscowsLogoIsDisplayed());
        loginPage
                .clickLoginButton()
                .waitForUrlContains(ProjectConstants.URL_MAIN_PAGE);

        Assert.assertEquals(loginPage.getTitle(),ProjectConstants.TITLE_MAIN_PAGE);

    }
    @Test
    public void testLoginToSiteSwisscowsEmailForSwisscowsUser_LoginPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        final String actualTittle =loginPage
                .openSwisscowsEmailForm()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton()
                .waitUtilToBeVisibleSwisscowsEmailBoxLogo()
                .getTitle();

        Assert.assertEquals( actualTittle,"Swisscows.email :: Inbox");


    }
    @Test
    public void testLoginToSiteSwisscowsEmailForExternalUser_LoginPage(){
        LoginPage loginPage = new LoginPage(getDriver());
        final String actualTittle =loginPage
                .openSwisscowsEmailForm()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton()
                .getTextWarningMessage();

        Assert.assertEquals( actualTittle,"Login failed.");


    }
    @Test
    public void testLoginToUnconfirmedAccountSwisscowsUser_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        final String actualTittle = openLoginURL()
                .enterUserCredentialsUnconfirmedAccountSwisscowsUser()
                .clickLoginButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();

        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_RECOVERY_PAGE);
        Assert.assertEquals(loginPage.getCurrentURL(),ProjectConstants.URL_RECOVERY_PAGE);
    }
    @Test
    public void testLoginToUnconfirmedAccountExternalUser_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterRandomCredentialsGmail()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .waitUntilMainImageToBeVisibly()
                .clickLinkInTheFooterMenu();

        final String actualTittle = loginPage
                .waitMainImageToBeVisible_LoginPage()
                .enterUserCredentialsUnconfirmedAccountExternalUser()
                .clickLoginButton_ConfirmPage()
                .waitUntilMainImageToBeVisibly()
                .getTitle();

        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_CONFIRM_PAGE);
        Assert.assertEquals(loginPage.getCurrentURL(),ProjectConstants.URL_CONFIRM_PAGE);
    }

    @Test
    public void testLinkForgotPasswordNavigateToCorrespondingPage_LoginPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .getTitle();

        Assert.assertEquals(actualTittle, ProjectConstants.TITLE_FORGOT_PAGE);
        Assert.assertEquals(loginPage.getCurrentURL(),ProjectConstants.URL_FORGOT_PAGE);
    }
    @Test
    public void testH1Text_LoginPage()  {
        LoginPage loginPage = new LoginPage(getDriver());

        final String actualH1Text = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_LOGIN_PAGE);
        Assert.assertEquals(loginPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
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
            int index, String expectedH1Text,String expectedUrl) throws InterruptedException {
        LoginPage loginPage = new  LoginPage(getDriver());

        final String oldURL = openLoginURL()
                .getCurrentURL();

        loginPage
                .clickLangInDropdownOfLanguages(index);

        final String actualURL = loginPage.getCurrentURL();
        final String actualTittle = loginPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }

}