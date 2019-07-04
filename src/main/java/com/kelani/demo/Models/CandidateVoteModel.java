package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "candidate_vote")
public class CandidateVoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "party_vote")
    private PartyVoteModel partyVoteModel;

    public CandidateVoteModel() {
    }


}
