package willy.individual.com.todolistapp.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zhenglu on 3/1/17.
 */

public class DateUtils {
    private static SimpleDateFormat sdf =
            new SimpleDateFormat("yyyy MM dd HH:mm", Locale.getDefault());

    public static SimpleDateFormat sdfDate =
            new SimpleDateFormat("EEE MM dd yyyy", Locale.getDefault());

    public static SimpleDateFormat sdfTime =
            new SimpleDateFormat("HH:mm", Locale.getDefault());


    public static Date stringToDate(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date(0);
        }
    }

    public static String dateToString(Date date) {
        return sdf.format(date);
    }
}
