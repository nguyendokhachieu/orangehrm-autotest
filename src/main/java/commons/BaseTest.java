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
import pageObjects.pages.LoginPageObject;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPageObject loginPage;

    @BeforeSuite
    public void beforeSuite() {
        FileHelper.deleteAllFileInFolder("allure-results");
    }

    @Parameters({"browserName"})
    @BeforeTest
    public void beforeTest(String browserName) {
        driver = getWebDriver(browserName);
        driver.get(GlobalConstants.WEB_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriver getWebDriver(String browserName) {
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException(Messages.BROWSER_NAME_IS_WRONG);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }

    @AfterTest(alwaysRun = true)
    public void afterTest() {
//        driver.quit();
    }
}
