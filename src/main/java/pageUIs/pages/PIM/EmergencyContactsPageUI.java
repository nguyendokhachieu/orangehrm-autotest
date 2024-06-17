package pageUIs.pages.PIM;

public class EmergencyContactsPageUI {
    public static final String XPATH_ADD_EMERGENCY_CONTACT_BUTTON = "xpath=//h6[text()='Assigned Emergency Contacts']/parent::div/button[contains(string(),'Add')]";
    public static final String FM_XPATH_EMERGENCY_CONTACT_FIELD_BY_LABEL_NAME = "xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
    public static final String XPATH_SAVE_EMERGENCY_CONTACT_BUTTON = "xpath=//h6[text()='Save Emergency Contact']/parent::div//button[contains(string(),'Save')]";
    public static final String FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[@role='columnheader' and text()='%s']//preceding-sibling::div";
    public static final String FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//div[@class='oxd-table-card'][%s]//div[@role='cell'][%s]/div";
    public static final String XPATH_NUMBER_OF_ROWS_IN_EMERGENCY_CONTACT = "xpath=//h6[text()='Assigned Emergency Contacts']/parent::div/parent::div//following-sibling::div[@class='orangehrm-container']//div[@class='oxd-table-card']";
}