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
    private JButton menu;

    private Container mainContainer;

    private JTable customerTable;

    private ApplicationController controller;



    public FormAdmin() throws SQLException {
        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        addButton = new JButton("Ajouter Utilisateur");
        menu = new JButton("Menu");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        addButton.setFont(buttonFont);
        menu.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        addButton.setPreferredSize(buttonSize);
        menu.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(100, 20, 100, 50));


        // Ajouter le bouton "Ajouter Utilisateur" aligné à gauche
        JPanel newUserButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        newUserButtonPanel.add(addButton);
        buttonPanel.add(newUserButtonPanel);
        addButton.addActionListener(new nouveauAction());

        // Ajouter le bouton "Menu" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);
        menu.addActionListener(new menuAction());

        ArrayList<Customer> customers = controller.getAllCustomers();

        customerTable = new JTable(new CustomerTableModel(customers));
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

