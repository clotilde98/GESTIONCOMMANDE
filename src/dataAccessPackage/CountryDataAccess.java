package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.Country;

import java.util.ArrayList;

public interface CountryDataAccess {
    Country getCountry(String codeCountry) throws DataAccessException;

    ArrayList<Country> getAllCountries() throws DataAccessException;
}
