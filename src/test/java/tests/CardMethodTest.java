package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.CardMethodPage;
import pages.sidebar_menu.EmailStandardBuyPage;
import pages.sidebar_menu.EmailStandardBuyPlanIdPage;
import pages.sidebar_menu.ProductsPage;
import utils.ProjectConstants;

public class CardMethodTest extends BaseTest {
    @Test
    @QaseId(value = 1351)
    public void testInvalidUserName_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
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
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("123");

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
    }
    @Test
    @QaseId(value = 1350)
    public void testCorrectUserName_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
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
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("Anton Udovychenko");

        Assert.assertTrue(cardMethodPage.validationSuccessIconIsDysplaed());
    }
    @Test
    @QaseId(value = 1356)
    public void testUserNameFieldIsEmpty_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
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
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE);
        final String actualUrl = cardMethodPage
                .clickInputEnterCardNumber(ProjectConstants.VISA_CARD)
                .clickInputEnterCardDate("1345")
                .clickInputEnterCardCvvCode("111")
                .clickProceedButton_SubscriptionPage()
                .getCurrentURL();

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1357)
    public void testInvalidCardNumber_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardNumber("1111111111111111")
                .clickInputEnterCardDate("1345")
                .clickInputEnterCardCvvCode("111");

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
    }
    @Test
    @QaseId(value = 1355)
    public void testInvalidDateNumber_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailPremiumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickAnnualPlanOfEmailPremium()
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD)
                .clickInputEnterCardDate("1111")
                .clickInputEnterCardCvvCode("111");

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
    }
    @Test
    @QaseId(value = 1352)
    public void testCardNumberFieldIsEmpty_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        final String actualUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfEmailStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfEmailStandard()
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardDate("1345")
                .clickInputEnterCardCvvCode("111")
                .clickProceedButton_SubscriptionPage()
                .getCurrentURL();

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1354)
    public void testDateFieldIsEmpty_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        final String actualUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD)
                .clickInputEnterCardCvvCode("111")
                .clickProceedButton_SubscriptionPage()
                .getCurrentURL();

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1358)
    public void testInvalidCvvNumber_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        final String actualUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD)
                .clickInputEnterCardDate("1232")
                .clickInputEnterCardCvvCode("12")
                .clickProceedButton_SubscriptionPage()
                .getCurrentURL();

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1359)
    public void testCvvFieldIsEmpty_CardMethodPage() throws InterruptedException {
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        final String actualUrl = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD)
                .clickInputEnterCardDate("1232")
                .clickInputEnterCardCvvCode("")
                .clickProceedButton_SubscriptionPage()
                .getCurrentURL();

        Assert.assertTrue(cardMethodPage.validationErrorIconIsDysplaed());
        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE));
    }
    @Test
    @QaseId(value = 1340)
    public void testLinkBackToListRedirectToCorrespondingPage_CardMethodPage(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        EmailStandardBuyPlanIdPage emailStandardBuyPlanIdPage = new EmailStandardBuyPlanIdPage(getDriver());
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
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .clickInputEnterCardName("anton")
                .getCurrentURL();

        final String newUrl = emailStandardBuyPlanIdPage
                .clickLinkBackToListOfProduct()
                .getCurrentURL();

        Assert.assertNotEquals(newUrl,oldUrl);
        Assert.assertEquals(emailStandardBuyPlanIdPage.getTitle(), ProjectConstants.TITLE_EMAIL_STANDARD_PLAN_PAGE);
    }
    @Test
    @QaseId(value = 1343)
    public void testH1TextForEmailStandardSubscription_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        EmailStandardBuyPlanIdPage emailStandardBuyPlanIdPage = new EmailStandardBuyPlanIdPage(getDriver());
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
                .clickMonthlyPlanOfEmailStandard()
                .waitMainImageToBeVisible()
                .selectCardMethodOfEmailStandard()
                .clickToProceedButton_CardMethodPage()
                .waitMainImageToBeVisible()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_STANDARD_CARD_PAGE);

        Assert.assertEquals(cardMethodPage.getH1Text(),ProjectConstants.H1_TEXT_EMAIL_STANDARD_PAGE);
        Assert.assertEquals(cardMethodPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1362)
    public void testH1TextForEmailPremiumSubscription_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
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
                .selectCardMethodOfEmailPremium()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_EMAIL_PREMIUM_CARD_PAGE);

        Assert.assertEquals(cardMethodPage.getH1Text(),ProjectConstants.H1_TEXT_EMAIL_PREMIUM_PAGE);
        Assert.assertEquals(cardMethodPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1361)
    public void testH1TextForVpnStandardSubscription_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfVpnStandardSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfVpnStandard()
                .waitMainImageToBeVisible()
                .selectCardMethodOfVpnStandard()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_VPN_STANDARD_CARD_PAGE);

        Assert.assertEquals(cardMethodPage.getH1Text(),ProjectConstants.H1_TEXT_VPN_STANDARD_PAGE);
        Assert.assertEquals(cardMethodPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1360)
    public void testH1TextForPlatinumSubscription_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitMainImageToBeVisible()
                .selectCardMethodOfPlatinum()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PLATINUM_CARD_PAGE);

        Assert.assertEquals(cardMethodPage.getH1Text(),ProjectConstants.H1_TEXT_PLATINUM_PAGE);
        Assert.assertEquals(cardMethodPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1346)
    public void testMainImageIsDysplaedOnThePage_CardMethodPage(){
        CardMethodPage cardMethodPage = new CardMethodPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .clickButtonGoToCatalogue()
                .waitUntilToBeVisibleLogoSubscriptions()
                .clickBuyNowButtonOfPlatinumSubscription()
                .clickBuyNowButtonOfProduct()
                .clickMonthlyPlanOfPlatinum()
                .waitMainImageToBeVisible()
                .selectCardMethodOfPlatinum()
                .clickToProceedButton_CardMethodPage()
                .waitForUrlContains(ProjectConstants.URL_PLATINUM_CARD_PAGE);
        cardMethodPage.waitMainImageToBeVisible();

        Assert.assertTrue(cardMethodPage.mainImageIsDisplayed());
    }
}
