package pages;

import io.qase.api.annotation.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base_abstract.FooterMenuPage;
import pages.footer_menu.LoginPage;

public class NotFound404Page extends FooterMenuPage<NotFound404Page> {
    @FindBy(xpath =  "//a")
    private WebElement linkOf404Page;
    public NotFound404Page(WebDriver driver) {
        super(driver);
    }
    public NotFound404Page createGeneric() {

        return new NotFound404Page(getDriver());
    }
    @Step("Open site 404 page")
    public NotFound404Page open404PageAccount() {
        getDriver().get("https://accounts.dev.swisscows.com//");
        return new NotFound404Page (getDriver());
    }
    @Step("Click Start page link ")
    public LoginPage clickStartPageLink(){
        click(linkOf404Page);
        return new LoginPage(getDriver());
    }
}
