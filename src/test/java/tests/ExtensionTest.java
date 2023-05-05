package tests;

import base.BaseTest;
import io.qase.api.annotation.QaseId;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sidebar_menu.EmailStandardBuyPlanIdPage;
import utils.ProjectConstants;

public class ExtensionTest extends BaseTest {
    @Test
    public void testLoginToExtension(){
        openExtension();
    }
}
