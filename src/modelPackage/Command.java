package modelPackage;

import java.time.LocalDate;

public class Command {
    private Integer number;
    private LocalDate commandDate;
    private Boolean isPaid;
    private LocalDate deliveryDate;
    private Customer customer;

    public Command(Integer number,LocalDate commandDate, Boolean isPaid, LocalDate deliveryDate, Customer customer){
        setNumber(number);
        setCommandDate(commandDate);
        setPaid(isPaid);
        setDeliveryDate(deliveryDate);
        setCustomer(customer);
    }

//Setters
    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCommandDate(LocalDate commandDate) {
        this.commandDate = commandDate;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //Getters
    public Integer getNumber() {
        return number;
    }

    public LocalDate getCommandDate() {
        return commandDate;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public Customer getCustomer() {
        return customer;
    }
}
