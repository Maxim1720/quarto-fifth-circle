package ru.trankwilizator.quartofifthcircle.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.bot.message.BotMessageHandlerImpl;
import ru.trankwilizator.quartofifthcircle.bot.message.BotMessagesHandler;
import ru.trankwilizator.quartofifthcircle.command.message.CommandMessageHandlerMediator;
import ru.trankwilizator.quartofifthcircle.command.message.quartofifthcircle.QuartoFifthCircleMessageHandler;
import ru.trankwilizator.quartofifthcircle.command.message.scale.ScaleMessageHandler;
import ru.trankwilizator.quartofifthcircle.exception.MessageHandlerException;


class MessageHandlerTest {
    BotMessagesHandler botMessageHandler = Mockito.mock(BotMessageHandlerImpl.class);

    @BeforeEach
    public void init(){
        CommandMessageHandlerMediator.setMessageHandler(new ScaleMessageHandler());
    }

    @Test
    public void testAm(){
        System.out.println(botMessageHandler);
        testMessageHandling("Am");
    }

    @Test
    public void testCm(){
        testMessageHandling("Cm");
    }

    @Test
    public void testCdm(){
        testMessageHandling("C#m");
    }

    private void testMessageHandling(String text){
        Assertions.assertDoesNotThrow(()->getAnswer(text));
        Assertions.assertEquals(getAnswer(text).getText().split("\n").length, 5);
    }

    private SendMessage getAnswer(String text){
        Message message = new Message();
        message.setText(text);
        return botMessageHandler.getAnswer(message);
    }
}