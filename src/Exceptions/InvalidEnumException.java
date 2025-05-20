package Exceptions;

public class InvalidEnumException extends IllegalArgumentException {
    public InvalidEnumException(String message) {
        super(message);
    }
}
