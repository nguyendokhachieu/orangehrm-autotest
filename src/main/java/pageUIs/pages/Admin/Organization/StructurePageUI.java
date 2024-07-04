package pageUIs.pages.Admin.Organization;

public class StructurePageUI {
    public static final String XPATH_EDIT_TOGGLE = "xpath=//label[text()='Edit']/input";
    public static final String XPATH_ADD_BUTTON = "xpath=//button[contains(string(),'Add')]";
    public static final String FM_XPATH_ORG_NAME = "xpath=//div[@class='org-name' and text()='%s']";
    public static final String FM_XPATH_TOGGLE_BUTTON_BY_ORG_NAME = "xpath=//div[@class='org-name' and text()='%s']//ancestor::div/span[@class='oxd-tree-node-toggle']/button";
    public static final String FM_XPATH_PLUS_BUTTON_BY_ORG_NAME = "xpath=//div[@class='org-name' and text()='%s']/following-sibling::div//button/i[contains(@class,'bi-plus')]";
    public static final String XPATH_ADD_ORG_DIALOG_TITLE = "xpath=//div[@role='dialog']//p[text()='Add Organization Unit']";
    public static final String FM_XPATH_INPUT_BY_LABEL = "xpath=//label[text()='%s']/parent::div/following-sibling::div//input";
    public static final String XPATH_DESCRIPTION_INPUT = "xpath=//label[text()='Description']/parent::div/following-sibling::div//textarea";
    public static final String XPATH_SAVE_BUTTON = "xpath=//button[text()=' Save ']";

}
