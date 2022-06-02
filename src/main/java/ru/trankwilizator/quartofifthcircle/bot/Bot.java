package ru.trankwilizator.quartofifthcircle.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.trankwilizator.quartofifthcircle.service.QuartoFifthCircleCommand;

@Component
public class Bot extends TelegramLongPollingCommandBot {


    private final QuartoFifthCircleCommand quartoFifthCircleCommand;

    @Autowired
    public Bot(QuartoFifthCircleCommand quartoFifthCircleCommand){
        this.quartoFifthCircleCommand = quartoFifthCircleCommand;
    }
    @Value("${telegram.bot.username}")
    private String BOT_NAME;

    @Value("${telegram.bot.token}")
    private String BOT_TOKEN;

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        Long chatId = msg.getChatId();
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
