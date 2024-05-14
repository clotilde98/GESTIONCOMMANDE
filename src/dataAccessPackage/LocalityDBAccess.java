package dataAccessPackage;

import modelPackage.Country;
import modelPackage.Locality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LocalityDBAccess implements LocalityDataAccess{

    static Connection connection = SingletonConnection.getInstance();



    public  Locality getLocality(Integer id) throws SQLException {


        String sqlInstruction = "select * from locality where id = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setInt(1, id);

        ResultSet data = statement.executeQuery();
        Locality locality = null;
        if (data.next()) {
            CountryDataAccess dao = new CountryDBAccess();
            Country country = dao.getCountry(data.getString("country"));
            locality = new Locality(data.getInt("id"), data.getString("city"), data.getInt("zip_code"), country);

        }
        return locality;
    }


    public ArrayList<Locality> getAllLocalities() throws SQLException {
        String sqlInstruction = "select * from locality";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);

        ResultSet data = statement.executeQuery();
        Locality locality;
        Country country = null;
        ArrayList<Locality> allLocalities =  new ArrayList<>();
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

        return allLocalities;
    }

    public static DefaultComboBoxModel<Locality> getLocalityDataModel(int localityId) throws SQLException {

            // Récupérer toutes les localités depuis la base de données
            LocalityDBAccess dao = new LocalityDBAccess();
            ArrayList<Locality> allLocalities = dao.getAllLocalities();

            // Créer un modèle de données pour le JComboBox
            DefaultComboBoxModel<Locality> comboBoxModel = new DefaultComboBoxModel<>(allLocalities.toArray(new Locality[0]));

            return comboBoxModel;
        }
}
