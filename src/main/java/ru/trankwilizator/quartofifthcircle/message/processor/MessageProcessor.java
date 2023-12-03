package ru.trankwilizator.quartofifthcircle.message.processor;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;

public interface MessageProcessor {
    void processMessage(AbsSender sender, Message message, String[] strings);
}