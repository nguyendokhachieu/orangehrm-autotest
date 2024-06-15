package testcases.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.pages.AddEmployeePageObject;
import pageObjects.pages.DashboardPageObject;
import pageObjects.pages.EmployeeListPageObject;
import pageObjects.pages.PersonalDetailsPageObject;

import java.util.Random;

public class EmployeeTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;

    private String firstName = "Auto";
    private String lastName = "test";
    private String middleName = "111";
    private String driversLicenseNumber = "39392000023";
    private String username = "user_" + new Random().nextInt(299999);
    private String password = GlobalConstants.ADMIN_PASSWORD;

    @BeforeClass
    public void beforeClass() {
        dashboardPage = loginPage.loginWithUsernameAndPassword(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @Description("TC001 Add new employee")
    @Test
    public void TC001_AddNewEmployee() {
        Allure.step("Step 01 - Click PIM on side bar");
        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        Allure.step("Step 02 - Click Add button");
        addEmployeePage = employeeListPage.clickAddButton(driver);
        Allure.step("Step 03 - Input new employee information");
        personalDetailsPage = addEmployeePage.addNewEmployeeWithFullInfo(firstName, middleName, lastName, username, password);
        Assert.assertTrue(employeeListPage.waitToastMessageVisible(driver, "Successfully Saved"),
                "Toast message is not displayed");

        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), middleName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);

        Allure.step("Step 04 - Update employee information");
        personalDetailsPage.inputToDriversLicenseNumber(driversLicenseNumber);
        personalDetailsPage.inputToLicenseExpiryDate("2025-05-06");
        personalDetailsPage.selectNationality("Vietnamese");
        personalDetailsPage.selectMaritalStatus("Single");
        personalDetailsPage.inputToDateOfBirth("1999-09-09");
        personalDetailsPage.selectGenderMale();
        personalDetailsPage.clickSaveButton();
        Assert.assertTrue(personalDetailsPage.waitToastMessageVisible(driver, "Successfully Updated"));

        // update for search function...
    }

    @Description("TC002 Upload avatar")
    @Test
    public void TC002_UploadAvatar() {

    }

    @Description("TC003")
    @Test
    public void TC003_PersonalDetails() {

    }

    @Description("TC004")
    @Test
    public void TC004_ContactDetails() {

    }

    @Description("TC005")
    @Test
    public void TC005_EmergencyDetails() {

    }

    @Description("TC006")
    @Test
    public void TC006_AssignDependent() {

    }

    @Description("TC007")
    @Test
    public void TC007_EditViewJob() {

    }

    @Description("TC008")
    @Test
    public void TC008_EditViewSalary() {

    }

    @Description("TC009")
    @Test
    public void TC009_EditViewTax() {

    }

    @Description("TC010")
    @Test
    public void TC010_Qualifications() {

    }

    @Description("TC011")
    @Test
    public void TC011_SearchEmployee() {

    }
}
