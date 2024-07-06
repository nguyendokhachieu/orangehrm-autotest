package pageObjects.pages.Maintenance;

import org.openqa.selenium.WebDriver;

public class PurgeEmployeeRecordsPageObject extends MaintenancePageObject {
    private WebDriver driver;

    public PurgeEmployeeRecordsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
