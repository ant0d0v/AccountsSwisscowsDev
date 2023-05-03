package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.EmailPremiumBuyPage;
import pages.sidebar_menu.EmailStandardBuyPage;
import pages.sidebar_menu.EmailStandardPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailPremiumBuyTest extends BaseTest {
    @Test
    @QaseId(value = 1280)
    public void testH1Text_EmailPremiumBuyPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_PREMIUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1278)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailStandardByPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailPremiumBuyPage swisscowsEmailPremiumBuyPage = new EmailPremiumBuyPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailPremiumBuyPage.getTitle(),ProjectConstants.TITLE_EMAIL_PREMIUM_PAGE );
    }

    @Test
    @QaseId(value = 1281)
    public void testSubscriptionLogoIsDysplaedOnThePage_EmailStandardBuyPage(){
        EmailPremiumBuyPage swisscowsEmailPremiumBuyPage = new EmailPremiumBuyPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailPremiumToBeVisible();


        Assert.assertTrue(swisscowsEmailPremiumBuyPage .logoOfSubscriptionIsDysplaed());
    }
    @Test(dataProvider = "EmailPremiumPlanButtonsData", dataProviderClass = TestData.class)
    @QaseId(value = 1279)
    public void testButtonBuyNowRedirectToCorrespondingPage_EmailPremiumByPage(
            int index, String expectedH1Text,String expectedUrl){
        EmailPremiumBuyPage swisscowsEmailPremiumBuyPage = new EmailPremiumBuyPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailPremiumToBeVisible()
                .getCurrentURL();

        swisscowsEmailPremiumBuyPage
                .clickButtonsOfPlan(index);


        final String actualURL = swisscowsEmailPremiumBuyPage.getCurrentURL();
        final String actualTittle = swisscowsEmailPremiumBuyPage.getH1Text();

        Assert.assertNotEquals(oldUrl, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }
    @Test
    @QaseId(value = 1282)
    public void testPriceOfSubscriptionAnnualAndMonthly_EmailPremiumByPage(){
        final List<String> expectedPriceText = List.of(
                "8 CHF/month",
                "84 CHF/year\n"
                        + "*save 12 CHF"
        );

        final List<String> actualPriceText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailPremiumToBeVisible()
                .getPriceSubscription();

        Assert.assertEquals(actualPriceText,expectedPriceText);
    }
}
