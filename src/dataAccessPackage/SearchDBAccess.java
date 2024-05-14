package dataAccessPackage;

import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import java.sql.*;
import java.util.ArrayList;

public class SearchDBAccess implements SearchDataAccess{
    Connection connection = SingletonConnection.getInstance();

    public ArrayList<SearchProductHistory> customerProductHistory(String name) throws SQLException {
        String sqlInstruction = "select product.name, command.command_date, commandlign.quantity " +
                "from product inner join command inner join commandlign inner join customer\n" +
                "where command.number = commandlign.number and product.reference = commandlign.reference \n" +
                "and command.customer = customer.number and customer.last_name = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setString(1,name);

        ResultSet data = statement.executeQuery();

        return null;
    }

    public ArrayList<SearchInvoiceList> customerInvoiceList(int number, boolean isPaid) throws SQLException {
        String sqlInstruction = "select customer.last_name 'Nom', customer.first_name 'Prénom', command.command_date 'Date de la commande'," +
                " invoice.number 'Numéro de facture', invoice.date 'date de la facture' \n" +
                "from customer inner join command inner join invoice\n" +
                "where customer.number = command.customer and invoice.command = command.number and customer.number = ? and command.is_paid = ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setInt(1,number);
        statement.setBoolean(2,isPaid);

        ResultSet data = statement.executeQuery();

        return null;
    }

    public ArrayList<SearchProductInfo> productInfosByPrice(double priceMin, double priceMax) throws SQLException {
        String sqlInstruction = "select product.name 'Nom du produit', product.stock 'Stock', category.name 'Catégorie'," +
                " provider.name 'Fournisseur', locality.city 'Ville du fournisseur'\n" +
                "from product inner join category inner join provider inner join locality\n" +
                "where product.category = category.id and product.provider = provider.number and provider.locality = locality.id " +
                "and product.price > ? and product.price < ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setDouble(1,priceMin);
        statement.setDouble(2,priceMax);

        ResultSet data = statement.executeQuery();

        return null;
    }

    public ArrayList<SearchCommandInfo> customerCommandsInfosForSpecificYear(int number, int year) throws SQLException {
        String startDate = year + "-01-01";
        year++;
        String endDate = year + "-01-01";
        String sqlInstruction = "select product.name 'Nom du produit', product.stock 'Stock', category.name 'Catégorie'," +
                " provider.name 'Fournisseur', locality.city 'Ville du fournisseur'\n" +
                "from product inner join category inner join provider inner join locality\n" +
                "where product.category = category.id and product.provider = provider.number and provider.locality = locality.id " +
                "and product.price > ? and product.price < ?";

        PreparedStatement statement = connection.prepareStatement(sqlInstruction);
        statement.setInt(1,number);
        statement.setString(2,startDate);
        statement.setString(3,endDate);

        ResultSet data = statement.executeQuery();

        return null;
    }
}
