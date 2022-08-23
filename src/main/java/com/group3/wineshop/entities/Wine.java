package com.group3.wineshop.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name="Wine")
@Entity

public class Wine {

    @Id
    private int id;
    private String name;
    private int year;
    private Float rating;
    private int numReviews;
    private Float price;
    private int body;
    private int acidity;
    private int wineryId;
    private int typeId;
    private int region_id;

    public Wine(){

    }

    public Wine(int id, String name, int year, Float rating, int num_reviews, Float price, int body, int acidity, int winery_id, int type_id, int region_id) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.numReviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.wineryId = winery_id;
        this.typeId = type_id;
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

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int num_reviews) {
        this.numReviews = num_reviews;
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

    public int getWineryId() {
        return wineryId;
    }

    public void setWineryId(int winery_id) {
        this.wineryId = winery_id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int type_id) {
        this.typeId = type_id;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", num_reviews=" + numReviews +
                ", price=" + price +
                ", body=" + body +
                ", acidity=" + acidity +
                ", winery_id=" + wineryId +
                ", type_id=" + typeId +
                ", region_id=" + region_id +
                '}';
    }
}
