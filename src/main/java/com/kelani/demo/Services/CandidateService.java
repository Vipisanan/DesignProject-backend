package com.kelani.demo.Services;

import com.kelani.demo.DAO.CandidateModelDAO;
import com.kelani.demo.Models.CandidateModel;
import com.kelani.demo.Models.NominatedCandidateModel;
import com.kelani.demo.Models.NominatedPartyModel;
import com.kelani.demo.Models.PartyModel;
import com.kelani.demo.Repository.*;
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
    @Autowired
    private NominatedCandidateRepository nominatedCandidateRepository;
    @Autowired
    private NominatedPartyRepository nominatedPartyRepository;

    public List<CandidateModel> getAllCandidate() {
        return candidateRepository.findAll();
    }

    public CandidateModel saveCandidate(CandidateModelDAO dao) throws AGException {
        CandidateModel candidateModel = new CandidateModel();
        candidateModel.setName(dao.getName());
        candidateModel.setPno(dao.getPno());
        candidateModel.setNo(dao.getNo());

//        if voter id is available can be continue
//        but one time allow
//        TO DO save voter id as a uniq value
        if (voterRepository.findFirstByVoterId(dao.getVoterId()) !=null){
            candidateModel.setVoterId(dao.getVoterId());
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

//using nominatedPartyId ="N-PARTY-101"(String) and candidateID =1(int)
    public NominatedCandidateModel candidateNomination(int i ,String s) throws AGException {
        NominatedPartyModel nominatedPartyModel=new NominatedPartyModel();
        NominatedCandidateModel nominatedCandidateModel=new NominatedCandidateModel();
        if (candidateRepository.findFirstById(i) != null && nominatedPartyRepository.findFirstById(s) !=null){
            try {
                nominatedPartyModel =nominatedPartyRepository.findFirstById(s);
                nominatedCandidateModel.setCandidateModel(candidateRepository.findFirstById(i));
                nominatedCandidateModel.setNominatedPartyModel(nominatedPartyModel);
                nominatedCandidateRepository.save(nominatedCandidateModel);
            }catch (Exception e){
                LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
                throw new AGException(AGStatus.DB_ERROR);
            }
        }else {
            LOGGER.error(AGStatus.NO_CANDIDATE_FOUND.getStatusDescription());
            throw new AGException(AGStatus.NO_CANDIDATE_FOUND);
        }
        return nominatedCandidateModel;
    }

    public NominatedCandidateModel candidateNominationByPartyId(int i, String s) throws AGException {
//        1.get party id
//        2.confirm is this party was nominated?
//        3.if it's nominated get the id and do

        PartyModel partyModel =partyRepository.findFirstById(s);
        NominatedPartyModel model=nominatedPartyRepository.findFirstByPartyModel(partyModel);

        NominatedPartyModel nominatedPartyModel=new NominatedPartyModel();
        NominatedCandidateModel nominatedCandidateModel=new NominatedCandidateModel();

        if (partyModel.getId() == model.getPartyModel().getId()){
            if (candidateRepository.findFirstById(i)!=null){
                try {
                    nominatedPartyModel =nominatedPartyRepository.findFirstById(model.getId());
                    nominatedCandidateModel.setCandidateModel(candidateRepository.findFirstById(i));
                    nominatedCandidateModel.setNominatedPartyModel(nominatedPartyModel);
                    nominatedCandidateRepository.save(nominatedCandidateModel);
                }catch (Exception e){
                    LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
                    throw new AGException(AGStatus.DB_ERROR);
                }
            }else {
                LOGGER.error(AGStatus.NO_CANDIDATE_FOUND.getStatusDescription());
                throw new AGException(AGStatus.NO_CANDIDATE_FOUND);
            }
        }else {
            throw new AGException(AGStatus.PARTY_NOT_NOMINATED);
        }
        return null;
    }

    public List<NominatedCandidateModel> getAllNominatedCandidate() throws AGException {
        List<NominatedCandidateModel> nominatedCandidateModels;
        try {
            nominatedCandidateModels=nominatedCandidateRepository.findAll();
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return nominatedCandidateModels;
    }

    public List<NominatedCandidateModel> generateCandidateNo() throws AGException {
        List<NominatedCandidateModel> nominatedCandidateModels;

        try {
            nominatedCandidateModels = nominatedCandidateRepository.findAll();
//        to do for set candidate no here
            for(int i=0 ; i<nominatedCandidateModels.size() ; i++){
                NominatedCandidateModel nominatedCandidateModel;
                nominatedCandidateModel = nominatedCandidateRepository.findFirstById(nominatedCandidateModels.get(i).getId());
                if (nominatedCandidateModel.getCandidateModel().getNo() == null){
                    CandidateModel candidateModel=candidateRepository.findFirstById(nominatedCandidateModel.getCandidateModel().getId());
                    candidateModel.setNo(Integer.toString(i+1));
                    nominatedCandidateModel.setCandidateModel(candidateModel);
                }
                nominatedCandidateRepository.save(nominatedCandidateModel);
            }
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return nominatedCandidateModels;

    }
}
