package viewPackage;

import modelPackage.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CustomerTableModel extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<Customer> contents;
    private List<Customer> customers = new ArrayList<>(); // Initialisation de la liste


    public CustomerTableModel(ArrayList<Customer> customers)
    { columnNames = new ArrayList<>();
        columnNames.add("Prénom");
        columnNames.add("Nom");
        columnNames.add("Email");
        columnNames.add("Genre");
        columnNames.add("Date de naissance");
        columnNames.add("Admin");
        columnNames.add("Adhérent");
        columnNames.add("Localité");
        columnNames.add("Rue");
        columnNames.add("Localité");
        columnNames.add("Numéro de rue");
        columnNames.add("Nombre de sponsorisations");
        setContents(customers); }

    private void setContents(ArrayList<Customer> customers) {
    }

    public CustomerTableModel() {
        this.customers = new ArrayList<>();
    }

    public CustomerTableModel(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size( );
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return customer.getFirstName();
            case 1:
                return customer.getLastName();
            case 2:
                return customer.getEmail();
            case 3:
                return customer.getPhoneNumber();
            case 4:
                return customer.getGender();
            case 5:
                return customer.getBirthday();
            case 6:
                return customer.getIsAdmin();
            case 7:
                return customer.getIsAdherent();
            case 8:
                return customer.getLocality().getCity();
            case 9:
                return customer.getStreet();
            case 10:
                return customer.getStreetNumber();
            case 11:
                return customer.getNumberSponsorised();
            default:
                return null;
        }
    }


}

