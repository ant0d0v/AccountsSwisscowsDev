package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import io.qase.api.annotation.QaseTitle;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.footer_menu.LoginPage;
import pages.sidebar_menu.ProfilePage;
import utils.ProjectConstants;

import java.util.List;

public class DeleteAccountTest extends BaseTest {
    @Test(priority = 1)
    @QaseTitle(" Verify that the image is displayed in the delete account popup")
    @QaseId(value = 1410)
    public void testImageIsDysplaedOfDeleteAccountPopup() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDeleteButton()
                .waitVisibleImageInDeleteAccountPopup();

        Assert.assertTrue(profilePage.mainImageOfDeleteAccountPopup());
    }

    @Test(priority = 2)
    @QaseTitle("Verify that the 'No, I've changed my mind' link in the delete account popup works correctly")
    @QaseId(value = 1411)
    public void testLink_No_I_ve_changed_my_mind_OfDeleteAccountPopup() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDeleteButton()
                .clickLinkInPopup();

        Assert.assertFalse(profilePage.isPopupPresent(),"Popup is present");
    }

    @Test(priority = 3)
    @QaseTitle("Verify the text displayed in the delete account popup")
    @QaseId(value = 1414)
    public void testCheckTextDeleteAccountPopup() {
        ProfilePage profilePage = new ProfilePage(getDriver());
        final String expectedH1Text = "Delete account";
        final List<String> expectedDescriptionText = List.of(
                "This will permanently delete your account and all of its data. You will not be able to reactivate this account."
        );
        final String actualH1Text = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDeleteButton()
                .getH1TextOfPopup();

        final String actualFontSizeH1Text = profilePage.getFontSizeH1TextOfPopup();
        final List<String> actualFontSizeDescription = profilePage.getDescriptionTextOfDeletePopup();

        Assert.assertEquals(actualH1Text, expectedH1Text);
        Assert.assertEquals(actualFontSizeDescription,expectedDescriptionText);
        Assert.assertEquals(actualFontSizeH1Text, ProjectConstants.FONT_SIZES_H1_TEXT_OF_POPUP);
    }
    @Test(priority = 4)
    @QaseTitle("Verify the account deletion for Swisscows user.")
    @QaseId(value = 1415)
    public void testDeleteOfAccount_SwisscowsUser() {
        LoginPage loginPage = new LoginPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDeleteButton()
                .clickDeleteButtonInPopup()
                .waitMainImageToBeVisible_LoginPage();

        Assert.assertTrue(loginPage.getCurrentURL().contains(ProjectConstants.URL_LOGIN_PAGE));
        Assert.assertEquals(loginPage.getH1Text(), ProjectConstants.H1_TEXT_LOGIN_PAGE);
    }
    @Test(priority = 5)
    @QaseTitle("Verify login error message for deleting an account of Swisscows user")
    @QaseId(value = 1417)
    public void testLoginToDeleteAccount_SwisscowsUser() {
        final String expectedValidationError = "The email or password is invalid";

        final String actualValidationError = openLoginURL()
                .enterNewUserEmail(ProjectConstants.SWISSCOWS_EMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton()
                .getTextValidationErrorMessage();

        Assert.assertEquals(actualValidationError, expectedValidationError);
    }
    @Test(priority = 6)
    @QaseTitle("Verify the account deletion for External user")
    @QaseId(value = 1416)
    public void testDeleteOfAccount_ExternalUser() {
        LoginPage loginPage = new LoginPage(getDriver());

        openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton_Dashboard()
                .waitLogoInSidebarToBeVisible()
                .clickProfileIconInSidebar()
                .clickDeleteButton()
                .clickDeleteButtonInPopup()
                .waitMainImageToBeVisible_LoginPage();

        Assert.assertTrue(loginPage.getCurrentURL().contains(ProjectConstants.URL_LOGIN_PAGE));
        Assert.assertEquals(loginPage.getH1Text(), ProjectConstants.H1_TEXT_LOGIN_PAGE);
    }
    @Test(priority = 7)
    @QaseTitle("Verify login error message for deleting an account of External user")
    @QaseId(value = 1418)
    public void testLoginToDeleteAccount_ExternalUser() {
        final String expectedValidationError = "The email or password is invalid";

        final String actualValidationError = openLoginURL()
                .enterNewUserEmail(ProjectConstants.GMAIL_USER)
                .enterNewUserPassword(ProjectConstants.NEW_PASSWORD)
                .clickLoginButton()
                .getTextValidationErrorMessage();

        Assert.assertEquals(actualValidationError, expectedValidationError);
    }

}
