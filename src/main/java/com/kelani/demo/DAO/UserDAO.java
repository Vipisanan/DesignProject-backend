package com.kelani.demo.DAO;

public class UserDAO {


    private String firstName;

    private String lastName;

    private int nicNo;

    private String imageUrl;

    private String gsDivisionName;

    private int userType;

    public UserDAO() {
    }



    public UserDAO(String firstName, String lastName, String imageUrl, int nicNo, String name) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nicNo = nicNo;
        this.imageUrl = imageUrl;
        this.gsDivisionName = name;
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

    public int getNicNo() {
        return nicNo;
    }

    public void setNicNo(int nicNo) {
        this.nicNo = nicNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getGsDivisionName() {
        return gsDivisionName;
    }

    public void setGsDivisionName(String gsDivisionName) {
        this.gsDivisionName = gsDivisionName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "UserDAO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nicNo=" + nicNo +
                ", imageUrl='" + imageUrl + '\'' +
                ", gsDivision='" + gsDivisionName + '\'' +
                ", userType=" + userType +
                '}';
    }
}
