package testcases.Admin;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import helpers.JavaMessages;
import helpers.RandomHelper;
import helpers.ToastMessages;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.Admin.EditUserPageObject;
import pageObjects.pages.Admin.UserManagementPageObject;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageObjects.pages.PIM.AddEmployeePageObject;
import pageObjects.pages.PIM.EmployeeListPageObject;
import pageObjects.pages.PIM.PersonalDetailsPageObject;

public class SystemUserTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private UserManagementPageObject userManagementPage;
    private EditUserPageObject editUserPage;

    @BeforeClass
    public void beforeClass() {
        dashboardPage = loginPage.loginWithUsernameAndPassword(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @Description("TC001 Edit User")
    @Test()
    public void TC001_EditUser() {
        // Before Editing user, add new user to get employee name info to edit later
        String firstName = "Ben ";
        String lastName = RandomHelper.generateRandomEmployeeName();
        String middleName = "V.";
        String username = RandomHelper.generateRandomUsername();

        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        addEmployeePage = employeeListPage.clickAddButton(driver);
        addEmployeePage.inputNewEmployeeWithFullInfo(firstName, middleName, lastName, username, GlobalConstants.ADMIN_PASSWORD);
        addEmployeePage.clickSaveButton();
        Assert.assertTrue(employeeListPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED),
                JavaMessages.TOAST_MESSAGE_IS_NOT_DISPLAYED);
        addEmployeePage.waitLoadingIconInvisible(driver);
        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
        personalDetailsPage.waitLoadingIconInvisible(driver);

        // Main flow of Editing user
        personalDetailsPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);

        userManagementPage.inputToUsername(GlobalConstants.ADMIN_USERNAME);
        userManagementPage.clickSearchButton();
        userManagementPage.waitLoadingIconInvisible(driver);
        editUserPage = userManagementPage.clickToEditRowByUsername(GlobalConstants.ADMIN_USERNAME);
        editUserPage.waitLoadingIconInvisible(driver);
        editUserPage.inputToEmployeeName(lastName);
        editUserPage.clickToEmployeeNameOption(firstName + " " + middleName + " " + lastName);
        userManagementPage = editUserPage.clickSaveButton();

        Assert.assertTrue(editUserPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_UPDATED));
        userManagementPage.waitLoadingIconInvisible(driver);
    }

    @Description("TC002 Search Not Found, Then Clear All Inputs")
    @Test
    public void TC002_SearchNotFound() {
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.inputToUsername("fake user name not found!!");
        userManagementPage.selectUserRole("Admin");
        userManagementPage.inputToEmployeeName("Sample User  2");
        userManagementPage.selectEmployeeName("Sample User  2");
        userManagementPage.selectStatus("Enabled");
        userManagementPage.clickSearchButton();

        Assert.assertTrue(userManagementPage.waitToastMessageVisible(driver, ToastMessages.NO_RECORDS_FOUND));
        userManagementPage.waitLoadingIconInvisible(driver);
        Assert.assertTrue(userManagementPage.waitNoRecordsFoundVisible());

        userManagementPage.clickResetButton();
        userManagementPage.waitLoadingIconInvisible(driver);

        Assert.assertEquals(userManagementPage.getUsernameInputValue(), "");
        Assert.assertEquals(userManagementPage.getUserRoleSelectedValue(), "-- Select --");
        Assert.assertEquals(userManagementPage.getEmployeeNameInputValue(), "");
        Assert.assertEquals(userManagementPage.getStatusSelectedValue(), "-- Select --");
    }

}
