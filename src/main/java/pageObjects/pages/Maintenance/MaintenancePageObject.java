package pageObjects.pages.Maintenance;

import org.openqa.selenium.WebDriver;
import pageObjects.common.CommonPageActions;
import pageUIs.pages.Maintenance.MaintenancePageUI;

public class MaintenancePageObject extends CommonPageActions {
    private WebDriver driver;

    public MaintenancePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopbarDropdown(String name) {
        waitForElementClickable(driver, MaintenancePageUI.FM_XPATH_TOPBAR_DROPDOWN, name);
        clickToElement(driver, MaintenancePageUI.FM_XPATH_TOPBAR_DROPDOWN, name);
    }

    public void clickTopbarAccessRecordsLink() {
        waitForElementClickable(driver, MaintenancePageUI.XPATH_TOPBAR_ACCESS_RECORDS_LINK);
        clickToElement(driver, MaintenancePageUI.XPATH_TOPBAR_ACCESS_RECORDS_LINK);
    }

    public void clickNavLinkInDropdown(String linkName) {
        waitForElementClickable(driver, MaintenancePageUI.FM_XPATH_NAV_LINK_IN_DROPDOWN, linkName);
        clickToElement(driver, MaintenancePageUI.FM_XPATH_NAV_LINK_IN_DROPDOWN, linkName);
    }
}
