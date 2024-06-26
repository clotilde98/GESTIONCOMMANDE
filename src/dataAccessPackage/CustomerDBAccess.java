package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.Customer;
import modelPackage.Locality;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;


public class CustomerDBAccess implements CustomerDataAccess{

    public void addCustomer(Customer customer ) throws DataAccessException {

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
            throw new DataAccessException(e.getMessage());
        }



}

    public Customer getCustomer(Integer customerNumber) throws DataAccessException {

        Customer customer = null;
        Connection connection = SingletonConnection.getInstance();

        try {
            String sqlInstruction = "SELECT * FROM customer WHERE number = ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setInt(1, customerNumber);



            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

            String last_name = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String password =resultSet.getString("password");
            String genderString = resultSet.getString("gender");
            char gender = genderString.charAt(0);
            Date birthday =resultSet.getDate("birthday");
            boolean is_admin =resultSet.getBoolean("is_admin");
            boolean is_adherent =resultSet.getBoolean("is_adherent");

                Integer localityId = resultSet.getInt("locality");

            LocalityDBAccess localityDBAccess = new LocalityDBAccess();
            Locality locality = localityDBAccess.getLocality(localityId);

            String street =resultSet.getString("street");
            Integer street_number =resultSet.getInt("street_number");
            Integer number_sponsorised =resultSet.getInt("number_sponsorised");
            Integer number = resultSet.getInt("number");

                customer = new Customer(last_name,email,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised);
                customer.setNumber(number);

                //Optional column
                if (resultSet.getString("first_name") != null){
                    String first_name = resultSet.getString("first_name");
                    customer.setFirstName(first_name);
                }

                if (resultSet.getString("phone_number") != null){
                    String phone_number = resultSet.getString("phone_number");
                    customer.setPhoneNumber(phone_number);
                }

            }
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

        return customer;
    }

    public ArrayList<Customer> getAllCustomers() throws DataAccessException {

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();

            String sql = "SELECT * FROM customer";

            // Préparer la déclaration
            PreparedStatement statement = connection.prepareStatement(sql);

            // Exécuter la requête
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {


                String last_name = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String password =resultSet.getString("password");
                String genderString = resultSet.getString("gender");
                char gender = genderString.charAt(0);
                Date birthday =resultSet.getDate("birthday");
                boolean is_admin =resultSet.getBoolean("is_admin");
                boolean is_adherent =resultSet.getBoolean("is_adherent");

                // Récupérer l'ID de la localité du client
                Integer localityId = resultSet.getInt("locality");

                // Utiliser la méthode getLocality() de LocalityDBAccess pour récupérer la localité
                LocalityDBAccess localityDBAccess = new LocalityDBAccess();
                Locality locality = localityDBAccess.getLocality(localityId);


                String street =resultSet.getString("street");
                Integer street_number =resultSet.getInt("street_number");
                Integer number_sponsorised =resultSet.getInt("number_sponsorised");
                Integer number = resultSet.getInt("number");

                Customer customer = new Customer(last_name,email,password,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised);
                customers.add(customer);
                customer.setNumber(number);

                //Optional column
                if (resultSet.getString("first_name") != null){
                    String first_name = resultSet.getString("first_name");
                    customer.setFirstName(first_name);
                }

                if (resultSet.getString("phone_number") != null){
                    String phone_number = resultSet.getString("phone_number");
                    customer.setPhoneNumber(phone_number);
                }


            }

    } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }
            return customers;
        }

    public void updateCustomer(Customer customer) throws DataAccessException {

        Connection connection = SingletonConnection.getInstance();

        String sql = "UPDATE customer SET first_name = ?, last_name = ?, email = ?, phone_number = ?, password = ?, gender = ?, birthday = ?, is_admin = ?, is_adherent = ?, locality = ?, street = ?, street_number = ?, number_sponsorised = ? WHERE number = ?";


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
            statement.setInt(14, customer.getNumber());

           statement.executeUpdate();


        }catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
            }
    }

    public void deleteCustomer(int customerNumber) throws DataAccessException {

        Connection connection = SingletonConnection.getInstance();


        String sqlSelectCommandsToDelete = "select number from command where customer = ?";
        String sqlDeleteCustomer = "delete from customer where number =?";

        try {

            PreparedStatement selectCommandsStatement = connection.prepareStatement(sqlSelectCommandsToDelete);
            selectCommandsStatement.setInt(1,customerNumber);

            ResultSet resultSet = selectCommandsStatement.executeQuery();

            while (resultSet.next()){
                int commandNumber = resultSet.getInt("number");
                deleteCommand(commandNumber);
            }

            PreparedStatement deleteStatement = connection.prepareStatement(sqlDeleteCustomer);
            deleteStatement.setInt(1, customerNumber);
            deleteStatement.executeUpdate();

        }catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

    }

    public Customer getUser(String email, String password) throws DataAccessException {

        Customer customer;
        Connection connection = SingletonConnection.getInstance();

        try {
            String sqlInstruction = "select * from customer where customer.email = ? and customer.password = ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setString(1, email);
            statement.setString(2,password);


            ResultSet resultSet = statement.executeQuery();

            resultSet.next();

            String last_name = resultSet.getString("last_name");
            String userEmail = resultSet.getString("email");
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


            customer = new Customer(last_name,userEmail,userPassword,gender,birthday,is_admin,is_adherent,locality,street,street_number,number_sponsorised);

            //Optional column
            if (resultSet.getString("first_name") != null){
                String first_name = resultSet.getString("first_name");
                customer.setFirstName(first_name);
            }

            if (resultSet.getString("phone_number") != null){
                String phone_number = resultSet.getString("phone_number");
                customer.setPhoneNumber(phone_number);
            }
        }

        catch (SQLException e){
            throw new DataAccessException(e.getMessage());
        }

        return customer;
    }


    private void deleteCommand(int commandNumber) throws DataAccessException {

        Connection connection = SingletonConnection.getInstance();

        String sqlInvoiceDelete = "delete from invoice where command = ?";
        String sqlDeleteCommandsLigns = "delete from commandlign where number = ?";
        String sqlDeleteCommand = "delete from command where number = ?";

        try {
            PreparedStatement deleteInvoiceStatement = connection.prepareStatement(sqlInvoiceDelete);
            deleteInvoiceStatement.setInt(1, commandNumber);
            deleteInvoiceStatement.executeUpdate();

            PreparedStatement deleteLignStatement = connection.prepareStatement(sqlDeleteCommandsLigns);
            deleteLignStatement.setInt(1,commandNumber);
            deleteLignStatement.executeUpdate();

            PreparedStatement deleteCommandStatement = connection.prepareStatement(sqlDeleteCommand);
            deleteCommandStatement.setInt(1,commandNumber);
            deleteCommandStatement.executeUpdate();


        }catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

    }

    public boolean customerExistsByEmail(String email) throws DataAccessException {
        // Implement the query logic here, for example using JDBC:
        Connection connection = SingletonConnection.getInstance();
        try {
            String query = "SELECT COUNT(*) FROM customer WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }

        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

        return false;
    }

}
