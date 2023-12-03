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
import ru.trankwilizator.quartofifthcircle.bot.log.MessageLogger;
import ru.trankwilizator.quartofifthcircle.bot.command.simple.NotBotCommand;

@Component
public class Bot extends TelegramLongPollingCommandBot {
    private final MessageLogger messageLogger;
    @Autowired
    public Bot(IBotCommand[] commands,
               MessageLogger messageLogger,
               @Value("${bot.token}") String token,
               @Value("${bot.username}") String username){
        registerAll(commands);
        registerDefaultAction(new NotBotCommand(messageLogger));

        this.token = token;
        this.username = username;
        this.messageLogger = messageLogger;
    }

    private final String token;
    private final String username;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        messageLogger.logMessageReceived(update.getMessage().getFrom(),update.getMessage());
        SendMessage sendMessage = incorrectCommandSendMessage(update.getMessage());
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        tryExecute(sendMessage);
    }


    private SendMessage incorrectCommandSendMessage(Message message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChat().getId().toString());
        sendMessage.setText(
                MessageSourceResourceBundle
                        .getBundle("messages")
                        .getString("bot.message.error")
        );
        return sendMessage;
    }

    private void tryExecute(SendMessage sendMessage){
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            messageLogger.logError(this.getClass(),e);
        }
        messageLogger.logMessageSent(sendMessage);
    }



}
