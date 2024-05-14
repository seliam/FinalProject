import junit.framework.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SearchResultsPage;
import static constants.Assertion.message1;

public class SearchFunctionalityTest extends BaseTest{

    @Test
    public void testSearchFunctionality() {
        homePage.clickOnSearchIcon();
        homePage.header.enterSearchKeyword("mac");
        SearchResultsPage searchResultsPage = homePage.header.clickSearchIt();
        for(int i = 0; i < searchResultsPage.getProductsCount(); i++){
            Assert.assertTrue(searchResultsPage.getProductName(i).toLowerCase().contains("mac"));
        }
    }
    @Test
    @Parameters("keyword")
    public void testInvalidSearch(String keyword){
        homePage.clickOnSearchIcon();
        homePage.header.enterSearchKeyword(keyword);
        SearchResultsPage searchResultsPage = homePage.header.clickSearchIt();
        String noResult = searchResultsPage.getNoResult();
        Assert.assertTrue(noResult.contains(message1));
    }
}
