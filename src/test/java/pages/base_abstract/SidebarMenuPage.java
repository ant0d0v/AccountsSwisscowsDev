package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.footer_menu.LoginPage;
import pages.sidebar_menu.*;
import utils.ProjectConstants;

import java.util.List;

public abstract class SidebarMenuPage<Generic> extends FooterMenuPage{
    @FindBy(xpath = "//img")
    private List<WebElement> allImageOnPage;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement profileIcon;
    @FindBy(xpath = "//li[1]//a[@href='/']")
    private WebElement dashboardIcon;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement buttonChangePassword;
    @FindBy(xpath = "//h1[@class='modal-title']")
    private WebElement h1TextOfPopup;
    @FindBy(xpath = "//div[@class='content-box']//li")
    private List<WebElement> descriptionTextOfPopup;
    @FindBy(xpath = "//div[@id='portal']//button[@class='link']")
    private WebElement linkOfPopup;
    @FindBy(xpath = "//div[contains(@class,'modal')]")
    WebElement popup;
    @FindBy(xpath = "//ul[@class ='menu-list']//li[3]//a")
    private WebElement subscriptionIcon;
    @FindBy(xpath = "//ul[@class ='menu-list']//li[4]//a")
    private WebElement paymentsIcon;
    @FindBy(xpath = "//ul[@class ='menu-list']//li[5]//a")
    private WebElement logoutIconInSidebar;
    @FindBy(xpath = "//footer//*[name()='svg']")
    private WebElement linkBackToList;
    @FindBy(xpath = "//button")
    private WebElement proceedButton;
    @FindBy(xpath = "//div[@class='description']//*[name() = 'svg']")
    private List<WebElement> iconsOfProduct;
    @FindBy(xpath = "//div[@class ='product plans']//img[@class= 'logo']")
    private WebElement logoOfSubscription;
    @FindBy(xpath = "//a[@class='btn-submit']")
    private WebElement buyNowButtonOfProduct;
    @FindBy(xpath = "//div[@class='remark-container features']//li[text()]")
    private List<WebElement> featuresTextOfProduct;
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath= "//span[@class = 'price']")
    private List<WebElement> priceSubscription;
    @FindBy(xpath = "//div[@class = 'summary']//p")
    private List<WebElement> paymentSummary;
    @FindBy(xpath = "//img[@src ='./images/payment-illustration.svg']")
    private WebElement mainImageOfPlanidPage;
    @FindBy(xpath= "//p[@class ='bought-message']")
    private WebElement boughtMessage;
    @FindBy(xpath = "//div[@class ='modal log-out']//button[@class='btn-submit']")
    private WebElement logoutButtonInPopup;
    @FindBy(xpath = "//img[@src ='/images/logout-Illustration.svg']")
    private WebElement imageOfLogoutPopup;
    @FindBy(xpath = "//aside[@class ='sidebar']//div[@class='avatar']//img")
    private WebElement avatarOfSidebar;
    @FindBy(xpath = "//aside[@class ='sidebar']//li//*[name() ='svg']")
    private List<WebElement> listOfIconsInSidebar;


    public SidebarMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
    @Step("Click Profile icon in the Sidebar")
    public ProfilePage clickProfileIconInSidebar(){
        click20(profileIcon);
        waitForUrlContains(ProjectConstants.URL_PROFILE_PAGE);
        return new ProfilePage(getDriver());
    }
    @Step("Click Dashboard icon in the Sidebar")
    public DashboardPage clickDashboardIconInSidebar(){
        click20(dashboardIcon);
        waitForUrlContains(ProjectConstants.URL_DASHBOARD_PAGE);
        return new DashboardPage(getDriver());
    }
    @Step("Retrieve the H1 text of the popup.")
    public String getH1TextOfPopup() {

        return getText(h1TextOfPopup);
    }

    @Step("Get 'Features' text of Product")
    public List<String> getFeaturesTextOfProduct() {

        return getTexts(featuresTextOfProduct);
    }
    @Step("Retrieve the font size of the H1 text of the popup.")
    public String getFontSizeH1TextOfPopup() {

        return getFontSize(h1TextOfPopup);
    }
    @Step("Retrieve the description text of the popup.")
    public List<String> getDescriptionTextOfPopup() {

        return getTexts(descriptionTextOfPopup);
    }
    public ProfilePage clickLinkInPopup() {
        click(linkOfPopup);
        return new ProfilePage(getDriver());

    }

    @Step("Click link 'Back to list'")
    public ProductsPage clickLinkBackToListOfProduct() {
        click(linkBackToList);
        return new ProductsPage(getDriver());

    }
    @Step("Click Proceed button")
    public CardMethodPage clickToProceedButton_CardMethodPage() {
        click(proceedButton);
        return new CardMethodPage(getDriver());

    }
    public List<WebElement> getAllButtonsOnPage() {

        return  buttonsOfProductsPlan;
    }
    @Step("Click buttons of payment plan")
    public void clickButtonsOfPlan(int index) {
        click(getAllButtonsOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    @Step("Get text of subscription price")
    public List<String> getPriceSubscription(){
        return getTexts(priceSubscription);
    }
    @Step("Get text payment summary")
    public List<String> getTextPaymentSummary(){

        return getTexts(paymentSummary);
    }
    @Step("Get list size of icons in the sudebar")
    public int getListSizeOfIconsInSidebar(){
        return getListSize(listOfIconsInSidebar);
    }
    @Step("Get attribute color of dashboard icon in the sidebar")
    public String getColorOfDashboardIconInSidebar(){
        return getBackgroundColor(dashboardIcon);
    }

    public boolean isPopupPresent() {
        try {
            getDriver().findElement(By.xpath("//div[contains(@class, 'modal')]"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isBuyNowButtonOfPresent() {
        try {
            getDriver().findElement(By.xpath("//a[@class='btn-submit']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    @Step("Click subscription icon in the sidebar ")
    public SubscriptionsPage clickSubscriptionIcon() {

        click(subscriptionIcon);
        return new SubscriptionsPage (getDriver());
    }
    @Step("Click payments icon in the sidebar ")
    public PaymentsPage clickPaymentsIcon() {
        click(paymentsIcon);
        return new PaymentsPage (getDriver());
    }
    @Step("Click logout icon in the sidebar ")
    public DashboardPage clickLogoutIconInSidebar() {
        click(logoutIconInSidebar);
        return new DashboardPage (getDriver());
    }
    @Step("Click 'Logout' button in the popup ")
    public LoginPage clickLogoutButtonInPopup() {
        click(logoutButtonInPopup);
        return new LoginPage(getDriver());
    }
    @Step("Wait to be visible image in logout popup")
    public void waitVisibleImageInLogoutPopup() {
        wait10ElementToBeVisible(imageOfLogoutPopup);
    }

    public boolean buyNowButtonOfProductIsDisplayed() {
        return isElementDisplayed(buyNowButtonOfProduct);
    }
    public boolean allIconsOfProductIsDysplaed(){
        return areElementsInListDisplayed(iconsOfProduct);
    }
    public boolean logoOfSubscriptionIsDysplaed(){

        return isElementDisplayed(logoOfSubscription);
    }
    public boolean mainImageOfPlanIdPageIsDysplaed(){

        return isElementDisplayed(mainImageOfPlanidPage);
    }
    public boolean mainImageOfLogoutPopup(){

        return isElementDisplayed(imageOfLogoutPopup);
    }
    public boolean allIconsAreDysplaedInSidebar(){

        return areElementsInListDisplayed(listOfIconsInSidebar);
    }
    public boolean avatarIsDisplayedOfSidebar(){
        return isElementDisplayed(avatarOfSidebar);
    }
    @Step("Get bought message")
    public String getBoughtMessage(){
        return getText(boughtMessage);
    }

}
