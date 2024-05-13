package modelPackage;

public class CommandLign {
    private Integer id;
    private Command command;
    private Product product;
    private Integer quantity;
    private Integer discount;

    public CommandLign(Integer id, Command command, Product product, Integer quantity, Integer discount){
        setId(id);
        setCommand(command);
        setProduct(product);
        setQuantity(quantity);
        setDiscount(discount);
    }

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    //Getters

    public Integer getId() {
        return id;
    }

    public Command getCommand() {
        return command;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getDiscount() {
        return discount;
    }
}
