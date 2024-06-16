package pageObjects.pages.PIM;

import org.openqa.selenium.WebDriver;
import pageObjects.common.CommonPageActions;
import pageUIs.pages.PIM.PIMPageUI;

public class PIMPageObject extends CommonPageActions {
    private WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEmployeeInfoTabItem(String tabName) {
        waitForElementVisible(driver, PIMPageUI.FM_XPATH_EMPLOYEE_INFO_TAB_ITEM, tabName);
        clickToElement(driver, PIMPageUI.FM_XPATH_EMPLOYEE_INFO_TAB_ITEM, tabName);
    }

}
