package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base_abstract.FooterMenuPage;
import pages.ContactUsPage;
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
    @FindBy(xpath = "//h1")
    private WebElement H1text;


    public ForgotPage(WebDriver driver) {
        super(driver);
    }

    public  ForgotPage createGeneric() {

        return new  ForgotPage(getDriver());
    }
    @Step("Enter user email")
    public ForgotPage enterUserEmail(String email) {
        click(emailField);
        input(email, emailField);

        return this;
    }
    @Step("Get description text on the /forgot page")
    public List<String> getDescriptionForgotPage() {
        return getTexts(descriptionForgotPage);
    }
    @Step("Click Submit button ")
    public RecoveryPage clickSubmitButton_RecoveryPage() {
        click(submitButton);
        return new RecoveryPage(getDriver());
    }
    @Step("After click submit button redirect to /recovery-method page")
    public RecoveryMethodPage clickSubmitButton_RecoveryMethodPage() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/recovery/method");
        return new  RecoveryMethodPage(getDriver());
    }
    @Step("After click submit button redirect to /user_not_found page")
    public UserNotFoundPage clickSubmitButton_UserNotFoundPage() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/error?status=user_not_found");
        return new  UserNotFoundPage (getDriver());
    }
    @Step("After click submit button redirect to /restore page")
    public RestorePage clickSubmitButton_RestorePage() throws InterruptedException {
        click(submitButton);
        waitForUrlContains(ProjectConstants.URL_RESTORE_PAGE);
        return new  RestorePage (getDriver());
    }

    @Step("After click Support link redirect to swisscows.com/contact  ")
    public ContactUsPage clickSupportLink() {
        click(supportLink);
        switchToAnotherWindow();
        return new ContactUsPage(getDriver());
    }
    @Step("Wait to be visible main image on the /forgot page")
    public ForgotPage waitMainImageToBeVisible_ForgotPage(){
        waitForUrlContains(ProjectConstants.URL_FORGOT_PAGE);
        wait10ElementToBeVisible(mainImage);

        return new ForgotPage(getDriver());
    }
    public ForgotPage waitToBeChangeH1text(String text){
        getWait10().until(ExpectedConditions.textToBePresentInElement(H1text, text));
        return new ForgotPage(getDriver());
    }
    public boolean imageIsDisplayedForgotPage() {

        return isElementDisplayed(mainImage);
    }

}