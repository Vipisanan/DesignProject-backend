package com.kelani.demo.Controllers;

import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.VotingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("voting")
@CrossOrigin(origins = "*")
public class VotingController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(VotingController.class);

    @Autowired
    private VotingService votingService;


    @GetMapping("election")
    public ResponseEntity<?> getVotingList(){
        return new ResponseEntity<>(new ApiResponse<>(votingService.getVotingList()) , HttpStatus.OK);
    }
}
