package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.*;

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

    public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
        return new EmployeeListPageObject(driver);
    }

    public static AddEmployeePageObject getAddEmployeePage(WebDriver driver) {
        return new AddEmployeePageObject(driver);
    }

    public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPageObject(driver);
    }
}
