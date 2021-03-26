package objects;

public class User {

    public String email;
    public String password;

    public String firstName;
    public String lastName;

    public Integer dayBirth;
    public Integer monthBirth;
    public Integer yearBirth;

    public String company;
    public String address1;
    public String address2;
    public String city;
    public String state;
    public String country;
    public String zipCode;

    public String homePhone;
    public String mobilePhone;

    public String addressAlias;


    public void setUser(String email, String password){

        this.email = email;
        this.password = password;

    }

    public void setUser(String email, String password, String firstName, String lastName, Integer dayBirth,
                        Integer monthBirth, Integer yearBirth, String company, String address1, String address2,
                        String city, String state, String zipCode,  String country, String homePhone, String mobilePhone,
                        String addressAlias){

        this.email = email;
        this.password = password;

        this.firstName = firstName;
        this.lastName = lastName;

        this.dayBirth = dayBirth;
        this.monthBirth = monthBirth;
        this.yearBirth = yearBirth;

        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;

        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;

        this.addressAlias = addressAlias;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getDayBirth() {
        return dayBirth;
    }

    public void setDayBirth(Integer dayBirth) { this.dayBirth = dayBirth; }

    public Integer getMonthBirth() {
        return monthBirth;
    }

    public void setMonthBirth(Integer monthBirth) {
        this.monthBirth = monthBirth;
    }

    public Integer getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(Integer yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }
}
