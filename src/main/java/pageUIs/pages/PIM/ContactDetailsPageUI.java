package pageUIs.pages.PIM;

public class ContactDetailsPageUI {
    public static final String FM_XPATH_INPUT = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input";
    public static final String XPATH_STREET_1_INPUT = "xpath=//label[text()='Street 1']/parent::div/following-sibling::div//input";
    public static final String XPATH_STREET_2_INPUT = "xpath=//label[text()='Street 2']/parent::div/following-sibling::div//input";
    public static final String XPATH_CITY_INPUT = "xpath=//label[text()='City']/parent::div/following-sibling::div//input";
    public static final String XPATH_STATE_PROVINCE_INPUT = "xpath=//label[text()='State/Province']/parent::div/following-sibling::div//input";
    public static final String XPATH_ZIP_POSTAL_CODE_INPUT = "xpath=//label[text()='Zip/Postal Code']/parent::div/following-sibling::div//input";
    public static final String XPATH_COUNTRY_SELECT_PARENT = "xpath=//label[text()='Country']/parent::div/following-sibling::div//i";
    public static final String FM_XPATH_COUNTRY_SELECT_CHILD = "xpath=//div[@class='oxd-select-option']/span[text()='%s']";
    public static final String FM_XPATH_SELECTED_COUNTRY = "xpath=//div[@class='oxd-select-text-input' and text()='%s']";
    public static final String XPATH_WORK_EMAIL_INPUT = "xpath=//label[text()='Work Email']/parent::div/following-sibling::div//input";
    public static final String XPATH_OTHER_EMAIL_INPUT = "xpath=//label[text()='Other Email']/parent::div/following-sibling::div//input";
    public static final String XPATH_SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";
}
