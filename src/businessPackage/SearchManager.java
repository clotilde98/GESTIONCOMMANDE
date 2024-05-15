package businessPackage;

import dataAccessPackage.SearchDBAccess;
import dataAccessPackage.SearchDataAccess;
import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchManager {
    private SearchDataAccess dao;

    public SearchManager( ) {
        setDao (new SearchDBAccess()) ;
    }

    private void setDao(SearchDBAccess searchDBAccess) {
        this.dao = searchDBAccess;
    }

    public ArrayList<SearchProductHistory> searchProductHistories(String name) {
        return dao.customerProductHistory(name);
    }

    public ArrayList<SearchInvoiceList> searchInvoiceLists(int number,boolean isPaid) {
        return dao.customerInvoiceList(number,isPaid);
    }

    public ArrayList<SearchProductInfo> searchProductInfos(double price) {
        double priceMin = price - 50;
        double priceMax = price + 50;
        return dao.productInfosByPrice(priceMin,priceMax);
    }

    public ArrayList<SearchCommandInfo> totalCommands(int customer, LocalDate year) {
        ArrayList<SearchCommandInfo> dataList = dao.customerCommandsInfosForSpecificYear(customer, year);
        ArrayList<SearchCommandInfo> newDataList = new ArrayList<>();

        int lignNumber = dataList.size();
        int newIndex = 0;

        newDataList.add(dataList.get(0));
        SearchCommandInfo.setTotalPrice(dataList.get(0).getPrice());

        for (int i = 1; i < lignNumber; i++){
            Double price = dataList.get(i).getPrice();
            Double total = SearchCommandInfo.getTotalPrice() + price;
            SearchCommandInfo.setTotalPrice(total);

            if (dataList.get(i-1).getCommandNumber().equals(dataList.get(i).getCommandNumber()) ){
                Double newPrice = newDataList.get(newIndex).getPrice() + price;
                newDataList.get(newIndex).setPrice(newPrice);
            }

            else {
                newDataList.add(dataList.get(i));
                newIndex ++;
            }
        }

        return newDataList;
    }
}
