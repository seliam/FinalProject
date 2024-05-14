package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static constants.Locators.*;
import static constants.Locators.subTotal;

public class CartPage extends BasePage{
    private final WebDriverWait wait;

    public CartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String basketProductName(int index ){
        List<WebElement> products = findElements(cartPageProductTitle);
        return products.get(index).getText();
    }
    public int basketProductCount(){
        return findElements(cartPageProducs).size();
    }

    public void removeProduct(int index){
        findElements(cartPageTrash).get(index).click();
    }
    public double getSubTotal(){
        String cleanedText = findElements(cartPageTotalPrice).get(0).getText().replace("£", "").replace(",", "").replace(" ", "").trim();
        return Double.parseDouble(cleanedText);
    }

    public boolean isCartEmpty(){
        return findElements(emptyCart).size() > 0;
    }

    public String emptyCartMassege(){
        return findElements(emptyCart).get(0).getText();
    }
}
