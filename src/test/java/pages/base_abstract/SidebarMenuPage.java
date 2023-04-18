package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.accounts.ProfilePage;
import utils.ProjectConstants;

import java.util.List;

public abstract class SidebarMenuPage<Generic> extends FooterMenuPage{
    @FindBy(xpath = "//img")
    private List<WebElement> allImageOnPage;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement profileIcon;
    @FindBy(xpath = "//li[2]//a[@href='/profile']")
    private WebElement buttonСhangePassword;

    public SidebarMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();
    public ProfilePage clickProfileIconInSidebar(){
        click20(profileIcon);
        waitForUrlContains(ProjectConstants.URL_PROFILE_PAGE);
        return new ProfilePage(getDriver());
    }



}
