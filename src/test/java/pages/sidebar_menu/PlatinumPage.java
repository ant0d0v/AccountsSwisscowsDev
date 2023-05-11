package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class PlatinumPage extends SidebarMenuPage<PlatinumPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath = "//div[@class ='description']//a")
    private List<WebElement> linkOfPlatinumPage;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoSubscription;
    public PlatinumPage(WebDriver driver) {

        super(driver);
    }
    @Step("Click link of platinum page")
    public void clickLinksOfPage(int index) {
        click(getAllLinksOnPage().get(index));
        wait10ElementToBeVisible(logoSubscription);
        createGeneric();
    }
    public List<WebElement> getAllLinksOnPage() {

        return  linkOfPlatinumPage;
    }

    public PlatinumPage createGeneric() {

        return new PlatinumPage(getDriver());
    }
    public PlatinumBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new PlatinumBuyPage (getDriver());
    }

}