package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import pages.base_abstract.SidebarMenuPage;

public class SwisscowsEmailStandardPage extends SidebarMenuPage<SwisscowsEmailStandardPage> {
    public SwisscowsEmailStandardPage(WebDriver driver) {

        super(driver);
    }

    public SwisscowsEmailStandardPage createGeneric() {

        return new SwisscowsEmailStandardPage(getDriver());
    }
}
