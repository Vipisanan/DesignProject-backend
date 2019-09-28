package com.kelani.demo.Services;

import com.kelani.demo.Models.ElectionModel;
import com.kelani.demo.Models.ElectionTypeModel;
import com.kelani.demo.Repository.ElectionRepository;
import com.kelani.demo.Repository.ElectionTypeRepository;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ElectionService.class);


    @Autowired
    private ElectionRepository electionRepository;
    @Autowired
    private ElectionTypeRepository electionTypeRepository;

    public ElectionModel addElection(int id) throws AGException {
        ElectionTypeModel electionTypeModel;
        ElectionModel electionModel = new ElectionModel();
        try {
            electionTypeModel=electionTypeRepository.findFirstById(id);
            electionModel.setElectionTypeModel(electionTypeModel);
            electionRepository.save(electionModel);
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return electionModel;
    }

    public List<ElectionTypeModel> getAllElectionTypes() throws AGException {
        List<ElectionTypeModel> modelList;
        try {
            modelList=electionTypeRepository.findAll();
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return modelList;
    }

    public List<ElectionModel> getAllElection() {
        return electionRepository.findAll();
    }

    public ElectionModel daleteElection(int id) {
        return electionRepository.deleteById(id);
    }

    public ElectionModel activeElection(int id) throws AGException {
        ElectionModel electionModel =new ElectionModel();

        try {
            electionModel=electionRepository.findFirstById(id);
            electionModel.setActive(true);
            electionRepository.save(electionModel);
        }catch (Exception e){
            LOGGER.error(AGStatus.DB_ERROR.getStatusDescription());
            throw new AGException(AGStatus.DB_ERROR);
        }
        return electionModel;
    }
}
