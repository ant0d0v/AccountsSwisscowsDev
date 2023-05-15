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
import java.util.List;

import static java.lang.Thread.sleep;

public class PaymentsPage extends SidebarMenuPage<PaymentsPage > {
    @FindBy(xpath = "(//div[@class= 'purchase-info']//a)[position() = 1]")
    private WebElement downloadIcon;
    @FindBy(xpath = "//div[@class='purchase-info']/span[text() ='25.00']/following-sibling::a[1]")
    private WebElement downloadIconOfDiscountSubscription;
    @FindBy(xpath = "//div[@class = 'items']//div[@class = 'item']")
    private List<WebElement> listSizeOfSubscription;
    @FindBy(xpath = "//div[@class = 'items']//div[@class = 'item'][1]//h2")
    private WebElement textOfSubscription;
    @FindBy(xpath = "//div[@class = 'items']//div[@class = 'item'][1]//span[@class ='date']")
    private WebElement dateTextOfSubscription;
    @FindBy(xpath = "//div[@class = 'items']//div[@class = 'item'][1]//span[@class ='price']")
    private WebElement priceTextOfSubscription;
    @FindBy(xpath = "//div[@class = 'items']//div[@class = 'item']//*[name()='svg']")
    private List<WebElement> allDownloadIcon;

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
    @Step("Get attribute download of pdf ")
    public String getAttributeOfPdfFail(){
        return getAttribute(downloadIcon,"download");
    }
    @Step("Get attribute discount subscription of pdf ")
    public String getAttributeOfPdfFailDiscountSub(){
        return getAttribute(downloadIconOfDiscountSubscription,"download");
    }
    @Step("Get list sizes of subscription ")
    public int getListSizeOfSubscription(){
        return getListSize(listSizeOfSubscription);
    }
    @Step("Get text of subscription ")
    public String getTextOfSubscription(){
        return getText(textOfSubscription);
    }
    @Step("Get date text  of subscription ")
    public String getDateTextOfSubscription(){
        return getText(dateTextOfSubscription);
    }
    @Step("Get price text of subscription ")
    public String getPriceTextOfSubscription(){
        return getText(priceTextOfSubscription);
    }
    @Step("Wait to be visible all download icon")
    public PaymentsPage waitToBeVisibleDownloadIcon(){
        areAllElementsVisible(allDownloadIcon);
        return this;
    }

    public boolean downloadIconAreDisplayed(){
        return areElementsInListDisplayed(allDownloadIcon);
    }
}
