package dataAccessPackage;

import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocalityDataAccess {
    Locality getLocality(Integer idLocality) throws SQLException;

    ArrayList<Locality> getAllLocalities() throws SQLException;
}
