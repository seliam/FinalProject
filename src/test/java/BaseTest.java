import constants.BaseURL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        driver.get(BaseURL.URL);
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotName = "failu"  + ".png";
            FileUtils.copyFile(screenshotFile, new File("src/test/resources/ScreenShots" + screenshotName));
        }
        driver.quit();
    }
}
