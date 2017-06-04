package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;

/**
 * Created by SXK8780 on 5/31/2017.
 */
public class Utils {
    public static String getToday() {
        LocalDate today = LocalDate.now();
        return convertDateToString(today);
    }
    public static String getDay(int noOfDays) {
        LocalDate today = LocalDate.now();
        return convertDateToString(today.plusDays(noOfDays));
    }
    public static Year getYear(int noOfYear) {
        LocalDate today = LocalDate.now();
        Year year = Year.of(today.getYear());
        return year.plusYears(noOfYear);
    }
    public static String convertDateToString(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    public static String convertDateTimeToString(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return time.format(formatter);
    }

    public static Properties loadConfig(String filePath) {
        Properties properties = new Properties();
        try {
            InputStream in = new FileInputStream(filePath);
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading " + filePath + ".properties");
        }
        return properties;
    }

    public static String getRandomNumberString() {
        long seedUniquifier = 8682522807148012L;
        Random random = new Random(++seedUniquifier + System.nanoTime());
        return String.valueOf(random.nextInt());
    }

/*    public static void main(String[] args) {
        System.out.println(getDay(-7));
    }*/
}
