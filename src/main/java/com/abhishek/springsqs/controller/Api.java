package com.abhishek.springsqs.controller;

import com.abhishek.springsqs.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "postMessage")
public class Api {
    private final Service service;

    public Api(Service service) {
        this.service = service;
    }

    @PostMapping
    private ResponseEntity<Void> publishMessageToQueue(@RequestBody String message) {
        service.sendMessage(message);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
