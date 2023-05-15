package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class ProductsPage extends SidebarMenuPage<ProductsPage> {
    @FindBy(xpath = "//h3[@class='title']")
    private List<WebElement> h3TextAllSubscriptions;
    @FindBy(xpath = "//span[contains(@class,'price')]")
    private List<WebElement> priceAllSubscriptions;
    @FindBy(xpath = "//div[@class ='purchase']//span[@class='price'][1]")
    private WebElement priceEmailStandardSubscription;
    @FindBy(xpath = "//div[@class ='periods']//button[1]")
    private WebElement monthlyOfToggle;
    @FindBy(xpath = "//article//img[@class='logo']")
    private List<WebElement> logoAllSubscriptions;
    @FindBy(xpath = "//article[1]//span[@class ='label discount']")
    private WebElement labelDiscountOfEmailStandard;
    @FindBy(xpath = "//article[1]//button")
    private WebElement buyNowButtonOfEmailStandardSubscription;
    @FindBy(xpath = "//article[2]//button")
    private WebElement buyNowButtonOfEmailPremiumSubscription;
    @FindBy(xpath = "//article[3]//button")
    private WebElement buyNowButtonOfVpnStandardSubscription;
    @FindBy(xpath = "//article[4]//button")
    private WebElement buyNowButtonOfPlatinumSubscription;
    @FindBy(xpath = "//article[1]")
    private WebElement attributeEmailStandardSubscription ;
    @FindBy(xpath = "//article[2]")
    private WebElement attributeEmailPremiumSubscription  ;
    @FindBy(xpath = "//div[@class ='content-box']//button[@class='btn-submit']")
    private WebElement confirmButtonInPopup;
    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public ProductsPage createGeneric() {

        return new ProductsPage(getDriver());
    }
    @Step("Get text all subscriptions ")
    public List<String> getH3AllSubscriptions(){
        return getTexts(h3TextAllSubscriptions);
    }
    @Step("Get text of price all subscriptions ")
    public List<String> getPriceAllSubscriptions(){
        return getTexts(priceAllSubscriptions);
    }
    @Step("Click to toggle ")
    public ProductsPage clickMonthlyOfToggle() {
        click(monthlyOfToggle);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'buy now' button of Email Standard Subscription ")
    public EmailStandardPage clickBuyNowButtonOfEmailStandardSubscription() {
        clickByJavaScript(buyNowButtonOfEmailStandardSubscription);
        return new EmailStandardPage(getDriver());
    }
    @Step("Click 'buy now' button of Email Premium Subscription ")
    public EmailPremiumPage clickBuyNowButtonOfEmailPremiumSubscription() {
        clickByJavaScript(buyNowButtonOfEmailPremiumSubscription);
        return new EmailPremiumPage(getDriver());
    }
    @Step("Click 'buy now' button of Email Premium Subscription ")
    public ProductsPage clickBuyNowButtonOfEmailPremiumSubscription_popup() {
        clickByJavaScript(buyNowButtonOfEmailPremiumSubscription);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'buy now' button of Platinum Subscription ")
    public ProductsPage clickBuyNowButtonOfPlatinumSubscription_popup() {
        clickByJavaScript(buyNowButtonOfPlatinumSubscription);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'buy now' button of Email Standard Subscription ")
    public ProductsPage clickBuyNowButtonOfEmailStandardSubscription_popup() {
        clickByJavaScript(buyNowButtonOfEmailStandardSubscription);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'buy now' button of Vpn Standard Subscription ")
    public VpnStandardPage clickBuyNowButtonOfVpnStandardSubscription() {
        clickByJavaScript(buyNowButtonOfVpnStandardSubscription);
        return new VpnStandardPage(getDriver());
    }
    @Step("Click 'buy now' button of Platinum Subscription ")
    public PlatinumPage clickBuyNowButtonOfPlatinumSubscription() {
        clickByJavaScript(buyNowButtonOfPlatinumSubscription);
        return new PlatinumPage (getDriver());
    }
    @Step("Wait for the page  / products to load")
    public ProductsPage waitUntilToBeVisibleLogoSubscriptions(){
        areAllElementsVisibleAndClickable(logoAllSubscriptions);
        return new ProductsPage(getDriver());
    }
    public void clickConfirmButtonInPopup() {
        click(confirmButtonInPopup);
    }
    @Step("Retrieve the attribute of the Email Standard subscription.")
    public String getAttributeEmailStandardSubscription() {
        wait10ElementToBeVisible(attributeEmailStandardSubscription );
        return getAttribute(attributeEmailStandardSubscription ,"class");
    }

    public String getAttributeEmailPremiumSubscription() {
        wait10ElementToBeVisible(attributeEmailPremiumSubscription);
        return getAttribute(attributeEmailPremiumSubscription,"class");
    }
    public boolean logoAllSubscriptionsIsDysplaed(){

        return areElementsInListDisplayed(logoAllSubscriptions);
    }
    public boolean labelDiscountIsDisplayedOfEmailStandard(){

        return isElementDisplayed(labelDiscountOfEmailStandard);
    }
}
