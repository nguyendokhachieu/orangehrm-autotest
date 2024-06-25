package pageObjects.pages.Admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminPageObject extends BasePage {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
