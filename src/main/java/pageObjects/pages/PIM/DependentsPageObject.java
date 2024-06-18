package pageObjects.pages.PIM;

import org.openqa.selenium.WebDriver;
import pageUIs.pages.PIM.DependentsPageUI;

public class DependentsPageObject extends PIMPageObject {
    private WebDriver driver;

    public DependentsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddDependent() {
        waitForElementClickable(driver, DependentsPageUI.XPATH_ADD_DEPENDENT);
        clickToElement(driver, DependentsPageUI.XPATH_ADD_DEPENDENT);
        sleepInSeconds(1);
    }

    public void inputToName(String name) {
        waitForElementVisible(driver, DependentsPageUI.XPATH_NAME_INPUT);
        sendKeyToElement(driver, DependentsPageUI.XPATH_NAME_INPUT, name);
    }

    public void selectRelationship(String relationship) {
        selectItemInCustomDropdown(driver, DependentsPageUI.XPATH_RELATIONSHIP_SELECT_PARENT, DependentsPageUI.XPATH_RELATIONSHIP_SELECT_CHILD, relationship);
    }

    public void inputToDateOfBirth(String dateOfBirth) {
        waitForElementVisible(driver, DependentsPageUI.XPATH_DATE_OF_BIRTH);
        sendKeyToElement(driver, DependentsPageUI.XPATH_DATE_OF_BIRTH, dateOfBirth);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, DependentsPageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, DependentsPageUI.XPATH_SAVE_BUTTON);
    }

    private int getColumnIndexByColumnName(String columnName) {
        waitForElementVisible(driver, DependentsPageUI.FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME, columnName);
        return getSizeOfListElements(driver, DependentsPageUI.FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
    }

    private int getNumberOfRowsInDependents() {
        waitForElementVisible(driver, DependentsPageUI.XPATH_NUMBER_OF_ROWS_IN_DEPENDENTS);
        return getSizeOfListElements(driver, DependentsPageUI.XPATH_NUMBER_OF_ROWS_IN_DEPENDENTS);
    }

    public String getCellContentOfLastRowAndColumnName(String columnName) {
        int columnIndex = getColumnIndexByColumnName(columnName);
        int lastRowIndex = getNumberOfRowsInDependents();
        waitForElementVisible(driver, DependentsPageUI.FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(lastRowIndex), String.valueOf(columnIndex));
        return getElementText(driver, DependentsPageUI.FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(lastRowIndex), String.valueOf(columnIndex));
    }
}
