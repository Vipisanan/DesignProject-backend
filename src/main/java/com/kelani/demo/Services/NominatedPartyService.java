package com.kelani.demo.Services;

import com.kelani.demo.Models.NominatedPartyModel;
import com.kelani.demo.Repository.NominatedPartyRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NominatedPartyService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(NominatedPartyService.class);

    @Autowired
    private NominatedPartyRepository nominatedPartyRepository;

    public List<NominatedPartyModel> getAllNominatedPArtyList() throws AGException {
        List<NominatedPartyModel> model;
        try {
           model= nominatedPartyRepository.findAll();
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return model;
    }
}
