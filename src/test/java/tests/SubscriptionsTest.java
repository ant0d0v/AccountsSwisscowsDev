package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.SubscriptionsPage;
import utils.ProjectConstants;

import java.util.List;

public class SubscriptionsTest extends BaseTest {
//    @Test(priority = 1)
//    public void testBuySubscriptionPlatinum() throws InterruptedException {
//        final String expectedSuccessfulMessage = "Congratulations,\n"
//                + "the payment was successful!";
//        openBaseURL()
//                .clickHamburgerMenu()
//                .signIn()
//                .waitTopMenuToBeInvisible()
//                .clickHamburgerMenu()
//                .clickAccountInHamburgerMenu()
//                .clickSubscriptionIcon()
//                .clickSeeAllLink()
//                .clickBuyNowButtonOfPlatinumSubscription()
//                .clickConfirmButtonInPopup()
//                .clickBuyNowButtonOfProduct()
//                .clickBuyNowButtonOfMonthlyPlan()
//                .clickMethodCard()
//                .payByCard()
//                .waitForUrlContains("https://accounts.dev.swisscows.com/products/swisscows-platinum/buy/success");
//
//        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
//                .waitSuccessImage()
//                .getTextSuccessfulMessage();
//        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);
//
//    }
//    @Test(priority = 2)
//    public void testCheckSubscriptionPlatinum() throws InterruptedException {
//        final String expectedAttribute = "item active";
//        final String actualAttribute = openBaseURL()
//                .clickHamburgerMenu()
//                .signIn()
//                .waitTopMenuToBeInvisible()
//                .clickHamburgerMenu()
//                .clickAccountInHamburgerMenu()
//                .clickSubscriptionIcon()
//                .clickSeeAllLink()
//                .getAttributePlatinumSubscription();
//
//        Assert.assertEquals(actualAttribute,expectedAttribute);
//
//    }
//    @Test(priority = 3)
//    public void testBuyVpnSubscriptionPlatinum() throws InterruptedException {
//        final String expectedSuccessfulMessage = "Congratulations,\n"
//                + "the payment was successful!";
//        openBaseURL()
//                .clickHamburgerMenu()
//                .signIn()
//                .waitTopMenuToBeInvisible()
//                .clickHamburgerMenu()
//                .clickAccountInHamburgerMenu()
//                .clickSubscriptionIcon()
//                .clickSeeAllLink()
//                .clickBuyNowButtonOfVpnSubscription()
//                .clickConfirmButtonInPopup()
//                .clickBuyNowButtonOfProduct()
//                .clickBuyNowButtonOfMonthlyPlan()
//                .clickMethodCard()
//                .payByCard();
//
//        final String actualSuccessfulMessage = new SubscriptionsPage(getDriver())
//                .waitSuccessImage()
//                .getTextSuccessfulMessage();
//        Assert.assertEquals(actualSuccessfulMessage,expectedSuccessfulMessage);
//
//    }
//    @Test(priority = 4)
//    public void testUpgradeSubscription() throws InterruptedException {
//        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
//        final String expectedAttribute = "item active";
//        final String actualAttribute = openBaseURL()
//                .clickHamburgerMenu()
//                .signIn()
//                .waitTopMenuToBeInvisible()
//                .clickHamburgerMenu()
//                .clickAccountInHamburgerMenu()
//                .clickSubscriptionIcon()
//                .clickSeeAllLink()
//                .getAttributeVpnSubscription();
//
//        Assert.assertEquals(actualAttribute,expectedAttribute);
//        Assert.assertEquals(subscriptionsPage.getAttributePlatinumSubscription(),"item");
//
//    }
    @Test(priority = 1)
    public void testH1Text_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
        final String expectedH1text = "Your subscriptions";
        final String actualH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .getH1Text();

        Assert.assertEquals(actualH1text,expectedH1text);
        Assert.assertEquals(subscriptionsPage.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test(priority = 2)
    public void testMainImage_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage();

        Assert.assertTrue(subscriptionsPage.mainImageIsDysplaed_SubscriptionPage());

    }
    @Test(priority = 3)
    public void testHoverGoToCatalogueButton_SubscriptionPage() throws InterruptedException {
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickSubscriptionIcon()
                .waitToBeVisibleMainImage_SubscriptionPage();

        final List colorButtonWithoutHover = subscriptionsPage
                .getColorButton();

        final List colorButtonWhenHover = subscriptionsPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWithoutHover,colorButtonWhenHover);

    }
    @Test(priority = 4)
    public void testListAllSubscriptionsForSwisscowsUser_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
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

        Assert.assertEquals(subscriptionsPage.getH3AllSubscriptions().size(),4);
        Assert.assertEquals(actualH3texts,expectedH3texts);

    }
    @Test(priority = 5)
    public void testListAllSubscriptionsForExternalUser_SubscriptionPage(){
        SubscriptionsPage subscriptionsPage= new SubscriptionsPage(getDriver());
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

        Assert.assertEquals(subscriptionsPage.getH3AllSubscriptions().size(),4);
        Assert.assertEquals(actualH3texts,expectedH3texts);

    }
}
