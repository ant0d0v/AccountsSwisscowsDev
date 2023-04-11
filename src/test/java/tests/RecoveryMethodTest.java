package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.RestorePage;

import javax.mail.MessagingException;
import java.io.IOException;

public class RecoveryMethodTest extends BaseTest {
    @Test
    public void tesRestoreAccountUsingEmail_ForgotPage() throws MessagingException, IOException, InterruptedException {
        RestorePage restorePage = new RestorePage(getDriver());
        final String expectedTittle = "Dashboard - Swisscows Accounts";
        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail("qaengineer1203@gmail.com")
                .clickSubmitButton_RestorePage()
                .clickLinkIdidntGetCodeUntilVisiblePreloader()
                .getCodeFromGmailBox();

        final String actualTittle =restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword("2075Delt")
                .repeatUserPassword("2075Delt")
                .clickSubmitButton()
                .waitLogoInSidebarToBeVisible()
                .getTitle();

        Assert.assertEquals(restorePage.getCurrentURL(),"https://accounts.dev.swisscows.com/");
        Assert.assertEquals(actualTittle,expectedTittle);





    }


}
