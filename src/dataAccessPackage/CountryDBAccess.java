package dataAccessPackage;

import modelPackage.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDBAccess implements CountryDataAccess{

    Connection connection = SingletonConnection.getInstance();

    public Country getCountry(String codeCountry) throws SQLException {
        String sqlInstruction = "select * from country where code = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setString(1,codeCountry);

        ResultSet data = statement.executeQuery();
        data.next();

        Country country = new Country(data.getString("code"),data.getString("name"));

        return country;
    }

    public ArrayList<Country> getAllCountries() throws SQLException {
        String sqlInstruction = "select * from country";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);

        ResultSet data = statement.executeQuery();
        Country country;
        ArrayList<Country> allCountries =  new ArrayList<>();

        while (data.next()){
            country = new Country(data.getString("code"),data.getString("name"));
            allCountries.add(country);
        }

        return allCountries;
    }
}
