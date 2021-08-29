package helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");

    //Get Date of Today.
    public static String getToday() {
        Calendar cal = Calendar.getInstance();
        String getDate = dateFormat.format(cal.getTime());
        return getDate;
    }

    //Get Date From Today.
    public static String getDateFromToday(int i) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, i);
        String thatDate = dateFormat.format(cal.getTime());
        return thatDate;
    }


    //Get distance between Dates by one argument.
    public int getDaysBetween(Date date2) {
        Calendar cal = Calendar.getInstance();
        Date date1 = cal.getTime();
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public int getDaysBetween(String dateString) throws Exception {
        Calendar cal = Calendar.getInstance();
        Date date1 = cal.getTime();
        Date date2 = dateFormat.parse(dateString);
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    //Get distance between Dates by two argument.
    public int getDaysBetween(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public int getDaysBetween(String d1, String d2) throws Exception {
        Date date1 = dateFormat.parse(d1);
        Date date2 = dateFormat.parse(d2);
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
