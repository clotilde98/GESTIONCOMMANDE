package dataAccessPackage;

import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocalityDataAccess {
    static Locality getLocality(Integer id) throws SQLException {
        return null;
    }

    ArrayList<Locality> getAllLocalities() throws SQLException;
}
