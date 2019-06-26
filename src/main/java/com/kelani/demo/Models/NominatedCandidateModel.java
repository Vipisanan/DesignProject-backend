package com.kelani.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "nominated_candidate")
public class NominatedCandidateModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nominated_party_id")
    private NominatedPartyModel nominatedPartyModel;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private CandidateModel candidateModel;

    public NominatedCandidateModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NominatedPartyModel getNominatedPartyModel() {
        return nominatedPartyModel;
    }

    public void setNominatedPartyModel(NominatedPartyModel nominatedPartyModel) {
        this.nominatedPartyModel = nominatedPartyModel;
    }

    public CandidateModel getCandidateModel() {
        return candidateModel;
    }

    public void setCandidateModel(CandidateModel candidateModel) {
        this.candidateModel = candidateModel;
    }
}
