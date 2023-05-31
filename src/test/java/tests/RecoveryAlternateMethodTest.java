package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.RestorePage;
import tests.retrytest.Retry;
import utils.EmailUtils;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;

public class RecoveryAlternateMethodTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1213)
    public void tesRestoreAccountUsingAlternateEmailExternalUser_RecoveryMethodPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RecoveryMethodPage()
                .clickAlternateMailMethod()
                .clickProceedButton()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);;

        final String actualTittle =restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .repeatUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickSubmitButton()
                .waitLogoInSidebarToBeVisible()
                .getTitle();

        Assert.assertEquals(restorePage.getCurrentURL(),ProjectConstants.URL_DASHBOARD_PAGE);
        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_DASHBOARD_PAGE);

    }
    @Test
    @QaseId(value = 1214)
    public void tesRestoreAccountUsingPhoneNumberExternalUser_RecoveryMethodPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RecoveryMethodPage()
                .clickPhoneNumberMethod()
                .clickProceedButton()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final String actualTittle = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .repeatUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickSubmitButton()
                .waitLogoInSidebarToBeVisible()
                .getTitle();

        Assert.assertEquals(restorePage.getCurrentURL(),ProjectConstants.URL_DASHBOARD_PAGE);
        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_DASHBOARD_PAGE);

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1215)
    public void tesRestoreAccountUsingAlternateEmailSwisscowsUser_RecoveryMethodPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .clickSubmitButton_RecoveryMethodPage()
                .clickAlternateMailMethod()
                .clickProceedButton()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final String actualTittle = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .repeatUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickSubmitButton()
                .waitLogoInSidebarToBeVisible()
                .getTitle();

        Assert.assertEquals(restorePage.getCurrentURL(),ProjectConstants.URL_DASHBOARD_PAGE);
        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_DASHBOARD_PAGE);

    }
}
