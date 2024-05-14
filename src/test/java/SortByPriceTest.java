import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;


public class SortByPriceTest extends BaseTest{
    @Test
    public void testSortByPrice(){
        homePage.clickOnSearchIcon();
        homePage.header.enterSearchKeyword("iPhone");
        SearchResultsPage searchResultsPage = homePage.header.clickSearchIt();
        searchResultsPage.sortByPrice();
        int productCount = searchResultsPage.getProductsCount();
        for(int i = 0; i < productCount -1; i++){
            Assert.assertTrue(searchResultsPage.getPrice(i) >= searchResultsPage.getPrice(i +1));
        }
    }
}
