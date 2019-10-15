package com.kelani.demo.Controllers;

import com.kelani.demo.DAO.UserAllDetailsDAO;
import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Models.UserTypeModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Repository.GSDivisionRepository;
import com.kelani.demo.Repository.UserTypeRepository;
import com.kelani.demo.Services.AmazonClient;
import com.kelani.demo.Services.ServiceUser;
import com.kelani.demo.exceptions.AGException;
import com.kelani.demo.exceptions.AGStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private AmazonClient amazonClient;

    public UserController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @Autowired
    private ServiceUser userService;
    @Autowired
    private GSDivisionRepository gsDivisionRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("")
    public ResponseEntity<?> userModelGetAll() {
        return new ResponseEntity<>(new ApiResponse<>(userService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<?> save(@RequestBody UserModel userModel) throws Exception {
//        when save user(voter) add default role as a Voter
        return new ResponseEntity<>(new ApiResponse<>(userService.save(userModel)), HttpStatus.OK);
    }


    @PostMapping("voter-register")
    public ResponseEntity<?> registerVoter(@RequestBody UserAllDetailsDAO dao) {
        UserModel userModel = new UserModel();

        userModel.setFirstName(dao.getFirstName());
        userModel.setLastName(dao.getLastName());
        userModel.setSpecificDetails(dao.getSpecificDetails());
        userModel.setNicNo(dao.getNicNo());
        userModel.setImageUrl(dao.getImageUrl());
        userModel.setGsDivisionModel(gsDivisionRepository.findFirstById(dao.getGsDivisionId()));

        Set<UserTypeModel> userTypeModels = userModel.getUserTypeModels();
        userTypeModels.add(userTypeRepository.findFirstById(dao.getUserType()));

        userService.save(userModel);
        return new ResponseEntity<>(new ApiResponse<>(userModel), HttpStatus.OK);

    }

    @PostMapping("voter-register-img")
    public ResponseEntity<?> registerWidImgVoter(@RequestParam(value = "firstName") String firstName,
                                                 @RequestParam(value = "lastName") String lastName,
                                                 @RequestParam(value = "nicNo") int nicNo,
                                                 @RequestParam(value = "specificDetails") String specificDetails,
                                                 @RequestParam(value = "gsDivisionId") int gsDivisionId,

                                                 @RequestPart(value = "image") MultipartFile multipartFile) throws AGException {


        UserModel userModel = new UserModel();
        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setNicNo(nicNo);
        userModel.setSpecificDetails(specificDetails);
        userModel.setGsDivisionModel(gsDivisionRepository.findFirstById(gsDivisionId));

        Set<UserTypeModel> userTypeModels = userModel.getUserTypeModels();
        userTypeModels.add(userTypeRepository.findFirstById(1));


        String imageUrl;
        if (multipartFile == null) {
            LOGGER.error(AGStatus.EMPTY_FILE.getStatusDescription());
            throw new AGException(AGStatus.EMPTY_FILE);
        }
        try {
            imageUrl = this.amazonClient.uploadFile(multipartFile);
        } catch (Exception e) {
            LOGGER.warn(AGStatus.AWS_ERROR.getStatusDescription());
            throw new AGException(AGStatus.AWS_ERROR);
        }

        userModel.setImageUrl(imageUrl);
        userService.save(userModel);
        return new ResponseEntity<>(new ApiResponse<>(userModel), HttpStatus.OK);

    }

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUser() {
        return new ResponseEntity<>(new ApiResponse<>(userService.findAllUser()), HttpStatus.OK);
    }

    //    get user by id
    @GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(userService.getUserById(id)), HttpStatus.OK);
    }

    @PostMapping("add-finger-print/{id}/{fingerPrint}")
    public ResponseEntity<?> addFingerPrint(@PathVariable("id") int id,
                                            @PathVariable("fingerPrint") String fingerPrint) throws Exception {
        return new ResponseEntity<>(new ApiResponse<>(userService.addFingerPrint(id, fingerPrint)), HttpStatus.OK);
    }


}
