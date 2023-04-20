package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestData;
import pages.accounts.ConfirmPage;
import pages.accounts.ProfilePage;
import pages.accounts.RecoveryPage;
import utils.ProjectConstants;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

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
                .enterPhoneNumber(ProjectConstants.PHONE_NUMBER)
                .clickConfirmButton_ConfirmPage()
                .getMessageCountToGmailBox();

        profilePage
                .clickLinkInPopup();
        final int newCountMessage = confirmPage
                .getMessageCountToGmailBox();

        Assert.assertNotEquals(newCountMessage,oldCountMessage);

    }
    @Test(priority = 7)
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
                .enterPhoneNumber(ProjectConstants.PHONE_NUMBER)
                .clickConfirmButton_ConfirmPage()
                .getConfirmCodeFromGmailBox();

        final String actualAttribute = confirmPage
                .enterCode(code)
                .clickSubmitButtonInThePopup()
                .getValuePhoneNumber();

        Assert.assertEquals(actualAttribute,"+380993484583");

    }

    @Test(priority = 8)
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
    @Test(priority = 9)
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

    @Test(priority = 10,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
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
    @Test(priority = 11,dataProvider = "LangProfilePageTestData", dataProviderClass = TestData.class)
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
    @Test(priority = 12)
    public void testChangeAvatarForExternalUser_ProfilePage() throws InterruptedException {
        ProfilePage profilePage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("1.png")
                .waitUntilImageToBeChanged()
                .clickButtonSaveChanges();

        Assert.assertTrue(profilePage.avatarIsDysplaed());

    }
    @Test(priority = 13)
    public void testChangeAvatarForSwisscowsUser_ProfilePage() throws InterruptedException {
        ProfilePage profilePage = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("2.jpg")
                .waitUntilImageToBeChanged()
                .clickButtonSaveChanges();

        Assert.assertTrue(profilePage.avatarIsDysplaed());


    }

    @Test(priority = 14)
    public void testChangeAvatarUsingLargeSizeImage_ProfilePage() {
        final String actualErrorText = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .changeAvatar("largesize.jpeg")
                .getValidationText();

        Assert.assertEquals(actualErrorText,"Image size should not exceed 2 MB");


    }
    @Test(priority = 15)
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
    public void testChangeRegionAndRefreshPageForSwisscowsUser_ProfilePage() {
        final String actualRegion = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .selectSwitzerlandRegion()
                .clickButtonSaveChanges()
                .getRegionValue();

        Assert.assertEquals(actualRegion,"Switzerland (DE)");

    }
    @Test(priority = 20)
    public void testChangeRegionAndRefreshPageForExternalUser_ProfilePage() {
        final String actualRegion = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDropdownRegion()
                .selectSwitzerlandRegion()
                .clickButtonSaveChanges()
                .getRegionValue();

        Assert.assertEquals(actualRegion,"Switzerland (DE)");

    }
    @Test(priority = 21)
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
    public void testListOfDropDownCountryOfPopupPhoneNumber_ProfilePage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final List<String> expectedCountryList = List.of(
                "Afghanistan(+93)", "Aland Islands(+358)", "Albania(+355)", "Algeria(+213)", "American Samoa(+1684)",
                "Andorra(+376)", "Angola(+244)", "Anguilla(+1264)", "Antarctica(+672)", "Antigua and Barbuda(+1268)","Argentina(+54)",
                "Armenia(+374)", "Aruba(+297)", "Australia(+61)","Austria(+43)", "Azerbaijan(+994)", "Bahamas(+1242)",
                "Bahrain(+973)","Bangladesh(+880)","Barbados(+1246)", "Belarus(+375)", "Belgium(+32)","Belize(+501)",
                "Benin(+229)", "Bermuda(+1441)", "Bhutan(+975)", "Bolivia(+591)", "Bosnia and Herzegovina(+387)", "Botswana(+267)",
                "Brazil(+55)", "British Indian Ocean Territory(+246)", "Brunei Darussalam(+673)", "Bulgaria(+359)", "Burkina Faso(+226)",
                "Burundi(+257)", "Cambodia(+855)", "Cameroon(+237)", "Canada(+1)", "Cape Verde(+238)", "Cayman Islands(+ 345)",
                "Central African Republic(+236)", "Chad(+235)", "Chile(+56)", "China(+86)", "Christmas Islands(+61)",
                "Cocos Islands(+61)", "Colombia(+57)", "Comoros(+269)", "Congo(+242)", "Cook Islands(+682)", "Costa Rica(+506)",
                "Cote d'Ivoire(+225)", "Croatia(+385)","Cuba(+53)", "Cyprus(+357)","Czech Republic(+420)", "Denmark(+45)",
                "Djibouti(+253)", "Dominica(+1767)","Dominican Republic(+1849)", "Ecuador(+593)", "Egypt(+20)","El Salvador(+503)",
                "Equatorial Guinea(+240)", "Eritrea(+291)", "Estonia(+372)","Ethiopia(+251)", "Falkland Islands(+500)",
                "Faroe Islands(+298)", "Fiji(+679)", "Finland(+358)", "France(+33)","French Polynesia(+689)", "Gabon(+241)",
                "Gambia(+220)", "Georgia(+995)","Germany(+49)", "Ghana(+233)", "Gibraltar(+350)","Greece(+30)", "Greenland(+299)",
                "Grenada(+1473)", "Guam(+1671)","Guatemala(+502)", "Guernsey(+44)", "Guinea(+224)","Guinea-Bissau(+245)",
                "Guyana(+595)","Haiti(+509)","Vatican(+379)","Honduras(+504)","Hong Kong(+852)","Hungary(+36)", "Iceland(+354)",
                "India(+91)", "Indonesia(+62)","Iran(+98)","Iraq(+964)", "Ireland(+353)","Isle of Man(+44)", "Israel(+972)",
                "Italy(+39)", "Jamaica(+1876)", "Japan(+81)","Jersey(+44)", "Jordan(+962)", "Kazakhstan(+77)", "Kenya(+254)",
                "Kiribati(+686)", "Democratic People's Republic of Korea(+850)", "South Korea(+82)", "Kuwait(+965)",
                "Kyrgyzstan(+996)","Laos(+856)", "Latvia(+371)","Lebanon(+961)", "Lesotho(+266)", "Liberia(+231)",
                "Libyan Arab Jamahiriya(+218)", "Liechtenstein(+423)", "Lithuania(+370)", "Luxembourg(+352)", "Macao(+853)",
                "Macedonia(+389)","Madagascar(+261)", "Malawi(+265)", "Malaysia(+60)", "Maldives(+960)","Mali(+223)",
                "Malta(+356)", "Marshall Islands(+692)","Martinique(+596)", "Mauritania(+222)", "Mauritius(+230)",
                "Mayotte(+262)", "Mexico(+52)", "Micronesia(+691)", "Moldova(+373)", "Monaco(+377)","Mongolia(+976)",
                "Montenegro(+382)", "Montserrat(+1664)", "Morocco(+212)","Mozambique(+258)", "Myanmar(+95)", "Namibia(+264)",
                "Nauru(+674)", "Nepal(+977)","Netherlands(+31)", "New Caledonia(+687)", "New Zealand(+64)", "Nicaragua(+505)",
                "Niger(+227)","Nigeria(+234)", "Niue(+683)", "Norfolk Island(+672)", "Mauritus(+1670)","Norway(+47)",
                "Oman(+968)", "Pakistan(+92)", "Palau(+680)", "Palestinian Territory(+970)", "Panama(+507)", "Papua New Guinea(+675)",
                "Paraguay(+595)", "Peru(+51)", "Philippines(+63)","Pitcairn(+872)", "Poland(+48)", "Portugal(+351)",
                "Puerto Rico(+1939)", "Qatar(+974)", "Romania(+40)", "Russia(+7)", "Rwanda(+250)", "Reunion(+262)",
                "Saint Barthelemy(+590)", "Saint Helena(+290)", "Saint Kitts and Nevis(+1869)", "Saint Lucia(+1758)",
                "Saint Martin(+590)", "Saint Pierre and Miquelon(+508)", "Saint Vincent and the Grenadines(+1784)",
                "Samoa(+685)", "San Marino(+378)", "Sao Tome and Principe(+239)", "Saudi Arabia(+966)", "Senegal(+221)",
                "Serbia(+381)", "Seychelles(+248)", "Sierra Leone(+232)", "Singapore(+65)", "Slovakia(+421)", "Slovenia(+386)",
                "Solomon Islands(+677)", "Somalia(+252)", "South Africa(+27)", "South Sudan(+211)", "South Georgia(+500)",
                "Spain(+34)", "Sri Lanka(+94)", "Sudan(+249)", "Suriname(+597)", "Svalbard and Jan Mayen(+47)", "Swaziland(+268)",
                "Sweden(+46)", "Switzerland(+41)", "Syrian(+963)", "Taiwan(+886)", "Tajikistan(+992)", "Tanzania(+255)",
                "Thailand(+66)", "Timor-Leste(+670)", "Togo(+228)", "Tokelau(+690)", "Tonga(+676)", "Trinidad and Tobago(+1868)",
                "Tunisia(+216)", "Turkey(+90)", "Turkmenistan(+993)", "Tuvalu(+688)", "Uganda(+256)","Ukraine(+380)",
                "United Arab Emirates(+971)", "United Kingdom(+44)", "United States(+1)", "Uruguay(+598)", "Uzbekistan(+998)",
                "Vanuatu(+678)", "Venezuela(+58)", "Vietnam(+84)", "Virgin Islands US(+1340)", "Wallis and Futuna(+681)",
                "Yemen(+967)", "Zambia(+260)", "Zimbabwe(+263)"


        );

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
    public void testMainImageIsDisplayed_RecoveryPage() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickButtonChangePhoneNumber()
                .waitMainImageToBeVisibleOfRPopupPhoneNumber();


        Assert.assertTrue(profilePage.mainImageOfRPopupPhoneNumberIsDysplaed());

    }
    @Test(priority = 32)
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
}
