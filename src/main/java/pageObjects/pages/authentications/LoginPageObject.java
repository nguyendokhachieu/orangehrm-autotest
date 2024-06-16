package pageObjects.pages.authentications;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.pages.Dashboard.DashboardPageObject;
import pageUIs.pages.authentications.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    private void inputToUsername(String username) {
        waitForElementVisible(driver, LoginPageUI.XPATH_USERNAME_INPUT);
        sendKeyToElement(driver, LoginPageUI.XPATH_USERNAME_INPUT, username);
    }

    private void inputToPassword(String password) {
        waitForElementVisible(driver, LoginPageUI.XPATH_PASSWORD_INPUT);
        sendKeyToElement(driver, LoginPageUI.XPATH_PASSWORD_INPUT, password);
    }

    private void clickLoginButton() {
        waitForElementClickable(driver, LoginPageUI.XPATH_LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.XPATH_LOGIN_BUTTON);
    }

    public DashboardPageObject loginWithUsernameAndPassword(String username, String password) {
        inputToUsername(username);
        inputToPassword(password);
        clickLoginButton();
        return PageGeneratorManager.getDashboardPage(driver);
    }
}
