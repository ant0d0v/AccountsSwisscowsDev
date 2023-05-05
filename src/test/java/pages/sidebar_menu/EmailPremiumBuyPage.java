package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;
import tests.EmailPremiumPlanidTest;

import java.util.List;

public class EmailPremiumBuyPage extends SidebarMenuPage<EmailPremiumBuyPage> {
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath= "//h1//img[@src]")
    private WebElement logoEmailPremium;
    @FindBy(xpath= "//div[@class= 'plan'][1]//button")
    private WebElement buttonOfMonthlyPlan;
    @FindBy(xpath= "//div[@class= 'plan'][2]//button")
    private WebElement buttonOfAnnualPlan;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
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
    @Step("Click monthly plan")
    public EmailPremiumBuyPlanIdPage clickMonthlyPlanOfEmailPremium() {
        click(buttonOfMonthlyPlan);
        return new EmailPremiumBuyPlanIdPage(getDriver());

    }
    @Step("Click Annual plan  ")
    public EmailPremiumBuyPlanIdPage clickAnnualPlanOfEmailPremium() {
        click(buttonOfAnnualPlan);
        return new EmailPremiumBuyPlanIdPage(getDriver());

    }

}
