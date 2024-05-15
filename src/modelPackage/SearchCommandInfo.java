package modelPackage;

public class SearchCommandInfo {
    private static String firstName;
    private static String lastName;
    private Integer commandNumber;

    private Integer quantity;
    private Integer discount;
    private Double price;
    private static Double totalPrice;

    public SearchCommandInfo(Integer commandNumber, Integer discount, Integer quantity, Double price){
        setCommandNumber(commandNumber);
        setDiscount(discount);
        setQuantity(quantity);
        setPrice(price);
    }

    //Setters
    public static void setFirstName(String firstName) {
        SearchCommandInfo.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        SearchCommandInfo.lastName = lastName;
    }

    public void setCommandNumber(Integer commandNumber) {
        this.commandNumber = commandNumber;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static void setTotalPrice(Double totalPrice) {
        SearchCommandInfo.totalPrice = totalPrice;
    }

    //Getters
    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public Integer getCommandNumber() {
        return commandNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Double getPrice() {
        return price;
    }

    public static Double getTotalPrice() {
        return totalPrice;
    }
}
