package pages.accounts;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.sidebar_menu.DashboardPage;
import utils.ProjectConstants;

public class ResetPage extends FooterMenuPage<ResetPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@name = 'password']")
    private WebElement newUserPassword;
    @FindBy(xpath = "//input[@name = 'confirmPassword']")
    private WebElement repeatUserPassword;
    @FindBy(xpath = "//button[@class='link']")
    private WebElement linkIdidntGetCode;
    @FindBy(xpath = "//img[@src='/images/verification-illustration.svg']")
    private WebElement mainImage;


    public ResetPage(WebDriver driver) {
        super(driver);
    }

    public ResetPage createGeneric() {

        return new ResetPage(getDriver());
    }
    @Step("Enter new user password")
    public ResetPage enterNewUserPassword(String email) {
        click(newUserPassword);
        input(email, newUserPassword);
        return this;

    }
    @Step("Repeat user password")
    public ResetPage repeatUserPassword(String password) {
        click(repeatUserPassword);
        input(password, repeatUserPassword);
        return this;
    }
    @Step("Click Submit button")
    public DashboardPage clickSubmitButton() {
        click(submitButton);
        waitForUrlContains(ProjectConstants.URL_DASHBOARD_PAGE);

        return new DashboardPage(getDriver());
    }
    public ResetPage waitMainImageToBeVisible_ResetPage(){
        wait10ElementToBeVisible(mainImage);

        return new ResetPage(getDriver());
    }
    public boolean imageIsDisplayedResetPage() {

        return isElementDisplayed(mainImage);
    }
}