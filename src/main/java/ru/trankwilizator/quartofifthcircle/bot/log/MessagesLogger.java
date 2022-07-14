package ru.trankwilizator.quartofifthcircle.bot.log;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MessagesLogger {

    private static final Logger logger;

    static {
        logger = Logger.getLogger(System.Logger.Level.INFO.getName());
        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/logs.txt", true);
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void logMessageReceived(User user, Message message){
        String from = "message received from:\n";
        String userInfo = user.getFirstName() + " " + user.getLastName() + "\n" + user.getUserName();
        logger.info(from +  userInfo + "\nid: " + user.getId());
        logger.info("received: " + message.getText());
    }

    public static void logMessageSent(SendMessage sendMessage){
        logger.info("sent message: " + sendMessage.getText().replace('\n',' '));
    }

    public static void logError(Class clazz,TelegramApiException e){
        logger.throwing(clazz.getName(), e.getMessage(), e);
    }

}
