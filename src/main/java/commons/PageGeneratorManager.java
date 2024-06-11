package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.DashboardPageObject;
import pageObjects.pages.LoginPageObject;
import pageObjects.pages.PIMPageObject;

public class PageGeneratorManager {
    public static DashboardPageObject getDashboardPage(WebDriver driver) {
        return new DashboardPageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static PIMPageObject getPIMPage(WebDriver driver) {
        return new PIMPageObject(driver);
    }
}
