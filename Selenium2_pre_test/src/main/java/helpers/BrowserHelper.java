package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserHelper {
    public static WebDriver driver;

    public enum DriverType {CHROME, FIREFOX, EDGE}

    public static void startBrowser(DriverType driverType) {
        switch (driverType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=en-au");
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Constant.IMPLICITLY_TIME, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static void quitBrowser() {
        if (driver != null) {
            getDriver().quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void navigateToUrl(String url) {
        getDriver().get(url);
    }

    public static void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
