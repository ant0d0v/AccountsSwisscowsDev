package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.RestorePage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ResetTest extends BaseTest {
    @Test
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
    @Test
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
    @Test
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
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_ForgotPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final String expectedTitle = "Login - Swisscows Accounts";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox();

        restorePage
                .enterCode(code)
                .clickSubmitButton()
                .clickLinkInTheFooterMenu()
                .waitForUrlContains("https://accounts.dev.swisscows.com/login");

        Assert.assertEquals(restorePage.getTitle(),expectedTitle);
        Assert.assertEquals(restorePage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }

}
