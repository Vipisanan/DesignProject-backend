package com.kelani.demo.Controllers;

import com.kelani.demo.Models.  ElectionModel;
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

//    getAll registered election
    @GetMapping
    public ResponseEntity<?> getAllElection(){
        return new ResponseEntity<>(new ApiResponse<>(electionService.getAllElection()) ,HttpStatus.OK);
    }

    @GetMapping("types")
    public ResponseEntity<?> getAllElectionTypes() throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.getAllElectionTypes()) ,HttpStatus.OK);
    }

    @GetMapping("add-election/{id}")
    public ResponseEntity<?> addElection(@PathVariable(name = "id") int id) throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.addElection(id)), HttpStatus.OK);
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteElection(@PathVariable(name = "id") int id) throws Exception{
//        return new ResponseEntity<>(new ApiResponse<>(electionService.daleteElection(id)) ,HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<?> activeElection(@PathVariable(name = "id") int id) throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.activeElection(id)) ,HttpStatus.OK);
    }

    @GetMapping("deactive/{id}")
    public ResponseEntity<?> deActiveElection(@PathVariable(name = "id") int id) throws Exception{
        return new ResponseEntity<>(new ApiResponse<>(electionService.deActiveElection(id)) ,HttpStatus.OK);
    }




}
