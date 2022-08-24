package com.group3.wineshop.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "region")
public class Region {

    //@GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    @Id
    private int id;
    @NotEmpty
    @NotNull
    private String name;
    @NotNull
    private String country;

    public Region(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Region() {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
