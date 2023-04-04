package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import javax.mail.MessagingException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class RegisterPage extends FooterMenuPage<RegisterPage> {

    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//div[@class='checkboxes']//div//label")
    private List<WebElement> checkboxesRegisterPage;

    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@autocomplete='email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class='input-container'][3]//input")
    private WebElement repeatUserPasswordField;

    @FindBy(xpath = "//input[@id='agreement_is_age_confirmed']")
    private WebElement ageConfirmCheckbox;

    @FindBy(xpath = "//input[@id='agreement_is_accepted']")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//div[@id='switch-toggle']")
    private WebElement toggleExtension;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameFieldVpnExtension;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordFieldVpnExtension;
    @FindBy(xpath = "//button[@id = 'btn-submit']")
    private WebElement singInButton;

    @FindBy(xpath = "//input[@value='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(text(),'Privacy Centre')]/a[.='Privacy Policy']")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//div[@class= 'checkboxes']//a")
    private List<WebElement> linksCheckboxRegisterPage;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage createGeneric() {

        return new RegisterPage(getDriver());
    }


    public void enterNewUserEmail(String email) {
        click(usernameField);
        input(email, usernameField);

    }

    public void enterNewUserPassword() {
        String password = "Tester12#";

        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);

    }

    public void enterRepeatPassword() {
        String password = "Tester12#";
        click(repeatUserPasswordField);
        repeatUserPasswordField.clear();
        input(password, repeatUserPasswordField);

    }
    public RegisterPage enterPhoneNumber() {
        String password = "993484583";

        click(phoneNumberField);
        phoneNumberField.clear();
        input(password, phoneNumberField);

        return this;
    }

    public void enterEmailInVINExtension(String email) {
        click( usernameFieldVpnExtension);
        input(email, usernameFieldVpnExtension);
    }

    public void enterPasswordInVINExtension(String password) {

        click(passwordFieldVpnExtension);
        input(password, passwordFieldVpnExtension);
    }

    public RegisterPage clickAgeConfirmCheckbox() {
        click(ageConfirmCheckbox);

        return this;
    }

    public RegisterPage clickAgreementCheckbox() {
        click(agreementCheckbox);

        return this;
    }

    public RegisterPage clickRegisterButton() {
        click(submitButton);

        return this;
    }
    public RegisterPage clickSubmitButton() {
        click(submitButton);

        return this;
    }
    public RegisterPage clickSignInButtonInExtesion() {
        click(singInButton);

        return this;
    }

    public RegisterPage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }

    public RegisterPage clickCreateAccountButton() {
        click(createAccountButton);

        return new RegisterPage(getDriver());
    }

    public List<WebElement> getLinksCheckboxRegisterPage() {

        return linksCheckboxRegisterPage;
    }

    public void clickLinksInCheckbox(int index) {
        click(getLinksCheckboxRegisterPage().get(index));
        switchToAnotherWindow();

    }
    public RegisterPage clickAllCheckboxesRegisterPage() {
        clickAllElementsInList(checkboxesRegisterPage);
        return this;
    }
    public RegisterPage enterUserCredentials() {
        enterNewUserEmail("qaengineer1203@gmail.com");
        enterNewUserPassword();
        enterRepeatPassword();

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUserCredentialsForSwisscowsUser() {
        enterNewUserEmail("qaengineer1203@gmail.com");
        enterNewUserPassword();
        enterRepeatPassword();

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUserCredentialsToSwisscowsVpn() {
        clickToggleVpnExtension();
        enterEmailInVINExtension("a.qa@swisscows.email");
        enterPasswordInVINExtension("2075Deltuha");


        return new RegisterPage(getDriver());
    }


    public void clickPrivacyPolicy() {

        click20(privacyPolicy);
    }
    public void clickToggleVpnExtension() {

        click(toggleExtension);
    }

    public RegisterPage closeWindow() {
        getDriver().close();
        return this;

    }
    public String getConfirmCodeFromGmailBox () throws MessagingException, IOException, InterruptedException {
      return  getCodeFromGmailBox();
    }
    public RegisterPage openExtension()  {
        ChromeOptions opt = new ChromeOptions();
        opt.addExtensions(new File("/Users/antonudovycenko/IdeaProjects/AccountsSwisscowsDev/target/app.crx"));
        getDriver().get("chrome-extension://daacinoanjcpanjpelldmmompbamjkap/popup.html");

        return this;
    }

}