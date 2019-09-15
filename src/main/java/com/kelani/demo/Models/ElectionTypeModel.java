package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "election_type")
public class ElectionTypeModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    public ElectionTypeModel() {
    }

    public ElectionTypeModel(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ElectionTypeModel{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
