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
import pageObjects.pages.Admin.Job.AddJobTitlePageObject;
import pageObjects.pages.Admin.Organization.GeneralInfomationPageObject;
import pageObjects.pages.Admin.Organization.StructurePageObject;
import pageObjects.pages.Admin.UserManagement.EditUserPageObject;
import pageObjects.pages.Admin.Job.JobTitlesPageObject;
import pageObjects.pages.Admin.UserManagement.UserManagementPageObject;
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
    private JobTitlesPageObject jobTitlesPage;
    private AddJobTitlePageObject addJobTitlePage;
    private GeneralInfomationPageObject generalInfomationPage;
    private StructurePageObject structurePage;

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

    @Description("TC003 Click Help button, verify new tab open, then switch back to original page, close the Help page")
    @Test
    public void TC003_ClickHelpButton() {
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.clickHelpButton();

        Assert.assertEquals(userManagementPage.countNumberOfTabsInBrowser(driver), 2);
        userManagementPage.switchToTabByTitle(driver, "How to Add a User Account – OrangeHRM");
        Assert.assertTrue(userManagementPage.isHelpPageTitleDisplayed());
        userManagementPage.closeAllTabsExceptTitle(driver, "OrangeHRM");
    }

    @Description("TC004 Add New Job Titles")
    @Test
    public void TC004_AddNewJobTitles() {
        String jobTitle = RandomHelper.generateRandomJobTitle();
        String jobDescription = "job description sample 01";
        String jobSpecFileName = "jobspec.pdf";
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.clickTopbarDropdown("Job");
        userManagementPage.clickNavLinkInDropdown("Job Titles");
        jobTitlesPage = PageGeneratorManager.getJobTitlesPage(driver);

        addJobTitlePage = jobTitlesPage.clickAddButton();
        addJobTitlePage.inputToJobTitle(jobTitle);
        addJobTitlePage.inputToJobDescription(jobDescription);
        Assert.assertEquals(addJobTitlePage.getJobSpecificationFileStatus(), "No file chosen");
        addJobTitlePage.uploadJobSpecificationFile(GlobalConstants.TEST_RESOURCES_UPLOAD_PATH + jobSpecFileName);
        Assert.assertEquals(addJobTitlePage.getJobSpecificationFileStatus(), jobSpecFileName);
        addJobTitlePage.inputToNote("job note");
        addJobTitlePage.clickSaveButton();

        Assert.assertTrue(addJobTitlePage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        jobTitlesPage = PageGeneratorManager.getJobTitlesPage(driver);
        jobTitlesPage.waitLoadingIconInvisible(driver);

        Assert.assertTrue(jobTitlesPage.isJobTitleAdded(jobTitle, jobDescription));
    }

    @Description("TC005 Delete one job title by checking checkbox")
    @Test
    public void TC005_DeleteOneJobTitleByCheckingCheckbox() {
        String jobTitle = RandomHelper.generateRandomJobTitle();
        String jobDescription = "job description sample 01";
        String jobSpecFileName = "jobspec.pdf";
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.clickTopbarDropdown("Job");
        userManagementPage.clickNavLinkInDropdown("Job Titles");
        jobTitlesPage = PageGeneratorManager.getJobTitlesPage(driver);

        addJobTitlePage = jobTitlesPage.clickAddButton();
        addJobTitlePage.inputToJobTitle(jobTitle);
        addJobTitlePage.inputToJobDescription(jobDescription);
        Assert.assertEquals(addJobTitlePage.getJobSpecificationFileStatus(), "No file chosen");
        addJobTitlePage.uploadJobSpecificationFile(GlobalConstants.TEST_RESOURCES_UPLOAD_PATH + jobSpecFileName);
        Assert.assertEquals(addJobTitlePage.getJobSpecificationFileStatus(), jobSpecFileName);
        addJobTitlePage.inputToNote("job note");
        addJobTitlePage.clickSaveButton();

        Assert.assertTrue(addJobTitlePage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        jobTitlesPage = PageGeneratorManager.getJobTitlesPage(driver);
        jobTitlesPage.waitLoadingIconInvisible(driver);

        Assert.assertTrue(jobTitlesPage.isJobTitleAdded(jobTitle, jobDescription));

        jobTitlesPage.checkToRowCheckboxByJobTitle(jobTitle);
        jobTitlesPage.clickDeleteSelectedButton();
        jobTitlesPage.clickYesDeleteButton();

        Assert.assertTrue(jobTitlesPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_DELETED));
        jobTitlesPage.waitLoadingIconInvisible(driver);
        Assert.assertTrue(jobTitlesPage.isRowUndisplayedByJobTitle(jobTitle));
    }

    @Description("TC006 General Information - Verify inputs enabled/disabled states")
    @Test
    public void TC006_GeneralInformationInputsState() {
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.clickTopbarDropdown("Organization");
        userManagementPage.clickNavLinkInDropdown("General Information");
        generalInfomationPage = PageGeneratorManager.getGeneralInfomationPage(driver);
        generalInfomationPage.waitLoadingIconInvisible(driver);

        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Organization Name"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Registration Number"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Tax ID"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Phone"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Fax"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Email"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Address Street 1"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Address Street 2"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("City"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("State/Province"));
        Assert.assertFalse(generalInfomationPage.isTextInputByLabelEnabled("Zip/Postal Code"));
        Assert.assertTrue(generalInfomationPage.isCountryDropdownDisabled());
        Assert.assertFalse(generalInfomationPage.isNotesEnabled());

        generalInfomationPage.clickEditToggle();

        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Organization Name"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Registration Number"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Tax ID"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Phone"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Fax"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Email"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Address Street 1"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Address Street 2"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("City"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("State/Province"));
        Assert.assertTrue(generalInfomationPage.isTextInputByLabelEnabled("Zip/Postal Code"));
        Assert.assertTrue(generalInfomationPage.isCountryDropdownEnabled());
        Assert.assertTrue(generalInfomationPage.isNotesEnabled());
    }

    @Description("TC007 Structure - Create one new sub unit")
    @Test
    public void TC007_Structure() {
        dashboardPage.clickLeftSidebarLink(driver, "Admin");
        userManagementPage = PageGeneratorManager.getUserManagementPage(driver);
        userManagementPage.clickTopbarDropdown("Organization");
        userManagementPage.clickNavLinkInDropdown("Structure");
        structurePage = PageGeneratorManager.getStructurePage(driver);
        structurePage.waitLoadingIconInvisible(driver);

        structurePage.clickEditToggle();

        // Add level 1
        structurePage.clickAddButton();
        structurePage.inputToLabeledField("Unit Id", "91001");
        structurePage.inputToLabeledField("Name", "Org1001");
        structurePage.inputToDescription("Org1001 description");
        structurePage.clickSaveButton();

        Assert.assertTrue(structurePage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        structurePage.waitAddOrganizationDialogUndisplayed();
        structurePage.waitLoadingIconInvisible(driver);
        Assert.assertTrue(structurePage.isOrgNameDisplayed("91001", "Org1001"));

        // Add Level 2 (Child of Level 1)
        structurePage.clickPlusButton("91001", "Org1001");
        structurePage.inputToLabeledField("Unit Id", "91002");
        structurePage.inputToLabeledField("Name", "Org1002");
        structurePage.inputToDescription("Org1002 description");
        structurePage.clickSaveButton();

        Assert.assertTrue(structurePage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        structurePage.waitAddOrganizationDialogUndisplayed();
        structurePage.waitLoadingIconInvisible(driver);
        Assert.assertTrue(structurePage.isOrgNameUndisplayed("91002", "Org1002"));
        structurePage.clickToggleButtonByOrgName("91001", "Org1001");
        Assert.assertTrue(structurePage.isOrgNameDisplayed("91002", "Org1002"));
    }
}
