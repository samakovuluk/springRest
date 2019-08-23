package com.example.springRest.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity(name = "City")
@Table(name = "city",schema = "public")
public class City {
    @Id
    @Column(name = "id",nullable = false, unique = true)
    Integer id;
    @Column(name = "name")
    String name;

    @JsonIgnore
    @Column(name = "regionId")
    Integer regionId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "regionId", insertable = false, updatable = false)
    Region region;


    @JsonIgnore
    public Integer getRegionId() {
        return regionId;
    }
    @JsonProperty
    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public City(){

    }
    public City(Integer id, String name, Integer regionId) {
        this.id = id;
        this.name = name;
        this.regionId=regionId;

    }
}
