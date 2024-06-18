package pageUIs.pages.PIM;

public class DependentsPageUI {
    public static final String XPATH_ADD_DEPENDENT = "xpath=//h6[text()='Assigned Dependents']/parent::div//button[contains(string(),'Add')]";
    public static final String XPATH_NAME_INPUT = "xpath=//label[text()='Name']/parent::div/following-sibling::div/input";
    public static final String XPATH_RELATIONSHIP_SELECT_PARENT = "xpath=//label[text()='Relationship']/parent::div/following-sibling::div//i";
    public static final String XPATH_RELATIONSHIP_SELECT_CHILD = "xpath=//div[@class='oxd-select-option']/span";
    public static final String XPATH_DATE_OF_BIRTH = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";
    public static final String XPATH_SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";

    public static final String FM_XPATH_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[@role='columnheader' and text()='%s']//preceding-sibling::div";
    public static final String FM_XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//div[@class='oxd-table-card'][%s]//div[@role='cell'][%s]/div";
    public static final String XPATH_NUMBER_OF_ROWS_IN_DEPENDENTS = "xpath=//h6[text()='Assigned Dependents']/parent::div/parent::div//following-sibling::div[@class='orangehrm-container']//div[@class='oxd-table-card']";


}
