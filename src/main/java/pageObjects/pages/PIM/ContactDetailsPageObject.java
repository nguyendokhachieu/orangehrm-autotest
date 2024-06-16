package pageObjects.pages.PIM;

import org.openqa.selenium.WebDriver;

public class ContactDetailsPageObject extends PIMPageObject {
    private WebDriver driver;

    public ContactDetailsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
