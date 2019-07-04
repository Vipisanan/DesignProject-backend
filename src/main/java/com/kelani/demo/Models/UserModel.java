package com.kelani.demo.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinTable(name = "gs_division_id")
    private GSDivisionModel gsDivisionModel;

    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Set<UserTypeModel> userTypeModels;

    private String firstName;

    private int nicNo;

    private String lastName;

    private String voterId;

    private String specificDetails;

    private String imageUrl;



    public UserModel() {
    }

    public Set<UserTypeModel> getUserTypeModels() {
        return userTypeModels;
    }

    public void setUserTypeModels(Set<UserTypeModel> userTypeModels) {
        this.userTypeModels = userTypeModels;
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

    public int getNicNo() {
        return nicNo;
    }

    public void setNicNo(int nicNo) {
        this.nicNo = nicNo;
    }


}
