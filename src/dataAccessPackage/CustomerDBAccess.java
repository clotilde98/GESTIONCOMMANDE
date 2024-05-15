package dataAccessPackage;

import exceptionPackage.InvalidDataLoginException;
import modelPackage.Customer;
import modelPackage.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class CustomerDBAccess implements CustomerDataAccess{

    public void addCustomer(Customer customer ) throws SQLException {

        Connection connection = SingletonConnection.getInstance();

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

        Connection connection = SingletonConnection.getInstance();

        return null;
    }

    public ArrayList<Customer> getAllCustomers() {

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();

            String sql = "SELECT first_name,last_name,email,phone_number,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised FROM customer";

            // Préparer la déclaration
            PreparedStatement statement = connection.prepareStatement(sql);



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

    public void updateCustomer(Customer customer) {

        Connection connection = SingletonConnection.getInstance();

        String sql = "update customer set first_name = ?, last_name = ?, email = ?, phone_number = ?, password = ?, gender = ?, " +
                "birthday = ?, is_admin= ?, is_adherent = ?, locality = ?, street = ?, street_number =?, number_sponsorised = ?) " +
                "where number = ?";


        try (PreparedStatement statement = connection.prepareStatement(sql)) {

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
            statement.setInt(14,customer.getNumber());

            statement.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
            }
    }

    public void deleteCustomer(Customer customer) {

        Connection connection = SingletonConnection.getInstance();

    }

    public Customer getUser(String email, String password) throws InvalidDataLoginException {

        Customer customer;
        Connection connection = SingletonConnection.getInstance();

        try {
            String sqlInstruction = "select * from customer where customer.email = ? and customer.password = ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setString(1, email);
            statement.setString(2,password);


            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String userEmail = resultSet.getString("email");
            String phone_number = resultSet.getString("phone_number");
            String userPassword =resultSet.getString("password");
            String genderString = resultSet.getString("gender");
            char gender = genderString.charAt(0);
            Date birthday =resultSet.getDate("birthday");
            boolean is_admin =resultSet.getBoolean("is_admin");
            boolean is_adherent =resultSet.getBoolean("is_adherent");

            int localityId = resultSet.getInt("locality");

            LocalityDBAccess localityDBAccess = new LocalityDBAccess();
            Locality locality = localityDBAccess.getLocality(localityId);

            String street =resultSet.getString("street");
            int street_number =resultSet.getInt("street_number");
            int number_sponsorised =resultSet.getInt("number_sponsorised");


            customer = new Customer( first_name,last_name,userEmail,phone_number,userPassword,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised);
        }

        catch (SQLException e){
            throw new InvalidDataLoginException("Données de connexion invalides");
        }

        return customer;
    }




}
