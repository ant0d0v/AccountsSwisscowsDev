package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class PlatinumPage extends SidebarMenuPage<PlatinumPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    public PlatinumPage(WebDriver driver) {

        super(driver);
    }

    public PlatinumPage createGeneric() {

        return new PlatinumPage(getDriver());
    }
    public EmailPremiumBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new EmailPremiumBuyPage (getDriver());
    }



}