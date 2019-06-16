package com.kelani.demo.Services;

import com.kelani.demo.Models.GSDivisionModel;
import com.kelani.demo.Repository.GSDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GSDivisionService {

    @Autowired
    private GSDivisionRepository   gsDivisionRepository;


    public GSDivisionModel save(GSDivisionModel gsDivisionModels) {
        gsDivisionRepository.save(gsDivisionModels);
        return gsDivisionModels;
    }
}
