package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "GS_division")
public class GSDivisionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinTable(name = "election_zone_id")
    private ElectionZoneModel electionZoneModel;

    public GSDivisionModel() {
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

    public ElectionZoneModel getElectionZoneModel() {
        return electionZoneModel;
    }

    public void setElectionZoneModel(ElectionZoneModel electionZoneModel) {
        this.electionZoneModel = electionZoneModel;
    }

    @Override
    public String toString() {
        return "GSDivisionModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", electionZoneModel=" + electionZoneModel +
                '}';
    }
}
