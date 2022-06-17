package ru.trankwilizator.quartofifthcircle.bot.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessagesLogger {

    private static final Logger logger = LoggerFactory.getLogger(Logger.class);

    public static void logMessageRecivied(User user){
        logger.info("message received from " + user.getFirstName() + " " + user.getLastName() + ": username is '" + user.getUserName() + "'"
        + " id: " + user.getId());
    }

    public static void logMessageSent(SendMessage sendMessage){
        logger.info("sent message: " + sendMessage.getText());
    }

    public static void logError(TelegramApiException e){
        logger.error(e.getMessage(), e);
    }

}
