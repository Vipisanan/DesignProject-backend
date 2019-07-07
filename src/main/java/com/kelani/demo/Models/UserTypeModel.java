package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
public class UserTypeModel {

    @Id
    private int id;

    private String type;



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
