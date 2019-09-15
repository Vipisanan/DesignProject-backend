package com.kelani.demo.Controllers;


import com.kelani.demo.DAO.PartyDAO;
import com.kelani.demo.Models.PartyModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.CandidateService;
import com.kelani.demo.Services.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("party")
@CrossOrigin(origins = "*")
public class PartyController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyService partyService;

    @GetMapping
    public ResponseEntity<?> getAllParties() throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.getAllParties()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveParty(@RequestBody PartyDAO partyDAO) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.saveParty(partyDAO)), HttpStatus.OK);
    }

    @GetMapping("color")
    public ResponseEntity<?> getPartyColor() throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.getPartyColor()), HttpStatus.OK);
    }

//    party nomination
//    before party nomination we have to add Election
//    one can have many Party-nominated

}
