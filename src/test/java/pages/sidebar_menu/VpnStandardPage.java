package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class VpnStandardPage extends SidebarMenuPage<VpnStandardPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
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



}