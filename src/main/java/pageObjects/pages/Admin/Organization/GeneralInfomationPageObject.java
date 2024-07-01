package pageObjects.pages.Admin.Organization;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.Admin.common.AdminPageObject;
import pageUIs.pages.Admin.Organization.GeneralInfomationPageUI;

public class GeneralInfomationPageObject extends AdminPageObject {
    private WebDriver driver;

    public GeneralInfomationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isTextInputByLabelEnabled(String label) {
        waitForElementVisible(driver, GeneralInfomationPageUI.FM_XPATH_TEXT_INPUT_BY_LABEL, label);
        return isElementEnabled(driver, GeneralInfomationPageUI.FM_XPATH_TEXT_INPUT_BY_LABEL, label);
    }

    public void clickEditToggle() {
        clickToElementByJS(driver, GeneralInfomationPageUI.XPATH_EDIT_TOGGLE);
    }

    public boolean isCountryDropdownEnabled() {
        waitForElementVisible(driver, GeneralInfomationPageUI.XPATH_COUNTRY_DROPDOWN_PARENT);
        return isElementDisplayed(driver, GeneralInfomationPageUI.XPATH_COUNTRY_DROPDOWN_PARENT);
    }

    public boolean isCountryDropdownDisabled() {
        return isElementUndisplayed(driver, GeneralInfomationPageUI.XPATH_COUNTRY_DROPDOWN_PARENT);
    }

    public boolean isNotesEnabled() {
        waitForElementVisible(driver, GeneralInfomationPageUI.XPATH_NOTES_TEXTAREA);
        return isElementEnabled(driver, GeneralInfomationPageUI.XPATH_NOTES_TEXTAREA);
    }
}
