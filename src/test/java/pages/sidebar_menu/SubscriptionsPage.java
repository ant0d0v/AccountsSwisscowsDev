package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class SubscriptionsPage extends SidebarMenuPage<SubscriptionsPage> {





    @FindBy(xpath = "//a[@href='/products']")
    private WebElement seeAllLink;

    @FindBy(xpath = "//article[1]//button")
    private WebElement buyNowButtonOfPlatinumSubscription;


    @FindBy(xpath = "//div[@class ='modal']//button[@class='btn-submit']")
    private WebElement confirmButtonInPopup;

    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfPlatinumProduct;

    @FindBy(xpath = "//div[@class ='items']//div[1]//button")
    private WebElement buyNowButtonOfMonthlyPlan;

    @FindBy(xpath = "//div[@class= 'methods']//div[1]")
    private WebElement methodCard;

    @FindBy(xpath = "//button")
    private WebElement buttonProceed;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;
    @FindBy(xpath = "//article[1]")
    private WebElement attributePlatinumSubscription ;
    @FindBy(xpath = "//article[4]")
    private WebElement attributeVpnSubscription ;

    @FindBy(xpath = "//div[3]//iframe")
    private WebElement cardNumberFrame;
    @FindBy(xpath = "//input[@placeholder='Card Number']")
    private WebElement cardNumber;
    @FindBy(xpath = "(//div[4]//iframe)[position() =1]")
    private WebElement cardDateFrame;
    @FindBy(xpath = "//input[@placeholder='__/__']")
    private WebElement cardDate;
    @FindBy(xpath = "(//div[4]//iframe)[position() =2]")
    private WebElement cardSvvCodeFrame;
    @FindBy(xpath = "//input[@placeholder='___']")
    private WebElement cardSvvCode;
    @FindBy(xpath = "//button[@class]")
    private WebElement proceedButton;
    @FindBy(xpath = "//div[@class = 'product checkout success']//h1")
    private WebElement successfulMessage;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration-success.svg']")
    private WebElement successfulImage;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement paymentImage;
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buttonGoToCatalogue;
    @FindBy(xpath = "//img[@src='./images/empty-subscription-illustration.svg']")
    private WebElement mainImageSubscriptionPage;
    @FindBy(xpath = "//h3[@class='title']")
    private List<WebElement> h3TextAllSubscriptions;
    @FindBy(xpath = "//span[@class ='price']")
    private List<WebElement> priceAllSubscriptions;
    @FindBy(xpath = "//div[@class ='purchase']//span[@class='price'][1]")
    private WebElement priceEmailStandardSubscription;
    @FindBy(xpath = "//div[@class ='periods']//button[2]")
    private WebElement yearOfToggle;

    public SubscriptionsPage(WebDriver driver) {

        super(driver);
    }

    public SubscriptionsPage createGeneric() {

        return new SubscriptionsPage(getDriver());
    }


    public ProductsPage clickSeeAllLink() {
        wait10ElementToBeVisible(seeAllLink);
        click(seeAllLink);
        return new ProductsPage (getDriver());
    }
    @Step("Click 'Go to catalogue' button")
    public ProductsPage clickButtonGoToCatalogue() {

        click(buttonGoToCatalogue);
        return new ProductsPage (getDriver());
    }
    public SubscriptionsPage waitSuccessImage() {
        wait20ElementToBeVisible(successfulImage);
        wait10ElementToBeVisible(successfulMessage);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Wait util to be visible main image on the /subscription page")
    public SubscriptionsPage waitToBeVisibleMainImage_SubscriptionPage() {

        wait10ElementToBeVisible(mainImageSubscriptionPage);
        return new SubscriptionsPage (getDriver());
    }
    public boolean mainImageIsDysplaed_SubscriptionPage() {
        return isElementDisplayed(mainImageSubscriptionPage);
    }
    public SubscriptionsPage clickBuyNowButtonOfPlatinumSubscription() {
        clickByJavaScript(buyNowButtonOfPlatinumSubscription);
        return new SubscriptionsPage (getDriver());
    }

    public SubscriptionsPage clickConfirmButtonInPopup() {
        click(confirmButtonInPopup);
        return new SubscriptionsPage (getDriver());
    }

    public SubscriptionsPage clickBuyNowButtonOfMonthlyPlan() {
        click(buyNowButtonOfMonthlyPlan);
        return new SubscriptionsPage (getDriver());
    }
    public SubscriptionsPage clickMethodCard() {
        click(methodCard);
        click(buttonProceed);
        return new SubscriptionsPage (getDriver());
    }
    public void clickClearInputRegularCardName() {
        click(userName);
        userName.clear();
        String name = "TEST";
        input(name, userName);

    }
    public void clickClearInputRegularCardNumber() throws InterruptedException {
        getDriver().switchTo().frame(cardNumberFrame);
        click(cardNumber);
        String name = "4111111111111111";
        input(name,cardNumber);



    }
    public void clickClearInputRegularCardDate() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardDateFrame);
        clickByJavaScript(cardDate);
        String email = "1143";
        input(email,cardDate);
    }
    public void clickClearInputRegularCardCvvCode() {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardSvvCodeFrame);
        click(cardSvvCode);
        cardSvvCode.clear();
        String email = "434";
        input(email, cardSvvCode);
        getDriver().switchTo().defaultContent();
    }
    public void clickProceedButton() {
        click(proceedButton);
    }


    public SubscriptionsPage payByCard() throws InterruptedException {
        clickClearInputRegularCardName();
        clickClearInputRegularCardNumber();
        clickClearInputRegularCardDate();
        clickClearInputRegularCardCvvCode();
        clickProceedButton();

        return new SubscriptionsPage(getDriver());
    }
    public String getTextSuccessfulMessage() {
        return getText(successfulMessage);
    }

}
