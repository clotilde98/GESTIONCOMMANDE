package modelPackage;

public class SearchProductInfo {
    private String productName;
    private String category;
    private Integer stock;
    private String provider;
    private String cityProvider;

    public SearchProductInfo(String productName, String category, Integer stock, String provider, String cityProvider){
        setProductName(productName);
        setCategory(category);
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

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setCityProvider(String cityProvider) {
        this.cityProvider = cityProvider;
    }
}
