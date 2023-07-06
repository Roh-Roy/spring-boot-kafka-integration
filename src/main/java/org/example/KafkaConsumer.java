package org.example;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "java_in_use_topic", group = "test_group")
    public void greetingListener(ConsumerRecord<?, ?> consumerRecord) throws IOException {

        String a = consumerRecord.value().toString();

        Gson gson = new Gson();
        DBOperation book = gson.fromJson(a, DBOperation.class);
        System.out.println(book.getOperation());
        System.out.println(book.getTimestamp());
        System.out.println(book.getTitle());


        System.out.println(consumerRecord);
        System.out.println(consumerRecord.value());
        System.out.println(a);
        // process greeting message
    }
}
