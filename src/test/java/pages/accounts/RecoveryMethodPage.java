package pages.accounts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class RecoveryMethodPage extends FooterMenuPage<RecoveryMethodPage> {
    @FindBy(xpath = "//label[@for='PhoneNumber']")
    private WebElement phoneNumberMethod;
    @FindBy(xpath = "//label[@for='AlternateEmail']")
    private WebElement alternateEmailMethod;
    @FindBy(className = "btn-submit")
    private WebElement proceedButton;
    public  RecoveryMethodPage(WebDriver driver) {
        super(driver);
    }

    public  RecoveryMethodPage createGeneric() {

        return new  RecoveryMethodPage(getDriver());
    }
    public RecoveryMethodPage clickPhoneNumberMethod(){
        click20(phoneNumberMethod);
        return this;
    }
    public RecoveryMethodPage clickAlternateMailMethod(){
        click20(alternateEmailMethod);
        return this;
    }
    public ConfirmPage clickProceedButton(){
        click20(proceedButton);
        return new  ConfirmPage(getDriver());
    }
}
