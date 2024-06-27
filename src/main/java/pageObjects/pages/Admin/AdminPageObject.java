package pageObjects.pages.Admin;

import org.openqa.selenium.WebDriver;
import pageObjects.common.CommonPageActions;

public class AdminPageObject extends CommonPageActions {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        this.driver = driver;
    }
}
