package page_objects;

import elements.Button;
import elements.Label;
import helpers.BrowserHelper;
import helpers.Constant;
import org.openqa.selenium.By;

public class YoutubePage {
    private final Label lblTitle = new Label(By.xpath("//h1[@class='title style-scope ytd-video-primary-info-renderer']"));
    private final Button btnPlay = new Button(By.xpath("//button[@class='ytp-play-button ytp-button']"));
    private final Label lblCurrentTime = new Label(By.cssSelector("span.ytp-time-current"));

    public String getVideoTitle() {
        return lblTitle.getText();
    }

    public String getCurrentPlayTime() {
        return lblCurrentTime.getText();
    }

    public void clickPlayButton() {
        btnPlay.click();
    }

    public void playAndPauseVideoAfterMilliseconds(long millis) {
        btnPlay.waitUntilElementExist(Constant.SHORT_TIME);
        clickPlayButton();
        BrowserHelper.pause(millis);
        clickPlayButton();
    }
}
