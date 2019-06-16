package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinTable(name = "gs_division_id")
    private GSDivisionModel gsDivisionModel;

    private String firstName;

    private String lastName;

    private String voterId;

    private String specificDetails;

    private String imageUrl;

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GSDivisionModel getGsDivisionModel() {
        return gsDivisionModel;
    }

    public void setGsDivisionModel(GSDivisionModel gsDivisionModel) {
        this.gsDivisionModel = gsDivisionModel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getSpecificDetails() {
        return specificDetails;
    }

    public void setSpecificDetails(String specificDetails) {
        this.specificDetails = specificDetails;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", gsDivisionModel=" + gsDivisionModel +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", voterId='" + voterId + '\'' +
                ", specificDetails='" + specificDetails + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
