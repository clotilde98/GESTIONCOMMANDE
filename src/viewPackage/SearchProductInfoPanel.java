package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.CustomExceptions;
import modelPackage.SearchProductInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchProductInfoPanel extends JPanel {
    private JTextField priceField;
    private JButton search;
    private MenuProjet projectMenu;

    private JScrollPane scrollPane;

    private JTable result;
    private SearchProductInfoTable tableModel;
    private ArrayList<SearchProductInfo> infoList;

    private ApplicationController controller;

    public SearchProductInfoPanel(MenuProjet projectMenu){
        this.projectMenu = projectMenu;

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

        priceField = new JTextField(10);

        JPanel searchButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        searchPanel.add(new JLabel("Prix:"));
        searchPanel.add(priceField);
        searchButtonPanel.add(search);
        searchPanel.add(searchButtonPanel);
        search.addActionListener(new searchAction());

        infoList = controller.searchProductInfos(0);
        tableModel = new SearchProductInfoTable(infoList);

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
            try {
                double searchPrice = validateDoubleField(priceField.getText());
                infoList.clear();
                infoList.addAll(controller.searchProductInfos(searchPrice));
                tableModel.fireTableDataChanged();
            }
            catch (CustomExceptions ex){
                JOptionPane.showMessageDialog(SearchProductInfoPanel.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private double validateDoubleField(String numStr) throws CustomExceptions {
        if (numStr.isEmpty()) {
            String message ="Le champ de recherche est vide.";
            throw new CustomExceptions(message);
        }

        try {
            double checkNumber = Double.parseDouble(numStr);
            if (checkNumber<0){
                String message ="Le nombre doit être positif.";
                throw new CustomExceptions(message);
            }
            return checkNumber;
        } catch (NumberFormatException e) {
            String message ="Format du prix recherché est invalide. Entrez un nombre.";
            throw new CustomExceptions(message);
        }
    }
}
