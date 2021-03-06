package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "GS_division")
public class GSDivisionModel {

    @Id
    private int id;

    private String name;

//Grama Niladhari  Details

    private String gsDivisionNo;

    private String pNo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinTable(name = "dis_id")
    private DistrictModel districtModel;

    public GSDivisionModel() {
    }

    public GSDivisionModel(int id, String name, String gsDivisionNo, String pNo, DistrictModel districtModel) {
        this.id = id;
        this.name = name;
        this.gsDivisionNo = gsDivisionNo;
        this.pNo = pNo;
        this.districtModel = districtModel;
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

    public String getGsDivisionNo() {
        return gsDivisionNo;
    }

    public void setGsDivisionNo(String gsDivisionNo) {
        this.gsDivisionNo = gsDivisionNo;
    }

    public String getpNo() {
        return pNo;
    }

    public void setpNo(String pNo) {
        this.pNo = pNo;
    }

    public DistrictModel getDistrictModel() {
        return districtModel;
    }

    public void setDistrictModel(DistrictModel districtModel) {
        this.districtModel = districtModel;
    }
}
