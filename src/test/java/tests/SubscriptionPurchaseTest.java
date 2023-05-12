package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

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
    public void testCheckSubscriptionPlatinum_SwisscowsUser() throws InterruptedException {
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

    @Test(priority = 3)
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

    @Test(priority = 4)
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
    @Test(priority = 5)
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
    @Test(priority = 6)
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
    @Test(priority = 7)
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
    @Test(priority = 8)
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
    @Test(priority = 9)
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
                .waitErrorImage()
                .getTextInformationMessage();

        Assert.assertEquals(actualSuccessfulMessage, expectedSuccessfulMessage);
    }
}
