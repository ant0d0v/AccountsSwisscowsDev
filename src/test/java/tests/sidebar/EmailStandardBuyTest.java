package tests.sidebar;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.EmailStandardBuyPage;
import pages.sidebar_menu.EmailStandardPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailStandardBuyTest extends BaseTest {
    @Test
    @QaseId(value = 1271)
    public void testH1Text_EmailStandardBuyPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1269)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailStandardByPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailStandardBuyPage swisscowsEmailStandardBuyPage = new EmailStandardBuyPage(getDriver());
        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .waitUntilToBeVisibleLogoSubscriptions()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailStandardBuyPage.getTitle(),ProjectConstants.TITLE_EMAIL_STANDARD_PAGE );
    }

    @Test
    @QaseId(value = 1275)
    public void testSubscriptionLogoIsDysplaedOnThePage_EmailStandardBuyPage(){
        EmailStandardBuyPage emailStandardBuyPage = new EmailStandardBuyPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailStandardToBeVisible();


        Assert.assertTrue(emailStandardBuyPage.logoOfSubscriptionIsDysplaed());
    }
    @Test(dataProvider = "EmailStandardPlanButtonsData", dataProviderClass = TestData.class)
    @QaseId(value = 1270)
    public void testButtonBuyNowRedirectToCorrespondingPage_EmailStandardByPage(
            int index, String expectedH1Text,String expectedUrl){
        EmailStandardBuyPage swisscowsEmailStandardBuyPage = new EmailStandardBuyPage(getDriver());

        final String oldUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailStandardToBeVisible()
                .getCurrentURL();

        swisscowsEmailStandardBuyPage
                .clickButtonsOfPlan(index);


        final String actualURL = swisscowsEmailStandardBuyPage.getCurrentURL();
        final String actualTittle = swisscowsEmailStandardBuyPage.getH1Text();

        Assert.assertNotEquals(oldUrl, actualURL);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedH1Text);
    }

    @Test
    @QaseId(value = 1276)
    public void testPriceOfSubscriptionAnnualAndMonthly_EmailStandardByPage(){
        final List<String> expectedPriceText = List.of(
                "5 CHF/month",
                "45 CHF/year\n"
                        + "*save 15 CHF"
        );

        final List<String> actualPriceText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailStandardToBeVisible()
                .getPriceSubscription();

        Assert.assertEquals(actualPriceText,expectedPriceText);
    }
    @Ignore("Actual only for discount subscription ")
    @Test
    @QaseId(value = 1364)
    public void testLabelDiscountIsDisplayedOfAnnualPlan_ProductsPage(){
        EmailStandardBuyPage swisscowsEmailStandardBuyPage = new EmailStandardBuyPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .waitLogoEmailStandardToBeVisible();

        Assert.assertTrue(swisscowsEmailStandardBuyPage.labelDiscountIsDisplayedOfAnnualPlan());

    }
}
