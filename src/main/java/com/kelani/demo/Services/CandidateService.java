package com.kelani.demo.Services;

import com.kelani.demo.DAO.CandidateModelDAO;
import com.kelani.demo.Models.CandidateModel;
import com.kelani.demo.Repository.CandidateRepository;
import com.kelani.demo.Repository.PartyRepository;
import com.kelani.demo.Repository.VoterRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CandidateService.class);


    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PartyRepository partyRepository;
    @Autowired
    private VoterRepository voterRepository;

    public List<CandidateModel> getAllCandidate() {
        return candidateRepository.findAll();
    }

    public CandidateModel saveCandidate(CandidateModelDAO dao) throws AGException {
        CandidateModel candidateModel = new CandidateModel();
        candidateModel.setName(dao.getName());
        candidateModel.setPno(dao.getPno());
        candidateModel.setNo(dao.getNo());

//        if voter id is available can be continue
        if (voterRepository.findFirstByVoterId(dao.getVoterId()) !=null){
            try {
                candidateModel.setPartyModel(partyRepository.findFirstById(dao.getPartyModelId()));
                candidateRepository.save(candidateModel);
            }catch (Exception e){
                LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
                throw new AGException(AGStatus.DB_ERROR);
            }
        }else {
            LOGGER.error(AGStatus.NO_VOTER_FOUND.getStatusDescription());
            throw new AGException(AGStatus.NO_VOTER_FOUND);
        }

        return candidateModel;
    }
}
