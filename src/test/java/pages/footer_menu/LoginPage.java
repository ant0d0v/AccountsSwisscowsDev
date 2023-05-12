package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.base_abstract.FooterMenuPage;
import pages.sidebar_menu.DashboardPage;
import pages.sidebar_menu.ProfilePage;
import utils.ProjectConstants;

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
    @FindBy(xpath = "//img[@src='skins/elastic/images/logo.svg?s=1658607434']")
    private WebElement swisscowsEmailBoxLogo;
    @FindBy(xpath = "//div[@class='warning content ui alert alert-warning']//span")
    private WebElement warningMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage createGeneric() {

        return new LoginPage(getDriver());
    }
    @Step("Click link Forgot password ")
    public ForgotPage clickLinkForgotPassword() {
        click(linkForgotPassword);

        return new  ForgotPage(getDriver());
    }
    @Step("Get text validation message")
    public String getTextValidationErrorMessage() {

        return getText(textValidationErrorMessage);
    }
    @Step("Wait util to be visible Main image on the /login page" )
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
    @Step("Wait until to be visible Swisscows logo")
    public LoginPage waitUtilToBeVisibleSwisscowsLogo() {
        wait10ElementToBeVisible(swisscowsLogo);
        return this;
    }
    @Step("Wait until to be visible Swisscows email box logo")
    public LoginPage waitUtilToBeVisibleSwisscowsEmailBoxLogo() {
        wait10ElementToBeVisible(swisscowsEmailBoxLogo);
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
        input(ProjectConstants.PASSWORD, userPassword);

        return this;
    }
    @Step("Click Login button")
    public LoginPage clickLoginButton() {

        click(submitButton);
        return this;
    }
    @Step("After Click Login button redirect to /recovery page")
    public RecoveryPage clickLoginButton_RecoveryPage() {

        click(submitButton);
        return new RecoveryPage(getDriver());
    }
    @Step("Click login button")
    public ConfirmPage clickLoginButton_ConfirmPage() {

        click(submitButton);
        return new ConfirmPage(getDriver());
    }
    @Step("Open Swisscows email form")
    public LoginPage openSwisscowsEmailForm() {

        getDriver().get("https://dev.swisscows.email/mbox/index.php/login/oauth");
        return this;
    }
    @Step("Get text validation message")
    public List<String> getListValidationErrorMessage() {

        return getTexts(listValidationErrorMessage);
    }
    @Step("Click login button ")
    public DashboardPage clickLoginButton_Dashboard() {

        click(submitButton);
        return new DashboardPage(getDriver());
    }
    @Step("After Click Login button redirect to /blocked page")
    public BlockedPage clickLoginButton_Blocked() {

        click(submitButton);
        return new BlockedPage(getDriver());
    }
    @Step("Get text warning message in the email box")
    public String getTextWarningMessage() {

        return getText(warningMessage);
    }
    @Step("Enter user email ")
    public LoginPage enterNewUserEmail(String email) {
        click(usernameField);
        input(email, usernameField);
        return this;

    }
    @Step("Enter user password ")
    public LoginPage enterNewUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);
        return this;
    }
    public LoginPage enterUserCredentials() {
        enterNewUserEmail(ProjectConstants.GMAIL_USER);
        enterNewUserPassword(ProjectConstants.PASSWORD);
        return new LoginPage(getDriver());
    }
    public LoginPage enterInvalidUserCredentials() {
        enterNewUserEmail(ProjectConstants.GMAIL_USER);
        enterNewUserPassword("Tester12#12");
        return new LoginPage(getDriver());
    }
    public LoginPage enterUserCredentialsUnconfirmedAccountSwisscowsUser() {
        enterNewUserEmail(ProjectConstants.NEW_SWISSCOWS_EMAIL_USER);
        enterNewUserPassword(ProjectConstants.PASSWORD);
        return new LoginPage(getDriver());
    }
    public LoginPage enterUserCredentialsUnconfirmedAccountExternalUser() {
        enterNewUserEmail("test123@gmail.com");
        enterNewUserPassword(ProjectConstants.PASSWORD);
        return new LoginPage(getDriver());
    }

    public void signInAsRegularUser() {
        clickClearInputRegularUserEmail();
        clickClearInputRegularUserPassword();
        clickLoginButton_Dashboard();

        new ProfilePage(getDriver());
    }
    @Step("Open swisscows site in the new tab")
    public MainPage openSwisscowsSiteInNewTabAndSwitch() {
        JavascriptExecutor jse = (JavascriptExecutor)getDriver();
        jse.executeScript("window.open('https://dev.swisscows.com/en', '_blank');");
        switchToAnotherWindow();
        return new MainPage(getDriver());
    }


}
