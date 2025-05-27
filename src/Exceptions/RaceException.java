package Exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RaceException extends RuntimeException {
    public RaceException(String message) {
        super(message);
    }

    public static boolean regexRaceError(String cityOrStreet){
        boolean isInCorretRace;
        Pattern pattern = Pattern.compile("[^A-Za-záàãâéêíóôõúçÁÀÃÂÉÊÍÓÔÕÚÇ ]");
        Matcher matcher = pattern.matcher(cityOrStreet);

        if (matcher.find()) {
            return isInCorretRace = true;
        }
        return isInCorretRace = false;
    }
}
