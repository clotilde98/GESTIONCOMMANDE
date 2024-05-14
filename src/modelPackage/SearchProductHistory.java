package modelPackage;

import java.time.LocalDate;

public class SearchProductHistory {
    private String productName;
    private LocalDate commandDate;
    private Integer quantity;

    public SearchProductHistory(String productName, LocalDate commandDate, Integer quantity){
        setProductName(productName);
        setCommandDate(commandDate);
        setQuantity(quantity);
    }

    //Setters

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCommandDate(LocalDate commandDate) {
        this.commandDate = commandDate;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    //Getters
    public String getProductName() {
        return productName;
    }

    public LocalDate getCommandDate() {
        return commandDate;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
