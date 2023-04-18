package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.accounts.ProfilePage;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;

public class ProfileTest extends BaseTest {
    @Test(priority = 1)
    public void testChangePasswordForExternalUser_ProfilePage() throws InterruptedException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        final String oldUrl  = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getCurrentURL();

        final String newUrl  = profilePage
                .clickButtonСhangePassword()
                .enterNewUserCredentials()
                .clickConfirmButton()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitAllWidgetsToBeVisible()
                .getCurrentURL();

        Assert.assertEquals(profilePage.getTitle(),ProjectConstants.TITLE_DASHBOARD_PAGE);
        Assert.assertNotEquals(oldUrl,newUrl);

    }
    @Test(priority = 2)
    public void testChangePasswordForSwisscowsUser_ProfilePage() {
        ProfilePage profilePage = new ProfilePage(getDriver());

        final String oldUrl  = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getCurrentURL();

        final String newUrl  = profilePage
                .clickButtonСhangePassword()
                .enterNewUserCredentials()
                .clickConfirmButton()
                .waitMainImageToBeVisible_LoginPage()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitAllWidgetsToBeVisible()
                .getCurrentURL();

        Assert.assertEquals(profilePage.getTitle(),ProjectConstants.TITLE_DASHBOARD_PAGE);
        Assert.assertNotEquals(oldUrl,newUrl);

    }
    @Test(priority = 3)
    public void testChangeAlternateEmailForSwisscowsUser_ProfilePage() throws InterruptedException, MessagingException, IOException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final String code  = profilePage
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail(ProjectConstants.GMAIL_USER)
                .clickConfirmButton_ConfirmPage()
                .getConfirmCodeFromGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValueAlternateEmail();

        Assert.assertEquals(actualAttribute,"qaengineer1203@gmail.com");
    }
    @Test(priority = 4)
    public void testChangeAlternateEmailForExternalUser_ProfilePage() throws InterruptedException, MessagingException, IOException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final String code  = profilePage
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail(ProjectConstants.NEW_GMAIL_USER)
                .clickConfirmButton_ConfirmPage()
                .getCodeFromNewGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValueAlternateEmail();

        Assert.assertEquals(actualAttribute,"a.udovychenko1203@gmail.com");

    }
    @Test(priority = 5)
    public void testChangePhoneNumberForExternalUser_ProfilePage() throws InterruptedException, MessagingException, IOException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final String code  = profilePage
                .clickButtonСhangePhoneNumber()
                .enterPhoneNumber(ProjectConstants.PHONE_NUMBER)
                .clickConfirmButton_ConfirmPage()
                .getConfirmCodeFromGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValuePhoneNumber();

        Assert.assertEquals(actualAttribute,"+380993484583");

    }
    @Test(priority = 6)
    public void testChangeNicknameForSwisscowsUser_ProfilePage() {

        final String actualNickname = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeNickname()
                .enterNickname("Test")
                .clickButtonSaveChanges()
                .getValueNickname();

        Assert.assertEquals(actualNickname,"Test");

    }
    @Test(priority = 7)
    public void testChangeNicknameForExternalUser_ProfilePage() {

        final String actualNickname = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeNickname()
                .enterNickname("Anton Udovychenko")
                .clickButtonSaveChanges()
                .getValueNickname();

        Assert.assertEquals(actualNickname,"Anton Udovychenko");

    }

    @Test(priority = 8,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
    public void testChangeLocalisationForExternalUser_ProfilePage(
            int index, String expectedH1Text) throws InterruptedException {
        ProfilePage profilePage = new  ProfilePage(getDriver());

        final String oldH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getH1Text();
        profilePage
                .clickLangInDropdownOfLanguages(index);

        final String actualH1text = profilePage
                .getH1Text();

        Assert.assertNotEquals( oldH1text, actualH1text);
        Assert.assertEquals( actualH1text, expectedH1Text);
    }
    @Test(priority = 9,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
    public void testChangeLocalisationForSwisscowsUser_ProfilePage(
            int index, String expectedH1Text) throws InterruptedException {
        ProfilePage profilePage = new  ProfilePage(getDriver());

        final String oldH1text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getH1Text();
        profilePage
                .clickLangInDropdownOfLanguages(index);


        final String actualH1text = profilePage
                .getH1Text();
        Assert.assertNotEquals( oldH1text, actualH1text);
        Assert.assertEquals( actualH1text, expectedH1Text);
    }
}
