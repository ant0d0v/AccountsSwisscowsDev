package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.RegisterPage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public class RegisterTest extends BaseTest {
    @Test(dataProvider = "RegisterPageLinksData", dataProviderClass = TestData.class)
    public void testRegisterPageLinksNavigateToCorrespondingPages(
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


        RegisterPage registerPage = openBaseURL()
                .clickLinkInTheFooterMenu();


        final List<String> actualInnerTextOfPlaceholder = registerPage.getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @Test(dataProvider = "LangRegisterPageTestData", dataProviderClass = TestData.class)
    public void testLocalisationsLinksNavigateToCorrespondingPages_RegisterPage(
            int index, String expectedTittle,String expectedUrl) {

        RegisterPage registerPage = openBaseURL()
                .clickLinkInTheFooterMenu();

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
    public void testLinkInTheFooterNavigateToCorrespondingPage_RegisterPage() throws InterruptedException {

        RegisterPage registerPage = openBaseURL()
                .clickLinkInTheFooterMenu();

        final String oldUrl = registerPage.getCurrentURL();

        registerPage
                .clickLinkInTheFooterMenu();

        final String newUrl = registerPage.getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(registerPage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
    @Test
    public void tesValidationErrorMessageAndImage_RegisterPage() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required",
                "The field is required"
        );
        final List<String> actualTextValidationError = openBaseURL()
                .clickLinkInTheFooterMenu()
                .clickRegisterButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(registerPage.isErrorImageIsDisplayed());

    }

    @Test
    public void tesRegisterExternalUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final String expectedH1Text = "Welcome";
        final String expectedUrl = "https://accounts.dev.swisscows.com/welcome";


        final String code = openBaseURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentials()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .getConfirmCodeFromGmailBox();

        registerPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/welcome");


        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }
    @Ignore
    @Test
    public void  tesRegisterSwisscowsUserAndConfirmAccount() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        final String expectedH1Text = "Welcome";
        final String expectedUrl = "https://accounts.dev.swisscows.com/welcome";


        final String code = openBaseURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox();

        registerPage
                .enterCode(code)
                .clickSubmitButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/welcome");

        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }
    @Test
    public void  tesLoginToSwisscowsVpn() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());

        registerPage
                .openExtension()
                .enterUserCredentialsToSwisscowsVpn()
                .clickSignInButtonInExtesion()
                .clickToggleVpnExtension();

        sleep(5000);
    }

}
