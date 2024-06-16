package common;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageObjects.pages.authentications.LoginPageObject;

import java.util.Set;

public class CommonLogin extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(CommonLogin.class);
    private WebDriver driver;
    public static Set<Cookie> cookies;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private String username = "";
    private String password = "";

    @Parameters({"browserName"})
    @BeforeTest
    public void loginToWeb(String browserName) {
        driver = getWebDriver(browserName);
        driver.get(GlobalConstants.WEB_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        dashboardPage = loginPage.loginWithUsernameAndPassword(username, password);
        cookies = dashboardPage.getCookies(driver);
        driver.quit();
    }
}
