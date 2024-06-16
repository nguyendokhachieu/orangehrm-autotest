package pageObjects.pages.PIM;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.PIM.EmployeeListPageUI;

public class EmployeeListPageObject extends PIMPageObject {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToEmployeeName(String employeeName) {
        waitForElementVisible(driver, EmployeeListPageUI.XPATH_EMPLOYEE_NAME_INPUT);
        sendKeyToElement(driver, EmployeeListPageUI.XPATH_EMPLOYEE_NAME_INPUT, employeeName);
    }

    public void inputToEmployeeId(String employeeId) {
        waitForElementVisible(driver, EmployeeListPageUI.XPATH_EMPLOYEE_ID_INPUT);
        sendKeyToElement(driver, EmployeeListPageUI.XPATH_EMPLOYEE_ID_INPUT, employeeId);
    }

    public AddEmployeePageObject clickAddButton(WebDriver driver) {
        waitForElementClickable(driver, EmployeeListPageUI.XPATH_ADD_BUTTON);
        clickToElement(driver, EmployeeListPageUI.XPATH_ADD_BUTTON);
        return PageGeneratorManager.getAddEmployeePage(driver);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, EmployeeListPageUI.XPATH_SEARCH_BUTTON);
        clickToElement(driver, EmployeeListPageUI.XPATH_SEARCH_BUTTON);
    }

    public PersonalDetailsPageObject clickEditIconById(String employeeId) {
        waitForElementVisible(driver, EmployeeListPageUI.FM_XPATH_ROW_ICON_EDIT_BY_EMPLOYEE_ID, employeeId);
        clickToElement(driver, EmployeeListPageUI.FM_XPATH_ROW_ICON_EDIT_BY_EMPLOYEE_ID, employeeId);
        return new PersonalDetailsPageObject(driver);
    }
}
