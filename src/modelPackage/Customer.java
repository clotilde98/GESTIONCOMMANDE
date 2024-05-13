package modelPackage;

import java.util.Date;

public class Customer {

    private Integer number;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Character gender;
    private Date birthday; // Importez la classe Date correcte
    private Boolean isAdmin;
    private Boolean isAdherent;
    private Locality locality;
    private String street;
    private Integer streetNumber;
    private Integer numberSponsorised;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String password , Character gender,
                    Date birthday, Boolean isAdmin, Boolean isAdherent, Locality locality , Integer streetNumber,String street,  Integer numberSponsorised){
        //setNumber(number);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        setPassword(password);
        setGender(gender);
        setBirthday(birthday);
        setIsAdmin(isAdmin);
        setIsAdherent(isAdherent);
        setLocality(locality);
        setStreetNumber(streetNumber);
        setStreet(street);
        setNumberSponsorised(numberSponsorised);

    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setIsAdherent(Boolean isAdherent) {
        this.isAdherent = isAdherent;
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

    public void setNumberSponsorised(Integer numberSponsorised) {
        this.numberSponsorised = numberSponsorised;
    }

    public Integer getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public char getGender() {
        return gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public Boolean getIsAdherent() {
        return isAdherent;
    }

    public Locality getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public Integer getNumberSponsorised() {
        return numberSponsorised;
    }
}
