package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocalityDataAccess {
    Locality getLocality(Integer id) throws DataAccessException;

    ArrayList<Locality> getAllLocalities() throws DataAccessException;
}
