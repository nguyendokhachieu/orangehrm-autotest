package commons;

import helpers.FileHelper;
import helpers.Messages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        FileHelper.deleteAllFileInFolder("allure-results");
    }

    @Parameters({"browserName"})
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getWebDriver(browserName);
        driver.get(GlobalConstants.WEB_URL);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new RuntimeException(Messages.BROWSER_NAME_IS_WRONG);
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
        driver.quit();
    }
}
