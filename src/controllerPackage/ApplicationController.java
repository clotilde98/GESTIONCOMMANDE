package controllerPackage;

import businessPackage.ConnectionManager;
import businessPackage.CustomerManager;
import businessPackage.LocalityManager;
import businessPackage.SearchManager;
import exceptionPackage.DataAccessException;
import modelPackage.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class ApplicationController {

    private CustomerManager customerManager;
    private LocalityManager localityManager;
    private SearchManager searchManager;
    private ConnectionManager connectionManager;

    public ApplicationController() throws DataAccessException {
        setCustomerManager (new CustomerManager());
        setLocalityManager (new LocalityManager());
        setSearchManager(new SearchManager());
        setConnectionManager(new ConnectionManager());


    }

    private void setCustomerManager(CustomerManager customerManager) {this.customerManager = customerManager;}
    private void setLocalityManager(LocalityManager localityManager) {
        this.localityManager = localityManager;
    }

    public void setSearchManager(SearchManager searchManager) {this.searchManager = searchManager; }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    //Customer Manager
    public void addCustomer(Customer customer) throws DataAccessException {
        customerManager.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() throws DataAccessException {
        return  customerManager.getAllCustomers();
    }

    public void deleteCustomer(int number) throws DataAccessException { customerManager.deleteCustomer(number);}
    public void updateCustomer(Customer customer) throws DataAccessException { customerManager.updateCustomer(customer);}

    public Customer getUser(String email, String password) throws DataAccessException {
        return customerManager.getUSer(email,password);
    }

    public Customer getCustomer(Integer customerNumber) throws DataAccessException {
        return customerManager.getCustomer(customerNumber);
    }

    //Locality Manager
    public ArrayList<Locality> getAllLocalities() throws DataAccessException {
        return localityManager.getAllLocalities();
    }

    //Search Manager
    public ArrayList<SearchProductHistory> searchProductHistories(String name) throws DataAccessException {
        return searchManager.searchProductHistories(name);
    }

    public ArrayList<SearchInvoiceList> searchInvoiceLists(int number, boolean isPaid) throws DataAccessException {
        return searchManager.searchInvoiceLists(number,isPaid);
    }

    public ArrayList<SearchProductInfo> searchProductInfos(double price) throws DataAccessException {
        return searchManager.searchProductInfos(price);
    }

    public ArrayList<SearchCommandInfo> searchTotalCommands(int customer, LocalDate year) throws DataAccessException {
        return searchManager.totalCommands(customer,year);
    }

    public void closeConnection() throws DataAccessException {
        connectionManager.closeConnection();
    }

    public boolean customerExistsByEmail(String email) throws DataAccessException {
        return customerManager.customerExistsByEmail(email);
    }

}
