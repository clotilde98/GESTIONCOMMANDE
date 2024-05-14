package modelPackage;

import java.time.LocalDate;

public class SearchInvoiceList {
    private String firstName;
    private String lastName;
    private Integer invoiceNumber;
    private LocalDate commandDate;
    private LocalDate invoiceDate;

    public SearchInvoiceList(String firstName,String lastName, Integer invoiceNumber, LocalDate commandDate, LocalDate invoiceDate){
        setFirstName(firstName);
        setLastName(lastName);
        setInvoiceNumber(invoiceNumber);
        setCommandDate(commandDate);
        setInvoiceDate(invoiceDate);
    }

    //Setters

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setCommandDate(LocalDate commandDate) {
        this.commandDate = commandDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
}
