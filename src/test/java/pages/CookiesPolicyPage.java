package pages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class CookiesPolicyPage extends FooterMenuPage<CookiesPolicyPage> {
    @FindBy(xpath = "(//div[@class='row narrow static-content']//a)[position() < 5]")
    private List<WebElement> allLinksOnPage;

    public CookiesPolicyPage(WebDriver driver) {
        super(driver);
    }

    public CookiesPolicyPage createGeneric() {

        return new CookiesPolicyPage(getDriver());
    }

    public List<WebElement> getAllLinksOnPage() {

        return allLinksOnPage;
    }
    @Step("Click all links on the page")
    public void clickAllLinks(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    @Step("Close /register page")
    public CookiesPolicyPage closeRegisterPage() {
        getDriver().close();
        return this;

    }
    @Step("Switch to /cookies page")
    public  CookiesPolicyPage switchToCookiesPolicyPage() {
        for (String windowHandle : getDriver().getWindowHandles()) {
            if (getDriver().getWindowHandles().size() == 1) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }

}