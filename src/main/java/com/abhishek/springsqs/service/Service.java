package com.abhishek.springsqs.service;

import com.abhishek.springsqs.sqs.Sqs;

@org.springframework.stereotype.Service
public class Service {

    private final Sqs sqs;

    public Service(Sqs sqs) {
        this.sqs = sqs;
    }

    public void sendMessage(String message) {
        sqs.postMessageToQueue(message);
    }
}
