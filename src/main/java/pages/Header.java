package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static constants.Locators.*;
public class Header extends BasePage{
    private final WebDriver driver;
    private final WebDriverWait wait;

    public Header(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void setSearchWrite(String searchsth){
        driver.findElement(searchWrite).sendKeys(searchsth);
    }
    public void enterSearchKeyword(String keyword) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchWrite)));
        driver.findElement(searchWrite).clear();
        setSearchWrite(keyword);
    }
    public SearchResultsPage clickSearchIt(){
        wait.until(ExpectedConditions.elementToBeClickable(searchIt)).click();
        return new SearchResultsPage(driver);
    }
    public void openBasket(){
        wait.until(ExpectedConditions.elementToBeClickable(basket)).click();
    }
    public String basketProductName(int index ){
        List<WebElement> products = driver.findElements(basketProductName);
        return products.get(index).getText();
    }
    public int basketProductCount(){
        return driver.findElements(basketProductName).size();
    }
    public void clickPriceButton(){
        wait.until(ExpectedConditions.elementToBeClickable(priceButton)).click();
    }
    public void removeItemFromBasket(int index){
        driver.findElements(trash).get(index).click();
    }

    public double getSubTotal(){
        String cleanedText = driver.findElement(subTotal).getText().replace("£", "").replace(",", "").replace(" ", "").trim();
        return Double.parseDouble(cleanedText);
    }
    public CartPage viewAndEditCart(){
        findElement(viewAndEditButton).click();
        return new CartPage(driver);

    }
}