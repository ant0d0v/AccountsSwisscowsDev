package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.TestData;
import pages.footer_menu.ForgotPage;
import pages.footer_menu.LoginPage;
import utils.ProjectConstants;

import java.util.List;

public class ForgotTest  extends BaseTest {
    @Test
    @QaseId(value = 1072)
    public void testRestoreUnconfirmedAccountSwisscowsUser_ForgotPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("tester")
                .clickSubmitButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();


        Assert.assertEquals(actualTittle, ProjectConstants.TITLE_RECOVERY_PAGE);
        Assert.assertEquals(loginPage.getCurrentURL(),ProjectConstants.URL_RECOVERY_PAGE);
    }
    @Ignore
    @Test
    @QaseId(value = 1089)
    public void testRestoreUnconfirmedAccountExternalUser_ForgotPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterRandomCredentialsGmail()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .waitUntilMainImageToBeVisibly()
                .clickLinkInTheFooterMenu();
        final String actualTittle =  loginPage
                .waitMainImageToBeVisible_LoginPage()
                .clickLinkForgotPassword()
                .enterUserEmail("test123@gmail.com")
                .clickSubmitButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();


        Assert.assertEquals(actualTittle, ProjectConstants.TITLE_RECOVERY_PAGE);
        Assert.assertEquals(loginPage.getCurrentURL(),ProjectConstants.URL_RECOVERY_PAGE);
    }
    @Test
    @QaseId(value = 1074)
    public void testLinkSupportRedirectToCorrespondingPage_ForgotPage() throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        final String expectedTittle = "Contact us | Swisscows";

        final String oldUrl = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        final String newUrl = forgotPage
                .clickSupportLink()
                .getCurrentURL();


        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(forgotPage.getTitle(),expectedTittle);
    }
    @Test
    @QaseId(value = 1081)
    public void testPlaceholderIsAvailable_ForgotPage() throws InterruptedException {
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "Username or email"
        );
        final String attribute = "placeholder";


        final List<String> actualInnerTextOfPlaceholder = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @Test
    @QaseId(value = 1076)
    public void testH1Text_ForgotPage()  {
        ForgotPage forgotPage = new ForgotPage(getDriver());

        final String actualH1Text = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_FORGOT_PAGE);
        Assert.assertEquals(forgotPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1084)
    public void testLinkInTheFooterNavigateToCorrespondingPage_ForgotPage(){
        ForgotPage forgotPage = new ForgotPage(getDriver());

        final String oldUrl = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        final String newUrl = forgotPage
                .clickLinkInTheFooterMenu()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(forgotPage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test
    @QaseId(value = 1079)
    public void tesValidationErrorMessageFieldIsEmpty_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required"

        );
        openBaseURL();
        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .clickSubmitButton_RecoveryPage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(forgotPage.isErrorImageIsDisplayed());
        Assert.assertTrue(forgotPage.isErrorIconIsDisplayed());

    }
    @Test
    @QaseId(value = 1078)
    public void tesValidationErrorMessageInvalidEmail_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The email address is invalid"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("test@@")
                .clickSubmitButton_RecoveryPage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(forgotPage.isErrorIconIsDisplayed());
    }
    @Test
    @QaseId(value = 1085)
    public void tesNavigateToCorrespondingPageWhenEnteringExistAccount_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());

        final String oldUrl = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        final String newUrl = forgotPage
                .enterUserEmail("a.qa")
                .clickSubmitButton_RecoveryMethodPage()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(forgotPage.getTitle(),ProjectConstants.TITLE_FORGOT_PAGE);
    }
    @Test
    @QaseId(value = 1086)
    public void tesNavigateToCorrespondingPageWhenEnteringNotExistAccount_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final String expectedTittle = "User not found - Swisscows Accounts";

        final String oldUrl = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        final String newUrl = forgotPage
                .enterUserEmail("SFSDFSF")
                .clickSubmitButton_UserNotFoundPage()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(forgotPage.getTitle(),expectedTittle);
    }
    @Test
    @QaseId(value = 1075)
    public void testHoverSubmitButton_ForgotPage() throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getColorButton();

        final List<String> colorButtonWhenHover = forgotPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    @QaseId(value = 1087)
    public void tesSuccessIconIsDisplayed_ForgotPage() {
        ForgotPage forgotPage = new  ForgotPage(getDriver());

        openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("a.qa@swisscows.email");


        Assert.assertTrue(forgotPage.isSuccessIconIsDisplayed());

    }
    @Test
    @QaseId(value = 1082)
    public void testMainImageIsDisplayed_ForgotPage() {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage();


        Assert.assertTrue(forgotPage.imageIsDisplayedForgotPage());

    }
    @Test
    @QaseId(value = 1088)
    public void testDescriptionText_ForgotPage()  {

        final  List<String> expectedDescription = List.of(
                "If you forgot your password, we can help you to reset it."
                         + " Please, specify the primary email of your Swisscows account and follow the instructions:",
                 "If you don't remember your primary email, please contact the support"
                         + " and provide as much information as you can in order to restore the access."


        );

        final List<String> actualDescription = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getDescriptionForgotPage();


        Assert.assertEquals(actualDescription, expectedDescription);

    }
    @Test(dataProvider = "LangForgotPageTestData", dataProviderClass = TestData.class)
    @QaseId(value = 1080)
    public void testLocalisationsLinksNavigateToCorrespondingPages_ForgotPage(
            int index, String expectedH1Text,String expectedUrl) throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());

        final String oldURL = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        forgotPage
                .clickLangInDropdownOfLanguages(index);


        final String actualURL = forgotPage
                .waitToBeChangeH1text()
                .getCurrentURL();
        final String actualTittle = forgotPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(expectedH1Text, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }

}
