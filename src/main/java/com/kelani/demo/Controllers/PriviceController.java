package com.kelani.demo.Controllers;

import com.kelani.demo.Models.ProvinceModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.ProvinceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("province")
public class PriviceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProvinceModel.class);


    @Autowired
    private ProvinceService provinceService;


    @GetMapping("")
    private ResponseEntity<?> getAllProvince(){
        return new ResponseEntity<>(new ApiResponse<>(provinceService.geAll()) , HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveAll(@RequestBody List<ProvinceModel> provinceModelList){
        provinceService.saveAll(provinceModelList);
        LOGGER.info("saved all province data by list");
        return new ResponseEntity<>(new ApiResponse<>(provinceModelList) , HttpStatus.OK);
    }
}
