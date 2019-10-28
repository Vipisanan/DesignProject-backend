package com.kelani.demo.DAO;

public class ResultDAO {


    private String partyName;
    private String partyId;

    private int noOfVoteForParty;

    public ResultDAO() {
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public int getNoOfVoteForParty() {
        return noOfVoteForParty;
    }

    public void setNoOfVoteForParty(int noOfVoteForParty) {
        this.noOfVoteForParty = noOfVoteForParty;
    }
}
