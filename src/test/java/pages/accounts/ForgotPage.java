package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.footer_menu.ContactUsPage;
import utils.ProjectConstants;

import java.util.List;

public class  ForgotPage extends FooterMenuPage< ForgotPage> {
    @FindBy(xpath = "//input[@class ='input']")
    private WebElement emailField;
    @FindBy(xpath = "//button[@class ='btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//p[@class='notes']//a")
    private WebElement supportLink;
    @FindBy(xpath = "//img[@src='/images/verification-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//div//p")
    private List<WebElement> descriptionForgotPage;


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
    public List<String> getDescriptionForgotPage() {
        return getTexts(descriptionForgotPage);
    }
    public RecoveryPage clickSubmitButton_RecoveryPage() {
        click(submitButton);
        return new RecoveryPage(getDriver());
    }
    public RecoveryMethodPage clickSubmitButton_RecoveryMethodPage() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/recovery/method");
        return new  RecoveryMethodPage(getDriver());
    }
    public UserNotFoundPage clickSubmitButton_UserNotFoundPage() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/error?status=user_not_found");
        return new  UserNotFoundPage (getDriver());
    }
    public RestorePage clickSubmitButton_RestorePage() throws InterruptedException {
        click(submitButton);
        waitForUrlContains(ProjectConstants.URL_RESTORE_PAGE);
        return new  RestorePage (getDriver());
    }

    public ContactUsPage clickSupportLink() {
        click(supportLink);
        switchToAnotherWindow();
        return new ContactUsPage(getDriver());
    }
    public ForgotPage waitMainImageToBeVisible_ForgotPage(){
        waitForUrlContains(ProjectConstants.URL_FORGOT_PAGE);
        wait10ElementToBeVisible(mainImage);

        return new ForgotPage(getDriver());
    }
    public boolean imageIsDisplayedForgotPage() {

        return isElementDisplayed(mainImage);
    }

}