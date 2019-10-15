package com.kelani.demo.Controllers;


import com.kelani.demo.DAO.PartyDAO;
import com.kelani.demo.Models.PartyModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Repository.PartyColourRepository;
import com.kelani.demo.Services.AmazonClient;
import com.kelani.demo.Services.CandidateService;
import com.kelani.demo.Services.PartyService;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("party")
@CrossOrigin(origins = "*")
public class PartyController {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyService partyService;
    @Autowired
    private PartyColourRepository partyColourRepository;

    private AmazonClient amazonClient;
    public PartyController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @GetMapping
    public ResponseEntity<?> getAllParties() throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.getAllParties()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveParty(@RequestBody PartyDAO partyDAO) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.saveParty(partyDAO)), HttpStatus.OK);
    }

    @PostMapping("with-logo")
    public ResponseEntity<?> savePartyWidImage(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "partyColourId") int partyColourId,
                                               @RequestPart(value = "logo") MultipartFile logo) throws Exception {

        PartyModel partyModel = new PartyModel();
        partyModel.setName(name);
        partyModel.setColor(partyColourRepository.findFirstById(partyColourId));

        String imageUrl;
        if (logo == null) {
            LOGGER.error(AGStatus.EMPTY_FILE.getStatusDescription());
            throw new AGException(AGStatus.EMPTY_FILE);
        }
        try {
            imageUrl = this.amazonClient.uploadFile(logo);
        }catch (Exception e){
            LOGGER.warn(AGStatus.AWS_ERROR.getStatusDescription());
            throw new AGException(AGStatus.AWS_ERROR);
        }
        partyModel.setLogoUrl(imageUrl);

        return new ResponseEntity<>(new ApiResponse<>(partyService.savePartyWidImage(partyModel)), HttpStatus.OK);
    }

    @GetMapping("color")
    public ResponseEntity<?> getPartyColor() throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.getPartyColor()), HttpStatus.OK);
    }

//    party nomination
//    01.add election => it's api created
//    one can have many Party-nominated
    //        get election model and Party model then save

    @GetMapping("nomination/{eId}/{pId}")
    public ResponseEntity<?> partyNomination(@PathVariable(name = "eId") int i,
                                             @PathVariable(name = "pId") String s) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(partyService.partyNomination(i, s)), HttpStatus.OK);
    }

}
