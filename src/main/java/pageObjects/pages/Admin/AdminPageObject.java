package pageObjects.pages.Admin;

import org.openqa.selenium.WebDriver;
import pageObjects.common.CommonPageActions;
import pageUIs.pages.Admin.AdminPageUI;

public class AdminPageObject extends CommonPageActions {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopbarDropdown(String name) {
        waitForElementClickable(driver, AdminPageUI.FM_XPATH_TOPBAR_DROPDOWN, name);
        clickToElement(driver, AdminPageUI.FM_XPATH_TOPBAR_DROPDOWN, name);
    }

    public void clickNavLinkInDropdown(String linkName) {
        waitForElementClickable(driver, AdminPageUI.FM_XPATH_NAV_LINK_IN_DROPDOWN, linkName);
        clickToElement(driver, AdminPageUI.FM_XPATH_NAV_LINK_IN_DROPDOWN, linkName);
    }
}
