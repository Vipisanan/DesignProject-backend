package com.kelani.demo.Controllers;

import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.NominatedPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nomi-party")
@CrossOrigin(origins = "*")
public class NominatedPartyController  {

    @Autowired
    private NominatedPartyService nominatedPartyService;



    @GetMapping
    public ResponseEntity<?> getAllNominatedPArtyList() throws  Exception{
        return new ResponseEntity<>(new ApiResponse<>(nominatedPartyService.getAllNominatedPArtyList()) , HttpStatus.OK);
    }
}
