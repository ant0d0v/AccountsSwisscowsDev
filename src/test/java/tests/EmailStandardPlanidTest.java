package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.EmailStandardBuyPage;
import pages.sidebar_menu.EmailStandardBuyPlanIdPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailStandardPlanidTest extends BaseTest {
    @Test
    @QaseId(value = 1298)
    public void testH1TextMonthly_EmailStandardPlanPage(){
        EmailStandardBuyPage emailStandardBuyPage = new EmailStandardBuyPage(getDriver());
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
                .clickMonthlyPlanOfEmailStandard()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1303)
    public void testH1TextAnnual_EmailStandardPlanPage(){
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
                .clickAnnualPlanOfEmailStandard()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_STANDARD_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1299)
    public void testTextPaymentSummaryOfAnnualPlan_EmailStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedText = List.of(
                "Swisscows.email Standard\n"
                        + "43.08 CHF",
                "Discount\n"
                        + "-20.00 CHF",
                "Value added tax\n"
                        + "1.93 CHF",
                "Total\n"
                        + "25.00 CHF"

        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailStandard()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1295)
    public void testTextPaymentSummaryOfMonthlyPlan_EmailStandardPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        final List<String> expectedText = List.of(
                "Swisscows.email Standard\n"
                        + "4.62 CHF",
                "Value added tax\n"
                        + "0.39 CHF",
                "Total\n"
                        + "5.00 CHF"
        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1293)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailStandardPlanPage(){
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
                .clickMonthlyPlanOfEmailStandard()
                .waitMainImageToBeVisible()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(swisscowsEmailStandardBuyPage.getTitle(),ProjectConstants.TITLE_EMAIL_STANDARD_BUY_PAGE );
    }

    @Test
    @QaseId(value = 1296)
    public void testSubscriptionLogoIsDysplaedOnThePage_EmailStandardPlanPage(){
        EmailStandardBuyPlanIdPage emailStandardBuyPage = new EmailStandardBuyPlanIdPage (getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .waitLogoEmailToBeVisible();

        Assert.assertTrue(emailStandardBuyPage.logoOfEmailIsDysplaed());
    }
    @Test
    @QaseId(value = 1301)
    public void testMainImageIsDysplaedOnThePage_EmailStandardPlanPage(){
        EmailStandardBuyPlanIdPage emailStandardBuyPage = new EmailStandardBuyPlanIdPage (getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .waitMainImageToBeVisible();

        Assert.assertTrue(emailStandardBuyPage.mainImageOfPlanIdPageIsDysplaed());
    }
    @Test
    @QaseId(value = 1300)
    public void testSelectCardMethod_EmailStandardPlanPage(){
        EmailStandardBuyPlanIdPage emailStandardPlanPage = new EmailStandardBuyPlanIdPage (getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        emailStandardPlanPage
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE );
        final String newURL = emailStandardPlanPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(emailStandardPlanPage.getCurrentURL().contains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE ));
    }
    @Test
    @QaseId(value = 1302)
    public void testSelectPayPalMethod_EmailStandardPlanPage(){
        EmailStandardBuyPlanIdPage emailStandardPlanPage = new EmailStandardBuyPlanIdPage (getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        emailStandardPlanPage
                .selectPayPalMethodMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PAYPAL_PAGE);
        final String newURL = emailStandardPlanPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(emailStandardPlanPage.getCurrentURL().contains(ProjectConstants.URL_PAYPAL_PAGE));
    }
}
