package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "party_vote")
public class PartyVoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "election_center_id")
    private ElectionCenterModel electionCenterModel;

    public PartyVoteModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElectionCenterModel getElectionCenterModel() {
        return electionCenterModel;
    }

    public void setElectionCenterModel(ElectionCenterModel electionCenterModel) {
        this.electionCenterModel = electionCenterModel;
    }

    @Override
    public String toString() {
        return "PartyVoteModel{" +
                "id=" + id +
                ", electionCenterModel=" + electionCenterModel +
                '}';
    }
}
