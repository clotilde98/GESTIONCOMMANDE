package modelPackage;

import java.time.LocalDate;

public class Customer {

    private Integer number;
    private String first_name;
    private String last_name;
    private String email;
    private String phone_number;
    private String password;
    private Character gender;
    private LocalDate birthday;
    private Boolean is_admin;
    private Boolean is_adherent;
    private Locality locality;
    private String street;
    private Integer street_number;
    private Integer number_sponsorised;

    public Customer(Integer number, String first_name, String last_name, String email, String phone_number, String password , Character gender,
                    LocalDate birthday, Boolean is_admin, Boolean is_adherent, Locality locality, String street, Integer streetNumber, Integer number_sponsorised){
        setNumber(number);
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setPhone_number(phone_number);
        setPassword(password);
        setGender(gender);
        setBirthday(birthday);
        setIs_admin(is_admin);
        setIs_adherent(is_adherent);
        setLocality(locality);
        setStreet(street);
        setStreet_number(streetNumber);
        setNumber_sponsorised(number_sponsorised);
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }

    public void setIs_adherent(Boolean is_adherent) {
        this.is_adherent = is_adherent;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(Integer street_number) {
        this.street_number = street_number;
    }

    public void setNumber_sponsorised(Integer number_sponsorised) {
        this.number_sponsorised = number_sponsorised;
    }

    public Integer getNumber() {
        return number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public Character getGender() {
        return gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Boolean getIs_admin() {
        return is_admin;
    }

    public Boolean getIs_adherent() {
        return is_adherent;
    }

    public Locality getLocality() {
        return locality;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreet_number() {
        return street_number;
    }

    public Integer getNumber_sponsorised() {
        return number_sponsorised;
    }
}
