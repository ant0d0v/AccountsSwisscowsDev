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
    @FindBy(xpath= "//div[@class= 'plan'][1]//button")
    private WebElement buttonOfMonthlyPlan;
    @FindBy(xpath= "//div[@class= 'plan'][2]//button")
    private WebElement buttonOfAnnualPlan;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath = "//div[@class = 'plan'][2]//span[@class ='label discount']")
    private WebElement labelDiscountOfAnnualPlan;
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
    @Step("Click monthly plan")
    public EmailStandardBuyPlanIdPage clickMonthlyPlanOfEmailStandard() {
        click(buttonOfMonthlyPlan);
        return new EmailStandardBuyPlanIdPage(getDriver());

    }
    @Step("Click Annual plan  ")
    public EmailStandardBuyPlanIdPage clickAnnualPlanOfEmailStandard() {
       click(buttonOfAnnualPlan);
        return new EmailStandardBuyPlanIdPage(getDriver());

    }
    public boolean labelDiscountIsDisplayedOfAnnualPlan(){

        return isElementDisplayed(labelDiscountOfAnnualPlan);
    }

}
