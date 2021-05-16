package com.example.lab8_2;

public class City {
    private int img;
    private String name_city;

    public City(int img, String name_city) {
        this.img = img;
        this.name_city = name_city;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName_city() {
        return name_city;
    }

    public void setName_city(String name_city) {
        this.name_city = name_city;
    }
}
