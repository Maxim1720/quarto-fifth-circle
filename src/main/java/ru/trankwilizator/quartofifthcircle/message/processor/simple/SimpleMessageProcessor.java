package ru.trankwilizator.quartofifthcircle.message.processor.simple;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.message.processor.MessageProcessor;


public class SimpleMessageProcessor implements MessageProcessor {

    private final String answer;

    public SimpleMessageProcessor(String answer){
        this.answer = answer;
    }

    @Override
    public void processMessage(AbsSender sender, Message message, String[] strings) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChat().getId().toString());
        sendMessage.setText(answer);
        try {
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
