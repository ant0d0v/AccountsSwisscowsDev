package pages.accounts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class RecoveryMethodPage extends FooterMenuPage<RecoveryMethodPage> {
    @FindBy(xpath = "//label[@for='PhoneNumber']")
    private WebElement phoneNumberMethod;
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
    public RestorePage clickProceedButton(){
        click20(proceedButton);
        return new RestorePage(getDriver());
    }
}
