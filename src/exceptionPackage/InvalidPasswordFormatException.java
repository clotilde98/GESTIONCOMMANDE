package exceptionPackage;

public class InvalidPasswordFormatException extends Exception {

    public InvalidPasswordFormatException(String message) {
            super(message);
        }
}
