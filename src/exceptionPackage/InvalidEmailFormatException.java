package exceptionPackage;

public class InvalidEmailFormatException extends Exception {
    public InvalidEmailFormatException() {
        super("Format d'email invalide.");
    }

}
