package pages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.List;

public class ExtensionPage extends FooterMenuPage<ExtensionPage> {
    @FindBy(xpath = "(//div[@class='row narrow static-content']//a)[position() < 5]")
    private List<WebElement> allLinksOnPage;
    @FindBy(id = "btn-toggle")
    private WebElement toggle;
    @FindBy(id = "btn-submit")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@class= 'input-wrapper']//input[@id ='password']")
    private WebElement userPasswordField;
    @FindBy(xpath = "//div[@class= 'input-wrapper']//input[@id ='username']")
    private WebElement userEmailField;
    public ExtensionPage(WebDriver driver) {
        super(driver);
    }
    public ExtensionPage createGeneric() {

        return new ExtensionPage(getDriver());
    }
    @Step("Open extension")
    public ExtensionPage clickToggle() {
        click20(toggle);
        return new ExtensionPage(getDriver());
    }
    public boolean toggleIsTernOn(){
        return  toggle.isEnabled();
    }
    @Step("Open extension")
    public ExtensionPage clickSignInButton() {
        click20(signInButton);
        return new ExtensionPage(getDriver());
    }
    @Step("Enter user password ")
    public ExtensionPage enterUserPassword(String password) {
        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);
        return new ExtensionPage(getDriver());
    }
    @Step("Enter user email")
    public ExtensionPage enterUserEmail(String email) {
        click(userEmailField);
        userEmailField.clear();
        input(email, userEmailField);
        return new ExtensionPage(getDriver());
    }

}
