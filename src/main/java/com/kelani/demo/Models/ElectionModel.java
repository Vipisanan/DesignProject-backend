package com.kelani.demo.Models;


import javax.persistence.*;

@Entity
@Table(name = "election")
public class ElectionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "type_id")
    private ElectionTypeModel electionTypeModel;

    private boolean active;

    public ElectionModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectionTypeModel getElectionTypeModel() {
        return electionTypeModel;
    }

    public void setElectionTypeModel(ElectionTypeModel electionTypeModel) {
        this.electionTypeModel = electionTypeModel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
