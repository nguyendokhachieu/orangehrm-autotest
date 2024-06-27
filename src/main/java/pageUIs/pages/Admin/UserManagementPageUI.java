package pageUIs.pages.Admin;

public class UserManagementPageUI {
    public static final String XPATH_USERNAME_INPUT = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String XPATH_USER_ROLE_DROPDOWN_PARENT = "xpath=//label[text()='User Role']/parent::div/following-sibling::div//i";
    public static final String FM_XPATH_USER_ROLE_DROPDOWN_CHILD = "xpath=//div[@class='oxd-select-option']/span[text()='%s']";
    public static final String XPATH_SELECTED_USER_ROLE = "xpath=//label[text()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String XPATH_EMPLOYEE_NAME = "xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    public static final String FM_XPATH_EMPLOYEE_NAME_DROPDOWN_OPTION_BY_TEXT = "xpath=//div[@class='oxd-autocomplete-option']/span[contains(text(),'%s')]";
    public static final String XPATH_STATUS_DROPDOWN_PARENT = "xpath=//label[text()='Status']/parent::div/following-sibling::div//i";
    public static final String FM_XPATH_STATUS_DROPDOWN_CHILD = "xpath=//div[@class='oxd-select-option']/span[text()='%s']";
    public static final String XPATH_SELECTED_STATUS = "xpath=//label[text()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-text-input']";
    public static final String XPATH_SEARCH_BUTTON = "xpath=//button[contains(string(),'Search')]";
    public static final String XPATH_RESET_BUTTON = "xpath=//button[contains(string(),'Reset')]";
    public static final String FM_XPATH_ROW_EDIT_BY_USERNAME = "xpath=//div[@class='oxd-table-card']/div[@role='row']/div[2]/div[text()='%s']/parent::div/following-sibling::div[4]//i[contains(@class,'bi-pencil-fill')]";
    public static final String XPATH_SPAN_NO_RECORDS_FOUND = "xpath=//span[text()='No Records Found']";
}
