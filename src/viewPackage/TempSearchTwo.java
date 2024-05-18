package viewPackage;

import controllerPackage.ApplicationController;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TempSearchTwo extends JFrame{
    private Container mainContainer;


    private JTable searchTable;

    private ApplicationController controller;

    public TempSearchTwo(String name) {
        setController(new ApplicationController());


        setBounds(100, 100, 500, 500);
        mainContainer = this.getContentPane();
        mainContainer.setLayout(new BorderLayout());

        //menu = new JButton("Menu");

        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);
        //menu.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        //menu.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1));
        buttonPanel.setBorder(new EmptyBorder(100, 20, 100, 50));


        // Ajouter le bouton "Menu" aligné à gauche
        JPanel menuButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
       // menuButtonPanel.add(menu);
        buttonPanel.add(menuButtonPanel);
        //menu.addActionListener(new TempSearchTwo.menuAction());


        ArrayList<SearchProductHistory> lists = controller.searchProductHistories(name);

        searchTable = new JTable(new SearchProductHistoryTable(lists));
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


}
