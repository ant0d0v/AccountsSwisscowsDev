package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.DashboardPage;
import utils.ProjectConstants;

import java.util.List;

public class DashBoardTest extends BaseTest {
    @Test
    @QaseId(value = 1144)
    public void testH1Text_DashboardPage() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final String actualH1text= openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getH1Text();

        Assert.assertEquals(actualH1text, ProjectConstants.H1_TEXT_DASHBOARD_PAGE);
        Assert.assertEquals(dashboardPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);


    }
    @Test
    @QaseId(value = 1143)
    public void testHoverButtons_DashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final List colorButtonsWithoutHover = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getColorButton();


        final List colorButtonsWhenHover = dashboardPage
                .getColorButtonWhenHover();


        Assert.assertNotEquals(colorButtonsWhenHover, colorButtonsWithoutHover);

    }
    @Test
    @QaseId(value = 1145)
    public void testCountWidgetForExternalUser_DashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        final List<String> expectedH2Text = List.of(
                "Swisscows.VPN Standard",
                "Swisscows"
        );
        final List<String> expectedH2FontSizes = List.of(
                "30px",
                "24px"
        );
        final int actualCountWidgets = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getCountWidgets();

        final List actualH2Text = dashboardPage.getH2Texts();


        Assert.assertEquals(actualCountWidgets, 3);
        Assert.assertEquals(actualH2Text, expectedH2Text);
        Assert.assertEquals(dashboardPage.getH2FontSizes(), expectedH2FontSizes);

    }
    @Test
    @QaseId(value = 1152)
    public void testCountWidgetForSwisscowsUser_DashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        final List<String> expectedH2Text = List.of(
                "Swisscows.email",
                "Swisscows.VPN Standard",
                "Swisscows.email Premium",
                "Swisscows"
        );
        final List<String> expectedH2FontSizes = List.of(
                "24px",
                "30px",
                "30px",
                "24px"
        );
        final int actualCountWidgets = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getCountWidgets();

        final List<String> actualH2Text = dashboardPage.getH2Texts();


        Assert.assertEquals(actualCountWidgets, 5);
        Assert.assertEquals(actualH2Text, expectedH2Text);
        Assert.assertEquals(dashboardPage.getH2FontSizes(), expectedH2FontSizes);

    }
    @Test(priority = 1,dataProvider = "DashboardLinksDataExternalUser", dataProviderClass = TestData.class)
    @QaseId(value = 1142)
    public void testDashboardLinksNavigateToCorrespondingPagesExternalUser(
            int index, String expectedURL, String expectedH1text) {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible();


        final String oldURL = dashboardPage.getCurrentURL();
        final String oldH1text = dashboardPage.getH1Text();

        dashboardPage
                .clickAllLinksOnDashboardPage(index);

        final  String actualURL = dashboardPage.getCurrentURL();
        final  String actualH1Text = dashboardPage.getH1Text();


        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(actualH1Text, oldH1text);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
    @Ignore
    @Test(priority = 4,dataProvider = "DashboardLinksDataSwisscowsUser", dataProviderClass = TestData.class)
    @QaseId(value = 1153)
    public void testDashboardLinksNavigateToCorrespondingPagesSwisscowsUser(
            int index, String expectedTitle, String expectedH1text) {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible();

        final String oldTitle = dashboardPage.getTitle();
        final String oldH1Text = dashboardPage.getH1Text();

        dashboardPage
                .clickAllLinksOnDashboardPage(index);

        final  String actualTitle = dashboardPage.getTitle();
        final  String actualH1Text = dashboardPage.getH1Text();


        Assert.assertNotEquals(actualTitle, oldTitle);
        Assert.assertNotEquals(actualH1Text, oldH1Text);
        Assert.assertEquals(actualTitle, expectedTitle);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
    @Test(priority = 2)
    @QaseId(value = 1149)
    public void testColorWidgetForExternalUser_DashboardPage() throws InterruptedException {
        final List<String> expectedColorsOfWidget = List.of(
                "rgba(102, 119, 251, 1)",
                "rgba(0, 0, 0, 0)",
                "rgba(0, 0, 0, 0)"
        );

        final List<String> actualColorsOfWidget = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getColorOfWidgets();

        Assert.assertEquals(actualColorsOfWidget,expectedColorsOfWidget);

    }
    @Test(priority = 3)
    @QaseId(value = 1154)
    public void testColorWidgetForSwisscowsUser_DashboardPage() throws InterruptedException {
        final List<String> expectedColorsOfWidget = List.of(
                "rgba(0, 0, 0, 0)",
                "rgba(102, 119, 251, 1)",
                "rgba(102, 119, 251, 1)",
                "rgba(0, 0, 0, 0)",
                "rgba(0, 0, 0, 0)"
        );

        final List<String> actualColorsOfWidget = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitAllWidgetsToBeVisible()
                .getColorOfWidgets();

        Assert.assertEquals(actualColorsOfWidget,expectedColorsOfWidget);

    }
    @Test
    @QaseId(value = 1146)
    public void testWelcomeMessageForExternalUser_DashboardPage() {
        final String expectedMessage = "Hi, qaengineer1203@gmail.com";

        final String actualMessage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getWelcomeMessage();


        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    @QaseId(value = 1155)
    public void testWelcomeMessageForSwisscowsUser_DashboardPage() {
        final String expectedMessage = "Hi, aqa@swisscows.email";

        final String actualMessage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getWelcomeMessage();


        Assert.assertEquals(actualMessage, expectedMessage);

    }
    @Test
    @QaseId(value = 1150)
    public void testAllImagesIsDisplayed_DashboardPage() {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitAllWidgetsToBeVisible();

        Assert.assertTrue(dashboardPage.allImageOnPageIsDisplayed());
    }
}
