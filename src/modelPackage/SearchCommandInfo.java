package modelPackage;

public class SearchCommandInfo {
    private String firstName;
    private String lastName;
    private Integer commandNumber;
    private Integer discount;
    private Double price;
    static private Double totalPrice;

    public SearchCommandInfo(String firstName, String lastName, Integer commandNumber, Integer discount, Double price){
        setFirstName(firstName);
        setLastName(lastName);
        setCommandNumber(commandNumber);
        setDiscount(discount);
        setPrice(price);
    }

    //Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public static void setTotalPrice(Double totalPrice) {
        SearchCommandInfo.totalPrice = totalPrice;
    }
}
