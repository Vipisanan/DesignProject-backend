package com.kelani.demo.DAO;

public class ElectionZoneDAO {

    private String name;

    private String districtName;

    public ElectionZoneDAO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Override
    public String toString() {
        return "ElectionZoneDAO{" +
                "name='" + name + '\'' +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
