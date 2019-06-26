package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "nominated_party")
public class NominatedPartyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "election_id")
    private ElectionModel electionModel;

    @ManyToOne
    @JoinColumn(name = "party_id")
    private PartyModel partyModel;

    public NominatedPartyModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectionModel getElectionModel() {
        return electionModel;
    }

    public void setElectionModel(ElectionModel electionModel) {
        this.electionModel = electionModel;
    }

    public PartyModel getPartyModel() {
        return partyModel;
    }

    public void setPartyModel(PartyModel partyModel) {
        this.partyModel = partyModel;
    }
}
