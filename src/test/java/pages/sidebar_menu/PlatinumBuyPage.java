package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class PlatinumBuyPage extends SidebarMenuPage<PlatinumBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
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
}
