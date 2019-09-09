package com.kelani.demo.Controllers;

import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.VoterService;
import com.kelani.demo.exceptions.AGException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("voter")
@CrossOrigin(origins = "*")
public class VoterController {
    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(VoterController.class);

    @Autowired
    private VoterService voterService;

    @GetMapping()
    public ResponseEntity<?> getAllVoter(){
        LOGGER.info("Called get all voter method in VoterController");
        return new ResponseEntity<>(new ApiResponse<>(voterService.getAllVoter()) , HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> addVoter(@PathVariable("id") int id) throws AGException {
        LOGGER.info("Called add voter method in VoterController with this userId" + id);
        return new ResponseEntity<>(new ApiResponse<>(voterService.addVoter(id)) , HttpStatus.OK);
    }
}
