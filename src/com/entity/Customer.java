package com.entity;



public class Customer {
    private int id ;
    private String NAME ;
    private String address;
    private String phone ;

    public Customer() {
    }

    public Customer(int id, String NAME, String address, String phone) {
        this.id = id;
        this.NAME = NAME;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAME() {
      return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
