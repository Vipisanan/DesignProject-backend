package com.kelani.demo.Controllers;

import com.kelani.demo.DAO.UserAllDetailsDAO;
import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Models.UserTypeModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Repository.GSDivisionRepository;
import com.kelani.demo.Repository.UserTypeRepository;
import com.kelani.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private GSDivisionRepository gsDivisionRepository;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("/")
    public ResponseEntity<?> userModelGetAll() {
        return new ResponseEntity<>(new ApiResponse<>(userService.findAll()), HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<?> save(@RequestBody UserModel userModel) throws Exception {
//        when save user(voter) add default role as a Voter

        return new ResponseEntity<>(new ApiResponse<>(userService.save(userModel)), HttpStatus.OK);
    }

    @PostMapping("voter-register")
    public ResponseEntity<?> registerVoter(@RequestBody UserAllDetailsDAO dao){
        UserModel userModel=new UserModel();

        userModel.setFirstName(dao.getFirstName());
        userModel.setLastName(dao.getLastName());
        userModel.setSpecificDetails(dao.getSpecificDetails());
        userModel.setNicNo(dao.getNicNo());
        userModel.setImageUrl(dao.getImageUrl());
        userModel.setGsDivisionModel(gsDivisionRepository.findFirstById(dao.getGsDivisionId()));
        Set<UserTypeModel> userTypeModels = userModel.getUserTypeModels();
        userTypeModels.add(userTypeRepository.findFirstById(dao.getUserType()));
        userService.save(userModel);
        return new ResponseEntity<>(new ApiResponse<>(userModel) , HttpStatus.OK);

    }

    @GetMapping("all-users")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(new ApiResponse<>(userService.findAllUser()) , HttpStatus.OK);
    }


}
