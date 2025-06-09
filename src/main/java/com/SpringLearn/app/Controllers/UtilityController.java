package com.SpringLearn.app.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UtilityController {
    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public String getHealthCheck(){
        return "The service is healthy and running fine.";
    }
}
