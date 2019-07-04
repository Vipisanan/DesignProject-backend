package com.kelani.demo.Controllers;

import com.kelani.demo.DAO.GSDivisionDAO;
import com.kelani.demo.Models.GSDivisionModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.GSDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("gs-division")
@CrossOrigin(origins = "*")
public class GSDivisionController {

    @Autowired
    private GSDivisionService gsDivisionService;

    @PostMapping("/")
    public ResponseEntity<?> saveAll(@RequestBody GSDivisionDAO gsDivisionDAO){

        GSDivisionModel gsDivisionModel = new GSDivisionModel();
        gsDivisionService.save(gsDivisionModel);
        return new ResponseEntity<>(new ApiResponse<>(gsDivisionModel) , HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>(new ApiResponse<>(gsDivisionService.getAll()),HttpStatus.OK);
    }
}
