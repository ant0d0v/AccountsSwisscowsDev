package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.BlockedPage;
import pages.footer_menu.LoginPage;
import pages.footer_menu.UserNotFoundPage;
import utils.ProjectConstants;
import utils.TestUtils;

public class UserNotFoundTest extends BaseTest {
    @Test
    @QaseTitle("Link in the footer menu navigate to corresponding page")
    @QaseId(value = 1539)
    public void testLinkInTheFooterNavigateToCorrespondingPage_UserNotFoundPage() {
        LoginPage loginPage = new  LoginPage(getDriver());

        final String actualUrl = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(TestUtils.getRandomName())
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .getCurrentURL();

        Assert.assertEquals(actualUrl,ProjectConstants.URL_REGISTER_PAGE);
        Assert.assertEquals(loginPage.getH1Text(),ProjectConstants.H1_TEXT_REGISTER_PAGE);
    }
    @Test
    @QaseTitle("Verify that the support link redirects to the corresponding page")
    @QaseId(value = 1537)
    public void testLinkSupportRedirectToCorrespondingPage_UserNotFoundPage() throws InterruptedException {
        BlockedPage blockedPage = new BlockedPage(getDriver());
        final String expectedTittle = "Contact us | Swisscows";

        final String oldUrl = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(TestUtils.getRandomName())
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage()
                .getCurrentURL();

        final String newUrl = blockedPage
                .clickSupportLink()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(blockedPage.getTitle(),expectedTittle);
    }
    @Test
    @QaseTitle("Verify the H1 text on the User not found page")
    @QaseId(value = 1536)
    public void testH1Text_UserNotFoundPage() {
        BlockedPage blockedPage = new BlockedPage(getDriver());

        final String actualH1Text = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(TestUtils.getRandomName())
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage()
                .getH1Text();

        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_USER_NOT_FOUND_PAGE);
        Assert.assertEquals(blockedPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseTitle("Verify that the main image is displayed ")
    @QaseId(value = 1538)
    public void testMainImageIsDisplayed_UserNotFound()  {
        UserNotFoundPage userNotFoundPage = new UserNotFoundPage(getDriver());

        openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(TestUtils.getRandomName())
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage();

        Assert.assertTrue(userNotFoundPage.mainImageIsDisplayed());
    }
    @Test
    @QaseTitle("Verify the description text")
    @QaseId(value = 1540)
    public void testDescriptionText_UserNotFoundPage()  {
        final String expectedDescription = "We didn't find the account with email random@swisscows.email in our database.\n"
                + "\n"
                + "Please, contact the support and provide as much information as you can in order to recover your account.";

        final String actualDescription = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail("random@swisscows.email")
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage()
                .getDescriptionText();

        Assert.assertEquals(actualDescription,expectedDescription);
    }
    @Test
    @QaseTitle("Verify that the Try login with another account redirects to the corresponding page")
    @QaseId(value = 1541)
    public void testLink_TryLoginWithAnotherAccount_RedirectToCorrespondingPage_UserNotFoundPage() throws InterruptedException {
        UserNotFoundPage userNotFoundPage = new UserNotFoundPage(getDriver());
        final String oldUrl = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(TestUtils.getRandomName())
                .clickLinkForgotPassword_UserNotFound()
                .waitMainImageToBeVisible_UserNotFoundPage()
                .getCurrentURL();

        final String newUrl = userNotFoundPage
                .clickAnotherAccountLink()
                .waitMainImageToBeVisible_LoginPage()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(userNotFoundPage.getTitle(),ProjectConstants.TITLE_LOGIN_PAGE);
    }

}
