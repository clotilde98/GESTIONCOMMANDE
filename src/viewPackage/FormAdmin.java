package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormAdmin extends JPanel{

    private JButton addButton;
    private JButton deleteButton;
    private JButton menu;

    private JButton updateButton;

    private Container mainContainer;

    private static JTable customerTable;
    private static ArrayList<Customer> customers;

    private CustomerTableModel tableModel;

    private ApplicationController controller;



    public FormAdmin() throws SQLException {
        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);

        setLayout(new BorderLayout());

        addButton = new JButton("Ajouter Client");
        deleteButton = new JButton("Supprimer Client");
        updateButton = new JButton("Modifier Client");

        menu = new JButton("Actualiser");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        addButton.setFont(buttonFont);
        deleteButton.setFont(buttonFont);
        menu.setFont(buttonFont);
        updateButton.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        addButton.setPreferredSize(buttonSize);
        deleteButton.setPreferredSize(buttonSize);
        menu.setPreferredSize(buttonSize);
        updateButton.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBorder(new EmptyBorder(100, 20, 100, 50));


        // Ajouter le bouton "Ajouter Utilisateur" aligné à gauche
        JPanel newUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        newUserButtonPanel.add(addButton);
        buttonPanel.add(newUserButtonPanel);
        addButton.addActionListener(new nouveauAction());

        JPanel deleteUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        deleteUserButtonPanel.add(deleteButton);
        buttonPanel.add(deleteUserButtonPanel);
        deleteButton.addActionListener(new deleteAction());

        JPanel updateUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        updateUserButtonPanel.add(updateButton);
        buttonPanel.add(updateUserButtonPanel);
        updateButton.addActionListener(new updateAction());


        // Ajouter le bouton "Menu" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);
        menu.addActionListener(new menuAction());

        customers = controller.getAllCustomers();
        tableModel = new CustomerTableModel(customers);

        customerTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(customerTable);

        add(scrollPane, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.WEST);


        setSize(1280, 720);
        setVisible(true);


    }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public class nouveauAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur

            try {
                AddCustomer addUsers = new AddCustomer();
                addUsers.setVisible(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            // Rendre la fenêtre visible


        }
    }

    public class deleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customerTable.getSelectedRow() == -1) {
                // Aucune ligne n'est sélectionnée, afficher un message d'avertissement
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client à supprimer.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int confirmation = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer ce client ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
            if (confirmation == JOptionPane.YES_OPTION) {
                int customerNumber = customers.get(customerTable.getSelectedRow()).getNumber();

                controller.deleteCustomer(customerNumber);

                customers.remove(customerTable.getSelectedRow());
                tableModel.fireTableDataChanged();
                JOptionPane.showMessageDialog(null, "Client supprimé avec succès.", "Suppression réussie", JOptionPane.INFORMATION_MESSAGE);

            }
        }
    }

    public class updateAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customerTable.getSelectedRow() == -1) {
                // Aucune ligne n'est sélectionnée, afficher un message d'avertissement
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client à modifier.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int customerNumber = customers.get(customerTable.getSelectedRow()).getNumber();

            Customer customer = controller.getCustomer(customerNumber);

            try {
                AddCustomer  addCustomer = new AddCustomer();
                addCustomer.setVisible(true);
                addCustomer.enableUpdateButton();
                addCustomer.disableaddButton();
                addCustomer.afficherDonneesClient(customer);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            setVisible(false);
        }
    }

    public static Customer returnCustomer() {
        int selectedRowIndex = customerTable.getSelectedRow();
        if (selectedRowIndex != -1) {
            return customers.get(selectedRowIndex);
        } else {
            // Gérer le cas où aucune ligne n'est sélectionnée dans la table
            return null; // Ou tout autre valeur de retour par défaut appropriée
        }
    }

    public class menuAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            Menu menu = new Menu();
            menu.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }
    }

}

