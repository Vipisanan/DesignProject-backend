package com.kelani.demo.Controllers;

import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Repository.UserTypeRepository;
import com.kelani.demo.Services.UserTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user-type")
public class UserTypeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTypeController.class);


    @Autowired
    private UserTypeService userTypeService;

    @Autowired
    private UserTypeRepository userTypeRepository;

    @GetMapping("")
    public ResponseEntity<?> saveAll() {
        LOGGER.info("Call getAll method in UserTypeController");
        return new ResponseEntity<>(new ApiResponse<>(userTypeRepository.findAll()), HttpStatus.OK);

    }

}