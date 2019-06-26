package com.kelani.demo.Controllers;

import com.kelani.demo.DAO.ElectionZoneDAO;
import com.kelani.demo.Models.DistrictModel;
import com.kelani.demo.Models.ElectionZoneModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Repository.DistrictRepository;
import com.kelani.demo.Services.DistrictService;
import com.kelani.demo.Services.ElectionZoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("election-zone")
public class ElectionZoneController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElectionZoneController.class);


    @Autowired
    private ElectionZoneService electionZoneService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private DistrictRepository districtRepository;

    @PostMapping("/")
    public ResponseEntity<?> addZone(@RequestBody ElectionZoneDAO electionZoneDAO){

        if (districtRepository.findFirstByName(electionZoneDAO.getDistrictName()) == null){
//            if it is null save district name
//            if not get and save both details
            DistrictModel districtModel=new DistrictModel();
            districtModel.setName(electionZoneDAO.getDistrictName());
            DistrictModel model = districtService.addDistrict(districtModel);
            LOGGER.info("new district added as a    " + electionZoneDAO.getDistrictName());
            ElectionZoneModel  electionZoneModel = new ElectionZoneModel();
            electionZoneModel.setName(electionZoneDAO.getName());
            electionZoneModel.setDistrictModel(model);
            electionZoneService.addZone(electionZoneModel);
            LOGGER.info("new Election zone added name as a "+electionZoneDAO.getName());
            return new ResponseEntity<>(new ApiResponse<>(electionZoneModel) , HttpStatus.OK);

        }else{
//            if already registered district name just save ony Zone
            DistrictModel model = districtRepository.findFirstByName(electionZoneDAO.getDistrictName());
            ElectionZoneModel electionZoneModel = new ElectionZoneModel();
            electionZoneModel.setName(electionZoneDAO.getName());
            electionZoneModel.setDistrictModel(model);
            LOGGER.info("new Election zone added name as a "+electionZoneDAO.getName());
            return new ResponseEntity<>(new ApiResponse<>(electionZoneService.addZone(electionZoneModel)) ,HttpStatus.OK);

        }


    }
}
