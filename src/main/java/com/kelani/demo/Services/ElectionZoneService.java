package com.kelani.demo.Services;

import com.kelani.demo.Models.ElectionZoneModel;
import com.kelani.demo.Repository.ElectionZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectionZoneService {

    @Autowired
    private ElectionZoneRepository electionZoneRepository;

    public ElectionZoneModel addZone(ElectionZoneModel electionZoneModel) {
        electionZoneRepository.save(electionZoneModel);
        return electionZoneModel;
    }
}
