package viewPackage;

import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.customExceptions;

public class CustomUtilities {
    public static String validateEmail(String email,String fieldName) throws InvalidEmailFormatException, customExceptions {
        // Vérifiez d'abord si le champ est vide
        if (email.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire";
            throw new customExceptions(message);
        }

        // Utilisation d'une expression régulière pour valider l'email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            String message = fieldName + " Format  invalide";
            throw new InvalidEmailFormatException(message);
        }
        return email;
    }
}
