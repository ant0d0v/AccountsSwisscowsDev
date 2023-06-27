package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.BlockedPage;
import pages.footer_menu.LoginPage;
import utils.ProjectConstants;

public class BlockedTest extends BaseTest {
    @Test
    @QaseTitle("Link in the footer menu navigate to corresponding page")
    @QaseId(value = 1534)
    public void testLinkInTheFooterNavigateToCorrespondingPage_BlockedPage() {
        LoginPage loginPage = new  LoginPage(getDriver());

        final String actualUrl = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.BLOCKED_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Blocked()
                .waitMainImageToBeVisible_BlockedPage()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .getCurrentURL();

        Assert.assertEquals(actualUrl,ProjectConstants.URL_REGISTER_PAGE);
        Assert.assertEquals(loginPage.getH1Text(),ProjectConstants.H1_TEXT_REGISTER_PAGE);
    }
    @Test
    @QaseTitle("Verify that the support link redirects to the corresponding page")
    @QaseId(value = 1532)
    public void testLinkSupportRedirectToCorrespondingPage_BlockedPage() throws InterruptedException {
        BlockedPage blockedPage = new BlockedPage(getDriver());
        final String expectedTittle = "Contact us | Swisscows";

        final String oldUrl = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.BLOCKED_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Blocked()
                .waitMainImageToBeVisible_BlockedPage()
                .getCurrentURL();

        final String newUrl = blockedPage
                .clickSupportLink()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(blockedPage.getTitle(),expectedTittle);
    }
    @Test
    @QaseTitle("Verify the H1 text on the Blocked page")
    @QaseId(value = 1531)
    public void testH1Text_BlockedPage()  {
        BlockedPage blockedPage = new BlockedPage(getDriver());

        final String actualH1Text = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.BLOCKED_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Blocked()
                .waitMainImageToBeVisible_BlockedPage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_BLOCKED_PAGE);
        Assert.assertEquals(blockedPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseTitle("Verify that the main image is displayed ")
    @QaseId(value = 1533)
    public void testMainImageIsDisplayed_Blocked()  {
        BlockedPage blockedPage = new BlockedPage(getDriver());

        openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.BLOCKED_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Blocked()
                .waitMainImageToBeVisible_BlockedPage();


        Assert.assertTrue(blockedPage.mainImageIsDisplayed());
    }
    @Test
    @QaseTitle("Verify the description text")
    @QaseId(value = 1535)
    public void testDescriptionText_BlockedPage()  {
        final String expectedDescription = "This might be because we've detected the suspicious activity on your account "
                + "or we found that your account violates the Terms of use.\n"
                + "\n"
                + "Please, contact the support.";

        final String actualDescription = openLoginURL()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.BLOCKED_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Blocked()
                .waitMainImageToBeVisible_BlockedPage()
                .getDescriptionText();

        Assert.assertEquals(actualDescription,expectedDescription);
    }
}
