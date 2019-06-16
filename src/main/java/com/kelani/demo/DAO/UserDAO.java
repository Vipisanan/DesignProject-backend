package com.kelani.demo.DAO;

public class UserDAO {

    private String gsDivision;

    private String firstName;

    private String lastName;

    private String voterId;

    private String specificDetails;

    private String imageUrl;

    public UserDAO() {
    }

    public String getGsDivision() {
        return gsDivision;
    }

    public void setGsDivision(String gsDivision) {
        this.gsDivision = gsDivision;
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
        return "UserDAO{" +
                "gsDivision='" + gsDivision + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", voterId='" + voterId + '\'' +
                ", specificDetails='" + specificDetails + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
