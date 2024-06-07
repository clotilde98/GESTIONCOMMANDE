package businessPackage;

import dataAccessPackage.LocalityDBAccess;
import dataAccessPackage.LocalityDataAccess;
import exceptionPackage.DataAccessException;
import modelPackage.Locality;

import java.util.ArrayList;

public class LocalityManager {

    private LocalityDataAccess dao;

    public LocalityManager ( ) throws DataAccessException {
        setDao (new LocalityDBAccess()) ;
    }

    private void setDao(LocalityDataAccess localityDataAccess) {
        this.dao = localityDataAccess;
    }

    public ArrayList<Locality> getAllLocalities() throws DataAccessException {
        return dao.getAllLocalities();
    }
}
