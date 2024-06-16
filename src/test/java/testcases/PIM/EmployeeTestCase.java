package testcases.PIM;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import helpers.ToastMessages;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.pages.PIM.AddEmployeePageObject;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageObjects.pages.PIM.ContactDetailsPageObject;
import pageObjects.pages.PIM.EmployeeListPageObject;
import pageObjects.pages.PIM.PersonalDetailsPageObject;

import java.util.Random;

public class EmployeeTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private ContactDetailsPageObject contactDetailsPage;

    private String firstName = "Auto";
    private String lastName = "test";
    private String middleName = "111";
    private String driversLicenseNumber = "39392000023";
    private String username = "user_" + new Random().nextInt(299999);
    private String password = GlobalConstants.ADMIN_PASSWORD;
    private String employeeId = "0004";
    private String attachmentFileName = "attachment1.jpg";
    private String attachmentComment = "Comment of attachment1.jpg";

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
        employeeId = addEmployeePage.getEmployeeId();
        personalDetailsPage = addEmployeePage.addNewEmployeeWithFullInfo(firstName, middleName, lastName, username, password);
        Assert.assertTrue(employeeListPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED),
                "Toast message is not displayed");

        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), middleName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeId(), employeeId);

        Allure.step("Step 04 - Update employee information");
        personalDetailsPage.inputToDriversLicenseNumber(driversLicenseNumber);
        personalDetailsPage.inputToLicenseExpiryDate("2025-05-06");
        personalDetailsPage.selectNationality("Vietnamese");
        personalDetailsPage.selectMaritalStatus("Single");
        personalDetailsPage.inputToDateOfBirth("1999-09-09");
        personalDetailsPage.selectGenderMale();
        personalDetailsPage.clickSaveButton();
        Assert.assertTrue(personalDetailsPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_UPDATED));

        // update for search function...
    }

    @Description("TC002 Upload avatar")
    @Test
    public void TC002_UploadAvatar() {
        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        employeeListPage.inputToEmployeeId(employeeId);
        employeeListPage.clickSearchButton();
        employeeListPage.waitLoadingIconInvisible(driver);

        personalDetailsPage = employeeListPage.clickEditIconById(employeeId);
        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);
        personalDetailsPage.clickAvatar();
        personalDetailsPage.waitForChangeProfilePictureTitleVisible();
        personalDetailsPage.clickToUploadAvatar(GlobalConstants.TEST_RESOURCES_UPLOAD_PATH + "avatar.jpg");
        Assert.assertTrue(personalDetailsPage.isAvatarUploadedBase64());
        personalDetailsPage.clickSaveButton();
        Assert.assertTrue(personalDetailsPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_UPDATED));
    }

    @Description("TC003 In Personal Details, Add Attachments")
    @Test
    public void TC003_PersonalDetailsAddAttachments() {
        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        employeeListPage.inputToEmployeeId(employeeId);
        employeeListPage.clickSearchButton();
        employeeListPage.waitLoadingIconInvisible(driver);

        personalDetailsPage = employeeListPage.clickEditIconById(employeeId);
        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);

        personalDetailsPage.clickAddButton();
        Assert.assertEquals(personalDetailsPage.getFileUploadStatus(), "No file selected");
        personalDetailsPage.uploadAttachment(GlobalConstants.TEST_RESOURCES_UPLOAD_PATH + attachmentFileName);
        Assert.assertEquals(personalDetailsPage.getFileUploadStatus(), attachmentFileName);
        personalDetailsPage.inputToAttachmentComment(attachmentComment);
        personalDetailsPage.clickSaveAttachment();
        Assert.assertTrue(personalDetailsPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        employeeListPage.waitLoadingIconInvisible(driver);

        Assert.assertTrue(personalDetailsPage.isValueInColumnCorrect("File Name", attachmentFileName));
        Assert.assertTrue(personalDetailsPage.isValueInColumnCorrect("Description", attachmentComment));
    }

    @Description("TC004 Update Contact Details")
    @Test
    public void TC004_ContactDetails() {
        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        employeeListPage.inputToEmployeeId(employeeId);
        employeeListPage.clickSearchButton();
        employeeListPage.waitLoadingIconInvisible(driver);

        personalDetailsPage = employeeListPage.clickEditIconById(employeeId);
        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);

        personalDetailsPage.clickEmployeeInfoTabItem("Contact Details");
        contactDetailsPage = PageGeneratorManager.getContactDetailsPage(driver);
        contactDetailsPage.waitLoadingIconInvisible(driver);

        contactDetailsPage.inputToFieldByFieldName("Street 1", "D1");
        contactDetailsPage.inputToFieldByFieldName("Street 2", "Tan Phu");
        contactDetailsPage.inputToFieldByFieldName("City", "Thu Duc");
        contactDetailsPage.inputToFieldByFieldName("State/Province", "HCMC");
        contactDetailsPage.inputToFieldByFieldName("Zip/Postal Code", "700000");
        contactDetailsPage.selectCountry("Viet Nam");
        contactDetailsPage.inputToFieldByFieldName("Home", "0981112221");
        contactDetailsPage.inputToFieldByFieldName("Mobile", "0981119992");
        contactDetailsPage.inputToFieldByFieldName("Work", "0999991111");
        contactDetailsPage.inputToFieldByFieldName("Work Email", "work@email.com");
        contactDetailsPage.inputToFieldByFieldName("Other Email", "personal@email.com");

        contactDetailsPage.clickSaveButton();
        Assert.assertTrue(contactDetailsPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_UPDATED));
        contactDetailsPage.waitLoadingIconInvisible(driver);

        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Street 1"), "D1");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Street 2"), "Tan Phu");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("City"), "Thu Duc");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("State/Province"), "HCMC");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Zip/Postal Code"), "700000");
        Assert.assertTrue(contactDetailsPage.isCountrySelected("Viet Nam"));
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Home"), "0981112221");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Mobile"), "0981119992");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Work"), "0999991111");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Work Email"), "work@email.com");
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Other Email"), "personal@email.com");
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
