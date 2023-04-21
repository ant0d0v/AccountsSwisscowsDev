package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class EmailStandardBuyPage extends SidebarMenuPage<EmailStandardBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;

    public EmailStandardBuyPage(WebDriver driver) {

        super(driver);
    }

    public EmailStandardBuyPage createGeneric() {

        return new EmailStandardBuyPage(getDriver());
    }
}
