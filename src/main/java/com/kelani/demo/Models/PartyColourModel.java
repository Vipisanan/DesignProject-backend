package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "party_colour")
public class PartyColourModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String colour;



}
