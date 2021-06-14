package com.example.employeepayroll.dto;

public class AddressDTO {

    private String street;
    private String houseNumber;
    private String city;
    private String district;
    private String state;
    private String pinCode;

    public AddressDTO() {
    }

    public AddressDTO( String street, String houseNumber, String city, String district, String state, String pinCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
