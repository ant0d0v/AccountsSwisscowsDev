package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class VpnStandartBuyPage extends SidebarMenuPage<VpnStandartBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoVpnStandard;
    @FindBy(xpath= "//div[@class= 'plan'][1]//button")
    private WebElement buttonOfMonthlyPlan;
    @FindBy(xpath= "//div[@class= 'plan'][2]//button")
    private WebElement buttonOfAnnualPlan;
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
    @Step("Click monthly plan")
    public VpnStandardBuyPlanIdPage clickMonthlyPlanOfVpnStandard() {
        click(buttonOfMonthlyPlan);
        return new VpnStandardBuyPlanIdPage (getDriver());

    }
    @Step("Click Annual plan  ")
    public VpnStandardBuyPlanIdPage clickAnnualPlanOfVpnStandard() {
        click(buttonOfAnnualPlan);
        return new VpnStandardBuyPlanIdPage (getDriver());

    }

}
