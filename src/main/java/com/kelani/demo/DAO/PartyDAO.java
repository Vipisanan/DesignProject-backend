package com.kelani.demo.DAO;

public class PartyDAO {

    private int id;

    private String name;

    private int partyColourId;

    private String logoUrl;

    public PartyDAO() {
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

    public int getPartyColourId() {
        return partyColourId;
    }

    public void setPartyColourId(int partyColourId) {
        this.partyColourId = partyColourId;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "PartyDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partyColourId=" + partyColourId +
                ", logoUrl='" + logoUrl + '\'' +
                '}';
    }
}
