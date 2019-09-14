package com.kelani.demo.DAO;

public class CandidateModelDAO {


    private String  partyModelId;

    private String name;

    private String no;

    private String pno;

    private boolean active;

    public CandidateModelDAO() {
    }

    public String getPartyModelId() {
        return partyModelId;
    }

    public void setPartyModelId(String partyModelId) {
        this.partyModelId = partyModelId;
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

}
