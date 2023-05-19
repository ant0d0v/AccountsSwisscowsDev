package pages.footer_menu;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;

public class UserNotFoundPage extends FooterMenuPage<UserNotFoundPage> {
    @FindBy(xpath = "//img[@src ='/images/error-illustration.svg']")
    private WebElement mainImage;
    public  UserNotFoundPage(WebDriver driver) {
        super(driver);
    }

    public  UserNotFoundPage createGeneric() {

        return new  UserNotFoundPage(getDriver());
    }
    @Step("Wait until to be visible main image on the /user not found page")
    public UserNotFoundPage waitMainImageToBeVisible_UserNotFoundPage() {
        wait10ElementToBeVisible(mainImage);
        return this;
    }
    public boolean mainImageIsDisplayed(){
        return isElementDisplayed(mainImage);
    }

}
