package modelPackage;

import dataAccessPackage.connexion;
import exceptionPackage.customExceptions;
import exceptionPackage.InvalidEmailFormatException;
import exceptionPackage.InvalidPasswordFormatException;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsersModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private char gender;
    private LocalDate birthday;
    private boolean isAdmin;
    private boolean isAdherent;
    private String locality;
    private String street;
    private int streetNumber;
    private int numberSponsorised;

    public UsersModel(String firstName, String lastName, String email, String phoneNumber, String password,
                      char gender, int year, int month, int dayOfMonth, boolean isAdmin, boolean isAdherent,
                      String street, int streetNumber, int numberSponsorised , String locality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.gender = gender;
        this.birthday= LocalDate.of(year, month, dayOfMonth);
        this.isAdmin = isAdmin;
        this.isAdherent = isAdherent;
        this.street = street;
        this.streetNumber = streetNumber;
        this.numberSponsorised = numberSponsorised;
        this.locality = locality;
    }

    public void addUserToDatabase() throws customExceptions, InvalidEmailFormatException, InvalidPasswordFormatException {
        Connection connection = connexion.getInstance();
        if (lastName.isEmpty() || email.isEmpty() || password.isEmpty()
                || gender == '\0' || birthday == null || !isAdmin || !isAdherent || locality.isEmpty() || street.isEmpty() ||  streetNumber == 0) {
            throw new customExceptions("Tous les champs sont obligatoires.");
        }

        if (phoneNumber.length() > 10) {
            throw new customExceptions("Le numéro de téléphone doit avoir 10 chiffres.");
        }

        if (!isValidEmail(email)) {
            throw new InvalidEmailFormatException();
        }

        if (!isValidPassword(password)) {
            throw new InvalidPasswordFormatException();
        }

        if (connection != null) {
            try {
                String query = "INSERT INTO users (firstName, lastName, email, phoneNumber, password, gender, birthday, isAdmin, isAdherent, street, streetNumber, numberSponsorised,locality) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, email);
                statement.setString(4, phoneNumber);
                statement.setString(5, password);
                statement.setString(6, String.valueOf(gender));
                statement.setObject(7, birthday);
                statement.setBoolean(8, isAdmin);
                statement.setBoolean(9, isAdherent);
                statement.setString(10, street);
                statement.setInt(11, streetNumber);
                statement.setInt(12, numberSponsorised);
                statement.setString(13, locality);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Utilisateur ajouté avec succès !");

                } else {
                    JOptionPane.showMessageDialog(null, "Erreur lors de l'ajout de l'utilisateur.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isValidEmail(String email) {
        // Expression régulière pour valider un email
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Création d'un pattern à partir de l'expression régulière
        Pattern pattern = Pattern.compile(emailRegex);

        // Création d'un matcher à partir de l'email fourni
        Matcher matcher = pattern.matcher(email);

        // Retourne true si l'email correspond au pattern, sinon false
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        // Vérifie si le mot de passe respecte un format valide
        // Ajoutez vos propres règles de validation ici
        return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*") && password.matches(".*[!@#$%^&*()-_=+\\|\\[{\\]};:'\",<.>/?`~].*");
    }
}
