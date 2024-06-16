package helpers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonHelper {
    public static JSONObject readJsonFromFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        bufferedReader.close();
        fileReader.close();

        String jsonString = stringBuilder.toString();
        JSONObject jsonObject = new JSONObject(jsonString);

        return jsonObject;
    }
}