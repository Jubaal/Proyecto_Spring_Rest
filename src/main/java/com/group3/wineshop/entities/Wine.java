package com.group3.wineshop.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="wine")
public class Wine {
    @Id
    private int id;
    private String name;
    private String year;
    private int wineryId;
    private int typeId;
    private int regionId;

    public Wine() {

    }

    public Wine(int id, String name, String year, int wineryId, int typeId, int regionId) {
        this.id = id;
        this.name = name;
        this.year = year;
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


