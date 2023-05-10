package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.PlatinumBuyPlanIdPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class PlatinumPlanidTest extends BaseTest {
    @Test
    @QaseId(value = 1316)
    public void testH1TextMonthly_PlatinumPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1321)
    public void testH1TextAnnual_PlatinumPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfPlatinum()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1317)
    public void testTextPaymentSummaryOfAnnualPlan_PlatinumPlanPage(){
        final List<String> expectedText = List.of(
                "Swisscows Platinum\n"
                        + "100.61 CHF",
                "Value added tax\n"
                        + "8.39 CHF",
                "Total\n"
                        + "109.00 CHF"

        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfPlatinum()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1314)
    public void testTextPaymentSummaryOfMonthlyPlan_PlatinumPlanPage(){
        final List<String> expectedText = List.of(
                "Swisscows Platinum\n"
                        + "11.08 CHF",
                "Value added tax\n"
                        + "0.92 CHF",
                "Total\n"
                        + "12.00 CHF"
        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1313)
    public void testLinkBackToListRedirectToCorrespondingPage_PlatinumPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        PlatinumBuyPlanIdPage platinumBuyPlanIdPage = new PlatinumBuyPlanIdPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitMainImageToBeVisible()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(platinumBuyPlanIdPage.getTitle(),ProjectConstants.TITLE_PLATINUM_BUY_PAGE);
    }

    @Test
    @QaseId(value = 1315)
    public void testSubscriptionLogoIsDysplaedOnThePage_PlatinumPlanPage(){
        PlatinumBuyPlanIdPage platinumBuyPlanIdPage = new PlatinumBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitLogoEmailToBeVisible();

        Assert.assertTrue(platinumBuyPlanIdPage.logoOfEmailIsDysplaed());
    }
    @Test
    @QaseId(value = 1319)
    public void testMainImageIsDysplaedOnThePage_PlatinumPlanPage(){
        PlatinumBuyPlanIdPage platinumBuyPlanIdPage = new PlatinumBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitMainImageToBeVisible();

        Assert.assertTrue(platinumBuyPlanIdPage.mainImageOfPlanIdPageIsDysplaed());
    }
    @Test
    @QaseId(value = 1318)
    public void testSelectCardMethod_PlatinumPlanPage(){
        PlatinumBuyPlanIdPage platinumBuyPlanIdPage = new PlatinumBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        platinumBuyPlanIdPage
                .selectCardMethodOfPlatinum()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PLATINUM_CARD_PAGE);
        final String newURL = platinumBuyPlanIdPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(platinumBuyPlanIdPage.getCurrentURL().contains(ProjectConstants.URL_PLATINUM_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1320)
    public void testSelectPayPalMethod_PlatinumPlanPage(){
        PlatinumBuyPlanIdPage platinumBuyPlanIdPage = new PlatinumBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        platinumBuyPlanIdPage
                .selectPayPalMethodMethodOfPlatinum()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PAYPAL_PAGE);
        final String newURL = platinumBuyPlanIdPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(platinumBuyPlanIdPage.getCurrentURL().contains(ProjectConstants.URL_PAYPAL_PAGE));
    }
}
