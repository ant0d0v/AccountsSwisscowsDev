package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.io.*;
import java.net.URL;

import static java.lang.Thread.sleep;

public class PaymentsPage extends SidebarMenuPage<PaymentsPage > {
    @FindBy(xpath = "(//div[@class= 'purchase-info']//a)[position() = 1]")
    private WebElement downloadIcon;
    @FindBy(xpath = "//div[@class='purchase-info']/span[text() ='25.00']/following-sibling::a[1]")
    private WebElement downloadIconOfDiscountSubscription;

    public PaymentsPage(WebDriver driver) {

        super(driver);
    }
    public PaymentsPage createGeneric() {
        return new PaymentsPage(getDriver());
    }
    @Step("Click download icon")
    public PaymentsPage clickDownloadIcon() throws InterruptedException {
        click(downloadIcon);
        sleep(3000);
        return new PaymentsPage (getDriver());
    }
    @Step("Click download of discount icon")
    public PaymentsPage clickDownloadIconOfDiscountSubscription() throws InterruptedException {
        click(downloadIconOfDiscountSubscription);
        sleep(3000);
        return new PaymentsPage (getDriver());
    }
    @Step("Get pdf text")
    public String getTextInThePdfFile(String pdfUrl) throws IOException {
        URL url = new URL(pdfUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis= new BufferedInputStream(is);
        PDDocument doc = PDDocument.load(bis);
        return  new PDFTextStripper().getText(doc);
    }
    public String getAttributeOfPdfFail(){
        return getAttribute(downloadIcon,"download");
    }
    public String getAttributeOfPdfFailDiscountSub(){
        return getAttribute(downloadIconOfDiscountSubscription,"download");
    }
    public void openPdfFail (String url){
        getDriver().get(url);

    }
}
