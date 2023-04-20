package pages.accounts;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;
import utils.ProjectConstants;

import java.io.File;
import java.util.List;

import static java.lang.Thread.sleep;

public class ProfilePage extends SidebarMenuPage<ProfilePage> {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;

    @FindBy(id = "user-dropdown")
    WebElement userTopMenu;

    @FindBy(xpath = "//ul[@id='user-dropdown-menu']/li")
    List<WebElement> userDropdownMenuLinks;

    @FindBy(xpath = "//h2")
    private List<WebElement> h2Headers;

    @FindBy(xpath = "//div[@class='dropdown']//ul[@class='suggestions fade-in']//li")
    private List<WebElement> listLanguagesProfile;

    @FindBy(xpath = "//ul[@class='nav nav-tabs pull-left']//a")
    private List<WebElement> navTabs;
    @FindBy(xpath = "//button[text()='Change password']")
    private WebElement buttonChangePassword;
    @FindBy(xpath = "//div[@class='field additional-email']//*[name() = 'svg']")
    private WebElement buttonChangeAlternateEmail;
    @FindBy(xpath = "//div[@class='field nickname']//*[name() = 'svg']")
    private WebElement buttonChangeNickname;
    @FindBy(xpath = "//div[@class='field language']//*[name() = 'svg']")
    private WebElement buttonChangeLocalisation;
    @FindBy(xpath = "//div[@class='field phone']//*[name() = 'svg']")
    private WebElement buttonChangePhone;
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
    @FindBy(xpath = "//div[@class='field region']//button//*[name() = 'svg']")
    private WebElement dropdownRegion;
    @FindBy(xpath = "//div[@class='field image']//div[@class='avatar']")
    private WebElement avatar;
    @FindBy(xpath = "//div[@class='field image']//img[@class = 'photo']")
    private WebElement imageInAvatar;
    @FindBy(xpath = "//label[@class='btn-submit']//input")
    private WebElement changeImageButton;
    @FindBy(xpath = "//p[@class='error-message']")
    private WebElement validationTextOfAvatar;
    @FindBy(xpath = "//ul[@class='suggestions fade-in']//li[37]")
    private WebElement switzerlandRegion;
    @FindBy(xpath = "//ul[@class='suggestions fade-in']//li")
    private List<WebElement> listOfRegion;
    @FindBy(xpath = "//div[@class='field region']//button")
    private WebElement regionValue;
    @FindBy(xpath = "//input[@class = 'search']")
    private WebElement searchInDropdown;
    @FindBy(xpath = "//div[@class='change-form change-avatar']//button")
    private WebElement deleteButtonInPopupAvatar;
    @FindBy(xpath = "//img[@src='/images/login-illustration.svg']")
    private WebElement imageOfPopupPhoneNumber;
    @FindBy(xpath = "//img[@src='/images/change-password-illustration.svg']")
    private WebElement imageOfPopupChangePassword;





    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage createGeneric() {

        return new ProfilePage(getDriver());
    }

    public String getRegionValue() {
        refreshPage();
        return getText(regionValue);
    }

    public List<String> getUserNameDropdownMenuTexts() {

        return getTexts(userDropdownMenuLinks);
    }

    public List<String> getListOfRegion() {

        return getTexts(listOfRegion);
    }

    public String getValidationText() {

        return getText(validationTextOfAvatar);
    }

    public ProfilePage clickButtonChangePassword() {
        click(buttonChangePassword);

        return this;
    }
    public ProfilePage clickButtonChangeAlternateEmail() {
        click20(buttonChangeAlternateEmail);

        return this;
    }
    public ProfilePage clickButtonChangeNickname() {
        click20(buttonChangeNickname);

        return this;
    }
    public void clickButtonChangeLocalisation() {
        click20(buttonChangeLocalisation);

    }
    public ProfilePage clickButtonChangePhoneNumber() {
        click20(buttonChangePhone);

        return new ProfilePage(getDriver());
    }

    public ProfilePage enterCurrentPassword(String email) {
        click(inputOldPassword);
        input(email, inputOldPassword);
        return this;
    }
    public ProfilePage enterAlternateEmail(String email) {
        click(inputAlternateEmail);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", inputAlternateEmail);
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
    public  ProfilePage enterSearchCriteriaInDropdownRegion() {
        input("United", searchInDropdown);
        return new  ProfilePage(getDriver());
    }
    public ProfilePage enterNewPassword(String email) {
        click(inputNewPassword);
        input(email, inputNewPassword);
        return  this;
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
    public ProfilePage clickDropdownRegion() {
        click(dropdownRegion);

        return new ProfilePage(getDriver());
    }
    public ProfilePage selectSwitzerlandRegion() {
        click(switzerlandRegion);

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
        sleep(1000);
    }
    public List<WebElement> getListLanguagesFooterMenu() {

        return listLanguagesProfile;
    }

    public ProfilePage waitUntilImageToBeChanged() {

        wait10ElementToBeVisible(imageInAvatar);
        return this;
    }
    public ProfilePage waitMainImageToBeVisibleOfRPopupPhoneOrEmail() {

        wait10ElementToBeVisible(imageOfPopupPhoneNumber);
        return this;
    }
    public ProfilePage waitMainImageToBeVisibleOfRPopupChangePassword() {

        wait10ElementToBeVisible(imageOfPopupChangePassword);
        return this;
    }
    public boolean mainImageOfRPopupPhoneOrEmailIsDysplaed(){
        return isElementDisplayed(imageOfPopupPhoneNumber);
    }
    public boolean mainImageOfRPopupChangePasswordIsDysplaed(){
        return isElementDisplayed(imageOfPopupChangePassword);
    }
    public boolean avatarIsDysplaed(){
        return isElementDisplayed(imageInAvatar);
    }
    public boolean isImagePresent() {
        try {
            getDriver().findElement(By.xpath("//div[@class='field image']//img[@class = 'photo']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public ProfilePage changeAvatar(String picturePath) {
        clickAvatar();
        File picture = new File(picturePath);
        changeImageButton.sendKeys(picture.getAbsolutePath());
        return this;
    }
    public ProfilePage clickAvatar(){
        click(avatar);
        return this;
    }
    public ProfilePage clickDeleteButtonInPopupAvatar(){
        click(deleteButtonInPopupAvatar);
        return this;
    }
}
