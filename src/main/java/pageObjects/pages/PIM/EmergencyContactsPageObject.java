package pageObjects.pages.PIM;

import org.openqa.selenium.WebDriver;
import pageUIs.pages.PIM.EmergencyContactsPageUI;

public class EmergencyContactsPageObject extends PIMPageObject {
    private WebDriver driver;

    public EmergencyContactsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddNewEmergencyContact() {
        waitForElementClickable(driver, EmergencyContactsPageUI.XPATH_ADD_EMERGENCY_CONTACT_BUTTON);
        clickToElement(driver, EmergencyContactsPageUI.XPATH_ADD_EMERGENCY_CONTACT_BUTTON);
        sleepInSeconds(1);
    }

    public void inputToEmergencyContactFieldByLabelName(String labelName, String value) {
        waitForElementVisible(driver, EmergencyContactsPageUI.FM_XPATH_EMERGENCY_CONTACT_FIELD_BY_LABEL_NAME, labelName);
        sendKeyToElement(driver, EmergencyContactsPageUI.FM_XPATH_EMERGENCY_CONTACT_FIELD_BY_LABEL_NAME, value, labelName);
    }

    public void clickToSaveNewEmergencyContact() {
        waitForElementClickable(driver, EmergencyContactsPageUI.XPATH_SAVE_EMERGENCY_CONTACT_BUTTON);
        clickToElement(driver, EmergencyContactsPageUI.XPATH_SAVE_EMERGENCY_CONTACT_BUTTON);
    }

    private int getColumnIndexByColumnName(String columnName) {
        waitForElementVisible(driver, EmergencyContactsPageUI.FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        return getSizeOfListElements(driver, EmergencyContactsPageUI.FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
    }

    private int getNumberOfRowsInEmergencyContact() {
        waitForElementVisible(driver, EmergencyContactsPageUI.XPATH_NUMBER_OF_ROWS_IN_EMERGENCY_CONTACT);
        return getSizeOfListElements(driver, EmergencyContactsPageUI.XPATH_NUMBER_OF_ROWS_IN_EMERGENCY_CONTACT);
    }

    public String getCellContentOfLastRowAndColumnName(String columnName) {
        int columnIndex = getColumnIndexByColumnName(columnName);
        int lastRowIndex = getNumberOfRowsInEmergencyContact();
        waitForElementVisible(driver, EmergencyContactsPageUI.FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(lastRowIndex), String.valueOf(columnIndex));
        return getElementText(driver, EmergencyContactsPageUI.FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(lastRowIndex), String.valueOf(columnIndex));
    }
}
