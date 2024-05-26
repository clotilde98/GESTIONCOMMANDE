package viewPackage;

import controllerPackage.ApplicationController;
import exceptionPackage.customExceptions;
import modelPackage.SearchInvoiceList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchInvoicePanel extends JPanel {
    private JTextField customerNumberField;
    private JRadioButton paid, notPaid;

    private JButton search;
    private MenuProjet projectMenu;

    private JScrollPane scrollPane;

    private JTable result;
    private SearchInvoiceListTable tableModel;
    private ArrayList<SearchInvoiceList> invoiceList;

    private ApplicationController controller;

    public SearchInvoicePanel(MenuProjet projectMenu){
        this.projectMenu = projectMenu;

        setController(new ApplicationController());

        setBounds(100, 100, 500, 500);

        setLayout(new BorderLayout());

        search = new JButton("Rechercher");
        paid = new JRadioButton("Payée");
        notPaid = new JRadioButton("Non payée");

        ButtonGroup paidGroup = new ButtonGroup();
        paidGroup.add(paid);
        paidGroup.add(notPaid);


        // Réduire la taille et changer la police des boutons
        Font buttonFont = new Font("Arial", Font.BOLD, 12);

        search.setFont(buttonFont);

        Dimension buttonSize = new Dimension(200, 30);
        search.setPreferredSize(buttonSize);

        // Mettre en couleur la partie des boutons
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(14, 1));
        searchPanel.setBorder(new EmptyBorder(50, 20, 100, 50));

        customerNumberField = new JTextField(10);

        JPanel searchButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        searchPanel.add(new JLabel("Numéro Client:"));
        searchPanel.add(customerNumberField);

        searchPanel.add(new JLabel("Paiement:"));
        searchPanel.add(paid);
        searchPanel.add(notPaid);
        searchButtonPanel.add(search);
        searchPanel.add(searchButtonPanel);
        search.addActionListener(new searchAction());

        invoiceList = controller.searchInvoiceLists(1,false);
        tableModel = new SearchInvoiceListTable(invoiceList);

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
                int searchNumber = CustomUtilities.validateNumericField(customerNumberField.getText(),"Numéro Client");
                boolean isPaid = CustomUtilities.validateBoolean(paid.isSelected(),notPaid.isSelected(),"Paiement");
                invoiceList.clear();
                invoiceList.addAll(controller.searchInvoiceLists(searchNumber,isPaid));
                tableModel.fireTableDataChanged();
            }
            catch (customExceptions ex){
                JOptionPane.showMessageDialog(SearchInvoicePanel.this, ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        }
    }
}
