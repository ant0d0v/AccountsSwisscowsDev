package pages.base_abstract;

import io.qase.api.annotation.Step;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.MainPage;
import pages.accounts.RegisterPage;
import pages.footer_menu.*;
import pages.top_menu.EmailPage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'locales']//ul")
    private WebElement langDropdownMenuFooterMenu;
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




    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/en/media-education']")
    private WebElement MediaEducationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Charity Project']") // Swisscows
    private WebElement CharityProjectFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/en/search-engine-no-tracking']")
    private WebElement whoWeAreFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Our Datacenter']")// Swisscows
    private WebElement OurDatacenterFooterMenu;
    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Donation']")// Swisscows
    private WebElement donationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text()='Contact us']")//Swisscows
    private WebElement ContactusFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'VPN']")//Swisscows
    private WebElement VpnFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Swisscows.email']")//Swisscows
    private WebElement SwisscowsEmailFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'TeleGuard']")//Swisscows
    private WebElement TeleGuardFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'HES']")//Swisscows
    private WebElement HesFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'GetDigest']")//Swisscows
    private WebElement GetDigestFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'footer-menu']//ul[2]//a")//Swisscows
    private List<WebElement> OurProductsList;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Fan-shop']")//Swisscows
    private WebElement fanShopFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Swisscows Blog']")//Swisscows
    private WebElement swisscowsBlogFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Set as Startpage']")//Swisscows
    private WebElement setAsStartpageFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Make a Default Search Engine']")//Swisscows
    private WebElement makeDefaultSearchEngineFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@class = 'company-link']")//Swisscows
    private WebElement AboutSwisscowsAgFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Imprint']")//Swisscows
    private WebElement imprintFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[text() = 'Data privacy']")//Swisscows
    private WebElement dataPrivacyFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@class = 'app-link'][2]")
    private WebElement downloadOnTheAppStoreLinkFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href ='https://play.google.com/store/apps/details?id=com.swisscows.search']"
            + "[@target ='_blank']")
    private WebElement downloadGooglePlayLinkFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href ='https://apps.apple.com/app/swisscows-privacy-search/id1581108092']"
            + "[@target ='_blank']")
    private WebElement downloadAppStoreLinkFooterMenu; //Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'social-networks']/a")
    private List<WebElement> socialPanelIconsFooterMenu;//Swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.facebook.com/swisscows/']")
    private WebElement facebookIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.instagram.com/swisscows.official/']")
    private WebElement instagramIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://www.linkedin.com/company/swisscows/']")
    private WebElement linkedinIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://twitter.com/swisscows_ch']")
    private WebElement twitterIconFooterMenu; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://teleguard.com/']")
    private WebElement teleGuardIconFooterMenu; // Swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'app']/a")
    private List<WebElement> storeIconsDownload;// Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//p[contains(text(), '©')]")
    private WebElement copyright;

    @FindBy(xpath = FOOTER_MENU_ID + "//li[text()='About Swisscows']")
    private WebElement aboutSwisscows; // swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='footer-menu-bottom']")
    private WebElement aboutSwisscowsAG; // swisscows


    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class = 'footer-menu']//ul[1]//a")
    private List<WebElement> aboutSwisscowsList;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='footer-menu-bottom']//a")
    private List<WebElement> aboutSwisscowsAGList;

    @FindBy(xpath = FOOTER_MENU_ID + "//a") // Swisscows links
    private List<WebElement> footerMenuLinks;


    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='app']//a")
    private List<WebElement> storePanelIconsFooterMenu; // Swisscows

    @FindBy(className = "social-networks")
    private WebElement socialPanelFooterMenu;

    @FindBy(xpath = "//h1")
    private WebElement textH1FooterMenu;
    @FindBy(xpath = "//h1")
    private List<WebElement> textsH1;

    @FindBy(xpath = "//h2")
    private List<WebElement> textsH2;


    @FindBy(xpath = "//div[@class='row narrow static-content']//a")
    private List<WebElement> allLinksOnPage; // Swisscows

    @FindBy(xpath = FOOTER_MENU_ID + "//ul/li/a")
    private List<WebElement> innerFooterMenuLink;

    @FindBy(xpath = "//ul[@class ='menu-dropdown-list']/li")
    private List<WebElement> innerLangMenuList;

    @FindBy(xpath = "//ul[@class='menu-dropdown-list']//li")
    private List<WebElement> innerRegionMenuList;

    @FindBy(xpath = "//div[@class ='menu-dropdown-button'][1]")
    private WebElement LangDropDownIcon;

    @FindBy(xpath = "//div[@class='menu-dropdown-button'][2]")
    private WebElement RegionDropDownIcon;
    @FindBy(xpath = "//video")
    private WebElement videoPlayer;
    @FindBy(xpath = "//div[@class='player']/iframe")
    private WebElement videoPlayerYouTube;
    @FindBy(xpath = "//a[@href='mailto: info@swisscows.com']")
    private WebElement linkToEmail;
    @FindBy(className= "btn-submit")
    private List<WebElement> submitButton;
    @FindBy(xpath = "//input[@class ='input email']")
    private WebElement autocompleteAttribute;


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
    public String getColorEmail (){
        return getBackgroundColor(linkToEmail);
    }
    public List <String> getColorLinks (){

        return getColors(allLinksOnPage);
    }

    public WebElement getAboutSwisscowsFooterMenu() {

        return aboutSwisscows;
    }

    public WebElement getAboutSwisscowsAGFooterMenu() {

        return aboutSwisscowsAG;
    }


    public List<String> getAboutSwisscowsMenusTexts() {

        return getTexts(aboutSwisscowsList);
    }

    public List<String> getAboutSwisscowsAGMenusTexts() {

        return getTexts(aboutSwisscowsAGList);
    }

    public List<String> getOurProductsMenusTexts() {

        return getTexts(OurProductsList);
    }

    protected WebElement getFooterMenu() {

        return footerMenu;
    }

    public int getFooterMenuLinksCount() {
        areAllElementsVisibleAndClickable(footerMenuLinks);

        return getListSize(footerMenuLinks);
    }

    public int getStoresIconsCount() {

        return getListSize(storePanelIconsFooterMenu);
    }
    public List<String> getLinkColorsFooterMenu() throws InterruptedException {

        return  getColorsOfElements(footerMenuLinks);
    }
    public List<String> getLinksColorsWhenHoverFooterMenu() throws InterruptedException {

        return  getHoverColorsOfElements(footerMenuLinks);
    }

    public List<WebElement> getInnerFooterMenuLinks() {

        return innerFooterMenuLink;
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

    public Generic clickFooterMenu(int index) {
        click(getInnerFooterMenuLinks().get(index));
        if (getDriver().getWindowHandles().size() > 1) {
            switchToAnotherWindow();
        }

        return createGeneric();
    }


    public void clickFooterMenuExternalLink(int index) {
        click(getInnerFooterMenuLinks().get(index));
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
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


    public MediaEducationPage clickMediaEducationFooterMenu() {
        click(MediaEducationFooterMenu);

        return new MediaEducationPage(getDriver());
    }


    public CharityProjectPage clickCharityProjectFooterMenu() {
        click(CharityProjectFooterMenu);

        return new CharityProjectPage(getDriver());
    }

    public OurDatacenterPage clickOurDatacenterPageFooterMenu() {
        click(OurDatacenterFooterMenu);

        return new OurDatacenterPage(getDriver());
    }
    public DonationPage clickDonationPageFooterMenu() {
        click(donationFooterMenu);

        return new DonationPage(getDriver());
    }

    public WhoWeArePage clickAboutUsFooterMenu() {
        click20(whoWeAreFooterMenu);

        return new WhoWeArePage(getDriver());
    }

    public MainPage clickInstagramIcon() {
        click20(instagramIconFooterMenu);
        return new MainPage(getDriver());
    }

    public MainPage clickLinkedinIcon() {
        click20(linkedinIconFooterMenu);
        return new MainPage(getDriver());
    }

    public EmailPage clickSwisscowsEmail() {

        click20(SwisscowsEmailFooterMenu);
        return new EmailPage(getDriver());
    }
    public ContactUsPage clickContactUsPageFooterMenu() {
        click(ContactusFooterMenu);

        return new ContactUsPage(getDriver());
    }
    public SetAsStartPage clickSetAsStartPageFooterMenu() {
        click(setAsStartpageFooterMenu);

        return new SetAsStartPage(getDriver());
    }
    public MakeDefaultSearchPage clickMakeDefaultSearchPageFooterMenu() {
        click(makeDefaultSearchEngineFooterMenu);

        return new MakeDefaultSearchPage(getDriver());
    }
    public PrivacyPolicyPage clickPrivacyPolicyPageFooterMenu() {
        click(dataPrivacyFooterMenu);

        return new PrivacyPolicyPage(getDriver());
    }
    public ImprintPage clickImprintPageFooterMenu() {
        click(imprintFooterMenu);

        return new ImprintPage(getDriver());
    }

    public MainPage clickAppStoreIcon() {
        click20(downloadOnTheAppStoreLinkFooterMenu);
        return new MainPage(getDriver());
    }


    public MainPage clickGooglePlayIcon() {
        click20(downloadGooglePlayLinkFooterMenu);
        return new MainPage(getDriver());
    }

    public MainPage clickFacebookIcon() {
        click20(facebookIconFooterMenu);
        return new MainPage(getDriver());
    }

    public MainPage clickTwitterIcon() {
        click20(twitterIconFooterMenu);
        return new MainPage(getDriver());
    }

    public MainPage clickTeleGuardIcon() {
        click20(teleGuardIconFooterMenu);
        return new MainPage(getDriver());
    }


    public boolean isStorePanelDisplayed() {

        return areElementsInListDisplayed(storePanelIconsFooterMenu);
    }

    public boolean isSocialPanelDisplayed() {

        return isElementDisplayed(socialPanelFooterMenu);
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
    public String getCurrentSrcOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (String) executor.executeScript("return arguments[0].currentSrc;", videoPlayer);
    }
    public CharityProjectPage pauseVideoCharity() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].pause()", videoPlayer);
        return new CharityProjectPage(getDriver());
    }
    public OurDatacenterPage pauseVideoDatacenter() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].pause()", videoPlayer);
        return new OurDatacenterPage(getDriver());
    }
    public CharityProjectPage playVideoCharity() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].play()", videoPlayer);
        sleep(5000);
        return new CharityProjectPage(getDriver());
    }
    public OurDatacenterPage playVideoDatacenter() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("return arguments[0].play()", videoPlayer);
        sleep(5000);
        return new OurDatacenterPage(getDriver());
    }


    public String getPdfText(String pdfUrl) throws IOException {
        URL url = new URL(pdfUrl);
        InputStream is = url.openStream();
        BufferedInputStream bis= new BufferedInputStream(is);
        PDDocument doc = PDDocument.load(bis);
        return  new PDFTextStripper().getText(doc);
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
        sleep(1000);
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

    /*public long getDurationOfVideo() {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        return (Long) executor.executeScript("return arguments[0].duration", videoPlayer);
    }*/
}
