package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.ResetPage;
import pages.footer_menu.RestorePage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ResetTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1111)
    public void tesValidationErrorMessageFieldIsEmpty_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required"

        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox();

        final List actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1112)
    public void tesValidationErrorMessageInvalidNewPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password must contain at least 8 characters, including letters and numbers",
                "The field is required"


        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final List actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword("da12")
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1113)
    public void tesValidationErrorMessageInvalidRepeatPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password confirmation doesn't match"



        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final List actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .repeatUserPassword("2075Delt")
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1114)
    public void testLinkInTheFooterNavigateToCorrespondingPage_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        restorePage
                .enterCode(code)
                .clickLinkInTheFooterMenu()
                .waitForUrlContains(ProjectConstants.URL_LOGIN_PAGE);

        Assert.assertEquals(restorePage.getTitle(),ProjectConstants.TITLE_LOGIN_PAGE);
        Assert.assertEquals(restorePage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1115)
    public void testPlaceholderIsAvailable_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "New password"
        );
        final String attribute = "placeholder";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();


        final List<String> actualInnerTextOfPlaceholder = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1116)
    public void testH1Text_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        ResetPage resetPage = new ResetPage(getDriver());
        final  String expectedH1Text = "Reset password";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final String actualH1Text = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .waitMainImageToBeVisible_ResetPage()
                .getH1Text();




        Assert.assertTrue(resetPage.imageIsDisplayedResetPage());
        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(restorePage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }

}
