package com.kelani.demo.Models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "election_result")
public class ElectionResultModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "election_result_id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "voter_id")
    private VoterModel voterModel;

    @OneToMany(mappedBy = "electionResultModel", cascade = CascadeType.ALL)
    private Set<NominatedPartyModel> nominatedPartyModels;

    @OneToMany(mappedBy = "electionResultModel", cascade = CascadeType.ALL)
    private Set<NominatedCandidateModel> nominatedCandidateModels  = new HashSet<>();

    public ElectionResultModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VoterModel getVoterModel() {
        return voterModel;
    }

    public void setVoterModel(VoterModel voterModel) {
        this.voterModel = voterModel;
    }

    public Set<NominatedPartyModel> getNominatedPartyModels() {
        return nominatedPartyModels;
    }

    public void setNominatedPartyModels(Set<NominatedPartyModel> nominatedPartyModels) {
        this.nominatedPartyModels = nominatedPartyModels;
    }

    public Set<NominatedCandidateModel> getNominatedCandidateModels() {
        return nominatedCandidateModels;
    }

    public void setNominatedCandidateModels(Set<NominatedCandidateModel> nominatedCandidateModels) {
        this.nominatedCandidateModels = nominatedCandidateModels;
    }
}

