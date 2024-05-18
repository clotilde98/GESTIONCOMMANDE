package dataAccessPackage;

import exceptionPackage.InvalidDataLoginException;
import modelPackage.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDataAccess {
    void addCustomer(Customer customer);

    Customer getCustomer(Integer customerNumber);

    ArrayList<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerNumber);

    Customer getUser(String email, String password) throws InvalidDataLoginException;
}
