package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.EmailPremiumPage;
import pages.sidebar_menu.EmailStandardPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailPremiumTest extends BaseTest {
    @Test
    @QaseId(value = 1246)
    public void testH1Text_EmailPremiumPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_PREMIUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1248)
    public void testButtonBuyNowForSwisscowsUser_EmailPremiumPage(){
        EmailPremiumPage swisscowsEmailPremiumPage = new EmailPremiumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription();

        Assert.assertTrue(swisscowsEmailPremiumPage.buyNowButtonOfProductIsDisplayed());
    }
    @Test
    @QaseId(value = 1247)
    public void testButtonBuyNowForExternalUser_EmailPremiumPage(){
        EmailPremiumPage swisscowsEmailPremiumPage = new EmailPremiumPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription();

        Assert.assertFalse(swisscowsEmailPremiumPage.isBuyNowButtonOfPresent());
    }
    @Test
    @QaseId(value = 1244)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailPremiumPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailPremiumPage swisscowsEmailPremiumPage = new EmailPremiumPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailPremiumPage.getTitle(),ProjectConstants.TITLE_PRODUCTS_PAGE );
    }
    @Test
    @QaseId(value = 1249)
    public void testH2Text_EmailPremiumPage(){
        final List<String> expectedH2texts = List.of(
                "What we guarantee with Swisscows.email",
                "Our advantages",
                "Features"
        );

        final List actualH2texts = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .getH2Texts();

        Assert.assertEquals(actualH2texts,expectedH2texts);
    }
    @Test
    @QaseId(value = 1250)
    public void testAllIconsAreDysplaedOnThePage_EmailPremiumPage(){
        EmailPremiumPage swisscowsEmailPremiumPage = new EmailPremiumPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription();


        Assert.assertTrue(swisscowsEmailPremiumPage.allIconsOfProductIsDysplaed());
        Assert.assertTrue(productsPage.logoAllSubscriptionsIsDysplaed());
    }
    @Test
    @QaseId(value = 1245)
    public void testButtonBuyNowRedirectToCorrespondingPage_EmailPremiumPage(){

        EmailPremiumPage swisscowsEmailPremiumPage = new EmailPremiumPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .getCurrentURL();

        final String newUrl = swisscowsEmailPremiumPage
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailPremiumToBeVisible()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailPremiumPage.getTitle(),ProjectConstants.TITLE_EMAIL_PREMIUM_BUY_PAGE);
    }
    @Test
    @QaseId(value = 1266)
    public void testFeaturesTextsOfProduct_VpnStandardPage(){
        final List<String> expectedFeaturesText = List.of(
                "1000 emails per day",
                "50 GB storage",
                "IMAP settings",
                "Unlimited folders / labels",
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
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .getFeaturesTextOfProduct();


        Assert.assertEquals(actualFeaturesText,expectedFeaturesText);

    }
}
