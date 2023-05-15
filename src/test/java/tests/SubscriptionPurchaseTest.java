package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

import java.util.List;

public class SubscriptionPurchaseTest extends BaseTest {
    @Test(priority = 1)
    @QaseId(value = 1351)
    public void testBuyEmailStandardSubscriptionUsingCardVisa_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .payUsingVisa()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_STANDARD_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();
        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 2)
    @QaseId(value = 1351)
    public void testCheckStorageOfEmailBoxAfterBayingEmailStandard_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "0 MB of 5.00 GB";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getStorageOfEmailBox();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 3)
    @QaseId(value = 1351)
    public void testCheckSubscriptionEmailStandard_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "item active";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributeEmailStandardSubscription();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 4)
    @QaseId(value = 1351)
    public void testCheckTextPopupOfTheCurrentSubscriptionWhenBuyingEmailPremium_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        EmailPremiumPage emailPremiumPage = new EmailPremiumPage(getDriver());
        final String expectedH1Text = "Purchasing this product will cancel your current subscriptions:";
        final List<String> expectedDescriptionH1Text = List.of(
                "Swisscows.email Standard"
        );
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription_popup()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text,expectedDescriptionH1Text);
    }

    @Test(priority = 5)
    @QaseId(value = 1351)
    public void testBuyEmailPremiumSubscriptionUsingMasterCard_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        EmailPremiumPage emailPremiumPage = new EmailPremiumPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfEmailPremiumSubscription_popup()
                .clickConfirmButtonInPopup();
        emailPremiumPage
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .payUsingMasterCard()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_PREMIUM_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();
        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 6)
    @QaseId(value = 1351)
    public void testCheckStorageOfEmailBoxAfterBayingEmailPremium_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "0 MB of 50.00 GB";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getStorageOfEmailBox();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 7)
    @QaseId(value = 1351)
    public void testCheckTextPopupOfTheCurrentSubscriptionWhenBuyingEmailStandard_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        EmailPremiumPage emailPremiumPage = new EmailPremiumPage(getDriver());
        final List<String> expectedDescriptionH1Text = List.of(
                "Swisscows.email Premium"
        );
        final String expectedH1Text = "Purchasing this product will cancel your current subscriptions:";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription_popup()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text,expectedDescriptionH1Text);
    }

    @Test(priority = 8)
    @QaseId(value = 1351)
    public void testUpgradeSubscription_SwisscowsUser() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String expectedAttribute = "item active";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .getAttributeEmailPremiumSubscription();

        Assert.assertEquals(actualAttribute, expectedAttribute);
        Assert.assertEquals(productsPage.getAttributeEmailStandardSubscription(), "item");
    }
    @Test(priority = 9)
    @QaseId(value = 1351)
    public void testBuyEmailStandardSubscriptionUsingAmericanExpress_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        EmailStandardPage emailStandardPage = new EmailStandardPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfEmailStandardSubscription_popup()
                .clickConfirmButtonInPopup();
        emailStandardPage
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailStandard()
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .payUsingAmericanExpress()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_STANDARD_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 10)
    @QaseId(value = 1351)
    public void testBuyVpnStandardSubscriptionUsing3DSecure_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .payUsingVisa3DSecure()
                .waitForUrlContains(ProjectConstants.URL_VPN_STANDARD_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 11)
    @QaseId(value = 1351)
    public void testCheckStorageVpnBoxAfterBayingVpnSubscription_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "Transferred 0 bytes / ∞";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getTransferredOfVpn();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 12)
    @QaseId(value = 1351)
    public void testErrorPaymentSubscriptionUsing3DSecure_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        EmailPremiumPage emailPremiumPage = new EmailPremiumPage(getDriver());
        final String expectedErrorMessage = "Oops! Something went wrong";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfEmailPremiumSubscription_popup()
                .clickConfirmButtonInPopup();
        emailPremiumPage
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .errorPayUsingVisa3DSecure()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_PREMIUM_BUY_PAGE + "/error");

        final String actualErrorMessage = new SubscriptionsPage(getDriver())
                .waitErrorImage()
                .getTextInformationMessage();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
    @Test(priority = 13)
    @QaseId(value = 1351)
    public void testLink_Back_OfErrorPage_RedirectToCorrespondingPage_SwisscowsUser() throws InterruptedException {
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailPremiumPage emailPremiumPage = new EmailPremiumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfEmailPremiumSubscription_popup()
                .clickConfirmButtonInPopup();

        final String oldUrl = emailPremiumPage
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .errorPayUsingVisa3DSecure()
                .waitErrorImage()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(productsPage.getTitle(),ProjectConstants.TITLE_DASHBOARD_PAGE);
    }
    @Test(priority = 14)
    @QaseId(value = 1351)
    public void testCheckTextPopupOfTheCurrentSubscriptionWhenBuyingPlatinum_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        final List<String> expectedDescriptionH1Text = List.of(
                "Swisscows.email Standard",
                "Swisscows.VPN Standard"
        );
        final String expectedH1Text = "Purchasing this product will cancel your current subscriptions:";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription_popup()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text,expectedDescriptionH1Text);
    }
    @Test(priority = 15)
    @QaseId(value = 1351)
    public void testBuyPlatinumSubscriptionUsingPayPal_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfPlatinumSubscription_popup()
                .clickConfirmButtonInPopup();
        platinumPage
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .selectPayPalMethodMethodOfPlatinum()
                .clickToProceedButton_CardMethodPage()
                .payUsingPayPal()
                .waitForUrlContains(ProjectConstants.URL_PLATINUM_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 16)
    @QaseId(value = 1351)
    public void testCheckStorageOfEmailBoxAfterBayingPlatinumSubscription_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "0 MB of 50.00 GB";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getStorageOfEmailBox();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 17)
    @QaseId(value = 1351)
    public void testCheckStorageVpnBoxAfterBayingPlatinum_SwisscowsUser() throws InterruptedException {
        final String expectedAttribute = "Transferred 0 bytes / ∞";
        final String actualAttribute = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getTransferredOfVpn();

        Assert.assertEquals(actualAttribute, expectedAttribute);
    }
    @Test(priority = 18)
    @QaseId(value = 1351)
    public void testCheckTextPopupOfTheCurrentSubscriptionWhenUpgradePlatinum_BuyingVpn_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        final List<String> expectedDescriptionH1Text = List.of(
                "Swisscows Platinum"
        );
        final String expectedH1Text = "Purchasing this product will cancel your current subscriptions:";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text,expectedDescriptionH1Text);
    }
    @Test(priority = 19)
    @QaseId(value = 1351)
    public void testCheckTextPopupOfTheCurrentSubscriptionWhenUpgradePlatinum_BuyingEmailStandard_SwisscowsUser() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        final List<String> expectedDescriptionH1Text = List.of(
                "Swisscows Platinum"
        );
        final String expectedH1Text = "Purchasing this product will cancel your current subscriptions:";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription_popup()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = subscriptionsPage.getFontSizeH1TextOfPopup();
        final List<String> actualDescriptionH1Text = subscriptionsPage.getDescriptionTextOfPopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
        Assert.assertEquals(actualDescriptionH1Text,expectedDescriptionH1Text);
    }
    @Test(priority = 20)
    @QaseId(value = 1351)
    public void testBuyVpnStandardSubscriptionUsing3DSecure_ExternalUser() throws InterruptedException {

        final String expectedSuccessfulMessage = "Congratulations,\n"
                + "the payment was successful!";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .payUsingVisa3DSecure()
                .waitForUrlContains(ProjectConstants.URL_VPN_STANDARD_BUY_PAGE + "/success");

        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
                .waitSuccessImage()
                .getTextInformationMessage();

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
    @Test(priority = 21)
    @QaseId(value = 1351)
    public void testLink_No_I_ve_changed_my_mind_PopupOfTheCurrentSubscription() throws InterruptedException {
        SubscriptionsPage subscriptionsPage = new SubscriptionsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickSeeAllLink()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription_popup()
                .clickLinkInPopup();

        Assert.assertFalse(subscriptionsPage.isPopupPresent());
    }
}
