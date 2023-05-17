package pages.sidebar_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import pages.footer_menu.ConfirmPage;
import pages.footer_menu.LoginPage;
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
    @FindBy(xpath = "//div[@class = 'section account']//button")
    private WebElement deleteButton;
    @FindBy(xpath = "//div[@class='content-box']//button[@class = 'btn-submit']")
    private WebElement deleteButtonInPopup;
    @FindBy(xpath = "//div[@class='field image']//img[@class = 'photo']")
    private WebElement imageInAvatar;
    @FindBy(xpath = "//label[@class='btn-submit']//input")
    private WebElement changeImageButton;
    @FindBy(xpath = "//p[@class='error-message']")
    private WebElement validationTextOfAvatar;
    @FindBy(xpath = "//ul[@class='suggestions fade-in']//li[text()='Switzerland (DE)']")
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
    @FindBy(xpath = "//div[@class = 'modal delete-account']//img[@src ='/images/delete-account-illustration.svg']")
    private WebElement imageOfDeletePopup;
    @FindBy(xpath = "//div[@class='content-box']//p")
    private List<WebElement> descriptionTextOfDeletePopup;





    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage createGeneric() {

        return new ProfilePage(getDriver());
    }
    @Step("Get value og Region")
    public String getRegionValue() {
        return getText(regionValue);
    }
    @Step("Refresh page")
    public ProfilePage refreshProfilePage(){
        refreshPage();
        return new ProfilePage(getDriver());
    }

    public List<String> getUserNameDropdownMenuTexts() {

        return getTexts(userDropdownMenuLinks);
    }
    @Step("Get all list in the dropdown Region")
    public List<String> getListOfRegion() {

        return getTexts(listOfRegion);
    }
    @Step("Get validation text")
    public String getValidationText() {

        return getText(validationTextOfAvatar);
    }
    @Step("Click icon change password ")
    public ProfilePage clickButtonChangePassword() {
        click(buttonChangePassword);

        return this;
    }
    @Step("Click icon change alternate email ")
    public ProfilePage clickButtonChangeAlternateEmail() {
        click20(buttonChangeAlternateEmail);

        return this;
    }
    @Step("Click icon change nickname ")
    public ProfilePage clickButtonChangeNickname() {
        click20(buttonChangeNickname);

        return this;
    }
    @Step("Click icon change localization ")
    public void clickButtonChangeLocalisation() {
        click20(buttonChangeLocalisation);

    }
    @Step("Click icon change phone number ")
    public ProfilePage clickButtonChangePhoneNumber() {
        click20(buttonChangePhone);

        return new ProfilePage(getDriver());
    }
    @Step("Enter current password ")
    public ProfilePage enterCurrentPassword(String email) {
        click(inputOldPassword);
        input(email, inputOldPassword);
        return this;
    }
    @Step("Enter alternate email in the popup ")
    public ProfilePage enterAlternateEmail(String email) {
        click(inputAlternateEmail);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", inputAlternateEmail);
        input(email, inputAlternateEmail);
        return this;
    }
    @Step("Enter phone number in the popup ")
    public ProfilePage enterPhoneNumber(String phone) {
        click(inputPhoneNumber);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", inputPhoneNumber);
        input(phone, inputPhoneNumber);

        return this;
    }
    @Step("Enter nickname")
    public ProfilePage enterNickname(String Nickname) {
        click(inputNickname);
        input(Nickname, inputNickname);

        return this;
    }
    @Step("Enter search criteria ")
    public  ProfilePage enterSearchCriteriaInDropdownRegion() {
        input("United", searchInDropdown);
        return new  ProfilePage(getDriver());
    }
    @Step("Enter new password")
    public ProfilePage enterNewPassword(String email) {
        click(inputNewPassword);
        input(email, inputNewPassword);
        return  this;
    }
    @Step("Enter repeat new password ")
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
    @Step("Click Confirm button")
    public LoginPage clickConfirmButton() {
        click(confirmButton);

        return new LoginPage(getDriver());
    }
    @Step("Click save changes button ")
    public ProfilePage clickButtonSaveChanges() {
        click(buttonSaveChanges);

        return new ProfilePage(getDriver());
    }
    @Step("Click dropdown region ")
    public ProfilePage clickDropdownRegion() {
        click(dropdownRegion);

        return new ProfilePage(getDriver());
    }
    @Step("Select region in the list")
    public ProfilePage selectSwitzerlandRegion() {
        click(switzerlandRegion);

        return new ProfilePage(getDriver());
    }
    @Step("After Click confirm button  opened popup ")
    public ConfirmPage clickConfirmButton_ConfirmPage() {
        click20(confirmButton);

        return new ConfirmPage(getDriver());
    }
    @Step("Get value input email ")
    public String getValueAlternateEmail(){
        return getAttribute(attributeAlternateEmail,"value");
    }
    @Step("Get value input phone ")
    public String getValuePhoneNumber(){
        return getAttribute(attributePhoneNumber,"value");
    }
    @Step("Get value input nickname")
    public String getValueNickname(){
        return getAttribute(attributeNickname,"value");
    }
    @Step("Get description text of delete Popup")
    public List<String> getDescriptionTextOfDeletePopup(){
        return getTexts(descriptionTextOfDeletePopup);
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
    @Step("Wait until to be changed image")
    public ProfilePage waitUntilImageToBeChanged() {

        wait10ElementToBeVisible(imageInAvatar);
        return this;
    }
    @Step("Wait to be visible image in Delete popup")
    public void waitVisibleImageInDeleteAccountPopup() {
        wait10ElementToBeVisible(imageOfDeletePopup);
    }
    @Step("Wait until to be visible main image in the Phone number popup")
    public void waitMainImageToBeVisibleOfRPopupPhoneOrEmail() {
        wait10ElementToBeVisible(imageOfPopupPhoneNumber);
    }
    @Step("Wait until to be visible main image in the change password popup")
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
    public boolean mainImageOfDeleteAccountPopup(){

        return isElementDisplayed(imageOfDeletePopup);
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
    @Step("Click avatar icon")
    public ProfilePage clickAvatar(){
        click(avatar);
        return this;
    }
    @Step("Click delete button")
    public ProfilePage clickDeleteButton(){
        click(deleteButton);
        return this;
    }
    @Step("Click delete button  in Popup")
    public LoginPage clickDeleteButtonInPopup(){
        click(deleteButtonInPopup);
        return new LoginPage(getDriver());
    }
    @Step("Click delete button in the popup Avatar ")
    public ProfilePage clickDeleteButtonInPopupAvatar(){
        click(deleteButtonInPopupAvatar);
        return this;
    }
}
