package com.example.springRest.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Region")
@Table(name = "region",schema = "public")
public class Region {
    @Id
    @Column(name = "id",nullable = false, unique = true)
    Integer id;


    @Column(name = "name")
    String name;



    @OneToMany
    @JoinColumn(name = "regionId", referencedColumnName = "id", insertable = false, updatable = false)
    List<City> cities=new ArrayList<>();

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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Region(){

    }
    public Region(String name){
        this.name=name;
    }

    public Region(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
