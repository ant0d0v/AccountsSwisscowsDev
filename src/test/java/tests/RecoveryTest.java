package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.RecoveryPage;

import java.util.List;

public class RecoveryTest extends BaseTest {
    @Test
    public void testHoverSubmitButton_WelcomePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitForUrlContains("https://accounts.dev.swisscows.com/recovery");

        final List<String> colorButtonWithoutHover =recoveryPage
                .enterPhoneNumber()
                .getColorButton();

        final List<String> colorButtonWhenHover = recoveryPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    public void testMainImageIsDisplayed_RecoveryPage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage();


        Assert.assertTrue(recoveryPage.imageIsDisplayedRecoveryPage());

    }
    @Test
    public void testSelectAnyCountryInDropDown_RecoveryPage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedValuePhoneNumber = "+1684";
        final String expectedAttributeCountry = "/images/icons.svg#american-samoa";

        final String actualValuePhoneNumber = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .clickDropdownCountry()
                .clickCountryInDropDown()
                .getValueOfInputPhoneNumber();


        Assert.assertEquals(actualValuePhoneNumber,expectedValuePhoneNumber);
        Assert.assertEquals(recoveryPage.getCountryAttribute(),expectedAttributeCountry);
        Assert.assertTrue(recoveryPage.flagImageIsDisplayedRecoveryPage());

    }
    @Test
    public void testListEqualSearchCriteriaInDropDownCountry_RecoveryPage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String query = "V";

        final List<String> actualSearchCriteria = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .clickDropdownCountry()
                .enterSearchCriteriaInDropdownCountry()
                .getListCountryDropDown();

        final int sizeSearchCriteria = recoveryPage.getListCountryDropDown().size();

        for (String searchCriteria : actualSearchCriteria) {
            Assert.assertTrue(sizeSearchCriteria > 0);
            Assert.assertTrue(searchCriteria.contains(query));

        }

    }
    @Test
    public void testListOfDropDownCountry_RecoveryPage() throws InterruptedException {
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

        final List<String> actualCountryList = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .clickDropdownCountry()
                .getListCountryDropDown();


        final int sizeDropDownCountryList = recoveryPage.getListCountryDropDown().size();

        Assert.assertEquals(sizeDropDownCountryList,236);
        Assert.assertEquals(actualCountryList,expectedCountryList);

    }
    @Test
    public void testValidationErrorMessageInvalidPhoneNumber_RecoveryPage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "The phone number is invalid";

        final String actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .enterInvalidPhoneNumber()
                .getValidationMessageError();

        recoveryPage
                .clickSubmitButton();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);
        Assert.assertTrue(recoveryPage.isErrorImageIsDisplayed());

    }
    @Test
    public void testH1Text_RecoveryPage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final  String expectedH1Text = "Recovery options";
        final List<String> expectedFontSizesH1text = List.of(
                "30px"
        );

        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .getH1Text();



        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(recoveryPage.getH1FontSizes(), expectedFontSizesH1text);

    }
    @Test
    public void testLinkInTheFooterNavigateToCorrespondingPage_RecoveryPage(){
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage();

        final String oldUrl = recoveryPage.getCurrentURL();

        final String newUrl = recoveryPage
                .clickLinkInTheFooterMenu()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(recoveryPage.getCurrentURL(), "https://accounts.dev.swisscows.com/login");

    }
}
