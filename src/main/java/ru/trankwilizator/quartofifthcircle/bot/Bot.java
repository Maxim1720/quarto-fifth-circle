package ru.trankwilizator.quartofifthcircle.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.bot.log.MessagesLogger;
import ru.trankwilizator.quartofifthcircle.bot.command.simple.NotCommand;

@Component
public class Bot extends TelegramLongPollingCommandBot {

    @Autowired
    public Bot(IBotCommand[] commands){
               @Value("${bot.token}") String token,
               @Value("${bot.username}") String username){
        registerAll(commands);
        registerDefaultAction(new NotCommand());

        this.token = token;
        this.username = username;
        this.messageLogger = messageLogger;
    }


    @Override
    public String getBotToken() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.token");
    }

    @Override
    public String getBotUsername() {
        return MessageSourceResourceBundle
                .getBundle("messages")
                .getString("bot.username");
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
