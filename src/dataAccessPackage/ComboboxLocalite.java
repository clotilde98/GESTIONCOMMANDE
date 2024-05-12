package dataAccessPackage;

import modelPackage.Locality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dataAccessPackage.SingletonConnection.getSingletonInstance;


public class ComboboxLocalite {
    public static DefaultComboBoxModel<Locality> getLocalityDataModel() {
        List<Locality> localities = getLocalityData();

        // Convertir la liste en tableau
        Locality[] localityArray = localities.toArray(new Locality[0]);

        // Créer un modèle de combobox avec le tableau de localités
        return new DefaultComboBoxModel<>(localityArray);
    }

    public static List<Locality> getLocalityData() {
        List<Locality> localities = new ArrayList<>();

        // Récupération de la connexion à la base de données
        Connection connection = getSingletonInstance();

        // Requête SQL pour récupérer les données de localité
        String query = "SELECT * FROM locality";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();

            // Ajout des données récupérées au modèle de combobox
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String city = resultSet.getString("city");
                // Créer un objet Locality avec l'ID et le nom de la ville
                Locality locality = new Locality(id, city);
                localities.add(locality);
            }
        } catch (SQLException e) {
            // Gérer les exceptions SQL (par exemple, afficher un message d'erreur)
            JOptionPane.showMessageDialog(null, "Erreur lors de la récupération des données de localité: " + e.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
        }

        return localities;
    }
}
