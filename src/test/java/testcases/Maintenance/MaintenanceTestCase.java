package testcases.Maintenance;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import helpers.FileHelper;
import helpers.RandomHelper;
import helpers.ToastMessages;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageObjects.pages.Maintenance.AccessRecordsPageObject;
import pageObjects.pages.Maintenance.AdministratorAccessPageObject;
import pageObjects.pages.Maintenance.MaintenancePageObject;
import pageObjects.pages.Maintenance.PurgeEmployeeRecordsPageObject;
import pageObjects.pages.PIM.AddEmployeePageObject;
import pageObjects.pages.PIM.EmployeeListPageObject;
import pageObjects.pages.PIM.PersonalDetailsPageObject;

public class MaintenanceTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private MaintenancePageObject maintenancePage;
    private AdministratorAccessPageObject administratorAccessPage;
    private PurgeEmployeeRecordsPageObject purgeEmployeeRecordsPage;
    private AccessRecordsPageObject accessRecordsPage;

    @BeforeClass
    public void beforeClass() {
        dashboardPage = loginPage.loginWithUsernameAndPassword(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @Description("TC001 Download Employee Info")
    @Test()
    public void TC001_DownloadEmployeeInfo() {
        String firstName = RandomHelper.generateRandomFirstName();
        String middleName = RandomHelper.generateRandomMiddleName();
        String lastName = RandomHelper.generateRandomLastName();
        String fullName = firstName + " " + middleName + " " + lastName;
        String employeeFullFileName = fullName + ".json";

        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        addEmployeePage = employeeListPage.clickAddButton(driver);

        addEmployeePage.inputToFirstName(firstName);
        addEmployeePage.inputToMiddleName(middleName);
        addEmployeePage.inputToLastName(lastName);
        addEmployeePage.waitFormLoaderInvisible();
        addEmployeePage.clickSaveButton();
        Assert.assertTrue(employeeListPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        addEmployeePage.waitLoadingIconInvisible(driver);
        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
        personalDetailsPage.waitLoadingIconInvisible(driver);

        personalDetailsPage.clickLeftSidebarLink(driver, "Maintenance");
        maintenancePage = PageGeneratorManager.getMaintenancePage(driver);
        administratorAccessPage = PageGeneratorManager.getAdministratorAccessPage(driver);

        Assert.assertEquals(administratorAccessPage.getTextBoxValueByLabelName("Username"), GlobalConstants.ADMIN_USERNAME);
        administratorAccessPage.inputToTextBoxByLabelName("Password", GlobalConstants.ADMIN_PASSWORD);
        administratorAccessPage.clickConfirmButton();
        purgeEmployeeRecordsPage = PageGeneratorManager.getPurgeEmployeeRecordsPage(driver);
        purgeEmployeeRecordsPage.clickTopbarAccessRecordsLink();
        accessRecordsPage = PageGeneratorManager.getAccessRecordsPage(driver);

        accessRecordsPage.inputToEmployeeName(fullName);
        accessRecordsPage.clickEmployeeNameOption(fullName);
        accessRecordsPage.clickSearchButton();

        Assert.assertEquals(accessRecordsPage.getValueFromInput("firstName"), firstName);
        Assert.assertEquals(accessRecordsPage.getValueFromInput("middleName"), middleName);
        Assert.assertEquals(accessRecordsPage.getValueFromInput("lastName"), lastName);

        accessRecordsPage.clickDownloadButton();
        accessRecordsPage.waitForFileDownloadCompleted(GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH, employeeFullFileName);
        Assert.assertTrue(FileHelper.isFileExist(GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH, employeeFullFileName));
        Assert.assertEquals(accessRecordsPage.getFullNameFromDownloadFile(GlobalConstants.TEST_RESOURCES_DOWNLOAD_PATH, employeeFullFileName), fullName);
    }


}
