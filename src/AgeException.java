import java.util.regex.*;

public class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }

    public static boolean regexAgeError(String age){
        boolean isCorretAge;
        Pattern pattern = Pattern.compile("[^0-9 ,]");
        Matcher matcher = pattern.matcher(age);

        if (matcher.find()) {
            return isCorretAge = true;
        }
        return isCorretAge = false;
    }
}
