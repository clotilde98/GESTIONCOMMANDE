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

public class FormAdmin extends JFrame{

    private JButton addButton;
    private JButton deleteButton;
    private JButton menu;

    private JButton updateButton;

    private Container mainContainer;

    private JTable customerTable;
    private ArrayList<Customer> customers;

    private CustomerTableModel tableModel;

    private ApplicationController controller;



    public FormAdmin() throws SQLException {
        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        addButton = new JButton("Ajouter Client");
        deleteButton = new JButton("Supprimer Client");
        updateButton = new JButton("Modifier Client");

        menu = new JButton("Menu");

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
        //deleteButton.addActionListener(new deleteAction());


        // Ajouter le bouton "Menu" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);
        menu.addActionListener(new menuAction());

        customers = controller.getAllCustomers();
        tableModel = new CustomerTableModel(customers);

        customerTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(customerTable);

        mainContainer.add(scrollPane, BorderLayout.CENTER);

        mainContainer.add(buttonPanel, BorderLayout.WEST);

        setTitle("Gestion des clients");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        setResizable(true);

 }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public class nouveauAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Ouvrir une nouvelle fenêtre de gestion utilisateur
            AddCustomer addUsers = null;
            try {
                addUsers = new AddCustomer();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            addUsers.setVisible(true); // Rendre la fenêtre visible
            setVisible(false);

        }
    }

    public class deleteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int customerNumber = customers.get(customerTable.getSelectedRow()).getNumber();

            controller.deleteCustomer(customerNumber);

            customers.remove(customerTable.getSelectedRow());
            tableModel.fireTableDataChanged();
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

