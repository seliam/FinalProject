package constants;

import org.openqa.selenium.By;

public class Locators {
    public static final By searchButton = By.id("searchToggle");
    public static final By searchIt = By.xpath("//*[@id=\"block-search\"]/div/section/div/section[1]/button[2]");
    public static final By searchWrite = By.id("search");
    public static final By basket = By.cssSelector("#html-body > div.page-wrapper > header > div > div.header-sub > div > a");
    public static final By priceButton = By.cssSelector("#sorter > option:nth-child(2)");
    public static final By productName = By.className("product-item-name");
    public static final By products = By.cssSelector("li[class=\"item product product-item\"]");
    public static final By addToBasketButton = By.cssSelector("[title=\"Add to Basket\"]");
    public static final By basketProductName = By.cssSelector("strong[class=\"product-item-name\"] > a");
    public static final By price = By.cssSelector("span[id*=\"product-price\"] > span");
    public static final By trash = By.cssSelector("[title=\"Remove item\"]");
    public static final By emptySearchResult = By.id("tabs-amasty_search_products_tab");
    public static final By cookies = By.id("cookieConsentButton");
    public static final By subTotal = By.cssSelector("#minicart-content-wrapper > div.block-content > div.subtotal > div > span > span");
    public static final By viewAndEditButton = By.cssSelector("a[class=\"action viewcart\"] > span");
    public static final By cartPageProducs = By.cssSelector("tbody[class=\"cart item\"]");
    public static final By cartPageProductTitle = By.cssSelector("div.product-item-details > strong > a");
    public static final By cartPageTrash = By.cssSelector("div.actions-toolbar > [title=\"Remove item\"]");
    public static final By cartPageTotalPrice = By.cssSelector("strong > span.price");
    public static final By emptyCart = By.cssSelector("div.cart-empty>p");
}