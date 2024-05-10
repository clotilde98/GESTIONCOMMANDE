package modelPackage;

public class Locality {
    private Integer id;
    private String city;
    private Integer zip_code;
    private Country country;

    public Locality(String city, Integer zip_code, Country country){
        setCity(city);
        setZip_code(zip_code);
        setCountry(country);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip_code(Integer zip_code) {
        this.zip_code = zip_code;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public Integer getZip_code() {
        return zip_code;
    }

    public Country getCountry() {
        return country;
    }
}
