package com.kelani.demo.Controllers;

import com.kelani.demo.Models.ElectionModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("election")
@CrossOrigin(origins = "*")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    @GetMapping("types")
    public ResponseEntity<?> getAllElectionTypes() throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.getAllElectionTypes()) ,HttpStatus.OK);
    }

    @PostMapping("add-election/{id}")
    public ResponseEntity<?> addElection(@PathVariable(name = "id") int id) throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.addElection(id)), HttpStatus.OK);
    }

}
