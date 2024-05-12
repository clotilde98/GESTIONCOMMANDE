package dataAccessPackage;

import exceptionPackage.AddCustomerExceptions;
import modelPackage.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static dataAccessPackage.SingletonConnection.getSingletonInstance;

public class CustomerDBAccess {



    public void addCustomer(Customer customer ) throws AddCustomerExceptions, SQLException {
        String sql = "INSERT INTO customer (firstName, lastName, email, phoneNumber, password, gender, birthdayDay, isAdmin, isAdherent, street, streetNumber, numberSponsorised, locality) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = getSingletonInstance();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
        // Remplacer les points d'interrogation par les valeurs réelles des champs
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setString(3, customer.getEmail());
        statement.setString(4, customer.getPhoneNumber());
        statement.setString(5, customer.getPassword());
        statement.setString(6, String.valueOf(customer.getGender())); // Convertir le char en String
        java.util.Date birthdayDate = customer.getBirthday();
        java.sql.Date sqlBirthday = new java.sql.Date(birthdayDate.getTime());
        statement.setDate(7, sqlBirthday);
        statement.setBoolean(8, customer.getIsAdmin());
        statement.setBoolean(9, customer.getIsAdherent());
        statement.setString(10, customer.getStreet());
        statement.setInt(11, customer.getStreetNumber());
        statement.setInt(12, customer.getNumberSponsorised());
        statement.setString(13,  customer.getLocality().getId());

        statement.executeUpdate();

    }catch (SQLException e) {
            // Gérer les exceptions SQL localement
            throw new AddCustomerExceptions("Erreur lors de l'ajout du client : " + e.getMessage());
        }



}
    public boolean exists(Customer customer) {

        return false;
    }
}
