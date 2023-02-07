package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.footer_menu.ContactUsPage;

public class ContactUsTest extends BaseTest {
    @Test
    public void testFormContactUs() {
        final String expectedSuccessMessage = "Thank you for contacting us!";
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();
        String actualURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickContactUsPageFooterMenu()
                .getCurrentURL();

        String actualSuccessMessage = contactUsPage
                .sendFormContactUs()
                .getThanksMessage();

        Assert.assertNotEquals(actualURL, oldURL);
        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);
    }

    @Test
    public void testContactUsButtonNavigateToCorrespondingPages() {
        final String expectedUrl = "https://dev.swisscows.com/en";
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        final String oldURL = openBaseURL().getCurrentURL();

        String newURL = new MainPage(getDriver())
                .scrollToFooter()
                .clickContactUsPageFooterMenu()
                .getCurrentURL();

        String actualUrl = contactUsPage
                .sendFormContactUs()
                .clickBackToSearchButton()
                .getCurrentURL();

        Assert.assertNotEquals(newURL, oldURL);
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void testPrivacyPolicyLinkNavigateToCorrespondingPages() {
        final String expectedUrl = "https://dev.swisscows.com/en/privacy";
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        String actualUrl = openBaseURL()
                    .scrollToFooter()
                    .clickContactUsPageFooterMenu()
                    .clickPrivacyPolicyLink()
                    .getCurrentURL();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

}
