package pageObjects.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import pageUIs.pages.Maintenance.AdministratorAccessPageUI;

public class AdministratorAccessPageObject extends MaintenancePageObject {
    private WebDriver driver;

    public AdministratorAccessPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getTextBoxValueByLabelName(String labelName) {
        waitForElementVisible(driver, AdministratorAccessPageUI.FM_XPATH_INPUT_BY_LABEL_NAME, labelName);
        return getElementAttribute(driver, AdministratorAccessPageUI.FM_XPATH_INPUT_BY_LABEL_NAME, "value", labelName);
    }

    public void inputToTextBoxByLabelName(String labelName, String keyToSend) {
        waitForElementVisible(driver, AdministratorAccessPageUI.FM_XPATH_INPUT_BY_LABEL_NAME, labelName);
        sendKeyToElement(driver, AdministratorAccessPageUI.FM_XPATH_INPUT_BY_LABEL_NAME, keyToSend, labelName);
    }

    public void clickConfirmButton() {
        waitForElementClickable(driver, AdministratorAccessPageUI.XPATH_CONFIRM_BUTTON);
        clickToElement(driver, AdministratorAccessPageUI.XPATH_CONFIRM_BUTTON);
    }
}
