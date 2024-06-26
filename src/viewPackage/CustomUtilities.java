package viewPackage;

import exceptionPackage.CharOverflowException;
import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;
import exceptionPackage.CustomExceptions;
import modelPackage.Locality;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomUtilities {
    public static String validateEmail(String email,String fieldName) throws InvalidEmailFormatException, CustomExceptions {
        // Vérifiez d'abord si le champ est vide
        if (email.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire";
            throw new CustomExceptions(message);
        }

        // Utilisation d'une expression régulière pour valider l'email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(emailRegex)) {
            String message = fieldName + " Format  invalide";
            throw new InvalidEmailFormatException(message);
        }
        return email;
    }

    public static String validateRequiredField(String field, String fieldName) throws CustomExceptions {
        if (field.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire";
            throw new CustomExceptions(message);
        }
        return field;
    }

    public static  String validatePassword(String password,String fieldName) throws InvalidPasswordFormatException, CustomExceptions {
        // Vérifiez d'abord si le champ est vide
        if (password.isEmpty()) {
            String message = "Le champ " + fieldName + " est obligatoire.";
            throw new CustomExceptions(message);
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

    public static void validateRequiredLocality(Locality selectedItem, String fieldName) throws CustomExceptions {
        if (selectedItem == null) {
            String message = "Le champ " + fieldName + " est obligatoire";
            throw new CustomExceptions(message);
        }

    }
    public static Date validateDate(String dateStr, String fieldName) throws CustomExceptions {
        if (fieldName.isEmpty()) {
            String message = "Le champ " + fieldName + " est obligatoire.";
            throw new CustomExceptions(message);
        }

        String[] dateComponents = dateStr.split("/");
        if (dateComponents.length != 3) {
            String message ="Format de " + fieldName + " invalide. Utilisez le format yyyy/MM/dd.";

            throw new CustomExceptions(message);
        }

        int year, month, day;
        try {
            year = Integer.parseInt(dateComponents[0]);
        } catch (NumberFormatException e) {
            String message ="L'année dans le champ " + fieldName + " est invalide.";
            throw new CustomExceptions(message);
        }

        try {
            month = Integer.parseInt(dateComponents[1]);
        } catch (NumberFormatException e) {
             String message ="Le mois dans le champ " + fieldName + " est invalide.";
            throw new CustomExceptions(message);
        }

        try {
            day = Integer.parseInt(dateComponents[2]);
        } catch (NumberFormatException e) {
            String message ="Le jour dans le champ " + fieldName + " est invalide.";
            throw new CustomExceptions(message);
        }

        if (month < 1 || month > 12) {
            String message ="Le mois dans le champ " + fieldName + " doit être entre 01 et 12.";
            throw new CustomExceptions(message);
        }

        if (day < 1 || day > 31) {
            String message = "Le jour dans le champ " + fieldName + " doit être entre 01 et 31.";
            throw new CustomExceptions(message);
        }

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            String message = "Le jour dans le champ " + fieldName + " doit être entre 01 et 30 pour  le mois " + month ;
            throw new CustomExceptions(message);
        }



        if (month == 2) {
            if (isLeapYear(year)) {
                if (day > 29) {
                    String message ="Le jour dans le champ " + fieldName + " doit être entre 01 et 29 pour le mois de février dans une année bissextile.";
                    throw new CustomExceptions(message);
                }
            } else {
                if (day > 28) {
                    String message = "Le jour dans le champ " + fieldName + " doit être entre 01 et 28 pour le mois de février.";
                    throw new CustomExceptions(message);
                }
            }
        }

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            sdf.setLenient(false); // La date doit être valide
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new CustomExceptions("Format de " + fieldName + " invalide. Utilisez le format yyyy/MM/dd.");
        }



    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }
    public static int validateNumericField(String numStr, String fieldName) throws CustomExceptions {
        // Vérifiez d'abord si le champ est vide
        if (numStr.isEmpty()) {
            String message ="Le champ " + fieldName + " est obligatoire.";
            throw new CustomExceptions(message);
        }

        try {
            // Essayez de convertir le champ en nombre entier
            int checkNumber = Integer.parseInt(numStr);
            if (checkNumber<0){
                String message ="Le nombre doit être positif.";
                throw new CustomExceptions(message);
            }
            return checkNumber;
        } catch (NumberFormatException e) {
            String message ="Format de " + fieldName + " invalide. Entrez un nombre entier.";
            throw new CustomExceptions(message);
        }
    }



    public static String validatePhoneNumberField(String phoneNumberStr, String fieldName) throws CustomExceptions {


        // Vérifiez si le numéro de téléphone contient uniquement des chiffres
        if (!phoneNumberStr.matches("\\d+")) {
            String message = "Format de " + fieldName + " invalide. Entrez un numéro de téléphone valide (chiffres uniquement).";
            throw new CustomExceptions(message);
        }

        return phoneNumberStr;
    }

    public static boolean validateBoolean(boolean selectedTrue, boolean selectedFalse, String fieldName) throws CustomExceptions {
        // Vérifiez d'abord si l'une des options a été sélectionnée
        if (!selectedTrue && !selectedFalse) {
            String message = "Le champ "+ fieldName +" est obligatoire.";
            throw new CustomExceptions(message);
        }

        // Si l'option "OUI" est sélectionnée, retournez true, sinon retournez false
        return selectedTrue;

    }

    public static String validateCharNumber(String text, int charNumber, String fieldName) throws CharOverflowException {


        // Vérifiez si le numéro de téléphone contient uniquement des chiffres
        if (text.length() > charNumber) {
            String message = "Nombre de caractères trop importants dans  " + fieldName + ". Entrez au maximum "+ charNumber + " caractères";
            throw new CharOverflowException(message);
        }

        return text;
    }


}
