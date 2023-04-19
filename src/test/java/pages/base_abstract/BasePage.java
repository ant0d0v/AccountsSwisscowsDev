package pages.base_abstract;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import pages.footer_menu.CharityProjectPage;

import javax.mail.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Thread.sleep;

public abstract class BasePage {
    private WebDriver driver;
    private WebDriverWait webDriverWait20;
    private WebDriverWait webDriverWait10;
    private Actions actions;
    private String code;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait10() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait5() {
        if (webDriverWait10 == null) {
            webDriverWait10 = new WebDriverWait(driver, Duration.ofSeconds(5));
        }

        return webDriverWait10;
    }

    protected WebDriverWait getWait20() {
        if (webDriverWait20 == null) {
            webDriverWait20 = new WebDriverWait(driver, Duration.ofSeconds(20));
        }

        return webDriverWait20;
    }

    protected Actions getActions() {
        if (actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }


    public String getTitle() {

        return getDriver().getTitle();
    }

    public String getCurrentURL() {

        return getDriver().getCurrentUrl();
    }

    public String getFormattedURL(String expectedURL) {

        return getDriver().getCurrentUrl().substring(0, 37);
    }

    protected String getText(WebElement element) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getText();
    }

    protected List<String> getTexts(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> textList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    textList.add(element.getText());
                }
            }

            return textList;
        }

        return new ArrayList<>();
    }


    protected List<String> getTrimmedTexts(List<WebElement> elements) {
        List<String> texts = new ArrayList<>();

        for (WebElement element : elements) {
            texts.add(getText(element).trim());
        }

        return texts;
    }

    public String getAttribute(WebElement element, String attribute) {
        if (!element.getText().isEmpty()) {
            wait10ElementToBeVisible(element);
        }

        return element.getAttribute(attribute);
    }

    public List<String> getAttributeOfElements(List<WebElement> inputs, String attribute) throws InterruptedException {

        List<String> attributeList = new ArrayList<>();

        for (WebElement input : inputs) {
            if (input.isEnabled() && input.isDisplayed()) {
                attributeList.add(input.getAttribute(attribute));

            }

        }
        return attributeList;
    }


    protected String getBackgroundColor(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("color");
    }

    protected String getBackgroundHoverColor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true, cancelable: true}));", element);
        wait10ElementToBeVisible(element);
        return element.getCssValue("background-color");
    }

    protected List<String> getColors(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> colorsList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    colorsList.add(element.getCssValue("color"));
                }
            }

            return colorsList;
        }

        return new ArrayList<>();
    }

    protected List<String> getFontSizes(List<WebElement> list) {
        if (list.size() > 0) {
            getWait20().until(ExpectedConditions.visibilityOfAllElements(list));
            List<String> FontSizeList = new ArrayList<>();
            for (WebElement element : list) {
                if (element.isEnabled() && element.isDisplayed()) {
                    FontSizeList.add(element.getCssValue("font-size"));
                }
            }

            return FontSizeList;
        }

        return new ArrayList<>();
    }

    protected String getBackgroundColorInHEX(WebElement element) {

        return Color.fromString(getBackgroundColor(element)).asHex();
    }

    protected String getFontSize(WebElement element) {
        wait10ElementToBeVisible(element);

        return element.getCssValue("font-size");
    }

    public int getListSize(List<WebElement> list) {

        return list.size();
    }

    protected void click(WebElement element) {
        wait10ElementToBeVisible(element);
        wait10ElementToBeClickable(element).click();
    }

    protected void clickElementUntilInvisible(WebElement element) {
        while (element.isEnabled() && element.isDisplayed()) {
            clickByJavaScript(element);
        }

    }

    protected void click20(WebElement element) {
        wait20ElementToBeVisible(element);
        wait20ElementToBeClickable(element).click();
    }

    protected void clickByJavaScript(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void clickEnter(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ENTER);
    }

    protected void clickArrowUp(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(Keys.ARROW_UP);
    }

    protected void clickAllElementsInList(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);

        for (WebElement element : allElements) {
            if (element.isEnabled() && element.isDisplayed()) {
                wait10ElementToBeVisible(element);
                wait10ElementToBeClickable(element);
                clickByJavaScript(element);
            } else {
                Reporter.log("Element " + element + " is not visible or not clickable ", true);
            }
        }
    }

    protected void clear(WebElement element) {

        element.clear();
    }


    protected void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();

    }

    public List<String> getBackgroundHoverColorsOfElements(List<WebElement> buttons) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        List<String> colorList = new ArrayList<>();

        for (WebElement button : buttons) {
            actions.moveToElement(button).build().perform();
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("background-color"));

            }

        }
        return colorList;
    }

    public List<String> getSrcOfElements(List<WebElement> images) {
        List<String> colorList = new ArrayList<>();

        for (WebElement image : images) {
            if (image.isEnabled() && image.isDisplayed()) {
                colorList.add(image.getAttribute("src"));

            }

        }
        return colorList;
    }

    public List<String> getHoverColorsOfElements(List<WebElement> buttons) throws InterruptedException {
        Actions actions = new Actions(getDriver());
        List<String> colorList = new ArrayList<>();

        for (WebElement button : buttons) {
            actions.moveToElement(button).build().perform();
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("color"));

            }

        }
        return colorList;
    }

    public List<String> getBackgroundColorsOfElements(List<WebElement> buttons) throws InterruptedException {

        List<String> colorList = new ArrayList<>();

        for (WebElement button : buttons) {
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("background-color"));

            }

        }
        return colorList;
    }

    public List<String> getColorsOfElements(List<WebElement> buttons) throws InterruptedException {

        List<String> colorList = new ArrayList<>();

        for (WebElement button : buttons) {
            if (button.isEnabled() && button.isDisplayed()) {
                colorList.add(button.getCssValue("color"));

            }

        }
        return colorList;
    }


    protected void input(String text, WebElement element) {

        element.sendKeys(text);
    }

    protected void inputActions(String text, WebElement element) {
        Actions actions = new Actions(driver);

        actions.click(element).perform();

        actions.sendKeys(text).perform();
    }

    protected void inputJavaScript(String text, WebElement element) {

        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
        javaScriptExecutor.executeScript("arguments[0].value='" + text + "';", element);
    }
    protected void clearJavaScript( WebElement element) {

        JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) getDriver();
        javaScriptExecutor.executeScript("arguments[0].value = '';", element);

    }

    protected void inputAfterClear(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected void setWindowDimensions(int width, int height) {
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    public void switchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();

        for (String windowHandle : getDriver().getWindowHandles()) {
            if (!originalWindow.equals(windowHandle) && getDriver().getWindowHandles().size() == 2) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }


    protected void scrollByVisibleElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void scroll() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,6000)");
    }

    protected void goBack() {

        getDriver().navigate().back();
    }

    public void refreshPage() {

        getDriver().navigate().refresh();
    }

    protected void selectOption(WebElement element, String text) {
        Select option = new Select(element);
        option.selectByValue(text);
    }

    protected void waitForTextNotToBeEmpty(WebElement element) {
        while (element.getText() == null || element.getText().length() < 1) {
            getWait20().until(ExpectedConditions
                    .not(ExpectedConditions.textToBePresentInElement(element, "")));
        }
    }

    protected void wait10ElementToBeVisible(WebElement element) {
        getWait10().until(ExpectedConditions.visibilityOf(element));
    }

    protected void wait10ElementToBeInVisible(WebElement element) {
        getWait10().until(ExpectedConditions.invisibilityOf(element));
    }

    protected void wait10ElementToBeEmpty(WebElement element) {
        getWait10().until(ExpectedConditions.textToBePresentInElement(element, ""));
    }

    protected void wait20ElementToBeVisible(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement wait10ElementToBeClickable(WebElement element) {

        return getWait10().until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement wait20ElementToBeClickable(WebElement element) {

        return getWait20().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForUrlContains(String text) {
        getWait10().until(ExpectedConditions.urlContains(text));
    }

    protected void waitTextToBeChanged(WebElement element, String text) {
        getWait20().until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(element, text)));
    }

    protected boolean isElementDisplayed(WebElement element) {

        return element.isDisplayed();
    }


    protected boolean areElementsInListDisplayed(List<WebElement> list) {
        boolean result = false;

        for (WebElement element : list) {
            if (element.isDisplayed()) {
                result = true;
            } else {

                return false;
            }
        }

        return result;
    }

    protected boolean areAllElementsVisibleAndClickable(List<WebElement> elements) {
        List<WebElement> allElements = new ArrayList<>(elements);
        int elementsSize = elements.size();
        int count = 0;

        for (WebElement checkedElement : allElements) {
            if (checkedElement.isEnabled() && checkedElement.isDisplayed()) {
                wait10ElementToBeClickable(checkedElement);
                count++;
            }
        }

        return elementsSize == count;
    }

    public void waitForElementIsDisappeared(WebElement element) {
        getWait20().until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForElementIsInvisible(WebElement element) {
        getWait20().until(ExpectedConditions.invisibilityOf(element));
    }

    public String getClassAttribute(WebElement element) {

        return getAttribute(element, "class");
    }

    public void switchToExternalPage() {
        switchToAnotherWindow();
        getWait20().until(ExpectedConditions.numberOfWindowsToBe(2));
    }


    public void screen(String name) throws IOException {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshotsVideo/" + name));
        new CharityProjectPage(getDriver());
    }

    public List<WebElement> getAllHTTPSLinks(List<WebElement> allLinks) {
        List<WebElement> linksList = new ArrayList<>();

        for (WebElement link : allLinks) {
            if (link.getAttribute("protocol").equals("https:")) {
                linksList.add(link);
            }
        }
        return linksList;
    }
    public int getMessageCountToGmailBox() throws MessagingException, IOException, InterruptedException {
        sleep(7000);
        class PropertiesEmail {
            public final String host = "imap.gmail.com";
            public final String user = "qaengineer1203@gmail.com";
            public final String password = "hmcmhkutozxsxdvq"; //cqhfpzuosufpxfcp
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

    public String getCodeFromGmailBox() throws MessagingException, IOException, InterruptedException {

        class PropertiesEmail {
            public final String host = "imap.gmail.com";
            public final String user = "qaengineer1203@gmail.com";
            public final String password = "hmcmhkutozxsxdvq"; //cqhfpzuosufpxfcp
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
}



