package pages.accounts;
import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class RecoveryMethodPage extends FooterMenuPage<RecoveryMethodPage> {

    public  RecoveryMethodPage(WebDriver driver) {
        super(driver);
    }

    public  RecoveryMethodPage createGeneric() {

        return new  RecoveryMethodPage(getDriver());
    }
}
