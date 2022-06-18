package tests;

import helpers.Constant;
import helpers.LogHelper;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GooglePage;
import page_objects.YoutubePage;

public class Testcase2_ValidateYoutubeResult extends BaseTest {
    GooglePage googlePage = new GooglePage();
    YoutubePage youtubePage = new YoutubePage();

    @Test(description = "Testcase 02 - Validate Youtube Result")
    public void Test02_Validate_Youtube_Result() {
        LogHelper.info("2. Input and search keyword:");
        googlePage.search(Constant.SEARCH_KEYWORD);
        String titleOnGoogleResult = googlePage.getFirstVideoTitle();

        LogHelper.info("3. Open 1st Youtube video result:");
        googlePage.openFirstVideo();

        LogHelper.info("4. Play the video and pause after 10 seconds:");
        youtubePage.playAndPauseVideoAfterMilliseconds(Constant.TIME_MILLISECONDS);

        String titleOnYoutubePage = youtubePage.getVideoTitle();
        LogHelper.info("5. Verify the video title is same to Google result:");
        Assert.assertEquals(titleOnGoogleResult, titleOnYoutubePage, "Title on Google Result and Title on Youtube page is not match!");

        String currentPlayTime = youtubePage.getCurrentPlayTime();
        LogHelper.info("6. Verify the video is played/ paused accordingly:");
        Assert.assertEquals(currentPlayTime, Constant.STOP_TIME, "Video is not played accordingly!");
    }
}
