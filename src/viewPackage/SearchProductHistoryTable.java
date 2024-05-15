package viewPackage;

import modelPackage.SearchProductHistory;

import javax.swing.table.AbstractTableModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchProductHistoryTable extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<SearchProductHistory> contents;
    private List<SearchProductHistory> productHistories = new ArrayList<>();


    public SearchProductHistoryTable(ArrayList<SearchProductHistory> productHistories)
    { columnNames = new ArrayList<>();
        columnNames.add("Nom du produit");
        columnNames.add("Quantité");
        columnNames.add("Date de la commande");
        setContents(productHistories); }

    private void setContents(ArrayList<SearchProductHistory> productHistories) {
        this.contents = productHistories;
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
        SearchProductHistory productHistory = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return productHistory.getProductName();
            case 1:
                return productHistory.getQuantity();
            case 2:
                return productHistory.getCommandDate();
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return LocalDate.class;
            default:
                return Object.class;
        }
    }

}
