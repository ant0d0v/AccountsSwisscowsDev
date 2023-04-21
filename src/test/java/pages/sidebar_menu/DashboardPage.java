package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class DashboardPage extends SidebarMenuPage<DashboardPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;


    @FindBy(xpath = "//input[@name='phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement notification;
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
    @FindBy(xpath = "//header[@class ='header']//img")
    private WebElement logoSidebar;
    @FindBy(xpath = "//div[@class='greetings']")
    private WebElement welcomeMessage;
    @FindBy(className = "btn-submit")
    private List<WebElement> allLinksOnDashboardPage;
    @FindBy(xpath = "//div[contains(@class,'widget ')]")
    private List<WebElement> allWidgets;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement profileIcon;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage createGeneric() {

        return new DashboardPage(getDriver());
    }
    public DashboardPage waitLogoInSidebarToBeVisible(){
        wait10ElementToBeVisible(logoSidebar);
        return new DashboardPage(getDriver());
    }
    public DashboardPage waitAllWidgetsToBeVisible(){
        areAllElementsVisibleAndClickable(allWidgets);
        return new DashboardPage(getDriver());
    }

    public List<WebElement> getAllLinksOnDashboardPage() {

        return allLinksOnDashboardPage;
    }
    public void clickAllLinksOnDashboardPage(int index) {
        click(getAllLinksOnDashboardPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    public int getCountWidgets(){
        return getListSize(allWidgets);
    }
    public String getWelcomeMessage(){
        return getText(welcomeMessage);
    }
    public List<String> getColorOfWidgets() throws InterruptedException {

        return  getBackgroundColorsOfElements(allWidgets);
    }


}

