package com.kelani.demo.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kelani.demo.DTO.DistrictDTO;
import com.kelani.demo.Models.DistrictModel;
import com.kelani.demo.Models.ProvinceModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.DistrictService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("district")
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
public class DistrictController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistrictController.class);
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private DistrictService districtService;

    @PostMapping("/")
    public ResponseEntity<?> saveDistrict(@RequestBody DistrictDTO dto) {
        ProvinceModel provinceModel = districtService.getProvinceModel(dto.getProvince_id());
        LOGGER.info("Call save district method in DistrictController");
        LOGGER.info(String.valueOf(provinceModel));
        DistrictModel districtModel = new DistrictModel();
//        BeanUtils.copyProperties(dto , districtModel);
        districtModel.setProvinceModel(provinceModel);
        districtModel.setName(dto.getName());
        districtModel.setProvinceModel(provinceModel);
        districtService.saveDirstrivt(districtModel);
        return new ResponseEntity<>(new ApiResponse<>(districtModel), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() throws Exception {
        LOGGER.info("Call in getAll method in districtController");
        List<DistrictModel> all;
        all = (List<DistrictModel>) districtService.getAll();
        return new ResponseEntity<>(new ApiResponse<>(all), HttpStatus.OK);
    }


}
