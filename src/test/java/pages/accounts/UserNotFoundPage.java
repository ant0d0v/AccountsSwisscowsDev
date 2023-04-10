package pages.accounts;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class UserNotFoundPage extends FooterMenuPage<UserNotFoundPage> {

    public  UserNotFoundPage(WebDriver driver) {
        super(driver);
    }

    public  UserNotFoundPage createGeneric() {

        return new  UserNotFoundPage(getDriver());
    }
}
