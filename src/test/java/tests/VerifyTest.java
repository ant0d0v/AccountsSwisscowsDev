package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.VerifyPage;
import utils.ProjectConstants;

public class VerifyTest extends BaseTest {
    @Test
    public void testMainImageIsDisplayed_VerifyPage() {
        VerifyPage verifyPage =new VerifyPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .waitMainImageToBeVisible_VerifyPage();


        Assert.assertTrue(verifyPage.imageIsDisplayedVerifyPage());

    }
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_VerifyPage(){

        VerifyPage verifyPage = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots();

        final String oldUrl = verifyPage.getCurrentURL();

        final String newUrl = verifyPage
                .clickLinkInTheFooterMenu()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(verifyPage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);
    }
    @Test
    public void testH1Text_VerifyPage() {
        VerifyPage verifyPage =new VerifyPage(getDriver());
        final  String expectedH1Text = "Verify you're human";

        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .waitMainImageToBeVisible_VerifyPage()
                .getH1Text();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(verifyPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    public void testListNumbers_VerifyPage() {
        final int expectedList = 4;

        final int actualList = openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .enterUserCredentialsForBots()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForBots()
                .waitMainImageToBeVisible_VerifyPage()
                .getListNumber();

        Assert.assertEquals(actualList, expectedList);


    }
}
