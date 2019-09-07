package com.kelani.demo.DAO;

public class UserAllDetailsDAO {

    private String firstName;

    private String lastName;

    private int nicNo;

    private String specificDetails;

    private String imageUrl;

    private int gsDivisionId;

    private int userType;

    public UserAllDetailsDAO() {
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getGsDivisionId() {
        return gsDivisionId;
    }

    public void setGsDivisionId(int gsDivisionId) {
        this.gsDivisionId = gsDivisionId;
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

    public int getNicNo() {
        return nicNo;
    }

    public void setNicNo(int nicNo) {
        this.nicNo = nicNo;
    }

    @Override
    public String toString() {
        return "UserAllDetailsDAO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nicNo=" + nicNo +
                ", specificDetails='" + specificDetails + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", gsDivisionId=" + gsDivisionId +
                ", userType=" + userType +
                '}';
    }
}
