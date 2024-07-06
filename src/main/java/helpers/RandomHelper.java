package helpers;

import commons.GlobalConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomHelper {
    public static String generateRandomEmail() {
        return "randomemail" + new Random().nextInt(19991998) + "@randmail.com";
    }

    public static String generateRandomUsername() {
        return "user_" + new Random().nextInt(299999);
    }

    public static String generateRandomEmployeeName() {
        return "Sample User " + new Random().nextInt(299999);
    }

    public static String generateRandomJobTitle() {
        List<String> jobTitles = new ArrayList<>();
        jobTitles.add("Developer");
        jobTitles.add("Tester");
        jobTitles.add("Designer");
        jobTitles.add("Product Manager");

        Random random = new Random();
        Collections.shuffle(jobTitles, random);
        return jobTitles.get(0) + new Random().nextInt(1020);
    }

    public static String generateRandomFirstName() {
        String[] firstNameArray = FileHelper.readJsonFileToArray(GlobalConstants.JAVA_RESOURCES_PATH, "RandomFirstName.json");
        Random random = new Random();
        return firstNameArray[random.nextInt(firstNameArray.length)];
    }

    public static String generateRandomMiddleName() {
        String[] middleNameArray = FileHelper.readJsonFileToArray(GlobalConstants.JAVA_RESOURCES_PATH, "RandomMiddleName.json");
        Random random = new Random();
        return middleNameArray[random.nextInt(middleNameArray.length)];
    }

    public static String generateRandomLastName() {
        String[] lastNameArray = FileHelper.readJsonFileToArray(GlobalConstants.JAVA_RESOURCES_PATH, "RandomLastName.json");
        Random random = new Random();
        return lastNameArray[random.nextInt(lastNameArray.length)];
    }
}
