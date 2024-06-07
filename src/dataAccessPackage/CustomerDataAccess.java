package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.Customer;

import java.util.ArrayList;

public interface CustomerDataAccess {
    void addCustomer(Customer customer) throws DataAccessException;

    Customer getCustomer(Integer customerNumber) throws DataAccessException;

    ArrayList<Customer> getAllCustomers() throws DataAccessException;

    void updateCustomer(Customer customer) throws DataAccessException;

    void deleteCustomer(int customerNumber) throws DataAccessException;

    Customer getUser(String email, String password) throws DataAccessException;

    boolean customerExistsByEmail(String email) throws DataAccessException;
}
