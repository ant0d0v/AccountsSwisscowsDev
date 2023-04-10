package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.LoginPage;

public class ForgotTest  extends BaseTest {
    @Test
    public void testRestoreUnconfirmedAccountSwisscowsUser_ForgotPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Recovery options - Swisscows Accounts";
        final String expectedUrl = "https://accounts.dev.swisscows.com/recovery";

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .enterUserEmail("tester")
                .clickSubmitButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();


        Assert.assertEquals(actualTittle,expectedTittle);
        Assert.assertEquals(loginPage.getCurrentURL(),expectedUrl);
    }
    @Test
    public void testLinkSupportRedirectToCorrespondingPage_ForgotPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        final String expectedTittle = "Recovery options - Swisscows Accounts";
        final String expectedUrl = "https://accounts.dev.swisscows.com/recovery";

        final String actualTittle = openLoginURL()
                .clickLinkForgotPassword()
                .clickSubmitButton_RecoveryPage()
                .waitMainImageToBeVisible_RecoveryPage()
                .getTitle();


        Assert.assertEquals(actualTittle,expectedTittle);
        Assert.assertEquals(loginPage.getCurrentURL(),expectedUrl);
    }

}
