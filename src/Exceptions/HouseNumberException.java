package Exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HouseNumberException extends RuntimeException {
    public HouseNumberException(String message) {
        super(message);
    }

    public static boolean regexHouseNumberError(String HouseNumber){
        boolean isInCorretHouseNumber;
        Pattern pattern = Pattern.compile("[^0-9]");
        Matcher matcher = pattern.matcher(HouseNumber);

        if (matcher.find()) {
          return isInCorretHouseNumber = true;
        }
        return isInCorretHouseNumber = false;
    }
}
