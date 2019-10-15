package com.kelani.demo.Services;

import com.kelani.demo.Controllers.PartyController;
import com.kelani.demo.DAO.PartyDAO;
import com.kelani.demo.Models.ElectionModel;
import com.kelani.demo.Models.NominatedPartyModel;
import com.kelani.demo.Models.PartyColourModel;
import com.kelani.demo.Models.PartyModel;
import com.kelani.demo.Repository.ElectionRepository;
import com.kelani.demo.Repository.NominatedPartyRepository;
import com.kelani.demo.Repository.PartyColourRepository;
import com.kelani.demo.Repository.PartyRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.DirectColorModel;
import java.awt.image.PackedColorModel;
import java.util.List;

@Service
public class PartyService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PartyService.class);

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private PartyColourRepository partyColourRepository;
    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private NominatedPartyRepository nominatedPartyRepository;


    public List<PartyModel> getAllParties() throws AGException {
        try {
            partyRepository.findAll();
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return partyRepository.findAll();
    }

    public PartyModel saveParty(PartyDAO partyDAO) throws AGException {
        PartyColourModel partyColourModel;
        PartyModel model = new PartyModel();

        try {
            partyColourModel = partyColourRepository.findFirstById(partyDAO.getPartyColourId());
            model.setColor(partyColourModel);
            model.setLogoUrl(partyDAO.getLogoUrl());
            model.setName(partyDAO.getName());

            partyRepository.save(model);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }

        return model;
    }

    public PartyModel savePartyWidImage(PartyModel partyModel) throws AGException {
        try {
            partyRepository.save(partyModel);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return partyModel;
    }

    public List<PartyColourModel> getPartyColor() throws AGException {
        try {
            partyColourRepository.findAll();
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return partyColourRepository.findAll();
    }

    public NominatedPartyModel partyNomination(int i, String s) throws AGException {
//        get election model and Party model then save
        NominatedPartyModel nominatedPartyModel = new NominatedPartyModel();

        LOGGER.info("election id     " + i + "party id" + s);

        try {
            ElectionModel electionModel = electionRepository.findFirstById(i);
            PartyModel partyModel = partyRepository.findFirstById(s);
            LOGGER.info("electionModel" + electionModel);
            LOGGER.info("partyModel" + partyModel);
            nominatedPartyModel.setElectionModel(electionModel);
            nominatedPartyModel.setPartyModel(partyModel);
            nominatedPartyRepository.save(nominatedPartyModel);
        } catch (Exception e) {
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return nominatedPartyModel;
    }
}
