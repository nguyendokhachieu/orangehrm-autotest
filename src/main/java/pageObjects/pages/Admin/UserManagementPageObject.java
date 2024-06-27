package pageObjects.pages.Admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.Admin.UserManagementPageUI;

public class UserManagementPageObject extends AdminPageObject {
    private WebDriver driver;

    public UserManagementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToUsername(String username) {
        waitForElementVisible(driver, UserManagementPageUI.XPATH_USERNAME_INPUT);
        sendKeyToElement(driver, UserManagementPageUI.XPATH_USERNAME_INPUT, username);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, UserManagementPageUI.XPATH_SEARCH_BUTTON);
        clickToElement(driver, UserManagementPageUI.XPATH_SEARCH_BUTTON);
    }

    public EditUserPageObject clickToEditRowByUsername(String username) {
        waitForElementVisible(driver, UserManagementPageUI.FM_XPATH_ROW_EDIT_BY_USERNAME, username);
        clickToElement(driver, UserManagementPageUI.FM_XPATH_ROW_EDIT_BY_USERNAME, username);
        return PageGeneratorManager.getEditUserPage(driver);
    }
}
