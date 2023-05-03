package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.VpnStandardPage;
import pages.sidebar_menu.VpnStandartBuyPage;
import utils.ProjectConstants;

import java.util.List;

public class PlatinumBuyTest extends BaseTest {
    @Test
    @QaseId(value = 1290)
    public void testH1Text_PlatinumBuyPage(){
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
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1288)
    public void testLinkBackToListRedirectToCorrespondingPage_PlatinumBuyPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        VpnStandardPage vpnStandardPage = new VpnStandardPage(getDriver());
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
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(vpnStandardPage.getTitle(),ProjectConstants.TITLE_EMAIL_PLATINUM_PAGE );
    }

    @Test
    @QaseId(value = 1291)
    public void testSubscriptionLogoIsDysplaedOnThePage_PlatinumPage(){
        VpnStandartBuyPage vpnStandartBuyPage  = new VpnStandartBuyPage (getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoPlatinumToBeVisible();


        Assert.assertTrue(vpnStandartBuyPage.logoOfSubscriptionIsDysplaed());
    }
    @Test(dataProvider = "PlatinumPlanButtonsData", dataProviderClass = TestData.class)
    @QaseId(value = 1289)
    public void testButtonBuyNowRedirectToCorrespondingPage_PlatinumPage(
            int index, String expectedH1Text,String expectedUrl){
        VpnStandartBuyPage vpnStandartBuyPage  = new VpnStandartBuyPage (getDriver());

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
                .waitLogoPlatinumToBeVisible()
                .getCurrentURL();

        vpnStandartBuyPage
                .clickButtonsOfPlan(index);


        final String actualURL =  vpnStandartBuyPage.getCurrentURL();
        final String actualTittle =  vpnStandartBuyPage.getH1Text();

        Assert.assertNotEquals(oldUrl, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }
    @Test
    @QaseId(value = 1292)
    public void testPriceOfSubscriptionAnnualAndMonthly_PlatinumPage(){
        final List<String> expectedPriceText = List.of(
                "12 CHF/month",
                "109 CHF/year\n"
                        + "*save 35 CHF"
        );

        final List<String> actualPriceText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoPlatinumToBeVisible()
                .getPriceSubscription();

        Assert.assertEquals(actualPriceText,expectedPriceText);
    }
}
