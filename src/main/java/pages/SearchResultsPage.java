package pages;

import constants.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static constants.Locators.*;

public class SearchResultsPage extends BasePage{
    private final WebDriverWait wait;
    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getProductName(int index){
        List<WebElement> products = driver.findElements(Locators.products);
        return products.get(index).findElement(productName).getText();
    }
    public void addToBasketClick(int index){
        List<WebElement> products = driver.findElements(Locators.products);
        WebElement product = products.get(index).findElement(addToBasketButton);
        Actions actions = new Actions(this.driver);
        actions.moveToElement(product);
        actions.perform();
        wait.until(ExpectedConditions.elementToBeClickable(products.get(index).findElement(addToBasketButton))).click();
    }
    public int getProductsCount(){
        return driver.findElements(Locators.products).size();
    }
    public double getPrice(int index){
        String cleanedText = driver.findElements(price).get(index).getText().replace("£", "").replace(",", "").replace(" ", "").trim();
        return Double.parseDouble(cleanedText);
    }
    public String getNoResult(){
        return findElement(emptySearchResult).getText();
    }

    public void sortByPrice(){
        WebElement selectElement = findElement(By.id("sorter"));
        Select select = new Select(selectElement);
        select.selectByValue("price");
    }
}
