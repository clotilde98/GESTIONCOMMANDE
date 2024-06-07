package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.CustomExceptions;
import exceptionPackage.DataAccessException;
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

    private JScrollPane scrollPane;
    private JLabel totalLabel, customerLabel;

    private JTable result;
    private SearchCommandInfoTable tableModel;
    private ArrayList<SearchCommandInfo> commandList;

    private ApplicationController controller;

    public TaskPanel(){


        try {
            setController(new ApplicationController());
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(TaskPanel.this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        setLayout(new BorderLayout());

        search = new JButton("Rechercher");


        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        search.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 25);
        search.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(14, 1));
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

        JPanel resultPanel = new JPanel(new GridLayout(2,3));
        customerLabel = new JLabel("");
        totalLabel = new JLabel("");
        resultPanel.add(customerLabel);
        resultPanel.add(totalLabel);

        searchPanel.add(searchButtonPanel);
        searchPanel.add(resultPanel);
        search.addActionListener(new searchAction());


        try {
            commandList = controller.searchTotalCommands(1,LocalDate.parse("2000-01-01"));
        } catch (DataAccessException e) {
            JOptionPane.showMessageDialog(TaskPanel.this, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        tableModel = new SearchCommandInfoTable(commandList);

        result = new JTable(tableModel);

        scrollPane = new JScrollPane(result);

        add(scrollPane, BorderLayout.CENTER);
        add(searchPanel, BorderLayout.WEST);

    }

    private void setController(ApplicationController controller) {
        this.controller = controller;
    }

    private DefaultComboBoxModel<LocalDate> getDateDataModel() {
        LocalDate selectDate = LocalDate.parse("2020-01-01"); // Start date Selection
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

                if (commandList.isEmpty()) {
                    JOptionPane.showMessageDialog(TaskPanel.this, "Aucune commande correspond à ce numero.", "Aucun résultat", JOptionPane.INFORMATION_MESSAGE);
                }


                //Reset result
                customerLabel.setText("");
                totalLabel.setText("");

                String lastName = SearchCommandInfo.getLastName();
                if (lastName !=  null){
                    String firstName = SearchCommandInfo.getFirstName();
                    if (firstName == null){
                        firstName = "";
                    }
                    else {
                        firstName = firstName + " ";
                    }

                    customerLabel.setText("Client: "+ firstName + lastName);

                    String totalPrice = String.valueOf(SearchCommandInfo.getTotalPrice());
                    totalLabel.setText("\nPrix Total pour l'année : " + totalPrice );
                }



            }
            catch (CustomExceptions | DataAccessException ex){
                JOptionPane.showMessageDialog(TaskPanel.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
