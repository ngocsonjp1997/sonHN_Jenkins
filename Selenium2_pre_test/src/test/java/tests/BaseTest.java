package tests;

import helpers.Constant;
import helpers.BrowserHelper;
import helpers.LogHelper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;

public class BaseTest {
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(@Optional("chrome") String browser, Method method) {
        BrowserHelper.startBrowser(BrowserHelper.DriverType.valueOf(browser.toUpperCase()));
        LogHelper.startTestCase(method.getName());
        LogHelper.info("1. Navigate to Google page");
        BrowserHelper.navigateToUrl(Constant.GOOGLE_URL);
    }

    @AfterMethod
    public void afterMethod() {
        LogHelper.endTestCase();
        BrowserHelper.quitBrowser();
    }
}
