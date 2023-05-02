package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class EmailPremiumPage extends SidebarMenuPage<EmailPremiumPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    public EmailPremiumPage(WebDriver driver) {

        super(driver);
    }

    public EmailPremiumPage createGeneric() {

        return new EmailPremiumPage(getDriver());
    }
    public EmailPremiumBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new EmailPremiumBuyPage (getDriver());
    }



}