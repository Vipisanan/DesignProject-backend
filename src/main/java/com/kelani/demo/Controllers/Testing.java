package com.kelani.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testing")
public class Testing {

    @GetMapping("")
    public String te(){
        return "sdfsdf";
    }
}
