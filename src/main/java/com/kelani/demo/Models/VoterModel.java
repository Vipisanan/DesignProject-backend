package com.kelani.demo.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "voter")
public class VoterModel {
    @Id
    @GenericGenerator(name = "sequence_voter_Id", strategy = "com.kelani.demo.Models.idGenerator.VoteIdGenerator")
    @GeneratedValue(generator = "sequence_voter_Id")
    @Column(name="voter_Id")
    private String voterId;

    private String password;

    @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    private boolean activeVoter;
//    isBlock


    public VoterModel() {
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
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
}
