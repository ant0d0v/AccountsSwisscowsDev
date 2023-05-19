package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NotFound404Page;
import pages.footer_menu.LoginPage;
import pages.footer_menu.UserNotFoundPage;
import utils.ProjectConstants;
import utils.TestUtils;

public class NotFound404PageTest extends BaseTest {
    @Test
    @QaseTitle("Check h1 text ")
    @QaseId(value = 1543)
    public void testH1Text_NotFound404Page() {
        NotFound404Page notFound404Page = new  NotFound404Page(getDriver());

        final String actualH1text= notFound404Page
                .open404PageAccount()
                .getH1Text();


        Assert.assertEquals(actualH1text,"Page not found");
        Assert.assertEquals(notFound404Page.getH1FontSizes(),ProjectConstants.FONT_SIZES_H1_TEXT);
    }
    @Test
    @QaseTitle("Link Start Page navigate to corresponding page")
    @QaseId(value = 1544)
    public void testLink_StartPage_NavigateToCorrespondingPage_NotFound404Page() {
        NotFound404Page notFound404Page = new  NotFound404Page(getDriver());

        final String actualUrl = notFound404Page
                .open404PageAccount()
                .clickStartPageLink()
                .waitMainImageToBeVisible_LoginPage()
                .getCurrentURL();

        Assert.assertTrue(actualUrl.contains(ProjectConstants.URL_LOGIN_PAGE));
    }
}
