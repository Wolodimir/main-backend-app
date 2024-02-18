package com.core.mvp.kafka;

import com.core.mvp.kafka.payload.CharacterState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    static final Logger log = LoggerFactory.getLogger(KafkaConsumer.class);

    //@KafkaListener(topics = "game-events", groupId = "game-group")
    public void consumeMessage(String msg) {
        log.info("Consume a message from PLAYER-EVENTS: " + msg);
    }

    @KafkaListener(topics = "character-event", groupId = "game-group")
    public void consumeCharacterState(CharacterState cs) {
        log.info("Consume a message from PLAYER-EVENTS: \n" + cs.toString());
    }
}
