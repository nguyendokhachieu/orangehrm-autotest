package testcases.PIM;

import commons.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmployeeTestCase extends BaseTest {

    @BeforeClass
    public void beforeClass() {

    }

    @Description("TC001")
    @Test
    public void TC001_AddNewEmployee() {
        Allure.step("Step 01 - ");
        Allure.step("Step 02 - ");

    }
}
