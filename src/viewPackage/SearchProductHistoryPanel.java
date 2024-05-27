package viewPackage;

import controllerPackage.ApplicationController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchProductHistoryPanel extends JPanel {

    private JTextField nameField;
    private JButton search;

    private JScrollPane scrollPane;

    private JTable result;
    private SearchProductHistoryTable tableModel;
    private ArrayList<modelPackage.SearchProductHistory> historyList;

    private ApplicationController controller;

    public SearchProductHistoryPanel(){

        setController(new ApplicationController());

        setBounds(100, 100, 500, 500);

        setLayout(new BorderLayout());

        search = new JButton("Rechercher");


        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        search.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        search.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(14, 1));
        searchPanel.setBorder(new EmptyBorder(50, 20, 100, 50));

        nameField = new JTextField(10);

        JPanel searchButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        searchPanel.add(new JLabel("Nom du Client:"));
        searchPanel.add(nameField);
        searchButtonPanel.add(search);
        searchPanel.add(searchButtonPanel);
        search.addActionListener(new searchAction());

        historyList = controller.searchProductHistories("");
        tableModel = new SearchProductHistoryTable(historyList);

        result = new JTable(tableModel);

        scrollPane = new JScrollPane(result);

        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.WEST);


    }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public class searchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String searchText = nameField.getText();
            if (searchText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer un nom.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (searchText.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Le nom ne peut pas être composé uniquement de chiffres.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            historyList.clear();
            ArrayList<modelPackage.SearchProductHistory> results = controller.searchProductHistories(searchText);
            if (results.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Aucun résultat trouvé pour le nom: " + searchText, "Information", JOptionPane.INFORMATION_MESSAGE);
            } else {
                historyList.addAll(results);
            }
            tableModel.fireTableDataChanged();

        }
    }


}
