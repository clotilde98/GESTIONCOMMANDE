package businessPackage;

import dataAccessPackage.SearchDBAccess;
import dataAccessPackage.SearchDataAccess;
import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

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

        int lignNumber = dataList.size();

        SearchCommandInfo.setTotalPrice(0.0);

        for (int i = 0; i < lignNumber; i++){
            //Product price
            Double price = dataList.get(i).getPrice();
            //price * quantity
            price = price * (double)dataList.get(i).getQuantity();

            double discount =price * ((double)dataList.get(i).getDiscount()/100);
            //price less discount
            price = price - discount;
            dataList.get(i).setPrice(price);
            Double total = SearchCommandInfo.getTotalPrice() + price;
            SearchCommandInfo.setTotalPrice(total);
        }

        return dataList;
    }
}
