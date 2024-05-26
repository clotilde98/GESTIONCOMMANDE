package modelPackage;

public class SearchProductInfo {
    private String productName;
    private String category;
    private Double price;
    private Integer stock;
    private String provider;
    private String cityProvider;

    public SearchProductInfo(String productName, String category,Double price, Integer stock, String provider, String cityProvider){
        setProductName(productName);
        setCategory(category);
        setPrice(price);
        setStock(stock);
        setProvider(provider);
        setCityProvider(cityProvider);
    }

    //Setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(Double price) { this.price = price;}

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setCityProvider(String cityProvider) {
        this.cityProvider = cityProvider;
    }

    //Getters
    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() { return price;}

    public Integer getStock() {
        return stock;
    }

    public String getProvider() {
        return provider;
    }

    public String getCityProvider() {
        return cityProvider;
    }
}
