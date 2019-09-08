package com.kelani.demo.Services;

import com.kelani.demo.Controllers.VoterController;
import com.kelani.demo.Models.VoterModel;
import com.kelani.demo.Repository.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class VoterService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(VoterController.class);

    @Autowired
    private VoterRepository voterRepository;


    public List<VoterModel> getAllVoter() {
        LOGGER.info("Called get all voter method in VoterService");
        return voterRepository.findAll();
    }
}
