package com.group3.wineshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wine {

    @Id
    private int id;
    private String name;
    private int year;
    private Float rating;
    private int num_reviews;
    private Float price;
    private int body;
    private int acidity;
    private int winery_id;
    private int type_id;
    private int region_id;

    public Wine(){

    }

    public Wine(int id, String name, int year, Float rating, int num_reviews, Float price, int body, int acidity, int winery_id, int type_id, int region_id) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.winery_id = winery_id;
        this.type_id = type_id;
        this.region_id = region_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getAcidity() {
        return acidity;
    }

    public void setAcidity(int acidity) {
        this.acidity = acidity;
    }

    public int getWinery_id() {
        return winery_id;
    }

    public void setWinery_id(int winery_id) {
        this.winery_id = winery_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }
}
