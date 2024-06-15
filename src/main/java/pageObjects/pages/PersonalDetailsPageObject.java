package pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pageUIs.pages.PersonalDetailsPageUI;

public class PersonalDetailsPageObject extends PIMPageObject {
    private WebDriver driver;

    public PersonalDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public Boolean waitPageTitleVisible(WebDriver driver) {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_PAGE_TITLE);
        return isElementDisplayed(driver, PersonalDetailsPageUI.XPATH_PAGE_TITLE);
    }

    public String getFirstName() {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_FIRSTNAME_INPUT);
        return getElementAttribute(driver, PersonalDetailsPageUI.XPATH_FIRSTNAME_INPUT, "value");
    }

    public String getMiddleName() {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_MIDDLENAME_INPUT);
        return getElementAttribute(driver, PersonalDetailsPageUI.XPATH_MIDDLENAME_INPUT, "value");
    }

    public String getLastName() {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_LASTNAME_INPUT);
        return getElementAttribute(driver, PersonalDetailsPageUI.XPATH_LASTNAME_INPUT, "value");
    }

    public void inputToDriversLicenseNumber(String number) {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_DRIVERS_LICENSE_NUMBER_INPUT);
        sendKeyToElement(driver, PersonalDetailsPageUI.XPATH_DRIVERS_LICENSE_NUMBER_INPUT, number);
    }

    // yyyy-mm-dd
    public void inputToLicenseExpiryDate(String date) {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_LICENSE_EXPIRY_DATE_INPUT);
        sendKeyToElement(driver, PersonalDetailsPageUI.XPATH_LICENSE_EXPIRY_DATE_INPUT, date);
    }

    public void selectNationality(String nationality) {
        selectItemInCustomDropdown(
                driver,
                PersonalDetailsPageUI.XPATH_NATIONALITY_SELECT_PARENT,
                PersonalDetailsPageUI.XPATH_NATIONALITY_SELECT_CHILDREN,
                nationality
        );
    }

    public void selectMaritalStatus(String status) {
        selectItemInCustomDropdown(
                driver,
                PersonalDetailsPageUI.XPATH_MARITAL_STATUS_SELECT_PARENT,
                PersonalDetailsPageUI.XPATH_MARITAL_STATUS_SELECT_CHILDREN,
                status
        );
    }

    public void inputToDateOfBirth(String date) {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_DATE_OF_BIRTH);
        sendKeyToElement(driver, PersonalDetailsPageUI.XPATH_DATE_OF_BIRTH, date);
    }

    public void selectGenderMale() {
        if (!isElementSelected(driver, PersonalDetailsPageUI.XPATH_GENDER_MALE_RADIO)) {
            clickToElementByJS(driver, PersonalDetailsPageUI.XPATH_GENDER_MALE_RADIO);
        }
    }

    public void selectGenderFemale() {
        if (!isElementSelected(driver, PersonalDetailsPageUI.XPATH_GENDER_FEMALE_RADIO)) {
            clickToElementByJS(driver, PersonalDetailsPageUI.XPATH_GENDER_FEMALE_RADIO);
        }
    }

    public void clickSaveButton() {
        waitForElementVisible(driver, PersonalDetailsPageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, PersonalDetailsPageUI.XPATH_SAVE_BUTTON);
    }
}
