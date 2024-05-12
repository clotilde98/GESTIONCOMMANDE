package modelPackage;

public class Locality {
    private Integer id;
    private String city;
    private Integer zipCode;
    private Country country;

    public Locality(Integer id, String city, Integer zipCode, Country country){
        setId(id);
        setCity(city);
        setZipCode(zipCode);
        setCountry(country);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getId() {
        return id;
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
