package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.sidebar_menu.DashboardPage;
import utils.ProjectConstants;

import java.util.List;

public class DashBoardTest extends BaseTest {
    @Test
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
    public void testHoverButtonsExternal_DashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final List<String> colorButtonsWithoutHover = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getColorButton();


        final List<String> colorButtonsWhenHover = dashboardPage
                .getColorButtonWhenHover();


        Assert.assertNotEquals(colorButtonsWhenHover, colorButtonsWithoutHover);

    }
    @Test
    public void testHoverButtonsSwisscowsUser_DashboardPage() throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        final List<String> colorButtonsWithoutHover = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .getColorButton();


        final List<String> colorButtonsWhenHover = dashboardPage
                .getColorButtonWhenHover();


        Assert.assertNotEquals(colorButtonsWhenHover, colorButtonsWithoutHover);

    }
    @Test
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

        final List<String> actualH2Text = dashboardPage.getH2Texts();


        Assert.assertEquals(actualCountWidgets, 3);
        Assert.assertEquals(actualH2Text, expectedH2Text);
        Assert.assertEquals(dashboardPage.getH2FontSizes(), expectedH2FontSizes);

    }
    @Test
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
    @Test(dataProvider = "DashboardLinksDataExternalUser", dataProviderClass = TestData.class)
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
    @Test(dataProvider = "DashboardLinksDataSwisscowsUser", dataProviderClass = TestData.class)
    public void testDashboardLinksNavigateToCorrespondingPagesSwisscowsUser(
            int index, String expectedH1text) {
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible();


        final String oldH1text = dashboardPage.getH1Text();

        dashboardPage
                .clickAllLinksOnDashboardPage(index);

        final  String actualH1Text = dashboardPage.getH1Text();


        Assert.assertNotEquals(actualH1Text, oldH1text);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
    @Test
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
    @Test
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
