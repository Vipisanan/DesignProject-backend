package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "voter")
public class VoterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String password;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    public VoterModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
