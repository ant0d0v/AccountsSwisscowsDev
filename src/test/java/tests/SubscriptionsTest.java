package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.SubscriptionsPage;
import utils.ProjectConstants;

import java.util.List;

public class SubscriptionsTest extends BaseTest {
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
    @Test
    @QaseId(value = 1217)
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
    @Test
    @QaseId(value = 1227)
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
    @Test
    @QaseId(value = 1228)
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

}
