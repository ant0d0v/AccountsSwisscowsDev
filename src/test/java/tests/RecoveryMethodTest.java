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
        String userPassword = "2075Delt";

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
                .enterNewUserPassword(userPassword)
                .repeatUserPassword(userPassword)
                .clickSubmitButton()
                .waitLogoInSidebarToBeVisible()
                .getTitle();

        Assert.assertEquals(restorePage.getCurrentURL(),ProjectConstants.URL_DASHBOARD_PAGE);
        Assert.assertEquals(actualTittle,ProjectConstants.TITLE_DASHBOARD_PAGE);





    }


}
