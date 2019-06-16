package com.kelani.demo.Controllers;

import com.kelani.demo.Models.UserModel;
import com.kelani.demo.Payload.ApiResponse;
import com.kelani.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> userModelGetAll(){
        return new ResponseEntity<>(new ApiResponse<>( userService.findAll()) , HttpStatus.OK);
    }

    @PostMapping("/")
    private ResponseEntity<?> save(@RequestPart String provinceName ,
                                   @RequestBody UserModel userModel) throws Exception{

        return new ResponseEntity<>(new ApiResponse<>(userService.save(userModel)), HttpStatus.OK);
    }


}
