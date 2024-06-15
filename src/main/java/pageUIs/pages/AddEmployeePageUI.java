package pageUIs.pages;

public class AddEmployeePageUI {
    public static final String XPATH_FIRSTNAME_INPUT = "xpath=//input[@name='firstName']";
    public static final String XPATH_MIDDLENAME_INPUT = "xpath=//input[@name='middleName']";
    public static final String XPATH_LASTNAME_INPUT = "xpath=//input[@name='lastName']";
    public static final String XPATH_EMPLOYEE_ID_INPUT = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String XPATH_CREATE_LOGIN_DETAILS_CHECKBOX = "xpath=//p[text()='Create Login Details']/following-sibling::div/label/input";
    public static final String XPATH_USERNAME_INPUT = "xpath=//label[text()='Username']/parent::div/following-sibling::div/input";
    public static final String XPATH_STATUS_ENABLED_RADIO = "xpath=//label[text()='Enabled']/input";
    public static final String XPATH_STATUS_DISABLED_RADIO = "xpath=//label[text()='Disabled']/input";
    public static final String XPATH_PASSWORD_INPUT = "xpath=//label[text()='Password']/parent::div/following-sibling::div/input";
    public static final String XPATH_CONFIRM_PASSWORD_INPUT = "xpath=//label[text()='Confirm Password']/parent::div/following-sibling::div/input";
    public static final String XPATH_SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";
    public static final String XPATH_CANCEL_BUTTON = "xpath=//button[contains(string(),'Cancel')]";

}
