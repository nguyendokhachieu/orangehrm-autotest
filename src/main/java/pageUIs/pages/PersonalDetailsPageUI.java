package pageUIs.pages;

public class PersonalDetailsPageUI {
    public static final String XPATH_PAGE_TITLE = "xpath=//h6[text()='Personal Details']";
    public static final String XPATH_FIRSTNAME_INPUT = "xpath=//input[@name='firstName']";
    public static final String XPATH_MIDDLENAME_INPUT = "xpath=//input[@name='middleName']";
    public static final String XPATH_LASTNAME_INPUT = "xpath=//input[@name='lastName']";
    public static final String XPATH_EMPLOYEE_ID_INPUT = "xpath=//label[text()='Employee Id']/parent::div/following-sibling::div/input";
    public static final String XPATH_OTHER_ID_INPUT = "xpath=//label[text()='Other Id']/parent::div/following-sibling::div/input";
    public static final String XPATH_DRIVERS_LICENSE_NUMBER_INPUT = "xpath=//label[text()=\"Driver's License Number\"]/parent::div/following-sibling::div/input";
    public static final String XPATH_LICENSE_EXPIRY_DATE_INPUT = "xpath=//label[text()='License Expiry Date']/parent::div/following-sibling::div//input";

    public static final String XPATH_NATIONALITY_SELECT_PARENT = "xpath=//label[text()='Nationality']/parent::div/following-sibling::div//i";
    public static final String XPATH_NATIONALITY_SELECT_CHILDREN = "xpath=//div[@class='oxd-select-option']//span";

    public static final String XPATH_MARITAL_STATUS_SELECT_PARENT = "xpath=//label[text()='Marital Status']/parent::div/following-sibling::div//i";
    public static final String XPATH_MARITAL_STATUS_SELECT_CHILDREN = "xpath=//div[@class='oxd-select-option']//span";

    public static final String XPATH_DATE_OF_BIRTH = "xpath=//label[text()='Date of Birth']/parent::div/following-sibling::div//input";

    public static final String XPATH_GENDER_MALE_RADIO = "xpath=//label[text()='Male']/input";
    public static final String XPATH_GENDER_FEMALE_RADIO = "xpath=//label[text()='Female']/input";

    public static final String XPATH_SAVE_BUTTON = "xpath=//button[contains(string(),'Save')]";
}