package pages;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.FooterMenuPage;

public class ExtensionPage extends FooterMenuPage<ExtensionPage> {
    public ExtensionPage(WebDriver driver) {
        super(driver);
    }
    public ExtensionPage createGeneric() {

        return new ExtensionPage(getDriver());
    }

}
