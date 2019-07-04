package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "election_center_staff")
public class ElectionCenterStaffModel {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "election_center_id")
    private ElectionCenterModel  electionCenterModel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserModel  userModel;

    public ElectionCenterStaffModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectionCenterModel getElectionCenterModel() {
        return electionCenterModel;
    }

    public void setElectionCenterModel(ElectionCenterModel electionCenterModel) {
        this.electionCenterModel = electionCenterModel;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
