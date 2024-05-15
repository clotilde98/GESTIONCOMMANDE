package controllerPackage;

import businessPackage.CustomerManager;
import businessPackage.LocalityManager;
import businessPackage.SearchManager;
import exceptionPackage.InvalidDataLoginException;
import modelPackage.*;

import java.sql.SQLException;
import java.time.LocalDate;
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
    public void addCustomer(Customer customer) {
        customerManager.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return  customerManager.getAllCustomers();
    }

    public Customer getUser(String email, String password) throws InvalidDataLoginException {
        return customerManager.getUSer(email,password);
    }

    //Locality Manager
    public ArrayList<Locality> getAllLocalities() throws SQLException {
        return localityManager.getAllLocalities();
    }

    //Search Manager
    public ArrayList<SearchProductHistory> searchProductHistories(String name) {
        return searchManager.searchProductHistories(name);
    }

    public ArrayList<SearchInvoiceList> searchInvoiceLists(int number, boolean isPaid) {
        return searchManager.searchInvoiceLists(number,isPaid);
    }

    public ArrayList<SearchProductInfo> searchProductInfos(double price) {
        return searchManager.searchProductInfos(price);
    }

    public ArrayList<SearchCommandInfo> searchTotalCommands(int customer, LocalDate year) {
        return searchManager.totalCommands(customer,year);
    }

}
