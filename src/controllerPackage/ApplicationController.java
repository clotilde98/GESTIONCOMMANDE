package controllerPackage;

import businessPackage.CustomerManager;
import businessPackage.LocalityManager;
import modelPackage.Customer;
import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationController {

    private CustomerManager customerManager;
    private LocalityManager localityManager;

    public ApplicationController() {
        setCustomerManager (new CustomerManager());
        setLocalityManager (new LocalityManager());
    }

    private void setCustomerManager(CustomerManager customerManager) {this.customerManager = customerManager;}
    private void setLocalityManager(LocalityManager localityManager) {
        this.localityManager = localityManager;
    }

    public void addCustomer(Customer customer) throws  SQLException {
        customerManager.addCustomer(customer);
    }

    public ArrayList<Locality> getAllLocalities() throws SQLException {
        return localityManager.getAllLocalities();
    }
}
