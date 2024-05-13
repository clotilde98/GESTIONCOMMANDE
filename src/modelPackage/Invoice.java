package modelPackage;

import java.time.LocalDate;

public class Invoice {
    private Integer number;
    private LocalDate date;
    private Command command;

    public Invoice(Integer number, LocalDate date, Command command){
        setNumber(number);
        setDate(date);
        setCommand(command);
    }

    //Setters

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    //Getters

    public Integer getNumber() {
        return number;
    }

    public LocalDate getDate() {
        return date;
    }

    public Command getCommand() {
        return command;
    }
}
