package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import javax.mail.MessagingException;
import java.io.IOException;

public class ConfirmPage extends FooterMenuPage<ConfirmPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
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

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmPage createGeneric() {

        return new ConfirmPage(getDriver());
    }
    public ConfirmPage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }

    public WelcomePage clickSubmitButton() {
        click(submitButton);

        return new WelcomePage(getDriver());
    }
    public String getConfirmCodeFromGmailBox () throws MessagingException, IOException, InterruptedException {
        return  getCodeFromGmailBox();
    }
}