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


    //first nominate party then we can nominate candidate
// Column 'nominated_party_id' cannot be null
    @PostMapping("nomination/{id}")
    public ResponseEntity<?> candidateNomination(@PathVariable(name = "id") int i) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(candidateService.candidateNomination(i)), HttpStatus.OK);
    }

}
