package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.ForgotPage;
import pages.footer_menu.RestorePage;
import tests.retrytest.Retry;
import utils.EmailUtils;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class RestoreTest extends BaseTest {
    @Test
    @QaseId(value = 1096)
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
    @QaseId(value = 1105)
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
    @QaseId(value = 1107)
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
    @QaseId(value = 1117)
    public void testLinkIdidntGetCodeSendLatterToEmailBox_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getMessageCountFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final int newCountMessage = restorePage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        Assert.assertNotEquals(newCountMessage,oldCountMessage);


    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1118)
    public void testLinkIdidntGetCodeSendCodeToPhoneNumber_RestorePage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.NEW_SWISSCOWS_EMAIL_USER)
                .clickSubmitButton_RecoveryMethodPage()
                .clickPhoneNumberMethod()
                .clickProceedButton()
                .getMessageCountFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final int newCountMessage = restorePage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        Assert.assertNotEquals(newCountMessage,oldCountMessage);


    }
    @Test
    @QaseId(value = 1119)
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
    @QaseId(value = 1110)
    public void testH1Text_RestorePage() throws InterruptedException {
        ForgotPage forgotPage = new ForgotPage(getDriver());

        final String actualH1Text = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_RESTORE_PAGE);
        Assert.assertEquals(forgotPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1121)
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
