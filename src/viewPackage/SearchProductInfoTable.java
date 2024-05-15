package viewPackage;

import modelPackage.SearchProductInfo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class SearchProductInfoTable extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<SearchProductInfo> contents;
    private List<SearchProductInfo> productInfos = new ArrayList<>();


    public SearchProductInfoTable(ArrayList<SearchProductInfo> productInfos)
    { columnNames = new ArrayList<>();
        columnNames.add("Nom du produit");
        columnNames.add("Stock");
        columnNames.add("Catégorie");
        columnNames.add("Fournisseur");
        columnNames.add("Ville du fournisseur");
        setContents(productInfos); }

    private void setContents(ArrayList<SearchProductInfo> productInfos) {
        this.contents = productInfos;
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
        SearchProductInfo productInfo = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return productInfo.getProductName();
            case 1:
                return productInfo.getStock();
            case 2:
                return productInfo.getCategory();
            case 3:
                return productInfo.getProvider();
            case 4:
                return productInfo.getCityProvider();
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: case 2: case 3: case 4:
                return String.class;
            case 1:
                return Integer.class;
            default:
                return Object.class;
        }
    }
}
