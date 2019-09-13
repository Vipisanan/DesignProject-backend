package com.kelani.demo.DAO;

public class UserDAO {

    private int id;

    private String firstName;

    private String lastName;

    private long nicNo;

    private String imageUrl;

    private String gsDivisionName;

    private int userType;

    public UserDAO() {
    }



    public UserDAO(int id ,String firstName, String lastName, String imageUrl, long nicNo, String name) {
        this.id = id;
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

    public long getNicNo() {
        return nicNo;
    }

    public void setNicNo(long nicNo) {
        this.nicNo = nicNo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nicNo=" + nicNo +
                ", imageUrl='" + imageUrl + '\'' +
                ", gsDivisionName='" + gsDivisionName + '\'' +
                ", userType=" + userType +
                '}';
    }
}
