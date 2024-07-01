package pageObjects.pages.Admin.UserManagement;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.pages.Admin.common.AdminPageObject;
import pageUIs.pages.Admin.UserManagement.EditUserPageUI;

public class EditUserPageObject extends AdminPageObject {
    private WebDriver driver;

    public EditUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToEmployeeName(String employeeName) {
        waitForElementVisible(driver, EditUserPageUI.XPATH_EMPLOYEE_NAME_INPUT);
        sendKeyToElement(driver, EditUserPageUI.XPATH_EMPLOYEE_NAME_INPUT, employeeName);
    }

    public void clickToEmployeeNameOption(String employeeName) {
        waitForElementVisible(driver, EditUserPageUI.FM_XPATH_EMPLOYEE_NAME_DROPDOWN_OPTION_BY_TEXT, employeeName);
        clickToElement(driver, EditUserPageUI.FM_XPATH_EMPLOYEE_NAME_DROPDOWN_OPTION_BY_TEXT, employeeName);
    }

    public UserManagementPageObject clickSaveButton() {
        waitForElementClickable(driver, EditUserPageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, EditUserPageUI.XPATH_SAVE_BUTTON);
        return PageGeneratorManager.getUserManagementPage(driver);
    }
}
