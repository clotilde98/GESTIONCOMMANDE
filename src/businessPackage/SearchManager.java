package businessPackage;

import dataAccessPackage.SearchDBAccess;
import dataAccessPackage.SearchDataAccess;
import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchManager {
    private SearchDataAccess dao;

    public SearchManager( ) {
        setDao (new SearchDBAccess()) ;
    }

    private void setDao(SearchDBAccess searchDBAccess) {
        this.dao = searchDBAccess;
    }

    public ArrayList<SearchProductHistory> searchProductHistories(String name) throws SQLException {
        return dao.customerProductHistory(name);
    }

    public ArrayList<SearchInvoiceList> searchInvoiceLists(int number,boolean isPaid) throws SQLException {
        return dao.customerInvoiceList(number,isPaid);
    }

    public ArrayList<SearchProductInfo> searchProductInfos(double price) throws SQLException {
        double priceMin = price - 50;
        double priceMax = price + 50;
        return dao.productInfosByPrice(priceMin,priceMax);
    }

    public ArrayList<SearchCommandInfo> totalCommands(int customer, int year) throws SQLException {
        ArrayList<SearchCommandInfo> datas = dao.customerCommandsInfosForSpecificYear(customer, year);
        return datas;
    }
}
