package com.spring.entity;

public class Store {
    private int id;
    private String sort;
    private String name;
    private String mainMenu;
    private String price;
    private String phone;
    private String address;
    private String lat;
    private String lng;

    public Store(int id, String sort, String name, String mainMenu, String price, String phone, String address, String lat, String lng) {
        this.id = id;
        this.sort = sort;
        this.name = name;
        this.mainMenu = mainMenu;
        this.price = price;
        this.phone = phone;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public String getSort() {
        return sort;
    }

    public String getName() {
        return name;
    }

    public String getMainMenu() {
        return mainMenu;
    }

    public String getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", name='" + name + '\'' +
                ", mainMenu='" + mainMenu + '\'' +
                ", price='" + price + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
