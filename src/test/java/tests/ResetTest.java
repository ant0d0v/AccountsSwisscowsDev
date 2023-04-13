package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.ResetPage;
import pages.accounts.RestorePage;
import tests.retrytest.Retry;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ResetTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void tesValidationErrorMessageFieldIsEmpty_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required"

        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final List<String> actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    public void tesValidationErrorMessageInvalidNewPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password must contain at least 8 characters, including letters and numbers",
                "The field is required"


        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final List<String> actualTextValidationError = restorePage
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
    public void tesValidationErrorMessageInvalidRepeatPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password confirmation doesn't match"



        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final List<String> actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword("2075Deltuha")
                .repeatUserPassword("2075Delt")
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    public void testLinkInTheFooterNavigateToCorrespondingPage_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final String expectedTitle = "Login - Swisscows Accounts";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        restorePage
                .enterCode(code)
                .clickLinkInTheFooterMenu()
                .waitForUrlContains("https://accounts.dev.swisscows.com/login");

        Assert.assertEquals(restorePage.getTitle(),expectedTitle);
        Assert.assertEquals(restorePage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
    @Test(retryAnalyzer = Retry.class)
    public void testPlaceholderIsAvailable_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "New password"
        );
        final String attribute = "placeholder";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
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
    public void testH1Text_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        ResetPage resetPage = new ResetPage(getDriver());
        final  String expectedH1Text = "Reset password";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );
        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
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
        Assert.assertEquals(restorePage.getH1FontSizes(), expectedFontSizesH1text);
    }

}
