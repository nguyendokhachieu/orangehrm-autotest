package helpers;

import io.qameta.allure.Attachment;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void deleteAllFileInFolder(String folderName) {
        try {
            String folderPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + folderName;
            File file = new File(folderPath);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile()) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public static boolean isFileExist(String folderPath, String fileName) {
        String filePath = folderPath + fileName;
        File file = new File(filePath);
        return file.exists();
    }

    public static String readJsonAttribute(String filePath, String attributeName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject json = new JSONObject(content);

            String attributeValue = json.getString(attributeName);

            return attributeValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readJsonAttribute(JSONObject jsonObject, String attributeName) {
        try {
            return jsonObject.getString(attributeName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONArray readJsonArray(String filePath, String attributeName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject json = new JSONObject(content);

            JSONArray jsonArray = json.getJSONArray(attributeName);

            return jsonArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String[] readJsonFileToArray(String folderPath, String fileName) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(folderPath + fileName)));

            JSONArray jsonArray = new JSONArray(content);

            String[] stringArray = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                stringArray[i] = jsonArray.getString(i);
            }

            return stringArray;
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
