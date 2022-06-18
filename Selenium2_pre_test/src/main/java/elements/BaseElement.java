package elements;

import helpers.LogHelper;
import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {
    private final By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement findElement() {
        return BrowserHelper.getDriver().findElement(locator);
    }

    public List<WebElement> findElements() {
        return BrowserHelper.getDriver().findElements(locator);
    }

    public void click() {
        try {
            findElement().click();
        } catch (WebDriverException e) {
            LogHelper.error(e.getMessage());
        }
    }

    public void enter(CharSequence... value) {
        try {
            findElement().sendKeys(value);
        } catch (WebDriverException e) {
            LogHelper.error(e.getMessage());
        }
    }

    public String getText() {
        try {
            return findElement().getText();
        } catch (WebDriverException e) {
            LogHelper.error(e.getMessage());
        }
        return null;
    }

    public void clear() {
        try {
            findElement().clear();
        } catch (WebDriverException e) {
            LogHelper.error(e.getMessage());
        }
    }

    public String getAttribute(String name) {
        try {
            return findElement().getAttribute(name);
        } catch (WebDriverException e) {
            LogHelper.error(e.getMessage());
        }
        return null;
    }

    public boolean isDisplayed() {
        try {
            return findElement().isDisplayed();
        } catch (NoSuchElementException e) {
            LogHelper.error("Element is not displayed! More info: " + e.getMessage());
            return false;
        }
    }

    public boolean isEmpty() {
        return !findElements().isEmpty();
    }

    public boolean isEnabled() {
        return findElement().isEnabled();
    }

    public boolean isSelected() {
        return findElement().isSelected();
    }

    public void waitUntilElementExist(int seconds) {
        WebDriverWait wait = new WebDriverWait(BrowserHelper.getDriver(), seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
