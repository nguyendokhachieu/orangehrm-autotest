package helpers;

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
}
