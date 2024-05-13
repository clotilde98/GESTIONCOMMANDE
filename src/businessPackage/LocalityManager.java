package businessPackage;

import dataAccessPackage.LocalityDBAccess;
import dataAccessPackage.LocalityDataAccess;
import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityManager {

    private LocalityDataAccess dao;

    public LocalityManager ( ) {
        setDao (new LocalityDBAccess()) ;
    }

    private void setDao(LocalityDBAccess localityDBAccess) {
        this.dao = localityDBAccess;
    }

    public ArrayList<Locality> getAllLocalities() throws SQLException {
        return dao.getAllLocalities();
    }
}
