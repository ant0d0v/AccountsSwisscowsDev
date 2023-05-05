package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.CardMethodPage;
import pages.sidebar_menu.EmailStandardBuyPlanIdPage;
import utils.ProjectConstants;

public class CardMethodTest extends BaseTest {
    @Test
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
    public void testCardFieldIsEmpty_CardMethodPage() throws InterruptedException {
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
}
