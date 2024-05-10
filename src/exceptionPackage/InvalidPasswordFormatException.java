package exceptionPackage;

public class InvalidPasswordFormatException extends Exception {

    public InvalidPasswordFormatException() {
            super("Format de mot de passe invalide.");
        }
}
