package testcases.Admin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.Admin.UserManagementPageObject;
import pageObjects.pages.Dashboard.DashboardPageObject;

public class SystemUserTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private UserManagementPageObject userManagementPage;

    @BeforeClass
    public void beforeClass() {
        dashboardPage = loginPage.loginWithUsernameAndPassword(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @BeforeMethod
    public void beforeMethod() {
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
    }

    @Description("TC001 ")
    @Test()
    public void TC001_AddNewEmployee() {

    }

    @Description("TC002 ")
    @Test
    public void TC002_() {


    }

}
