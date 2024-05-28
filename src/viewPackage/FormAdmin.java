package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormAdmin extends JPanel{


    private JButton deleteButton;

    private JButton updateButton;

    private ProjectMenu projectMenu;


    private static JTable customerTable;
    private static ArrayList<Customer> customers;

    private CustomerTableModel tableModel;

    private ApplicationController controller;




    public FormAdmin(ProjectMenu projectMenu) {

        this.projectMenu = projectMenu;

        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);

        setLayout(new BorderLayout());


        deleteButton = new JButton("Supprimer Client");
        updateButton = new JButton("Modifier Client");



        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        deleteButton.setFont(buttonFont);
        updateButton.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        deleteButton.setPreferredSize(buttonSize);
        updateButton.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.setBorder(new EmptyBorder(50, 20, 100, 50));




        JPanel deleteUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        deleteUserButtonPanel.add(deleteButton);
        buttonPanel.add(deleteUserButtonPanel);
        deleteButton.addActionListener(new deleteAction());

        JPanel updateUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        updateUserButtonPanel.add(updateButton);
        buttonPanel.add(updateUserButtonPanel);
        updateButton.addActionListener(new updateAction());




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

    private ProjectMenu getMenuProjet() {
        return this.projectMenu;
    }




    public class deleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (customerTable.getSelectedRow() == -1) {
                // Aucune ligne n'est sélectionnée, afficher un message d'avertissement
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner un client à supprimer.", "Aucune sélection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            int selectedRow = customerTable.getSelectedRow();
            Customer selectedCustomer = customers.get(selectedRow);

            if (selectedCustomer.getIsAdmin() && selectedCustomer.getLastName().equals("Super Admin")) {
                JOptionPane.showMessageDialog(null, "Vous ne pouvez pas supprimer le super administrateur.", "Suppression non autorisée", JOptionPane.ERROR_MESSAGE);
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

            AddCustomer addCustomer = new AddCustomer(projectMenu);
            projectMenu.showAddCustomerForm(addCustomer); // Use the MenuProjet reference
            addCustomer.enableUpdateButton();
            addCustomer.disableaddButton();
            addCustomer.showCustomerData(customer);


            setVisible(false);
        }
    }

    public static Customer returnCustomer() {
        if (customerTable != null) {
            int selectedRowIndex = customerTable.getSelectedRow();
            if (selectedRowIndex != -1) {
                return customers.get(selectedRowIndex);
            }
        }
        // Gérer le cas où la table ou aucune ligne n'est sélectionnée
        return null;
    }



}

