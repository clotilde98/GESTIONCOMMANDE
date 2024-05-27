package businessPackage;

import dataAccessPackage.CustomerDBAccess;
import dataAccessPackage.CustomerDataAccess;
import exceptionPackage.InvalidDataLoginException;
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

    public void addCustomer(Customer customer){

        // Appel de la méthode addCustomer de CustomerDBAccess
        dao.addCustomer(customer);


    }

    public ArrayList<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

    public void deleteCustomer(int number){ dao.deleteCustomer(number);}

    public void updateCustomer(Customer customer){
        dao.updateCustomer(customer);
    }

    public Customer getUSer(String email, String password) throws InvalidDataLoginException {
        return dao.getUser(email,password);
    }

    public Customer getCustomer(Integer customerNumber)  {
        return dao.getCustomer(customerNumber);
    }

    public boolean customerExistsByEmail(String email) {
        return dao.customerExistsByEmail(email);
    }
}
