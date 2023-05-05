package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class PlatinumBuyPage extends SidebarMenuPage<PlatinumBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//div[@class= 'plan'][1]//button")
    private WebElement buttonOfMonthlyPlan;
    @FindBy(xpath= "//div[@class= 'plan'][2]//button")
    private WebElement buttonOfAnnualPlan;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoPlatinum;
    public PlatinumBuyPage(WebDriver driver) {

        super(driver);
    }

    public PlatinumBuyPage createGeneric() {

        return new PlatinumBuyPage(getDriver());
    }
    @Step("Wait logo Email Standard to be visible ")
    public PlatinumBuyPage waitLogoPlatinumToBeVisible() {
        wait10ElementToBeVisible(logoPlatinum);
        return new PlatinumBuyPage(getDriver());
    }
    @Step("Click monthly plan")
    public PlatinumBuyPlanIdPage clickMonthlyPlanOfPlatinum() {
        click(buttonOfMonthlyPlan);
        return new PlatinumBuyPlanIdPage(getDriver());

    }
    @Step("Click Annual plan  ")
    public PlatinumBuyPlanIdPage clickAnnualPlanOfPlatinum() {
        click(buttonOfAnnualPlan);
        return new PlatinumBuyPlanIdPage(getDriver());

    }
}
