package pages.accounts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;
import utils.ProjectConstants;

import java.util.List;

public class ProfilePage extends SidebarMenuPage<ProfilePage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;

    @FindBy(id = "user-dropdown")
    WebElement userTopMenu;

    @FindBy(xpath = "//ul[@id='user-dropdown-menu']/li")
    List<WebElement> userDropdownMenuLinks;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement profileIcon;

    @FindBy(xpath = "//ul[@id='myTab']//a[@href='/api_keys']")
    private WebElement apiKeysTab;

    @FindBy(xpath = "//h2")
    private List<WebElement> h2Headers;

    @FindBy(xpath = "//div[@class='dropdown']//ul[@class='suggestions fade-in']//li")
    private List<WebElement> listLanguagesProfile;

    @FindBy(xpath = "//ul[@class='nav nav-tabs pull-left']//a")
    private List<WebElement> navTabs;
    @FindBy(xpath = "//button[text()='Change password']")
    private WebElement buttonСhangePassword;
    @FindBy(xpath = "//div[@class='field additional-email']//*[name() = 'svg']")
    private WebElement buttonСhangeAlternateEmail;
    @FindBy(xpath = "//div[@class='field nickname']//*[name() = 'svg']")
    private WebElement buttonСhangeNickname;
    @FindBy(xpath = "//div[@class='field language']//*[name() = 'svg']")
    private WebElement buttonСhangeLocalisation;
    @FindBy(xpath = "//div[@class='field phone']//*[name() = 'svg']")
    private WebElement buttonСhangePhone;
    @FindBy(xpath = "//input[@name ='oldPassword']")
    private WebElement inputOldPassword;
    @FindBy(xpath = "//input[@name ='password']")
    private WebElement inputNewPassword;
    @FindBy(xpath = "//input[@name ='confirmPassword']")
    private WebElement inputConfirmNewPassword;
    @FindBy(xpath = "//input[@name='alternateEmail']")
    private WebElement inputAlternateEmail;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//input[@id ='nickname']")
    private WebElement inputNickname;
    @FindBy(xpath = "//button[@type ='submit']")
    private WebElement confirmButton;
    @FindBy(xpath = "//div[@class='field additional-email']//input")
    private WebElement attributeAlternateEmail;
    @FindBy(xpath = "//div[@class='field phone']//input")
    private WebElement attributePhoneNumber;
    @FindBy(xpath = "//input[@id ='nickname']")
    private WebElement attributeNickname;
    @FindBy(xpath = "//button[@name ='submitBtn']")
    private WebElement buttonSaveChanges;




    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage createGeneric() {

        return new ProfilePage(getDriver());
    }

    public String getNotification() {

        return getText(notification);
    }

    public List<String> getUserNameDropdownMenuTexts() {

        return getTexts(userDropdownMenuLinks);
    }

    public List<String> getListH2Headers() {

        return getTexts(h2Headers);
    }

    public String getUserMenuText() {

        return getText(userTopMenu);
    }

    public ProfilePage clickButtonСhangePassword() {
        click(buttonСhangePassword);

        return this;
    }
    public ProfilePage clickButtonChangeAlternateEmail() {
        click20(buttonСhangeAlternateEmail);

        return this;
    }
    public ProfilePage clickButtonChangeNickname() {
        click20(buttonСhangeNickname);

        return this;
    }
    public ProfilePage clickButtonChangeLocalisation() {
        click20(buttonСhangeLocalisation);

        return this;
    }
    public ProfilePage clickButtonСhangePhoneNumber() {
        click20(buttonСhangePhone);

        return this;
    }
    public ProfilePage enterCurrentPassword(String email) {
        click(inputOldPassword);
        input(email, inputOldPassword);
        return this;
    }
    public ProfilePage enterAlternateEmail(String email) {
        click(inputAlternateEmail);
        input(email, inputAlternateEmail);
        return this;
    }
    public ProfilePage enterPhoneNumber(String phone) {
        click(inputPhoneNumber);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", inputPhoneNumber);
        input(phone, inputPhoneNumber);

        return this;
    }
    public ProfilePage enterNickname(String Nickname) {
        click(inputNickname);
        input(Nickname, inputNickname);

        return this;
    }
    public ProfilePage enterNewPassword(String email) {
        click(inputNewPassword);
        input(email, inputNewPassword);
        return this;
    }
    public ProfilePage enterRepeatNewPassword(String email) {
        click(inputConfirmNewPassword);
        input(email, inputConfirmNewPassword);
        return this;
    }
    public ProfilePage enterNewUserCredentials(){
        enterCurrentPassword(ProjectConstants.NEW_PASSWORD);
        enterNewPassword(ProjectConstants.PASSWORD);
        enterRepeatNewPassword(ProjectConstants.PASSWORD);
        return new ProfilePage(getDriver());
    }
    public LoginPage clickConfirmButton() {
        click(confirmButton);

        return new LoginPage(getDriver());
    }
    public ProfilePage clickButtonSaveChanges() {
        click(buttonSaveChanges);

        return new ProfilePage(getDriver());
    }
    public ConfirmPage clickConfirmButton_ConfirmPage() {
        click20(confirmButton);

        return new ConfirmPage(getDriver());
    }
    public String getValueAlternateEmail(){
        return getAttribute(attributeAlternateEmail,"value");
    }
    public String getValuePhoneNumber(){
        return getAttribute(attributePhoneNumber,"value");
    }
    public String getValueNickname(){
        return getAttribute(attributeNickname,"value");
    }

    public void clickLangInDropdownOfLanguages(int index) throws InterruptedException {
        clickButtonChangeLocalisation();
        click20(getListLanguagesFooterMenu().get(index));
        clickButtonSaveChanges();
        refreshPage();
    }
    public List<WebElement> getListLanguagesFooterMenu() {

        return listLanguagesProfile;
    }

    public void waitUntilButtonIsClickable(WebElement button) {

        wait10ElementToBeClickable(button);
    }
}
