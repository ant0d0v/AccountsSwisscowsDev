package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import utils.ProjectConstants;

import java.util.List;

public class RecoveryPage extends FooterMenuPage<RecoveryPage> {
    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//span[@class='country-flag-box']")
    private WebElement dropdownCountry;
    @FindBy(xpath = "//ul[@class='country-list']//li[5]")
    private WebElement countryInDropDown;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//img[@src='/images/form-illustration.svg']")
    private WebElement imageRecoveryPage;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement inputPhoneNumber;
    @FindBy(xpath = "//*[local-name()='use']")
    private WebElement countryAttribute;
    @FindBy(xpath = "(//span[@class='country-flag-box']//*[local-name()='use'])[position()=1]")
    private WebElement countryAttributeInPopup;
    @FindBy(xpath = "//div[@class='country-box fade-in']//input[@class= 'search']")
    private WebElement searchInDropdown;

    @FindBy(xpath = "//ul[@class= 'country-list']//li")
    private List<WebElement> listCountryDropDown;
    @FindBy(xpath = "//div[@class='error-message']")
    private WebElement validationErrorMessage;
    public RecoveryPage(WebDriver driver) {
        super(driver);
    }

    public RecoveryPage createGeneric() {

        return new RecoveryPage(getDriver());
    }
    @Step("Enter phone number")
    public RecoveryPage enterPhoneNumber() {
        String password = ProjectConstants.PHONE_NUMBER;

        click(phoneNumberField);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", phoneNumberField);
        input(password, phoneNumberField);

        return this;
    }
    @Step("Enter new phone number")
    public RecoveryPage enterNewPhoneNumber() {
        String password = ProjectConstants.NEW_PHONE_NUMBER;

        click(phoneNumberField);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", phoneNumberField);
        input(password, phoneNumberField);

        return this;
    }
    @Step("Enter invalid Phone number")
    public RecoveryPage enterInvalidPhoneNumber() {
        String password = "993484583da";

        click(phoneNumberField);
        clearJavaScript(phoneNumberField);
        input(password, phoneNumberField);

        return this;
    }
    @Step("Enter already registered phone number ")
    public RecoveryPage enterAlreadyRegisteredPhoneNumber() {
        String password = "+380960507948";

        click(phoneNumberField);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", phoneNumberField);
        input(password, phoneNumberField);

        return this;
    }
    @Step("After click submit button redirect to /confirm page ")
    public ConfirmPage clickSubmitButton() {
        click(submitButton);

        return new ConfirmPage(getDriver());
    }
    @Step("Click Submit button")
    public RecoveryPage clickSubmitButton_RecoveryPage() {
        click(submitButton);

        return new RecoveryPage(getDriver());
    }
    @Step("Click dropdown country ")
    public  RecoveryPage clickDropdownCountry() {
        click(dropdownCountry);

        return new  RecoveryPage(getDriver());
    }
    @Step("Get list result")
    public  List<String> getListCountryDropDown() {
        return getTexts(listCountryDropDown);

    }
    public String getValidationMessageError() {

        return getText(validationErrorMessage);
    }
    @Step("Enter search criteria in the drop-down country ")
    public  RecoveryPage enterSearchCriteriaInDropdownCountry() {
        input("V", searchInDropdown);
        return new  RecoveryPage(getDriver());
    }
    @Step("Click country in the dropdown  ")
    public  RecoveryPage clickCountryInDropDown() {
        click(countryInDropDown);

        return new  RecoveryPage(getDriver());
    }
    @Step("Wait until to be visible main image on the page /recovery")
    public RecoveryPage waitMainImageToBeVisible_RecoveryPage(){
        waitForUrlContains(ProjectConstants.URL_RECOVERY_PAGE);
        wait10ElementToBeVisible(imageRecoveryPage);

        return new RecoveryPage(getDriver());
    }
    public boolean imageIsDisplayedRecoveryPage() {

        return isElementDisplayed(imageRecoveryPage);
    }
    @Step("Get value input phone number ")
    public String getValueOfInputPhoneNumber(){
        return getAttribute(inputPhoneNumber,"value");
    }
    public String getCountryAttribute(){

        return getAttribute(countryAttribute,"xlink:href");
    }
    public String getCountryAttributeInPopup(){

        return getAttribute(countryAttributeInPopup,"xlink:href");
    }
    public boolean flagImageIsDisplayedRecoveryPage() {

        return isElementDisplayed(countryAttribute);
    }
}
