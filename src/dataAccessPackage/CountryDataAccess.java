package dataAccessPackage;

import modelPackage.Country;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CountryDataAccess {
    Country getCountry(String codeCountry) throws SQLException;

    ArrayList<Country> getAllCountries() throws SQLException;
}
