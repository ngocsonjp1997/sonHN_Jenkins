package page_objects;

import elements.Label;
import elements.TextBox;
import helpers.BrowserHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {
    private final TextBox txtSearch = new TextBox(By.cssSelector(".gLFyf.gsfi"));
    private final Label lblMainResult = new Label(By.cssSelector(".LC20lb.MMgsKf"));

    public List<WebElement> getListPeopleAlsoAsk() {
        return BrowserHelper.getDriver().findElements(By.xpath("//h3[@class='O3JH7 diAzE qLBFXd fnYJle']//following-sibling::div[@jsname='N760b']//div[@jsname='Cpkphb']"));
    }

    public List<WebElement> getListVideo() {
        return BrowserHelper.getDriver().findElements(By.xpath("//div[@class='FzCfme']//preceding-sibling::div//div"));
    }

    public void search(String keyword) {
        txtSearch.clear();
        txtSearch.enter(keyword);
        txtSearch.enter(Keys.ENTER);
    }

    public boolean doesMainResultContainKeyword(String keyword) {
        if (lblMainResult.getText().toLowerCase().contains(keyword.toLowerCase())) {
            return true;
        }
        return false;
    }

    public boolean doesPeopleAlsoAskContainKeyWord(String keyword) {
        for (WebElement element : getListPeopleAlsoAsk()) {
            if (element.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean doesVideoContainKeyWord(String keyword) {
        for (WebElement element : getListVideo()) {
            if (element.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public String getFirstVideoTitle() {
        String lblResult = lblMainResult.getText();
        lblResult = lblResult.substring(0, lblResult.length() - 10);
        return lblResult;
    }

    public void openFirstVideo() {
        this.lblMainResult.click();
    }
}
