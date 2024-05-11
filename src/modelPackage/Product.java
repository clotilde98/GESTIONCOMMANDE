package modelPackage;

public class Product {
    private Integer reference;
    private String name;
    private Double price;
    private Integer stock;
    private Provider provider;
    private Category category;

    public Product(Integer reference, String name, Double price, Integer stock, Provider provider, Category category){
        setReference(reference);
        setName(name);
        setPrice(price);
        setStock(stock);
        setProvider(provider);
        setCategory(category);
    }
    public void setReference(Integer reference) {
        this.reference = reference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
