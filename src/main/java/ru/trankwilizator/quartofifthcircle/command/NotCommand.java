package ru.trankwilizator.quartofifthcircle.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.function.BiConsumer;

@Component
public class NotCommand implements BiConsumer<AbsSender, Message> {

    @Override
    public void accept(AbsSender sender, Message message) {

        SendMessage sendMessage = new SendMessage();
        String answer = "Unknown command: " + message.getText();
        sendMessage.setChatId(message.getChat().getId().toString());
        sendMessage.setText(answer);

        try {
            sender.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
