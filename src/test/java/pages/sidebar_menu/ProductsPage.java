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
    @FindBy(xpath = "//span[@class ='price']")
    private List<WebElement> priceAllSubscriptions;
    @FindBy(xpath = "//div[@class ='purchase']//span[@class='price'][1]")
    private WebElement priceEmailStandardSubscription;
    @FindBy(xpath = "//div[@class ='periods']//button[2]")
    private WebElement yearOfToggle;
    @FindBy(xpath = "//article//img[@class='logo']")
    private List<WebElement> logoAllSubscriptions;
    @FindBy(xpath = "//article[1]//button")
    private WebElement buyNowButtonOfEmailStandardSubscription;
    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    public ProductsPage createGeneric() {

        return new ProductsPage(getDriver());
    }
    public List<String> getH3AllSubscriptions(){
        return getTexts(h3TextAllSubscriptions);
    }
    public List<String> getPriceAllSubscriptions(){
        return getTexts(priceAllSubscriptions);
    }
    public ProductsPage clickYearOfToggle() {
        waitTextToBeChanged(priceEmailStandardSubscription,"45.00 CHF/month");
        click(yearOfToggle);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'buy now' button of Email Standard Subscription ")
    public EmailStandardPage clickBuyNowButtonOfEmailStandardSubscription() {
        clickByJavaScript(buyNowButtonOfEmailStandardSubscription);
        return new EmailStandardPage(getDriver());
    }
    @Step("Wait for the page  / products to load")
    public ProductsPage waitUntilToBeVisibleLogoSubscriptions(){
        areAllElementsVisibleAndClickable(logoAllSubscriptions);
        return new ProductsPage(getDriver());
    }
    public boolean logoAllSubscriptionsIsDysplaed(){
        return areElementsInListDisplayed(logoAllSubscriptions);
    }
}
