package com.kelani.demo.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "party")
public class PartyModel {

    @Id
    @GenericGenerator(name = "sequence_party_Id", strategy = "com.kelani.demo.Models.idGenerator.PartyIdGenerator")
    @GeneratedValue(generator = "sequence_party_Id")
    @Column(name="party_Id")
    private String id;

    private String name;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "colour_id")
    private PartyColourModel color;


    private String logoUrl;

    public PartyModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
