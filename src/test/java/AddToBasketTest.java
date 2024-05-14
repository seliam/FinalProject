import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.SearchResultsPage;

public class AddToBasketTest extends BaseTest{
    @Test
    public void testAddToBasket(){
        homePage.clickOnSearchIcon();
        homePage.header.enterSearchKeyword("mac");
        SearchResultsPage searchResultsPage = homePage.header.clickSearchIt();
        searchResultsPage.addToBasketClick(0);
        String productName = searchResultsPage.getProductName(0);
        homePage.header.openBasket();
        Assert.assertEquals(1,homePage.header.basketProductCount());
        String basketProductName = homePage.header.basketProductName(0);
        Assert.assertEquals(productName,basketProductName);

        searchResultsPage.addToBasketClick(1);
        String productName1 = searchResultsPage.getProductName(1);
        homePage.header.openBasket();
        Assert.assertEquals(2,homePage.header.basketProductCount());
        String basketProductName1 = homePage.header.basketProductName(0);
        Assert.assertEquals(productName1,basketProductName1);
        basketProductName = homePage.header.basketProductName(1);
        Assert.assertEquals(productName,basketProductName);
    }
}
