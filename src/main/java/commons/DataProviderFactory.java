package commons;

import helpers.JsonHelper;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;

public class DataProviderFactory {
    @DataProvider(name = "jsonData")
    public Object[][] jsonData(Method method) {
        try {
            String methodName = method.getName();
            String testcaseCode = methodName.split("_")[0];

            JSONObject jsonObject = JsonHelper.readJsonFromFile(GlobalConstants.TEST_RESOURCES_TEST_DATA_PATH + testcaseCode + ".json");

            return new Object[][]{
                    {jsonObject}
            };
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[][]{};
        }
    }
}
