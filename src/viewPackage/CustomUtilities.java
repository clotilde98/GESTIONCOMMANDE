package viewPackage;

import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;
import exceptionPackage.customExceptions;
import modelPackage.Locality;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String validateRequiredField(String field, String fieldName) throws customExceptions {
        if (field.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire";
            throw new customExceptions(message);
        }
        return field;
    }

    public static  String validatePassword(String password,String fieldName) throws InvalidPasswordFormatException, customExceptions {
        // Vérifiez d'abord si le champ est vide
        if (password.isEmpty()) {
            String message = "Le champ " + fieldName + " est obligatoire.";
            throw new customExceptions(message);
        }

        // Vérifiez la longueur minimale du mot de passe
        if (password.length() < 8) {
            String message =fieldName + " doit contenir au moins 8 caractères.";
            throw new InvalidPasswordFormatException(message);
        }

        // Vérifiez s'il contient au moins une majuscule
        if (!password.matches(".*[A-Z].*")) {
            String message ="Le mot de passe doit contenir au moins une majuscule";
            throw new InvalidPasswordFormatException(message);
        }

        // Vérifiez s'il contient au moins un chiffre
        if (!password.matches(".*\\d.*")) {
            String message ="Le mot de passe doit contenir au moins un chiffre.";
            throw new InvalidPasswordFormatException(message);
        }

        // Vérifiez s'il contient au moins une lettre
        if (!password.matches(".*[a-zA-Z].*")) {
            String message ="Le mot de passe doit contenir au moins une lettre.";
            throw new InvalidPasswordFormatException(message);
        }

        // Vérifiez s'il contient au moins un caractère spécial
        if (!password.matches(".*[!@#$%^&*()-+].*")) {
            String message ="Le mot de passe doit contenir au moins un caractère spécial.";
            throw new InvalidPasswordFormatException(message);
        }

        return password;
    }

    public static void validateRequiredLocality(Locality selectedItem, String fieldName) throws customExceptions {
        if (selectedItem == null) {
            String message = "Le champ " + fieldName + " est obligatoire";
            throw new customExceptions(message);
        }

    }
    public static Date validateDate(String dateStr, String fieldName) throws customExceptions {
        if (fieldName.isEmpty()) {
            String message = "Le champ " + fieldName + " est obligatoire.";
            throw new customExceptions(message);
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // La date doit être valide
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new customExceptions("Format de " + fieldName + " invalide. Utilisez le format yyyy-MM-dd.");
        }
    }

    public static int validateNumericField(String numStr, String fieldName) throws customExceptions {
        // Vérifiez d'abord si le champ est vide
        if (numStr.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire.";
            throw new customExceptions(message);
        }

        try {
            // Essayez de convertir le champ en nombre entier
            return Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            String message ="Format de " + fieldName + " invalide. Entrez un nombre entier.";
            throw new customExceptions(message);
        }
    }



    public static String validatePhoneNumberField(String phoneNumberStr, String fieldName) throws customExceptions {
        // Vérifiez d'abord si le champ est vide


        // Vérifiez si le numéro de téléphone contient uniquement des chiffres
        if (!phoneNumberStr.matches("\\d+")) {
            String message = "Format de " + fieldName + " invalide. Entrez un numéro de téléphone valide (chiffres uniquement).";
            throw new customExceptions(message);
        }

        return phoneNumberStr;
    }


}
