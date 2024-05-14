package dataAccessPackage;

import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchDataAccess {
    ArrayList<SearchProductHistory> customerProductHistory(String name) throws SQLException;

    ArrayList<SearchInvoiceList> customerInvoiceList(int number, boolean isPaid) throws SQLException;

    ArrayList<SearchProductInfo> productInfosByPrice(double priceMin, double priceMax) throws SQLException;

    ArrayList<SearchCommandInfo> customerCommandsInfosForSpecificYear(int number, int year) throws SQLException;
}
