package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.EmailStandardPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailStandardTest extends BaseTest {
    @Test
    @QaseId(value = 973)
    public void testH1Text_EmailStandardPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 975)
    public void testButtonBuyNowForSwisscowsUser_EmailStandardPage(){
        EmailStandardPage swisscowsEmailStandardPage = new EmailStandardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription();

        Assert.assertTrue(swisscowsEmailStandardPage.buyNowButtonOfProductIsDisplayed());
    }
    @Test
    @QaseId(value = 974)
    public void testButtonBuyNowForExternalUser_EmailStandardPage(){
        EmailStandardPage swisscowsEmailStandardPage = new EmailStandardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription();

        Assert.assertFalse(swisscowsEmailStandardPage.isBuyNowButtonOfPresent());
    }
    @Test
    @QaseId(value = 971)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailStandardPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailStandardPage swisscowsEmailStandardPage = new EmailStandardPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailStandardPage.getTitle(),ProjectConstants.TITLE_PRODUCTS_PAGE );
    }
    @Test
    @QaseId(value = 976)
    public void testH2Text_EmailStandardPage(){
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
                .clickBuyNowButtonOfEmailStandardSubscription()
                .getH2Texts();

        Assert.assertEquals(actualH2texts,expectedH2texts);
    }
    @Test
    @QaseId(value = 977)
    public void testAllIconsAreDysplaedOnThePage_EmailStandardPage(){
        EmailStandardPage swisscowsEmailStandardPage = new EmailStandardPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription();


        Assert.assertTrue(swisscowsEmailStandardPage.allIconsOfProductIsDysplaed());
        Assert.assertTrue(productsPage.allIconsOfProductIsDysplaed());
    }
    @Test
    @QaseId(value = 972)
    public void testButtonBuyNowRedirectToCorrespondingPage_EmailStandardPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailStandardPage swisscowsEmailStandardPage = new EmailStandardPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailStandardToBeVisible()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailStandardPage.getTitle(),ProjectConstants.TITLE_EMAIL_STANDARD_BUY_PAGE);
    }
}
