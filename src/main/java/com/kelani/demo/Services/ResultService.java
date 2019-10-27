package com.kelani.demo.Services;

import com.kelani.demo.Models.ElectionResultModel;
import com.kelani.demo.Models.NominatedCandidateModel;
import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.ElectionResultRepository;
import com.kelani.demo.Repository.NominatedCandidateRepository;
import com.kelani.demo.Repository.NominatedPartyRepository;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ResultService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ResultService.class);

    @Autowired
    private ElectionResultRepository electionResultRepository;

    @Autowired
    private NominatedPartyRepository nominatedPartyRepository;

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private NominatedCandidateRepository nominatedCandidateRepository;


    public List<ElectionResultModel> getAllResult() {
        return electionResultRepository.findAll();
    }

    public ElectionResultModel addVote(int[] cId, String[] partyId, String voterId) throws AGException {

        ElectionResultModel electionResultModel = new ElectionResultModel();
        Set<NominatedCandidateModel> nominatedCandidateModels = electionResultModel.getNominatedCandidateModels();
        VoterModel voterModel;
        try {
            voterModel = voterRepository.findFirstByVoterId(voterId);
            for (int i = 0; i < cId.length; i++) {
                LOGGER.info(String.valueOf(cId[i]));
                nominatedCandidateModels.add(nominatedCandidateRepository.findFirstById(cId[i]));
            }

//            nominatedCandidateModels.add(nominatedCandidateRepository.findFirstById(1));
            electionResultModel.setVoterModel(voterModel);
            electionResultModel.setNominatedCandidateModels(nominatedCandidateModels);

            electionResultRepository.save(electionResultModel);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return electionResultModel;
    }

//    public ResultByPartyDAO partyCount() throws AGException {
//        List<ElectionResultModel> electionResultModel = electionResultRepository.findAll();
//        try {
//
//        }catch (Exception e){
//            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
//            throw new AGException(AGStatus.DB_ERROR);
//        }
//        return null;
//    }
}
