package com.tourism.Travel_Buddy.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Packages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String location;
    private String description;
    private float price;
    private Date date;

    @Lob
    private String img;

    public Packages() {
    }

    public Packages(int id, String location, String description, float price, Date date, String img) {
        this.id = id;
        this.location = location;
        this.description = description;
        this.price = price;
        this.date = date;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
