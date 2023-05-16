package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.PlatinumPage;
import pages.sidebar_menu.SubscriptionsPage;
import pages.sidebar_menu.VpnStandardPage;
import utils.ProjectConstants;

import java.util.List;

public class YourSubscriptionsTest extends BaseTest {
    @QaseTitle("To verify that clicking the 'See details' link in the subscription page redirects "
            + "the user to the corresponding Platinum subscription page and displays the correct bought message.")
    @Test
    @QaseId(value = 1388)
    public void testLink_See_details_RedirectToCorrespondingPage_ForPlatinumSubscription() throws InterruptedException {
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
    @QaseTitle("To verify that clicking the 'See details' link in the subscription page redirects "
            + "the user to the corresponding VPN subscription page and displays the correct bought message.")
    @Test
    @QaseId(value = 1389)
    public void testLink_See_details_RedirectToCorrespondingPage_ForVpnSubscription() throws InterruptedException {
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
    @QaseTitle("To verify that the logo of the Platinum subscription is displayed on the subscription page.")
    @Test
    @QaseId(value = 1390)
    public void testLogoOfPlatinumSubscriptionIsDysplaed_SubscriptionPage() throws InterruptedException {
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
    @QaseTitle("To verify that the logo of the Vpn subscription is displayed on the subscription page.")
    @Test
    @QaseId(value = 1391)
    public void testLogoOfVpnSubscriptionIsDysplaed_SubscriptionPage() throws InterruptedException {
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
    @QaseTitle("To verify the text displayed in the cancel subscription popup when canceling a subscription.")
    @Test
    @QaseId(value = 1392)
    public void testCheckTextCancelSubscriptionPopupWhenCancelingSubscription() throws InterruptedException {
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
    @QaseTitle("To verify that clicking the 'No, I've changed my mind' link in the cancel subscription popup closes the popup.")
    @Test
    @QaseId(value = 1393)
    public void testLink_No_I_ve_changed_my_mind_OfCancelSubscriptionPopup() throws InterruptedException {
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
    @QaseTitle("To verify that the image is displayed in the cancel subscription popup.")
    @Test
    @QaseId(value = 1394)
    public void testImageIsDysplaedOfCancelSubscriptionPopup() throws InterruptedException {
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
}
