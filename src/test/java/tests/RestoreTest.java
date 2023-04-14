package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.ForgotPage;
import pages.accounts.RestorePage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

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
                .enterUserEmail(ProjectConstants.GMAIL_USER)
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
                .enterUserEmail(ProjectConstants.GMAIL_USER)
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

         openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkInTheFooterMenu()
                .waitForUrlContains(ProjectConstants.URL_LOGIN_PAGE);

        final String actualTitle = restorePage.getTitle();

        Assert.assertEquals(actualTitle,ProjectConstants.TITLE_LOGIN_PAGE);
        Assert.assertEquals(restorePage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testLinkIdidntGetCodeSendLatterToEmailBox_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
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
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getColorButton();

        final List<String> colorButtonWhenHover = forgotPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void testH1Text_RestorePage() throws InterruptedException {
        ForgotPage forgotPage = new ForgotPage(getDriver());

        final String actualH1Text = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_FORGOT_PAGE);
        Assert.assertEquals(forgotPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    public void testDescriptionTextWhenRestoringUsingEmail_RestorePage() throws InterruptedException {

        final  List<String> expectedDescription = List.of(
                "We have sent a mail with one-time code to your email-address qae***********@gmail.com.\n"
                        + "\n"
                        + "Please, type it below to proceed:"

        );

        final List<String> actualDescription = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getDescriptionRestorePage();


        Assert.assertEquals(actualDescription, expectedDescription);

    }


}
