package com.kelani.demo.Controllers;

import com.kelani.demo.DAO.CandidateModelDAO;
import com.kelani.demo.Models.CandidateModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("candidate")
@CrossOrigin(origins = "*")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @GetMapping
    public ResponseEntity<?> getAllCandidate() {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.getAllCandidate()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCandidate(@RequestBody CandidateModelDAO dao) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.saveCandidate(dao)), HttpStatus.OK);
    }


    //first nominate party then we can nominate candidate =>done
// Column 'nominated_party_id' cannot be null
//using nominatedPartyId ="N-PARTY-101"(String) and candidateID =1(int)
    @PostMapping("nomination/{cId}/{npId}")
    public ResponseEntity<?> candidateNomination(@PathVariable(name = "cId") int i,
                                                 @PathVariable(name = "npId") String s) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.candidateNomination(i, s)), HttpStatus.OK);
    }

//    i want to nominate candidate using candidateId , partyId no nominatedPartyId
    @GetMapping("nomination/{cid}/{pid}")
    public ResponseEntity<?> candidateNominationByPartyId(@PathVariable(name = "cid") int i,
                                                 @PathVariable(name = "pid") String s) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.candidateNominationByPartyId(i, s)), HttpStatus.OK);
    }

}
