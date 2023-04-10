package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.footer_menu.ContactUsPage;

public class  ForgotPage extends FooterMenuPage< ForgotPage> {
    @FindBy(xpath = "//input[@class ='input']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class ='btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//button[@class ='btn-submit']")
    private WebElement supportLink;

    public ForgotPage(WebDriver driver) {
        super(driver);
    }

    public  ForgotPage createGeneric() {

        return new  ForgotPage(getDriver());
    }
    public ForgotPage enterUserEmail(String email) {
        click(emailField);
        input(email, emailField);

        return this;
    }
    public RecoveryPage clickSubmitButton_RecoveryPage() {
        click(submitButton);
        return new RecoveryPage(getDriver());
    }
    public ContactUsPage clickSupportLink() {
        click(submitButton);
        return new ContactUsPage(getDriver());
    }

}