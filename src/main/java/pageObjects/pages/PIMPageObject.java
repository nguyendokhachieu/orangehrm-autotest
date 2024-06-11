package pageObjects.pages;

import org.openqa.selenium.WebDriver;
import pageObjects.common.CommonPageActions;

public class PIMPageObject extends CommonPageActions {
    private WebDriver driver;

    public PIMPageObject(WebDriver driver) {
        this.driver = driver;
    }


}
