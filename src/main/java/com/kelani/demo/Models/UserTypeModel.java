package com.kelani.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserTypeModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

//    @ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private Set<UserModel> userModel;


    public UserTypeModel() {
    }

    public UserTypeModel(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public UserTypeModel(String type) {
        this.type = type;
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
}
