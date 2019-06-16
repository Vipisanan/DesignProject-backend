package com.kelani.demo.Services;

import com.kelani.demo.Models.DistrictModel;
import com.kelani.demo.Repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public DistrictModel addDistrict(DistrictModel districtModel) {
        districtRepository.save(districtModel);
        return districtModel;
    }
}
