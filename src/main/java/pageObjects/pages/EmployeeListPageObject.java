package pageObjects.pages;

import org.openqa.selenium.WebDriver;

public class EmployeeListPageObject extends PIMPageObject {
    private WebDriver driver;

    public EmployeeListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
