package com.bofa.pmtodskafkalib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaSendService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * The topic we will send on is defined
     * in the application.yaml file as
     * <i>kafka.topic.name</i>
     */
  //  @Value("${kafka.topic.name}")
  //  private String topicName;
    
   

    public KafkaSendService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public ListenableFuture<SendResult<String, String>> sendMessage(String topicName,String message) {
        return kafkaTemplate.send(topicName, message);
    }
}
