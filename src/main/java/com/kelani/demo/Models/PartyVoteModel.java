package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "party_vote")
public class PartyVoteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "election_center_id")
    private ElectionCenterModel electionCenterModel;


}
