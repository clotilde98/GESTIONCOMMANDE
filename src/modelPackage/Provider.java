package modelPackage;

public class Provider {
    private Integer number;
    private String name;
    private String email;
    private String phoneNumber;
    private Locality locality;
    private String street;
    private Integer streetNumber;

    public Provider(Integer number, String name, String email, String phoneNumber, Locality locality, String street, Integer streetNumber){
        setNumber(number);
        setName(name);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setLocality(locality);
        setStreet(street);
        setStreetNumber(streetNumber);
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }
}
