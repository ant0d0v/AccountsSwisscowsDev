package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;
import utils.EmailUtils;
import utils.ProjectConstants;

import javax.mail.*;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @Step("Enter code")
    public RestorePage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }
    @Step("Click Submit button")
    public ResetPage clickSubmitButton() {
        click(submitButton);
        waitForUrlContains(ProjectConstants.URL_RESET_PAGE);

        return new ResetPage(getDriver());
    }
    @Step("Click Submit button on the /restore page")
    public RestorePage clickSubmitButtonOnRestorePage() {
        click(submitButton);
        return new RestorePage(getDriver());
    }
    @Step("Click link 'I didn't get the code'")
    public RestorePage clickLinkLinkIdidntGetCode() throws InterruptedException {
        click20(linkIdidntGetCode);
        wait10ElementToBeVisible(preloader);
        return new  RestorePage (getDriver());
    }
    @Step("Click link 'I didn't get the code' and wait until to be visible preloader")
    public RestorePage clickLinkIdidntGetCodeUntilVisiblePreloader() {
            click(linkIdidntGetCode);
            wait10ElementToBeVisible(preloader);
        return this;
    }
    @Step("Get description on the /restore page")
    public List<String> getDescriptionRestorePage() {
        return getTexts(descriptionRestorePage);
    }
}