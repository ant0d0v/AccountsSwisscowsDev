package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;
import pages.sidebar_menu.ProfilePage;
import utils.EmailUtils;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ConfirmPage extends FooterMenuPage<ConfirmPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class = 'btn-submit'][text()='Confirm']")
    private WebElement submitButtonInThePopup;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(id = "user_password")
    private WebElement userPassword;
    @FindBy(xpath = "//a[@href='/users/sign_up']")
    private WebElement createAccountLink;
    @FindBy(xpath = "//a[@href='#']")
    private WebElement clickHereToRecoverLink;
    @FindBy(xpath = "//h3")
    private WebElement h3Header;
    @FindBy(xpath = "//div[@id='desktop-menu']//li[@class='user-li']/a")
    private WebElement signInTopMenu;
    @FindBy(xpath = "//div//p")
    private WebElement descriptionConfirmPage;
    @FindBy(xpath = "//img[@src='/images/verification-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//button[@class='link']")
    private WebElement linkIdidntGetCode;
    @FindBy(xpath = "//div[@class='content-box loading']")
    private WebElement preloader;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmPage createGeneric() {

        return new ConfirmPage(getDriver());
    }
    @Step("Enter code")
    public ConfirmPage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }
    @Step("Click Submit button")
    public WelcomePage clickSubmitButton() {
        click(submitButton);

        return new WelcomePage(getDriver());
    }
    public ProfilePage clickSubmitButtonInThePopup() {
        click(submitButtonInThePopup);

        return new ProfilePage(getDriver());
    }

    public String getDescriptionConfirmPage() {
        return getText(descriptionConfirmPage);
    }
    @Step("Wait until to be visible main image om the /confirm page")
    public ConfirmPage waitUntilMainImageToBeVisibly() {
        wait10ElementToBeVisible(mainImage);
        return this;
    }
    public boolean imageIsDisplayedConfirmPage() {

        return isElementDisplayed(mainImage);
    }
    @Step("Click link 'I didn't get the code'")
    public ConfirmPage clickLinkLinkIdidntGetCode() throws InterruptedException {
        click20(linkIdidntGetCode);
        wait10ElementToBeVisible(preloader);
        return new  ConfirmPage (getDriver());
    }
}