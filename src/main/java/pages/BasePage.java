package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    private final WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findElement(By by){
        return driver.findElement((by));
    }
    public List<WebElement> findElements(By by){
        return driver.findElements((by));
    }
}
