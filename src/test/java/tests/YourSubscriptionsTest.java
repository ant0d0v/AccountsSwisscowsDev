package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.DashboardPage;
import pages.sidebar_menu.PlatinumPage;
import pages.sidebar_menu.SubscriptionsPage;
import pages.sidebar_menu.VpnStandardPage;
import utils.ProjectConstants;

import java.util.List;

public class YourSubscriptionsTest extends BaseTest {
    @Test(priority = 1)
    @QaseTitle("To verify that clicking the 'See details' link in the subscription page redirects "
            + "the user to the corresponding Platinum subscription page and displays the correct bought message.")
    @QaseId(value = 1388)
    public void testLink_See_details_RedirectToCorrespondingPage_ForPlatinumSubscription(){
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeDetailsLink();

        final String actualTextOfBoughtMessage = platinumPage
                .waitToBeVisibleBoughtMessage()
                .getBoughtMessage();

        final String currentUrl = platinumPage.getCurrentURL();

        Assert.assertEquals(currentUrl,ProjectConstants.URL_PLATINUM_PAGE);
        Assert.assertEquals(actualTextOfBoughtMessage,"You have already purchased this subscription!");
    }
    @Test(priority = 2)
    @QaseTitle("To verify that clicking the 'See details' link in the subscription page redirects "
            + "the user to the corresponding VPN subscription page and displays the correct bought message.")
    @QaseId(value = 1389)
    public void testLink_See_details_RedirectToCorrespondingPage_ForVpnSubscription(){
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeDetailsLink();

        final String actualTextOfBoughtMessage = vpnStandardPage
                .waitToBeVisibleBoughtMessage()
                .getBoughtMessage();

        final String currentUrl = vpnStandardPage.getCurrentURL();

        Assert.assertEquals(currentUrl,ProjectConstants.URL_VPN_STANDARD_PAGE);
        Assert.assertEquals(actualTextOfBoughtMessage,"You have already purchased this subscription!");
    }

    @Test(priority = 3)
    @QaseTitle("To verify that the logo of the Platinum subscription is displayed on the subscription page.")
    @QaseId(value = 1390)
    public void testLogoOfPlatinumSubscriptionIsDysplaed_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleLogoOfPlatinumSubscription();

        Assert.assertTrue(subscriptionsPage.logoOfPlatinumSubscriptionIsDysplaed());

    }

    @Test(priority = 4)
    @QaseTitle("To verify that the logo of the Vpn subscription is displayed on the subscription page.")
    @QaseId(value = 1391)
    public void testLogoOfVpnSubscriptionIsDysplaed_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleLogoOfVpnSubscription();

        Assert.assertTrue(subscriptionsPage.logoOfVpnSubscriptionIsDysplaed());

    }

    @Test(priority = 5)
    @QaseTitle("To verify the text displayed in the cancel subscription popup when canceling a subscription.")
    @QaseId(value = 1392)
    public void testCheckTextCancelSubscriptionPopupWhenCancelingSubscription(){
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        final List<String> expectedDescriptionH1Text = List.of(
                "The subscription renewal will be cancelled.\n"
                        + "\n"
                        + "You will still be able to access all features provided by the subscription until the end of payed period.\n"
                        + "\n"
                        + "Are you sure you want to cancel the subscription?"
        );
        final String expectedH1Text = "Cancel subscription";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickUnsubscribeButton()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfCancelSubscriptionPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text, expectedDescriptionH1Text);
    }

    @Test(priority = 6)
    @QaseTitle("To verify that clicking the 'No, I've changed my mind' link in the cancel subscription popup closes the popup.")
    @QaseId(value = 1393)
    public void testLink_No_I_ve_changed_my_mind_OfCancelSubscriptionPopup(){
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickUnsubscribeButton()
                .clickLinkInPopup();

        Assert.assertFalse(subscriptionsPage.isPopupPresent());
    }

    @Test(priority = 7)
    @QaseTitle("To verify that the image is displayed in the cancel subscription popup.")
    @QaseId(value = 1394)
    public void testImageIsDysplaedOfCancelSubscriptionPopup() {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickUnsubscribeButton()
                .waitVisibleImageInCancelSubscriptionPopup();

        Assert.assertTrue(subscriptionsPage.imageOfCancelSubscriptionIsDysplaed());
    }
    @Test(priority = 8)
    @QaseTitle("To verify that the VPN subscription is canceled for an external user.")
    @QaseId(value = 1395)
    public void testCancelVpnSubscriptio_ExternalUser() {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        final String expectedAttribute = "Transferred 0 bytes / ∞";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickUnsubscribeButton()
                .clickYesButtonInCancelPopup()
                .waitUnsubscribeButtonTobeNotClickable();

        Assert.assertFalse(subscriptionsPage.buttonUnsubscribeIsEnabled());

        final String actualAttribute = dashboardPage
                .clickDashboardIconInSidebar()
                .waitAllWidgetsToBeVisible()
                .getTransferredOfVpn();

        Assert.assertEquals(actualAttribute, expectedAttribute);

    }
    @Test(priority = 9)
    @QaseTitle("To verify that the Platinum subscription is canceled for an external user.")
    @QaseId(value = 1396)
    public void testCancelPlatinumSubscriptio_SwisscowsUser() {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        final String expectedAttributeVpn = "Transferred 0 bytes / ∞";
        final String expectedAttributeEmail = "0 MB of 50.00 GB";

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickUnsubscribeButton()
                .clickYesButtonInCancelPopup()
                .waitUnsubscribeButtonTobeNotClickable();

        Assert.assertFalse(subscriptionsPage.buttonUnsubscribeIsEnabled());

        final String actualAttribute = dashboardPage
                .clickDashboardIconInSidebar()
                .waitAllWidgetsToBeVisible()
                .getTransferredOfVpn();

        final String actualAttributeEmail = dashboardPage.getStorageOfEmailBox();

        Assert.assertEquals(actualAttribute, expectedAttributeVpn);
        Assert.assertEquals(actualAttributeEmail, expectedAttributeEmail);

    }
}
