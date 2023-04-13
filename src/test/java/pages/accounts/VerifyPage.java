package pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VerifyPage extends FooterMenuPage<VerifyPage> {
    @FindBy(xpath = "//div[@role='button']")
    private WebElement codeConfirm;
    @FindBy(xpath = "//button[@class = 'btn-submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class ='buttons']//button")
    private List<WebElement> allNumbers;
    @FindBy(xpath = "//p[@class ='description']//b")
    private WebElement numberInDescription;
    @FindBy(xpath = "//p[@class ='description'][2]")
    private WebElement description;
    @FindBy(xpath = "//img[@src='/images/robot-illustration.svg']")
    private WebElement mainImage;


    public VerifyPage(WebDriver driver) {
        super(driver);
    }

    public VerifyPage createGeneric() {

        return new VerifyPage(getDriver());
    }

    public void clickMaxNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (WebElement listItem : allNumbers) {
            int number = Integer.parseInt(getText(listItem));
            numbers.add(number);
        }
        int maxNumber = Collections.max(numbers);
        WebElement maxNumberElement = getDriver().findElement(By.xpath("//div[@class ='buttons']//button[text()='" + maxNumber + "']"));
        click20(maxNumberElement);
    }
    public void clickMinNumber() {
        List<Integer> numbers = new ArrayList<>();
        for (WebElement listItem : allNumbers) {
            int number = Integer.parseInt(getText(listItem));
            numbers.add(number);
        }
        int maxNumber = Collections.min(numbers);
        WebElement minNumberElement = getDriver().findElement(By.xpath("//div[@class ='buttons']//button[text()='" + maxNumber + "']"));
        click20(minNumberElement);
    }
    public void clickNumberInDescription() {

        String numberInTheDescription = getText(numberInDescription);
        WebElement numberElement = getDriver().findElement(By.xpath("//div[@class ='buttons']//button[text()='" + numberInTheDescription + "']"));
        click20(numberElement);

    }
    public RecoveryPage resolveCaptcha() {
        String descriptionText = getText(description);
        if (descriptionText.contains("Please press the number ")) {
            clickNumberInDescription();
        }
            if (descriptionText.contains("Please choose the highest number from the following:")) {
                clickMaxNumber();
            }
            if (descriptionText.contains("Please choose the lowest number from the following:")) {
                clickMinNumber();
            }

        return new RecoveryPage(getDriver());
    }
    public VerifyPage waitMainImageToBeVisible_VerifyPage(){
        waitForUrlContains("https://accounts.dev.swisscows.com/verify");
        wait10ElementToBeVisible(mainImage);

        return new VerifyPage(getDriver());
    }
    public boolean imageIsDisplayedVerifyPage() {

        return isElementDisplayed(mainImage);
    }
    public int getListNumber() {
        return getListSize(allNumbers);
    }

}

