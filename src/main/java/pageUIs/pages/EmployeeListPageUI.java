package pageUIs.pages;

public class EmployeeListPageUI {
    public static final String XPATH_EMPLOYEE_NAME_INPUT = "xpath=//label[text()='Employee Name']/parent::div/following-sibling::div//input";
    public static final String XPATH_EMPLOYEE_ID_INPUT = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div//input";
    public static final String XPATH_SEARCH_BUTTON = "xpath=//button[contains(string(),'Search')]";
    public static final String XPATH_ADD_BUTTON = "xpath=//button[contains(string(), 'Add')]";
    public static final String FM_XPATH_ROW_ICON_EDIT_BY_EMPLOYEE_ID = "xpath=//div[text()='%s']//ancestor::div[@role='row']/child::div[9]//i[contains(@class,'bi-pencil-fill')]";
}
