package com.kelani.demo.Models;



import javax.persistence.*;

@Entity
@Table(name = "province")
public class ProvinceModel {

    @Id
//    @Column(name="p_id",updatable=false, insertable = false ,nullable=false)
    @GeneratedValue(strategy =  GenerationType.IDENTITY , generator = "native")
    private int id;

    private String provinceName;

    public ProvinceModel() {
    }

    public ProvinceModel(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Override
    public String toString() {
        return "ProvinceModel{" +
                "id=" + id +
                ", provinceName='" + provinceName + '\'' +
                '}';
    }
}
