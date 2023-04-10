package pages.accounts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class RecoveryPage extends FooterMenuPage<RecoveryPage> {
    @FindBy(xpath = "//button[@class = 'btn-submit']")
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
    @FindBy(xpath = "//input[@class= 'search']")
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
    public RecoveryPage enterPhoneNumber() {
        String password = "993484583";

        click(phoneNumberField);
        phoneNumberField.clear();
        input(password, phoneNumberField);

        return this;
    }
    public RecoveryPage enterInvalidPhoneNumber() {
        String password = "993484583da";

        click(phoneNumberField);
        phoneNumberField.clear();
        input(password, phoneNumberField);

        return this;
    }
    public RecoveryPage enterAlreadyRegisteredPhoneNumber() {
        String password = "+380960507948";

        click(phoneNumberField);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = '';", phoneNumberField);
        input(password, phoneNumberField);

        return this;
    }
    public ConfirmPage clickSubmitButton() {
        click(submitButton);

        return new ConfirmPage(getDriver());
    }
    public RecoveryPage clickSubmitButton_RecoveryPage() {
        click(submitButton);

        return new RecoveryPage(getDriver());
    }
    public  RecoveryPage clickDropdownCountry() {
        click(dropdownCountry);

        return new  RecoveryPage(getDriver());
    }
    public  List<String> getListCountryDropDown() {
        return getTexts(listCountryDropDown);

    }
    public String getValidationMessageError() {

        return getText(validationErrorMessage);
    }
    public  RecoveryPage enterSearchCriteriaInDropdownCountry() {
        input("V", searchInDropdown);
        return new  RecoveryPage(getDriver());
    }
    public  RecoveryPage clickCountryInDropDown() {
        click(countryInDropDown);

        return new  RecoveryPage(getDriver());
    }

    public RecoveryPage waitMainImageToBeVisible_RecoveryPage(){
        waitForUrlContains("https://accounts.dev.swisscows.com/recovery");
        wait10ElementToBeVisible(imageRecoveryPage);

        return new RecoveryPage(getDriver());
    }
    public boolean imageIsDisplayedRecoveryPage() {

        return isElementDisplayed(imageRecoveryPage);
    }
    public String getValueOfInputPhoneNumber(){
        return getAttribute(inputPhoneNumber,"value");
    }
    public String getCountryAttribute(){

        return getAttribute(countryAttribute,"xlink:href");
    }
    public boolean flagImageIsDisplayedRecoveryPage() {

        return isElementDisplayed(countryAttribute);
    }
}
