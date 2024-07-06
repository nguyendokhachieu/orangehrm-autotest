package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.Admin.Job.AddJobTitlePageObject;
import pageObjects.pages.Admin.Job.JobTitlesPageObject;
import pageObjects.pages.Admin.Organization.GeneralInfomationPageObject;
import pageObjects.pages.Admin.Organization.StructurePageObject;
import pageObjects.pages.Admin.UserManagement.EditUserPageObject;
import pageObjects.pages.Admin.UserManagement.UserManagementPageObject;
import pageObjects.pages.Admin.common.AdminPageObject;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageObjects.pages.Maintenance.AccessRecordsPageObject;
import pageObjects.pages.Maintenance.AdministratorAccessPageObject;
import pageObjects.pages.Maintenance.MaintenancePageObject;
import pageObjects.pages.Maintenance.PurgeEmployeeRecordsPageObject;
import pageObjects.pages.PIM.*;
import pageObjects.pages.authentications.LoginPageObject;

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

    public static ContactDetailsPageObject getContactDetailsPage(WebDriver driver) {
        return new ContactDetailsPageObject(driver);
    }

    public static EmergencyContactsPageObject getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPageObject(driver);
    }

    public static DependentsPageObject getDependentsPage(WebDriver driver) {
        return new DependentsPageObject(driver);
    }

    public static AdminPageObject getAdminPage(WebDriver driver) {
        return new AdminPageObject(driver);
    }

    public static UserManagementPageObject getUserManagementPage(WebDriver driver) {
        return new UserManagementPageObject(driver);
    }

    public static EditUserPageObject getEditUserPage(WebDriver driver) {
        return new EditUserPageObject(driver);
    }

    public static JobTitlesPageObject getJobTitlesPage(WebDriver driver) {
        return new JobTitlesPageObject(driver);
    }

    public static AddJobTitlePageObject getAddJobTitlePage(WebDriver driver) {
        return new AddJobTitlePageObject(driver);
    }

    public static GeneralInfomationPageObject getGeneralInfomationPage(WebDriver driver) {
        return new GeneralInfomationPageObject(driver);
    }

    public static StructurePageObject getStructurePage(WebDriver driver) {
        return new StructurePageObject(driver);
    }

    public static MaintenancePageObject getMaintenancePage(WebDriver driver) {
        return new MaintenancePageObject(driver);
    }

    public static AdministratorAccessPageObject getAdministratorAccessPage(WebDriver driver) {
        return new AdministratorAccessPageObject(driver);
    }

    public static PurgeEmployeeRecordsPageObject getPurgeEmployeeRecordsPage(WebDriver driver) {
        return new PurgeEmployeeRecordsPageObject(driver);
    }

    public static AccessRecordsPageObject getAccessRecordsPage(WebDriver driver) {
        return new AccessRecordsPageObject(driver);
    }
}
