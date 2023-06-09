package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class EmailStandardPage extends SidebarMenuPage<EmailStandardPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    public EmailStandardPage(WebDriver driver) {

        super(driver);
    }

    public EmailStandardPage createGeneric() {

        return new EmailStandardPage(getDriver());
    }
    public EmailStandardBuyPage clickBuyNowButtonOfProduct() {
        click(buyNowButtonOfProduct);
        return new EmailStandardBuyPage (getDriver());
    }



}
