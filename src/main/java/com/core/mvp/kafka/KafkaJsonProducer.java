package com.core.mvp.kafka;

import com.core.mvp.kafka.payload.CharacterState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {

    static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, CharacterState> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, CharacterState> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendCharacterState(CharacterState state) {
        log.info("Sending character state for UI");

        Message<CharacterState> message = MessageBuilder
                .withPayload(state)
                .setHeader(KafkaHeaders.TOPIC, "character-event")
                .build();

        kafkaTemplate.send(message);
    }

}
