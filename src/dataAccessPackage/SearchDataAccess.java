package dataAccessPackage;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public interface SearchDataAccess {
    JTable customerProductHistory(String name) throws SQLException;

    JTable customerInvoiceList(int number,boolean isPaid) throws SQLException;

    JTable productInfosByPrice(double priceMin, double priceMax) throws SQLException;

    JTable customerCommandsInfosForSpecificYear(int number, int year) throws SQLException;
}
