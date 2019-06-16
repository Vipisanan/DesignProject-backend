package com.kelani.demo.Models;


import javax.persistence.*;

@Entity
@Table(name = "election")
public class ElectionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinTable(name = "type_id  ")
    private ElectionTypeModel electionTypeModel;

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

    @Override
    public String toString() {
        return "ElectionModel{" +
                "id=" + id +
                ", electionTypeModel=" + electionTypeModel +
                '}';
    }
}
