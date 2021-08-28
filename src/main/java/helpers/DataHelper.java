package helpers;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DataHelper {

    private static Faker faker = new Faker();

    //Generate Random Email
    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    //Generate Random Password
    public static String getRandomPassword(int numberOfPassword) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfPassword; i++) {
            stringBuilder.append(faker.bothify("?"));
        }
        return stringBuilder.toString();
    }

    //Generate Random PID (Number)
    public static String getRandomNumber(int numberOfDigits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= numberOfDigits; i++) {
            stringBuilder.append(faker.numerify("#"));
        }
        return stringBuilder.toString();
    }

}
