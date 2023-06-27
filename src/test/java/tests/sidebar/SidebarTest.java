package tests.sidebar;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.LoginPage;
import pages.sidebar_menu.DashboardPage;
import pages.sidebar_menu.SubscriptionsPage;
import utils.ProjectConstants;

public class SidebarTest extends BaseTest {
    @Test
    @QaseTitle("To verify that the user can successfully logout of their account.")
    @QaseId(value = 1397)
    public void testLogoutOfAccount() {
        LoginPage loginPage = new LoginPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickLogoutIconInSidebar()
                .clickLogoutButtonInPopup()
                .waitMainImageToBeVisible_LoginPage();

        Assert.assertTrue(loginPage.getCurrentURL().contains(ProjectConstants.URL_LOGIN_PAGE));
        Assert.assertEquals(loginPage.getH1Text(), ProjectConstants.H1_TEXT_LOGIN_PAGE);
    }

    @Test
    @QaseTitle(" Verify that the image is displayed in the logout popup")
    @QaseId(value = 1404)
    public void testImageIsDysplaedOfLogoutPopup() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickLogoutIconInSidebar()
                .waitVisibleImageInLogoutPopup();

        Assert.assertTrue(dashboardPage.mainImageOfLogoutPopup());
    }

    @Test
    @QaseTitle("Verify that the cancel link in the logout popup works correctly")
    @QaseId(value = 1405)
    public void testLink_Cancel_OfLogoutPopup() {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickLogoutIconInSidebar()
                .clickLinkInPopup();

        Assert.assertFalse(subscriptionsPage.isPopupPresent(), "Popup is present");
    }

    @Test
    @QaseTitle("Verify the text displayed in the logout popup")
    @QaseId(value = 1406)
    public void testCheckTextLogoutPopup() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        final String expectedH1Text = "Are you sure you want to logout of Swisscows account?";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickLogoutIconInSidebar()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = dashboardPage.getFontSizeH1TextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
    }

    @Test
    @QaseTitle("Wait for the logo in the sidebar to be visible.")
    @QaseId(value = 1407)
    public void testAvatarIsDisplayedInSidebar() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible();

        Assert.assertTrue(dashboardPage.avatarIsDisplayedOfSidebar());
    }

    @Test
    @QaseTitle("Verify that all icons are displayed in the sidebar")
    @QaseId(value = 1408)
    public void testAllIconsAreDisplayedInSidebar() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final int actualListSizeOfIcons = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getListSizeOfIconsInSidebar();

        Assert.assertEquals(actualListSizeOfIcons, 5);
        Assert.assertTrue(dashboardPage.allIconsAreDysplaedInSidebar());
    }

    @Test
    @QaseTitle("Verify that the icon is active in the sidebar when switching")
    @QaseId(value = 1409)
    public void testIconIsActiveInSidebarWhenSwitching() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final String oldColor = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getColorOfDashboardIconInSidebar();

        Assert.assertEquals(oldColor, "rgba(223, 93, 93, 1)");

        final String newColor = dashboardPage
                .clickPaymentsIcon()
                .getColorOfDashboardIconInSidebar();

        Assert.assertNotEquals(newColor,oldColor);
    }
}
