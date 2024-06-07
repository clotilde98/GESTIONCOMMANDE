package test;

import businessPackage.SearchManager;
import exceptionPackage.DataAccessException;
import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchManagerTest {
    private SearchManager searchManager;

    @BeforeEach
    void setUp() throws DataAccessException {
        searchManager = new SearchManager();
    }

    @Test
    void searchProductHistories() throws DataAccessException {
        ArrayList<SearchProductHistory> blankList = new ArrayList<>();
        //test super admin have no invoice
        assertEquals(blankList,searchManager.searchProductHistories("Super Admin"));
        //test customer Anna Belle have invoices
        assertNotEquals(blankList,searchManager.searchProductHistories("Belle"));

    }

    @Test
    void searchInvoiceLists() throws DataAccessException {
        ArrayList<SearchInvoiceList> blankList = new ArrayList<>();
        //test super admin have no invoice
        assertEquals(blankList,searchManager.searchInvoiceLists(1,true));
        //test customer Anna Belle have invoices
        assertNotEquals(blankList,searchManager.searchInvoiceLists(3,true));

    }

    @Test
    void searchProductInfos() throws DataAccessException {
        ArrayList<SearchProductInfo> blankList = new ArrayList<>();
        //test no products between 0 and 100
        assertEquals(blankList,searchManager.searchProductInfos(50));
        //test products between 100 and 200
        assertNotEquals(blankList,searchManager.searchProductInfos(150));
    }

    //Test Task
    @Test
    void totalCommands() throws DataAccessException {
        searchManager.totalCommands(3, LocalDate.parse("2023-01-01"));
        //expected total = total commandlign(price *quantity) - total commandLign * discount
        assertEquals(2174.5,SearchCommandInfo.getTotalPrice());
    }

}