package pages.sidebar_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.SidebarMenuPage;

import java.util.List;

public class MethodCardPage extends SidebarMenuPage<MethodCardPage> {
    @FindBy(xpath = "//div[@class ='product plans']//button")
    private List<WebElement> buttonsOfProductsPlan;
    @FindBy(xpath = "//div[@class='method'][1]")
    private WebElement cardMethod;
    @FindBy(xpath = "//div[@class='method'][2]")
    private WebElement payPalMethod;

    public MethodCardPage(WebDriver driver) {

        super(driver);
    }

    public MethodCardPage createGeneric() {

        return new MethodCardPage(getDriver());
    }
}
