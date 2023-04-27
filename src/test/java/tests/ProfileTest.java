package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.openqa.selenium.devtools.v85.profiler.model.Profile;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.sidebar_menu.DashboardPage;
import pages.sidebar_menu.ProfilePage;
import pages.accounts.RecoveryPage;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class ProfileTest extends BaseTest {
    @Test(priority = 1)
    @QaseId(value = 1169)
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
                .clickButtonChangePassword()
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
    @QaseId(value = 1170)
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
                .clickButtonChangePassword()
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
    @QaseId(value = 1175)
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
                .getCodeFromGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValueAlternateEmail();

        Assert.assertEquals(actualAttribute,"qaengineer1203@gmail.com");
    }
    @Test(priority = 4)
    public void testLink_IdidntGetCode_SendCodeToEmail_ProfilePage() throws InterruptedException, MessagingException, IOException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final int oldCountMessage  = profilePage
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail(ProjectConstants.NEW_GMAIL_USER)
                .clickConfirmButton_ConfirmPage()
                .getMessageCountNewGmailBox();

        profilePage
                .clickLinkInPopup();
        final int newCountMessage = confirmPage
                .getMessageCountNewGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);

    }
    @Test(priority = 5)
    @QaseId(value = 1172)
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
    @Test(priority = 6)
    @QaseId(value = 1171)
    public void testLink_IdidntGetCode_SendCodeToPhoneNumber_ProfilePage() throws InterruptedException, MessagingException, IOException {
        ProfilePage profilePage = new ProfilePage(getDriver());
        ConfirmPage confirmPage = new ConfirmPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final int oldCountMessage  = profilePage
                .clickButtonChangePhoneNumber()
                .enterPhoneNumber(ProjectConstants.NEW_PHONE_NUMBER)
                .clickConfirmButton_ConfirmPage()
                .getMessageCountToGmailBox();

        profilePage
                .clickLinkInPopup();
        final int newCountMessage = confirmPage
                .getMessageCountToGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);

    }

    @Test(priority = 7)
    @QaseId(value = 1177)
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
    @Test(priority = 8)
    @QaseId(value = 1176)
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
    @Test(priority = 9)
    @QaseId(value = 1173)
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
                .clickButtonChangePhoneNumber()
                .enterPhoneNumber(ProjectConstants.NEW_PHONE_NUMBER)
                .clickConfirmButton_ConfirmPage()
                .getCodeFromGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValuePhoneNumber();

        Assert.assertEquals(actualAttribute,ProjectConstants.NEW_PHONE_NUMBER);

    }

    @Test(priority = 10,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
    @QaseId(value = 1178)
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

        profilePage.clickLangInDropdownOfLanguages(index);

        final String actualH1text = profilePage
                .getH1Text();

        Assert.assertNotEquals( oldH1text, actualH1text);
        Assert.assertEquals( actualH1text, expectedH1Text);
    }
    @Test(priority = 11,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
    @QaseId(value = 1179)
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

        profilePage.clickLangInDropdownOfLanguages(index);

        final String actualH1text = profilePage
                .getH1Text();
        Assert.assertNotEquals( oldH1text, actualH1text);
        Assert.assertEquals( actualH1text, expectedH1Text);
    }
    @Test(priority = 12)
    @QaseId(value = 1180)
    public void testChangeAvatarForExternalUser_ProfilePage() throws InterruptedException {
        ProfilePage profilePage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("target/avatar/1.png")
                .waitUntilImageToBeChanged()
                .clickButtonSaveChanges();

        Assert.assertTrue(profilePage.avatarIsDysplaed());

    }
    @Test(priority = 13)
    @QaseId(value = 1181)
    public void testChangeAvatarForSwisscowsUser_ProfilePage() throws InterruptedException {
        ProfilePage profilePage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("target/avatar/2.jpg")
                .waitUntilImageToBeChanged()
                .clickButtonSaveChanges();

        Assert.assertTrue(profilePage.avatarIsDysplaed());


    }

    @Test(priority = 14)
    @QaseId(value = 1182)
    public void testChangeAvatarUsingLargeSizeImage_ProfilePage() {
        final String actualErrorText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("target/avatar/largesize.jpeg")
                .getValidationText();

        Assert.assertEquals(actualErrorText,"Image size should not exceed 2 MB");


    }
    @Test(priority = 15)
    @QaseId(value = 1183)
    public void testDeleteAvatar_ProfilePage() {
        ProfilePage profilePage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickAvatar()
                .clickDeleteButtonInPopupAvatar()
                .clickButtonSaveChanges();

        Assert.assertFalse(profilePage.isImagePresent());


    }
    @Test(priority = 16)
    @QaseId(value = 1184)
    public void testH1textOfPopupAvatar_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());

        final String expectedH1Text = "Your image";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickAvatar()
                .getH1TextOfPopup();


        Assert.assertEquals(actualH1Text,expectedH1Text);
        Assert.assertEquals(profilePage.getFontSizeH1TextOfPopup(),"20px");

    }
    @Test(priority = 17)
    @QaseId(value = 1185)
    public void testH2text_ProfilePage() {
        final List<String> expectedH2Text = List.of(
                "Here you can manage your account details",
                "Basic Information",
                "Contact Information",
                "Your password",
                "Delete account"
        );
        final List actualH2Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getH2Texts();

        Assert.assertEquals(actualH2Text,expectedH2Text);


    }
    @Test(priority = 18)
    @QaseId(value = 1186)
    public void testH2textFontSizes_ProfilePage() {
        final List<String> expectedH2TextFontSizes = List.of(
                "16px",
                "20px",
                "20px",
                "20px",
                "20px"
        );
        final List actualH2TextFontSizes = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .getH2FontSizes();

        Assert.assertEquals(actualH2TextFontSizes,expectedH2TextFontSizes);


    }
    @Test(priority = 19)
    @QaseId(value = 1189)
    public void testChangeRegionAndRefreshPageForSwisscowsUser_ProfilePage() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .selectSwitzerlandRegion()
                .clickButtonSaveChanges()
                .refreshProfilePage();

        final String actualRegion = dashboardPage
                .clickSubscriptionIcon()
                .clickProfileIconInSidebar()
                .getRegionValue();


        Assert.assertEquals(actualRegion,"Switzerland (DE)");

    }
    @Test(priority = 20)
    @QaseId(value = 1187)
    public void testChangeRegionAndRefreshPageForExternalUser_ProfilePage() {

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .selectSwitzerlandRegion()
                .clickButtonSaveChanges()
                .refreshProfilePage()
                .getRegionValue();

        final String actualRegion = dashboardPage
                .clickSubscriptionIcon()
                .clickProfileIconInSidebar()
                .getRegionValue();

        Assert.assertEquals(actualRegion,"Switzerland (DE)");

    }
    @Test(priority = 21)
    @QaseId(value = 1188)
    public void testListOfDropDownRegion_ProfilePage() {
        final List<String> expectedListOfRegion = List.of(
                "Argentina", "Australia", "Austria", "Belgium (FR)", "Belgium (NL)", "Brazil", "Canada (EN)",
                "Canada (FR)","Chile", "China", "Denmark", "Finland", "France", "Germany", "Hong Kong SAR", "Hungary",
                "India", "Italy", "Japan", "Kazakhstan", "Korea", "Latvia", "Malaysia", "Mexico", "Netherlands", "New Zealand",
                "Nigeria", "Norway", "Philippines", "Poland", "Portugal", "Russia", "Saudi Arabia", "South Africa", "Spain",
                "Sweden", "Switzerland (DE)", "Switzerland (FR)", "Taiwan", "Turkey", "Ukraine", "United Kingdom", "United States (EN)",
                "United States (ES)"
        );
        final List actualListOfRegion = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .getListOfRegion();

        Assert.assertEquals(actualListOfRegion.size(),44);
        Assert.assertEquals(actualListOfRegion,expectedListOfRegion);

    }
    @Test(priority = 22)
    @QaseId(value = 1190)
    public void testListEqualSearchCriteriaInDropDownRegion_ProfilePage() {
        ProfilePage profilePage = new  ProfilePage(getDriver());

        final String query = "United";
        final List<String> actualListOfRegion = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .enterSearchCriteriaInDropdownRegion()
                .getListOfRegion();

        final int sizeSearchCriteria = profilePage.getListOfRegion().size();

        for (String searchCriteria : actualListOfRegion) {
            Assert.assertTrue(sizeSearchCriteria > 0);
            Assert.assertTrue(searchCriteria.contains(query));

        }
    }
    @Test(priority = 23)
    @QaseId(value = 1188)
    public void testListOfDropDownCountryOfPopupPhoneNumber_ProfilePage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final List<String> expectedCountryList = ProjectConstants.LIST_OF_COUNTRY;

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final List<String> actualCountryList = recoveryPage
                .clickDropdownCountry()
                .getListCountryDropDown();


        Assert.assertEquals(actualCountryList.size(),236);
        Assert.assertEquals(actualCountryList,expectedCountryList);
    }
    @Test(priority = 24)
    @QaseId(value = 1192)
    public void testValidationErrorMessageInvalidPhoneNumberOfPopupPhoneNumber_ProfilePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());

        final String expectedTextValidationError = "The phone number is invalid";

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final String actualTextValidationError = recoveryPage
                .enterInvalidPhoneNumber()
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 25)
    @QaseId(value = 1194)
    public void testSelectAnyCountryInDropDownOfPopupPhoneNumber_ProfilePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedValuePhoneNumber = "+1684";
        final String expectedAttributeCountry = "/images/icons.svg#american-samoa";

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final String actualValuePhoneNumber = recoveryPage
                .clickDropdownCountry()
                .clickCountryInDropDown()
                .getValueOfInputPhoneNumber();


        Assert.assertEquals(actualValuePhoneNumber,expectedValuePhoneNumber);
        Assert.assertEquals(recoveryPage.getCountryAttributeInPopup(),expectedAttributeCountry);
        Assert.assertTrue(recoveryPage.flagImageIsDisplayedRecoveryPage());

    }
    @Test(priority = 26)
    @QaseId(value = 1195)
    public void testListEqualSearchCriteriaInDropDownCountryOfPopupPhoneNumber_ProfilePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String query = "V";

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final List<String> actualSearchCriteria = recoveryPage
                .clickDropdownCountry()
                .enterSearchCriteriaInDropdownCountry()
                .getListCountryDropDown();

        final int sizeSearchCriteria = recoveryPage.getListCountryDropDown().size();

        for (String searchCriteria : actualSearchCriteria) {
            Assert.assertTrue(sizeSearchCriteria > 0);
            Assert.assertTrue(searchCriteria.contains(query));

        }

    }
    @Test(priority = 27)
    @QaseId(value = 1193)
    public void testPhoneNumberAlreadyRegisteredOfPopupPhoneNumber_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "This phone number has already been used to activate another account."
                + " Please, use another phone number.";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final String actualTextValidationError = recoveryPage
                .enterAlreadyRegisteredPhoneNumber()
                .clickSubmitButton_RecoveryPage()
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 28)
    @QaseId(value = 1196)
    public void testH1textOfPopupPhoneNumber_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());

        final String expectedH1Text = "Phone number";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber()
                .getH1TextOfPopup();


        Assert.assertEquals(actualH1Text,expectedH1Text);
        Assert.assertEquals(profilePage.getFontSizeH1TextOfPopup(),"24px");

    }
    @Test(priority = 29)
    @QaseId(value = 1197)
    public void testClosePopupPhoneNumberUsingLinkCancel_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber()
                .clickLinkInPopup();

        Assert.assertFalse(profilePage.isPopupPresent());


    }
    @Test(priority = 30)
    @QaseId(value = 1157)
    public void testHoverConfirmButtonOfPopupPhoneNumber_ProfilePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber();

        final List<String> colorButtonWithoutHover = recoveryPage
                .enterPhoneNumber()
                .getColorButton();

        final List<String> colorButtonWhenHover = recoveryPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test(priority = 31)
    @QaseId(value = 1198)
    public void testMainImageIsDisplayedOfPopupPhoneNumber_ProfilePage() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber()
                .waitMainImageToBeVisibleOfRPopupPhoneOrEmail();


        Assert.assertTrue(profilePage.mainImageOfRPopupPhoneOrEmailIsDysplaed());

    }
    @Test(priority = 32)
    @QaseId(value = 1212)
    public void testHoverSaveButton_ProfilePage() throws InterruptedException {
        ProfilePage profilePage =new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar();

        final List colorButtonWithoutHover = profilePage
                .getColorButton();

        final List colorButtonWhenHover = profilePage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test(priority = 33)
    @QaseId(value = 1199)
    public void testH1textOfPopupChangePassword_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());

        final String expectedH1Text = "Change password";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword()
                .getH1TextOfPopup();


        Assert.assertEquals(actualH1Text,expectedH1Text);
        Assert.assertEquals(profilePage.getFontSizeH1TextOfPopup(),"24px");

    }
    @Test(priority = 34)
    @QaseId(value = 1200)
    public void testHoverConfirmButtonOfPopupChangePassword_ProfilePage() throws InterruptedException {
        ProfilePage profilePage =new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword();

        final List colorButtonWithoutHover = profilePage
                .getColorButton();

        final List colorButtonWhenHover = profilePage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test(priority = 35)
    @QaseId(value = 1201)
    public void testIncorrectCurrentPasswordOfPopupChangePassword_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The current password is incorrect";
         openLoginURL()
                 .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                 .enterNewUserPassword(ProjectConstants.PASSWORD)
                 .clickLoginButton_Dashboard()
                 .waitLogoInSidebarToBeVisible()
                 .clickProfileIconInSidebar()
                 .clickButtonChangePassword()
                 .enterCurrentPassword(ProjectConstants.NEW_PASSWORD)
                 .enterNewPassword(ProjectConstants.NEW_PASSWORD)
                 .enterRepeatNewPassword(ProjectConstants.NEW_PASSWORD)
                 .clickConfirmButton();

        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 36)
    @QaseId(value = 1202)
    public void testInvalidNewPasswordOfPopupChangePassword_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The password must contain at least 8 characters, including letters and numbers";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword()
                .enterCurrentPassword("123")
                .enterNewPassword(ProjectConstants.NEW_PASSWORD)
                .enterRepeatNewPassword(ProjectConstants.NEW_PASSWORD)
                .clickConfirmButton();

        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 37)
    @QaseId(value = 1203)
    public void testInvalidRepeatPasswordOfPopupChangePassword_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The password must contain at least 8 characters, including letters and numbers";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword()
                .enterCurrentPassword(ProjectConstants.PASSWORD)
                .enterNewPassword("123")
                .enterRepeatNewPassword("123")
                .clickConfirmButton();

        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 38)
    @QaseId(value = 1204)
    public void testIncorrectConfirmPasswordOfPopupChangePassword_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The password confirmation doesn't match";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword()
                .enterCurrentPassword(ProjectConstants.PASSWORD)
                .enterNewPassword(ProjectConstants.NEW_PASSWORD)
                .enterRepeatNewPassword(ProjectConstants.NEW_PASSWORD + "1")
                .clickConfirmButton();

        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 39)
    @QaseId(value = 1205)
    public void testMainImageIsDisplayedOfPopupChangePassword_ProfilePage() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePassword()
                .waitMainImageToBeVisibleOfRPopupChangePassword();


        Assert.assertTrue(profilePage.mainImageOfRPopupChangePasswordIsDysplaed());

    }
    @Test(priority = 40)
    @QaseId(value = 1206)
    public void testInvalidAlternateEmailOfPopupAlternateEmail_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The email address is invalid";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail("test@@gmail.com");


        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 41)
    @QaseId(value = 1207)
    public void testEnterSwisscowsAlternateEmail_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The email address is invalid";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail("test@swisscows.email")
                .clickConfirmButton_ConfirmPage();


        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 42)
    @QaseId(value = 1208)
    public void testEnterAlreadyRegisteredAlternateEmail_ProfilePage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "This email has already been used to activate another account. Please, use another email address.";
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .enterAlternateEmail(ProjectConstants.NEW_GMAIL_USER)
                .clickConfirmButton_ConfirmPage();


        final String actualTextValidationError = recoveryPage
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);

    }
    @Test(priority = 43)
    @QaseId(value = 1209)
    public void testH1textOfPopupAlternateEmail_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());

        final String expectedH1Text = "Alternate email";
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .getH1TextOfPopup();


        Assert.assertEquals(actualH1Text,expectedH1Text);
        Assert.assertEquals(profilePage.getFontSizeH1TextOfPopup(),"24px");

    }
    @Test(priority = 44)
    @QaseId(value = 1210)
    public void testMainImageIsDisplayedOfPopupAlternateEmail_ProfilePage() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .waitMainImageToBeVisibleOfRPopupPhoneOrEmail();


        Assert.assertTrue(profilePage.mainImageOfRPopupPhoneOrEmailIsDysplaed());

    }
    @Test(priority = 45)
    @QaseId(value = 1211)
    public void testClosePopupAlternateEmailUsingLinkCancel_ProfilePage()  {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangeAlternateEmail()
                .clickLinkInPopup();

        Assert.assertFalse(profilePage.isPopupPresent());


    }

}
