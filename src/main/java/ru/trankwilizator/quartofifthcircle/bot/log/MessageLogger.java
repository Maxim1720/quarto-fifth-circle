package ru.trankwilizator.quartofifthcircle.bot.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.logging.Logger;

@Component
public class MessageLogger {
    private final Logger logger;

    public MessageLogger(Logger fileLogger) {
        this.logger = fileLogger;
    }

    public void logMessageReceived(User user, Message message) {
        String from = "message received from:\n";
        String userInfo = user.getFirstName() + " " + user.getLastName() + "\n" + user.getUserName();
        logger.info(from + userInfo + "\nid: " + user.getId());
        logger.info("received: " + message.getText());
    }

    public void logMessageSent(SendMessage sendMessage) {
        logger.info("sent message: " + sendMessage.getText().replace('\n', ' '));
    }

    public void logError(Class clazz, TelegramApiException e) {
        logger.throwing(clazz.getName(), e.getMessage(), e);
    }
}

