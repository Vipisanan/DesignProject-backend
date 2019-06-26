package com.kelani.demo.Services;

import com.kelani.demo.Models.DistrictModel;
import com.kelani.demo.Models.ProvinceModel;
import com.kelani.demo.Repository.DistrictRepository;
import com.kelani.demo.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    public DistrictModel addDistrict(DistrictModel districtModel) {
        districtRepository.save(districtModel);
        return districtModel;
    }

    public ProvinceModel getProvinceModel(int id) {
        return provinceRepository.getFirstById(id);
    }


    public DistrictModel saveDirstrivt(DistrictModel districtModel) {
        districtRepository.save(districtModel);
        return districtModel;
    }

    public List<DistrictModel> getAll() {
        return districtRepository.findAll();
    }
}
