package businessPackage;

import dataAccessPackage.CustomerDBAccess;
import exceptionPackage.AddCustomerExceptions;
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

    public void addCustomer(Customer customer) throws AddCustomerExceptions, SQLException {

        if (dao.exists(customer)) {
            String message ="Le client existe deja";
            throw new AddCustomerExceptions(message);
        }

        // Ajoutez le livre à la base de données
        dao.addCustomer(customer);

    }
}
