package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "party")
public class PartyModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @OneToOne
    @JoinColumn(name = "colour_id")
    private PartyColourModel color;

    private String logoUrl;

    public PartyModel() {
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

    public PartyColourModel getColor() {
        return color;
    }

    public void setColor(PartyColourModel color) {
        this.color = color;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }


}
