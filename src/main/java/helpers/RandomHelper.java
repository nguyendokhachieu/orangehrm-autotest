package helpers;

import java.util.Random;

public class RandomHelper {
    public static String generateRandomEmail() {
        return "randomemail" + new Random().nextInt(19991998) + "@randmail.com";
    }
}
