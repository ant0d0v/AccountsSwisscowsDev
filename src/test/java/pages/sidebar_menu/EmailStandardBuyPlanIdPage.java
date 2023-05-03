package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class EmailStandardBuyPlanIdPage extends SidebarMenuPage<EmailStandardBuyPlanIdPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoEmailStandard;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    public EmailStandardBuyPlanIdPage(WebDriver driver) {

        super(driver);
    }

    public EmailStandardBuyPlanIdPage createGeneric() {

        return new EmailStandardBuyPlanIdPage(getDriver());
    }


}
