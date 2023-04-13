package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ForgotPage;
import pages.accounts.LoginPage;

import java.util.List;

public class ForgotTest  extends BaseTest {
    @Test
    public void testRestoreUnconfirmedAccountSwisscowsUser_ForgotPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Recovery options - Swisscows Accounts";
        final String expectedUrl = "https://accounts.dev.swisscows.com/recovery";

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .enterUserEmail("tester")
                .clickSubmitButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();


        Assert.assertEquals(actualTittle,expectedTittle);
        Assert.assertEquals(loginPage.getCurrentURL(),expectedUrl);
    }
    @Test
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
    public void testH1Text_ForgotPage()  {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final  String expectedH1Text = "Recover account";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );

        final String actualH1Text = openLoginURL()
                .clickLinkForgotPassword()
                .getH1Text();


        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(forgotPage.getH1FontSizes(), expectedFontSizesH1text);
    }
    @Test
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
        Assert.assertEquals(forgotPage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
    @Test
    public void tesValidationErrorMessageFieldIsEmpty_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required"

        );
        openBaseURL();
        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .clickSubmitButton_RecoveryPage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(forgotPage.isErrorImageIsDisplayed());
        Assert.assertTrue(forgotPage.isErrorIconIsDisplayed());

    }
    @Test
    public void tesValidationErrorMessageInvalidEmail_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The email address is invalid"
        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .enterUserEmail("test@@")
                .clickSubmitButton_RecoveryPage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(forgotPage.isErrorIconIsDisplayed());
    }
    @Test
    public void tesNavigateToCorrespondingPageWhenEnteringExistAccount_ForgotPage() {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final String expectedTittle = "Recover account - Swisscows Accounts";

        final String oldUrl = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        final String newUrl = forgotPage
                .enterUserEmail("a.qa")
                .clickSubmitButton_RecoveryMethodPage()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(forgotPage.getTitle(),expectedTittle);
    }
    @Test
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
    public void testHoverSubmitButton_ForgotPage() throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkForgotPassword()
                .getColorButton();

        final List<String> colorButtonWhenHover = forgotPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void tesSuccessIconIsDisplayed_ForgotPage() {
        ForgotPage forgotPage = new  ForgotPage(getDriver());

        openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("a.qa@swisscows.email");


        Assert.assertTrue(forgotPage.isSuccessIconIsDisplayed());

    }
    @Test
    public void testMainImageIsDisplayed_ForgotPage() {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage();


        Assert.assertTrue(forgotPage.imageIsDisplayedForgotPage());

    }
    @Test
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
    public void testLocalisationsLinksNavigateToCorrespondingPages_ForgotPage(
            int index, String expectedH1Text,String expectedUrl) throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());

        final String oldURL = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .getCurrentURL();

        forgotPage
                .clickLangInDropdownOfLanguages(index);


        final String actualURL = forgotPage.getCurrentURL();
        final String actualTittle = forgotPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(expectedH1Text, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }

}
