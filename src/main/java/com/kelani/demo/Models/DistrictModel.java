package com.kelani.demo.Models;


import javax.persistence.*;

@Entity
@Table(name = "district")
public class DistrictModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinTable(name = "pro_id")
    private ProvinceModel provinceModel;

    public DistrictModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProvinceModel getProvinceModel() {
        return provinceModel;
    }

    public void setProvinceModel(ProvinceModel provinceModel) {
        this.provinceModel = provinceModel;
    }

    @Override
    public String toString() {
        return "DistrictModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", provinceModel=" + provinceModel +
                '}';
    }
}
