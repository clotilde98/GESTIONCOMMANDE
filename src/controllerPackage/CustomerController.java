package controllerPackage;

import businessPackage.CustomerManager;
import exceptionPackage.AddCustomerExceptions;
import modelPackage.Customer;

import java.sql.SQLException;

public class CustomerController {

    private CustomerManager manager;

    public CustomerController() {
        setManager (new CustomerManager());
    }

    private void setManager(CustomerManager customerManager) {

    }

    public void addCustomer(Customer customer) throws AddCustomerExceptions, SQLException {
        manager.addCustomer(customer);
    }
}
