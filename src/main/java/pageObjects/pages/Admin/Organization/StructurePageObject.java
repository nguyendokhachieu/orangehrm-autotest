package pageObjects.pages.Admin.Organization;

import org.openqa.selenium.WebDriver;
import pageObjects.pages.Admin.common.AdminPageObject;
import pageUIs.pages.Admin.Organization.StructurePageUI;

public class StructurePageObject extends AdminPageObject {
    private WebDriver driver;

    public StructurePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickEditToggle() {
        clickToElementByJS(driver, StructurePageUI.XPATH_EDIT_TOGGLE);
    }

    public void clickAddButton() {
        waitForElementClickable(driver, StructurePageUI.XPATH_ADD_BUTTON);
        clickToElement(driver, StructurePageUI.XPATH_ADD_BUTTON);
    }

    public void inputToLabeledField(String labelName, String value) {
        waitForElementVisible(driver, StructurePageUI.FM_XPATH_INPUT_BY_LABEL, labelName);
        sendKeyToElement(driver, StructurePageUI.FM_XPATH_INPUT_BY_LABEL, value, labelName);
    }

    public void inputToDescription(String value) {
        waitForElementVisible(driver, StructurePageUI.XPATH_DESCRIPTION_INPUT);
        sendKeyToElement(driver, StructurePageUI.XPATH_DESCRIPTION_INPUT, value);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, StructurePageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, StructurePageUI.XPATH_SAVE_BUTTON);
    }

    public void clickPlusButton(String unitId, String name) {
        String orgName = unitId + ": " + name;
        waitForElementClickable(driver, StructurePageUI.FM_XPATH_PLUS_BUTTON_BY_ORG_NAME, orgName);
        clickToElement(driver, StructurePageUI.FM_XPATH_PLUS_BUTTON_BY_ORG_NAME, orgName);
    }

    public void clickPlusButton(String name) {
        waitForElementClickable(driver, StructurePageUI.FM_XPATH_PLUS_BUTTON_BY_ORG_NAME, name);
        clickToElement(driver, StructurePageUI.FM_XPATH_PLUS_BUTTON_BY_ORG_NAME, name);
    }

    public void clickToggleButtonByOrgName(String unitId, String name) {
        String orgName = unitId + ": " + name;
        waitForElementClickable(driver, StructurePageUI.FM_XPATH_TOGGLE_BUTTON_BY_ORG_NAME, orgName);
        clickToElement(driver, StructurePageUI.FM_XPATH_TOGGLE_BUTTON_BY_ORG_NAME, orgName);
    }

    public void clickToggleButtonByOrgName(String name) {
        waitForElementClickable(driver, StructurePageUI.FM_XPATH_TOGGLE_BUTTON_BY_ORG_NAME, name);
        clickToElement(driver, StructurePageUI.FM_XPATH_TOGGLE_BUTTON_BY_ORG_NAME, name);
    }

    public boolean isOrgNameDisplayed(String unitId, String name) {
        String orgName = unitId + ": " + name;
        waitForElementVisible(driver, StructurePageUI.FM_XPATH_ORG_NAME, orgName);
        return isElementDisplayed(driver, StructurePageUI.FM_XPATH_ORG_NAME, orgName);
    }

    public boolean isOrgNameDisplayed(String name) {
        waitForElementVisible(driver, StructurePageUI.FM_XPATH_ORG_NAME, name);
        return isElementDisplayed(driver, StructurePageUI.FM_XPATH_ORG_NAME, name);
    }

    public boolean isOrgNameUndisplayed(String unitId, String name) {
        String orgName = unitId + ": " + name;
        return isElementUndisplayed(driver, StructurePageUI.FM_XPATH_ORG_NAME, orgName);
    }

    public boolean isOrgNameUndisplayed(String name) {
        return isElementUndisplayed(driver, StructurePageUI.FM_XPATH_ORG_NAME, name);
    }

    public void waitAddOrganizationDialogUndisplayed() {
        waitForListElementsInvisible(driver, StructurePageUI.XPATH_ADD_ORG_DIALOG_TITLE);
    }

}
