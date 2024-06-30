package pageObjects.pages.Admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.pages.Admin.JobTitlesPageUI;

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
}
