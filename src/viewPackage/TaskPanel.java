package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.customExceptions;
import modelPackage.SearchCommandInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskPanel extends JPanel {
    private JTextField customerNumberField;

    private JComboBox<LocalDate> yearComboBox;
    private JButton search;
    private MenuProjet projectMenu;

    private JScrollPane scrollPane;
    private JLabel totalLabel;

    private JTable result;
    private SearchCommandInfoTable tableModel;
    private ArrayList<SearchCommandInfo> commandList;

    private ApplicationController controller;

    public TaskPanel(MenuProjet projectMenu){
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
        searchPanel.setLayout(new GridLayout(4, 1));
        searchPanel.setBorder(new EmptyBorder(50, 20, 100, 50));

        customerNumberField = new JTextField(10);

        JPanel searchButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        searchPanel.add(new JLabel("Numéro Client:"));
        searchPanel.add(customerNumberField);

        DefaultComboBoxModel<LocalDate> comboBoxModel = getDateDataModel();
        yearComboBox = new JComboBox<>(comboBoxModel);
        yearComboBox.setRenderer(new YearComboBoxRenderer());

        searchPanel.add(new JLabel("Année:"));
        searchPanel.add(yearComboBox);

        searchButtonPanel.add(search);

        totalLabel = new JLabel("Prix Total pour l'année : ");
        searchButtonPanel.add(totalLabel);

        searchPanel.add(searchButtonPanel);
        search.addActionListener(new searchAction());

        commandList = controller.searchTotalCommands(1,LocalDate.parse("2023-01-01"));
        tableModel = new SearchCommandInfoTable(commandList);

        result = new JTable(tableModel);

        scrollPane = new JScrollPane(result);

        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.WEST);


        setSize(1280, 720);
        setVisible(true);

    }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private DefaultComboBoxModel<LocalDate> getDateDataModel() {
        LocalDate selectDate = LocalDate.parse("2020-01-01");
        LocalDate actualDate = LocalDate.now();
        int dateNumber = actualDate.getYear() - selectDate.getYear() + 1;

        LocalDate[] dates = new LocalDate[dateNumber] ;

        int i = 0;
        while (i < dateNumber){
            dates[i]= selectDate;
            selectDate = selectDate.plusYears(1);
            i++;
        }

        DefaultComboBoxModel<LocalDate> comboBoxModel = new DefaultComboBoxModel<>(dates);

        return comboBoxModel;
    }

    public class searchAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int searchNumber = CustomUtilities.validateNumericField(customerNumberField.getText(),"Numéro Client");
                commandList.clear();
                commandList.addAll(controller.searchTotalCommands(searchNumber, (LocalDate) yearComboBox.getSelectedItem()));
                tableModel.fireTableDataChanged();

                String totalPrice = String.valueOf(SearchCommandInfo.getTotalPrice());
                totalLabel.setText("Prix Total pour l'année : " + totalPrice );

            }
            catch (customExceptions ex){
                JOptionPane.showMessageDialog(TaskPanel.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
