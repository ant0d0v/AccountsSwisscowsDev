package pages.accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class BlockedPage extends FooterMenuPage<BlockedPage> {
    @FindBy(xpath = "//img[@src ='/images/error-illustration.svg']")
    private WebElement mainImage;
    public BlockedPage(WebDriver driver) {
        super(driver);
    }

    public BlockedPage createGeneric() {

        return new BlockedPage(getDriver());
    }
    public BlockedPage waitMainImageToBeVisible_BlockedPage() {
        wait10ElementToBeVisible(mainImage);
        return this;
    }
}
