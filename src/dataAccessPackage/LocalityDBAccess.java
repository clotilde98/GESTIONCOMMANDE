package dataAccessPackage;

import modelPackage.Country;
import modelPackage.Locality;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityDataAccess{

     Connection connection = SingletonConnection.getInstance();



    public  Locality getLocality(Integer id) {

        Locality locality = null;
        String sqlInstruction = "select * from locality where id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setInt(1, id);

            ResultSet data = statement.executeQuery();
            if (data.next()) {
                CountryDataAccess dao = new CountryDBAccess();
                Country country = dao.getCountry(data.getString("country"));
                locality = new Locality(data.getInt("id"), data.getString("city"), data.getInt("zip_code"), country);

            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return locality;
    }


    public ArrayList<Locality> getAllLocalities() {
        Locality locality;
        ArrayList<Locality> allLocalities =  new ArrayList<>();
        String sqlInstruction = "select * from locality";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlInstruction);

            ResultSet data = statement.executeQuery();

            Country country = null;

            CountryDataAccess dao;
            dao = new CountryDBAccess();

            ArrayList<Country> allCountries= dao.getAllCountries();
            int countriesNumber = allCountries.size();

            while (data.next()){

                for(int i = 0; i < countriesNumber ; i++){
                    if (data.getString("country").equals(allCountries.get(i).getCode())) country = allCountries.get(i);
                }

                locality = new Locality(data.getInt("id"),data.getString("city"),data.getInt("zip_code"),country);
                allLocalities.add(locality);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return allLocalities;
    }


}
