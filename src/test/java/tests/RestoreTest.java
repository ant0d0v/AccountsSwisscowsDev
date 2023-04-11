package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.ForgotPage;
import pages.accounts.RestorePage;
import tests.retrytest.Retry;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RestoreTest extends BaseTest {
    @Test
    public void tesValidationErrorMessageCodeFieldIsEmpty_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The security code is invalid."

        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickSubmitButtonOnRestorePage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());

    }
    @Test
    public void tesValidationErrorMessageEnterInvalidCode_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The security code is invalid."

        );

        final List<String> actualTextValidationError = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .enterCode("123456")
                .clickSubmitButtonOnRestorePage()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());

    }
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final String expectedTitle = "Login - Swisscows Accounts";

         openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkInTheFooterMenu()
                .waitForUrlContains("https://accounts.dev.swisscows.com/login");

        final String actualTitle = restorePage.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);
        Assert.assertEquals(restorePage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
    @Test(retryAnalyzer = Retry.class)
    public void testLinkIdidntGetCodeSendLatterToEmailBox_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .getMessageCountToGmailBox();

        final int newCountMessage = restorePage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountToGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);


    }
    @Test
    public void testHoverSubmitButton_RestorePage() throws InterruptedException {
        ForgotPage forgotPage = new  ForgotPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .getColorButton();

        final List<String> colorButtonWhenHover = forgotPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void testH1Text_RestorePage() throws InterruptedException {
        ForgotPage forgotPage = new ForgotPage(getDriver());
        final  String expectedH1Text = "Recover account";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );

        final String actualH1Text = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(forgotPage.getH1FontSizes(), expectedFontSizesH1text);
    }
    @Test
    public void testDescriptionText_RestorePage() throws InterruptedException {

        final  List<String> expectedDescription = List.of(
                "We have sent a mail with one-time code to your email-address qae***********@gmail.com.\n"
                        + "\n"
                        + "Please, type it below to proceed:"

        );

        final List<String> actualDescription = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .getDescriptionRestorePage();


        Assert.assertEquals(actualDescription, expectedDescription);

    }


}
