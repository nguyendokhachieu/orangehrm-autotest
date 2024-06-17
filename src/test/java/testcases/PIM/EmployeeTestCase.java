package testcases.PIM;

import commons.BaseTest;
import commons.DataProviderFactory;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import helpers.JavaMessages;
import helpers.RandomHelper;
import helpers.ToastMessages;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.pages.PIM.*;
import pageObjects.pages.Dashboard.DashboardPageObject;

public class EmployeeTestCase extends BaseTest {
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailsPageObject personalDetailsPage;
    private ContactDetailsPageObject contactDetailsPage;
    private EmergencyContactsPageObject emergencyContactsPageObject;

    private String username = RandomHelper.generateRandomUsername();
    private String password = GlobalConstants.ADMIN_PASSWORD;
    private String employeeId = "0004";
    private String attachmentFileName = "attachment1.jpg";
    private String attachmentComment = "Comment of attachment1.jpg";

    @BeforeClass
    public void beforeClass() {
        dashboardPage = loginPage.loginWithUsernameAndPassword(GlobalConstants.ADMIN_USERNAME, GlobalConstants.ADMIN_PASSWORD);
    }

    @Description("TC001 Add new employee")
    @Test(dataProvider = "jsonData", dataProviderClass = DataProviderFactory.class)
    public void TC001_AddNewEmployee(JSONObject data) {
        String firstName = (String) data.get("firstName");
        String lastName = (String) data.get("lastName");
        String middleName = (String) data.get("middleName");
        String driversLicenseNumber = (String) data.get("driversLicenseNumber");
        String licenseExpiryDate = (String) data.get("licenseExpiryDate");
        String nationality = (String) data.get("nationality");
        String maritalStatus = (String) data.get("maritalStatus");
        String dateOfBirth = (String) data.get("dateOfBirth");

        Allure.step("Step 01 - Click PIM on side bar");
        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

        Allure.step("Step 02 - Click Add button");
        addEmployeePage = employeeListPage.clickAddButton(driver);

        Allure.step("Step 03 - Input new employee information");
        employeeId = addEmployeePage.getEmployeeId();
        addEmployeePage.inputNewEmployeeWithFullInfo(firstName, middleName, lastName, username, password);
        addEmployeePage.clickSaveButton();
        Assert.assertTrue(employeeListPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED),
                JavaMessages.TOAST_MESSAGE_IS_NOT_DISPLAYED);
        addEmployeePage.waitLoadingIconInvisible(driver);

        personalDetailsPage = PageGeneratorManager.getPersonalDetailsPage(driver);
        personalDetailsPage.waitPageTitleVisible(driver);
        personalDetailsPage.waitLoadingIconInvisible(driver);

        Assert.assertEquals(personalDetailsPage.getFirstName(), firstName);
        Assert.assertEquals(personalDetailsPage.getMiddleName(), middleName);
        Assert.assertEquals(personalDetailsPage.getLastName(), lastName);
        Assert.assertEquals(personalDetailsPage.getEmployeeId(), employeeId);

        Allure.step("Step 04 - Update employee information");
        personalDetailsPage.inputToDriversLicenseNumber(driversLicenseNumber);
        personalDetailsPage.inputToLicenseExpiryDate(licenseExpiryDate);
        personalDetailsPage.selectNationality(nationality);
        personalDetailsPage.selectMaritalStatus(maritalStatus);
        personalDetailsPage.inputToDateOfBirth(dateOfBirth);
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
    @Test(dataProvider = "jsonData", dataProviderClass = DataProviderFactory.class)
    public void TC004_ContactDetails(JSONObject data) {
        String street1 = (String) data.get("Street 1");
        String street2 = (String) data.get("Street 2");
        String city = (String) data.get("City");
        String stateProvince = (String) data.get("State/Province");
        String zipPostalCode = (String) data.get("Zip/Postal Code");
        String country = (String) data.get("Country");
        String home = (String) data.get("Home");
        String mobile = (String) data.get("Mobile");
        String work = (String) data.get("Work");
        String workEmail = RandomHelper.generateRandomEmail();
        String otherEmail = RandomHelper.generateRandomEmail();

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

        contactDetailsPage.inputToFieldByFieldName("Street 1", street1);
        contactDetailsPage.inputToFieldByFieldName("Street 2", street2);
        contactDetailsPage.inputToFieldByFieldName("City", city);
        contactDetailsPage.inputToFieldByFieldName("State/Province", stateProvince);
        contactDetailsPage.inputToFieldByFieldName("Zip/Postal Code", zipPostalCode);
        contactDetailsPage.selectCountry(country);
        contactDetailsPage.inputToFieldByFieldName("Home", home);
        contactDetailsPage.inputToFieldByFieldName("Mobile", mobile);
        contactDetailsPage.inputToFieldByFieldName("Work", work);
        contactDetailsPage.inputToFieldByFieldName("Work Email", workEmail);
        contactDetailsPage.inputToFieldByFieldName("Other Email", otherEmail);

        contactDetailsPage.clickSaveButton();
        Assert.assertTrue(contactDetailsPage.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_UPDATED));
        contactDetailsPage.waitLoadingIconInvisible(driver);

        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Street 1"), street1);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Street 2"), street2);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("City"), city);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("State/Province"), stateProvince);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Zip/Postal Code"), zipPostalCode);
        Assert.assertTrue(contactDetailsPage.isCountrySelected(country));
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Home"), home);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Mobile"), mobile);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Work"), work);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Work Email"), workEmail);
        Assert.assertEquals(contactDetailsPage.getValueFromFieldByFieldName("Other Email"), otherEmail);
    }

    @Description("TC005 Emergency Contacts")
    @Test(dataProvider = "jsonData", dataProviderClass = DataProviderFactory.class)
    public void TC005_EmergencyContacts(JSONObject data) {
        String name = (String) data.get("Name");
        String relationship = (String) data.get("Relationship");
        String homeTelephone = (String) data.get("Home Telephone");
        String mobile = (String) data.get("Mobile");
        String workTelephone = (String) data.get("Work Telephone");

        dashboardPage.clickLeftSidebarLink(driver, "PIM");
        employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
        employeeListPage.inputToEmployeeId(employeeId);
        employeeListPage.clickSearchButton();
        employeeListPage.waitLoadingIconInvisible(driver);

        personalDetailsPage = employeeListPage.clickEditIconById(employeeId);
        personalDetailsPage.waitLoadingIconInvisible(driver);
        personalDetailsPage.waitPageTitleVisible(driver);

        personalDetailsPage.clickEmployeeInfoTabItem("Emergency Contacts");
        emergencyContactsPageObject = PageGeneratorManager.getEmergencyContactsPage(driver);
        emergencyContactsPageObject.waitLoadingIconInvisible(driver);

        emergencyContactsPageObject.clickToAddNewEmergencyContact();
        emergencyContactsPageObject.inputToEmergencyContactFieldByLabelName("Name", name);
        emergencyContactsPageObject.inputToEmergencyContactFieldByLabelName("Relationship", relationship);
        emergencyContactsPageObject.inputToEmergencyContactFieldByLabelName("Home Telephone", homeTelephone);
        emergencyContactsPageObject.inputToEmergencyContactFieldByLabelName("Mobile", mobile);
        emergencyContactsPageObject.inputToEmergencyContactFieldByLabelName("Work Telephone", workTelephone);

        emergencyContactsPageObject.clickToSaveNewEmergencyContact();
        Assert.assertTrue(emergencyContactsPageObject.waitToastMessageVisible(driver, ToastMessages.SUCCESSFULLY_SAVED));
        emergencyContactsPageObject.waitLoadingIconInvisible(driver);

        Assert.assertEquals(emergencyContactsPageObject.getCellContentOfLastRowAndColumnName("Name"), name);
        Assert.assertEquals(emergencyContactsPageObject.getCellContentOfLastRowAndColumnName("Relationship"), relationship);
        Assert.assertEquals(emergencyContactsPageObject.getCellContentOfLastRowAndColumnName("Home Telephone"), homeTelephone);
        Assert.assertEquals(emergencyContactsPageObject.getCellContentOfLastRowAndColumnName("Mobile"), mobile);
        Assert.assertEquals(emergencyContactsPageObject.getCellContentOfLastRowAndColumnName("Work Telephone"), workTelephone);

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
