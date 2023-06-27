package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.footer_menu.ConfirmPage;
import pages.footer_menu.RegisterPage;
import utils.EmailUtils;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public class RegisterTest extends BaseTest {
    @Test(dataProvider = "RegisterPageLinksData", dataProviderClass = TestData.class)
    @QaseId(value = 1010)
    public void testCheckboxLinksNavigateToCorrespondingPages_RegisterPage(
            int index, String expectedTittle,String expectedUrl) {

        RegisterPage registerPage = openLoginURL()
                .clickLinkInTheFooterMenu();

        final String oldURL = registerPage.getCurrentURL();
        final String oldTittle = registerPage.getH1Text();

        registerPage
                .clickLinksInCheckbox(index);


        final String actualURL = registerPage.getCurrentURL();
        final String actualTittle = registerPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }


    @Test
    @QaseId(value = 1009)
    public void testPlaceholderIsAvailable_RegisterPage() throws InterruptedException {
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "Username or email",
                "Password",
                "Confirm password"
        );
        final String attribute = "placeholder";


        RegisterPage registerPage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage();

        final List<String> actualInnerTextOfPlaceholder = registerPage.getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @Test
    @QaseId(value = 994)
    public void testH1Text_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());

        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .getH1Text();



        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_REGISTER_PAGE);
        Assert.assertEquals(registerPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test(dataProvider = "LangRegisterPageTestData", dataProviderClass = TestData.class)
    @QaseId(value = 1008)
    public void testLocalisationsLinksNavigateToCorrespondingPages_RegisterPage(
            int index, String expectedTittle,String expectedUrl) throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage();

        final String oldURL = registerPage.getCurrentURL();
        final String oldTittle = registerPage.getH1Text();

        registerPage.clickLangInDropdownOfLanguages(index);


        final String actualURL = registerPage
                .waitToBeChangeH1text()
                .getCurrentURL();
        final String actualTittle = registerPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @Test
    @QaseId(value = 991)
    public void testLinkInTheFooterNavigateToCorrespondingPage_RegisterPage(){

        RegisterPage registerPage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage();

        final String oldUrl = registerPage.getCurrentURL();

        final String newUrl = registerPage
                .clickLinkInTheFooterMenu()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(registerPage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test
    @QaseId(value = 1007)
    public void testValidationErrorMessageAndImage_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required",
                "The field is required"
        );
        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .clickRegisterButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());

    }

    @Test(priority = 7)
    @QaseId(value = 1006)
    public void testRegisterExternalUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());



        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsGmail()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains(ProjectConstants.URL_WELCOME_PAGE);

        Assert.assertEquals(registerPage.getH1Text(), ProjectConstants.H1_TEXT_WELCOME_PAGE);
        Assert.assertEquals(registerPage.getCurrentURL(), ProjectConstants.URL_WELCOME_PAGE);
    }
    @Test(priority = 1)
    @QaseId(value = 1005)
    public void  testShowCaptchaForBotAccountAndResolve() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .resolveCaptcha()
                .enterPhoneNumber()
                .waitForUrlContains(ProjectConstants.URL_RECOVERY_PAGE);

        Assert.assertEquals(registerPage.getH1Text(),ProjectConstants.H1_TEXT_RECOVERY_PAGE);
        Assert.assertEquals(registerPage.getCurrentURL(), ProjectConstants.URL_RECOVERY_PAGE);
    }

    @Test(priority = 4)
    @QaseId(value = 1004)
    public void  testRegisterSwisscowsUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsSwisscowsEmail()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains(ProjectConstants.URL_WELCOME_PAGE);

        Assert.assertEquals(registerPage.getH1Text(), ProjectConstants.H1_TEXT_WELCOME_PAGE);
        Assert.assertEquals(registerPage.getCurrentURL(), ProjectConstants.URL_WELCOME_PAGE);
    }
    @Test(priority = 2)
    @QaseId(value = 1002)
    public void tesValidationErrorMessageNotAgreeWithPolicyAndCookies_RegisterPage() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        final String expectedTextValidationError = "You must agree to the Privacy policy, Terms of Use and the Cookie policy";

        final String actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickRegisterButton_ValidationError()
                .getValidationMessageErrorOfCheckbox();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());

    }
    @Test(priority = 3)
    @QaseId(value = 1003)
    public void tesValidationErrorMessageNotAgreeWithPolicy_RegisterPage() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        final String expectedTextValidationError = "You must agree to the Privacy policy, Terms of Use and the Cookie policy";

        final String actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickAgreeWithCookies()
                .clickRegisterButton_ValidationError()
                .getValidationMessageErrorOfCheckbox();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());


    }
    @Test
    @QaseId(value = 1001)
    public void tesValidationErrorMessageNotAgreeWithCookies_RegisterPage(){

        RegisterPage registerPage = new RegisterPage(getDriver());
        final String expectedTextValidationError = "You must agree to the Privacy policy, Terms of Use and the Cookie policy";

        final String actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickAgreeWithPolicy()
                .clickRegisterButton_ValidationError()
                .getValidationMessageErrorOfCheckbox();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());

    }
    @Test
    @QaseId(value = 1000)
    public void tesValidationErrorMessageWhenEnteringExistingAccount_RegisterPage() {

        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "A user with the same email address has already been registered"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterEmailAlreadyBeenRegistered()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton_ValidationError()
                .getListValidationErrorMessage();;


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());

    }
    @Test(priority = 5)
    @QaseId(value = 999)
    public void tesValidationErrorMessageInvalidPasswordIsEntered_RegisterPage(){
        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password must contain at least 8 characters, including letters and numbers"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterInvalidPassword()
                .getListValidationErrorMessage();;


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());


    }
    @Test(priority = 6)
    @QaseId(value = 998)
    public void tesValidationErrorMessageWhenInvalidEmailIsEntered_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        String invalidEmail = "qwerty@@swisscows.email";
        final List<String> expectedTextValidationError = List.of(
                "The email address is invalid"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterInvalidEmail(invalidEmail)
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());
    }
    @Test
    @QaseId(value = 997)
    public void tesValidationErrorMessageWhenIncorrectConfirmationPasswordIsEntered_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password confirmation doesn't match"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterIncorrectRepeatPassword()
                .getListValidationErrorMessage();;


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());
    }
    @Test
    @QaseId(value = 992)
    public void testHoverRegisterButton_RegisterPage() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(getDriver());

        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .getColorButton();

        final List<String> colorButtonWhenHover = registerPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    @QaseId(value = 996)
    public void tesSuccessIconIsDisplayed() {
        RegisterPage registerPage = new RegisterPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsGmail()
                .clickRegisterButton_ValidationError();


        Assert.assertTrue(registerPage.isSuccessIconIsDisplayed());

    }
    @Test
    @QaseId(value = 995)
    public void testAutocompleteDomainSwisscowsEmail_RegisterPage() throws InterruptedException {
        final String expectedAttribute = "[test@swisscows.email]";
        final String actualAttribute = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterNewUserEmail("test")
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .getAutocompleteAttribute();

        Assert.assertNotEquals(actualAttribute,expectedAttribute);
    }
}
