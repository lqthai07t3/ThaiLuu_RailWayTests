package helpers;

import com.github.javafaker.Faker;

public class DataHelper {

    private static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword(int numberOfPassword) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfPassword; i++) {
            stringBuilder.append(faker.bothify("?"));
        }
        return stringBuilder.toString();
    }

    public static String getRandomNumber(int numberOfDigits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfDigits; i++) {
            stringBuilder.append(faker.numerify("#"));
        }
        return stringBuilder.toString();
    }


}
