package dataAccessPackage;

import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocalityDataAccess {
    Locality getLocality(Integer id) throws SQLException;

    ArrayList<Locality> getAllLocalities() throws SQLException;
}
