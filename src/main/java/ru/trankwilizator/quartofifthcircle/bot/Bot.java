package ru.trankwilizator.quartofifthcircle.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.bot.log.MessagesLogger;
import ru.trankwilizator.quartofifthcircle.command.NotCommand;

@Component
public class Bot extends TelegramLongPollingCommandBot {

    @Value("${bot.token}")
    private String botToken;
    @Value("${bot.username}")
    private String botName;
    @Autowired
    public Bot(IBotCommand[] commands){
        registerAll(commands);
        registerDefaultAction(new NotCommand());
    }


    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        MessagesLogger.logMessageReceived(update.getMessage().getFrom(), update.getMessage());
        SendMessage sendMessage = tryGetAnswer(update.getMessage());
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        tryExecute(sendMessage);
    }


    private SendMessage tryGetAnswer(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChat().getId().toString());
        sendMessage.setText(
                MessageSourceResourceBundle.getBundle("messages").getString("bot.message.error")
        );
        return sendMessage;
    }

    private void tryExecute(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            MessagesLogger.logError(Bot.class,e);
        }
        MessagesLogger.logMessageSent(sendMessage);
    }



}
