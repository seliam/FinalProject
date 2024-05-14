package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static constants.Locators.*;

public class HomePage extends BasePage{
    private final WebDriver driver;
    public final Header header;
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.header = new Header(driver);
    }
    public void clickOnSearchIcon(){
        WebDriverWait webDriverWait= new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(searchButton)));
        driver.findElement(searchButton).click();
    }
    public void allowCookies(){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(findElement(cookies))).click();
    }
}
