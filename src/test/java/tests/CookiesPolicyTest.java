package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CookiesPolicyPage;
import pages.TestData;

import java.util.List;

public class CookiesPolicyTest extends BaseTest {
    @Test
    public void testH2Texts_CookiesPolicyPage() {
        List<String> expectedH2Texts = List.of(
                "What are cookies?",
                "What kind of cookies do we use?",
                "Changes and additions",
                "Acceptance of this policy",
                "Contact"
        );
        final List<String> actualH2Texts = openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickCookiesPolicy()
                .closeRegisterPage()
                .switchToCookiesPolicyPage()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    public void testH2FontSizes_CookiesPolicyPage(){

        final List<String> expectedH1FontSizes = List.of(
                "24px",
                "24px",
                "24px",
                "24px",
                "24px"


        );
        final List<String>  actualH2FontSizes = openLoginURL()
                 .clickLinkInTheFooterMenu()
                 .clickCookiesPolicy()
                 .closeRegisterPage()
                 .switchToCookiesPolicyPage()
                 .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @Test
    public void testLinksColors_CookiesPolicyPage(){
        final List<String> expectedH1Colors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"
        );
        final List<String>  actualH1Colors = openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickCookiesPolicy()
                .closeRegisterPage()
                .switchToCookiesPolicyPage()
                .getColorLinks();

        Assert.assertTrue(actualH1Colors.size() > 0);
        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
    @Test(dataProvider = "CookiesLinksData", dataProviderClass = TestData.class)
    public void testCookiesLinksNavigateToCorrespondingPages(
            int index, String expectedURL, String expectedH1text) throws InterruptedException {

        CookiesPolicyPage cookiesPolicyPage = new CookiesPolicyPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .waitMainImageToBeVisible_RegisterPage()
                .clickCookiesPolicy()
                .closeRegisterPage()
                .switchToCookiesPolicyPage();


        final String oldURL = cookiesPolicyPage.getCurrentURL();
        final String oldH1Text = cookiesPolicyPage.getH1Text();

        cookiesPolicyPage
                .clickAllLinks(index);

        String actualURL = cookiesPolicyPage.getCurrentURL();
        String actualH1Text = cookiesPolicyPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertNotEquals(oldH1Text, actualH1Text);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
}
