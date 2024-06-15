package pageObjects.common;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.common.CommonPageUI;

public class CommonPageActions extends BasePage {
    public void clickLeftSidebarLink(WebDriver driver, String linkText) {
        if (!CommonPageUI.SIDEBAR_LINK_TEXT.containsValue(linkText)) {
            throw new RuntimeException("Wrong sidebar link!");
        }
        waitForElementClickable(driver, CommonPageUI.FM_XPATH_LEFT_SIDEBAR_LINK, linkText);
        clickToElement(driver, CommonPageUI.FM_XPATH_LEFT_SIDEBAR_LINK, linkText);
    }

    public Boolean waitLoadingIconInvisible(WebDriver driver) {
        waitForListElementsInvisible(driver, CommonPageUI.XPATH_LOADING_ICON);
        return isElementUndisplayed(driver, CommonPageUI.XPATH_LOADING_ICON);
    }

    public Boolean waitToastMessageVisible(WebDriver driver, String message) {
        waitForElementVisible(driver, CommonPageUI.FM_XPATH_TOAST_MESSAGE, message);
        return isElementDisplayed(driver, CommonPageUI.FM_XPATH_TOAST_MESSAGE, message);
    }
}