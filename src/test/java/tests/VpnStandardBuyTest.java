package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

import java.util.List;

public class VpnStandardBuyTest extends BaseTest {
    @Test
    @QaseId(value = 1285)
    public void testH1Text_VpnStandardBuyPage(){
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
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_VPN_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1283)
    public void testLinkBackToListRedirectToCorrespondingPage_VpnStandardByPage(){
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
                .clickBuyNowButtonOfProduct()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(vpnStandardPage.getTitle(),ProjectConstants.TITLE_VPN_STANDARD_PAGE );
    }

    @Test
    @QaseId(value = 1286)
    public void testSubscriptionLogoIsDysplaedOnThePage_VpnStandardBuyPage(){
        VpnStandartBuyPage vpnStandartBuyPage  = new VpnStandartBuyPage (getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoVpnStandardToBeVisible();


        Assert.assertTrue(vpnStandartBuyPage.logoOfSubscriptionIsDysplaed());
    }
    @Test(dataProvider = "VpnStandardPlanButtonsData", dataProviderClass = TestData.class)
    @QaseId(value = 1284)
    public void testButtonBuyNowRedirectToCorrespondingPage_VpnStandardByPage(
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
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoVpnStandardToBeVisible()
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
    @QaseId(value = 1287)
    public void testPriceOfSubscriptionAnnualAndMonthly_VpnStandardByPage(){
        final List<String> expectedPriceText = List.of(
                "10 CHF/month",
                "84 CHF/year\n"
                        + "*save 36 CHF"
        );

        final List<String> actualPriceText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoVpnStandardToBeVisible()
                .getPriceSubscription();

        Assert.assertEquals(actualPriceText,expectedPriceText);
    }
}
