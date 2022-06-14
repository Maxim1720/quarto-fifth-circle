package ru.trankwilizator.quartofifthcircle.bot.message;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.trankwilizator.quartofifthcircle.exception.MessageHandlerException;

public interface BotMessagesHandler {
    SendMessage getAnswer(Message message) throws MessageHandlerException;
}
