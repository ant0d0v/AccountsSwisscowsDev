package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class RestorePage extends FooterMenuPage<RestorePage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//button[@class='link']")
    private WebElement linkIdidntGetCode;
    @FindBy(xpath = "//div[@class='content-box loading']")
    private WebElement preloader;
    @FindBy(xpath = "//div//p")
    private List<WebElement> descriptionRestorePage;
    public   RestorePage(WebDriver driver) {
        super(driver);
    }

    public   RestorePage createGeneric() {

        return new   RestorePage(getDriver());
    }
    public RestorePage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }

    public ResetPage clickSubmitButton() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/reset");

        return new ResetPage(getDriver());
    }
    public RestorePage clickSubmitButtonOnRestorePage() {
        click(submitButton);
        return new RestorePage(getDriver());
    }
    public RestorePage clickLinkLinkIdidntGetCode() throws InterruptedException {
        click20(linkIdidntGetCode);
        wait10ElementToBeVisible(preloader);
        return new  RestorePage (getDriver());
    }
    public RestorePage clickLinkIdidntGetCodeUntilVisiblePreloader() {
    int maxAttempts = 5;
    int attempts = 0;
    boolean visible = false;

        while (!visible && attempts < maxAttempts) {
        try {
            click(linkIdidntGetCode);
            wait10ElementToBeVisible(preloader);
            visible = true;
        } catch (Exception e) {
            attempts++;
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
         }
      }
        if (!visible) {
            Reporter.log("Item did not become visible after maximum attempts.");
        }
        return this;
    }
    public List<String> getDescriptionRestorePage() {
        return getTexts(descriptionRestorePage);
    }

}