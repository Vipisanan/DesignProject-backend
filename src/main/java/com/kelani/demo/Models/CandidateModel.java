package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "candidate")
public class CandidateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinTable(name = "party_id")
    private PartyModel partyModel;

    private String name;

    private String no;

    private String pno;

    private boolean active;

    public CandidateModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PartyModel getPartyModel() {
        return partyModel;
    }

    public void setPartyModel(PartyModel partyModel) {
        this.partyModel = partyModel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "CandidateModel{" +
                "id=" + id +
                ", partyModel=" + partyModel +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", pno='" + pno + '\'' +
                ", active=" + active +
                '}';
    }
}
