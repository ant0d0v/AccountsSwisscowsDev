package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.MainPage;
import pages.footer_menu.LoginPage;

import java.util.ArrayList;
import java.util.List;

public abstract class TopMenuPage<Generic> extends BasePage {

    private static final String TOP_MENU_ID = "//div[@class = 'badges animation-badges']";
    @FindBy(xpath = TOP_MENU_ID)
    private WebElement topMenuContainer;
    @FindBy(xpath = "//button[@class ='login']")
    private WebElement signInTopMenu;
    @FindBy(xpath = "//button[@type = 'button']")
    private WebElement hamburgerTopMenu;

    @FindBy(xpath = "//div[@class ='menu popup']//a")
    private List<WebElement> hamburgerTopMenuDropdownLinks;
    @FindBy(xpath = "//button[@class ='logout']")
    private WebElement LogOutButtonHamburgerDropDownMenu;
    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement lastElementInDropdownRegion;
    @FindBy(xpath = "//h3")
    private List<WebElement> textsH3;
    @FindBy(xpath = "//h2")
    private List<WebElement> textsH2;
    @FindBy(xpath = "//div[@class='static-content']//div/a")
    private List<WebElement> allLinksOnPage;
    @FindBy(xpath = "//div[@class='static-content']//a[@class='button outline']")
    private List<WebElement> allLinksOnEmailPage;
    @FindBy(xpath = "//div[@class = 'static-content']//a")
    private List<WebElement> allLinks;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    protected WebElement getLastElementInDropdownRegion() {

        return lastElementInDropdownRegion;
    }
    @Step("Open url https://dev.swisscows.com/en ")
    public MainPage openSwisscowsSite() {

        getDriver().get("https://dev.swisscows.com/en");
        return  new MainPage(getDriver());
    }
    public LoginPage signIn() {
        clickSignInMenu().signInAsRegularUser();

        return new LoginPage(getDriver());
    }


    public List<String> getH2FontSizes(){
        return  getFontSizes(textsH2);

    }

    @Step("Click Hamburger menu on the site swisscows")
    public MainPage clickHamburgerMenu() {
        click(hamburgerTopMenu);

        return new MainPage(getDriver());
    }
    public List <String> getColorLinks (){

        return getColors(allLinks);
    }
    @Step("Click hamburger menu icon")
    public MainPage clickHamburgerMenuIcon() {
        click(hamburgerTopMenu);

        return new MainPage(getDriver());
    }
    public List <String> getH3Texts() {

        return getTexts(textsH3);
    }
    public List <String> getH2Texts() {

        return getTexts(textsH2);
    }

    @Step("Click Sign in redirect to /login page ")
    public LoginPage clickSignInMenu() {
        click20(signInTopMenu);

        return new LoginPage(getDriver());
    }
    @Step("Click Sign in icon")
    public MainPage clickSignInIcon() {
        click20(signInTopMenu);

        return new  MainPage(getDriver());
    }

}
