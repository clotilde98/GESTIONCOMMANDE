package controllerPackage;

import businessPackage.CustomerManager;
import businessPackage.LocalityManager;
import businessPackage.SearchManager;
import modelPackage.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class ApplicationController {

    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private SearchManager searchManager;

    public ApplicationController() {
        setCustomerManager (new CustomerManager());
        setLocalityManager (new LocalityManager());
        setSearchManager(new SearchManager());
    }

    private void setCustomerManager(CustomerManager customerManager) {this.customerManager = customerManager;}
    private void setLocalityManager(LocalityManager localityManager) {
        this.localityManager = localityManager;
    }

    public void setSearchManager(SearchManager searchManager) {this.searchManager = searchManager; }


    //Customer Manager
    public void addCustomer(Customer customer) throws  SQLException {
        customerManager.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() throws SQLException  {
        return customerManager.getAllCustomers();
    }

    //Locality Manager
    public ArrayList<Locality> getAllLocalities() throws SQLException {
        return localityManager.getAllLocalities();
    }

    //Search Manager
    public ArrayList<SearchProductHistory> searchProductHistories(String name) throws SQLException {
        return searchManager.searchProductHistories(name);
    }

    public ArrayList<SearchInvoiceList> searchInvoiceLists(int number, boolean isPaid) throws SQLException {
        return searchManager.searchInvoiceLists(number,isPaid);
    }

    public ArrayList<SearchProductInfo> searchProductInfos(double price) throws SQLException {
        return searchManager.searchProductInfos(price);
    }

    public ArrayList<SearchCommandInfo> searchTotalCommands(int customer, int year) throws SQLException {
        return searchManager.totalCommands(customer,year);
    }

}
