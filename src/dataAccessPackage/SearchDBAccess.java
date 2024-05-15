package dataAccessPackage;

import modelPackage.SearchCommandInfo;
import modelPackage.SearchInvoiceList;
import modelPackage.SearchProductHistory;
import modelPackage.SearchProductInfo;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchDBAccess implements SearchDataAccess{
    Connection connection = SingletonConnection.getInstance();

    public ArrayList<SearchProductHistory> customerProductHistory(String name) {

        ArrayList<SearchProductHistory> dataList = new ArrayList<>();

        try {
            String sqlInstruction = "select product.name, command.command_date, commandlign.quantity " +
                    "from product inner join command inner join commandlign inner join customer\n" +
                    "where command.number = commandlign.number and product.reference = commandlign.reference \n" +
                    "and command.customer = customer.number and customer.last_name = ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setString(1,name);

            ResultSet data = statement.executeQuery();

            while(data.next()){
                String productName = data.getString("name");
                LocalDate commandDate = data.getDate("command_date").toLocalDate() ;
                Integer quantity =  data.getInt("quantity");
                dataList.add(new SearchProductHistory(productName,commandDate,quantity));
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }


        return dataList;
    }

    public ArrayList<SearchInvoiceList> customerInvoiceList(int number, boolean isPaid) {

        ArrayList<SearchInvoiceList> dataList = new ArrayList<>();

        try {
            String sqlInstruction = "select customer.last_name, customer.first_name, command.command_date," +
                    " invoice.number, invoice.date\n" +
                    "from customer inner join command inner join invoice\n" +
                    "where customer.number = command.customer and invoice.command = command.number and customer.number = ? and command.is_paid = ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setInt(1,number);
            statement.setBoolean(2,isPaid);

            ResultSet data = statement.executeQuery();

            while(data.next()){
                String firstName = data.getString("first_name");
                String lastName = data.getString("last_name");
                Integer invoiceNumber = data.getInt("number");
                LocalDate commandDate = data.getDate("command_date").toLocalDate();
                LocalDate invoiceDate = data.getDate("date").toLocalDate();

                dataList.add(new SearchInvoiceList(firstName,lastName,invoiceNumber,commandDate,invoiceDate));
            }

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }


        return dataList;
    }

    public ArrayList<SearchProductInfo> productInfosByPrice(double priceMin, double priceMax) {

        ArrayList<SearchProductInfo> dataList = new ArrayList<>();

        try {
            String sqlInstruction = "select product.name 'product_name', product.stock, category.name 'category_name', provider.name 'provider_name', locality.city\n" +
                    "from product inner join category inner join provider inner join locality\n" +
                    "where product.category = category.id and product.provider = provider.number and provider.locality = locality.id " +
                    "and product.price > ? and product.price < ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setDouble(1,priceMin);
            statement.setDouble(2,priceMax);

            ResultSet data = statement.executeQuery();

            while(data.next()){
                String productName = data.getString("product_name");
                String category = data.getString("category_name");
                Integer stock = data.getInt("stock");
                String provider = data.getString("provider_name");
                String cityProvider = data.getString("city");

                dataList.add(new SearchProductInfo(productName,category,stock,provider,cityProvider));
            }
        }

        catch(SQLException e){
            throw new RuntimeException(e);
        }

        return dataList;
    }

    public ArrayList<SearchCommandInfo> customerCommandsInfosForSpecificYear(int number, LocalDate year)  {

        LocalDate nextYear = year.plusYears(1);

        ArrayList<SearchCommandInfo> dataList = new ArrayList<>();

        try {
            String sqlInstruction = "select customer.first_name, customer.last_name, command.number, commandlign.discount, commandlign.quantity, product.price\n" +
                    "from customer inner join command inner join commandlign inner join product\n" +
                    "where customer.number = ? and customer.number = command.customer and commandlign.number = command.number " +
                    "and commandlign.reference = product.reference and command.command_date >= ? and command.command_date < ?";

            PreparedStatement statement = connection.prepareStatement(sqlInstruction);
            statement.setInt(1,number);
            statement.setDate(2,Date.valueOf(year));
            statement.setDate(3,Date.valueOf(nextYear));

            ResultSet data = statement.executeQuery();

            while(data.next()){

                if (data.isFirst()){
                    SearchCommandInfo.setFirstName(data.getString("first_name"));
                    SearchCommandInfo.setLastName(data.getString("last_name"));
                }

                Integer commandNumber = data.getInt("number");
                Integer discount = data.getInt("discount");
                Double price = data.getDouble("price");

                dataList.add(new SearchCommandInfo(commandNumber,discount,price));
            }

        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

        return dataList;
    }
}
