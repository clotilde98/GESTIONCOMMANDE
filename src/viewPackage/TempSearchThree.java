package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.SearchProductInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TempSearchThree extends JFrame{
    private Container mainContainer;
    private JButton menu;

    private JTable searchTable;

    private ApplicationController controller;

    public TempSearchThree(Double price) {
        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        //addButton = new JButton("Ajouter Utilisateur");
        menu = new JButton("Menu");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        //addButton.setFont(buttonFont);
        menu.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        //addButton.setPreferredSize(buttonSize);
        menu.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(100, 20, 100, 50));


        // Ajouter le bouton "Menu" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);
        menu.addActionListener(new TempSearchThree.menuAction());


        ArrayList<SearchProductInfo> lists = controller.searchProductInfos(price);

        searchTable = new JTable(new SearchProductInfoTable(lists));
        JScrollPane scrollPane = new JScrollPane(searchTable);


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