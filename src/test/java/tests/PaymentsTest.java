package tests;

import base.BaseTest;
import com.codeborne.pdftest.PDF;
import io.qase.api.annotation.QaseId;
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
    @QaseId(value = 1144)
    public void testDownloadPdfFailAndCheckVATOfSwitzerland_DashboardPage() throws IOException, URISyntaxException, InterruptedException {
        PaymentsPage paymentsPage = new PaymentsPage(getDriver());

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
}
