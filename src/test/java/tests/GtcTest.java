package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GtcPage;
import pages.TestData;

import java.util.List;

public class GtcTest extends BaseTest {
    @Test
    @QaseId(value = 1139)
    public void testH2Texts_GtcPage() {
        List<String> expectedH2Texts = List.of(
                "1. Services",
                "2. Account setup",
                "3. Account information",
                "4. Payment and refund policies",
                "5. Age restriction",
                "6. Intellectual property",
                "7. Prohibited actions",
                "8. Guideline for use",
                "9. License agreements",
                "10. Third party linking",
                "11. Exclusions and limitations of liability",
                "12. Service-Level-Agreement (SLA)",
                "13. Compensation",
                "14. Termination, modification and discontinuation of the services",
                "15. Applicable law",
                "16. Government requests",
                "17. Questions and suggestions"
        );
        final List<String> actualH2Texts = openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickGtcPage()
                .closeRegisterPage()
                .switchToGtcPage()
                .getH2Texts();

        Assert.assertTrue(actualH2Texts.size() > 0);
        Assert.assertEquals(actualH2Texts, expectedH2Texts);
    }

    @Test
    @QaseId(value = 1138)
    public void testH2FontSizes_GtcPage(){

        final List<String> expectedH1FontSizes = List.of(
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px",
                "24px"
        );
        final List<String>  actualH2FontSizes = openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickGtcPage()
                .closeRegisterPage()
                .switchToGtcPage()
                .getH2FontSizes();

        Assert.assertTrue(actualH2FontSizes.size() > 0);
        Assert.assertEquals(actualH2FontSizes, expectedH1FontSizes);
    }
    @Test
    @QaseId(value = 1140)
    public void testLinksColors_GtcPage(){
        GtcPage gtcPage = new GtcPage(getDriver());
        final List<String> expectedH1Colors = List.of(
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)",
                "rgba(223, 93, 93, 1)"
        );
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickGtcPage()
                .closeRegisterPage()
                .switchToGtcPage()
                .waitForUrlContains("https://swisscows.com/en/gtc");
        final List<String>  actualH1Colors = gtcPage.getColorLinks();

        Assert.assertTrue(actualH1Colors.size() > 0);
        Assert.assertEquals(actualH1Colors, expectedH1Colors);

    }
    @Test(dataProvider = "GtcLinksData", dataProviderClass = TestData.class)
    @QaseId(value = 1141)
    public void testGtcLinksNavigateToCorrespondingPages(
            int index, String expectedURL, String expectedH1text) throws InterruptedException {

        GtcPage gtcPage = new GtcPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .clickGtcPage()
                .closeRegisterPage()
                .switchToGtcPage();


        final String oldURL = gtcPage.getCurrentURL();

        gtcPage
                .clickAllLinks(index);

        String actualURL = gtcPage.getCurrentURL();
        String actualH1Text = gtcPage.getH1Text();

        Assert.assertNotEquals(oldURL, actualURL);
        Assert.assertEquals(actualURL, expectedURL);
        Assert.assertEquals(actualH1Text, expectedH1text);
    }
}
