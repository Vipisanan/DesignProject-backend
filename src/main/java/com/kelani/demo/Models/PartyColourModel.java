package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "party_colour")
public class PartyColourModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String colour;

    public PartyColourModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "PartyColourModel{" +
                "id=" + id +
                ", colour='" + colour + '\'' +
                '}';
    }
}
