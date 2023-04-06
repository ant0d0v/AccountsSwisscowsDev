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

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage createGeneric() {

        return new LoginPage(getDriver());
    }
    public ConfirmPage clickRegisterButton() {
        click(submitButton);

        return new  ConfirmPage(getDriver());
    }

    public String getTextValidationErrorMessage() {

        return getText(textValidationErrorMessage);
    }

    public String getWelcomeMessage() {

        return getText(h3Header);
    }

    public String getSignInText() {

        return getText(signInTopMenu);
    }

    public LoginPage clickClearInputRegularUserEmail() {
        click(userEmail);
        userEmail.clear();
        String email = "jka59433@xcoxc.com";
        input(email, userEmail);

        return this;
    }

    public LoginPage clickClearInputRegularUserEmail(String email) {
        click(userEmail);
        userEmail.clear();
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

    public LoginPage clickClearInputRegularUserPassword(String password) {
        click(userPassword);
        userPassword.clear();
        input(password, userPassword);

        return this;
    }

    public LoginPage clickLoginButton() {

        click(submitButton);
        return this;
    }
    public List<String> getListValidationErrorMessage() {

        return getTexts(listValidationErrorMessage);
    }
    public DashboardPage clickLoginButton_Dashboard() {

        click(submitButton);
        return new DashboardPage(getDriver());
    }
    public void enterNewUserEmail(String email) {
        click(usernameField);
        input(email, usernameField);

    }
    public void enterNewUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);

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

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickLoginButton_Dashboard();

        new ProfilePage (getDriver());
    }


}
