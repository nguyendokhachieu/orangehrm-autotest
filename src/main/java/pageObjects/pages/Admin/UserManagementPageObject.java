package pageObjects.pages.Admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.Admin.UserManagementPageUI;

public class UserManagementPageObject extends AdminPageObject {
    private WebDriver driver;

    public UserManagementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToUsername(String username) {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_USERNAME_INPUT);
        sendKeyToElement(driver, UserManagementPageUI.XPATH_USERNAME_INPUT, username);
    }

    public void selectUserRole(String role) {
        selectItemInCustomDropdown(driver, UserManagementPageUI.XPATH_USER_ROLE_DROPDOWN_PARENT, UserManagementPageUI.FM_XPATH_USER_ROLE_DROPDOWN_CHILD, role, role);
    }

    public void inputToEmployeeName(String employeeName) {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_EMPLOYEE_NAME);
        sendKeyToElement(driver, UserManagementPageUI.XPATH_EMPLOYEE_NAME, employeeName);
    }

    public void selectEmployeeName(String employeeName) {
        waitForElementVisible(driver, UserManagementPageUI.FM_XPATH_EMPLOYEE_NAME_DROPDOWN_OPTION_BY_TEXT, employeeName);
        clickToElement(driver, UserManagementPageUI.FM_XPATH_EMPLOYEE_NAME_DROPDOWN_OPTION_BY_TEXT, employeeName);
    }

    public void selectStatus(String status) {
        scrollToElementOnBottomByJS(driver, UserManagementPageUI.XPATH_STATUS_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver, UserManagementPageUI.XPATH_STATUS_DROPDOWN_PARENT, UserManagementPageUI.FM_XPATH_STATUS_DROPDOWN_CHILD, status, status);
    }

    public void clickSearchButton() {
        scrollToElementOnBottomByJS(driver, UserManagementPageUI.XPATH_SEARCH_BUTTON);
        waitForElementClickable(driver, UserManagementPageUI.XPATH_SEARCH_BUTTON);
        clickToElement(driver, UserManagementPageUI.XPATH_SEARCH_BUTTON);
    }

    public EditUserPageObject clickToEditRowByUsername(String username) {
        waitForElementVisible(driver, UserManagementPageUI.FM_XPATH_ROW_EDIT_BY_USERNAME, username);
        clickToElement(driver, UserManagementPageUI.FM_XPATH_ROW_EDIT_BY_USERNAME, username);
        return PageGeneratorManager.getEditUserPage(driver);
    }

    public boolean waitNoRecordsFoundVisible() {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_SPAN_NO_RECORDS_FOUND);
        return isElementDisplayed(driver, UserManagementPageUI.XPATH_SPAN_NO_RECORDS_FOUND);
    }

    public String getUsernameInputValue() {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_USERNAME_INPUT);
        return getElementAttribute(driver, UserManagementPageUI.XPATH_USERNAME_INPUT, "value");
    }

    public String getUserRoleSelectedValue() {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_SELECTED_USER_ROLE);
        return getElementText(driver, UserManagementPageUI.XPATH_SELECTED_USER_ROLE);
    }

    public String getEmployeeNameInputValue() {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_EMPLOYEE_NAME);
        return getElementAttribute(driver, UserManagementPageUI.XPATH_EMPLOYEE_NAME, "value");
    }

    public String getStatusSelectedValue() {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_SELECTED_STATUS);
        return getElementText(driver, UserManagementPageUI.XPATH_SELECTED_STATUS);
    }

    public void clickResetButton() {
        waitForElementClickable(driver, UserManagementPageUI.XPATH_RESET_BUTTON);
        clickToElement(driver, UserManagementPageUI.XPATH_RESET_BUTTON);
    }
}
