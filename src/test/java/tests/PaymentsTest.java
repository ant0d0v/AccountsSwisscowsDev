package tests;

import base.BaseTest;
import com.codeborne.pdftest.PDF;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.PaymentsPage;
import utils.ProjectConstants;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.pdftest.PDF.containsText;
import static org.hamcrest.MatcherAssert.assertThat;

public class PaymentsTest extends BaseTest {
    @Test
    @QaseTitle("Verify the VAT of Switzerland in the downloaded PDF fails")
    @QaseId(value = 1523)
    public void testDownloadPdfFailAndCheckVATOfSwitzerland_PaymentPage() throws IOException, URISyntaxException, InterruptedException {

        final String attributeOfPdfFail = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .clickDownloadIcon()
                .getAttributeOfPdfFail();

        File pdfFile = new File("pdf/" + attributeOfPdfFail);
        PDF pdf = new PDF(new File(pdfFile.toURI()));

        assertThat(pdf, containsText("VAT 7,7%"));
    }

    @Test
    @QaseTitle("Verify the price of the discounted subscription in the downloaded PDF fails")
    @QaseId(value = 1524)
    public void testDownloadPdfFailOfDiscountSubscriptionAndCheckPrice_PaymentPage() throws IOException, URISyntaxException, InterruptedException {

        final String attributeOfPdfFail = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .clickDownloadIconOfDiscountSubscription()
                .getAttributeOfPdfFailDiscountSub();

        File pdfFile = new File("pdf/" + attributeOfPdfFail);
        PDF pdf = new PDF(new File(pdfFile.toURI()));

        assertThat(pdf, containsText("25.00"));
    }

    @Test
    @QaseTitle("Verify the description of the discounted subscription in the downloaded PDF fails ")
    @QaseId(value = 1525)
    public void testDownloadPdfFailOfDiscountSubscriptionAndCheckDescription_PaymentPage() throws IOException, InterruptedException {
        final String attributeOfPdfFail = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .clickDownloadIconOfDiscountSubscription()
                .getAttributeOfPdfFailDiscountSub();

        File pdfFile = new File("pdf/" + attributeOfPdfFail);
        PDF pdf = new PDF(new File(pdfFile.toURI()));

        assertThat(pdf, containsText("Swisscows.email Standard "));
    }

    @Test
    @QaseTitle("Verify the H1 text and font size")
    @QaseId(value = 1526)
    public void testH1Text_PaymentPage() throws IOException, InterruptedException {
        PaymentsPage paymentsPage = new PaymentsPage(getDriver());

        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .getH1Text();

        Assert.assertEquals(actualH1Text, ProjectConstants.H1_TEXT_PAYMENTS_PAGE);
        Assert.assertEquals(paymentsPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);
    }

    @Test
    @QaseTitle("Verify the H1 text of the subscription")
    @QaseId(value = 1527)
    public void testH1TextOfSubscription_PaymentPage() {
        PaymentsPage paymentsPage = new PaymentsPage(getDriver());

        final String actualText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .getTextOfSubscription();

        Assert.assertEquals(actualText, "Swisscows.VPN Standard");

    }

    @Test
    @QaseTitle("Verify the list size of subscriptions")
    @QaseId(value = 1527)
    public void testListSizesOfSubscription_PaymentPage() {

        final int actualSizes = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .getListSizeOfSubscription();

        Assert.assertTrue(actualSizes >= 4);

    }

    @Test
    @QaseTitle("Verify the date and price text of the subscription")
    @QaseId(value = 1529)
    public void testDateAndPriceTextOfSubscription_PaymentPage() {
        PaymentsPage paymentsPage = new PaymentsPage(getDriver());

        final String actualText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .getDateTextOfSubscription();

        final String actualPriceText = paymentsPage.getPriceTextOfSubscription();

        Assert.assertTrue(actualText.contains("2023"));
        Assert.assertEquals(actualPriceText, "10.00 CHF");

    }
    @Test
    @QaseTitle("Verify that the download icons are displayed")
    @QaseId(value = 1530)
    public void testDownloadIconAreDisplayedPaymentPage() {
        PaymentsPage paymentsPage = new PaymentsPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickPaymentsIcon()
                .waitToBeVisibleDownloadIcon();

        Assert.assertTrue(paymentsPage.downloadIconAreDisplayed());

    }


}
