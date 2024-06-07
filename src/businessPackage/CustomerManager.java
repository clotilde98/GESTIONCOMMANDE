package businessPackage;

import dataAccessPackage.CustomerDBAccess;
import dataAccessPackage.CustomerDataAccess;
import exceptionPackage.DataAccessException;
import modelPackage.Customer;

import java.util.ArrayList;

public class CustomerManager {

    private CustomerDataAccess dao ;
    public CustomerManager ( ) {
        setDao (new CustomerDBAccess()) ;
    }

    private void setDao(CustomerDataAccess customerDataAccess) {
        this.dao = customerDataAccess;
    }

    public void addCustomer(Customer customer) throws DataAccessException {

        // Appel de la méthode addCustomer de CustomerDBAccess
        dao.addCustomer(customer);


    }

    public ArrayList<Customer> getAllCustomers() throws DataAccessException {
        return dao.getAllCustomers();
    }

    public void deleteCustomer(int number) throws DataAccessException { dao.deleteCustomer(number);}

    public void updateCustomer(Customer customer) throws DataAccessException {
        dao.updateCustomer(customer);
    }

    public Customer getUSer(String email, String password) throws DataAccessException {
        return dao.getUser(email,password);
    }

    public Customer getCustomer(Integer customerNumber) throws DataAccessException {
        return dao.getCustomer(customerNumber);
    }

    public boolean customerExistsByEmail(String email) throws DataAccessException {
        return dao.customerExistsByEmail(email);
    }
}
