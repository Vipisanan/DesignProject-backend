package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "candidate_vote")
public class CandidateVoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "party_vote")
    private PartyVoteModel partyVoteModel;

    public CandidateVoteModel() {
    }


}
