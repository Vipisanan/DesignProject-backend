package com.kelani.demo.Services;

import com.kelani.demo.DAO.AllResultDAO;
import com.kelani.demo.DAO.ResultDAO;
import com.kelani.demo.Models.ElectionResultModel;
import com.kelani.demo.Models.NominatedCandidateModel;
import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.ElectionResultRepository;
import com.kelani.demo.Repository.NominatedCandidateRepository;
import com.kelani.demo.Repository.NominatedPartyRepository;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.codehaus.jackson.map.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ResultService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResultService.class);

    @Autowired
    private ElectionResultRepository electionResultRepository;

    @Autowired
    private NominatedPartyRepository nominatedPartyRepository;

    @Autowired
    private VoterRepository voterRepository;
    @Autowired
    private NominatedCandidateRepository nominatedCandidateRepository;


    public List<AllResultDAO> getAllResult() {
        List<ElectionResultModel> electionResultModels = electionResultRepository.findAll();
        List<AllResultDAO> allResultDAO  = new ArrayList<AllResultDAO>();
        AllResultDAO allResultDAO1 = new AllResultDAO();
        Set<String> partyId = new HashSet<String>();
        Set<Integer> candidateId = new HashSet<Integer>();
//        for (int i = 0; i < electionResultModels.size(); i++) {
//            allResultDAO1.setVoterId(electionResultModels.get(i).getVoterModel().getVoterId());
//            for (int j = 0; j < electionResultModels.get(i).getNominatedCandidateModels().size(); j++) {
//                List<NominatedCandidateModel> nominatedCandidateModels = new ArrayList<NominatedCandidateModel>();
//                nominatedCandidateModels.addAll(electionResultModels.get(i).getNominatedCandidateModels());
//
//                candidateId.add(nominatedCandidateModels.get(j).getCandidateModel().getId());
//                partyId.add(nominatedCandidateModels.get(j).getNominatedPartyModel().getId());
//            }
//            allResultDAO1.setCandidateId(candidateId);
//            allResultDAO1.setPartyId(partyId);
//            allResultDAO.add(i, allResultDAO1);
//            allResultDAO.set(i ,allResultDAO1);
//            BeanUtils.copyProperties(allResultDAO , electionResultModels);
//        }
        BeanUtils.copyProperties(electionResultModels,allResultDAO);

        return allResultDAO;
    }

    public ElectionResultModel addVote(int[] cId, String[] partyId, String voterId) throws AGException {

        ElectionResultModel electionResultModel = new ElectionResultModel();
        Set<NominatedCandidateModel> nominatedCandidateModels = electionResultModel.getNominatedCandidateModels();
        VoterModel voterModel;
        try {
            voterModel = voterRepository.findFirstByVoterId(voterId);
            for (int i = 0; i < cId.length; i++) {
                LOGGER.info(String.valueOf(cId[i + 1]));
                LOGGER.info(cId.length + "/t length");
                nominatedCandidateModels.add(nominatedCandidateRepository.findFirstById(cId[i]));
                LOGGER.info(nominatedCandidateModels + "/t nominatedCandidateModels");
            }

            electionResultModel.setVoterModel(voterModel);
            electionResultModel.setNominatedCandidateModels(nominatedCandidateModels);

            electionResultRepository.save(electionResultModel);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return electionResultModel;
    }

    public ResultDAO partyCount() throws AGException {
        List<ElectionResultModel> electionResultModel = electionResultRepository.findAll();
        try {
            for (int i = 0; i < electionResultModel.size(); i++) {
            }
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return null;
    }

    public List<ElectionResultModel> getFullResult() {
        return electionResultRepository.findAll();
    }


}
