package tests.sidebar;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.EmailPremiumBuyPlanIdPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

import java.util.List;

public class EmailPremiumPlanidTest extends BaseTest {
    @Test
    @QaseId(value = 1307)
    public void testH1TextMonthly_EmailPremiumPlanPage(){
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
                .clickMonthlyPlanOfEmailPremium()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_PREMIUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1312)
    public void testH1TextAnnual_EmailPremiumPlanPage(){
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
                .clickAnnualPlanOfEmailPremium()
                .getH1Text();

        Assert.assertEquals(actualH1text,ProjectConstants.H1_TEXT_EMAIL_PREMIUM_PAGE);
        Assert.assertEquals(productsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1308)
    public void testTextPaymentSummaryOfAnnualPlan_EmailPremiumPlanPage(){
        final List<String> expectedText = List.of(
                "Swisscows.email Premium\n"
                        + "77.99 CHF",
                "Value added tax\n"
                        + "6.01 CHF",
                "Total\n"
                        + "84.00 CHF"

        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1305)
    public void testTextPaymentSummaryOfMonthlyPlan_EmailPremiumPlanPage(){
        final List<String> expectedText = List.of(
                "Swisscows.email Premium\n"
                        + "7.43 CHF",
                "Value added tax\n"
                        + "0.57 CHF",
                "Total\n"
                        + "8.00 CHF"
        );

        final List<String> actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailPremium()
                .getTextPaymentSummary();

        Assert.assertEquals(actualH1text,expectedText);
    }
    @Test
    @QaseId(value = 1304)
    public void testLinkBackToListRedirectToCorrespondingPage_EmailPremiumPlanPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailPremiumBuyPlanIdPage emailPremiumBuyPlanIdPage = new EmailPremiumBuyPlanIdPage(getDriver());
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
                .clickMonthlyPlanOfEmailPremium()
                .waitMainImageToBeVisible()
                .getCurrentURL();

        final String newUrl = productsPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(emailPremiumBuyPlanIdPage.getTitle(),ProjectConstants.TITLE_EMAIL_PREMIUM_BUY_PAGE );
    }

    @Test
    @QaseId(value = 1306)
    public void testSubscriptionLogoIsDysplaedOnThePage_EmailPremiumPlanPage(){
        EmailPremiumBuyPlanIdPage emailPremiumBuyPlanIdPage = new EmailPremiumBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailPremium()
                .waitLogoEmailToBeVisible();

        Assert.assertTrue(emailPremiumBuyPlanIdPage.logoOfEmailIsDysplaed());
    }
    @Test
    @QaseId(value = 1310)
    public void testMainImageIsDysplaedOnThePage_EmailPremiumPlanPage(){
        EmailPremiumBuyPlanIdPage emailPremiumBuyPlanIdPage = new EmailPremiumBuyPlanIdPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailPremium()
                .waitMainImageToBeVisible();

        Assert.assertTrue(emailPremiumBuyPlanIdPage.mainImageOfPlanIdPageIsDysplaed());
    }
    @Test
    @QaseId(value = 1309)
    public void testSelectCardMethod_EmailPremiumPlanPage(){
        EmailPremiumBuyPlanIdPage emailPremiumBuyPlanIdPage = new EmailPremiumBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailPremium()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        emailPremiumBuyPlanIdPage
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_PREMIUM_CARD_PAGE);
        final String newURL = emailPremiumBuyPlanIdPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(emailPremiumBuyPlanIdPage.getCurrentURL().contains(ProjectConstants.URL_EMAIL_PREMIUM_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1311)
    public void testSelectPayPalMethod_EmailPremiumPlanPage(){
        EmailPremiumBuyPlanIdPage emailPremiumBuyPlanIdPage = new EmailPremiumBuyPlanIdPage(getDriver());
        final String oldURL = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailPremium()
                .waitLogoEmailToBeVisible()
                .getCurrentURL();
        emailPremiumBuyPlanIdPage
                .selectPayPalMethodMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PAYPAL_PAGE);
        final String newURL = emailPremiumBuyPlanIdPage.getCurrentURL();

        Assert.assertNotEquals(newURL,oldURL);
        Assert.assertTrue(emailPremiumBuyPlanIdPage.getCurrentURL().contains(ProjectConstants.URL_PAYPAL_PAGE));
    }
}
