package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class LoginPage extends FooterMenuPage<LoginPage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;
    @FindBy(xpath = "//input[@class='input email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordField;
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
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
    @FindBy(xpath = "//div[@class = 'error-message']")
    private List<WebElement> listValidationErrorMessage;
    @FindBy(xpath = "//div[@class ='error-message lg']//p")
    private WebElement textValidationErrorMessage;
    @FindBy(xpath = "//button[@class ='link']")
    private WebElement linkForgotPassword;
    @FindBy(xpath = "//img[@src ='/images/login-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//img[@src ='./images/logo-big.svg']")
    private WebElement accountLogo;
    @FindBy(xpath = "//img[@src ='./images/swisscows-logo.svg']")
    private WebElement swisscowsLogo;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage createGeneric() {

        return new LoginPage(getDriver());
    }
    public ForgotPage clickLinkForgotPassword() {
        click(linkForgotPassword);

        return new  ForgotPage(getDriver());
    }

    public String getTextValidationErrorMessage() {

        return getText(textValidationErrorMessage);
    }

    public LoginPage waitMainImageToBeVisible_LoginPage() {
          wait10ElementToBeVisible(mainImage);
         return this;
    }
    public boolean mainImageIsDisplayed() {

        return isElementDisplayed(mainImage);
    }
    public boolean accountLogoIsDisplayed() {

        return isElementDisplayed(accountLogo);
    }
    public boolean swisscowsLogoIsDisplayed() {

        return isElementDisplayed(swisscowsLogo);
    }
    public LoginPage waitUtilToBeVisibleSwisscowsLogo() {
        wait10ElementToBeVisible(swisscowsLogo);
        return this;
    }

    public LoginPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public LoginPage clickClearInputRegularUserPassword() {
        click(userPassword);
        userPassword.clear();
        String password = "Tester12#";
        input(password, userPassword);

        return this;
    }

    public LoginPage clickLoginButton() {

        click(submitButton);
        return this;
    }
    public RecoveryPage clickLoginButton_RecoveryPage() {

        click(submitButton);
        return new RecoveryPage(getDriver());
    }
    public List<String> getListValidationErrorMessage() {

        return getTexts(listValidationErrorMessage);
    }
    public DashboardPage clickLoginButton_Dashboard() {

        click(submitButton);
        return new DashboardPage(getDriver());
    }
    public LoginPage enterNewUserEmail(String email) {
        click(usernameField);
        input(email, usernameField);
        return this;

    }

    public LoginPage enterNewUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);
        return this;
    }
    public LoginPage enterUserCredentials() {
        enterNewUserEmail("qaengineer1203@gmail.com");
        enterNewUserPassword("Tester12#");
        return new LoginPage(getDriver());
    }
    public LoginPage enterInvalidUserCredentials() {
        enterNewUserEmail("qaengineer1203@gmail.com");
        enterNewUserPassword("Tester12#12");
        return new LoginPage(getDriver());
    }
    public LoginPage enterUserCredentialsUnconfirmedAccountSwisscowsUser() {
        enterNewUserEmail("tester@swisscows.email");
        enterNewUserPassword("Tester12#");
        return new LoginPage(getDriver());
    }

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickLoginButton_Dashboard();

        new ProfilePage (getDriver());
    }


}
