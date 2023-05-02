package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class EmailPremiumBuyPage extends SidebarMenuPage<EmailPremiumBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoEmailPremium;
    public EmailPremiumBuyPage(WebDriver driver) {

        super(driver);
    }

    public EmailPremiumBuyPage createGeneric() {

        return new EmailPremiumBuyPage(getDriver());
    }
    @Step("Wait logo Email Standard to be visible ")
    public EmailPremiumBuyPage waitLogoEmailPremiumToBeVisible() {
        wait10ElementToBeVisible(logoEmailPremium);
        return new EmailPremiumBuyPage(getDriver());

    }
}
