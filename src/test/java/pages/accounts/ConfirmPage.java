package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import pages.base_abstract.FooterMenuPage;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public class ConfirmPage extends FooterMenuPage<ConfirmPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@class = 'btn-submit'][text()='Confirm']")
    private WebElement submitButtonInThePopup;
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
    @FindBy(xpath = "//div[@id='desktop-menu']//li[@class='user-li']/a")
    private WebElement signInTopMenu;
    @FindBy(xpath = "//div//p")
    private WebElement descriptionConfirmPage;
    @FindBy(xpath = "//img[@src='/images/verification-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//button[@class='link']")
    private WebElement linkIdidntGetCode;
    @FindBy(xpath = "//div[@class='content-box loading']")
    private WebElement preloader;

    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmPage createGeneric() {

        return new ConfirmPage(getDriver());
    }
    public ConfirmPage enterCode(String code) {
        click(codeConfirm);
        inputActions(code, codeConfirm);
        return this;
    }

    public WelcomePage clickSubmitButton() {
        click(submitButton);

        return new WelcomePage(getDriver());
    }
    public ProfilePage clickSubmitButtonInThePopup() {
        click(submitButtonInThePopup);

        return new ProfilePage(getDriver());
    }
    public String getConfirmCodeFromGmailBox () throws MessagingException, IOException, InterruptedException {
        return  getCodeFromGmailBox();
    }
    public String getDescriptionConfirmPage() {
        return getText(descriptionConfirmPage);
    }
    public ConfirmPage waitUntilMainImageToBeVisibly() {
        wait10ElementToBeVisible(mainImage);
        return this;
    }
    public boolean imageIsDisplayedConfirmPage() {

        return isElementDisplayed(mainImage);
    }
    public int getMessageCountToNewGmailBox() throws MessagingException, IOException, InterruptedException {
        sleep(7000);
        class PropertiesEmail {
            public final String host = "imap.gmail.com";
            public final String user = "a.udovychenko1203@gmail.com";
            public final String password = "efsbabphzkolqroa"; //cqhfpzuosufpxfcp
            final int port = 993;

            public Properties setServerProperties() {
                Properties properties = new Properties();
                properties.put("mail.imap.host", host);
                properties.put("mail.imap.port", port);
                properties.put("mail.imap.starttls.enable", "true");
                properties.put("mail.store.protocol", "imaps");
                return properties;
            }

        }

        PropertiesEmail propertiesEmail = new PropertiesEmail();
        Properties props = propertiesEmail.setServerProperties();

        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore("imaps");

        store.connect(propertiesEmail.host, propertiesEmail.user, propertiesEmail.password);

        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);

        return inbox.getMessageCount();

    }
    private String code;
    public String getCodeFromNewGmailBox() throws MessagingException, IOException, InterruptedException {

        class PropertiesEmail {
            public final String host = "imap.gmail.com";
            public final String user = "a.udovychenko1203@gmail.com";
            public final String password = "efsbabphzkolqroa"; //cqhfpzuosufpxfcp
            final int port = 993;

            public Properties setServerProperties() {
                Properties properties = new Properties();
                properties.put("mail.imap.host", host);
                properties.put("mail.imap.port", port);
                properties.put("mail.imap.starttls.enable", "true");
                properties.put("mail.store.protocol", "imaps");
                return properties;
            }

        }

        PropertiesEmail propertiesEmail = new PropertiesEmail();
        Properties props = propertiesEmail.setServerProperties();

        Session session = Session.getDefaultInstance(props);
        Store store = session.getStore("imaps");

        store.connect(propertiesEmail.host, propertiesEmail.user, propertiesEmail.password);

        Folder inbox = store.getFolder("inbox");
        inbox.open(Folder.READ_ONLY);

        int messageCount = inbox.getMessageCount();

        while (true) {
            sleep(5000);

            inbox = store.getFolder("inbox");
            inbox.open(Folder.READ_WRITE);
            int newMessageCount = inbox.getMessageCount();

            if (newMessageCount > messageCount) {
                Reporter.log("New message received!");
                Message[] messages = inbox.getMessages(messageCount + 1, newMessageCount);
                for (Message message : messages) {
                    String messageContent = (String) message.getContent();
                    Pattern pattern = Pattern.compile("\\b(?!(\\d)\\1{5})\\d{6}\\b");
                    Matcher matcher = pattern.matcher(messageContent);
                    if (matcher.find()) {
                        code = matcher.group();
                        return code;
                    } else {
                        Reporter.log("Code  is not found");
                    }
                }
                messageCount = newMessageCount;
            } else {
                Reporter.log("New message  is not found");
            }
        }

    }
    public ConfirmPage clickLinkLinkIdidntGetCode() throws InterruptedException {
        click20(linkIdidntGetCode);
        wait10ElementToBeVisible(preloader);
        return new  ConfirmPage (getDriver());
    }
}