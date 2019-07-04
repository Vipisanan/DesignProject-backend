package com.kelani.demo.Services;

import com.kelani.demo.Models.ProvinceModel;
import com.kelani.demo.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    public List<ProvinceModel> saveAll(List<ProvinceModel> provinceModelList) {
        provinceRepository.saveAll(provinceModelList);
        return provinceModelList;
    }

    public List<ProvinceModel> geAll() {
        return provinceRepository.findAll();
    }
}
