package dataAccessPackage;

import modelPackage.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDataAccess {
    void addCustomer(Customer customer) throws SQLException;

    Customer getCustomer(Integer customerNumber);

    ArrayList<Customer> getAllCustomers() throws SQLException;

    Customer updateCustomer();

    void deleteCustomer(Customer customer);

    Customer getUser(String email, String password) throws SQLException;
}
