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
    @Max(2022)
    private String year;
    @NotNull
    private int wineryId;
    @NotNull
    private int typeId;
    @NotNull
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


