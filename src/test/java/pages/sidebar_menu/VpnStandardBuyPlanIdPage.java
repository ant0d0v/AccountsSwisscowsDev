package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class VpnStandardBuyPlanIdPage extends SidebarMenuPage<VpnStandardBuyPlanIdPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoVpnStandard;
    @FindBy(xpath = "//div[@class = 'product payment-methods']//img[@src='data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNjAiIGhlaWdodD0iNDgiIHZpZXdCb3g9IjAgMCA2MCA0OCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0zNC43OTk2IDQ4TDI1LjQxMTIgNDIuNjI5MUwxOC40OTM1IDQ3LjAyMzVMMTIuNTY0IDQ0LjU4MjFMNS42NDYyMSA0NS41NTg3TDAgNDIuNDc5M0wxMC45MzY2IDI0LjU4OTJMMTYuMTg3NSAzMS4yNjIyTDI4LjE5MTUgMEwzOS42MzU0IDIyLjg3N0w0NS45NDA1IDEyLjg3MDdMNjAgNDIuNDcyOEw1Mi4wOTQgNDUuNTU4N0w0NC42ODIxIDQ0LjA5MzlMMzQuNzk5NiA0OFoiIGZpbGw9IiMwMDREOTkiLz4KPHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBjbGlwLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0yOC4yNzgxIDI3LjQzMzNMMjcuMTg0NSAyMS4wNDY4TDIyLjEzNzggMjMuNDI5NUwyOC40OTU1IDYuMzI3MTVMMzcuNDYyMyAyNS44OTY5TDMyLjcxMjEgMjMuODU5MkwzMC40MzI1IDIwLjc2NjhMMjguMjc4MSAyNy40MzMzWk00Ni4xMzI1IDI4LjE0OTRMNDQuNjUwMSAyNS43MDgxTDQxLjg1MDEgMjcuMjgzNUw0MS4xOTEzIDI1Ljk4MTVMNDUuNjM4NCAxOC4zNjQ1TDQ5LjI3NTIgMjYuNjY1MUw0Ny45NTc1IDI1LjY4ODVMNDYuMTMyNSAyOC4xNDk0Wk02LjUyMzQ0IDM2LjIwOUwxMS4xMzUzIDI4LjMzODJMMTUuNjU0OSAzNC44MTU5TDE0LjI1MTYgMzQuMDQ3N0wxMS4zNzI1IDM1LjE0MTRMOS4yNzczNiAzMy42NzAxTDYuNTIzNDQgMzYuMjA5WiIgZmlsbD0id2hpdGUiLz4KPC9zdmc+Cg==']")
    private WebElement logoOfSubscription;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath= "//div[@class='method'][1]")
    private WebElement cardMethod;
    @FindBy(xpath= "//div[@class='method'][2]")
    private WebElement payPalMethod;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement mainImageOfPlanidPage;
    public VpnStandardBuyPlanIdPage(WebDriver driver) {

        super(driver);
    }

    public VpnStandardBuyPlanIdPage createGeneric() {

        return new VpnStandardBuyPlanIdPage(getDriver());
    }
    @Step("Wait logo Vpn Standard to be visible ")
    public VpnStandartBuyPage waitLogoVpnToBeVisible() {
        wait10ElementToBeVisible(logoVpnStandard);
        return new VpnStandartBuyPage (getDriver());

    }
    @Step("Click card method")
    public VpnStandardBuyPlanIdPage selectCardMethodOfVpnStandard() {
        click(cardMethod);
        return new VpnStandardBuyPlanIdPage(getDriver());

    }
    @Step("Click card payPal method")
    public VpnStandardBuyPlanIdPage selectPayPalMethodMethodOfVpnStandard() {
        click(payPalMethod);
        return new VpnStandardBuyPlanIdPage(getDriver());

    }
    @Step("Wait until to be visible Main image on the page Vpn Standard page ")
    public VpnStandardBuyPlanIdPage waitMainImageToBeVisible() {
        wait10ElementToBeVisible(mainImageOfPlanidPage);
        return new VpnStandardBuyPlanIdPage(getDriver());

    }

    public boolean logoOfEmailIsDysplaed(){
        return isElementDisplayed(logoOfSubscription);
    }



}
