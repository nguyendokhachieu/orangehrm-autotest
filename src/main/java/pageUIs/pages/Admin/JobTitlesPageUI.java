package pageUIs.pages.Admin;

public class JobTitlesPageUI {
    public static final String XPATH_ADD_BUTTON = "xpath=//button[contains(string(),'Add')]";
    public static final String XPATH_TABLE_ROW = "xpath=//div[@class='oxd-table-card']";
    public static final String FM_XPATH_ROW_BY_JOB_TITLE = "xpath=//div[@class='oxd-table-card']/div/div[2]/div[text()='%s']";
    public static final String FM_XPATH_ROW_CHECKBOX_BY_JOB_TITLE = "xpath=//div[@class='oxd-table-card']/div/div[2]/div[text()='%s']/parent::div/preceding-sibling::div//input";
    public static final String XPATH_DELETE_SELECTED_BUTTON = "xpath=//button[text()=' Delete Selected ']";
    public static final String XPATH_YES_DELETE_BUTTON = "xpath=//button[text()=' Yes, Delete ']";
}
