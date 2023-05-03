package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class EmailStandardBuyPage extends SidebarMenuPage<EmailStandardBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoEmailStandard;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    public EmailStandardBuyPage(WebDriver driver) {

        super(driver);
    }

    public EmailStandardBuyPage createGeneric() {

        return new EmailStandardBuyPage(getDriver());
    }
    @Step("Wait logo Email Standard to be visible ")
    public EmailStandardBuyPage waitLogoEmailStandardToBeVisible() {
        wait10ElementToBeVisible(logoEmailStandard);
        return new EmailStandardBuyPage(getDriver());

    }

}
