package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.accounts.RegisterPage;
import pages.accounts.WelcomePage;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class WelcomeTest extends BaseTest {

    @Test
    @QaseId(value = 1013)
    public void testH1Text_WelcomePage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());

        final String actualH1Text = welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_WELCOME_PAGE);
        Assert.assertEquals(welcomePage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseId(value = 1011)
    public void testMainImageIsDisplayed_WelcomePage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage();


        Assert.assertTrue(welcomePage.imageIsDisplayedWelcomePage());

    }
    @Test
    @QaseId(value = 1015)
    public void testHoverGoToAccountButton_WelcomePage() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(getDriver());

        final List<String> colorButtonWithoutHover = welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage()
                .getColorButton();

        final List<String> colorButtonWhenHover = welcomePage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    @QaseId(value = 1016)
    public void testProductIconsIsDisplayed_WelcomePage(){
        WelcomePage welcomePage = new WelcomePage(getDriver());

        welcomePage
                .openWelcomePage()
                .waitProductIconsToBeVisible_WelcomePage();

        Assert.assertTrue(welcomePage.productIconsIsDisplayed());
    }
    @Test(dataProvider = "WelcomePageLinksData", dataProviderClass = TestData.class)
    @QaseId(value = 1012)
    public void testProductsLinksNavigateToCorrespondingPages_WelcomePage(
            int index, String expectedTittle,String expectedUrl) {

        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.openWelcomePage();

        final String oldURL = welcomePage.getCurrentURL();
        final String oldTittle = welcomePage.getH1Text();

        welcomePage
                .waitMainImageToBeVisible_WelcomePage()
                .clickLinksOfProducts(index);


        final String actualURL = welcomePage.getCurrentURL();
        final String actualTittle = welcomePage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @Test
    @QaseId(value = 1017)
    public void testAccountButtonRedirectToCorrespondingPage_WelcomePage() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .resolveCaptcha()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox();

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .clickGoToAccountButton()
                .waitForUrlContains(ProjectConstants.URL_DASHBOARD_PAGE);


        Assert.assertEquals(registerPage.getH1Text(), ProjectConstants.H1_TEXT_DASHBOARD_PAGE);
        Assert.assertEquals(registerPage.getCurrentURL(), ProjectConstants.URL_DASHBOARD_PAGE);
    }
}
