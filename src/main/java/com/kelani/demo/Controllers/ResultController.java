package com.kelani.demo.Controllers;


import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.ResultService;
import com.kelani.demo.exceptions.AGException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("result")
@CrossOrigin(origins = "*")
public class ResultController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private ResultService resultService;

    @GetMapping
    private ResponseEntity<?> getAllResult() {
        return new ResponseEntity<>(new ApiResponse<>(resultService.getAllResult()), HttpStatus.OK);
    }
    @GetMapping("/all")
    private ResponseEntity<?> getFullResult() {
        return new ResponseEntity<>(new ApiResponse<>(resultService.getFullResult()), HttpStatus.OK);
    }



    @GetMapping("/voter/{vId}")
    private ResponseEntity<?> addVote(@PathVariable(name = "vId") String vId  ,
                                      @RequestParam("cId") int[] candidateId ,
                                      @RequestParam("pId") String[] nomiPartyId) throws AGException {

        LOGGER.info(vId);
            return new ResponseEntity<>(new ApiResponse<>(resultService.addVote(candidateId , nomiPartyId , vId)) , HttpStatus.OK);
    }


}
