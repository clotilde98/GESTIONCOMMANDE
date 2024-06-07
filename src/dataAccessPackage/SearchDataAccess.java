package dataAccessPackage;

import exceptionPackage.DataAccessException;
import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import java.time.LocalDate;
import java.util.ArrayList;

public interface SearchDataAccess {
    ArrayList<SearchProductHistory> customerProductHistory(String name) throws DataAccessException;

    ArrayList<SearchInvoiceList> customerInvoiceList(int number, boolean isPaid) throws DataAccessException;

    ArrayList<SearchProductInfo> productInfosByPrice(double priceMin, double priceMax) throws DataAccessException;

    ArrayList<SearchCommandInfo> customerCommandsInfosForSpecificYear(int number, LocalDate year) throws DataAccessException;
}
