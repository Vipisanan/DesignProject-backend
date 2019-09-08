package com.kelani.demo.DAO;

import com.kelani.demo.Models.UserModel;


public class VoterDAO {

    private String password;

    private UserModel userModel;

    private boolean activeVoter;

    public VoterDAO() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public boolean isActiveVoter() {
        return activeVoter;
    }

    public void setActiveVoter(boolean activeVoter) {
        this.activeVoter = activeVoter;
    }

    @Override
    public String toString() {
        return "VoterDAO{" +
                "password='" + password + '\'' +
                ", userModel=" + userModel +
                ", activeVoter=" + activeVoter +
                '}';
    }
}
