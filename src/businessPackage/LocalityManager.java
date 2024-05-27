package businessPackage;

import dataAccessPackage.LocalityDBAccess;
import dataAccessPackage.LocalityDataAccess;
import modelPackage.Locality;

import java.util.ArrayList;

public class LocalityManager {

    private LocalityDataAccess dao;

    public LocalityManager ( ) {
        setDao (new LocalityDBAccess()) ;
    }

    private void setDao(LocalityDataAccess localityDataAccess) {
        this.dao = localityDataAccess;
    }

    public ArrayList<Locality> getAllLocalities() {
        return dao.getAllLocalities();
    }
}
