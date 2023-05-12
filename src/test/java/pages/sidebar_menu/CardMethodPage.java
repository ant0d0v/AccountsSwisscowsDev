package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;
import utils.ProjectConstants;

import java.util.List;

import static java.lang.Thread.sleep;

public class CardMethodPage extends SidebarMenuPage<CardMethodPage> {
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath = "//div[@class='method'][1]")
    private WebElement cardMethod;
    @FindBy(xpath = "//div[@class='method'][2]")
    private WebElement payPalMethod;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;
    @FindBy(xpath = "//input[@id = 'email']")
    private WebElement emailPaypal;
    @FindBy(xpath = "//input[@id = 'password']")
    private WebElement passwordPaypal;
    @FindBy(xpath = "//button")
    private WebElement buttonProceed;
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
    @FindBy(xpath = "//*[local-name()='svg' and @class='icon error']")
    private WebElement errorIcon;
    @FindBy(xpath = "//*[local-name()='svg' and @class='icon check']")
    private WebElement successIcon;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement mainImageOfCardPage;
    @FindBy(xpath = "//button[@id = 'test-source-authorize-3ds']")
    private WebElement completeAuthenticationButton;
    @FindBy(xpath = "//button[@id = 'test-source-fail-3ds']")
    private WebElement failAuthenticationButton;
    @FindBy(xpath = "//button[text() = 'Log In']")
    private WebElement loginButtonOfPayPal;
    @FindBy(xpath = "//button[text() = 'Next']")
    private WebElement nextButtonOfPayPal;
    @FindBy(xpath = "//div[@id='button']")
    private WebElement agreeButtonOfPayPal;
    @FindBy(xpath = "(//div[@class= 'headerWrapper']//img)[position() =1]")
    private WebElement imageSwisscowsOfPayPal;

    public CardMethodPage(WebDriver driver) {

        super(driver);
    }

    public CardMethodPage createGeneric() {

        return new CardMethodPage(getDriver());
    }
    @Step("Enter user name of PayPal ")
    public void clickInputAndEnterEmailPayPal(String emailUserOfPaypal) {
        click(emailPaypal);
        emailPaypal.clear();
        input(emailUserOfPaypal, emailPaypal);
    }
    @Step("Enter user password of PayPal ")
    public void clickInputAndEnterPasswordPayPal(String passwordUserOfPaypal) {
        click(passwordPaypal);
        passwordPaypal.clear();
        input(passwordUserOfPaypal, passwordPaypal);
    }
    @Step("Enter user name of card form ")
    public CardMethodPage clickInputEnterCardName(String nameUserOfCard) {
        click(userName);
        userName.clear();
        input(nameUserOfCard, userName);
        return new CardMethodPage(getDriver());
    }
    @Step("Enter number of card form ")
    public CardMethodPage clickInputEnterCardNumber(String numberOfCard) throws InterruptedException {
        getDriver().switchTo().frame(cardNumberFrame);
        click(cardNumber);
        input(numberOfCard,cardNumber);
        return new CardMethodPage(getDriver());
    }
    @Step("Enter date of card form ")
    public CardMethodPage clickInputEnterCardDate(String numberOfDate) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardDateFrame);
        clickByJavaScript(cardDate);
        input(numberOfDate,cardDate);
        return new CardMethodPage(getDriver());
    }
    @Step("Enter cvv of card form ")
    public CardMethodPage clickInputEnterCardCvvCode(String numberOfSvv) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardSvvCodeFrame);
        click(cardSvvCode);
        cardSvvCode.clear();
        input(numberOfSvv, cardSvvCode);
        getDriver().switchTo().defaultContent();
        return new CardMethodPage(getDriver());
    }
    public SubscriptionsPage payUsingVisa() throws InterruptedException {
        clickInputEnterCardName("TEST");
        clickInputEnterCardNumber(ProjectConstants.VISA_CARD);
        clickInputEnterCardDate("1430");
        clickInputEnterCardCvvCode("333");
        clickProceedButton_SubscriptionPage();
        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage payUsingVisa3DSecure() throws InterruptedException {
        clickInputEnterCardName("qa");
        clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD);
        clickInputEnterCardDate("1133");
        clickInputEnterCardCvvCode("123");
        clickProceedButton_SubscriptionPage();
        waitForUrlContains("https://stripe.com/sources/test_source_3ds");
        click20(completeAuthenticationButton);

        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage errorPayUsingVisa3DSecure() throws InterruptedException {
        clickInputEnterCardName("forvard asdf");
        clickInputEnterCardNumber(ProjectConstants.VISA_3DS_CARD);
        clickInputEnterCardDate("0128");
        clickInputEnterCardCvvCode("312");
        clickProceedButton_SubscriptionPage();
        waitForUrlContains("https://stripe.com/sources/test_source_3ds");
        click20(failAuthenticationButton);

        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage payUsingMasterCard() throws InterruptedException {
        clickInputEnterCardName("aqa test");
        clickInputEnterCardNumber(ProjectConstants.MASTER_CARD);
        clickInputEnterCardDate("1228");
        clickInputEnterCardCvvCode("999");
        clickProceedButton_SubscriptionPage();
        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage payUsingAmericanExpress() throws InterruptedException {
        clickInputEnterCardName("aqa test");
        clickInputEnterCardNumber(ProjectConstants.AMERICAN_EXPRESS_CARD);
        clickInputEnterCardDate("0530");
        clickInputEnterCardCvvCode("5761");
        clickProceedButton_SubscriptionPage();
        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage payUsingPayPal() throws InterruptedException {
        clickProceedButton_SubscriptionPage();
        waitForUrlContains(ProjectConstants.URL_PAYPAL_PAGE);
        clickInputAndEnterEmailPayPal("sb-8jt1w3346523@personal.example.com");
        click20(nextButtonOfPayPal);
        clickInputAndEnterPasswordPayPal("kHTp{/I0");
        click20(loginButtonOfPayPal);
        wait20ElementToBeVisible(imageSwisscowsOfPayPal);
        click20(agreeButtonOfPayPal);
        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage clickProceedButton_SubscriptionPage() {
        click(buttonProceed);
        return new SubscriptionsPage(getDriver());
    }
    @Step("Wait until to be visible Main image on the page ")
    public CardMethodPage waitMainImageToBeVisible() {
        wait10ElementToBeVisible(mainImageOfCardPage);
        return new CardMethodPage (getDriver());

    }
    public boolean mainImageIsDisplayed(){
        return isElementDisplayed(mainImageOfCardPage);
    }
    public boolean validationErrorIconIsDysplaed(){
        return isElementDisplayed(errorIcon);
    }

    public boolean validationSuccessIconIsDysplaed(){
        return isElementDisplayed(successIcon);
    }

}
