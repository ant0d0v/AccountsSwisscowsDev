package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.accounts.RegisterPage;
import pages.accounts.WelcomePage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class WelcomeTest extends BaseTest {

    @Test
    public void testH1Text_WelcomePage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        final String expectedH1Text = "Welcome";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );

        final String actualH1Text = welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage()
                .getH1Text();


        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(welcomePage.getH1FontSizes(), expectedFontSizesH1text);
    }
    @Test
    public void testMainImageIsDisplayed_WelcomePage() {
        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage();


        Assert.assertTrue(welcomePage.imageIsDisplayedWelcomePage());

    }
    @Test
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
    public void testProductIconsIsDisplayed_WelcomePage() throws InterruptedException {
        WelcomePage welcomePage = new WelcomePage(getDriver());

        welcomePage
                .openWelcomePage()
                .waitMainImageToBeVisible_WelcomePage();

        Assert.assertTrue(welcomePage.productIconsIsDisplayed());
    }
    @Test(dataProvider = "WelcomePageLinksData", dataProviderClass = TestData.class)
    public void testProductsLinksNavigateToCorrespondingPages_WelcomePage(
            int index, String expectedTittle,String expectedUrl) {

        WelcomePage welcomePage = new WelcomePage(getDriver());
        welcomePage.openWelcomePage();

        final String oldURL = welcomePage.getCurrentURL();
        final String oldTittle = welcomePage.getH1Text();

        welcomePage
                .waitMainImageToBeVisible_WelcomePage()
                .clickLinksInCheckbox(index);


        final String actualURL = welcomePage.getCurrentURL();
        final String actualTittle = welcomePage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldTittle, actualTittle);
        Assert.assertEquals(actualURL,expectedUrl);
        Assert.assertEquals(actualTittle, expectedTittle);
    }
    @Test
    public void testAccountButtonRedirectToAccountProfile_WelcomePage() throws InterruptedException, MessagingException, IOException {
        RegisterPage registerPage = new RegisterPage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        final String expectedH1Text = "Dashboard";
        final String expectedUrl = "https://accounts.dev.swisscows.com/";


        final String code = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .enterPhoneNumber()
                .clickSubmitButton()
                .getCodeFromGmailBox();

        confirmPage
                .enterCode(code)
                .clickSubmitButton()
                .clickGoToAccountButton()
                .waitForUrlContains("https://accounts.dev.swisscows.com/");


        Assert.assertEquals(registerPage.getH1Text(), expectedH1Text);
        Assert.assertEquals(registerPage.getCurrentURL(), expectedUrl);
    }
}
