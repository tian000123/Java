package com.hbsd.day04;

public class VipUser {
    private String name;
    private Address homeAddress;

    public VipUser() {
    }

    public VipUser(String name, Address homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
