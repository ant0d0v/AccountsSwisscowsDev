package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.CardMethodPage;
import pages.sidebar_menu.EmailPremiumPage;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.SubscriptionsPage;
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
                .getTextSuccessfulMessage();
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
                .getTextSuccessfulMessage();
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
}