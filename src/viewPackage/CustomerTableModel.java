package viewPackage;

import modelPackage.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerTableModel extends AbstractTableModel {
    private ArrayList<String> columnNames = new ArrayList<>(Arrays.asList(
            "Prénom", "Nom", "Email", "Téléphone", "Genre", "Date de naissance",
            "Admin", "Adhérent", "Localité", "Rue", "Numéro de rue", "Nombre de sponsorisations"
    ));
    private List<Customer> customers;

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
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = customers.get(rowIndex);
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
                return customer.isAdmin() ? "Oui" : "Non";
            case 7:
                return customer.isAdherent() ? "Oui" : "Non";
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

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
        fireTableDataChanged(); // Notify the table that the data has changed
    }
}

