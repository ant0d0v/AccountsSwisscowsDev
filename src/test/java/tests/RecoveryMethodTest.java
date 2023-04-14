package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.RestorePage;
import tests.retrytest.Retry;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;

public class RecoveryMethodTest extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void tesRestoreAccountUsingEmail_ForgotPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

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
    @Test(retryAnalyzer = Retry.class)
    public void tesRestoreAccountUsingPhoneNumberSwisscowsUser_ForgotPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .clickSubmitButton_RecoveryMethodPage()
                .clickPhoneNumberMethod()
                .clickProceedButton()
                .getCodeFromGmailBox();

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


}
