package Exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdressException extends RuntimeException {
    public AdressException(String message) {
        super(message);
    }

    public static boolean regexHouseNumberError(String HouseNumber){
        boolean isInCorretHouseNumber;
        Pattern pattern = Pattern.compile("[^0-9 ]");
        Matcher matcher = pattern.matcher(HouseNumber);

        if (matcher.find()) {
          return isInCorretHouseNumber = true;
        }
        return isInCorretHouseNumber = false;
    }

    public static boolean regexCityAndStreetError(String cityOrStreet){
        boolean isInCorretCityOrStreet;
        Pattern pattern = Pattern.compile("[^A-Za-z ]");
        Matcher matcher = pattern.matcher(cityOrStreet);

        if (matcher.find()) {
            return isInCorretCityOrStreet = true;
        }
        return isInCorretCityOrStreet = false;
    }
}
