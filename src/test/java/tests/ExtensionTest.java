package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ExtensionPage;
import pages.sidebar_menu.EmailStandardBuyPlanIdPage;
import utils.ProjectConstants;

public class ExtensionTest extends BaseTest {
    @Test
    public void testLoginToExtension(){
        ExtensionPage extensionPage = new ExtensionPage(getDriver());
        openExtension()
                .clickToggle()
                .enterUserEmail("a.qa@swisscows.email")
                .enterUserPassword("2075Deltuha")
                .clickSignInButton()
                .clickToggle();
        Assert.assertTrue(extensionPage.toggleIsTernOn());
    }
}
