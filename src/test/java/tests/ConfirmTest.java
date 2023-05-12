package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.ConfirmPage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ConfirmTest extends BaseTest {

    @Test(priority = 1)
    @QaseId(value = 1122)
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
    @Test(priority = 2)
    @QaseId(value = 1123)
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
    @Test(priority = 3)
    @QaseId(value = 1124)
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
    @Test(priority = 4,retryAnalyzer = Retry.class)
    @QaseId(value = 1126)
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
    
    @Test(priority = 5)
    @QaseId(value = 1127)
    public void testLinkIdidntGetCodeSendCodeToPhoneNumber_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        final int oldCountMessage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .enterNewPhoneNumber()
                .clickSubmitButton()
                .waitUntilMainImageToBeVisibly()
                .getMessageCountToGmailBox();

        final int newCountMessage = confirmPage
                .clickLinkLinkIdidntGetCode()
                .getMessageCountToGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);
    }
    @Test(priority = 6)
    @QaseId(value = 1125)
    public void testH1TextWhenConfirmingEmail_ConfirmPage()  {
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
    @Test(priority = 7)
    @QaseId(value = 1130)
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
    @Test(priority = 8)
    @QaseId(value = 1128)
    public void testHoverSubmitButton_ConfirmPage() throws InterruptedException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final List<String> colorButtonWithoutHover = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForGmailUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButton()
                .waitUntilMainImageToBeVisibly()
                .getColorButton();

        final List<String> colorButtonWhenHover = confirmPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test(priority = 9)
    @QaseId(value = 1131)
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
    @Test(priority = 10)
    @QaseId(value = 1236)
    public void ConfirmingUnconfirmedSwisscowsAccount_ConfirmPage() throws InterruptedException, MessagingException, IOException {
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        String code = openLoginURL()
                .enterUserCredentialsUnconfirmedAccountSwisscowsUser()
                .clickLoginButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .enterPhoneNumber()
                .clickSubmitButton()
                .waitUntilMainImageToBeVisibly()
                .getCodeFromGmailBox();

         confirmPage
                 .enterCode(code)
                 .clickSubmitButton()
                 .waitMainImageToBeVisible_WelcomePage();

        Assert.assertEquals(confirmPage.getCurrentURL(), ProjectConstants.URL_WELCOME_PAGE);


    }
}
