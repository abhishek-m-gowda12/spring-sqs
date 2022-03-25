package com.abhishek.springsqs.sqs;

import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class Sqs {

    private final QueueMessagingTemplate queueMessagingTemplate;

    public Sqs(QueueMessagingTemplate queueMessagingTemplate) {
        this.queueMessagingTemplate = queueMessagingTemplate;
    }


    public void postMessageToQueue(String queuePayload) {
        queueMessagingTemplate.convertAndSend("queue-name", queuePayload);
    }
    @SqsListener("queue-name")
    public void queueListener(String queuePayload) {
        System.out.println(queuePayload);
    }
}