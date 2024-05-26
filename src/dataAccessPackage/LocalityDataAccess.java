package dataAccessPackage;

import modelPackage.Locality;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LocalityDataAccess {
    Locality getLocality(Integer id);

    ArrayList<Locality> getAllLocalities();
}
