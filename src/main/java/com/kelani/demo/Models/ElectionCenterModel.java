package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "election_center")
public class ElectionCenterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinTable(name = "election_district_id")
    private ElectionalDistrictModel electionalDistrictModel;

    public ElectionCenterModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectionalDistrictModel getElectionalDistrictModel() {
        return electionalDistrictModel;
    }

    public void setElectionalDistrictModel(ElectionalDistrictModel electionalDistrictModel) {
        this.electionalDistrictModel = electionalDistrictModel;
    }

    @Override
    public String toString() {
        return "ElectionCenterModel{" +
                "id=" + id +
                ", electionalDistrictModel=" + electionalDistrictModel +
                '}';
    }
}
