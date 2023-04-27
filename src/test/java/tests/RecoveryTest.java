package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.accounts.RecoveryPage;
import utils.ProjectConstants;

import java.util.List;

public class RecoveryTest extends BaseTest {
    @Test
    @QaseId(value = 1025)
    public void testHoverSubmitButton_WelcomePage() throws InterruptedException {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitForUrlContains(ProjectConstants.URL_RECOVERY_PAGE);

        final List<String> colorButtonWithoutHover =recoveryPage
                .enterPhoneNumber()
                .getColorButton();

        final List<String> colorButtonWhenHover = recoveryPage
                .getColorButtonWhenHover();

        Assert.assertNotEquals(colorButtonWhenHover, colorButtonWithoutHover);
    }
    @Test
    @QaseId(value = 1040)
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
    @QaseId(value = 1028)
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
    @QaseId(value = 1043)
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
    @QaseId(value = 1041)
    public void testListOfDropDownCountry_RecoveryPage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final List<String> expectedCountryList = ProjectConstants.LIST_OF_COUNTRY;

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
    @QaseId(value = 1030)
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
    @QaseId(value = 1026)
    public void testH1Text_RecoveryPage() {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());

        final String actualH1Text = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .getH1Text();



        Assert.assertEquals(actualH1Text,ProjectConstants.H1_TEXT_RECOVERY_PAGE);
        Assert.assertEquals(recoveryPage.getH1FontSizes(), ProjectConstants.FONT_SIZES_H1_TEXT);

    }
    @Test
    @QaseId(value = 1024)
    public void testLinkInTheFooterNavigateToCorrespondingPage_RecoveryPage(){
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());

        final String oldUrl = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUserCredentialsForSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .getCurrentURL();

        final String newUrl = recoveryPage
                .clickLinkInTheFooterMenu()
                .getCurrentURL();

        Assert.assertNotEquals(oldUrl, newUrl);
        Assert.assertEquals(recoveryPage.getCurrentURL(), ProjectConstants.URL_LOGIN_PAGE);

    }
    @Test
    @QaseId(value = 1032)
    public void testPhoneNumberAlreadyRegistered_RecoveryPage()  {
        RecoveryPage recoveryPage = new RecoveryPage(getDriver());
        final String expectedTextValidationError = "This phone number has already been used to activate another account."
                + " Please, use another phone number.";

        final String actualTextValidationError = openLoginURL()
                .clickLinkInTheFooterMenu()
                .enterUnconfirmedAccountSwisscowsUser()
                .clickAllCheckboxesRegisterPage()
                .clickRegisterButtonForSwisscowsUser()
                .waitMainImageToBeVisible_RecoveryPage()
                .enterAlreadyRegisteredPhoneNumber()
                .clickSubmitButton_RecoveryPage()
                .getValidationMessageError();

        Assert.assertEquals(actualTextValidationError,expectedTextValidationError);
        Assert.assertTrue(recoveryPage.isErrorImageIsDisplayed());
    }
}
