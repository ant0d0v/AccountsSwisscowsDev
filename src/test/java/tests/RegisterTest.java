package tests;

import base.BaseTest;
import org.testng.Assert;
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
    public void tesRegisterUser_RegisterPage() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());

        final String code = registerPage
                .getConfirmCodeToGmailBox();
        System.out.println(code);



    }





}
