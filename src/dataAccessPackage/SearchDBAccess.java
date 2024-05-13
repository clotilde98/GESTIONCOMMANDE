package dataAccessPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;

public class SearchDBAccess implements SearchDataAccess{
    Connection connection = SingletonConnection.getInstance();

    public JTable customerProductHistory(String name) throws SQLException {
        String sqlInstruction = "select product.name 'Nom du produit', command.command_date 'Date de la commande', commandlign.quantity 'Quantité'" +
                "from product inner join command inner join commandlign inner join customer\n" +
                "where command.number = commandlign.number and product.reference = commandlign.reference \n" +
                "and command.customer = customer.number and customer.last_name = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setString(1,name);

        ResultSet data = statement.executeQuery();

        return new JTable(resultSetToTable(data));
    }

    public JTable customerInvoiceList(Integer number,Boolean isPaid) throws SQLException {
        String sqlInstruction = "select customer.last_name 'Nom', customer.first_name 'Prénom', command.command_date 'Date de la commande'," +
                " invoice.number 'Numéro de facture', invoice.date 'date de la facture' \n" +
                "from customer inner join command inner join invoice\n" +
                "where customer.number = command.customer and invoice.command = command.number and customer.number = ? and command.is_paid = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setInt(1,number);
        statement.setBoolean(2,isPaid);

        ResultSet data = statement.executeQuery();

        return new JTable(resultSetToTable(data));
    }

    public JTable productInfosByPrice(Double priceMin, Double priceMax) throws SQLException {
        String sqlInstruction = "select product.name 'Nom du produit', product.stock 'Stock', category.name 'Catégorie'," +
                " provider.name 'Fournisseur', locality.city 'Ville du fournisseur'\n" +
                "from product inner join category inner join provider inner join locality\n" +
                "where product.category = category.id and product.provider = provider.number and provider.locality = locality.id " +
                "and product.price > ? and product.price < ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setDouble(1,priceMin);
        statement.setDouble(2,priceMax);

        ResultSet data = statement.executeQuery();

        return new JTable(resultSetToTable(data));
    }

    public DefaultTableModel resultSetToTable(ResultSet data) throws SQLException {

        ResultSetMetaData meta = data.getMetaData();
        Vector<String> titles = new Vector<>();
        int columnNumber = meta.getColumnCount();
        for (int i = 1; i <= columnNumber; i++) {
            titles.add(meta.getColumnName(i));
        }

        Vector<Vector<Object>> datas = new Vector<Vector<Object>>();
        while (data.next()) {
            Vector<Object> lign = new Vector<>();
            for (int i = 1; i <= columnNumber; i++) {
                lign.add(data.getObject(i));
            }
            datas.add(lign);
        }

        return new DefaultTableModel(datas,titles);
    }
}
