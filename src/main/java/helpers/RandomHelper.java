package helpers;

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
}
