package tests.footer;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.cookie.BasicCookieStore;
import org.apache.hc.client5.http.cookie.CookieStore;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.cookie.BasicClientCookie;
import org.apache.hc.client5.http.protocol.HttpClientContext;
import org.apache.http.client.config.CookieSpecs;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.ResetPage;
import pages.footer_menu.RestorePage;
import tests.retrytest.Retry;
import utils.EmailUtils;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class ResetTest extends BaseTest {
    @Test
    @QaseId(value = 1111)
    public void tesValidationErrorMessageFieldIsEmpty_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The field is required",
                "The field is required"

        );
        openLoginURL()
                .enterNewUserEmail("a.qa@swisscows.email")
                .enterNewUserPassword("2075Deltuha")
                .clickLoginButton_Dashboard();

        String authorizationCookieValue = getDriver().manage().getCookieNamed(".AspNetCore.Identity.Application").getValue();

        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie authorizationCookie = new BasicClientCookie(".AspNetCore.Identity.Application", authorizationCookieValue);
        authorizationCookie.setDomain("https://accounts.dev.swisscows.com");
        authorizationCookie.setPath("/");
        cookieStore.addCookie(authorizationCookie);
        getDriver().navigate().refresh();
//        getDriver().manage().addCookie(cookie);
//
//        String session = response.getCookie("__stripe_sid");
//        System.out.println(session);



//                .clickLinkForgotPassword()
//                .waitMainImageToBeVisible_ForgotPage()
//                .enterUserEmail(ProjectConstants.GMAIL_USER)
//                .clickSubmitButton_RestorePage()
//                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);
//
//        final List actualTextValidationError = restorePage
//                .enterCode(code)
//                .clickSubmitButton()
//                .clickSubmitButton()
//                .getListValidationErrorMessage();
//
//
//        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
//        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
//        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1112)
    public void tesValidationErrorMessageInvalidNewPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password must contain at least 8 characters, including letters and numbers",
                "The field is required"
        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final List actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword("da12")
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1113)
    public void tesValidationErrorMessageInvalidRepeatPassword_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedTextValidationError = List.of(
                "The password confirmation doesn't match"

        );

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final List actualTextValidationError = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .repeatUserPassword("2075Delt")
                .clickSubmitButton()
                .getListValidationErrorMessage();


        Assert.assertEquals(actualTextValidationError, expectedTextValidationError);
        Assert.assertTrue(restorePage.isErrorImageIsDisplayed());
        Assert.assertTrue(restorePage.isErrorIconIsDisplayed());

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1114)
    public void testLinkInTheFooterNavigateToCorrespondingPage_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        restorePage
                .enterCode(code)
                .clickLinkInTheFooterMenu()
                .waitForUrlContains(ProjectConstants.URL_LOGIN_PAGE);

        Assert.assertEquals(restorePage.getTitle(),ProjectConstants.TITLE_LOGIN_PAGE);
        Assert.assertEquals(restorePage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1115)
    public void testPlaceholderIsAvailable_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        final List<String> expectedInnerTextOfPlaceholder = List.of(
                "New password"
        );
        final String attribute = "placeholder";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);


        final List<String> actualInnerTextOfPlaceholder = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .getInnerTextOfPlaceholders(attribute);

        Assert.assertEquals(actualInnerTextOfPlaceholder, expectedInnerTextOfPlaceholder);

    }
    @Test(retryAnalyzer = Retry.class)
    @QaseId(value = 1116)
    public void testH1Text_ResetPage() throws InterruptedException, MessagingException, IOException {
        RestorePage restorePage = new RestorePage(getDriver());
        ResetPage resetPage = new ResetPage(getDriver());
        final  String expectedH1Text = "Reset password";

        final String code = openLoginURL()
                .clickLinkForgotPassword()
                .waitMainImageToBeVisible_ForgotPage()
                .enterUserEmail(ProjectConstants.GMAIL_USER)
                .clickSubmitButton_RestorePage()
                .getCodeFromGmailBox(EmailUtils.GMAIL_USER,EmailUtils.PASSWORD_GMAIL);

        final String actualH1Text = restorePage
                .enterCode(code)
                .clickSubmitButton()
                .waitMainImageToBeVisible_ResetPage()
                .getH1Text();

        Assert.assertTrue(resetPage.imageIsDisplayedResetPage());
        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(restorePage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }

}
