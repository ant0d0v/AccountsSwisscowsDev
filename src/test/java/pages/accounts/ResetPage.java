package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

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


    public ResetPage(WebDriver driver) {
        super(driver);
    }

    public ResetPage createGeneric() {

        return new ResetPage(getDriver());
    }
    public ResetPage enterNewUserPassword(String email) {
        click(newUserPassword);
        input(email, newUserPassword);
        return this;

    }

    public ResetPage repeatUserPassword(String password) {
        click(repeatUserPassword);
        input(password, repeatUserPassword);
        return this;
    }

    public DashboardPage clickSubmitButton() {
        click(submitButton);
        waitForUrlContains("https://accounts.dev.swisscows.com/");

        return new DashboardPage(getDriver());
    }
}