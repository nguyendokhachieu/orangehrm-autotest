package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private long timeout = 10;
    private long shortTimeout = 5;

    public void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getDynamicLocator(String formattedLocator, String... values) {
        if (formattedLocator.toLowerCase().startsWith("css=") || formattedLocator.toLowerCase().startsWith("xpath=")) {
            return String.format(formattedLocator, (Object[]) values);
        }
        throw new RuntimeException("Locator is wrong, must start with [\"css=\", \"xpath=\"]");
    }

    private By getByLocator(String locator) {
        if (locator.toLowerCase().startsWith("css=")) {
            return By.cssSelector(locator.substring(4));
        } else if (locator.toLowerCase().startsWith("xpath=")) {
            return By.xpath(locator.substring(6));
        }
        throw new RuntimeException("Locator is wrong, must start with [\"css=\", \"xpath=\"]");
    }

    protected void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getCurrentPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSourceCode(WebDriver driver) {
        return driver.getPageSource();
    }

    public Set<Cookie> getCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    protected void addCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie: cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    protected void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    protected void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    private Alert waitForAlertPresence(WebDriver driver) {
        return (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    protected void dismissAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    protected void getTextFromAlert(WebDriver driver) {
        waitForAlertPresence(driver).getText();
    }

    protected void sendkeyToAlert(WebDriver driver, String keyToSend) {
        waitForAlertPresence(driver).sendKeys(keyToSend);
    }

    public void switchToTabByID(WebDriver driver, String id) {
        Set<String> allTabIds = driver.getWindowHandles();
        for (String tabId: allTabIds) {
            if (!tabId.equals(id)) {
                driver.switchTo().window(tabId);
                break;
            }
        }
    }

    public void switchToTabByTitle(WebDriver driver, String title) {
        Set<String> allTabIds = driver.getWindowHandles();
        for (String tabId: allTabIds) {
            driver.switchTo().window(tabId);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    public int countNumberOfTabsInBrowser(WebDriver driver) {
        return driver.getWindowHandles().size();
    }

    public void closeAllTabsExceptId(WebDriver driver, String id) {
        Set<String> allTabIds = driver.getWindowHandles();
        for (String tabId: allTabIds) {
            if (!tabId.equals(id)) {
                driver.switchTo().window(tabId);
                driver.close();
            }
        }
        driver.switchTo().window(id);
    }

    public void closeAllTabsExceptTitle(WebDriver driver, String title) {
        Set<String> allTabIds = driver.getWindowHandles();
        String originalId = driver.getWindowHandle();
        for (String tabId: allTabIds) {
            driver.switchTo().window(tabId);
            if (!driver.getTitle().equals(title)) {
                driver.switchTo().window(tabId);
                driver.close();
            } else {
                originalId = driver.getWindowHandle();
            }
        }
        driver.switchTo().window(originalId);
    }

    protected WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    protected WebElement getWebElement(WebDriver driver, String locator, String... values) {
        return driver.findElement(getByLocator(getDynamicLocator(locator, values)));
    }

    protected List<WebElement> getListWebElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    protected List<WebElement> getListWebElements(WebDriver driver, String locator, String... values) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, values)));
    }

    protected int getSizeOfListElements(WebDriver driver, String locator) {
        return getListWebElements(driver, locator).size();
    }

    protected int getSizeOfListElements(WebDriver driver, String locator, String... values) {
        return getListWebElements(driver, getDynamicLocator(locator, values)).size();
    }

    protected void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    protected void clickToElement(WebDriver driver, String locator, String... values) {
        getWebElement(driver, locator, values).click();
    }

    private void clearField(WebElement element){
        while(!element.getAttribute("value").equals("")){
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String keyToSend) {
        WebElement webElement = getWebElement(driver, locator);
        webElement.clear();
        clearField(webElement);
        webElement.sendKeys(keyToSend);
    }

    protected void sendKeyToElement(WebDriver driver, String locator, String keyToSend, String... values) {
        WebElement webElement = getWebElement(driver, locator, values);
        webElement.clear();
        clearField(webElement);
        webElement.sendKeys(keyToSend);
    }

    protected void sendKeyToUploadFile(WebDriver driver, String locator, String keyToSend) {
        WebElement webElement = getWebElement(driver, locator);
        webElement.sendKeys(keyToSend);
    }

    protected void sendKeyToUploadFile(WebDriver driver, String locator, String keyToSend, String... values) {
        WebElement webElement = getWebElement(driver, getDynamicLocator(locator, values));
        webElement.sendKeys(keyToSend);
    }

    protected void selectItemInDefaultDropdown(WebDriver driver, String locator, String text) {
        (new Select(getWebElement(driver, locator))).selectByVisibleText(text);
    }

    protected String getFirstSelectedValueInDefaultDropdown(WebDriver driver, String locator) {
        return (new Select(getWebElement(driver, locator))).getFirstSelectedOption().getText();
    }

    protected Boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return (new Select(getWebElement(driver, locator))).isMultiple();
    }

    protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String visibleText) {
        waitForElementClickable(driver, parentLocator);
        clickToElement(driver, parentLocator);
        sleepInSeconds(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        List<WebElement> allOptions = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
        for (WebElement option: allOptions) {
            if (option.getText().trim().equals(visibleText)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
                sleepInSeconds(1);
                option.click();
                sleepInSeconds(1);
                break;
            }
        }
    }

    protected void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String visibleText, String... values) {
        waitForElementClickable(driver, parentLocator);
        clickToElement(driver, parentLocator);
        sleepInSeconds(1);
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        List<WebElement> allOptions = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(getDynamicLocator(childLocator, values))));
        for (WebElement option: allOptions) {
            if (option.getText().trim().equals(visibleText)) {
                JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                jsExecutor.executeScript("arguments[0].scrollIntoView(true);", option);
                sleepInSeconds(1);
                option.click();
                sleepInSeconds(1);
                break;
            }
        }
    }

    protected void scrollIntoViewByJS(WebDriver driver, String locator) {
        WebElement webElement = getWebElement(driver, locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        sleepInSeconds(1);
    }

    protected void scrollIntoViewByJS(WebDriver driver, String locator, String... values) {
        WebElement webElement = getWebElement(driver, locator, values);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        sleepInSeconds(1);
    }

    protected String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    protected String getElementText(WebDriver driver, String locator, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).getText();
    }

    protected String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    protected String getElementAttribute(WebDriver driver, String locator, String attributeName, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).getAttribute(attributeName);
    }

    protected String getElementCssValue(WebDriver driver, String locator, String cssAttribute) {
        return getWebElement(driver, locator).getCssValue(cssAttribute);
    }

    protected String getElementCssValue(WebDriver driver, String locator, String cssAttribute, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).getCssValue(cssAttribute);
    }

    protected String convertRGBAToHex(WebDriver driver, String RGBAValue) {
        return Color.fromString(RGBAValue).asHex();
    }

    protected void checkToElement(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    protected void checkToElement(WebDriver driver, String locator, String... values) {
        if (!getWebElement(driver, getDynamicLocator(locator, values)).isSelected()) {
            clickToElement(driver, getDynamicLocator(locator, values));
        }
    }

    protected void uncheckToElement(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    protected void uncheckToElement(WebDriver driver, String locator, String... values) {
        if (getWebElement(driver, getDynamicLocator(locator, values)).isSelected()) {
            clickToElement(driver, getDynamicLocator(locator, values));
        }
    }

    protected Boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    protected Boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).isDisplayed();
    }

    protected Boolean isElementSelected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    protected Boolean isElementSelected(WebDriver driver, String locator, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).isSelected();
    }

    protected Boolean isElementEnabled(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    protected Boolean isElementEnabled(WebDriver driver, String locator, String... values) {
        return getWebElement(driver, getDynamicLocator(locator, values)).isEnabled();
    }

    protected void switchToIframe(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getWebElement(driver, locator)));
        driver.switchTo().frame(getWebElement(driver, locator));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    protected void hoverToElement(WebDriver driver, String locator) {
        (new Actions(driver)).moveToElement(getWebElement(driver, locator)).perform();
    }

    protected void hoverToElement(WebDriver driver, String locator, String... values) {
        (new Actions(driver)).moveToElement(getWebElement(driver, getDynamicLocator(locator, values))).perform();
    }

    protected void doubleClickToElement(WebDriver driver, String locator) {
        (new Actions(driver)).doubleClick(getWebElement(driver, locator)).perform();
    }

    protected void doubleClickToElement(WebDriver driver, String locator, String... values) {
        (new Actions(driver)).doubleClick(getWebElement(driver, getDynamicLocator(locator, values))).perform();
    }

    protected void rightClickToElement(WebDriver driver, String locator) {
        (new Actions(driver)).contextClick(getWebElement(driver, locator)).perform();
    }

    protected void rightClickToElement(WebDriver driver, String locator, String... values) {
        (new Actions(driver)).contextClick(getWebElement(driver, getDynamicLocator(locator, values))).perform();
    }

    protected void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        (new Actions(driver)).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    protected void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
        (new Actions(driver)).sendKeys(getWebElement(driver, locator), key).perform();
    }

    protected void highlightElement(WebDriver driver, String locator) {
        String originalStyle = getElementAttribute(driver, locator, "style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])",
                getWebElement(driver, locator), "border: 2px solid red; border-style: dashed");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])",
                getWebElement(driver, locator), originalStyle);
    }

    protected void clickToElementByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
        sleepInSeconds(3);
    }

    protected void clickToElementByJS(WebDriver driver, String locator, String... values) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicLocator(locator, values)));
        sleepInSeconds(3);
    }

    protected void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    protected void scrollToElementOnBottomByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    protected void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(, document.body.scrollHeight);");
    }

    protected void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, locator));
    }

    protected void setAttributeInDOM(WebDriver driver, String locator, String attributeName, String attributeValue, String... values) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, getDynamicLocator(locator, values)));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeToBeRemoved) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeToBeRemoved + "')'", getWebElement(driver, locator));
    }

    protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeToBeRemoved, String... values) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute(\"" + attributeToBeRemoved + "\")", getWebElement(driver, getDynamicLocator(locator, values)));
    }

    protected void sendKeyToElementByJS(WebDriver driver, String locator, String keyToSend) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + keyToSend + "')'", getWebElement(driver, locator));
    }

    protected String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "')'", getWebElement(driver, locator));
    }

    protected String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    protected Boolean isImageLoaded(WebDriver driver, String locator) {
        return (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
    }

    protected void waitForElementVisible(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementVisible(WebDriver driver, String locator, String... values) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, values))));
    }

    protected void waitForListElementsVisible(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    protected void waitForListElementsVisible(WebDriver driver, String locator, String... values) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicLocator(locator, values))));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    protected void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicLocator(locator, values))));
    }

    protected void waitForListElementsInvisible(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, locator)));
    }

    protected void waitForListElementsInvisible(WebDriver driver, String locator, String... values) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.invisibilityOfAllElements(getListWebElements(driver, getDynamicLocator(locator, values))));
    }

    protected void waitForElementClickable(WebDriver driver, String locator) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    protected void waitForElementClickable(WebDriver driver, String locator, String... values) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, values))));
    }

    protected void waitForNumberOfWindowsToBe(WebDriver driver, int numberOfWindows) {
        (new WebDriverWait(driver, Duration.ofSeconds(timeout))).until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
    }

    private void overrideGlobalTimeout(WebDriver driver, long newTimeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(newTimeout));
    }

    protected Boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> listElements = getListWebElements(driver, locator);
        overrideGlobalTimeout(driver, timeout);

        if (listElements.size() == 0) {
            return true;
        } else if (listElements.size() > 0 && !listElements.get(0).isDisplayed()) {
            return true;
        }
        return false;
    }

    protected Boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
        overrideGlobalTimeout(driver, shortTimeout);
        List<WebElement> listElements = getListWebElements(driver, getDynamicLocator(locator, values));
        overrideGlobalTimeout(driver, timeout);

        if (listElements.size() == 0) {
            return true;
        } else if (listElements.size() > 0 && !listElements.get(0).isDisplayed()) {
            return true;
        }
        return false;
    }
}
