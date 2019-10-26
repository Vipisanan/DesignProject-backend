package com.kelani.demo.Models;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "gs_division_id")
    private GSDivisionModel gsDivisionModel;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserTypeModel> userTypeModels = new HashSet<UserTypeModel>();

    private String firstName;


    @Column(unique = true, nullable = false)
    private long nicNo;


    private String lastName;

    private String specificDetails;

    private String imageUrl;

    private boolean isVoter;


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

    public long getNicNo() {
        return nicNo;
    }

    public void setNicNo(long nicNo) {
        this.nicNo = nicNo;
    }

    public boolean isVoter() {
        return isVoter;
    }

    public void setVoter(boolean voter) {
        isVoter = voter;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", gsDivisionModel=" + gsDivisionModel +
                ", userTypeModels=" + userTypeModels +
                ", firstName='" + firstName + '\'' +
                ", nicNo=" + nicNo +
                ", lastName='" + lastName + '\'' +
                ", specificDetails='" + specificDetails + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public boolean validEmpty() {
        return !this.firstName.equals("")
                && !this.lastName.equals("")
                && !this.gsDivisionModel.equals("")
                && !this.userTypeModels.equals("")
                && !this.specificDetails.equals("");

    }

}
