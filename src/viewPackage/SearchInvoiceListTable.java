package viewPackage;

import modelPackage.SearchInvoiceList;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchInvoiceListTable extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<SearchInvoiceList> contents;
    private List<SearchInvoiceList> invoiceLists = new ArrayList<>();


    public SearchInvoiceListTable(ArrayList<SearchInvoiceList> invoiceLists)
    { columnNames = new ArrayList<>();
        columnNames.add("Prénom");
        columnNames.add("Nom");
        columnNames.add("Date de la commande");
        columnNames.add("Numéro de Facture");
        columnNames.add("Date de Facture");
        setContents(invoiceLists); }

    private void setContents(ArrayList<SearchInvoiceList> invoiceLists) {
        this.contents = invoiceLists;
    }


    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SearchInvoiceList invoiceList = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return invoiceList.getFirstName();
            case 1:
                return invoiceList.getLastName();
            case 2:
                return invoiceList.getCommandDate();
            case 3:
                return invoiceList.getInvoiceNumber();
            case 4:
                return invoiceList.getInvoiceDate();
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: case 1:
                return String.class;
            case 2: case 4:
                return LocalDate.class;
            case 3:
                return Integer.class;
            default:
                return Object.class;
        }
    }

}
