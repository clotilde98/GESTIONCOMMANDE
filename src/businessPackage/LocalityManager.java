package businessPackage;

import dataAccessPackage.LocalityDBAccess;
import modelPackage.Customer;
import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityManager {

    private LocalityDBAccess dao;

    public LocalityManager ( ) {
        setDao (new LocalityDBAccess()) ;
    }

    private void setDao(LocalityDBAccess localityDBAccess) {
        this.dao = localityDBAccess;
    }

    public ArrayList<Locality> getAllLocalities() throws SQLException {
        return dao.getAllLocalities();
    }

    public void addCustomer(Customer customer) {

    }
}
