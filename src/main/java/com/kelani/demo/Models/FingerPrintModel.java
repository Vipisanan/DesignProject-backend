package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "finger_print")
public class FingerPrintModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private UserModel userModel;


    @Column(unique = true)
    private String fingerprint;

    public FingerPrintModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
