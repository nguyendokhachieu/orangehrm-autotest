package commons;

import helpers.FileHelper;
import helpers.JavaMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.pages.authentications.LoginPageObject;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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
                ChromeOptions chromeOptions = new ChromeOptions();
                HashMap<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("download.default_directory", GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH);
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.download.dir", GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH);
                firefoxProfile.setPreference("browser.download.folderList", 2);
                firefoxOptions.setProfile(firefoxProfile);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                HashMap<String, Object> edgePrefs = new HashMap<>();
                edgePrefs.put("browser.download.folderList", 2);
                edgePrefs.put("download.default_directory", GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH);
//                edgePrefs.put("browser.download.dir", GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH);
                edgeOptions.setExperimentalOption("prefs", edgePrefs);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException(JavaMessages.BROWSER_NAME_IS_WRONG);
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
