package tests;

import helpers.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.GooglePage;
import helpers.LogHelper;

public class Testcase1_VerifySearchPage extends BaseTest {
    GooglePage googlePage = new GooglePage();

    @Test(description = "Testcase 01 - Verify the search page")
    public void Test01_Verify_Search_Page() {
        LogHelper.info("2. Input and search keyword:");
        googlePage.search(Constant.SEARCH_KEYWORD);

        LogHelper.info("3. Verify main result contains keyword:");
        Assert.assertTrue(googlePage.doesMainResultContainKeyword(Constant.SEARCH_KEYWORD), "Main result not contain keyword!");

        LogHelper.info("4. Verify people also ask result contains keyword:");
        Assert.assertTrue(googlePage.doesPeopleAlsoAskContainKeyWord(Constant.SEARCH_KEYWORD), "People Also Ask not contain keyword!");

        LogHelper.info("5. Verify video result contains keyword:");
        Assert.assertTrue(googlePage.doesVideoContainKeyWord(Constant.SEARCH_KEYWORD), "Video not contain keyword!");
    }
}
