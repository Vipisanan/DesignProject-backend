package com.kelani.demo.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "voter")
public class VoterModel {
    @Id
    @GenericGenerator(name = "sequence_voter_Id", strategy = "com.kelani.demo.Models.idGenerator.VoteIdGenerator")
    @GeneratedValue(generator = "sequence_voter_Id")
    @Column(name = "voter_Id")
    private String voterId;

    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id")
    private UserModel userModel;

    private boolean activeVoter;
//    isBlock

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "roles",
            joinColumns = @JoinColumn(name = "voter_id")
            , inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<RoleModel> roleModelset =new HashSet<RoleModel>();



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

    public Set<RoleModel> getRoleModelset() {
        return roleModelset;
    }

    public void setRoleModelset(Set<RoleModel> roleModelset) {
        this.roleModelset = roleModelset;
    }
}
