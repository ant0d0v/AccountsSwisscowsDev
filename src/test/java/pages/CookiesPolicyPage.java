package pages;

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
    public void clickAllLinks(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    public CookiesPolicyPage closeRegisterPage() {
        getDriver().close();
        return this;

    }
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