package pageObjects.pages;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.AddEmployeePageUI;

public class AddEmployeePageObject extends PIMPageObject {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PersonalDetailsPageObject addNewEmployeeWithFullInfo(String firstName, String middleName, String lastName, String username, String password) {
        inputToFirstName(firstName);
        inputToMiddleName(middleName);
        inputToLastName(lastName);
        checkCreateLoginDetails();
        sleepInSeconds(2);
        inputToUsername(username);
        checkEnabledStatus();
        inputToPassword(password);
        inputToConfirmPassword(password);
        return clickSaveButton();
    }

    private void inputToFirstName(String firstName) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_FIRSTNAME_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_FIRSTNAME_INPUT, firstName);
    }

    private void inputToMiddleName(String middleName) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_MIDDLENAME_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_MIDDLENAME_INPUT, middleName);
    }

    private void inputToLastName(String lastName) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_LASTNAME_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_LASTNAME_INPUT, lastName);
    }

    public String getEmployeeId() {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_EMPLOYEE_ID_INPUT);
        return getElementAttribute(driver, AddEmployeePageUI.XPATH_EMPLOYEE_ID_INPUT, "value");
    }

    public void checkCreateLoginDetails() {
        if (!isElementSelected(driver, AddEmployeePageUI.XPATH_CREATE_LOGIN_DETAILS_CHECKBOX)) {
            clickToElementByJS(driver, AddEmployeePageUI.XPATH_CREATE_LOGIN_DETAILS_CHECKBOX);
        }
    }

    private void inputToUsername(String username) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_USERNAME_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_USERNAME_INPUT, username);
    }

    private void checkEnabledStatus() {
        if (!isElementSelected(driver, AddEmployeePageUI.XPATH_STATUS_ENABLED_RADIO)) {
            clickToElementByJS(driver, AddEmployeePageUI.XPATH_STATUS_ENABLED_RADIO);
        }
    }

    private void inputToPassword(String password) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_PASSWORD_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_PASSWORD_INPUT, password);
    }

    private void inputToConfirmPassword(String password) {
        waitForElementVisible(driver, AddEmployeePageUI.XPATH_CONFIRM_PASSWORD_INPUT);
        sendKeyToElement(driver, AddEmployeePageUI.XPATH_CONFIRM_PASSWORD_INPUT, password);
    }

    private PersonalDetailsPageObject clickSaveButton() {
        waitForElementClickable(driver, AddEmployeePageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, AddEmployeePageUI.XPATH_SAVE_BUTTON);
        return PageGeneratorManager.getPersonalDetailsPage(driver);
    }
}
