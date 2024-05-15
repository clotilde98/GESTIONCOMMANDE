package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Customer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class DeleteClickListener extends MouseAdapter {
    private CustomerTableModel model;
    private int rowIndex;
    private ApplicationController controller;

    private Customer customer;

    public DeleteClickListener(CustomerTableModel model, int rowIndex) {
        this.model = model;
        this.rowIndex = rowIndex;

        setController(new ApplicationController());

    }
    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Récupérer l'identifiant du client à supprimer
        int customerId = customer.getNumber(); // Remplacez getId() par la méthode appropriée pour obtenir l'identifiant du client

        // Appeler la méthode de suppression dans la base de données via le contrôleur ou le service approprié
        try {
            controller.deleteCustomers(customerId);
            // Supprimer la ligne du modèle de table
            model.removeRow(rowIndex);
        } catch (SQLException ex) {
            ex.printStackTrace(); // Gérer l'exception
        }
    }
}