package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class CardMethodPage extends SidebarMenuPage<CardMethodPage> {
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath = "//div[@class='method'][1]")
    private WebElement cardMethod;
    @FindBy(xpath = "//div[@class='method'][2]")
    private WebElement payPalMethod;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement userName;
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

    public CardMethodPage(WebDriver driver) {

        super(driver);
    }

    public CardMethodPage createGeneric() {

        return new CardMethodPage(getDriver());
    }
    public CardMethodPage clickInputEnterCardName(String nameUserOfCard) {
        click(userName);
        userName.clear();
        input(nameUserOfCard, userName);
        return new CardMethodPage(getDriver());
    }
    public CardMethodPage clickInputEnterCardNumber(String numberOfCard) throws InterruptedException {
        getDriver().switchTo().frame(cardNumberFrame);
        click(cardNumber);
        input(numberOfCard,cardNumber);
        return new CardMethodPage(getDriver());
    }
    public CardMethodPage clickInputEnterCardDate(String numberOfDate) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardDateFrame);
        clickByJavaScript(cardDate);
        input(numberOfDate,cardDate);
        return new CardMethodPage(getDriver());
    }
    public CardMethodPage clickInputEnterCardCvvCode(String numberOfSvv) {
        getDriver().switchTo().defaultContent();
        getDriver().switchTo().frame(cardSvvCodeFrame);
        click(cardSvvCode);
        cardSvvCode.clear();
        input(numberOfSvv, cardSvvCode);
        getDriver().switchTo().defaultContent();
        return new CardMethodPage(getDriver());
    }
    public SubscriptionsPage payByCard() throws InterruptedException {
        clickInputEnterCardName("");
        clickInputEnterCardNumber("");
        clickInputEnterCardDate("");
        clickInputEnterCardCvvCode("");
        clickProceedButton_SubscriptionPage();
        return new SubscriptionsPage(getDriver());
    }
    public SubscriptionsPage clickProceedButton_SubscriptionPage() {
        click(buttonProceed);
        return new SubscriptionsPage(getDriver());
    }
    public boolean validationErrorIconIsDysplaed(){
        return isElementDisplayed(errorIcon);
    }

    public boolean validationSuccessIconIsDysplaed(){
        return isElementDisplayed(successIcon);
    }

}
