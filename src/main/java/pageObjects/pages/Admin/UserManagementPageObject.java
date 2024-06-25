package pageObjects.pages.Admin;

import org.openqa.selenium.WebDriver;

public class UserManagementPageObject extends AdminPageObject {
    private WebDriver driver;

    public UserManagementPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
