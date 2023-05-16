package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class VpnStandardPage extends SidebarMenuPage<VpnStandardPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//p[@class ='bought-message']")
    private WebElement boughtMessage;
    public VpnStandardPage(WebDriver driver) {

        super(driver);
    }

    public VpnStandardPage createGeneric() {

        return new VpnStandardPage(getDriver());
    }
    public VpnStandartBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new VpnStandartBuyPage (getDriver());
    }
    @Step("Wait until to be visible bought message")
    public VpnStandardPage waitToBeVisibleBoughtMessage(){
        wait10ElementToBeVisible(boughtMessage);
        return this;
    }



}