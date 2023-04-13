package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.accounts.RegisterPage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public class RegisterTest extends BaseTest {
    @Test(dataProvider = "RegisterPageLinksData", dataProviderClass = TestData.class)
    public void testCheckboxLinksNavigateToCorrespondingPages_RegisterPage(
            int index, String expectedTittle,String expectedUrl) {

        RegisterPage registerPage = openBaseURL()
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
    public void testH1Text_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final  String expectedH1Text = "Register";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
                );

        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .getH1Text();



        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(registerPage.getH1FontSizes(), expectedFontSizesH1text);

    }
    @Test(dataProvider = "LangRegisterPageTestData", dataProviderClass = TestData.class)
    public void testLocalisationsLinksNavigateToCorrespondingPages_RegisterPage(
            int index, String expectedTittle,String expectedUrl) throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage();

        final String oldURL = registerPage.getCurrentURL();
        final String oldTittle = registerPage.getTitle();

        registerPage
                .clickLangInDropdownOfLanguages(index);

        final String actualURL = registerPage.getCurrentURL();
        final String actualTittle = registerPage.getTitle();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_RegisterPage(){

        RegisterPage registerPage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage();

        final String oldUrl = registerPage.getCurrentURL();

        registerPage
                .clickLinkInTheFooterMenu();

        final String newUrl = registerPage.getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(registerPage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
    @Test
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

    @Test
    public void testRegisterExternalUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final String expectedH1Text = "Welcome";
        final String expectedUrl = "https://accounts.dev.swisscows.com/welcome";


        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentials()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .getConfirmCodeFromGmailBox();

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/welcome");


        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }
    @Test
    public void  testRegisterBotAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final String expectedH1Text = "Welcome";
        final String expectedUrl = "https://accounts.dev.swisscows.com/welcome";

        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .resolveCaptcha()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox();

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/welcome");

        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }

    @Test
    public void  testRegisterSwisscowsUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final String expectedH1Text = "Welcome";
        final String expectedUrl = "https://accounts.dev.swisscows.com/welcome";


        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox();

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/welcome");

        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }
    @Test
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
    @Test
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
    public void tesValidationErrorMessageUserAlreadyBeenRegistered_RegisterPage() {

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
    @Test
    public void tesValidationErrorMessageInvalidPassword_RegisterPage(){
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
    @Test
    public void tesValidationErrorMessageInvalidEmail_RegisterPage() {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The email address is invalid"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterInvalidEmail("qwerty@@swisscows.email")
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorIconIsDisplayed());
    }
    @Test
    public void tesValidationErrorMessagePasswordConfirmationDoesntMatch_RegisterPage() {
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
    public void tesSuccessIconIsDisplayed() {
        RegisterPage registerPage = new RegisterPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentials()
                .clickAllCheckboxesRegisterPage();


        Assert.assertTrue(registerPage.isSuccessIconIsDisplayed());

    }
    @Test
    public void testAutocompleteSwisscowsEmail_RegisterPage() throws InterruptedException {
        final String expectedAttribute = "[test@swisscows.email]";
        final String actualAttribute = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterNewUserEmail("test")
                .enterNewUserPassword("123DSFSsdd")
                .getAutocompleteAttribute();

        Assert.assertNotEquals(actualAttribute,expectedAttribute);
    }

}
