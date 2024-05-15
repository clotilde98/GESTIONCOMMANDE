package dataAccessPackage;

import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import java.time.LocalDate;
import java.util.ArrayList;

public interface SearchDataAccess {
    ArrayList<SearchProductHistory> customerProductHistory(String name);

    ArrayList<SearchInvoiceList> customerInvoiceList(int number, boolean isPaid);

    ArrayList<SearchProductInfo> productInfosByPrice(double priceMin, double priceMax);

    ArrayList<SearchCommandInfo> customerCommandsInfosForSpecificYear(int number, LocalDate year);
}
