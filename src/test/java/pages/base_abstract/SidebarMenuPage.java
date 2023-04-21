package pages.base_abstract;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.sidebar_menu.EmailStandardBuyPage;
import pages.sidebar_menu.ProductsPage;
import pages.sidebar_menu.ProfilePage;
import pages.sidebar_menu.SubscriptionsPage;
import utils.ProjectConstants;

import java.util.List;

public abstract class SidebarMenuPage<Generic> extends FooterMenuPage{
    @FindBy(xpath = "//img")
    private List<WebElement> allImageOnPage;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement profileIcon;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement buttonСhangePassword;
    @FindBy(xpath = "//h1[@class='modal-title']")
    private WebElement h1TextOfPopup;
    @FindBy(xpath = "//div[@id='portal']//button[@class='link']")
    private WebElement linkOfPopup;
    @FindBy(xpath = "//div[contains(@class,'modal')]")
    WebElement popup;
    @FindBy(xpath = "//ul[@class ='menu-list']//li[3]//a")
    private WebElement subscriptionIcon;
    @FindBy(xpath = "//a[text()='Back to list']")
    private WebElement linkBackToList;
    @FindBy(xpath = "//div[@class='description']//*[name() = 'svg']")
    private List<WebElement> iconsOfProduct;
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;


    public SidebarMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
    public ProfilePage clickProfileIconInSidebar(){
        click20(profileIcon);
        waitForUrlContains(ProjectConstants.URL_PROFILE_PAGE);
        return new ProfilePage(getDriver());
    }
    public String getH1TextOfPopup() {

        return getText(h1TextOfPopup);
    }
    public String getFontSizeH1TextOfPopup() {

        return getFontSize(h1TextOfPopup);
    }
    public ProfilePage clickLinkInPopup() {
        click(linkOfPopup);
        return new ProfilePage(getDriver());

    }
    public ProductsPage clickLinkBackToListOfProduct() {
        click(linkBackToList);
        return new ProductsPage(getDriver());

    }
    public EmailStandardBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new EmailStandardBuyPage (getDriver());
    }
    public boolean isPopupPresent() {
        try {
            getDriver().findElement(By.xpath("//div[contains(@class, 'modal')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isBuyNowButtonOfPresent() {
        try {
            getDriver().findElement(By.xpath("//a[@class='btn-submit']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public SubscriptionsPage clickSubscriptionIcon() {

        click(subscriptionIcon);
        return new SubscriptionsPage (getDriver());
    }
    public boolean buyNowButtonOfProductIsDisplayed() {
        return isElementDisplayed(buyNowButtonOfProduct);
    }
    public boolean allIconsOfProductIsDysplaed(){
        return areElementsInListDisplayed(iconsOfProduct);
    }

}
