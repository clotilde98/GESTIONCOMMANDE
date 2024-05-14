package dataAccessPackage;

import modelPackage.Customer;
import modelPackage.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class CustomerDBAccess implements CustomerDataAccess{
    Connection connection = SingletonConnection.getInstance();

    public void addCustomer(Customer customer ) throws SQLException {
        String sql = "INSERT INTO customer (first_name,last_name,email,phone_number,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


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
        statement.setInt(10,  customer.getLocality().getId());
        statement.setString(11, customer.getStreet());
        statement.setInt(12, customer.getStreetNumber());
        statement.setInt(13, customer.getNumberSponsorised());


        statement.executeUpdate();

    }catch (SQLException e) {
            throw e;

        }



}

    public Customer getCustomer(Integer customerNumber) {

        return null;
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException{
        ArrayList<Customer> customers = new ArrayList<>();

        try {

            String sql = "SELECT first_name,last_name,email,phone_number,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised FROM customer";

            // Préparer la déclaration
            PreparedStatement statement = connection.prepareStatement(sql);

            System.out.println(statement);

            // Exécuter la requête
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String phone_number = resultSet.getString("phone_number");
                String password =resultSet.getString("password");
                String genderString = resultSet.getString("gender");
                char gender = genderString.charAt(0);
                Date birthday =resultSet.getDate("birthday");
                boolean is_admin =resultSet.getBoolean("is_admin");
                boolean is_adherent =resultSet.getBoolean("is_adherent");

                // Récupérer l'ID de la localité du client
                int localityId = resultSet.getInt("locality");

                // Utiliser la méthode getLocality() de LocalityDBAccess pour récupérer la localité
                LocalityDBAccess localityDBAccess = new LocalityDBAccess();
                Locality locality = localityDBAccess.getLocality(localityId);


                String street =resultSet.getString("street");
                int street_number =resultSet.getInt("street_number");
                int number_sponsorised =resultSet.getInt("number_sponsorised");


                Customer customer = new Customer( first_name,last_name,email,phone_number,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised);
                customers.add(customer);
            }

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return customers;
        }



        public Customer updateCustomer() {
        return null;
    }

    public void deleteCustomer(Customer customer) {

    }

    public Customer getUser(String email, String password) throws SQLException{
        return null;
    }




}
