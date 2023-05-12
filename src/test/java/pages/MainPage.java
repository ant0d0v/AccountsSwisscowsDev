package pages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.List;


public class MainPage extends FooterMenuPage<MainPage> {
    @FindBy(xpath =  "//a[@class = 'userinfo']")
    private WebElement nicknameHamburgerMenu;
    @FindBy(xpath =  "//body")
    private WebElement summaryPage;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage createGeneric() {

        return new MainPage(getDriver());
    }
    public MainPage openVersionTxtPageSwisscows() {
        getDriver().get("https://dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    public MainPage openVersionTxtPageAccount() {
        getDriver().get("https://accounts.dev.swisscows.com/version.txt");
        return new MainPage(getDriver());
    }
    public String getTextInSummaryPage() {

        return getText(summaryPage);
    }
    @Step("Get text of nickname in the hamburger  menu")
    public String getNicknameInHamburgerMenu() {

        return getText(nicknameHamburgerMenu);
    }
    public void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

}
