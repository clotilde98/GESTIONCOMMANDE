package businessPackage;

import dataAccessPackage.CustomerDBAccess;
import modelPackage.Customer;

import java.sql.SQLException;

public class CustomerManager {

    private CustomerDBAccess dao ;
    public CustomerManager ( ) {
        setDao (new CustomerDBAccess()) ;
    }

    private void setDao(CustomerDBAccess customerDBAccess) {
        this.dao = customerDBAccess;
    }

    public void addCustomer(Customer customer) throws  SQLException {

        dao.addCustomer(customer);

    }
}
