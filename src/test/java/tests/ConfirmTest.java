package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.ConfirmPage;
import pages.accounts.RestorePage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ConfirmTest extends BaseTest {

    @Test
    public void tesValidationErrorMessageCodeFieldIsEmpty_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                    "The security code is invalid."

        );

        final List<String> actualTextValidationError =  openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .clickSubmitButton()
                .getListValidationErrorMessage();

        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(confirmPage.isErrorImageIsDisplayed());
    }
    @Test
    public void tesValidationErrorMessageEnterInvalidCode_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The security code is invalid."

        );

        final List<String> actualTextValidationError =  openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .enterCode("000000")
                .clickSubmitButton()
                .getListValidationErrorMessage();

        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(confirmPage.isErrorImageIsDisplayed());
    }
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .enterCode("532555")
                .clickLinkInTheFooterMenu()
                .waitForUrlContains(ProjectConstants.URL_LOGIN_PAGE);

        Assert.assertEquals(confirmPage.getH1Text(), ProjectConstants.H1_TEXT_LOGIN_PAGE);
        Assert.assertEquals(confirmPage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test(retryAnalyzer = Retry.class)
    public void testLinkIdidntGetCodeSendLatterToEmailBox_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterNewExternalUserCredentials()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .waitUntilMainImageToBeVisibly()
                .getMessageCountToNewGmailBox();

        final int newCountMessage = confirmPage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountToNewGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);
    }
    
    @Test(retryAnalyzer = Retry.class)
    public void testLinkIdidntGetCodeSendCodeToPhoneNumber_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getMessageCountToGmailBox();

        final int newCountMessage = restorePage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountToGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);
    }
    @Test
    public void testH1TextWhenConfirmingEmail_ConfirmPage() throws InterruptedException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final  String expectedH1Text = "Confirm your email";


        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .enterCode("414563")
                .getH1Text();


        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(confirmPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    public void testDescriptionTextWhenConfirmingEmail_ConfirmPage() {

        final String actualDescription = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .enterCode("414563")
                .getDescriptionConfirmPage();

        Assert.assertTrue(actualDescription.contains("We have sent a mail with one-time code to your email-address"));

    }
    @Test
    public void testHoverSubmitButton_ConfirmPage() throws InterruptedException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .getColorButton();

        final List<String> colorButtonWhenHover = confirmPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void testMainImageIsDisplayed_ConfirmPage() {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .waitUntilMainImageToBeVisibly();

        Assert.assertTrue(confirmPage.imageIsDisplayedConfirmPage());

    }
}
