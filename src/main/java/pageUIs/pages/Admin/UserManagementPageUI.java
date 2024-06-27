package pageUIs.pages.Admin;

public class UserManagementPageUI {
    public static final String XPATH_USERNAME_INPUT = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String XPATH_SEARCH_BUTTON = "xpath=//button[contains(string(),'Search')]";
    public static final String FM_XPATH_ROW_EDIT_BY_USERNAME = "xpath=//div[@class='oxd-table-card']/div[@role='row']/div[2]/div[text()='%s']/parent::div/following-sibling::div[4]//i[contains(@class,'bi-pencil-fill')]";
}
