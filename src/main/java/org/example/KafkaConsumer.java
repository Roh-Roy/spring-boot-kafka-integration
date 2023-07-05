package org.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(
            topics = "java_in_use_topic", group = "test_group")
    public void greetingListener(ConsumerRecord<?, ?> consumerRecord) {

        System.out.println(consumerRecord.toString());
        System.out.println(consumerRecord.value());
        // process greeting message
    }
}
