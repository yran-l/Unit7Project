public class Address {
    private String houseNumber, street, apartmentNumber, city, state, zipCode;

    public Address(String houseNumber, String street, String apartmentNumber, String city, String state, String zipCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String address) {
        if (address.contains("Apt")){
            houseNumber = address.substring(0, address.indexOf(" "));
            address = address.substring(address.indexOf(" "));
            street = address.substring(1, address.indexOf("Apt") - 1);
            address = address.substring(address.indexOf("Apt"));
            apartmentNumber = address.substring(address.indexOf(" ") + 1, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 1);
            city = address.substring(1, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
            state = address.substring(0, address.indexOf(" "));
            zipCode = address.substring(address.indexOf(" ") + 1, address.length() - 1);
        }
        else{
            houseNumber = address.substring(0, address.indexOf(" "));
            address = address.substring(address.indexOf(" "));
            street = address.substring(1, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 1);
            city = address.substring(1, address.indexOf(","));
            address = address.substring(address.indexOf(",") + 2);
            state = address.substring(0, address.indexOf(" "));
            zipCode = address.substring(address.indexOf(" ") + 1, address.length() - 1);
        }

    }
    public Address(Address temp){
        this.zipCode = temp.getZipCode();
        this.apartmentNumber = temp.getApartmentNumber();
        this.houseNumber = temp.getHouseNumber();
        this.street = temp.getStreet();
        this.city = temp.getCity();
        this.state = temp.getState();
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String toString() {
        return houseNumber + " " + street + " Apt " + apartmentNumber + ", " + city + ", " + state + " " + zipCode;
    }
}
