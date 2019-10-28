package com.kelani.demo.DAO;

import java.util.Set;

public class AllResultDAO {
    private int id;
    private String voterId;
    private Set<Integer> candidateId;
    private Set<String> partyId;

    public AllResultDAO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Set<Integer> getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Set<Integer> candidateId) {
        this.candidateId = candidateId;
    }

    public Set<String> getPartyId() {
        return partyId;
    }

    public void setPartyId(Set<String> partyId) {
        this.partyId = partyId;
    }
}
