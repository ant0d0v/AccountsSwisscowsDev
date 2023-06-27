package tests.sidebar;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class ProductsTest extends BaseTest {
    @Test
    @QaseId(value = 1229)
    public void testListAllSubscriptionsForSwisscowsUser_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedH3texts = List.of(
                "Swisscows.email Standard",
                "Swisscows.email Premium",
                "Swisscows.VPN Standard",
                "Swisscows Platinum"

        );
        final List<String> actualH3texts = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage()
                .clickButtonGoToCatalogue()
                .getH3AllSubscriptions();

        Assert.assertEquals(productsPage.getH3AllSubscriptions().size(),4);
        Assert.assertEquals(actualH3texts,expectedH3texts);

    }
    @Test
    @QaseId(value = 1232)
    public void testListAllSubscriptionsForExternalUser_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedH3texts = List.of(
                "Swisscows.email Standard",
                "Swisscows.email Premium",
                "Swisscows.VPN Standard",
                "Swisscows Platinum"

        );
        final List<String> actualH3texts = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage()
                .clickButtonGoToCatalogue()
                .getH3AllSubscriptions();

        Assert.assertEquals(productsPage.getH3AllSubscriptions().size(),4);
        Assert.assertEquals(actualH3texts,expectedH3texts);

    }
    @Test
    @QaseId(value = 1233)
    public void testListPriceMonthlyAllSubscriptions_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedPrice = List.of(
                "5.00 CHF/month",
                "8.00 CHF/month",
                "10.00 CHF/month",
                "12.00 CHF/month"

        );
        final List<String> actualPrice = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage()
                .clickButtonGoToCatalogue()
                .clickMonthlyOfToggle()
                .getPriceAllSubscriptions();

        Assert.assertEquals(productsPage.getPriceAllSubscriptions().size(),4);
        Assert.assertEquals(actualPrice,expectedPrice);

    }
    @Test
    @QaseId(value = 1234)
    public void testListPriceYearAllSubscriptions_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedPrice = List.of(
                "45.00 CHF/year",
                "84.00 CHF/year",
                "84.00 CHF/year",
                "109.00 CHF/year"

        );
        final List<String> actualPrice = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage()
                .clickButtonGoToCatalogue()
                .getPriceAllSubscriptions();

        Assert.assertEquals(productsPage.getPriceAllSubscriptions().size(),5);
        Assert.assertEquals(actualPrice,expectedPrice);

    }
//    @Test
//    @QaseId(value = 1363)
//    public void testLabelDiscountIsDisplayedOfEmailStandardSubscription_ProductsPage(){
//        ProductsPage productsPage = new ProductsPage(getDriver());
//        openLoginURL()
//                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
//                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
//                .clickLoginButton_Dashboard()
//                .waitLogoInSidebarToBeVisible()
//                .clickSubscriptionIcon()
//                .waitToBeVisibleMainImage_SubscriptionPage()
//                .clickButtonGoToCatalogue();
//
//        Assert.assertTrue(productsPage.labelDiscountIsDisplayedOfEmailStandard());
//
//    }
    @Test
    @QaseId(value = 1230)
    public void testH1Text_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());

        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_PRODUCTS_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1235)
    public void testLogoAllSubscriptionsIsDysplaed_ProductsPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions();

        Assert.assertTrue(productsPage.logoAllSubscriptionsIsDysplaed());

    }
}
