package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class KafkaSender {

    String kafkaTopic = "java_in_use_topic";
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message1) throws JsonProcessingException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        DBOperation dbOperation = new DBOperation(Operation.ADD, "send Book", LocalDateTime.now().format(formatter));
        Gson gson = new Gson();
        String message = gson.toJson(dbOperation);

        kafkaTemplate.send(kafkaTopic, message);
    }
}
