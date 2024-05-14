import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.SearchResultsPage;

import static constants.Assertion.message2;

public class RemoveFromCartTest extends BaseTest{
    @Test
    public void testRemove() throws InterruptedException {
        homePage.clickOnSearchIcon();
        homePage.header.enterSearchKeyword("mac");
        SearchResultsPage searchResultsPage = homePage.header.clickSearchIt();
        searchResultsPage.addToBasketClick(0);
        double price1 = searchResultsPage.getPrice(0);
        searchResultsPage.addToBasketClick(1);
        double price2 = searchResultsPage.getPrice(1);
        homePage.header.openBasket();
        CartPage cartPage = homePage.header.viewAndEditCart();
        Thread.sleep(3000);
        Assert.assertEquals(2, cartPage.basketProductCount());
        Assert.assertEquals(price1 + price2, cartPage.getSubTotal());
        cartPage.removeProduct(0);
        Assert.assertEquals(1, cartPage.basketProductCount());
        Thread.sleep(5000);
        Assert.assertEquals(price1, cartPage.getSubTotal());
        cartPage.removeProduct(0);
        Assert.assertTrue(cartPage.isCartEmpty());
        Assert.assertEquals( message2,cartPage.emptyCartMassege());
    }
}
