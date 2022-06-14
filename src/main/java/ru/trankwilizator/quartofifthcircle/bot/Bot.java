package ru.trankwilizator.quartofifthcircle.bot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.logic.exception.ChordException;
import ru.trankwilizator.quartofifthcircle.service.BotMessageHandler;
import ru.trankwilizator.quartofifthcircle.service.QuartoFifthCircleCommand;

@Component
public class Bot extends TelegramLongPollingCommandBot {

    private final QuartoFifthCircleCommand quartoFifthCircleCommand;
    private final BotMessageHandler botMessageHandler;

    @Value("${telegram.bot.username}")
    private String BOT_NAME;

    @Value("${telegram.bot.token}")
    private String BOT_TOKEN;
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }


    @Autowired
    public Bot(QuartoFifthCircleCommand quartoFifthCircleCommand, BotMessageHandler botMessageHandler){
        this.quartoFifthCircleCommand = quartoFifthCircleCommand;
        this.botMessageHandler = botMessageHandler;
    }




    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = botMessageHandler.sendMessageAnswer(update.getMessage());
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        tryExecute(sendMessage);
    }



    private void tryExecute(SendMessage sendMessage){
        try {
            execute(sendMessage);
            LoggerFactory.getLogger(Logger.class).info("sent message: " + sendMessage.getText());
        } catch (TelegramApiException e) {
            LoggerFactory.getLogger(Logger.class).error(e.getMessage(), e);
        }

    }



}
