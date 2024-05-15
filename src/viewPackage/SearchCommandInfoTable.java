package viewPackage;


import modelPackage.SearchCommandInfo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class SearchCommandInfoTable extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<SearchCommandInfo> contents;
    private List<SearchCommandInfo> commandInfos = new ArrayList<>();


    public SearchCommandInfoTable(ArrayList<SearchCommandInfo> commandInfos)
    { columnNames = new ArrayList<>();
        columnNames.add("Numéro de commande");
        columnNames.add("Prix");
        setContents(commandInfos); }

    private void setContents(ArrayList<SearchCommandInfo> commandInfos) {
        this.contents = commandInfos;
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
        SearchCommandInfo commandInfo = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return commandInfo.getCommandNumber();
            case 1:
                return commandInfo.getPrice();
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return Double.class;
            default:
                return Object.class;
        }
    }
}
