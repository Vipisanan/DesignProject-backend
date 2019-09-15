package com.kelani.demo.Models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "nominated_party")
public class NominatedPartyModel {

    @Id
    @GenericGenerator(name = "sequence_n_party_Id", strategy = "com.kelani.demo.Models.idGenerator.NominatedPartyIDGenerator")
    @GeneratedValue(generator = "sequence_n_party_Id")
    @Column(name = "nominated_party_id")
    private String id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "election_id")
    private ElectionModel electionModel;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "party_id")
    private PartyModel partyModel;

    private boolean isActive;

    public NominatedPartyModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
