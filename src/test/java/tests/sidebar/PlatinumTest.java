package tests.sidebar;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

import java.util.List;

public class PlatinumTest extends BaseTest {
    @Test
    @QaseId(value = 1260)
    public void testH1Text_PlatinumPage() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .getH1Text();

        Assert.assertEquals(actualH1text, ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }

    @Test
    @QaseId(value = 1262)
    public void testButtonBuyNowForSwisscowsUser_PlatinumPage() {
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription();

        Assert.assertTrue(platinumPage.buyNowButtonOfProductIsDisplayed());
    }

    @Test
    @QaseId(value = 1261)
    public void testButtonBuyNowForExternalUser_VpnStandardPage() {
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription();

        Assert.assertFalse(platinumPage.isBuyNowButtonOfPresent());
    }

    @Test
    @QaseId(value = 1258)
    public void testLinkBackToListRedirectToCorrespondingPage_PlatinumPage() {
        ProductsPage productsPage = new ProductsPage(getDriver());
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertEquals(platinumPage.getTitle(), ProjectConstants.TITLE_PRODUCTS_PAGE);
    }

    @Test
    @QaseId(value = 1263)
    public void testH2Text_PlatinumPage() {
        final List<String> expectedH2texts = List.of(
                "Swisscows.email Premium",
                "Features",
                "Swisscows.VPN",
                "Features"
        );

        final List actualH2texts = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .getH2Texts();

        Assert.assertEquals(actualH2texts, expectedH2texts);
    }

    @Test
    @QaseId(value = 1264)
    public void testAllIconsAreDysplaedOnThePage_PlatinumPage() {
        PlatinumPage platinumPage = new PlatinumPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription();

        Assert.assertTrue(platinumPage.allIconsOfProductIsDysplaed());
        Assert.assertTrue(productsPage.logoAllSubscriptionsIsDysplaed());

    }

    @Test
    @QaseId(value = 1259)
    public void testButtonBuyNowRedirectToCorrespondingPage_PlatinumPage() {

        PlatinumPage platinumPage = new PlatinumPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .getCurrentURL();

        final String newUrl = platinumPage
                .clickBuyNowButtonOfProduct()
                .waitLogoPlatinumToBeVisible()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl, oldUrl);
        Assert.assertEquals(platinumPage.getTitle(), ProjectConstants.TITLE_PLATINUM_BUY_PAGE);
    }

    @Test
    @QaseId(value = 1365)
    public void testFeaturesTextsOfProduct_PlatinumPage() {
        final List<String> expectedFeaturesText = List.of(
                "1000 emails per day",
                "50 GB storage",
                "IMAP settings",
                "Unlimited folders / labels",
                "Free support",
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
                .clickBuyNowButtonOfPlatinumSubscription()
                .getFeaturesTextOfProduct();

        Assert.assertEquals(actualFeaturesText, expectedFeaturesText);

    }
    @Test(dataProvider = "PlatinumLinksData", dataProviderClass = TestData.class)
    @QaseId(value = 1366)
    public void testLinkOfPageRedirectToCorrespondingPage_PlatinumPage(
            int index, String expectedH1Text,String expectedUrl){
        PlatinumPage platinumPage = new PlatinumPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .getCurrentURL();

        platinumPage
                .clickLinksOfPage(index);

        final String actualURL = platinumPage
                .getCurrentURL();
        final String actualTittle = platinumPage.getH1Text();

        Assert.assertNotEquals(oldUrl, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }
}
