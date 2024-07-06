package pageObjects.pages.Maintenance;

import helpers.FileHelper;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.Maintenance.AccessRecordsPageUI;

public class AccessRecordsPageObject extends MaintenancePageObject {
    private WebDriver driver;

    public AccessRecordsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToEmployeeName(String employeeName) {
        waitForElementVisible(driver, AccessRecordsPageUI.XPATH_EMPLOYEE_NAME);
        sendKeyToElement(driver, AccessRecordsPageUI.XPATH_EMPLOYEE_NAME, employeeName);
    }

    public void clickEmployeeNameOption(String employeeName) {
        waitForElementClickable(driver, AccessRecordsPageUI.FM_XPATH_EMPLOYEE_NAME_OPTION, employeeName);
        clickToElement(driver, AccessRecordsPageUI.FM_XPATH_EMPLOYEE_NAME_OPTION, employeeName);
    }

    public void clickSearchButton() {
        waitForElementClickable(driver, AccessRecordsPageUI.XPATH_SEARCH_BUTTON);
        clickToElement(driver, AccessRecordsPageUI.XPATH_SEARCH_BUTTON);
    }

    public String getValueFromInput(String labelName) {
        waitForElementVisible(driver, AccessRecordsPageUI.FM_XPATH_INPUT_BY_NAME, labelName);
        return getElementAttribute(driver, AccessRecordsPageUI.FM_XPATH_INPUT_BY_NAME, "value", labelName);
    }

    public void clickDownloadButton() {
        waitForElementClickable(driver, AccessRecordsPageUI.XPATH_DOWNLOAD_BUTTON);
        clickToElement(driver, AccessRecordsPageUI.XPATH_DOWNLOAD_BUTTON);
    }

    public void waitForFileDownloadCompleted(String folderPath, String fileName, int timeoutInSeconds) {
        while (!FileHelper.isFileExist(folderPath, fileName)) {
            if (timeoutInSeconds < 0) {
                break;
            }
            sleepInSeconds(1);
            timeoutInSeconds -= 1;
        }
    }

    public void waitForFileDownloadCompleted(String folderPath, String fileName) {
        waitForFileDownloadCompleted(folderPath, fileName, 5);
    }

    public String getFullNameFromDownloadFile(String folderPath, String fileName) {
        JSONObject employeeJson = FileHelper.readJsonArray(folderPath + fileName, "Employee").getJSONObject(0);
        String firstName = FileHelper.readJsonAttribute(employeeJson, "firstName");
        String middleName = FileHelper.readJsonAttribute(employeeJson, "middleName");
        String lastName = FileHelper.readJsonAttribute(employeeJson, "lastName");
        return firstName + " " + middleName + " " + lastName;
    }
}
