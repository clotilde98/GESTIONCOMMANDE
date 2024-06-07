package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess{

    Connection connection = SingletonConnection.getInstance();

    public CountryDBAccess() throws DataAccessException {
    }

    public Country getCountry(String codeCountry) throws DataAccessException {
        String sqlInstruction = "select * from country where code = ?";

        Country country;

        try{
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setString(1,codeCountry);

            ResultSet data = statement.executeQuery();
            data.next();

            country = new Country(data.getString("code"),data.getString("name"));
        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

        return country;
    }

    public ArrayList<Country> getAllCountries() throws DataAccessException {
        String sqlInstruction = "select * from country";

        Country country;
        ArrayList<Country> allCountries = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);

            ResultSet data = statement.executeQuery();


            while (data.next()) {
                country = new Country(data.getString("code"), data.getString("name"));
                allCountries.add(country);
            }

        } catch (SQLException e) {
            throw new DataAccessException(e.getMessage());
        }

        return allCountries;
    }
}
