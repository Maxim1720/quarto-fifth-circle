package ru.trankwilizator.quartofifthcircle.bot.command.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.trankwilizator.quartofifthcircle.bot.log.MessageLogger;

import java.util.function.BiConsumer;

@Component
public class NotBotCommand implements BiConsumer<AbsSender, Message> {

    private final MessageLogger logger;

    @Autowired
    public NotBotCommand(MessageLogger logger) {
        this.logger = logger;
    }

    @Override
    public void accept(AbsSender sender, Message message) {

        SendMessage sendMessage = new SendMessage();
        String answer = "Unknown command: " + message.getText();
        sendMessage.setChatId(message.getChat().getId().toString());
        sendMessage.setText(answer);

        try {
            logger.logMessageReceived(sender.getMe(),message);
            sender.execute(sendMessage);
            logger.logMessageSent(sendMessage);
        } catch (TelegramApiException e) {
            logger.logError(this.getClass(),e);
            throw new RuntimeException(e);
        }
    }
}
