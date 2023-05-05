package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class EmailPremiumBuyPlanIdPage extends SidebarMenuPage<EmailPremiumBuyPlanIdPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoEmailStandard;
    @FindBy(xpath = "//div[@class = 'product payment-methods']//img[@src='data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNDgiIGhlaWdodD0iNDgiIHZpZXdCb3g9IjAgMCA0OCA0OCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPGcgY2xpcC1wYXRoPSJ1cmwoI2NsaXAwXzMzMF84MjIyKSI+CjxwYXRoIGQ9Ik00OCAxNC43ODFMMC4wMDI3MzEzMiA0NVYxNC43ODFMMjQuMDAxNCAwTDQ4IDE0Ljc4MVoiIGZpbGw9IiNGRjhCMDAiLz4KPHJlY3QgeD0iMTkuMzk4NCIgeT0iMTQuMTI1IiB3aWR0aD0iOS41MzM3IiBoZWlnaHQ9IjcuODgzMjEiIGZpbGw9IndoaXRlIi8+CjxyZWN0IHg9IjEwLjUxNTYiIHk9IjIyLjAwMzkiIHdpZHRoPSIyNy4yODYxIiBoZWlnaHQ9IjcuODgzMiIgZmlsbD0id2hpdGUiLz4KPHBhdGggZD0iTTQ4IDE0Ljc4MTJMMC4wMDI3MzEzMiA0NS4wMDAySDQ4VjE0Ljc4MTJaIiBmaWxsPSIjRkEzQjJCIi8+CjxwYXRoIGQ9Ik0wIDE0Ljc4MTJMNDcuOTk3MyA0NS4wMDAySDBWMTQuNzgxMloiIGZpbGw9IiNENzA0MDQiLz4KPC9nPgo8ZGVmcz4KPGNsaXBQYXRoIGlkPSJjbGlwMF8zMzBfODIyMiI+CjxyZWN0IHdpZHRoPSI0OCIgaGVpZ2h0PSI0OCIgZmlsbD0id2hpdGUiLz4KPC9jbGlwUGF0aD4KPC9kZWZzPgo8L3N2Zz4K']")
    private WebElement logoOfSubscription;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath= "//div[@class='method'][1]")
    private WebElement cardMethod;
    @FindBy(xpath= "//div[@class='method'][2]")
    private WebElement payPalMethod;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement mainImageOfPlanidPage;
    public EmailPremiumBuyPlanIdPage(WebDriver driver) {

        super(driver);
    }

    public EmailPremiumBuyPlanIdPage createGeneric() {

        return new EmailPremiumBuyPlanIdPage(getDriver());
    }
    @Step("Wait logo Email Premium to be visible ")
    public EmailPremiumBuyPage waitLogoEmailToBeVisible() {
        wait10ElementToBeVisible(logoEmailStandard);
        return new EmailPremiumBuyPage(getDriver());

    }
    @Step("Click card method")
    public EmailPremiumBuyPlanIdPage selectCardMethodOfEmailPremium() {
        click(cardMethod);
        return new EmailPremiumBuyPlanIdPage(getDriver());

    }
    @Step("Click card payPal method")
    public EmailPremiumBuyPlanIdPage selectPayPalMethodMethodOfEmailPremium() {
        click(payPalMethod);
        return new EmailPremiumBuyPlanIdPage(getDriver());

    }
    @Step("Wait until to be visible Main image on the page Email Premium page ")
    public EmailPremiumBuyPlanIdPage waitMainImageToBeVisible() {
        wait10ElementToBeVisible(mainImageOfPlanidPage);
        return new EmailPremiumBuyPlanIdPage(getDriver());

    }

    public boolean logoOfEmailIsDysplaed(){
        return isElementDisplayed(logoOfSubscription);
    }



}
