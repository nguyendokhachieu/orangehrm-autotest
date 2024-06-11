package pageObjects.common;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.common.CommonPageUI;

public class CommonPageActions extends BasePage {
    protected void clickLeftSidebarLink(WebDriver driver, String linkText) {
        for (String key : CommonPageUI.SIDEBAR_LINK_TEXT.keySet()) {
            if (!CommonPageUI.SIDEBAR_LINK_TEXT.get(key).equals(linkText)) {
                throw new RuntimeException("Wrong sidebar link!");
            }
        }
        waitForElementClickable(driver, CommonPageUI.FM_XPATH_LEFT_SIDEBAR_LINK, linkText);
        clickToElement(driver, CommonPageUI.FM_XPATH_LEFT_SIDEBAR_LINK, linkText);
    }
}