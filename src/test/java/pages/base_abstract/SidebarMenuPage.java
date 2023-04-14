package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class SidebarMenuPage<Generic> extends BasePage{
    @FindBy(xpath = "//img")
    private List<WebElement> allImageOnPage;
    public SidebarMenuPage(WebDriver driver) {
        super(driver);
    }

    public abstract Generic createGeneric();


}
