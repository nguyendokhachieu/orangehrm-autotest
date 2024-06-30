package pageObjects.pages.Admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.Admin.AddJobTitlePageUI;

public class AddJobTitlePageObject extends AdminPageObject {
    private WebDriver driver;

    public AddJobTitlePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputToJobTitle(String title) {
        waitForElementVisible(driver, AddJobTitlePageUI.XPATH_JOB_TITLE_INPUT);
        sendKeyToElement(driver, AddJobTitlePageUI.XPATH_JOB_TITLE_INPUT, title);
    }

    public void inputToJobDescription(String description) {
        waitForElementVisible(driver, AddJobTitlePageUI.XPATH_JOB_DESCRIPTION_TEXTAREA);
        sendKeyToElement(driver, AddJobTitlePageUI.XPATH_JOB_DESCRIPTION_TEXTAREA, description);
    }

    public void uploadJobSpecificationFile(String filePath) {
        String originalStyle = getElementAttribute(driver, AddJobTitlePageUI.XPATH_JOB_SPECIFICATION_INPUT, "style");
        setAttributeInDOM(driver, AddJobTitlePageUI.XPATH_JOB_SPECIFICATION_INPUT, "style", "visibility: visible;max-width:10px;width:10px;height:10px;");
        sleepInSeconds(1);
        sendKeyToUploadFile(driver, AddJobTitlePageUI.XPATH_JOB_SPECIFICATION_INPUT, filePath);
        sleepInSeconds(1);
        setAttributeInDOM(driver, AddJobTitlePageUI.XPATH_JOB_SPECIFICATION_INPUT, "style", originalStyle);
    }

    public String getJobSpecificationFileStatus() {
        waitForElementVisible(driver, AddJobTitlePageUI.XPATH_JOB_SPEC_FILE_STATUS);
        return getElementText(driver, AddJobTitlePageUI.XPATH_JOB_SPEC_FILE_STATUS);
    }

    public void inputToNote(String note) {
        waitForElementVisible(driver, AddJobTitlePageUI.XPATH_NOTE_TEXTAREA);
        sendKeyToElement(driver, AddJobTitlePageUI.XPATH_NOTE_TEXTAREA, note);
    }

    public JobTitlesPageObject clickSaveButton() {
        waitForElementClickable(driver, AddJobTitlePageUI.XPATH_SAVE_BUTTON);
        clickToElement(driver, AddJobTitlePageUI.XPATH_SAVE_BUTTON);
        return PageGeneratorManager.getJobTitlesPage(driver);
    }
}
