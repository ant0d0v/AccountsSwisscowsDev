package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.footer_menu.RegisterPage;

import java.util.List;

import static java.lang.Thread.sleep;

public abstract class FooterMenuPage<Generic> extends TopMenuPage {

    private static final String FOOTER_MENU_ID = "//footer[@class = 'footer']";

    @FindBy(xpath = FOOTER_MENU_ID)
    private WebElement footerMenu;
    @FindBy(xpath = FOOTER_MENU_ID + "//a[@class='link']")
    private WebElement linkInTheFooterMenu;
    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'dropdown']//button")
    private WebElement langButtonFooterMenu;
    @FindBy(xpath = "//ul//li[position() > 1]")
    private List<WebElement> listLanguagesFooterMenu;
    @FindBy(xpath = "//div[@class = 'error-message']")
    private List<WebElement> listValidationErrorMessage;
    @FindBy(xpath = "//img")
    private List<WebElement> allImageOnPage;

    @FindBy(xpath = "//div[@class = 'input-container']//input")
    private List<WebElement> placeholdersFields;
    @FindBy(xpath = "//img[@src= '/images/error-illustration.svg']")
    private WebElement errorImage;
    @FindBy(xpath = "//*[name()='svg'][@class='error-input icon']")
    private List<WebElement> errorIcon;
    @FindBy(xpath = "//*[name()='svg'][@class='success-input-icon']")
    private WebElement successIcon;
    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'social-networks']/a")
    private List<WebElement> socialPanelIconsFooterMenu;//Swisscows
    @FindBy(xpath = FOOTER_MENU_ID + "//p[contains(text(), '©')]")
    private WebElement copyright;

    @FindBy(xpath = FOOTER_MENU_ID + "//li[text()='About Swisscows']")
    private WebElement aboutSwisscows; // swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='footer-menu-bottom']")
    private WebElement aboutSwisscowsAG;
    @FindBy(xpath = "//h1")
    private WebElement textH1FooterMenu;
    @FindBy(xpath = "//h1")
    private List<WebElement> textsH1;
    @FindBy(xpath = "//h2")
    private List<WebElement> textsH2;
    @FindBy(xpath = "//div[@class='row narrow static-content']//a")
    private List<WebElement> allLinksOnPage; // Swisscows
    @FindBy(className= "btn-submit")
    private List<WebElement> submitButton;
    @FindBy(xpath = "//input[@class ='input email']")
    private WebElement autocompleteAttribute;
    @FindBy(xpath = "//p[@class='description']")
    private WebElement descriptionText;


    public FooterMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();

    public int getSocialPanelSize() {

        return getListSize(socialPanelIconsFooterMenu);
    }

    public String getCopyright() {

        return getText(copyright);
    }
    @Step("Get h1 text")
    public String getH1Text() {
        return getText(textH1FooterMenu);
    }
    public List<String> getH1Texts() {

        return getTexts(textsH1);
    }
    @Step("Get description text")
    public String getDescriptionText(){
        return getText(descriptionText);
    }
    @Step("Get validation error message")
    public List<String> getListValidationErrorMessage() {

        return getTexts(listValidationErrorMessage);
    }

    public  List<String> getH2Texts() {

        return getTexts(textsH2);
    }
    public List<String> getH1Colors(){
        return  getColors(textsH1);

    }
    public List<String> getH2FontSizes(){
        return  getFontSizes(textsH2);

    }
    public List<String> getH1FontSizes(){
        return  getFontSizes(textsH1);

    }
    @Step("Get color all links")
    public List <String> getColorLinks (){

        return getColors(allLinksOnPage);
    }

    public WebElement getAboutSwisscowsFooterMenu() {

        return aboutSwisscows;
    }

    public WebElement getAboutSwisscowsAGFooterMenu() {

        return aboutSwisscowsAG;
    }
    protected WebElement getFooterMenu() {

        return footerMenu;
    }

    public List<WebElement> getAllLinksOnPage() {

        return allLinksOnPage;
    }

    public void clickAllLinks(int index) {
        click(getAllLinksOnPage().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        createGeneric();
    }
    @Step("Click link in the footer menu ")
    public RegisterPage clickLinkInTheFooterMenu() {
        wait10ElementToBeVisible(linkInTheFooterMenu);
        clickByJavaScript(linkInTheFooterMenu);

        return new RegisterPage (getDriver());
    }
    public RegisterPage clickLangButtonFooterMenu() {
        click20(langButtonFooterMenu);

        return new RegisterPage (getDriver());
    }

    public boolean isErrorImageIsDisplayed() {

        return isElementDisplayed(errorImage);
    }
    public boolean isErrorIconIsDisplayed() {

        return areElementsInListDisplayed(errorIcon);
    }
    public boolean isSuccessIconIsDisplayed() {

        return isElementDisplayed(successIcon);
    }
    public boolean allImageOnPageIsDisplayed() {

        return areElementsInListDisplayed(allImageOnPage);
    }
    @Step("Get text Of all placeholders ")
    public List<String> getInnerTextOfPlaceholders(String attribute) throws InterruptedException {

        return getAttributeOfElements(placeholdersFields, attribute);
    }
    @Step("Click language in the drop dawn lang")
    public void clickLangInDropdownOfLanguages(int index) throws InterruptedException {
        clickLangButtonFooterMenu();
        click20(getListLanguagesFooterMenu().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }
        getWait20().until(ExpectedConditions.urlContains("?culture="));
        createGeneric();
    }
    public List<WebElement> getListLanguagesFooterMenu() {

        return listLanguagesFooterMenu;
    }
    @Step("Get color when hovering")
    public List<String> getColorButtonWhenHover() throws InterruptedException {

        return  getHoverColorsOfElements(submitButton);
    }
    @Step("Get color without hover")
    public List<String> getColorButton() throws InterruptedException {

        return  getColorsOfElements(submitButton);
    }
    @Step("Get autocomplete attribute")
    public String getAutocompleteAttribute(){

        return getAttribute(autocompleteAttribute,"value");
    }

}
