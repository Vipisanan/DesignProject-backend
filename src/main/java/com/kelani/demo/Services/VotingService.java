package com.kelani.demo.Services;

import com.kelani.demo.Models.NominatedCandidateModel;
import com.kelani.demo.Repository.NominatedCandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private NominatedCandidateRepository nominatedCandidateRepository;

    public List<NominatedCandidateModel> getVotingList() {
        List<NominatedCandidateModel> nominatedCandidateModel;
        nominatedCandidateModel=nominatedCandidateRepository.findAll();
        return nominatedCandidateModel;
    }
}
