package modelPackage;

public class Locality {
    private Integer id;
    private String city;
    private Integer zipCode;
    private Country country;

    public Locality(String city, Integer zipCode, Country country){
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(Integer zip_code) {
        this.zipCode = zipCode;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public Country getCountry() {
        return country;
    }
}
