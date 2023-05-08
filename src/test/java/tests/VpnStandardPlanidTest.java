package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.VpnStandardBuyPlanIdPage;
import utils.ProjectConstants;

import java.util.List;

public class VpnStandardPlanidTest extends BaseTest {
    @Test
    @QaseId(value = 1325)
    public void testH1TextMonthly_VpnStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_VPN_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1330)
    public void testH1TextAnnual_VpnStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfVpnStandard()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_VPN_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1326)
    public void testTextPaymentSummaryOfAnnualPlan_VpnStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedText = List.of(
                "Swisscows.VPN Standard\n"
                        + "77.99 CHF",
                "Value added tax\n"
                        + "6.01 CHF",
                "Total\n"
                        + "84.00 CHF"

        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfVpnStandard()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1323)
    public void testTextPaymentSummaryOfMonthlyPlan_VpnStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedText = List.of(
                "Swisscows.VPN Standard\n"
                        + "9.29 CHF",
                "Value added tax\n"
                        + "0.71 CHF",
                "Total\n"
                        + "10.00 CHF"
        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1322)
    public void testLinkBackToListRedirectToCorrespondingPage_VpnStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        VpnStandardBuyPlanIdPage vpnStandardBuyPlanIdPage = new VpnStandardBuyPlanIdPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitMainImageToBeVisible()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(vpnStandardBuyPlanIdPage.getTitle(),ProjectConstants.TITLE_VPN_STANDARD_BUY_PAGE );
    }

    @Test
    @QaseId(value = 1324)
    public void testSubscriptionLogoIsDysplaedOnThePage_VpnStandardPlanPage(){
        VpnStandardBuyPlanIdPage vpnStandardBuyPlanIdPage = new VpnStandardBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitLogoVpnToBeVisible();

        Assert.assertTrue(vpnStandardBuyPlanIdPage.logoOfEmailIsDysplaed());
    }
    @Test
    @QaseId(value = 1328)
    public void testMainImageIsDysplaedOnThePage_VpnStandardPlanPage(){
        VpnStandardBuyPlanIdPage vpnStandardBuyPlanIdPage = new VpnStandardBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitMainImageToBeVisible();

        Assert.assertTrue(vpnStandardBuyPlanIdPage .mainImageOfPlanIdPageIsDysplaed());
    }
    @Test
    @QaseId(value = 1327)
    public void testSelectCardMethod_VpnStandardPlanPage(){
        VpnStandardBuyPlanIdPage vpnStandardBuyPlanIdPage = new VpnStandardBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitLogoVpnToBeVisible()
                .getCurrentURL();
        vpnStandardBuyPlanIdPage
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE );
        final String newURL = vpnStandardBuyPlanIdPage .getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(vpnStandardBuyPlanIdPage .getCurrentURL().contains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE ));
    }
    @Test
    @QaseId(value = 1329)
    public void testSelectPayPalMethod_VpnStandardPlanPage(){
        VpnStandardBuyPlanIdPage vpnStandardBuyPlanIdPage = new VpnStandardBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitLogoVpnToBeVisible()
                .getCurrentURL();
        vpnStandardBuyPlanIdPage
                .selectPayPalMethodMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PAYPAL_PAGE);
        final String newURL = vpnStandardBuyPlanIdPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(vpnStandardBuyPlanIdPage.getCurrentURL().contains(ProjectConstants.URL_PAYPAL_PAGE));
    }
}
