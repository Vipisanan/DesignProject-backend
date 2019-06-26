package com.kelani.demo.exceptions;

import com.kelani.demo.Payload.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.ws.rs.Produces;

@ControllerAdvice
@Produces("Application/json")
public class ExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);


    @ResponseBody
    @ExceptionHandler(value = AGException.class)
    public ApiResponse<String> customExceptionHandler(AGException ex) {
        LOGGER.error("In Exception handler");
        ApiResponse<String> response = new ApiResponse(ex.getStatus());
//        response.setContent("ERROR");
        response.setStatusCode(ex.getStatus().getStatusCode());
        response.setStatusDescription(ex.getStatus().getStatusDescription());
        return response;
    }

//    @ResponseBody
//    @ExceptionHandler(value = Exception.class)
//    public AGResponse ExceptionHandler(Exception ex){
//        System.out.println("In Exception handler");
//        AGResponse response=new AGResponse(AGStatus.ERROR);
//        return response;
//    }

}
