package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "election_zone")
public class ElectionZoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinTable(name = "district_id")
    private DistrictModel districtModel;

    public ElectionZoneModel() {
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

    public DistrictModel getDistrictModel() {
        return districtModel;
    }

    public void setDistrictModel(DistrictModel districtModel) {
        this.districtModel = districtModel;
    }

    @Override
    public String toString() {
        return "ElectionZoneModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", districtModel=" + districtModel +
                '}';
    }
}
