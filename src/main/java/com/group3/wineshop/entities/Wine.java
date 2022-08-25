package com.group3.wineshop.entities;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name="wine")
public class Wine {
    @Id
    private int id;
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    @Min(1900)
    @Max(2023)
    private String year;
    @NotNull
    @Min(0)
    @Max(5)
    private double rating;

    @NotNull
    @Min(0)
    private int numReviews;

    @NotNull
    @Min(0)
    private double price;

    @NotNull
    @Min(0)
    @Max(5)
    private String body;

    @NotNull
    @Min(0)
    @Max(5)
    private String acidity;
    @NotNull
    private int wineryId;
    @NotNull
    private int typeId;
    @NotNull
    private int regionId;

    public Wine() {

    }

    public Wine(int id, String name, String year, double rating, int numReviews, double price, String body, String acidity, int wineryId, int typeId, int regionId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.numReviews = numReviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.wineryId = wineryId;
        this.typeId = typeId;
        this.regionId = regionId;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumReviews() {
        return numReviews;
    }

    public void setNumReviews(int numReviews) {
        this.numReviews = numReviews;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAcidity() {
        return acidity;
    }

    public void setAcidity(String acidity) {
        this.acidity = acidity;
    }

    public int getWineryId() {
        return wineryId;
    }

    public void setWineryId(int wineryId) {
        this.wineryId = wineryId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}