package ru.trankwilizator.quartofifthcircle.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.objects.Message;

@SpringBootTest
class MessageHandlerTest {

    @Autowired
    BotMessageHandler botMessageHandler;

    @Test
    public void testAm(){

        Message message = new Message();
        message.setText("Am");
        Assertions.assertDoesNotThrow(()-> botMessageHandler.sendMessageAnswer(message));
        Assertions.assertEquals(botMessageHandler.sendMessageAnswer(message).getText().split("\n").length, 5);
    }
}