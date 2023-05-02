package tests;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

import java.util.List;

public class PlatinumTest extends BaseTest {
    @Test
    @QaseId(value = 1260)
    public void testH1Text_PlatinumPage(){
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

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1262)
    public void testButtonBuyNowForSwisscowsUser_PlatinumPage(){
        PlatinumPage platinumPage =new PlatinumPage(getDriver());
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
    public void testButtonBuyNowForExternalUser_VpnStandardPage(){
        PlatinumPage platinumPage =new PlatinumPage(getDriver());
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
    public void testLinkBackToListRedirectToCorrespondingPage_PlatinumPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        PlatinumPage platinumPage =new PlatinumPage(getDriver());
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

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(platinumPage.getTitle(),ProjectConstants.TITLE_PRODUCTS_PAGE );
    }
    @Test
    @QaseId(value = 1263)
    public void testH2Text_PlatinumPage(){
        final List<String> expectedH2texts = List.of(
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

        Assert.assertEquals(actualH2texts,expectedH2texts);
    }
    @Test
    @QaseId(value = 1264)
    public void testAllIconsAreDysplaedOnThePage_PlatinumPage(){

        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription();

        Assert.assertTrue(productsPage.logoAllSubscriptionsIsDysplaed());
    }
    @Test
    @QaseId(value = 1259)
    public void testButtonBuyNowRedirectToCorrespondingPage_PlatinumPage(){

        PlatinumPage platinumPage =new PlatinumPage(getDriver());

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
                .waitLogoEmailPremiumToBeVisible()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(platinumPage.getTitle(),ProjectConstants.TITLE_PLATINUM_BUY_PAGE);
    }

}
