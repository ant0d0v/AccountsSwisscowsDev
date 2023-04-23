package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

public class EmailStandardPage extends SidebarMenuPage<EmailStandardPage> {

    public EmailStandardPage(WebDriver driver) {

        super(driver);
    }

    public EmailStandardPage createGeneric() {

        return new EmailStandardPage(getDriver());
    }



}
