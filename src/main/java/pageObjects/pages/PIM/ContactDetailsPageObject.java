package pageObjects.pages.PIM;

import org.openqa.selenium.WebDriver;
import pageUIs.pages.PIM.ContactDetailsPageUI;

public class ContactDetailsPageObject extends PIMPageObject {
    private WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToFieldByFieldName(String fieldName, String value) {
        waitForElementVisible(driver, ContactDetailsPageUI.FM_XPATH_INPUT, fieldName);
        sendKeyToElement(driver, ContactDetailsPageUI.FM_XPATH_INPUT, value, fieldName);
    }

    public void selectCountry(String countryName) {
        if (!isCountrySelected(countryName)) {
            selectItemInCustomDropdown(driver, ContactDetailsPageUI.XPATH_COUNTRY_SELECT_PARENT, ContactDetailsPageUI.FM_XPATH_COUNTRY_SELECT_CHILD, countryName);
        }
    }

    public boolean isCountrySelected(String selectedCountry) {
        waitForElementVisible(driver, ContactDetailsPageUI.FM_XPATH_SELECTED_COUNTRY, selectedCountry);
        return isElementDisplayed(driver, ContactDetailsPageUI.FM_XPATH_SELECTED_COUNTRY, selectedCountry);
    }

    public void clickSaveButton() {
        waitForElementClickable(driver, ContactDetailsPageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, ContactDetailsPageUI.XPATH_SAVE_BUTTON);
    }

    public String getValueFromFieldByFieldName(String fieldName) {
        waitForElementVisible(driver, ContactDetailsPageUI.FM_XPATH_INPUT, fieldName);
        return getElementAttribute(driver, ContactDetailsPageUI.FM_XPATH_INPUT, "value", fieldName);
    }
}
