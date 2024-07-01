package pageObjects.pages.Admin.Job;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.pages.Admin.common.AdminPageObject;
import pageUIs.pages.Admin.Job.JobTitlesPageUI;

import java.util.List;

public class JobTitlesPageObject extends AdminPageObject {
    private WebDriver driver;

    public JobTitlesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddJobTitlePageObject clickAddButton() {
        waitForElementClickable(driver, JobTitlesPageUI.XPATH_ADD_BUTTON);
        clickToElement(driver, JobTitlesPageUI.XPATH_ADD_BUTTON);
        return PageGeneratorManager.getAddJobTitlePage(driver);
    }

    private List<WebElement> getAllTableRows() {
        waitForListElementsVisible(driver, JobTitlesPageUI.XPATH_TABLE_ROW);
        return getListWebElements(driver, JobTitlesPageUI.XPATH_TABLE_ROW);
    }

    private String getRowInfo(WebElement webElement) {
        return webElement.getText();
    }

    public boolean isJobTitleAdded(String jobTitle, String jobDescription) {
        List<WebElement> webElements = getAllTableRows();
        boolean isAdded = false;
        for(WebElement webElement: webElements) {
            String rowInfo = getRowInfo(webElement);
            if (rowInfo.contains(jobTitle) && rowInfo.contains(jobDescription)) {
                isAdded = true;
                break;
            }
        }
        return isAdded;
    }

    public void checkToRowCheckboxByJobTitle(String jobTitle) {
        clickToElementByJS(driver, JobTitlesPageUI.FM_XPATH_ROW_CHECKBOX_BY_JOB_TITLE, jobTitle);
    }

    public void clickDeleteSelectedButton() {
        waitForElementClickable(driver, JobTitlesPageUI.XPATH_DELETE_SELECTED_BUTTON);
        clickToElement(driver, JobTitlesPageUI.XPATH_DELETE_SELECTED_BUTTON);
    }

    public void clickYesDeleteButton() {
        waitForElementClickable(driver, JobTitlesPageUI.XPATH_YES_DELETE_BUTTON);
        clickToElement(driver, JobTitlesPageUI.XPATH_YES_DELETE_BUTTON);
    }

    public boolean isRowUndisplayedByJobTitle(String jobTitle) {
        waitForElementInvisible(driver, JobTitlesPageUI.FM_XPATH_ROW_BY_JOB_TITLE, jobTitle);
        return isElementUndisplayed(driver, JobTitlesPageUI.FM_XPATH_ROW_BY_JOB_TITLE, jobTitle);
    }
}
