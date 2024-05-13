package businessPackage;

import dataAccessPackage.CustomerDBAccess;
import dataAccessPackage.CustomerDataAccess;
import modelPackage.Customer;

import java.sql.SQLException;

public class CustomerManager {

    private CustomerDataAccess dao ;
    public CustomerManager ( ) {
        setDao (new CustomerDBAccess()) ;
    }

    private void setDao(CustomerDataAccess customerDataAccess) {
        this.dao = customerDataAccess;
    }

    public void addCustomer(Customer customer) throws  SQLException {

        try {
            // Appel de la méthode addCustomer de CustomerDBAccess
            dao.addCustomer(customer);
        } catch (SQLException e) {
            // Gestion de l'exception
            e.printStackTrace();
        }

    }
}
