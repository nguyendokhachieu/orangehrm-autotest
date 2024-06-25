package pageObjects.pages.Admin;

import org.openqa.selenium.WebDriver;

public class EditUserPageObject extends AdminPageObject {
    private WebDriver driver;

    public EditUserPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
