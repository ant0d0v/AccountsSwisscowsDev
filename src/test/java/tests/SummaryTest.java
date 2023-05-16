package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;


public class SummaryTest extends BaseTest {

    @Test
    public void testOpenVersionTxtAccountPage() {
        MainPage mainPage = new MainPage(getDriver());

        final String expectedTextInSummaryPage = "4.";

        final String actualTitle404Error = mainPage
                .openVersionTxtPageAccount()
                .getTextInSummaryPage();

        Assert.assertTrue(actualTitle404Error.contains(expectedTextInSummaryPage));
    }



}
