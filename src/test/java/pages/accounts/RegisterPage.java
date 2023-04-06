package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import utils.TestUtils;

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

    @FindBy(xpath = "//div[@class='checkbox-field'][2]//input")
    private WebElement checkboxCookies;
    @FindBy(xpath = "//div[@class='checkbox-field'][1]//input")
    private WebElement checkboxPolicy;

    @FindBy(xpath = "//div[@id='switch-toggle']")
    private WebElement toggleExtension;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameFieldVpnExtension;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordFieldVpnExtension;
    @FindBy(xpath = "//button[@id = 'btn-submit']")
    private WebElement singInButton;
    @FindBy(xpath = "//div[@class= 'checkboxes']//a")
    private List<WebElement> linksCheckboxRegisterPage;
    @FindBy(xpath = "//span[@class='error-message-agreed-policy']")
    private WebElement validationErrorMessageCheckbox;


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
    public RegisterPage enterInvalidEmail(String email) {
        click(usernameField);
        input(email, usernameField);
        return this;
    }

    public void enterNewUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);

    }
    public RegisterPage enterInvalidPassword() {
        String password = "Tester";

        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);
        return  this;

    }

    public void enterRepeatPassword( String password) {
        click(repeatUserPasswordField);
        repeatUserPasswordField.clear();
        input(password, repeatUserPasswordField);

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

    public RegisterPage clickAgreeWithCookies() {
        clickByJavaScript(checkboxCookies);

        return this;
    }
    public RegisterPage clickAgreeWithPolicy() {
        clickByJavaScript(checkboxPolicy);

        return this;
    }

    public ConfirmPage clickRegisterButton() {
        click(submitButton);

        return new  ConfirmPage(getDriver());
    }
    public RecoveryPage clickRegisterButtonForSwisscowsUser() {
        click(submitButton);

        return new  RecoveryPage (getDriver());
    }
    public RegisterPage clickRegisterButton_ValidationError() {
        click(submitButton);

        return new  RegisterPage(getDriver());
    }
    public RegisterPage clickSignInButtonInExtesion() {
        click(singInButton);

        return this;
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
        enterNewUserPassword("Tester12#");
        enterRepeatPassword("Tester12#");

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterIncorrectRepeatPassword() {
        enterNewUserEmail(TestUtils.getRandomName());
        enterNewUserPassword("Tester12#");
        enterRepeatPassword("Tester12#12");

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUserCredentialsForSwisscowsUser() {
        enterNewUserEmail(TestUtils.getRandomName());
        enterNewUserPassword("Tester12#");
        enterRepeatPassword("Tester12#");

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterEmailAlreadyBeenRegistered() {
        enterNewUserEmail("a.qa@swisscows.email");
        enterNewUserPassword("Tester12#");
        enterRepeatPassword("Tester12#");

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUserCredentialsToSwisscowsVpn() {
        clickToggleVpnExtension();
        enterEmailInVINExtension("a.qa@swisscows.email");
        enterPasswordInVINExtension("2075Deltuha");


        return new RegisterPage(getDriver());
    }

    public void clickToggleVpnExtension() {

        click(toggleExtension);
    }
    public String getValidationMessageErrorOfCheckbox() {

       return getText(validationErrorMessageCheckbox);
    }

    public RegisterPage closeWindow() {
        getDriver().close();
        return this;

    }
    public RegisterPage openExtension()  {
        getDriver().get("chrome-extension://binmiejfbfggbjinkbomoilboalimkdh/popup.html");
        return this;
    }

}