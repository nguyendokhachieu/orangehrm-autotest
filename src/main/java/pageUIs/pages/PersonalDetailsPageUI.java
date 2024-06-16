package pageUIs.pages;

public class PersonalDetailsPageUI {
    public static final String XPATH_PAGE_TITLE = "xpath=//h6[text()='Personal Details']";
    public static final String XPATH_CHANGE_PROFILE_PICTURE_TITLE = "xpath=//h6[text()='Change Profile Picture']";
    public static final String XPATH_AVATAR_IMAGE = "xpath=//img[@class='employee-image']";
    public static final String XPATH_AVATAR_UPLOAD_INPUT = "xpath=//input[@type='file']";
    public static final String XPATH_AVATAR_IMAGE_UPLOADED_BASE64 = "xpath=//img[starts-with(@src,'data:image')]";
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

    public static final String XPATH_ADD_BUTTON = "xpath=//button[contains(string(),'Add')]";
    public static final String XPATH_ATTACHMENT_UPLOAD_FILE_INPUT = "xpath=//h6[text()='Add Attachment']/parent::div//input[@type='file']";
    public static final String XPATH_FILE_UPLOAD_STATUS = "xpath=//h6[text()='Add Attachment']/parent::div//div[@class='oxd-file-input-div']";
    public static final String XPATH_ATTACHMENT_COMMENT_TEXTAREA = "xpath=//h6[text()='Add Attachment']/parent::div//textarea";
    public static final String XPATH_ATTACHMENT_SAVE_BUTTON = "xpath=//h6[text()='Add Attachment']/parent::div//button[contains(string(),'Save')]";
    public static final String XPATH_TABLE_CARD = "xpath=//div[@class='oxd-table-card']";
    public static final String XPATH_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//div[@role='columnheader' and text()='%s']//preceding-sibling::div";
    public static final String XPATH_TABLE_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//div[@class='oxd-table-card'][%s]//div[@role='cell'][%s]/div";
}