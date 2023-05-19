package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ContactUsPage;
import pages.base_abstract.FooterMenuPage;

public class BlockedPage extends FooterMenuPage<BlockedPage> {
    @FindBy(xpath = "//img[@src ='/images/error-illustration.svg']")
    private WebElement mainImage;
    @FindBy(xpath = "//p[@class='description']//a")
    private WebElement supportLink;
    public BlockedPage(WebDriver driver) {
        super(driver);
    }

    public BlockedPage createGeneric() {

        return new BlockedPage(getDriver());
    }
    @Step("Wait until to be visible main image on the /blocked page")
    public BlockedPage waitMainImageToBeVisible_BlockedPage() {
        wait10ElementToBeVisible(mainImage);
        return this;
    }
    @Step("After click Support link redirect to swisscows.com/contact  ")
    public ContactUsPage clickSupportLink() {
        click(supportLink);
        switchToAnotherWindow();
        return new ContactUsPage(getDriver());
    }

    public boolean mainImageIsDisplayed(){
        return isElementDisplayed(mainImage);
    }
}
