package com.kelani.demo.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_type")
public class UserTypeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String type;

    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<UserModel> userModel;

    public UserTypeModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserModel> getUserModel() {
        return userModel;
    }

    public void setUserModel(Set<UserModel> userModel) {
        this.userModel = userModel;
    }
}
