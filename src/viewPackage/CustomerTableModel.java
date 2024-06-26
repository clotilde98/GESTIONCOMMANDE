package viewPackage;

import modelPackage.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;


public class CustomerTableModel extends AbstractTableModel {
    private ArrayList<String> columnNames ;
    private ArrayList<Customer> contents;
    private List<Customer> customers = new ArrayList<>();


    public CustomerTableModel(ArrayList<Customer> customers)
    { columnNames = new ArrayList<>();
        columnNames.add("Numéro Client");
        columnNames.add("Prénom");
        columnNames.add("Nom");
        columnNames.add("Email");
        columnNames.add("Numero de téléphone");
        columnNames.add("Genre");
        columnNames.add("Mot de passe");
        columnNames.add("Date de naissance");
        columnNames.add("Admin");
        columnNames.add("Adhérent");
        columnNames.add("Localité");
        columnNames.add("Rue");
        columnNames.add("Numéro de rue");
        columnNames.add("Nombre de sponsorisations");
        setContents(customers); }

    private void setContents(ArrayList<Customer> customers) {
        this.contents = customers;
    }



    @Override
    public int getRowCount() {
        return contents.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames.get(columnIndex);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = contents.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return customer.getNumber();
            case 1:
                return customer.getFirstName();
            case 2:
                return customer.getLastName();
            case 3:
                return customer.getEmail();
            case 4:
                return customer.getPhoneNumber();
            case 5:
                return customer.getGender();
            case 6:
                return customer.getPassword();
            case 7:
                return customer.getBirthday();
            case 8:
                return customer.getIsAdmin();
            case 9:
                return customer.getIsAdherent();
            case 10:
                return customer.getLocality().getCity();
            case 11:
                return customer.getStreet();
            case 12:
                return customer.getStreetNumber();
            case 13:
                return customer.getNumberSponsorised();
            default:
                return null;
        }
    }

    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 10:case 11:
                return String.class;
            case 8: case 9:
                return Boolean.class;
            case 0: case 12: case 13:
                return Integer.class;
            default:
                return Object.class;
        }
    }


}

