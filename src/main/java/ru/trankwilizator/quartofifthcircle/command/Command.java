package ru.trankwilizator.quartofifthcircle.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.bots.AbsSender;
import ru.trankwilizator.quartofifthcircle.message.MessageProcessor;

public abstract class Command implements IBotCommand {
    private final MessageProcessor messageProcessor;
    protected Command(MessageProcessor messageProcessor) {
        this.messageProcessor = messageProcessor;
    }
    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        messageProcessor.processMessage(absSender,message,strings);
    }
}
