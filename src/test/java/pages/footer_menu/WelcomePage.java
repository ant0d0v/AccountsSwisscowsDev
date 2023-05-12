package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.sidebar_menu.DashboardPage;
import utils.ProjectConstants;

import java.util.List;

public class WelcomePage extends FooterMenuPage<WelcomePage> {
    @FindBy(xpath = "//h1")
    private WebElement h1Text;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class ='add-info']//a//*[name()='use']")
    private List<WebElement> productIcons;
    @FindBy(id = "user_email")
    private WebElement userEmail;
    @FindBy(id = "user_password")
    private WebElement userPassword;
    @FindBy(xpath = "//a[@href='/users/sign_up']")
    private WebElement createAccountLink;
    @FindBy(xpath = "//a[@href='#']")
    private WebElement clickHereToRecoverLink;
    @FindBy(xpath = "//h3")
    private WebElement h3Header;
    @FindBy(xpath = "//img[@src='/images/form-illustration.svg']")
    private WebElement imageWelcomePage;
    @FindBy(xpath = "//button[@class='btn-submit']")
    private WebElement goToAccountButton;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    public WelcomePage createGeneric() {

        return new WelcomePage(getDriver());
    }
    @Step("Open /welcome page")
    public WelcomePage openWelcomePage(){
        getDriver().get(ProjectConstants.URL_WELCOME_PAGE);

        return new WelcomePage(getDriver());
    }
    @Step("Wait until to be visible main image on the page /welcome")
    public WelcomePage waitMainImageToBeVisible_WelcomePage(){
       wait10ElementToBeVisible(imageWelcomePage);

        return new WelcomePage(getDriver());
    }
    @Step("Wait until to be visible products image on the page /welcome")
    public WelcomePage waitProductIconsToBeVisible_WelcomePage(){
        areAllElementsVisible(productIcons);
        return new WelcomePage(getDriver());
    }
    @Step("After click to 'Go to account' button redirect /dashboard page ")
    public DashboardPage clickGoToAccountButton(){
        waitForUrlContains(ProjectConstants.URL_WELCOME_PAGE);
        click20(goToAccountButton);

        return new DashboardPage(getDriver());
    }
    public boolean productIconsIsDisplayed() {

        return areElementsInListDisplayed(productIcons);
    }
    public boolean imageIsDisplayedWelcomePage() {

        return isElementDisplayed(imageWelcomePage);
    }
    public List<WebElement> getLinksWelcomePage() {

        return productIcons;
    }
    @Step("Click links Of products")
    public void clickLinksOfProducts(int index) {
        click(getLinksWelcomePage().get(index));
        switchToAnotherWindow();

    }
}
