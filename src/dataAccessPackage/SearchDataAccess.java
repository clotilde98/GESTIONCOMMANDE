package dataAccessPackage;

import javax.swing.*;
import java.sql.SQLException;

public interface SearchDataAccess {
    JTable customerProductHistory(String name) throws SQLException;

    JTable customerInvoiceList(Integer number,Boolean isPaid) throws SQLException;

    JTable productInfosByPrice(Double priceMin, Double priceMax) throws SQLException;

}
