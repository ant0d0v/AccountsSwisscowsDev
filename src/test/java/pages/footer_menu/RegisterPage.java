package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CookiesPolicyPage;
import pages.GtcPage;
import pages.base_abstract.FooterMenuPage;
import utils.ProjectConstants;
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
    @FindBy(xpath = "//img[@src='/images/form-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//a[@href='https://swisscows.com/cookies']")
    private WebElement linkCookiesPolicy;
    @FindBy(xpath = "//a[@href='https://swisscows.com/gtc']")
    private WebElement linkGtc;
    @FindBy(xpath = "//h1")
    private WebElement h1Text;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage createGeneric() {

        return new RegisterPage(getDriver());
    }

    @Step("Enter username")
    public RegisterPage enterNewUserEmail(String email) {
        click(usernameField);
        input(email, usernameField);
        return this;
    }
    @Step("Enter user credentials using invalid email")
    public RegisterPage enterInvalidEmail(String email) {
        click(usernameField);
        input(email, usernameField);
        return this;
    }
    @Step("Enter password")
    public RegisterPage enterNewUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);
        return this;

    }
    @Step("Enter user credentials using invalid password")
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
    @Step("Click agree with Cookies ")
    public RegisterPage clickAgreeWithCookies() {
        clickByJavaScript(checkboxCookies);

        return this;
    }
    @Step("Click agree with policy")
    public RegisterPage clickAgreeWithPolicy() {
        clickByJavaScript(checkboxPolicy);

        return this;
    }
    @Step("Click Register button")
    public ConfirmPage clickRegisterButton() {
        click(submitButton);

        return new  ConfirmPage(getDriver());
    }
    @Step("After click Register button redirect to /recovery options page")
    public RecoveryPage clickRegisterButtonForSwisscowsUser() {
        click(submitButton);

        return new  RecoveryPage (getDriver());
    }
    @Step("After click Register button redirect to /verify page")
    public VerifyPage clickRegisterButtonForBots() {
        click(submitButton);

        return new  VerifyPage(getDriver());
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
    @Step("Click all of checkboxes")
    public void clickLinksInCheckbox(int index) {
        click(getLinksCheckboxRegisterPage().get(index));
        switchToAnotherWindow();

    }
    @Step("Click link Cookies")
    public CookiesPolicyPage clickCookiesPolicy() {
        click20(linkCookiesPolicy);
        return new  CookiesPolicyPage(getDriver());
    }
    @Step("Click link GTC")
    public GtcPage clickGtcPage() {
        click20(linkGtc);
        return new  GtcPage(getDriver());
    }
    @Step("Click all checkboxes on the /register page")
    public RegisterPage clickAllCheckboxesRegisterPage() {
        clickAllElementsInList(checkboxesRegisterPage);
        return this;
    }

    public RegisterPage enterUserCredentialsGmail() {
        enterNewUserEmail(ProjectConstants.GMAIL_USER);
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterRandomCredentialsGmail() {
        enterNewUserEmail("test123@gmail.com");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterNewExternalUserCredentials() {
        enterNewUserEmail("a.udovychenko1203@gmail.com");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterIncorrectRepeatPassword() {
        enterNewUserEmail(TestUtils.getRandomName());
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword("Tester12#12");

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterUserCredentialsForSwisscowsUser() {
        enterNewUserEmail(TestUtils.getRandomName());
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUserCredentialsSwisscowsEmail() {
        enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER);
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterUserCredentialsForBots() {
        enterNewUserEmail(TestUtils.getRandomNameForBot());
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterUserCredentialsForGmailUser() {
        enterNewUserEmail(TestUtils.getRandomName()+ "@gmail.com");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }
    public RegisterPage waitToBeChangeH1text(String text){
        getWait10().until(ExpectedConditions.textToBePresentInElement(h1Text, text));
        return new RegisterPage(getDriver());
    }
    public RegisterPage enterUnconfirmedAccountSwisscowsUser() {
        enterNewUserEmail("tester@swisscows.email");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

        return new RegisterPage(getDriver());
    }

    public RegisterPage enterEmailAlreadyBeenRegistered() {
        enterNewUserEmail("a.qa@swisscows.email");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        enterRepeatPassword(ProjectConstants.PASSWORD);

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
    @Step("Get validation error message")
    public String getValidationMessageErrorOfCheckbox() {

       return getText(validationErrorMessageCheckbox);
    }
    @Step("Wait until to be visible main image on the page /register")
    public RegisterPage waitMainImageToBeVisible_RegisterPage(){
        waitForUrlContains(ProjectConstants.URL_REGISTER_PAGE);
        wait10ElementToBeVisible(mainImage);

        return new RegisterPage(getDriver());
    }
    public boolean mainImageIsDisplayed() {

        return isElementDisplayed(mainImage);
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