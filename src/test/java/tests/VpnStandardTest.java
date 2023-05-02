package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.EmailPremiumPage;
import pages.sidebar_menu.EmailStandardPage;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.VpnStandardPage;
import utils.ProjectConstants;

import java.util.List;

public class VpnStandardTest extends BaseTest {
    @Test
    @QaseId(value = 1253)
    public void testH1Text_VpnStandardPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_VPN_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1255)
    public void testButtonBuyNowForSwisscowsUser_VpnStandardPage(){
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription();

        Assert.assertTrue(vpnStandardPage.buyNowButtonOfProductIsDisplayed());
    }
    @Test
    @QaseId(value = 1254)
    public void testButtonBuyNowForExternalUser_VpnStandardPage(){
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription();

        Assert.assertTrue(vpnStandardPage.buyNowButtonOfProductIsDisplayed());
    }
    @Test
    @QaseId(value = 1251)
    public void testLinkBackToListRedirectToCorrespondingPage_VpnStandardPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(vpnStandardPage.getTitle(),ProjectConstants.TITLE_PRODUCTS_PAGE );
    }
    @Test
    @QaseId(value = 1256)
    public void testH2Text_VpnStandardPage(){
        final List<String> expectedH2texts = List.of(
                "How does a Swisscows proxy server work?",
                "Features"
        );

        final List actualH2texts = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getH2Texts();

        Assert.assertEquals(actualH2texts,expectedH2texts);
    }
    @Test
    @QaseId(value = 1257)
    public void testAllIconsAreDysplaedOnThePage_VpnStandardPage(){
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription();


        Assert.assertTrue(vpnStandardPage.allIconsOfProductIsDysplaed());
        Assert.assertTrue(productsPage.logoAllSubscriptionsIsDysplaed());
    }
    @Test
    @QaseId(value = 1252)
    public void testButtonBuyNowRedirectToCorrespondingPage_VpnStandardPage(){

        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getCurrentURL();

        final String newUrl = vpnStandardPage
                .clickBuyNowButtonOfProduct()
                .waitLogoVpnStandardToBeVisible()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(vpnStandardPage.getTitle(),ProjectConstants.TITLE_VPN_STANDARD_BUY_PAGE);
    }
    @Test
    @QaseId(value = 1265)
    public void testFeaturesTextsOfProduct_VpnStandardPage(){
        final List<String> expectedFeaturesText = List.of(
                "Swiss proxy server",
                "Unlimited traffic",
                "Up to 3 devices",
                "Free support"
        );

        final List<String> actualFeaturesText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .getFeaturesTextOfProduct();


        Assert.assertEquals(actualFeaturesText,expectedFeaturesText);

    }
}
