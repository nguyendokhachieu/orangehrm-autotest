package pageObjects.pages;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.pages.EmployeeListPageUI;

public class EmployeeListPageObject extends PIMPageObject {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AddEmployeePageObject clickAddButton(WebDriver driver) {
        waitForElementClickable(driver, EmployeeListPageUI.XPATH_ADD_BUTTON);
        clickToElement(driver, EmployeeListPageUI.XPATH_ADD_BUTTON);
        return PageGeneratorManager.getAddEmployeePage(driver);
    }
}
