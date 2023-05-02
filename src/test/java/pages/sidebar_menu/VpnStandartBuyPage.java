package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class VpnStandartBuyPage extends SidebarMenuPage<VpnStandartBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoVpnStandard;
    public VpnStandartBuyPage(WebDriver driver) {

        super(driver);
    }

    public VpnStandartBuyPage createGeneric() {

        return new VpnStandartBuyPage(getDriver());
    }
    @Step("Wait logo Vpn Standard to be visible ")
    public VpnStandartBuyPage waitLogoVpnStandardToBeVisible() {
        wait10ElementToBeVisible(logoVpnStandard);
        return new VpnStandartBuyPage(getDriver());

    }
}
