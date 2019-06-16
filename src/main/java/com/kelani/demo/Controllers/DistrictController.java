package com.kelani.demo.Controllers;

import com.kelani.demo.Services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

}
