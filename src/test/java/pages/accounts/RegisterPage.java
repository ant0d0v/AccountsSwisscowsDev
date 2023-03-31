package pages.accounts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimePart;
import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage extends FooterMenuPage<RegisterPage> {
    @FindBy(xpath = "//input[@class='phone-no ']")
    private WebElement usernameFieldYahoo;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordFieldYahoo;
    @FindBy(xpath = "//div[@class='button-container']")
    private WebElement nextButtonGmail;
    @FindBy(xpath = "//div[@class='_yb_j4wcb  _yb_x7ryt   _yb_dbdlj']")
    private WebElement emailIconYahoo;
    @FindBy(xpath = "//ul[@role='list']//li[2]")
    private WebElement letterInYahoo;
    @FindBy(xpath = "//tbody//td//p[2]")
    private WebElement codeInLetterYahoo;

    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//div[@class='checkboxes']//div//label")
    private List<WebElement> checkboxesRegisterPage;


    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//input[@autocomplete='email']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='user_email']")
    private WebElement enterEmailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//div[@class='input-container'][3]//input")
    private WebElement repeatUserPasswordField;

    @FindBy(xpath = "//input[@id='agreement_is_age_confirmed']")
    private WebElement ageConfirmCheckbox;

    @FindBy(xpath = "//input[@id='agreement_is_accepted']")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//input[@id='mailing_system']")
    private WebElement mailingSystemCheckbox;

    @FindBy(xpath = "//input[@id='mailing_product']")
    private WebElement mailingProductCheckbox;

    @FindBy(xpath = "//input[@id='mailing_news']")
    private WebElement mailingNewsCheckbox;

    @FindBy(xpath = "//input[@value='Create Account']")
    private WebElement createAccountButton;

    @FindBy(xpath = "//div[contains(text(),'Privacy Centre')]/a[.='Privacy Policy']")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//div[@class= 'checkboxes']//a")
    private List<WebElement> linksCheckboxRegisterPage;
    @FindBy(xpath = "//div[@class = 'input-container']//input")
    private List<WebElement> placeholdersFields;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage createGeneric() {

        return new RegisterPage(getDriver());
    }


    public RegisterPage clickClearInputNewUsername() {
        String username = "Tester";

        click(usernameField);
        usernameField.clear();
        input(username, usernameField);

        return this;
    }

    public RegisterPage enterNewUserEmail() {
        String email = "qaengineert16@yahoo.com";
        click(usernameField);
        input(email, usernameField);

        return this;
    }

    public RegisterPage enterNewUserPassword() {
        String password = "Tester12#";

        click(userPasswordField);
        userPasswordField.clear();
        input(password, userPasswordField);

        return this;
    }

    public RegisterPage enterRepeatPassword() {
        String password = "Tester12#";
        click(repeatUserPasswordField);
        repeatUserPasswordField.clear();
        input(password, repeatUserPasswordField);

        return this;
    }

    public void clickInputYahooField() {
        String password = "qaengineert16@yahoo.com";
        click(usernameFieldYahoo);
        input(password, usernameFieldYahoo);
    }

    public void clickInputPasswordYahooField() {
        String password = "2075Deltuha";
        click(passwordFieldYahoo);
        input(password, passwordFieldYahoo);
    }

    public RegisterPage clickAgeConfirmCheckbox() {
        click(ageConfirmCheckbox);

        return this;
    }

    public RegisterPage clickAgreementCheckbox() {
        click(agreementCheckbox);

        return this;
    }

    public RegisterPage clickRegisterButton() {
        click(submitButton);

        return this;
    }

    public RegisterPage enterCode() {
        String password = "524251";
        click(codeConfirm);
        inputActions(password, codeConfirm);

        return this;
    }

    public RegisterPage clickCreateAccountButton() {
        click(createAccountButton);

        return new RegisterPage(getDriver());
    }

    public List<WebElement> getLinksCheckboxRegisterPage() {

        return linksCheckboxRegisterPage;
    }

    public void clickLinksInCheckbox(int index) {
        click(getLinksCheckboxRegisterPage().get(index));
        switchToAnotherWindow();

    }

    public void clickNextButtonGmail() {
        click(nextButtonGmail);
    }

    public void clickEmailIconYahoo() {
        click(emailIconYahoo);
    }

    public void clickLetterInYahoo() {
        click(letterInYahoo);
    }

    public RegisterPage clickAllCheckboxesRegisterPage() {
        clickAllElementsInList(checkboxesRegisterPage);
        return this;
    }

    public String getCodeInYahooMailBox() {
        wait10ElementToBeVisible(emailIconYahoo);
        clickEmailIconYahoo();
        clickLetterInYahoo();
        return getText(codeInLetterYahoo);

    }

    public void loginToGmail() {
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        switchToAnotherWindow();
        getDriver().get("https://login.yahoo.com/?.lang=en-US&src=homepage&.done=https%3A%2F%2Fwww.yahoo.com%2F&pspid=2023538075&activity=ybar-signin");
        clickInputYahooField();
        clickNextButtonGmail();
        clickInputPasswordYahooField();
        clickNextButtonGmail();


    }

    public RegisterPage enterUserCredentials() {
        enterNewUserEmail();
        enterNewUserPassword();
        enterRepeatPassword();

        return new RegisterPage(getDriver());
    }


    public void clickPrivacyPolicy() {

        click20(privacyPolicy);
    }

    public RegisterPage closeWindow() {
        getDriver().close();
        return this;

    }

    public static class PropertiesEmail {
        public String host = "imap.gmail.com";
        public String user = "qaengineer1203@gmail.com";
        public String password = "hmcmhkutozxsxdvq"; //cqhfpzuosufpxfcp
        int port = 993;

        public Properties setServerProperties() {
            Properties properties = new Properties();
            properties.put("mail.imap.host", host);
            properties.put("mail.imap.port", port);
            properties.put("mail.imap.starttls.enable", "true");
            properties.put("mail.store.protocol", "imaps");
            return properties;
        }

    }

    private String confirmCode;

    public String getConfirmCodeToGmailBox() throws MessagingException, IOException {

        PropertiesEmail propertiesEmail = new PropertiesEmail();
        Properties props = propertiesEmail.setServerProperties();

        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore("imaps");

        store.connect(propertiesEmail.host, propertiesEmail.user, propertiesEmail.password);

        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_WRITE);
        Message message = inbox.getMessage(inbox.getMessageCount());

        String messageContent = (String) message.getContent();

        Pattern pattern = Pattern.compile("\\b(?!(\\d)\\1{5})\\d{6}\\b");
        Matcher matcher = pattern.matcher(messageContent);
        if (matcher.find()) {
            confirmCode = matcher.group();

        } else {
            Reporter.log("Element  is not found");
        }
       return confirmCode;
    }
}